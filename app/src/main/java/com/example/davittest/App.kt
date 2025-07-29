package com.example.davittest

import android.app.Application
import android.util.Log
import com.example.davittest.analytics.AnalyticsEvent
import com.example.davittest.analytics.AnalyticsProvider
import com.example.davittest.analytics.PosthogAnalyticsHelper
import com.posthog.internal.PostHogLogger

class PosthogLoggerImplTest : PostHogLogger {
    override fun isEnabled(): Boolean {
       return true
    }

    override fun log(message: String) {
        Log.d("message",message)
    }

}


class App : Application() {
    lateinit var analyticsProvider: AnalyticsProvider
        private set

    override fun onCreate() {
        super.onCreate()

        val logger = PosthogLoggerImplTest()
        analyticsProvider = PosthogAnalyticsHelper(this, logger).apply {
            initialize()
        }
        analyticsProvider.trackCustomEvent(AnalyticsEvent("test_event", ))

    }
}