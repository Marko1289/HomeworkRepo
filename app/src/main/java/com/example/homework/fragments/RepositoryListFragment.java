package com.example.homework.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.homework.Commons;
import com.example.homework.R;
import com.example.homework.adapters.RepositoryListAdapter;
import com.example.homework.models.RepositoriesModel;
import com.example.homework.network.CustomRequest;
import com.example.homework.network.RequestListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.List;


public class RepositoryListFragment extends Fragment implements RequestListener {

    private RecyclerView recyclerView;
    private List<RepositoriesModel> repositoriesModelsList;
    private RepositoryListAdapter adapter;

    public RepositoryListFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.repository_list_fragment, container, false);
        findViews(fragmentView);
        loadData();

        return fragmentView;
    }

    private void findViews(View view) {

        recyclerView = view.findViewById(R.id.recycler_list_view);
    }

    // call to server
    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    private void loadData() {
        if (getContext() != null) {

            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            CustomRequest customRequest = new CustomRequest(getContext(), requestQueue, this);
            customRequest.sendRequest(Commons.REPOSITORY_LIST_URL, Commons.GET_METHOD_TAG, Commons.JSON_ARRAY, Commons.REPOSITORY_LIST_TAG);

        }
    }

    // set RepositoryListAdapter after loading data from server
    private void setAdapter() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RepositoryListAdapter(getActivity(), repositoriesModelsList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onRequestSuccess(Object response, String tag) {

        if (tag.equalsIgnoreCase(Commons.REPOSITORY_LIST_TAG)) {
            if (response instanceof JSONArray) {

                Gson gson = new Gson();
                repositoriesModelsList = gson.fromJson(((JSONArray) response).toString(), new TypeToken<ArrayList<RepositoriesModel>>() {
                }.getType());
                if (repositoriesModelsList != null) {
                    setAdapter();
                }
            }
        }
    }
}
