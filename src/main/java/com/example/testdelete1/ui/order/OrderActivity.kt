package com.example.testdelete1.ui.order

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.testdelete1.R

class OrderActivity : AppCompatActivity() {
    private lateinit var email:EditText
    private lateinit var name:EditText
    private lateinit var adress:EditText
    private lateinit var order: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        email=findViewById(R.id.order_email)
        name=findViewById(R.id.order_name)
        adress=findViewById(R.id.order_adress)
        order=findViewById(R.id.button_order)
        order.setOnClickListener({ view ->
//            startActivity(Intent(this,CartActivity::class.java))
            Toast.makeText(this,""+" order placed sucessfully", Toast.LENGTH_LONG).show()

            val i = Intent(Intent.ACTION_SEND)
            i.type = "message/rfc822"
            i.putExtra(Intent.EXTRA_EMAIL, arrayOf("mounirrouissi2@gmail.com"))
            i.putExtra(Intent.EXTRA_SUBJECT, "order:\n")
            i.putExtra(Intent.EXTRA_TEXT,
                "email="+email.text+"\n"+
                "name="+name.text+"\n"+
                "adress="+adress.text+"\n"
            )
            try {
                startActivity(Intent.createChooser(i, "Send mail..."))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    this,
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            /*       Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show()*/
        })
    }
}