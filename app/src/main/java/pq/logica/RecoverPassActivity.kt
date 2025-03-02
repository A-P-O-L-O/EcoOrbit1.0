package pq.logica

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RecoverPassActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var buttonSend: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewSuccess: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recover_pass_activity)

        // Inicializar las vistas
        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSend = findViewById(R.id.buttonSend)
        progressBar = findViewById(R.id.progressBar)
        textViewSuccess = findViewById(R.id.textViewSuccess)

        buttonSend.setOnClickListener {
            val email = editTextEmail.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa un correo electrónico", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Mostrar el loader y ocultar el botón
            progressBar.visibility = View.VISIBLE
            buttonSend.visibility = View.GONE

            // Simular una operación con retraso de 2 segundos
            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = View.GONE
                textViewSuccess.visibility = View.VISIBLE
                Toast.makeText(this, "Correo enviado a $email", Toast.LENGTH_SHORT).show()
            }, 2000)
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("RecoverPassActivity", "onStart: log del onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("RecoverPassActivity", "onPause: log del onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("RecoverPassActivity", "onDestroy: log del onDestroy")
    }

    override fun onResume() {
        super.onResume()
        Log.d("RecoverPassActivity", "onResume: log del onResume")
    }
}
