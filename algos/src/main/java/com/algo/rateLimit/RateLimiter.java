package com.algo.rateLimit;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

/**
 * This is inspired by the Google Guava RateLimiter library.
 * However, this is a simple implementation. It takes into consideration
 * the unused state of the rate limiter - the rate limiter adapts when it is unused.
 * It keeps track of the next expected permit to arrive as opposed to keeping track of
 * the last permit that arrived.
 * @author preetam
 */

public abstract class RateLimiter{

    private final long startTime;

    private final SimpleTicker ticker;

    protected double extraPermits;

    protected double maxExtraPermits;

    protected double intervalMicroSeconds;

    private long nextFreePermitMicros;


    public static RateLimiter valueOf(double rate) {
        return valueOf(SimpleTicker.DEFAULT_TICKER, rate);
    }

    static RateLimiter valueOf(SimpleTicker ticker, double rate) {
        RateLimiter rateLimiter = new SimpleRateLimiter(ticker);
        rateLimiter.set(rate);
        return rateLimiter;
    }

    private RateLimiter(SimpleTicker ticker){
        this.ticker = ticker;
        this.startTime = ticker.read();
    }

    private void set(double rate){
        Preconditions.checkArgument(rate > 0, "Invalid rate specified");
        checkIfCurrent(TimeUnit.NANOSECONDS.toMicros(ticker.read() - startTime));
        double intervalMicroSeconds =TimeUnit.SECONDS.toMicros(1)/rate;
        this.intervalMicroSeconds = intervalMicroSeconds;
        setRate(rate, intervalMicroSeconds);
    }

    protected abstract void setRate(double rate, double intervalMicroSeconds);

    private void checkIfCurrent(long currentTime) {
        //Check if the predicted next free permit occurs in the past
        if(currentTime > nextFreePermitMicros){
            //Yes, then adjust it
            extraPermits = Math.min(extraPermits + (currentTime - nextFreePermitMicros)/intervalMicroSeconds, maxExtraPermits);
            nextFreePermitMicros = currentTime;
        }
    }

    public void acquire(int permits){
        Preconditions.checkArgument(permits > 0);
        long waitTime;
        synchronized (this){
            waitTime = getNextPermit(permits, TimeUnit.NANOSECONDS.toMicros(ticker.read() - startTime));
        }
        ticker.sleepMicrosUninterruptibly(waitTime);
    }

    private long getNextPermit(int requiredPermits, long currentTime) {
        checkIfCurrent(currentTime);
        long timeToNextFreePermit = nextFreePermitMicros - currentTime;
        double extraPermitsToSpend = Math.min(requiredPermits, this.extraPermits);
        double freshPermits = requiredPermits - extraPermitsToSpend;
        long waitTime = (long)(freshPermits * intervalMicroSeconds);
        nextFreePermitMicros = nextFreePermitMicros + waitTime;
        this.extraPermits -= extraPermitsToSpend;
        return timeToNextFreePermit;
    }


    @VisibleForTesting
    static abstract class SimpleTicker extends Ticker {
        abstract void sleepMicrosUninterruptibly(long micros);

        static final SimpleTicker DEFAULT_TICKER = new SimpleTicker() {
            @Override
            public long read() {
                return systemTicker().read();
            }

            @Override
            public void sleepMicrosUninterruptibly(long micros) {
                if (micros > 0) {
                    Uninterruptibles.sleepUninterruptibly(micros, TimeUnit.MICROSECONDS);
                }
            }
        };
    }

    private static class SimpleRateLimiter extends RateLimiter {


        private SimpleRateLimiter(SimpleTicker ticker) {
            super(ticker);
        }

        @Override
        protected void setRate(double rate, double intervalMicroSeconds) {
            double oldMaxExtra = maxExtraPermits;
            maxExtraPermits = rate;
            extraPermits = (oldMaxExtra == 0.0) ? 0.0 : (extraPermits * maxExtraPermits)/oldMaxExtra;
        }
    }
}
