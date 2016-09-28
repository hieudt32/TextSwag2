package com.word.swag.text.View;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.FrameLayout;

import com.word.swag.text.touch.RotateGestureDetector;

/**
 * Created by ThanhDat on 12/4/15.
 */
public class TouchBaseView extends FrameLayout{

    private GestureDetector gestureDetector;
    private ScaleGestureDetector mScaleDetector;
    private RotateGestureDetector mRotateDetector;
    private float mScaleFactor = 1.f;
    private float mRotationDegrees = 0.f;
    TouchBaseView temp;
    // declarations for drag and drop drawing object
    private float mPosX;
    private float mPosY;
    private float mLastTouchX;
    private float mLastTouchY;
    private static final int INVALID_POINTER_ID = -1;
    private int mActivePointerId = INVALID_POINTER_ID;
    float gx = 0,gy = 0;

    public int centerX, centerY;

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public OnChangeLayoutListener mListener;

    public interface OnChangeLayoutListener{
        public void onDoubleTab(MotionEvent event);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mListener = (OnChangeLayoutListener)this.getContext();
    }

    public TouchBaseView(Context context) {
        this(context, null, 0);
        temp = this;
        mListener = (OnChangeLayoutListener)this.getContext();

    }

    public TouchBaseView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        temp = this;
        mListener = (OnChangeLayoutListener)this.getContext();
    }

    public TouchBaseView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        temp = this;
        mListener = (OnChangeLayoutListener)this.getContext();
        gestureDetector = new GestureDetector(context, new GestureListener());
        mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
        mRotateDetector = new RotateGestureDetector(context, new RotateListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // Let the ScaleGestureDetector inspect all events.

        gestureDetector.onTouchEvent(ev);
        mScaleDetector.onTouchEvent(ev);
        mRotateDetector.onTouchEvent(ev);

        final int action = ev.getAction();
        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: {
                final float x = ev.getX();
                final float y = ev.getY();

                mLastTouchX = x;
                mLastTouchY = y;

                // Save the ID of this pointer
                mActivePointerId = ev.getPointerId(0);
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                // Find the index of the active pointer and fetch its position
                final int pointerIndex = ev.findPointerIndex(mActivePointerId);
                final float x = ev.getX(pointerIndex);
                final float y = ev.getY(pointerIndex);

                // Only move if the ScaleGestureDetector isn't processing a gesture.
                if (!mScaleDetector.isInProgress()) {
                    final float dx = x - mLastTouchX;
                    final float dy = y - mLastTouchY;

                    mPosX += dx;
                    mPosY += dy;

                    invalidate();
                }


                mLastTouchX = x;
                mLastTouchY = y;
                break;
            }

            case MotionEvent.ACTION_UP: {
                mActivePointerId = INVALID_POINTER_ID;
                break;
            }

            case MotionEvent.ACTION_CANCEL: {
                mActivePointerId = INVALID_POINTER_ID;
                break;
            }

            case MotionEvent.ACTION_POINTER_UP: {
                // Extract the index of the pointer that left the touch sensor
                final int pointerIndex = (action & MotionEvent.ACTION_POINTER_INDEX_MASK)
                        >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                final int pointerId = ev.getPointerId(pointerIndex);
                if (pointerId == mActivePointerId) {
                    // This was our active pointer going up. Choose a new
                    // active pointer and adjust accordingly.
                    final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                    mLastTouchX = ev.getX(newPointerIndex);
                    mLastTouchY = ev.getY(newPointerIndex);
                    mActivePointerId = ev.getPointerId(newPointerIndex);
                }
                break;
            }
        }

        return true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        float pivotX, pivotY;
        pivotX = getWidth() / 2;
        pivotY = getHeight() / 2;
        canvas.save(Canvas.MATRIX_SAVE_FLAG);

        canvas.translate(mPosX, mPosY);

        canvas.scale(mScaleFactor, mScaleFactor, pivotX, pivotY);

        canvas.rotate(mRotationDegrees, pivotX, pivotY);
        super.dispatchDraw(canvas);
        canvas.restore();

    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            mScaleFactor *= detector.getScaleFactor();
            gx = detector.getFocusX();
            gy = detector.getFocusY();
//            Log.d("showtouch", "gx" + gx);
//            Log.d("showtouch", "gy" + gy);
            // Don't let the object get too small or too large.
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 2.0f));
            // Log.d("onScale", ""+mScaleFactor);
            invalidate();
            return true;
        }
    }

    private class RotateListener extends RotateGestureDetector.SimpleOnRotateGestureListener {
        @Override
        public boolean onRotate(RotateGestureDetector detector) {
            mRotationDegrees -= detector.getRotationDegreesDelta();
            return true;
        }
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
        // event when double tap occurs
        @Override
        public boolean onDoubleTap(MotionEvent e) {
                mListener.onDoubleTab(e);
            return true;
        }
    }

}
