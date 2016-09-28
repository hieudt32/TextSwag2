package com.word.swag.text.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by ThanhDat on 12/28/15.
 */
public class MyStyleBaseView extends FrameLayout {

    public MyStyleBaseView(Context context) {
        super(context);
    }

    public MyStyleBaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyStyleBaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void onAlphaChange(float value){}

    public void onColorChange(int color){}

    public void onShadowChange(int shading, int color){}

    public void onTextChange(String text){}

}
