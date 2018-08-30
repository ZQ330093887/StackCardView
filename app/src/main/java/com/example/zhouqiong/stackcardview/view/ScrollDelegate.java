package com.example.zhouqiong.stackcardview.view;
/**
 * Created by ZQiong on 2018/1/19.
 */
public interface ScrollDelegate {

    void scrollViewTo(int x, int y);
    void setViewScrollY(int y);
    void setViewScrollX(int x);
    int getViewScrollY();
    int getViewScrollX();

}
