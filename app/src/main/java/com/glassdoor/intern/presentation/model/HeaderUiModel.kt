/*
 * Copyright (c) 2025, Glassdoor Inc.
 *
 * Licensed under the Glassdoor Inc Hiring Assessment License.
 * You may not use this file except in compliance with the License.
 * You must obtain explicit permission from Glassdoor Inc before sharing or distributing this file.
 * Mention Glassdoor Inc as the source if you use this code in any way.
 */

package com.glassdoor.intern.presentation.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

/**
 * DONE: Define the structure of the UI model based on the domain model
 */
@Immutable
@Parcelize
internal class HeaderUiModel(
    val items: List<ItemUiModel> = emptyList(),
    val title: String = "",
    val description: String = "",
    val timestamp: String = "",
    val id: Long = 0L,
) : Parcelable {

    @IgnoredOnParcel
    val isEmpty: Boolean = items.isEmpty() //DONE("Define empty state")
}
