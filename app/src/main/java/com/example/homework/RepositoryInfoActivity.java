package com.example.homework;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homework.models.RepositoriesModel;

public class RepositoryInfoActivity extends AppCompatActivity {

    private TextView
            id,
            name,
            createdAt,
            updatedAt,
            pushedAt,
            gitUrl,
            defaultBranch,
            openIssues,
            url,
            keys_url,
            teams_url,
            assignees_url,
            branches_url,
            commits_url,
            comments_url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repositoty_info_activity_view);

        findViews();

        if (getIntent().getExtras() != null) {
            setDataForModel();

        }
    }

    private void findViews() {
        id = findViewById(R.id.repositort_id);
        name = findViewById(R.id.repository_name);
        createdAt = findViewById(R.id.created_at);
        updatedAt = findViewById(R.id.updated_at);
        pushedAt = findViewById(R.id.pushed_at);
        gitUrl = findViewById(R.id.git_url);
        defaultBranch = findViewById(R.id.default_branch);
        openIssues = findViewById(R.id.open_issues);
        url = findViewById(R.id.url);
        keys_url = findViewById(R.id.keys_url);
        teams_url = findViewById(R.id.teams_url);
        assignees_url = findViewById(R.id.assignees_url);
        branches_url = findViewById(R.id.branches_url);
        commits_url = findViewById(R.id.commits_url);
        comments_url = findViewById(R.id.comments_url);

    }

    private void setDataForModel() {


        RepositoriesModel repositoriesModel = getIntent().getParcelableExtra(Commons.SINGLE_REPOSITORY);
        id.setText(String.valueOf(repositoriesModel.getId()));
        name.setText(repositoriesModel.getName());
        createdAt.setText(repositoriesModel.getCreated_at());
        updatedAt.setText(repositoriesModel.getUpdated_at());
        pushedAt.setText(repositoriesModel.getPushed_at());
        gitUrl.setText(repositoriesModel.getGit_url());
        defaultBranch.setText(repositoriesModel.getDefault_branch());
        openIssues.setText(repositoriesModel.getOpen_issues());
        url.setText(repositoriesModel.getUrl());
        keys_url.setText(repositoriesModel.getKeys_url());
        teams_url.setText(repositoriesModel.getTeams_url());
        assignees_url.setText(repositoriesModel.getAssignees_url());
        branches_url.setText(repositoriesModel.getBranches_url());
        commits_url.setText(repositoriesModel.getCommits_url());
        comments_url.setText(repositoriesModel.getComments_url());


    }
}
