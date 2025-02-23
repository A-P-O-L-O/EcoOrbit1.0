package pq.logica

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity

class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LoginActivity", "LoginActivity iniciada correctamente")

        setContentView(R.layout.login_activity)
    }
}