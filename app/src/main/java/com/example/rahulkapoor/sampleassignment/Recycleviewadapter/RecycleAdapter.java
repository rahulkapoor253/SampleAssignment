package com.example.rahulkapoor.sampleassignment.Recycleviewadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rahulkapoor.sampleassignment.HomePage;
import com.example.rahulkapoor.sampleassignment.Model;
import com.example.rahulkapoor.sampleassignment.R;

import java.util.ArrayList;

import constants.AppConstant;


/**
 * Created by rahulkapoor on 20/04/17.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> implements AppConstant {

    private ArrayList<Model> mModel;
    private ViewHolder dataHolder;
    private int mode;

    /**
     *
     * @param mode mode
     * @param datas arraylist datas;
     */
    public RecycleAdapter(final int mode, final ArrayList<Model> datas) {
        this.mModel = datas;
        this.mode = mode;
    }


    /**
     * @param parent   parent viewgroup
     * @param viewType viewtype
     * @return return object of inner class dataholder;
     */
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View dataView = inflater.inflate(R.layout.recycle_items, parent, false);

        dataHolder = new ViewHolder(dataView);

        return dataHolder;
    }

    /**
     * @param holder viewholder
     * @param position position
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Model colordata = mModel.get(position);
        Log.d("debug", String.valueOf(colordata.getImageID()));
        Log.d("debug", String.valueOf(colordata.getColor()));
        holder.mTextView.setText(colordata.getColor());
        holder.mImageView.setImageResource(colordata.getImageID());


    }


    /**
     * @return return size of arraylist;
     */
    @Override
    public int getItemCount() {
        return mModel.size();
    }

    @Override
    public void dummyMethod() {

    }

    /**
     * innerclass extending viewholder;
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private ImageView mImageView;

        /**
         *
         * @param itemView itemview
         */
        public ViewHolder(final View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.colorimageplaceholder);
            mTextView = (TextView) itemView.findViewById(R.id.tv_colorname);
            Log.d("debug", "about to be clicked.");
            Log.d("debug", String.valueOf(mModel.size()));

            if (mode == MODE_FIRST) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        Log.d("debug", "clicked");
                        itemView.getContext().startActivity(new Intent(itemView.getContext(),
                                HomePage.class));
                    }
                });

            } else {
                if (mode == MODE_UPCOMING) {

                    mImageView.setVisibility(View.GONE);
                } else {

                    mTextView.setVisibility(View.GONE);
                }

            }

        }


    }
}

