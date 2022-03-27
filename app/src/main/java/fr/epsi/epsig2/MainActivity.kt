package fr.epsi.epsig2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences= getSharedPreferences("epsi", Context.MODE_PRIVATE)
        val login = sharedPreferences.getString("login","Not found")
        val password = sharedPreferences.getString("password","Not found")

        val buttonLoggin:Button = findViewById(R.id.buttonLoggin)
        buttonLoggin.setOnClickListener(View.OnClickListener {
            val textLogin= findViewById<EditText>(R.id.editTextLogin)
            val textPassword = findViewById<EditText>(R.id.editTextPassowrd)

            if (login == textLogin.text.toString() && password == textPassword.text.toString() ) {
                val newIntent= Intent(application,FragmentActivity::class.java)
                startActivity(newIntent)
            }else{
                showToast("Mauvais login ou mot de passe")
            }
        })
    }
}