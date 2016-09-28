package com.word.swag.text.Params;

import android.graphics.Typeface;

import com.word.swag.text.Fragment.TextToolFragment;
import com.word.swag.text.Utils.ImageSmall;

/**
 * Created by HungND on 11/9/2015.
 */
public class BaseParams{

    public ImageSmall imageSmall = new ImageSmall();
    public int width, height;
    public int backgroundColor, textColor = TextToolFragment.getColor();
    public int paddingLeft, paddingTop, paddingRight, paddingBottom;
    public Typeface typeface;
    public int drawable = imageSmall.getRandomImageSquare();
    public int colorDrawable = TextToolFragment.getColor();
    public float rotation;
    public float textOpacity = TextToolFragment.getOpacity();
    public int textShadow = TextToolFragment.getColor();
    public int shading = TextToolFragment.getPosSbShadow();


    public int getShading() {
        return shading;
    }

    public void setShading(int shading) {
        this.shading = shading;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    public void setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public Typeface getTypeface() {
        return typeface;
    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getColorDrawable() {
        return colorDrawable;
    }

    public void setColorDrawable(int colorDrawable) {
        this.colorDrawable = colorDrawable;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public float getTextOpacity() {
        return textOpacity;
    }

    public void setTextOpacity(float textOpacity) {
        this.textOpacity = textOpacity;
    }

    public int getTextShadow() {
        return textShadow;
    }

    public void setTextShadow(int textShadow) {
        this.textShadow = textShadow;
    }
}
