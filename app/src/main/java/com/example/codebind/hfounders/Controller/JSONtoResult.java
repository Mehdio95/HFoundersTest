package com.example.codebind.hfounders.Controller;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.codebind.hfounders.Model.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class JSONtoResult {

    public static Result result;

    private static OkHttpClient client = new OkHttpClient();

    public static String link = "http://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc";

    public static String getJSON(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    //This method parses the JSON objects into a Java Object
    public static Result getResult(Integer pageNum) {
        String json = null;
        try {
            json = getJSON(JSONtoResult.link + "&page=" + pageNum );
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();

        try {
            result = gson.fromJson(json, new TypeToken<Result>() { }.getType());
        }
        catch (Exception ex){
           System.err.println("*********** Erreur de serveur, addresse IP inaccessible ***********");
        }
        return result;
    }

    //This Method loads the avatar of the Repo owner from its link into a bitmap
    public static Bitmap getBitmapFromURL(String src) {
        try {
            Request request = new Request.Builder()
                    .url(src)
                    .build();

            Response response = client.newCall(request).execute();

            InputStream input = response.body().byteStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
