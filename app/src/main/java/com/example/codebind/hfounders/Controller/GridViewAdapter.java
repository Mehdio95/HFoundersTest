package com.example.codebind.hfounders.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.codebind.hfounders.R;
import java.util.ArrayList;


//This GridViewAdapter populates RepoCards into the GridView from an ArrayList of RepoCards
public class GridViewAdapter extends ArrayAdapter {
    Context mContext;
    int resourceId;
    ArrayList data = new ArrayList();

    public GridViewAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        this.mContext = context;
        this.resourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolder holder = null;

        if (itemView == null) {
            final LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = layoutInflater.inflate(resourceId, parent, false);

            holder = new ViewHolder();
            itemView.setTag(holder);
        } else {
            holder = (ViewHolder) itemView.getTag();
        }

        holder.imgItem = (ImageView) itemView.findViewById(R.id.icon);
        holder.RepoName = (TextView) itemView.findViewById(R.id.textViewRepoName);
        holder.RepoDescription = (TextView) itemView.findViewById(R.id.textViewRepoDescription);
        holder.RepoOwnerName  = (TextView) itemView.findViewById(R.id.textViewRepoOwnerName);
        holder.RepoScore  = (TextView) itemView.findViewById(R.id.textViewRepoScore);


        RepoCard item = (RepoCard) data.get(position);
        holder.RepoName.setText(item.getRepoName());
        holder.RepoDescription.setText(item.getRepoDescription());
        holder.RepoOwnerName.setText(item.getRepoOwnerName());
        holder.imgItem.setImageBitmap(item.getImage());


        if (item.getRepoScore()!=null) {
            holder.RepoScore.setText(String.valueOf(item.getRepoScore()));
        }else {
            holder.RepoScore.setText("");
            holder.imgItem.setImageBitmap(null);
        }

        return itemView;
    }

    static class ViewHolder {
        ImageView imgItem;
        TextView RepoName;
        TextView RepoDescription;
        TextView RepoOwnerName;
        TextView RepoScore;
    }

}