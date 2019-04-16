package com.flores.products_firebase_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flores.products_firebase_android.util.showToast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_authentication.*

class AuthenticationActivity : AppCompatActivity() {

    private val firebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        btnSingIn.setOnClickListener {
            firebaseAuth
                .signInWithEmailAndPassword(etUser.text.toString(), etPassword.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        showToast("Authentication successful.")
                    } else {
                        showToast("Authentication failed.")
                    }
                }
        }
    }

}
