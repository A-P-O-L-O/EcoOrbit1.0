package pq.logica

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import pq.logica.models.User

class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        val user = User.getUser(this)

        val buttonRecover = findViewById<TextView>(R.id.TVRecoverPassLogin)
        buttonRecover.setOnClickListener{
            startActivity(Intent(this,RecoverPassActivity::class.java))
        }

        val buttonRegister = findViewById<TextView>(R.id.TVParagraphRegisterHome)
        buttonRegister.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java))
        }

        val userInput = findViewById<EditText>(R.id.ETUserLogin)
        val passwordInput = findViewById<EditText>(R.id.ETKeyLogin)
        val buttonLogin = findViewById<Button>(R.id.BTNLogin)

        buttonLogin.setOnClickListener{
            if(userInput.text.toString() == user.nombres && passwordInput.text.toString() == user.password){
                startActivity(Intent(this,ProfileActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "La contraseña o el usuario son incorrectos", Toast.LENGTH_SHORT).show()
            }



        }


    }

    override fun onStart() {
        super.onStart()
        Log.d("LoginActivity", "onStart: log del onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LoginActivity", "onPause: log del onpause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LoginActivity", "onDestroy: log del onDestroy")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LoginActivity", "onResume: log del onResume")
    }
}