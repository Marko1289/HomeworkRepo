package com.example.homework.network;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.homework.Commons;
import com.example.homework.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dmax.dialog.SpotsDialog;

public class CustomRequest {

    private final String REQUEST_TAG = "MyRequestsTag";


    public static final String CONTENT_TYPE = "application/json";
    private Context context;
    private RequestQueue requestQueue;
    private RequestListener callback;
    private AlertDialog alertDialog;

    public CustomRequest(Context context, RequestQueue requestQueue, RequestListener callback) {
        if (context != null) {
            this.context = context;
            if (requestQueue != null) {
                if (callback != null) {
                    this.callback = callback;
                    this.requestQueue = requestQueue;
                    this.requestQueue = Volley.newRequestQueue(context);
                }
            } else
                Log.e(REQUEST_TAG, "RequestQueue is null");
        } else
            Log.e(REQUEST_TAG, "Context is null");
    }

    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    public void sendRequest(String url, String methodTypeString, String jsonType, String tag) {

       setLoadingDialog();

        if (url != null) {
            int methodType = 0;
            if (methodTypeString != null) {

                switch (methodTypeString) {
                    case "GET":
                        methodType = Request.Method.GET;
                        break;
                    case "POST":
                        methodType = Request.Method.POST;
                        break;
                }
            }

            switch (jsonType) {
                case Commons.JSON_OBJECT:

                    alertDialog.show();

                    JsonObjectRequest request = new JsonObjectRequest(methodType, url, null,
                            response -> {
                                callback.onRequestSuccess(response, tag);
                                alertDialog.cancel();

                            }, error -> {
                        alertDialog.cancel();
                        Toast.makeText(context, R.string.connection_error_message, Toast.LENGTH_SHORT).show();
                    });

                    requestQueue.add(request);
                    break;

                case Commons.JSON_ARRAY:
                    alertDialog.show();
                    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(methodType, url, null, response -> {
                        callback.onRequestSuccess(response, tag);
                        alertDialog.cancel();

                    }, error -> {
                        alertDialog.cancel();
                        Toast.makeText(context, R.string.connection_error_message, Toast.LENGTH_SHORT).show();
                    });

                    requestQueue.add(jsonArrayRequest);
                    break;
            }
        }

    }
    private void setLoadingDialog(){
        alertDialog = new SpotsDialog.Builder()
                .setContext(context)
                .setTheme(R.style.CustomDialog)
                .setCancelable(false)
                .build();
    }

}
