package tg.esig.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import tg.esig.myapp.R

class SettingsActivity : AppCompatActivity() {

    lateinit var usernameTxtv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)
        usernameTxtv = findViewById(R.id.username_txtv)
        usernameTxtv.text = intent?.getStringExtra("USERNAME")

    }
}