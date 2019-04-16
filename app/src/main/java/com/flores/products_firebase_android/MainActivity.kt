package com.flores.products_firebase_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        realtimeDatabase.setOnClickListener {
            startActivity(Intent(this, RealtimeDatabaseActivity::class.java))
        }

        remoteConfig.setOnClickListener {
            startActivity(Intent(this, RemoteConfigActivity::class.java))
        }

        btnCrashlytics.setOnClickListener {
            startActivity(Intent(this, CrashlyticsActivity::class.java))
        }

        btnStorage.setOnClickListener {
            startActivity(Intent(this, StorageActivity::class.java))
        }

        btnAuthentication.setOnClickListener {
            startActivity(Intent(this, AuthenticationActivity::class.java))
        }

    }
}
