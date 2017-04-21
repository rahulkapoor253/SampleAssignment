package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rahulkapoor.sampleassignment.Model;
import com.example.rahulkapoor.sampleassignment.R;
import com.example.rahulkapoor.sampleassignment.Recycleviewadapter.RecycleAdapter;

import java.util.ArrayList;

import constants.AppConstant;

/**
 * Created by rahulkapoor on 21/04/17.
 */

public class SubEventFragment extends Fragment implements AppConstant {
    private RecyclerView recyclerView;
    private ArrayList<Model> mdataarraylist = new ArrayList<>();
    private Bundle bundle;
    private int modeVal;
    private Button mFirstBtn, mSecondBtn;
    private ViewPager viewPager;

    /**
     *
     * @param inflater layout inflate
     * @param container container
     * @param savedInstanceState current instance saved;
     * @return returns view;
     */
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sub_fragment, container, false);

        mdataarraylist.add(new Model("grandfather", R.drawable.family_grandfather));
        mdataarraylist.add(new Model("grandmother", R.drawable.family_grandmother));
        mdataarraylist.add(new Model("father", R.drawable.family_father));
        mdataarraylist.add(new Model("mother", R.drawable.family_mother));
        mdataarraylist.add(new Model("older brother", R.drawable.family_older_brother));
        mdataarraylist.add(new Model("older sister", R.drawable.family_older_sister));
        mdataarraylist.add(new Model("younger brother", R.drawable.family_younger_brother));
        mdataarraylist.add(new Model("younger sister", R.drawable.family_younger_sister));
        mdataarraylist.add(new Model("daughter", R.drawable.family_daughter));
        mdataarraylist.add(new Model("son", R.drawable.family_son));


        recyclerView = (RecyclerView) rootView.findViewById(R.id.rcSubFragment);
        bundle = getArguments();
        Log.d("debug", String.valueOf(bundle.getInt("mode")));
        RecycleAdapter adapter = new RecycleAdapter(bundle.getInt("mode"), mdataarraylist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);


        return rootView;
    }
}
