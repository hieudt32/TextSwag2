package com.word.swag.text.View;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.word.swag.text.Params.BaseParams;
import com.word.swag.text.Params.Params;

/**
 * Created by lifor on 11/6/2015.
 */
public class MyBaseView extends View {
    public String mText = "";
    private float mWidth, mHeight;
    private float mFontSize, mScaleX;
    private float mBaseLine;
    private Paint mPaint;
    private BaseParams params;
    public int mAlpha;
    public int drawable;

    boolean isInit = false;

    public void init(BaseParams params) {
        isInit = true;
        this.params = params;
        this.mWidth = params.width;
        this.mHeight = params.height;
        setPadding(params.paddingLeft, params.paddingTop, params.paddingRight, params.paddingBottom);
        setRotation(params.rotation);
//        if (params.backgroundColor != -1){
//            setmDrawObject(params.drawable);
//        }else {
//            setBackGroundColor(params.backgroundColor);
//        }
        setBackGroundColor(params.backgroundColor);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.CENTER);
        setmFontType(params.typeface);
        setTextOpacity(params.textOpacity);
        setTextColor(params.getTextColor());
        setTextShadow(params.shading, params.textShadow);
        setAlpha(1f);
    }

    public MyBaseView(Context context) {
        super(context);
        init(null);
    }

    public MyBaseView(Context context, Params params) {
        super(context);
        init(params);
    }

    public MyBaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyBaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        if (mText != null) {
            this.mText = mText;
            calculatorFontSize();
            calculatorSizeScale();
            invalidate();
        }
    }

    public void setTextOpacity(float textOpacity) {
        if (isInit) {
            this.params.textOpacity = textOpacity;
            setAlpha(textOpacity);
            Log.d("show", "alpha: " + mAlpha);
            invalidate();
        }
    }

    public void setTextColor(int newColor){
        if (isInit){
            this.params.textColor = newColor;
            Log.d("color", "color" + newColor);
            mPaint.setColor(newColor);
            invalidate();
        }
    }

    public void setTextShadow(int shading, int textShadow){
        if (isInit){
            this.params.shading = shading;
            this.params.textShadow = textShadow;
            mPaint.setShadowLayer(shading, 0, 0, textShadow);
            invalidate();
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void setDrawableColor(int colorDrawable){
        if (isInit){
            this.params.textColor = colorDrawable;
            int image = params.getDrawable();
            Drawable drawable = getResources().getDrawable(image);
            drawable.setColorFilter(colorDrawable, PorterDuff.Mode.SRC_ATOP);
            setBackground(drawable);

        }
    }

    public void setmFontType(Typeface mFontType) {
        if (isInit) {
            this.params.typeface = mFontType;
            mPaint.setTypeface(mFontType);
            calculatorFontSize();
            calculatorSizeScale();
            invalidate();
        }
    }

    public void setmDrawObject(int mDrawObject) {
        if (isInit) {
            this.params.drawable = mDrawObject;
            setBackgroundResource(mDrawObject);

        }
    }

    // add

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void setDrawableColor(int newDrawable, int colorDrawable){
        Drawable drawable = getResources().getDrawable(newDrawable);
        drawable.setColorFilter(colorDrawable, PorterDuff.Mode.SRC_ATOP);
        setBackground(drawable);
    }


    public void setBackGroundColor(int backGroundColor) {
        if (isInit) {
            this.params.backgroundColor = backGroundColor;
            setBackgroundColor(params.backgroundColor);

        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mWidth = w;
        mHeight = h;
        calculatorFontSize();
        calculatorSizeScale();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public void setRotation(float rotation) {
        if (isInit) this.params.rotation = rotation;
        Point offset = calculatorSizeOffset();
        setTranslationX(offset.x);
        setTranslationY(offset.y);
        super.setRotation(rotation);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (!isInit) {
            throw new RuntimeException("Data must init before use");
        }
        if (params.typeface != null) mPaint.setTypeface(params.typeface);
        mPaint.setColor(params.textColor);
        setAlpha(params.textOpacity);
        canvas.drawText(mText, mWidth / 2, mHeight - mBaseLine, mPaint);
        Log.d("Hung", "onDraw");
    }

    private void calculatorFontSize() {
        mPaint.setTextScaleX(1.0f);
        mPaint.setTextSize(100f);
        Rect bounds = new Rect();
        mPaint.getTextBounds(mText, 0, mText.length(), bounds);
        mFontSize = ((mHeight - getPaddingTop() - getPaddingBottom()) * 100f) / bounds.height();
        mPaint.setTextSize(mFontSize);
    }

    private void calculatorSizeScale() {
        Rect bounds = new Rect();
        mPaint.getTextBounds(mText, 0, mText.length(), bounds);
        mBaseLine = bounds.bottom + (mHeight - bounds.height()) / 2;
        mScaleX = (mWidth - getPaddingLeft() - getPaddingRight()) / bounds.width();
        mPaint.setTextScaleX(mScaleX);
    }

    private Point calculatorSizeOffset() {
        float w2 = mWidth / 2;
        float h2 = mHeight / 2;
        double xy = Math.sqrt(w2 * w2 + h2 * h2);
        double beta = Math.atan(h2 / w2);
        double alpha = Math.toRadians(params.rotation);
        double tempGama = alpha + beta;

        // chéo 1
        double gama = Math.abs(tempGama);
        Point cheo1 = calculatorProjection(xy, gama);

        // chéo 2
        double gama2 = Math.abs(tempGama - 2 * beta);
        Point cheo2 = calculatorProjection(xy, gama2);

        int deltaX = 0, deltaY = 0;
        if (Math.abs(cheo1.x) > Math.abs(cheo2.x)) {
            deltaX = cheo1.x - (int) w2;
        } else {
            deltaX = cheo2.x - (int) w2;
        }
        if (Math.abs(cheo1.y) > Math.abs(cheo2.y)) {
            deltaY = cheo1.y - (int) h2;
        } else {
            deltaY = cheo2.y - (int) h2;
        }
        return new Point(deltaX, deltaY);
    }

    private Point calculatorProjection(double hypotenuse, double corner) {
        if (corner > Math.PI) {
            double temp = Math.floor(Math.PI);
            corner = corner - temp * Math.PI;
        }
        if (corner > Math.PI / 2d) {
            corner = Math.PI - corner;
        }

        Long xt = Math.round(hypotenuse * Math.cos(corner));
        Long yt = Math.round(hypotenuse * Math.sin(corner));
        return new Point(xt.intValue(), yt.intValue());
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.destroyDrawingCache();
    }
}
