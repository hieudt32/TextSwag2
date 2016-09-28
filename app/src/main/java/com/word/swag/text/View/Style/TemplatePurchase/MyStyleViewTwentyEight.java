package com.word.swag.text.View.Style.TemplatePurchase;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;

import com.word.swag.text.Activity.MainActivity;
import com.word.swag.text.Fragment.TextToolFragment;
import com.word.swag.text.Params.Params;
import com.word.swag.text.R;
import com.word.swag.text.StringText.AnalyseString;
import com.word.swag.text.StringText.Calculate;
import com.word.swag.text.Utils.Fonts;
import com.word.swag.text.View.MyBaseView;
import com.word.swag.text.View.MyStyleBaseView;

/**
 * Created by company on 8/26/16.
 */
public class MyStyleViewTwentyEight extends MyStyleBaseView {

    public MyStyleViewTwentyEight myStyleViewTwentyEight;
    public int Width = MainActivity.sizeNew * 2 / 3;
    public int Height = MainActivity.sizeNew * 2 / 3;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03, baseView_04, baseView_05, baseView_06,
            baseView_07, baseView_08, baseView_09;
    public Params params_top, params_bottom;
    public Params params;
    public int drawable_top, drawable_left;
    public FrameLayout.LayoutParams layoutParams;

    public MyStyleViewTwentyEight(Context context) {
        super(context);
        myStyleViewTwentyEight = this;
        init();
    }

    public void init(){
        viewLine_top();
        customViewOne();
        customViewTwo();
        customViewThree();
        customviewFour();
        checkText();
    }


    public void viewLine_top(){
        params_top = new Params();
        params_top.setWidth(Width);
        params_top.setHeight(Height / 3);
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params_top);
        drawable_top = R.mipmap.temp28_02;
        baseView_01.setBackgroundResource(drawable_top);
        baseView_01.setDrawableColor(drawable_top, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(Width, Height / 3);
        layoutParams.setMargins(0, 0, 0, 0);
        myStyleViewTwentyEight.addView(baseView_01, layoutParams);

    }

    public void customViewOne(){
        params =  new Params();
        params.setWidth(Width * 5 / 7);
        params.setHeight(Height / 3);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setPaddingBottom(5);
        params.setPaddingTop(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width * 5 / 7, Height / 3);
        layoutParams.setMargins(Width / 7, Height / 3 - Height / 6, Width / 7, 0);
        myStyleViewTwentyEight.addView(baseView_02, layoutParams);
    }

    public void customViewTwo(){
        params =  new Params();
        params.setWidth(Width);
        params.setHeight(Height / 6);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setPaddingBottom(5);
        baseView_03 = new MyBaseView(MainActivity.getmContext(), params);
        drawable_left = R.mipmap.temp28_01;
        baseView_03.setBackgroundResource(drawable_left);
        baseView_03.setDrawableColor(drawable_left, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(Width, Height / 6);
        layoutParams.setMargins(0, Height * 2 / 3  - Height / 6 + Height / 24, 0, 0);
        myStyleViewTwentyEight.addView(baseView_03, layoutParams);
    }

    public void customViewThree(){
        params =  new Params();
        params.setWidth(Width);
        params.setHeight(Height / 6);
        params.setPaddingRight(20);
        params.setPaddingLeft(20);
        params.setPaddingBottom(10);
        params.setPaddingTop(10);
        baseView_04 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width, Height / 6);
        baseView_04.setTextColor(Color.BLACK);
        layoutParams.setMargins(0, Height * 2 / 3  - Height / 6 + Height / 24, 0, 0);
        myStyleViewTwentyEight.addView(baseView_04, layoutParams);
    }



    public void customviewFour(){
        params =  new Params();
        params.setWidth(Width / 3);
        params.setHeight(Height / 6);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setPaddingBottom(5);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_05 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width / 3, Height / 6);
        layoutParams.setMargins(Width / 3, Height * 2 / 3 + Height / 12, Width / 3, 0);
        myStyleViewTwentyEight.addView(baseView_05, layoutParams);
    }


    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_02 != null && baseView_04 != null && baseView_05 != null && baseView_07 !=null ) {
            baseView_01.setAlpha(value);
            baseView_02.setAlpha(value);
            baseView_04.setAlpha(value);
            baseView_05.setAlpha(value);
            baseView_06.setAlpha(value);
            baseView_07.setAlpha(value);
            baseView_08.setAlpha(value);
            baseView_09.setAlpha(value);
        }
    }

    @Override
    public void onColorChange(int color) {
        super.onColorChange(color);

        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 !=null && baseView_05 !=null) {
            baseView_01.setDrawableColor(drawable_top, color);
            baseView_02.setTextColor(color);
            baseView_03.setDrawableColor(drawable_left, color);
            baseView_04.setTextColor(Color.BLACK);
            baseView_05.setTextColor(color);
        }
    }

    @Override
    public void onShadowChange(int shading, int color) {
        super.onShadowChange(shading, color);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 !=null && baseView_05 !=null) {
            baseView_01.setTextShadow(shading, color);
            baseView_02.setTextShadow(shading, color);
            baseView_03.setTextShadow(shading, color);
            baseView_04.setTextShadow(shading, color);
            baseView_05.setTextShadow(shading, color);
        }
    }

    @Override
    public void onTextChange(String text) {
        super.onTextChange(text);
        analyseString.setmText(text);
        k = Calculate.countSpace(text);
        checkText();
    }

    public void checkText(){
        if (k >= 2){
            analyseString = new AnalyseString(2);
            setTextTH2();
        }else {
            analyseString = new AnalyseString(k);
            setTextTH1();
        }
    }

    public void setTextTH1(){
        if (k == 1) {
            baseView_02.setText(analyseString.result()[0]);
            baseView_04.setText(analyseString.result()[1]);
            baseView_05.setText("");
        }else if (k==0){
            baseView_04.setText(analyseString.result()[0]);
            baseView_02.setText("");
            baseView_05.setText("");
        }
    }

    public void setTextTH2(){
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 !=null && baseView_05 !=null){
            baseView_02.setText(analyseString.result()[0]);
            baseView_04.setText(analyseString.result()[1]);
            baseView_05.setText(analyseString.result()[2]);
        }
    }



}
