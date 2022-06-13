package com.example.notificaciones

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun myToastNormal(view:View){
        Toast.makeText(this@MainActivity, "Normal", Toast.LENGTH_SHORT).show()
    }
    fun myToastGravity (view:View){
        val t = Toast.makeText(this@MainActivity, "Gravity", Toast.LENGTH_SHORT)
        t.setGravity(Gravity.CENTER or Gravity.LEFT, 0, 0)
        t.show()
    }
    fun myToastLayout(view: View){
        val layout = layoutInflater.inflate(R.layout.toast, null)
        layout!!.findViewById<TextView>(R.id.tvToastTitle).text = "ALERTA"
        layout!!.findViewById<TextView>(R.id.tvToastDescription).text = "Ésto es un Toast Personalizado"
        val t = Toast(this@MainActivity)
        t.duration = Toast.LENGTH_SHORT
        t.view = layout
        t.show()
    }
    fun mySnackBar (view: View){
        Snackbar.make(view, "Testing SnackBar", Snackbar.LENGTH_SHORT).show()
    }
    fun mySnackColor(view: View){
        val s = Snackbar.make(view, "Testing SnackBar", Snackbar.LENGTH_SHORT)
        //Asignando color desde los RECURSOS
        s.setTextColor(ContextCompat.getColor(view.context, R.color.orange))
        //Asignando color desde la clase COLOR
        s.setActionTextColor(Color.BLACK)
        s.setBackgroundTint(Color.CYAN)
        s.show()
    }
    fun mySnackBarCustom (view: View){
        val s = Snackbar.make(view, "", Snackbar.LENGTH_SHORT)
        val sbLayout = s.view as Snackbar.SnackbarLayout
        val customLayout = layoutInflater.inflate(R.layout.toast, null)

        customLayout!!.findViewById<TextView>(R.id.tvToastTitle).text = "ALERTA"
        customLayout!!.findViewById<TextView>(R.id.tvToastDescription).text = "Ésto es un SnackBar Personalizado"

        sbLayout.addView(customLayout, 0)
        s.setBackgroundTint(Color.YELLOW)
        s.show()
    }
}