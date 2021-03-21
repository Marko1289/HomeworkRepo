package com.example.homework.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.homework.Commons;
import com.example.homework.R;
import com.example.homework.models.UserModel;
import com.example.homework.network.CustomRequest;
import com.example.homework.network.RequestListener;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class UserProfileFragment extends Fragment implements RequestListener {

    private UserModel userModel;
    private CircleImageView userProfileImage;
    private TextView name;
    private TextView company;

    public UserProfileFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.user_profile_fragment, container, false);

        findViews(fragmentView);
        loadData();
        return fragmentView;
    }

    // call to Server
    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    private void loadData() {
        if (getContext() != null) {

            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            CustomRequest customRequest = new CustomRequest(getContext(), requestQueue, this);
            customRequest.sendRequest(Commons.USER_URL, Commons.GET_METHOD_TAG, Commons.JSON_OBJECT, Commons.USERP_ROFILE_TAG);

        }
    }

    @Override   // Handle response
    public void onRequestSuccess(Object response, String tag) {
        if (tag.equalsIgnoreCase(Commons.USERP_ROFILE_TAG)) {
            Gson gson = new Gson();

            UserModel profile = gson.fromJson(response.toString(), UserModel.class);
            if (profile != null) {
                userModel = new UserModel(profile.getName(), profile.getCompany(), profile.getAvatar_url());
                name.setText(userModel.getName());
                company.setText(userModel.getCompany());
                if (!userModel.getAvatar_url().equals("/")) {
                    Picasso.with(getContext()).load(profile.getAvatar_url()).into(userProfileImage);
                } else
                    Toast.makeText(getContext(), "There is no url for user picture", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void findViews(View view) {
        userProfileImage = view.findViewById(R.id.user_profile_picture);
        name = view.findViewById(R.id.user_name);
        company = view.findViewById(R.id.company);

    }
}