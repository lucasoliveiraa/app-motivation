package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        findViewById<Button>(R.id.buttonSave).setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonSave) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = findViewById<EditText>(R.id.editName).text.toString()

        if (name != "") {
            mSecurityPreferences.storeString("name", name)
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Informe seu nome!", Toast.LENGTH_SHORT).show()
        }
    }
}