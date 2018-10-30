package com.scz.restaurantweek.Animations;

import android.view.animation.TranslateAnimation;

public class Animations {

    public static TranslateAnimation animate(int fromYdelta, int toYdelta) {
        TranslateAnimation animation = new TranslateAnimation(0, 0, fromYdelta, toYdelta);
        animation.setDuration(200);
        animation.setFillAfter(false);

        return animation;
    }
}
