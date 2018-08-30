package com.example.zhouqiong.stackcardview;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;

/**
 * Created by ZQiong on 2018/1/19.
 */

public class Card implements Parcelable {

    int mBgColor;
    int mImage;
    String mTitle;

    public Card(int bgColor, int image, String title) {
        mBgColor = bgColor;
        mImage = image;
        mTitle = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mBgColor);
        dest.writeInt(this.mImage);
        dest.writeString(this.mTitle);
    }

    protected Card(Parcel in) {
        this.mBgColor = in.readInt();
        this.mImage = in.readInt();
        this.mTitle = in.readString();
    }

    public static final Parcelable.Creator<Card> CREATOR = new Parcelable.Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel source) {
            return new Card(source);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };
}
