package com.enesterzi.alertdialogkotlin

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1) Toast 2) Alert Dialog 3) Snackbar


        // Context
        // Activity Context -> this (Bu aktivitenin içinde)
        // Applicaiton Context -> applicationContext (genel uygulamanın içinde)

        Toast.makeText(this@MainActivity, "Welcome!", Toast.LENGTH_LONG).show()
    }

    fun save(view: View){
        val alert = AlertDialog.Builder(this@MainActivity)
        alert
            .setTitle("Save")
            .setMessage("Are you sure?")
            .setPositiveButton("Yes"
            ) { dialog, which ->
                Toast.makeText(this@MainActivity, "Saved", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this@MainActivity, "Not Saved", Toast.LENGTH_LONG).show()
            }
            .show()
    }
}