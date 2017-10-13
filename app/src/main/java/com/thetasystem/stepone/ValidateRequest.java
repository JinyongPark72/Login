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

public class ValidateRequest extends StringRequest {
    final static private String URL = "http://localhost/userValidate.php";
    private Map<String, String> parameters;


    public ValidateRequest(String userNickname, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("NickName", userNickname);
    }

    @Override
    protected Map<String, String> getParams() {
        return  parameters;
    }
}
