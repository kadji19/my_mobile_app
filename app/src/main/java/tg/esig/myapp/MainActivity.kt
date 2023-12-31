package tg.esig.myapp

import android.annotation.SuppressLint
import android.bluetooth.le.AdvertiseSettings
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var settingsBtn: Button
    lateinit var usernameEdt: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        settingsBtn = findViewById(R.id.settings_button)
        usernameEdt = findViewById(R.id.username_edt)

        settingsBtn.setOnClickListener {
            println("***************** Settings Button clicked")

            val username = usernameEdt.text.toString()
            if (username.isEmpty() || username.length < 2){
                usernameEdt.error = "Nom d'utilisateur non valide"
            }else {
                usernameEdt.error = null
                val intent = Intent(this, SettingsActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)

            }
        }

    }
}