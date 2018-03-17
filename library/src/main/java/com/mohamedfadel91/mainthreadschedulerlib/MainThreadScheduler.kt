package com.mohamedfadel91.mainthreadschedulerlib

import android.os.Handler
import android.os.Looper
import android.support.test.espresso.Espresso

/**
 * Created by fadel on 17/03/18.
 */
object MainThreadScheduler {
    internal var mainThreadHandler: Handler? = null

    fun scheduleWhenIdle(unit: () -> Unit) {
        val block: () -> Unit = {
            Thread(Runnable {
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

    fun scheduleWhenIdle(runnable: Runnable) {
        val block: () -> Unit = {
            Thread(Runnable {
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
