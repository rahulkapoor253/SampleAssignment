package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rahulkapoor.sampleassignment.R;

import constants.AppConstant;

/**
 * Created by rahulkapoor on 20/04/17.
 */

public class ItemFragment extends Fragment implements AppConstant {
    private Button btnRightFrag, btnLeftFrag;
    private int mode;

    /**
     * @param mode mode to choose th fragment;
     * @return returns the fragment int;
     */
    public static Fragment getInstance(final int mode) {
        SubEventFragment subEventFragment = new SubEventFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("mode", mode);
        subEventFragment.setArguments(bundle);
        return subEventFragment;
    }

    /**
     *
     * @param inflater inflate layout
     * @param container container viewgroup
     * @param savedInstanceState current instance state;
     * @return return view;
     */
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Bundle bundle = getArguments();
        mode = bundle.getInt("mode");
        init(view);
        Log.d("lol", String.valueOf(mode));
        if (mode == MODE_UPCOMING) {
            btnRightFrag.setText("accepted");
            btnLeftFrag.setText("pending");
        } else {
            btnRightFrag.setText("completed");
            btnLeftFrag.setText("caneled");
        }
        addViewPager(view);
        return view;
    }

    /**
     *
     * @param view view passed;
     */
    public void addViewPager(final View view) {
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.vpSubScreen);
        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
            /**
             *
             * @param position position
             * @return return fragment chosen;
             */
            @Override
            public Fragment getItem(final int position) {
                if (mode == MODE_UPCOMING) {
                    if (position == 0) {
                        return getInstance(MODE_ACCPETED);
                    } else {
                        return getInstance(MODE_PENDING);
                    }
                }
                if (position == 0) {
                    return getInstance(MODE_COMPLETED);
                } else {
                    return getInstance(MODE_CANCELED);
                }
            }

            /**
             *
             * @return return count of fragments;
             */
            @Override
            public int getCount() {
                return 4;
            }
        };
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             *
             * @param position posiiton
             * @param positionOffset offsetposition
             * @param positionOffsetPixels posiitonoffsetpixels
             */
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
                if (position == 0) {
                    btnLeftFrag.setBackgroundResource(R.color.colorPrimary);
                    btnRightFrag.setBackgroundResource(R.color.colorAccent);

                } else {
                    btnLeftFrag.setBackgroundResource(R.color.colorPrimary);
                    btnRightFrag.setBackgroundResource(R.color.colorAccent);

                }
            }

            /**
             *
             * @param position position
             */
            @Override
            public void onPageSelected(final int position) {


            }

            /**
             *
             * @param state state
             */
            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });
        viewPager.setAdapter(fragmentStatePagerAdapter);
    }

    /**
     *
     * @param view view passed and initialissation to buttons made;
     */
    public void init(final View view) {
        btnLeftFrag = (Button) view.findViewById(R.id.btn_accepted);
        btnRightFrag = (Button) view.findViewById(R.id.btn_pending);
    }

}
