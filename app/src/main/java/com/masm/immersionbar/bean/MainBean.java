package com.masm.immersionbar.bean;

import android.graphics.drawable.Drawable;

import com.masm.immersionbar.MyApplication;
import com.masm.immersionbar.utils.Utils;

import java.io.Serializable;

/**
 * NAME: 柚子啊
 * DATE: 2020/5/19
 * DESC:
 */
public class MainBean implements Serializable {

    private String name;
    private Drawable pic;
    private int flower;
    private int marginStart;
    private int marginEnd;

    public MainBean(String name, Drawable pic) {
        this.name = name;
        this.pic = pic;
        this.flower = Utils.getFlowerIcon();
        this.marginStart = Utils.dip2px(MyApplication.getContext(), 8);
        this.marginEnd = Utils.dip2px(MyApplication.getContext(), 8);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getPic() {
        return pic;
    }

    public void setPic(Drawable pic) {
        this.pic = pic;
    }

    public int getFlower() {
        return flower;
    }

    public int getMarginStart() {
        return marginStart;
    }

    public void setMarginStart(int marginStart) {
        this.marginStart = marginStart;
    }

    public int getMarginEnd() {
        return marginEnd;
    }

    public void setMarginEnd(int marginEnd) {
        this.marginEnd = marginEnd;
    }

}
