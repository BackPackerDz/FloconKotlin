package io.github.openflocon.flocon.core

import android.content.Context
import android.os.Build
import android.provider.Settings
import io.github.openflocon.flocon.FloconContext
import io.github.openflocon.flocon.utils.AppUtils

private fun deviceId(appContext: Context): String = Settings.Secure.getString(
    appContext.contentResolver,
    Settings.Secure.ANDROID_ID,
)

private fun deviceName(): String = "${Build.MANUFACTURER} ${Build.MODEL}"

internal actual fun getAppInfos(floconContext: FloconContext): AppInfos {
    val appContext = floconContext.context

    return AppInfos(
        deviceId = deviceId(appContext),
        deviceName = deviceName(),
        appName = AppUtils.getAppName(appContext),
        appPackageName = AppUtils.getAppPackageName(appContext),
        platform = "android",
    )
}
