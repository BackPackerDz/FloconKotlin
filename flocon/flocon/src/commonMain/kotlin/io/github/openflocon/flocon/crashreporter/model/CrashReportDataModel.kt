package io.github.openflocon.flocon.crashreporter.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
internal data class CrashReportDataModel(
    val crashId: String,
    val timestamp: Long,
    val exceptionType: String,
    val exceptionMessage: String,
    val stackTrace: String,
)

internal fun CrashReportDataModel.toJson(): String = Json.encodeToString(this)

internal fun crashReportFromJson(json: String): CrashReportDataModel = Json.decodeFromString(json)
