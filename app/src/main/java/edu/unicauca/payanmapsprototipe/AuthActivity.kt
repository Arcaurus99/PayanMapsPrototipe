package edu.unicauca.payanmapsprototipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import androidx.core.text.set
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val bundle = intent.extras
        val email = bundle?.getString("email")

        editTextEmail.setText(email)

        setup()
    }

    private fun setup() {

        title = "Autentication"

        btnSignUp.setOnClickListener {
            if (editTextEmail.text.isNotEmpty() && editTextPassword.text.isNotEmpty()) {

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(editTextEmail.text.toString(),
                    editTextPassword.text.toString()).addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            goSignUp(it.result?.user?.email ?: "", ProviderType.BASIC)
                        } else {
                            showAlertRecord()
                        }
                }
            }
        }

        btnLogIn.setOnClickListener {
            if (editTextEmail.text.isNotEmpty() && editTextPassword.text.isNotEmpty()) {

                FirebaseAuth.getInstance().signInWithEmailAndPassword(editTextEmail.text.toString(),
                    editTextPassword.text.toString()).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        goMainMenu(it.result?.user?.email ?: "", ProviderType.BASIC)
                    } else {
                        showAlert()
                    }
                }
            }
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("There is a error in auth")
        builder.setPositiveButton("Accept", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showAlertRecord() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("A valid email is required and password must be at least 6 characters")
        builder.setPositiveButton("Accept", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun goMainMenu(email: String, provider: ProviderType) {
        val homeIntent = Intent(this, MainMenuActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

    private fun goSignUp(email: String, provider: ProviderType) {
        val homeIntent = Intent(this, AuthSingUpActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

}