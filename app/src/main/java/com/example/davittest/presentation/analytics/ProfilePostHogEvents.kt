package com.example.davittest.presentation.analytics

import com.example.davittest.analytics.AnalyticsEvent


object ProfilePostHogEvents {

    private val PROFILE_CALENDAR_CLICKED = "profile_calendar_clicked"


    val profileCalendarClicked = AnalyticsEvent(PROFILE_CALENDAR_CLICKED)

}