package com.example.homework.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class RepositoriesModel implements Parcelable {

    private long id;
    private String name;
    private String created_at;
    private String updated_at;
    private String pushed_at;
    private String git_url;
    private String default_branch;
    private String open_issues;
    private String url;
    private String keys_url;
    private String teams_url;
    private String assignees_url;
    private String branches_url;
    private String commits_url;
    private String comments_url;



    public RepositoriesModel(long id, String name, String created_at, String updated_at, String pushed_at, String git_url, String default_branch, String open_issues, boolean has_issues) {
        this.id = id < 0 ? id : 0;
        this.name = name != null ? name : "/";
        this.created_at = created_at != null ? created_at : "/";
        this.updated_at = updated_at != null ? updated_at : "/";
        this.pushed_at = pushed_at != null ? pushed_at : "/";
        this.git_url = git_url != null ? git_url : "/";
        this.default_branch = default_branch != null ? default_branch : "/";
        this.open_issues = open_issues != null ? open_issues : "/";
    }

    protected RepositoriesModel(Parcel in) {
        id = in.readLong();
        name = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
        pushed_at = in.readString();
        git_url = in.readString();
        default_branch = in.readString();
        open_issues = in.readString();
        url = in.readString();
        keys_url = in.readString();
        teams_url = in.readString();
        assignees_url = in.readString();
        branches_url = in.readString();
        commits_url = in.readString();
        comments_url = in.readString();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(created_at);
        dest.writeString(updated_at);
        dest.writeString(pushed_at);
        dest.writeString(git_url);
        dest.writeString(default_branch);
        dest.writeString(open_issues);
        dest.writeString(url);
        dest.writeString(keys_url);
        dest.writeString(teams_url);
        dest.writeString(assignees_url);
        dest.writeString(branches_url);
        dest.writeString(commits_url);
        dest.writeString(comments_url);

    }

    public static final Creator<RepositoriesModel> CREATOR = new Creator<RepositoriesModel>() {
        @Override
        public RepositoriesModel createFromParcel(Parcel in) {
            return new RepositoriesModel(in);
        }

        @Override
        public RepositoriesModel[] newArray(int size) {
            return new RepositoriesModel[size];
        }
    };
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeys_url() {
        return keys_url;
    }

    public void setKeys_url(String keys_url) {
        this.keys_url = keys_url;
    }

    public String getTeams_url() {
        return teams_url;
    }

    public void setTeams_url(String teams_url) {
        this.teams_url = teams_url;
    }

    public String getAssignees_url() {
        return assignees_url;
    }

    public void setAssignees_url(String assignees_url) {
        this.assignees_url = assignees_url;
    }

    public String getBranches_url() {
        return branches_url;
    }

    public void setBranches_url(String branches_url) {
        this.branches_url = branches_url;
    }

    public String getCommits_url() {
        return commits_url;
    }

    public void setCommits_url(String commits_url) {
        this.commits_url = commits_url;
    }

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPushed_at() {
        return pushed_at;
    }

    public void setPushed_at(String pushed_at) {
        this.pushed_at = pushed_at;
    }

    public String getGit_url() {
        return git_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public String getDefault_branch() {
        return default_branch;
    }

    public void setDefault_branch(String default_branch) {
        this.default_branch = default_branch;
    }

    public String getOpen_issues() {
        return open_issues;
    }

    public void setOpen_issues(String open_issues) {
        this.open_issues = open_issues;
    }


    @Override
    public int describeContents() {
        return 0;
    }


}

