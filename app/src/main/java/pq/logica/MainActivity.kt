package pq.logica

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sharePreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        val buttonStar = findViewById<Button>(R.id.BTNStartHome)
        buttonStar.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }

        val buttonRegister = findViewById<TextView>(R.id.BTNRegisterHome)
        buttonRegister.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart: log del onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause: log del onpause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy: log del onDestroy")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume: log del onResume")
    }
}