package tg.esig.myapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    lateinit var emailEdit : EditText
    lateinit var passWordEdit : EditText
    lateinit var submitButton : Button
    lateinit var goToRegisterPageTv : TextView

    lateinit var preferences : SharedPreferences
    lateinit var editor : SharedPreferences.Editor



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEdit = findViewById(R.id.login_email_edt)
        passWordEdit = findViewById(R.id.login_password_edt)
        submitButton = findViewById(R.id.login_valider_btn)
        goToRegisterPageTv = findViewById(R.id.l_go_to_register_page)

        preferences = getSharedPreferences("MyPreferences", MODE_PRIVATE)
        editor = preferences.edit()

        if (preferences.contains("email")) {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }else{



        submitButton.setOnClickListener {

            if (validerFormulaire()){

                val my_email = emailEdit.text.toString()
                val my_password = passWordEdit.text.toString()
                editor.putString("email", my_email)
                editor.putString("password", my_password)
                editor.commit()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }


        goToRegisterPageTv.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }
    }

    private fun validerFormulaire(): Boolean{
        var isOk = true
        val emailEdtText = emailEdit.text.toString()
        val passwordEdtText = passWordEdit.text.toString()
        if (emailEdtText == null || emailEdtText.isEmpty() ){
            emailEdit.error = "Veuillez renseignez cette information"
            isOk = false

        }else{
            emailEdit.error = null
            if (!VerifEmail.isValidEmail(emailEdtText)){
                emailEdit.error = "email invalide"
                isOk = false
            }else{
                emailEdit.error = null
            }
        }
        if (passwordEdtText == null|| passwordEdtText.isEmpty() ){
            passWordEdit.error = "Veuillez renseignez cette information"
            isOk = false
        }else{
            passWordEdit.error == null
        }
        return isOk
    }


    }
