package com.flores.products_firebase_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_realtime_database.*

class RealtimeDatabaseActivity : AppCompatActivity() {

    private val database = FirebaseDatabase.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realtime_database)

        buttonSend.setOnClickListener {
            if (name.text.toString().trim().isNotEmpty() && value.text.toString().isNotEmpty()) {
                val myRef = database.getReference(name.text.toString().trim())
                myRef.setValue(value.text.toString())
            }
        }

        buttonGetData.setOnClickListener {
            if (editTextGetName.text.toString().trim().isNotEmpty()) {
                val myRef = database.getReference(editTextGetName.text.toString())
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                    }

                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        tvData.text = dataSnapshot.getValue(String::class.java)
                    }
                })
            }
        }

    }
}
