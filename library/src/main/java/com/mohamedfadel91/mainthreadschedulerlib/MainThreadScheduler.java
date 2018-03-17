package com.mohamedfadel91.mainthreadschedulerlib;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.test.espresso.Espresso;

/**
 * Created by fadel on 17/03/18.
 */
public class MainThreadScheduler {
    @Nullable
    static Handler mainThreadHandler;

    public static void scheduleWhenIdle(@NonNull final Runnable runnable){
        Runnable _runnable = new Runnable() {
            @Override
            public void run() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Espresso.onIdle();
                        if(mainThreadHandler!=null) {
                            mainThreadHandler.post(runnable);
                        }
                    }
                }).start();
            }
        };

        /*
            check if current thread from mainThread just run the block
            otherwise it post it to the mainThread
         */
        if (Thread.currentThread() ==
                Looper.getMainLooper().getThread()) {
            _runnable.run();
        } else {
            if(mainThreadHandler!=null){
                mainThreadHandler.post(_runnable);
            }
        }
    }
}
