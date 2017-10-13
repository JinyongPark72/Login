package com.thetasystem.stepone;

import android.support.annotation.StringRes;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LG on 2017-10-14.
 */

public class RegisterRequest extends StringRequest {
    final static private String URL = "http://localhost/userRegister.php";
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userNickname, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("ID", userID);
        parameters.put("Password", userPassword);
        parameters.put("Nickname", userNickname);
    }

    @Override
    protected Map<String, String> getParams() {
        return  parameters;
    }
}
