package com.thetasystem.stepone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FrameLayout fbframeLayout = (FrameLayout) findViewById(R.id.fbbuttonFrameLayout);
        fbframeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "facebook 클릭 잘 됐네", Toast.LENGTH_LONG).show();
            }
        });


        TextView logintextView = (TextView) findViewById(R.id.logintextView);
        logintextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        TextView jointextView = (TextView) findViewById(R.id.jointextView);
        jointextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JoinFirstActivity.class);
                startActivity(intent);
            }
        });


    }
}
