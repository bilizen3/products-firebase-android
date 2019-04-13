package com.flores.products_firebase_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import kotlinx.android.synthetic.main.activity_remote_config.*

class RemoteConfigActivity : AppCompatActivity() {

    private lateinit var remoteConfig: FirebaseRemoteConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remote_config)
        remoteConfig = FirebaseRemoteConfig.getInstance()

        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setDeveloperModeEnabled(BuildConfig.DEBUG)
            .setMinimumFetchIntervalInSeconds(4200)
            .build()

        remoteConfig.setConfigSettings(configSettings)
        remoteConfig.setDefaults(R.xml.remote_config_defaults)

        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val updated = task.result
                } else {
                }
                showMessage()
            }
    }

    private fun showMessage() {
        val contentText = remoteConfig.getString("Text")
        val colorText = remoteConfig.getString("Color")
        tvContent.text = contentText
        when (colorText) {
            "Red" -> tvContent.setTextColor(resources.getColor(R.color.colorAccent))
            "Green" -> tvContent.setTextColor(resources.getColor(R.color.colorPrimaryDark))
            else -> tvContent.setTextColor(resources.getColor(R.color.colorPrimary))
        }
    }

}
