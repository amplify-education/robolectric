package com.xtremelabs.robolectric.shadows;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

@Implements(ValueAnimator.class)
public class ShadowValueAnimator extends ShadowAnimator {
    private TimeInterpolator interpolator;
    private int repeatCount;

    @Implementation
    public void setInterpolator(TimeInterpolator value) {
        if (value != null) {
            interpolator = value;
        } else {
            interpolator = new LinearInterpolator();
        }
    }

    @Implementation
    public TimeInterpolator getInterpolator() {
        return interpolator;
    }

    @Implementation
    public static ValueAnimator ofInt (int... values){
    	return new ValueAnimator();
    }

    @Implementation
    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    @Implementation
    public int getRepeatCount() {
        return repeatCount;
    }
}
