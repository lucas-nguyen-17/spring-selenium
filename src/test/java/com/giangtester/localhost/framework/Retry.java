package com.giangtester.localhost.framework;

import java.util.concurrent.TimeUnit;

public class Retry {
    private final long interval;
    private final TimeUnit unit;
    private final long count;

    public Retry(int count, int interval, TimeUnit unit) {
        this.count = count;
        this.interval = interval;
        this.unit = unit;
    }

    public void attempt(Attemptable attemptable) {
        for (int i = 0; i < count; i++) {
            try {
                attemptable.attempt();
                return;
            } catch (Exception e) {
                if (i == count - 1) {
                    throw new IllegalStateException(
                            String.format("try %d times but cannot do it, because of %s", count, e));
                }
            }
            try {
                unit.sleep(interval);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
