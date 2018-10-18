package com.example.codebind.hfounders.Model;

import com.example.codebind.hfounders.Controller.RepoCard;
import java.util.ArrayList;
import java.util.Iterator;



// This class represents the result of access to the JSON API URL, it stores info about the Repos and the Repos themselves
public class Result
{
    private boolean incomplete_results;

    private ArrayList<Repo> items;

    private String total_count;


    public void setIncomplete_results (boolean incomplete_results)
    {
        this.incomplete_results = incomplete_results;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public ArrayList<Repo> getItems() {
        return items;
    }

    public ArrayList<RepoCard> getRepoCards() {
        ArrayList<RepoCard> repoCards = new ArrayList<>();
        Iterator it = null;

        if(!items.isEmpty()) {
            try {
                it = items.iterator();
            } catch (Exception ex) {
                System.out.println("ssss");
            }
            assert it != null;
            while(it.hasNext()) {
                Repo repo = (Repo) it.next();
                repoCards.add(repo.getRepoCard());
            }
        }

        //This last Card will be used to load more Repos (the next page)
        repoCards.add(new RepoCard("Load More", "Click here to load more Repos"));

        return repoCards;
    }

    public void setItems(ArrayList<Repo> items) {
        this.items = items;
    }


    public String getTotal_count ()
    {
        return total_count;
    }

    public void setTotal_count (String total_count)
    {
        this.total_count = total_count;
    }

    @Override
    public String toString()
    {
        return "\n incomplete_results = "+ isIncomplete_results() +", total_count = "+ getTotal_count() + ",\n\n\n items = "+ getItems() ;
    }
}

