package pq.logica

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pq.logica.models.User

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)

        val user = User.getUser(this)


        // Referencias a las vistas
        val profileNameTextView = findViewById<TextView>(R.id.profileNameTextView)
        val profileLastnameTextView = findViewById<TextView>(R.id.profileLastnameTextView)
        val profileEmailTextView = findViewById<TextView>(R.id.profileEmailTextView)
        val profilePhoneTextView = findViewById<TextView>(R.id.profilePhoneTextView)

        // Asignar los datos recuperados a las vistas
        profileNameTextView.text = user.nombres
        profileLastnameTextView.text = user.apellidos
        profileEmailTextView.text = user.email
        profilePhoneTextView.text = user.phone
    }

    override fun onStart() {
        super.onStart()
        Log.d("ProfileActivity", "onStart: log del onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ProfileActivity", "onPause: log del onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ProfileActivity", "onDestroy: log del onDestroy")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ProfileActivity", "onResume: log del onResume")
    }
}
