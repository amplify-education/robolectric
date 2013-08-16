package com.xtremelabs.robolectric.shadows;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.xtremelabs.robolectric.WithTestDefaultsRunner;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.sameInstance;

@RunWith(WithTestDefaultsRunner.class)
public class ValueAnimatorTest {

    @Test
    public void canGetAndSetInterpolator() throws Exception {
        ValueAnimator subject = new ValueAnimator();
        LinearInterpolator expected = new LinearInterpolator();
        subject.setInterpolator(expected);
        assertSame(expected, subject.getInterpolator());
    }

    @Test
    public void canGetAndSetRepeatCount() throws Exception {
        ValueAnimator subject = new ValueAnimator();
        subject.setRepeatCount(9999);
        assertEquals(9999, subject.getRepeatCount());
    }
}
