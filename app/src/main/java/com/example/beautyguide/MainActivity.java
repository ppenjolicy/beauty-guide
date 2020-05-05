package com.example.beautyguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button menu_eye;
    private Button menu_lip;
    private Button menu_brush;
    private Button menu_brow;
    private Button menu_makeup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu_eye = (Button) findViewById(R.id.m_eye);
        menu_lip = (Button) findViewById(R.id.m_lip);
        menu_brush = (Button) findViewById(R.id.m_brush);
        menu_brow = (Button) findViewById(R.id.m_brow);
        menu_makeup = (Button) findViewById(R.id.m_makeup);

        menu_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Eye1.class));
            }
        });
        menu_lip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Lip1.class));
            }
        });
        menu_brush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Brush1.class));
            }
        });
        menu_brow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Brow1.class));
            }
        });
        menu_makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Ab1.class));
            }
        });
    }
}