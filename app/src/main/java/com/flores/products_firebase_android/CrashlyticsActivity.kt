package com.flores.products_firebase_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.crashlytics.android.Crashlytics
import kotlinx.android.synthetic.main.activity_crashlytics.*

class CrashlyticsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crashlytics)

        btnCrashImplicit.setOnClickListener {
            etImplicit.text as Int
        }

        btnCrashExplicit.setOnClickListener {
            Crashlytics.getInstance().crash()
        }

    }
}
