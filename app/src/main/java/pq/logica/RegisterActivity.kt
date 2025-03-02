package pq.logica

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import pq.logica.models.User

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        val buttonRedirectToLogin = findViewById<TextView>(R.id.loginRedirectAction)
        buttonRedirectToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        val inputFirstName = findViewById<EditText>(R.id.inputFirstName)
        val inputLastName = findViewById<EditText>(R.id.inputLastName)
        val inputEmail = findViewById<EditText>(R.id.inputEmail)
        val inputPhone = findViewById<EditText>(R.id.inputPhone)
        val inputPassword = findViewById<EditText>(R.id.inputPassword)
        val inputConfirmPassword = findViewById<EditText>(R.id.inputConfirmPassword)
        val termsCheckBox = findViewById<CheckBox>(R.id.termsCheckBox)
        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val errors = ArrayList<String>()

            // Validación del nombre
            if (inputFirstName.text.isNullOrEmpty()) {
                errors.add("El nombre no puede estar vacío")
            }

            // Validación del apellido
            if (inputLastName.text.isNullOrEmpty()) {
                errors.add("El apellido no puede estar vacío")
            }

            // Validación del correo electrónico
            val email = inputEmail.text.toString()
            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                errors.add("El correo electrónico no es válido")
            }

            // Validación del teléfono
            val phone = inputPhone.text.toString()
            if (phone.isEmpty() || !TextUtils.isDigitsOnly(phone)) {
                errors.add("El teléfono debe contener solo números y no puede estar vacío")
            }

            // Validación de la contraseña
            val password = inputPassword.text.toString()
            if (password.length < 6) {
                errors.add("La contraseña debe tener al menos 6 caracteres")
            }

            // Validación de coincidencia de contraseñas
            val confirmPassword = inputConfirmPassword.text.toString()
            if (password != confirmPassword) {
                errors.add("Las contraseñas no coinciden")
            }

            // Validación del CheckBox de términos y condiciones
            if (!termsCheckBox.isChecked) {
                errors.add("Debe aceptar los términos y condiciones")
            }

            // Mostrar los errores en un Toast
            if (errors.isNotEmpty()) {
                Toast.makeText(this, errors.joinToString("\n"), Toast.LENGTH_LONG).show()
            } else {
                // Crear un objeto User con los datos ingresados
                val user = User().apply {
                    nombres = inputFirstName.text.toString()
                    apellidos = inputLastName.text.toString()
                    this.email = email
                    this.phone = phone
                    this.password = password
                    acceptTerms = termsCheckBox.isChecked
                }
                user.save(this)
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("RegisterActivity", "onStart: log del onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("RegisterActivity", "onPause: log del onpause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("RegisterActivity", "onDestroy: log del onDestroy")
    }

    override fun onResume() {
        super.onResume()
        Log.d("RegisterActivity", "onResume: log del onResume")
    }
}
