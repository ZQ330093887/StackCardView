package com.example.zhouqiong.stackcardview;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhouqiong.stackcardview.view.CardStackView;
import com.example.zhouqiong.stackcardview.view.StackAdapter;

/**
 * Created by ZQiong on 2018/1/19.
 */
public class TestStackAdapter extends StackAdapter<Card> {
    MyItemOnClickListener mListener;

    public TestStackAdapter(Context context) {
        super(context);
    }

    public void setItemOnClickListener(MyItemOnClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public void bindView(Card data, int position, CardStackView.ViewHolder holder) {
        ColorItemViewHolder h = (ColorItemViewHolder) holder;
        h.onBind(data, position);
        h.mCardView.setTag(position);
        //h.mCardView.setOnClickListener(onClickListener);
    }

    @Override
    protected CardStackView.ViewHolder onCreateView(ViewGroup parent, int viewType) {
        return new ColorItemViewHolder(getLayoutInflater().inflate(R.layout.list_card_item, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.list_card_item;
    }

    static class ColorItemViewHolder extends CardStackView.ViewHolder {
        CardView mCardView;
        TextView mTextView;
        ImageView mImageView;

        ColorItemViewHolder(View view) {
            super(view);
            mCardView = view.findViewById(R.id.card);
            mTextView = view.findViewById(R.id.card_title);
            mImageView = view.findViewById(R.id.card_image);
        }

        @Override
        public void onItemExpand(boolean b) {
            //mContainerContent.setVisibility(View.GONE);
        }

        public void onBind(Card data, int position) {

            mTextView.setText(data.mTitle);
            mImageView.setImageResource(data.mImage);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                // BugFix: 4.x 版本: CardView 中填充 ImageView 会有白边
                mCardView.setCardBackgroundColor(data.mBgColor);
            }
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int pos = (int) v.getTag();
            if (mListener != null) {
                mListener.onItemOnClick(v, pos);
            }
        }
    };
}
