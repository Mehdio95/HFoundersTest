package com.example.codebind.hfounders.Model;

/**
 * Created by ASUS on 10/15/2018.
 */

public class Owner
{

    private String login;
    private String avatar_url;


    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getLogin ()
    {
        return login;
    }

    public void setLogin (String login)
    {
        this.login = login;
    }


    @Override
    public String toString() {
        return "Owner{" +
                "login='" + login + '\'' +
                '}';
    }
}
