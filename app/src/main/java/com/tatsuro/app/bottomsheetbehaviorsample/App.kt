package com.tatsuro.app.bottomsheetbehaviorsample

import android.app.Application
import androidx.annotation.StringRes

@Suppress("unused")
class App : Application() {

    init {
        instance = this
    }

    companion object {

        /** Appインスタンス */
        private var instance: App? = null

        /**
         * Returns a localized string from the application's package's default string table.
         * @param resId Resource id for the string
         * @return The string data associated with the resource, stripped of styled text information.
         */
        fun getString(@StringRes resId: Int) = instance!!.getString(resId)
    }
}