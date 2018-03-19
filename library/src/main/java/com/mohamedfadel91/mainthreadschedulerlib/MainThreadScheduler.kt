package com.mohamedfadel91.mainthreadschedulerlib

import android.os.Handler
import android.os.Looper
import android.support.test.espresso.Espresso

/**
 * Created by fadel on 17/03/18.
 * This Class responsible for schedule functions or runnable
 * objects to run as soon as MainThread become idle..
 */
object MainThreadScheduler {
    internal var mainThreadHandler: Handler? = null

    /**
     * it post [unit] to run as soon as MainThread become Idle..
     */
    fun scheduleWhenIdle(unit: () -> Unit) {
        val block: () -> Unit = {
            Thread({
                Espresso.onIdle()
                mainThreadHandler?.post(unit)
            }).start()
        }

        /*
            check if current thread from mainThread just run the block
            otherwise it post it to the mainThread
         */
        if (Thread.currentThread() === Looper.getMainLooper().thread) {
            kotlin.run(block)
        } else {
            mainThreadHandler?.post(block)
        }
    }

    /**
     * it post [runnable] to run as soon as MainThread become Idle..
     */
    fun scheduleWhenIdle(runnable: Runnable) {
        val block: () -> Unit = {
            Thread({
                Espresso.onIdle()
                mainThreadHandler?.post(runnable)
            }).start()
        }

        /*
            check if current thread from mainThread just run the block
            otherwise it post it to the mainThread
         */
        if (Thread.currentThread() === Looper.getMainLooper().thread) {
            kotlin.run(block)
        } else {
            mainThreadHandler?.post(block)
        }
    }
}
