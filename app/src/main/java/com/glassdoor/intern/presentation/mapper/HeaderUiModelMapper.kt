/*
 * Copyright (c) 2025, Glassdoor Inc.
 *
 * Licensed under the Glassdoor Inc Hiring Assessment License.
 * You may not use this file except in compliance with the License.
 * You must obtain explicit permission from Glassdoor Inc before sharing or distributing this file.
 * Mention Glassdoor Inc as the source if you use this code in any way.
 */

package com.glassdoor.intern.presentation.mapper

import com.glassdoor.intern.domain.model.HeaderInfo
import com.glassdoor.intern.presentation.model.HeaderUiModel
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import javax.inject.Inject

internal class HeaderUiModelMapper @Inject constructor() {
    private val dateFormatter: DateTimeFormatter = DateTimeFormatter
        .ofPattern(TIME_FORMAT_PATTERN)
        .withZone(ZoneId.systemDefault()) // DONE("Define date formatting pattern")

    private fun isoToEpochSeconds(isoDateTime: String): Long {
        val instant = Instant.parse(isoDateTime)
        return instant.epochSecond
    }

    fun toUiModel(headerInfo: HeaderInfo): HeaderUiModel = with(headerInfo) {
        HeaderUiModel(
            title = title,
            id = id,
            description = description,
            timestamp = Instant.ofEpochSecond(isoToEpochSeconds(timestamp)).let(dateFormatter::format),
            items = items.map { ItemUiModelMapper().toUiModel(it) }
        ) // DONE("Convert domain model to UI model")
    }
}
