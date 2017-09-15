package com.example.haeun_kim.hackpretty.volley;

import com.android.volley.VolleyError;

/**
 * Created by Sunpil on 2017-02-26.
 */

//volley의 request
public interface IVolleyResult {
    void notifySuccess(String response);
    void notifyError(VolleyError error);
}
