package com.example.exercise1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Graphics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphicsView(this));

    }
}