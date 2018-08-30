package com.example.zhouqiong.stackcardview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zhouqiong.stackcardview.utils.GlideImageLoader;
import com.example.zhouqiong.stackcardview.utils.StatusBarUtils;
import com.example.zhouqiong.stackcardview.view.AllMoveDownAnimatorAdapter;
import com.example.zhouqiong.stackcardview.view.CardStackView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.transformer.StackTransformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ZQiong on 2018/1/19.
 */
public class MainActivity extends AppCompatActivity implements CardStackView.ItemExpendListener {

    ArrayList<String> images = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();

    private CardStackView mStackView;
    private TestStackAdapter mTestStackAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBanner();
        StatusBarUtils.with(this)
                .init();

        mStackView = findViewById(R.id.stackview_main);
        mStackView.setItemExpendListener(this);
        mTestStackAdapter = new TestStackAdapter(this);
        mStackView.setAdapter(mTestStackAdapter);
        //mStackView.setAnimatorAdapter(new UpDownAnimatorAdapter(mStackView));
        mStackView.setAnimatorAdapter(new AllMoveDownAnimatorAdapter(mStackView));
        //mStackView.setAnimatorAdapter(new UpDownStackAnimatorAdapter(mStackView));
        mTestStackAdapter.setItemOnClickListener(new MyItemOnClickListener() {
            @Override
            public void onItemOnClick(View view, int position) {

            }
        });
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        mTestStackAdapter.updateData(initCards());
                    }
                }, 200
        );
    }

    private List<Card> initCards() {
        return Arrays.asList(
                new Card(0xFF00BACF, R.drawable.knowledge, "火车票"),
                new Card(0xFFE85D72, R.drawable.calendar, "国内机票"),
                new Card(0xFF17B084, R.drawable.task, "国际/港澳台机票"),
                new Card(0xFF2196F3, R.drawable.post, "汽车票"),
                new Card(0xFFA259A2, R.drawable.timg, "船票"));
    }

    private void initBanner() {
        images.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1089399937,1684001946&fm=23&gp=0.jpg");
        images.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=787324823,4149955059&fm=23&gp=0.jpg");
        images.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3514483810,1208920576&fm=23&gp=0.jpg");
        images.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1917280427,3920336884&fm=23&gp=0.jpg");
        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");

        titles.add("51巅峰钜惠");
        titles.add("十大星级品牌联盟，全场2折起");
        titles.add("生命不是要超越别人，而是要超越自己。");
        titles.add("己所不欲，勿施于人。——孔子");
        titles.add("嗨购5折不要停");


        Banner mBanner = findViewById(R.id.banner);
        mBanner.setImages(images)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .setBannerAnimation(StackTransformer.class)
                .start();
    }
//
//    public void onPreClick(View view) {
//        mStackView.pre();
//    }
//
//    public void onNextClick(View view) {
//        mStackView.next();
//    }

    @Override
    public void onItemExpend(boolean expend) {

    }
}

