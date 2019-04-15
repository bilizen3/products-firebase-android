package com.flores.products_firebase_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.storage.FirebaseStorage

class StorageActivity : AppCompatActivity() {
    val storage by lazy {
        FirebaseStorage.getInstance("gs://products-429f3.appspot.com/")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)
        val storageReference = storage.reference
        val forestRef = storageReference.child("1_jA64NTovT-efZ96tcq-X5g.png")
        val ONE_MEGABYTE: Long = 1024 * 1024

        forestRef.getBytes(ONE_MEGABYTE).addOnSuccessListener {
            it
        }.addOnFailureListener {

        }

    }
}
