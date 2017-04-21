package com.example.rahulkapoor.sampleassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rahulkapoor.sampleassignment.Recycleviewadapter.RecycleAdapter;

import java.util.ArrayList;

import constants.AppConstant;

/**
 * main acitvity that holds the recycler view;
 */
public class MainActivity extends AppCompatActivity implements AppConstant {

    private ArrayList<Model> mdataarraylist;
    private RecyclerView mRecycleView;

    /**
     * @param savedInstanceState current instance is saved;
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mdataarraylist = new ArrayList<>();

        init();

        mRecycleView = (RecyclerView) findViewById(R.id.recycler_view);
        RecycleAdapter adapter = new RecycleAdapter(MODE_FIRST, mdataarraylist);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(adapter);


    }


    /**
     * to make all the inits;
     */
    private void init() {

        mdataarraylist.add(new Model("red", R.drawable.color_red));
        mdataarraylist.add(new Model("gray", R.drawable.color_gray));
        mdataarraylist.add(new Model("brown", R.drawable.color_brown));
        mdataarraylist.add(new Model("black", R.drawable.color_black));
        mdataarraylist.add(new Model("dusty yellow", R.drawable.color_dusty_yellow));
        mdataarraylist.add(new Model("green", R.drawable.color_green));
        mdataarraylist.add(new Model("mustard", R.drawable.color_mustard_yellow));
        mdataarraylist.add(new Model("white", R.drawable.color_white));

    }


}
