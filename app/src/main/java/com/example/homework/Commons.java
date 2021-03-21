package com.example.homework;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.homework.network.CustomRequest;

import java.util.concurrent.TimeUnit;

public class Commons {

    public static final String TAG = "CommonsClass";

    // URLs
    public static final String BASE_URL = "https://api.github.com";
    public static final String USER_URL = BASE_URL + "/users/octocat";
    public static final String REPOSITORY_LIST_URL = BASE_URL + "/users/octocat/repos";

    // TAGS
    public static final String GET_METHOD_TAG = "GET";
    public static final String POST_METHOD_TAG= "POST";
    public static final String JSON_OBJECT= "JsonObject";
    public static final String JSON_ARRAY= "JsonArray";
    public static final String USERP_ROFILE_TAG = "userProfile";
    public static final String REPOSITORY_LIST_TAG= "repositoriesListTag";

    public static final String SINGLE_REPOSITORY = "singleRepository";

    }