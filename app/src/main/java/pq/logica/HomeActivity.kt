package pq.logica

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
    }

    override fun onStart() {
        super.onStart()
        Log.d("HomeActivity", "onStart: log del onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("HomeActivity", "onPause: log del onpause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeActivity", "onDestroy: log del onDestroy")
    }

    override fun onResume() {
        super.onResume()
        Log.d("HomeActivity", "onResume: log del onResume")
    }
}