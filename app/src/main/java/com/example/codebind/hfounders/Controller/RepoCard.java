package com.example.codebind.hfounders.Controller;

import android.graphics.Bitmap;

/**
 * Created by ASUS on 24/11/2017.
 */


//This class stores the attributes of a Repo that need to be displayed in the GridView
public class RepoCard {
    private Bitmap image;
    private String RepoName;
    private String RepoDescription;
    private String RepoOwnerName;
    private Double RepoScore;
    private String RepoImageURL;

    public RepoCard(String repoName, String repoDescription, String repoOwnerName, Double repoScore, String avatar_url) {
        super();
        RepoName = repoName;
        RepoDescription = repoDescription;
        RepoOwnerName = repoOwnerName;
        RepoScore = repoScore;
        RepoImageURL = avatar_url;
        image = JSONtoResult.getBitmapFromURL(avatar_url);
    }

    public RepoCard(String repoDescription, String repoOwnerName) {
        super();
        RepoDescription = repoDescription;
        RepoOwnerName = repoOwnerName;
    }


    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getRepoName() {
        return RepoName;
    }

    public void setRepoName(String repoName) {
        RepoName = repoName;
    }

    public String getRepoDescription() {
        return RepoDescription;
    }

    public void setRepoDescription(String repoDescription) {
        RepoDescription = repoDescription;
    }

    public String getRepoOwnerName() {
        return RepoOwnerName;
    }

    public void setRepoOwnerName(String repoOwnerName) {
        RepoOwnerName = repoOwnerName;
    }

    public Double getRepoScore() {
        return RepoScore;
    }

    public void setRepoScore(Double repoScore) {
        RepoScore = repoScore;
    }

    public String getRepoImageURL() {
        return RepoImageURL;
    }

    public void setRepoImageURL(String repoImageURL) {
        RepoImageURL = repoImageURL;
    }
}