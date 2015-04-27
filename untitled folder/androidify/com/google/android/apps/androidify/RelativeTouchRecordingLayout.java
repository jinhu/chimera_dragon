package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.apps.p017c.C0260g;

public class RelativeTouchRecordingLayout extends RelativeLayout {
    private C0260g f904a;

    public RelativeTouchRecordingLayout(Context context) {
        super(context);
    }

    public RelativeTouchRecordingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RelativeTouchRecordingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f904a != null && this.f904a.m2109a()) {
            this.f904a.m2107a(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setTouchRecorder(C0260g c0260g) {
        this.f904a = c0260g;
    }
}
