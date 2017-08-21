package br.com.cng.dextrasistemasprova

import br.com.livetouch.base.BaseApplication

/**
 * Created by nicolaugalves on 19/08/17.
 */


open class DexApplication : BaseApplication() {
    override fun getBuildFlavor(): String {
        return BuildConfig.FLAVOR
    }

    override fun getBuildType(): String {
        return BuildConfig.BUILD_TYPE
    }

    override fun getCrashlyticsKey(): String {
        return "76532d0cf05c8f50073e3ec921cd740595a2b1d5"
    }

    override fun getGoogleAnalyticsTrackingId(): String {
        return "hashGoogleAnalytics"
    }

    override fun getLogoAlert(): Int {
        return 0
    }

    override fun getProgressId(): Int {
        return 0
    }

    override fun getTag(): String {
        return "DEXTRAIN"
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance : DexApplication? = null

        fun getInstance() : DexApplication {
            if (appInstance == null) {
                appInstance = DexApplication()
            }

            return appInstance!!
        }
    }
}