package com.scz.restaurantweek.Custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;


public class NoTopFadingEdgeScrollView extends ScrollView {

    public NoTopFadingEdgeScrollView(Context context) {
        super(context);
    }

    public NoTopFadingEdgeScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoTopFadingEdgeScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected float getTopFadingEdgeStrength() {
        return 0.0f;
    }
}