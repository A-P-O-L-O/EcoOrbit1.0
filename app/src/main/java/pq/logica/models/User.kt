package pq.logica.models

import android.content.Context
import android.content.SharedPreferences

class User {
    var nombres: String = ""
    var apellidos: String = ""
    var email: String = ""
    var phone: String = ""
    var password: String = ""
    var acceptTerms: Boolean = false

    companion object {
        private const val PREFS_NAME = "UserPreferences"
        private const val NOMBRES_KEY = "nombres"
        private const val APELLIDOS_KEY = "apellidos"
        private const val EMAIL_KEY = "email"
        private const val PHONE_KEY = "phone"
        private const val PASSWORD_KEY = "password"
        private const val ACCEPT_TERMS_KEY = "acceptTerms"

        fun getUser(context: Context): User {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            return User().apply {
                nombres = sharedPreferences.getString(NOMBRES_KEY, "") ?: ""
                apellidos = sharedPreferences.getString(APELLIDOS_KEY, "") ?: ""
                email = sharedPreferences.getString(EMAIL_KEY, "") ?: ""
                phone = sharedPreferences.getString(PHONE_KEY, "") ?: ""
                password = sharedPreferences.getString(PASSWORD_KEY, "") ?: ""
                acceptTerms = sharedPreferences.getBoolean(ACCEPT_TERMS_KEY, false)
            }
        }

        fun clearUser(context: Context) {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            sharedPreferences.edit().clear().apply()
        }
    }

    fun save(context: Context) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString(NOMBRES_KEY, nombres)
            putString(APELLIDOS_KEY, apellidos)
            putString(EMAIL_KEY, email)
            putString(PHONE_KEY, phone)
            putString(PASSWORD_KEY, password)
            putBoolean(ACCEPT_TERMS_KEY, acceptTerms)
            apply()
        }
    }
}
