package com.example.homework.adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework.Commons;
import com.example.homework.R;
import com.example.homework.RepositoryInfoActivity;
import com.example.homework.models.RepositoriesModel;

import java.util.List;

public class RepositoryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private  Activity activity;
    private  List<RepositoriesModel> repositoriesModelsList;

    public RepositoryListAdapter(Activity activity, List<RepositoriesModel> repositoriesModelsList) {
        this.activity = activity;
        this.repositoriesModelsList = repositoriesModelsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(activity).inflate(R.layout.repository_list_row, parent, false);
        return new RepositoriesHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof RepositoriesHolder) {
            RepositoriesHolder holder1 = (RepositoriesHolder) holder;

            holder1.repositoryName.setText(repositoriesModelsList.get(position).getName());
            String issues = "Open issues (" + repositoriesModelsList.get(position).getOpen_issues() + ")";
            holder1.openIssues.setText(issues);

            holder1.repositoryLayout.setOnClickListener(v -> {

                Intent intent = new Intent(activity, RepositoryInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(Commons.SINGLE_REPOSITORY, (Parcelable) repositoriesModelsList.get(position));
                intent.putExtras(bundle);
                activity.startActivity(intent);

            });
        }
    }

    @Override
    public int getItemCount() {
        return Math.max(repositoriesModelsList.size(), 0);
    }

    static class RepositoriesHolder extends RecyclerView.ViewHolder {

        private final TextView repositoryName;
        private final TextView openIssues;
        private final LinearLayout repositoryLayout;

        public RepositoriesHolder(@NonNull View itemView) {
            super(itemView);

            repositoryName = itemView.findViewById(R.id.repository_name);
            openIssues = itemView.findViewById(R.id.open_issues);
            repositoryLayout = itemView.findViewById(R.id.repository_layout);

        }
    }
}
