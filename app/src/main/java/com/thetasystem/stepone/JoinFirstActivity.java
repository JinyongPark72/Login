package com.thetasystem.stepone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by LG on 2017-10-12.
 */

public class JoinFirstActivity extends AppCompatActivity {
    private String userID;
    private String userPassword;
    private String userNickname;
    private AlertDialog alertDialog;
    private boolean validate = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joinfirst);

        final EditText idEditText = (EditText) findViewById(R.id.emailEditText);
        final EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        final EditText nicknameEditText = (EditText) findViewById(R.id.nicknameEditText);

        final Button validateButton = (Button) findViewById(R.id.validateButton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNickname = nicknameEditText.getText().toString();
                if(validate){
                    return;
                }
                if(userNickname.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinFirstActivity.this);
                    alertDialog = builder.setMessage("닉네임을 반드시 입력해 주세요.")
                                    .setPositiveButton("확인", null)
                                    .create();
                    alertDialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinFirstActivity.this);
                                alertDialog = builder.setMessage("사용할 수 있는 닉네임입니다.")
                                        .setPositiveButton("확인", null)
                                        .create();
                                alertDialog.show();
                                nicknameEditText.setEnabled(false);
                                validate = true;
                                nicknameEditText.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                validateButton.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinFirstActivity.this);
                                alertDialog = builder.setMessage("사용할 수 없는 닉네임입니다.")
                                        .setPositiveButton("확인", null)
                                        .create();
                                alertDialog.show();
                            }
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                ValidateRequest validateRequest = new ValidateRequest(userNickname, responseListener);
                RequestQueue queue = Volley.newRequestQueue(JoinFirstActivity.this);
                queue.add(validateRequest);
            }
        });
        Intent intent = getIntent();

    }
}
