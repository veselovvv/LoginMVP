package com.veselovvv.loginmvp

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors

interface ThreadUtil {
    fun finalize()

    class Base : ThreadUtil {
        interface Threads {
            fun startThread(runnable: Runnable)
            fun startUIThread(delayMillis: Int, runnable: Runnable)
        }

        companion object : Threads {
            private val executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
            )
            private val handler = Handler(Looper.getMainLooper())

            override fun startThread(runnable: Runnable) {
                executorService.submit(runnable)
            }

            override fun startUIThread(delayMillis: Int, runnable: Runnable) {
                handler.postDelayed(runnable, delayMillis.toLong())
            }
        }

        override fun finalize() {
            if (!executorService.isShutdown) executorService.shutdown()
        }
    }
}