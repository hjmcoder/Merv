package com.hamedrahimvand.merv;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;

public class MervConfig {
    private Integer rotationExpand;
    private Integer rotationCollapse;
    private Drawable sideDrawable;
    private int textColor;

    private MervConfig(MervConfigBuilder mervConfigBuilder) {
        this.rotationExpand = mervConfigBuilder.rotationExpand;
        this.rotationCollapse = mervConfigBuilder.rotationCollapse;
        this.sideDrawable = mervConfigBuilder.sideDrawable;
        this.textColor = mervConfigBuilder.textColor;
    }

    public Integer getRotationExpand() {
        return rotationExpand;
    }

    public void setRotationExpand(Integer rotationExpand) {
        this.rotationExpand = rotationExpand;
    }

    public Integer getRotationCollapse() {
        return rotationCollapse;
    }

    public void setRotationCollapse(Integer rotationCollapse) {
        this.rotationCollapse = rotationCollapse;
    }

    public Drawable getSideDrawable() {
        return sideDrawable;
    }

    public void setSideDrawable(Drawable sideDrawable) {
        this.sideDrawable = sideDrawable;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(@ColorInt int textColor) {
        this.textColor = textColor;
    }

    public static class MervConfigBuilder {
        private Integer rotationExpand;
        private Integer rotationCollapse;
        private Drawable sideDrawable;
        private int textColor;

        public MervConfigBuilder() {
        }

        public MervConfigBuilder rotationExpand(Integer rotation) {
            this.rotationExpand = rotation;
            return this;
        }

        public MervConfigBuilder rotationCollapse(Integer rotation) {
            this.rotationCollapse = rotation;
            return this;
        }

        public MervConfigBuilder sideDrawable(Drawable drawable) {
            this.sideDrawable = drawable;
            return this;
        }

        public MervConfigBuilder textColor(@ColorInt int textColor) {
            this.textColor = textColor;
            return this;
        }

        public MervConfig build() {
            return new MervConfig(this);
        }


    }



}