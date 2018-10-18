package com.example.codebind.hfounders;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.codebind.hfounders.Controller.JSONtoResult;
import com.example.codebind.hfounders.Model.Result;
import com.example.codebind.hfounders.Controller.GridViewAdapter;
import com.example.codebind.hfounders.Controller.RepoCard;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    GridViewAdapter gridAdapter;
    ArrayList<RepoCard> repoCards;
    Result result;
    Integer page;
    TextView pageTxtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Trending Repos");

        page = 1;

        gridView = findViewById(R.id.gridView1);
        pageTxtView = findViewById(R.id.textView);

        new asyncGetRes(getBaseContext(), result, page).execute();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (repoCards.get(position).getRepoDescription().equals("Load More")){
                    page++;
                    new asyncGetRes(getBaseContext(), result, page).execute();
                }
            }
        });
    }

    public class asyncGetRes extends AsyncTask<Result, Void, Result> {
        Result result;
        Context context;
        Integer pageNum;

        public asyncGetRes(Context context, Result result, Integer pageNum) {
            super();
            this.result = result;
            this.context = context;
            this.pageNum = pageNum;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pageTxtView.setText("Loading... Please wait!");
            pageTxtView.setTextColor(Color.RED);
        }

        @Override
        protected Result doInBackground(Result... results) {
            this.result = JSONtoResult.getResult(pageNum);
            repoCards= result.getRepoCards();
            publishProgress();
            return result;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate();
            pageTxtView.setText("Page: "+pageNum);
            pageTxtView.setTextColor(Color.BLACK);
        }

        @Override
        protected void onPostExecute(Result result) {
            gridAdapter = new GridViewAdapter(context, R.layout.card_repo, repoCards );
            gridView.setAdapter(gridAdapter);

        }
    }

}
