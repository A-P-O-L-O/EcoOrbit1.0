package pq.logica

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val splastTime:Long = 1500


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        Log.d("SplasActivity","Iniciando splash")

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, splastTime)
    }

    override fun onStart() {
        super.onStart()
        Log.d("SplashActivty", "onStart: log del onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SplashActivty", "onPause: log del onpause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SplashActivty", "onDestroy: log del onDestroy")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SplashActivty", "onResume: log del onResume")
    }
}
