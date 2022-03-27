package fr.epsi.epsig2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            writeSharedPreferences("login", "afoley")
            writeSharedPreferences("password", "afoley")
            writeSharedPreferences("affectation", "Surveillance piece2")
            writeSharedPreferences("nom", "Axel")
            writeSharedPreferences("prenom", "Foley")
            writeSharedPreferences("mat1", "brassard")
            writeSharedPreferences("mat2", "cyno")
            val newIntent=Intent(application,MainActivity::class.java)
            startActivity(newIntent)
            finish()
        },2000)
    }
}