package dev.VictorO.parcialdamormeo20100835

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonLogin = findViewById<Button>(R.id.buttonSignIn)
        val email = findViewById<EditText>(R.id.emailText)
        val password = findViewById<EditText>(R.id.passwordText)

        val correctEmail: String = "admin@travelapp.com"
        val correctPassword: String = "admin123"

        buttonLogin.setOnClickListener {
            val emailT = email.text.toString()
            val passwordT = password.text.toString()

            if (emailT == correctEmail && passwordT == correctPassword) {
                // Acciones a realizar si las credenciales son correctas
                val intent = Intent(this, MenuActivityNavigation::class.java)
                startActivity(intent)
            }else{
                // Acciones a realizar si las credenciales son incorrectas
                email.error = "Credenciales incorrectas"
                password.error = "Credenciales incorrectas"
            }
        }
    }


}