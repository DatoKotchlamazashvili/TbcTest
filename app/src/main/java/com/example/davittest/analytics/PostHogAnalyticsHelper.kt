package com.example.davittest.analytics

import android.content.Context
import android.util.Log
import com.posthog.PostHog
import com.posthog.android.PostHogAndroid
import com.posthog.android.PostHogAndroidConfig
import com.posthog.internal.PostHogLogger


class PosthogAnalyticsHelper(
    private val context: Context,
    private val posthogLogger: PostHogLogger
) : AnalyticsProvider {

    override fun initialize() {
        val config = PostHogAndroidConfig(
            apiKey = POST_HOG_API_KEY,
            host = POSTHOG_HOST,
            captureScreenViews = false,
            captureDeepLinks = false,
            captureApplicationLifecycleEvents = false
        ).apply {
            preloadFeatureFlags = false
            sendFeatureFlagEvent = false
            logger = posthogLogger
        }
        PostHogAndroid.setup(context, config)
        resetIdentifier()
    }

    @Suppress("UNCHECKED_CAST")
    override fun trackCustomEvent(event: AnalyticsEvent) {
        Log.d("event",event.toString())
        PostHog.capture(event = event.name, properties = event.parameters.filter { it.value != null } as Map<String, Any>)
    }

    override fun identify(identifier: String, userProperties: Map<String, Any>?) {
        PostHog.identify(identifier, userProperties)
    }

    override fun resetIdentifier() {
        PostHog.reset()
    }

    companion object {
        private const val POSTHOG_HOST = "https://eu.i.posthog.com"
        //Should be at build config but .....
        const val  POST_HOG_API_KEY = ""
    }
}