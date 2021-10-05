package com.example.instafire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val auth=FirebaseAuth.getInstance()
        if(auth.currentUser!=null){
            PostActivity()
        }
        btn.setOnClickListener {
            btn.isEnabled=false
            val email = email.text.toString()
            val pass = pass.text.toString()
            if (email.isBlank() || pass.isBlank()) {
                Toast.makeText(this,"Email or Password Cannot be Empty",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
                btn.isEnabled=true
                if(it.isSuccessful) { Toast.makeText(this,"Successful",Toast.LENGTH_SHORT).show()
                    PostActivity()
                }
                else Toast.makeText(this,"Not Successful",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun PostActivity() {
        val intent=Intent(this,PostActivity::class.java)
        startActivity(intent)
        finish()
    }
}