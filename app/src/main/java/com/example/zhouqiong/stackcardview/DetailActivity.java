package com.example.zhouqiong.stackcardview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by ZQiong on 2018/1/19.
 */
public class DetailActivity extends AppCompatActivity {

    ImageView mImageView;
    TextView mTextView;
    View mContent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        mImageView = findViewById(R.id.detail_bg);
        mTextView = findViewById(R.id.detail_title);
        mContent = findViewById(R.id.detail_content);

//        Card card = getIntent().getParcelableExtra("card");
//        mImageView.setImageResource(card.mImage);
//        StatusBarUtil.setColor(this, card.mBgColor);
//        mTextView.setText("哈哈哈 改变一下标题 ~" + card.mTitle);

        animContent();
    }

    private void animContent() {
        mTextView.animate().alpha(1f).setDuration(500).start();
        mContent.animate().alpha(1f).setDuration(500).start();
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
        overridePendingTransition(0, 0);
    }
}
