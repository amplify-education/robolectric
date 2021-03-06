package com.xtremelabs.robolectric.shadows;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;
import com.xtremelabs.robolectric.internal.RealObject;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"UnusedDeclaration"})
@Implements(Animator.class)
public class ShadowAnimator {
    @RealObject
    private Animator realObject;
    protected long duration;
    private final List<AnimatorListener> listeners = new ArrayList<AnimatorListener>();
    private boolean wasStarted;

    protected void notifyStart() {
        for (AnimatorListener listener : listeners) {
            listener.onAnimationStart(realObject);
        }
    }

    protected void notifyEnd() {
        for (AnimatorListener listener : listeners) {
            listener.onAnimationEnd(realObject);
        }
    }

    @Implementation
    public void addListener(AnimatorListener listener) {
        listeners.add(listener);
    }
    
    @Implementation
    public void start() {
    	notifyStart();
    	notifyEnd();
        wasStarted = true;
    }

    // Tested via ObjectAnimatorTest for now
    @Implementation
    public long getDuration() {
        return duration;
    }

    public boolean wasStarted() {
        return wasStarted;
    }
}
