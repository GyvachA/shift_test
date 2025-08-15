package com.gyvacha.shift_test.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import androidx.core.content.edit

class PreferenceManager @Inject constructor(@ApplicationContext context: Context) {
    private val randomUserPrefs = context.getSharedPreferences(RANDOM_USER_SHARED_PREF, Context.MODE_PRIVATE)

    var seed: String?
        get() = randomUserPrefs.getString(SEED_PREF, null)
        set(value) = randomUserPrefs.edit { putString(SEED_PREF, value) }

    fun removeSeedPref() {
        randomUserPrefs.edit { remove(SEED_PREF) }
    }

    companion object {
        private const val RANDOM_USER_SHARED_PREF = "random_user_pref"
        private const val SEED_PREF = "seed"
    }
}