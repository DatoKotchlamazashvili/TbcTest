package com.example.davittest.analytics

data class AnalyticsEvent(
    var name: String,
    val parameters: MutableMap<String, Any?> = mutableMapOf(),
    val type: AnalyticsEventType = AnalyticsEventType.ACTION
)

enum class AnalyticsEventType {
    PAGE_VIEW, ACTION
}