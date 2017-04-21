package com.example.rahulkapoor.sampleassignment;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rahulkapoor on 20/04/17.
 */
public class Model implements Parcelable {

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(final Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(final int size) {
            return new Model[size];
        }
    };
    private static final int NO_IMAGE_PROVIDED = -1;
    private String mcolor;
    private int mImageId = NO_IMAGE_PROVIDED;

    /**
     * @param color   member name in family
     * @param imageid image of family member
     */
    public Model(final String color, final int imageid) {
        this.mcolor = color;
        this.mImageId = imageid;

    }

    /**
     *
     * @param in pacel in
     */
    protected Model(final Parcel in) {
        mcolor = in.readString();
        mImageId = in.readInt();
    }

    /**
     * @return family memeber name;
     */
    public String getColor() {
        return mcolor;
    }

    /**
     * @return family member image id
     */
    public int getImageID() {
        return mImageId;
    }

    /**
     * @return check for presence of image of that family member;
     */
    public boolean hasImage() {
        return true;
    }

    /**
     *
     * @return describeContents;
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     *
     * @param dest parcel dest;
     * @param flags int flags;
     */
    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(mcolor);
        dest.writeInt(mImageId);
    }
}
