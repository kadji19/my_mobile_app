package tg.esig.myapp

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Patterns
import java.util.regex.Pattern

class VerifEmail {

    companion object{
        @JvmStatic
        fun isValidEmail(email: String): Boolean {
            val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
            val pattern = Pattern.compile(emailRegex)
            val  matcher = pattern.matcher(email)
            return matcher.matches()
        }
    }

}
