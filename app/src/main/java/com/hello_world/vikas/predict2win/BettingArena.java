package com.hello_world.vikas.predict2win;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BettingArena extends AppCompatActivity {
    ArrayList<Match> matches_list;
    MatchAdapter adapter;
    public static RecyclerView rcv;
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_betting_arena);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        addDrawerItems();



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        TextView heading = (TextView) toolbar.findViewById(R.id.heading);
        assert heading != null;
        heading.setText("Betting Arena");
        matches_list = new ArrayList<>();
        Match m1=new Match();
        m1.Tournament="Champions Trophy";
        m1.Country_1="INDIA";
        m1.Country_2="SOUTH AFRICA";
        m1.Stake_1 = "1x";
        m1.Stake_2 = "2x";
        matches_list.add(m1);
        matches_list.add(m1);
        matches_list.add(m1);
        matches_list.add(m1);
        matches_list.add(m1);
        matches_list.add(m1);
        matches_list.add(m1);
        adapter = new MatchAdapter(matches_list, this);
        rcv = (RecyclerView) findViewById(R.id.rcv);
        rcv.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.setLayoutManager(manager);
    }
    private void addDrawerItems() {
        String[] osArray = { "Android", "iOS", "Windows", "OS X", "Linux" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);
    }
}
