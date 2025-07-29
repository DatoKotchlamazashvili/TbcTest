package com.example.davittest.analytics

interface AnalyticsProvider {
    fun isEnabled(): Boolean = true
    fun setEnabled(enabled: Boolean) = Unit
    fun initialize() = Unit
    fun trackCustomEvent(event: AnalyticsEvent)
    fun identify(identifier: String, userProperties: Map<String, Any>? = null) = Unit
    fun resetIdentifier() = Unit
}