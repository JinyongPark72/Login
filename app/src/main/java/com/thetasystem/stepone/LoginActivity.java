package com.thetasystem.stepone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by LG on 2017-10-13.
 */

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = getIntent();

        TextView findaccounttextView = (TextView) findViewById(R.id.findaccounttextView);
        findaccounttextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "비번찾기 클릭 잘 됐네", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intent);
            }
        });

        TextView loginproblemtextView = (TextView) findViewById(R.id.loginproblemtextView);
        loginproblemtextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "로그인문제 클릭 잘 됐네", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intent);
            }
        });

    }
}
