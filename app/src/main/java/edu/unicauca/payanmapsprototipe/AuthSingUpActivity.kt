package edu.unicauca.payanmapsprototipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_auth_sing_up.*

class AuthSingUpActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth_sing_up)

        // SETUP
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")

        btnSignUp.setOnClickListener {
            db.collection("users").document(email.toString()).set(
                hashMapOf("provider" to provider,
                "name" to editTextName.text.toString(),
                "phone" to editTextPhone.text.toString())
            )
            goMainMenu(email.toString(), provider.toString())
        }
    }

    private fun setup(email: String, provider: String) {
        title = "Inicio"

        txtEmail.text = email
        txtProvider.text = provider

        db.collection("users").document(email).get().addOnSuccessListener {
            editTextName.setText(it.get("name") as String?)
            editTextPhone.setText(it.get("phone") as String?)
        }

        // -------- LOG OUT BUTTON --------
        btnLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val homeIntent = Intent(this, AuthActivity::class.java).apply {
                putExtra("email", email)
            }
            startActivity(homeIntent)
        }
    }

    private fun showAlertRecord() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("A valid email is required and password must be at least 6 characters")
        builder.setPositiveButton("Accept", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun goMainMenu(email: String, provider: String) {
        val homeIntent = Intent(this, MainMenuActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider)
        }
        startActivity(homeIntent)
    }
}