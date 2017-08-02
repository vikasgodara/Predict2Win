package com.hello_world.vikas.predict2win;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vikas on 6/13/2017.
 */
public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MyHolder>
{
    private ArrayList<Match> matches_list;
    private Context mContext;
    public MatchAdapter(ArrayList<Match> list, Context mContext)
    {
    this.matches_list = list;
    this.mContext = mContext;
    }

    public MatchAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
    View v= LayoutInflater.from(mContext).inflate(R.layout.match_card,parent,false);
    //((TextView)v.findViewById(R.id.name)).setTypeface(DishActivity.custom_font);
    //((TextView)v.findViewById(R.id.total)).setTypeface(DishActivity.custom_font);
    //((TextView)v.findViewById(R.id.quantity)).setTypeface(DishActivity.custom_font);
    return new MyHolder(v);
    }
    @Override
    public void onBindViewHolder(final MatchAdapter.MyHolder holder, final int position)
    {
        Match match = matches_list.get(position);
        holder.tournament.setText(match.Tournament);
        holder.team1.setText(match.Country_1);
        holder.team2.setText(match.Country_2);
        holder.stake1.setText(match.Stake_1);
        holder.stake2.setText(match.Stake_2);
    }

    @Override
    public int getItemCount()
    {
    return matches_list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder
    {
    TextView tournament;
    TextView team1;
    TextView team2;
    TextView stake1;
    TextView stake2;
    public MyHolder(View itemView)
    {
    super(itemView);
         tournament = (TextView)itemView.findViewById(R.id.title);
         team1 = (TextView)itemView.findViewById(R.id.team1);
         team2 = (TextView)itemView.findViewById(R.id.team2);
         stake1 = (TextView)itemView.findViewById(R.id.stake1);
         stake2 = (TextView)itemView.findViewById(R.id.stake2);
         }
    }
}