package com.flores.products_firebase_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flores.products_firebase_android.util.showImage
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_storage.*

class StorageActivity : AppCompatActivity() {
    val storage by lazy {
        FirebaseStorage.getInstance("gs://products-429f3.appspot.com")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)
        val storageReference = storage.reference
        val forestRef = storageReference.child("1_jA64NTovT-efZ96tcq-X5g.png")
            .downloadUrl.addOnSuccessListener { uri ->
            ivPhoto.showImage(uri.toString())
        }.addOnFailureListener{
            it.message
        }

        storageReference.child("1_jA64NTovT-efZ96tcq-X5g.png").downloadUrl.addOnSuccessListener {
            // Got the download URL for 'users/me/profile.png'
        }.addOnFailureListener {
            // Handle any errors
        }


    }
}
