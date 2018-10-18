package com.example.codebind.hfounders.Model;


import com.example.codebind.hfounders.Controller.RepoCard;

import java.util.Date;

public class Repo {

   private String id;
    private Owner owner;
    private String description;
    private String name;
    private Double score;

    private Date created_at;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public RepoCard getRepoCard(){
        RepoCard repoCard = new RepoCard(this.name, this.description, this.owner.getLogin(), this.score, this.owner.getAvatar_url());
        return repoCard;
    }

    @Override
    public String toString() {
        return  "id='" + id  +
                ", owner=" + owner +
                ", description='" + description +
                ", name='" + name +
                ", score='" + score +
                ", created_at=" + created_at;
    }
}

