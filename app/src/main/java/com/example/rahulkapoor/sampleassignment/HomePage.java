package com.example.rahulkapoor.sampleassignment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import constants.AppConstant;
import fragment.ItemFragment;

/**
 * Created by rahulkapoor on 20/04/17.
 */

public class HomePage extends AppCompatActivity implements AppConstant {

    private Button mPast;
    private Button mUpcoming;
    private ViewPager pager;

    /**
     * @param mode mode to choose th fragment;
     * @return returns the fragment int;
     */
    public static ItemFragment getInstance(final int mode) {
        ItemFragment itemfragment = new ItemFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("mode", mode);
        itemfragment.setArguments(bundle);
        return itemfragment;
    }

    /**
     * @param savedInstanceState current instance is saved;
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        init();
        addViewPager();
        Log.d("debug", "class fired");
    }

    /**
     * set view pager adapter;
     */
    public void addViewPager() {
        pager = (ViewPager) findViewById(R.id.view_pager);
        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                if (position == 0) {
                    return getInstance(MODE_UPCOMING);
                }
                return getInstance(MODE_PAST);
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

                if (position == 0) {

                    mUpcoming.setBackgroundResource(R.color.colorPrimary);
                    mPast.setBackgroundResource(R.color.colorAccent);
                } else {

                    mPast.setBackgroundResource(R.color.colorPrimary);
                    mUpcoming.setBackgroundResource(R.color.colorAccent);

                }

            }

            /**
             *
             * @param position posiiton;
             */
            @Override
            public void onPageSelected(final int position) {


            }

            /**
             *
             * @param state onpagestatechanged;
             */
            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });
        pager.setAdapter(fragmentStatePagerAdapter);
    }

    /**
     * to make all the initialisations;
     */
    private void init() {

        mPast = (Button) findViewById(R.id.btn_past);
        mUpcoming = (Button) findViewById(R.id.btn_upcoming);

    }

}

