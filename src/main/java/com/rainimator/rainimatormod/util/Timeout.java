package com.rainimator.rainimatormod.util;

import io.netty.util.internal.UnstableApi;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import java.util.ArrayList;
import java.util.List;

public class Timeout {
    private static final List<Timeout> timeouts = new ArrayList<>();
    private final int waitTicks;
    private final int maxTimes;
    private final Runnable callback;
    public boolean shouldRemove = false;
    private int ticks = 0;
    private int currentTimes = 0;

    private Timeout(int waitTicks, int maxTimes, Runnable callback) {
        this.waitTicks = waitTicks;
        this.maxTimes = maxTimes;
        this.callback = callback;
    }

    public static void create(int waitTicks, Runnable callback) {
        create(waitTicks, 1, callback);
    }

    @UnstableApi
    public static void create(int waitTicks, int maxTimes, Runnable callback) {
        if (maxTimes <= 0) return;
        if (waitTicks <= 0) callback.run();
        else timeouts.add(new Timeout(waitTicks, maxTimes, callback));
    }

    public static void startTimeout() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            List<Timeout> removed = new ArrayList<>();
            for (Timeout timeout : timeouts) {
                timeout.tick();
                if (timeout.shouldRemove)
                    removed.add(timeout);
            }
            timeouts.removeAll(removed);
        });
    }

    public void tick() {
        this.ticks++;
        if (this.ticks >= this.waitTicks) {
            this.callback.run();
            this.currentTimes++;
            if (this.currentTimes >= this.maxTimes)
                shouldRemove = true;
        }
    }
}
