package com.launcher.test

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.graphics.drawable.Animatable
import android.widget.Toast
import android.content.Intent
import com.example.myapplication.AndroidVideoCaptureExample



class MainActivity extends Activity {
    // allows accessing `.value` on TR.resource.constants
    implicit val context = this

    override def onCreate(savedInstanceState: Bundle): Unit = {
        super.onCreate(savedInstanceState)

        val text = "Hello toast!";
        val duration = Toast.LENGTH_SHORT;
        val toast = Toast.makeText(context, text, duration);
        toast.show();

        val intent = new Intent(this, classOf[AndroidVideoCaptureExanple]);
        println("tristeess");
    }

}
