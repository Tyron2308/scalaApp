package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //Intent intent = new Intent(this, AndroidVideoCaptureExample.class);
        //intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
        //startActivity(intent);
        Toast.makeText(this, "bonjour", Toast.LENGTH_LONG).show();
    }
}
