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
import com.word.swag.text.Utils.ImageSmall;
import com.word.swag.text.View.MyBaseView;
import com.word.swag.text.View.MyStyleBaseView;

/**
 * Created by company on 8/26/16.
 */
public class MyStyleViewTwentySeven extends MyStyleBaseView{

    public MyStyleViewTwentySeven myStyleViewTwentySeven;
    public int Width = MainActivity.sizeNew * 2 / 3;
    public int Height = MainActivity.sizeNew * 2 / 3;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03, baseView_04, baseView_05, baseView_06,
            baseView_07, baseView_08, baseView_09;
    public Params params_top, params_bottom;
    public Params params;
    public int drawable_top, drawable_left, drawable_right, drawable_bottom;
    public FrameLayout.LayoutParams layoutParams;

    public MyStyleViewTwentySeven(Context context) {
        super(context);
        myStyleViewTwentySeven = this;
        init();
    }

    public void init(){
        viewLine_top();
        customViewOne();
        customViewTwo();
        customviewThree();
        customviewFour();
        customviewFive();
        customviewSix();
        viewLine_bottom();
        checkText();
    }


    public void viewLine_top(){
        params_top = new Params();
        params_top.setWidth(Width);
        params_top.setHeight(Height / 7);
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params_top);
        drawable_top = R.mipmap.temp27_03;
        baseView_01.setBackgroundResource(drawable_top);
        baseView_01.setDrawableColor(drawable_top, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(Width, Height / 7);
        layoutParams.setMargins(0, 0, 0, 0);
        myStyleViewTwentySeven.addView(baseView_01, layoutParams);

    }

    public void customViewOne(){
        params =  new Params();
        params.setWidth(Width * 5 / 7);
        params.setHeight(Height / 7);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setPaddingBottom(5);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width * 5 / 7, Height / 7);
        layoutParams.setMargins(Width / 7, Height / 7, Width / 7, 0);
        myStyleViewTwentySeven.addView(baseView_02, layoutParams);
    }

    public void customViewTwo(){
        params =  new Params();
        params.setWidth(Width / 4);
        params.setHeight(Height / 7);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setPaddingBottom(5);
        baseView_04 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width / 4, Height / 7);
        layoutParams.setMargins(Width * 3 / 8, Height * 2 / 7, Width * 3 / 8, 0);
        myStyleViewTwentySeven.addView(baseView_04, layoutParams);
    }

    public void customviewThree(){
        params =  new Params();
        params.setWidth(Width * 7 / 8);
        params.setHeight(Height / 7);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setPaddingBottom(5);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_05 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width * 7 / 8, Height / 7);
        layoutParams.setMargins(Width / 16, Height * 3 / 7, Width / 16 , 0);
        myStyleViewTwentySeven.addView(baseView_05, layoutParams);
    }

    public void customviewFour(){
        params =  new Params();
        params.setWidth(Width / 3);
        params.setHeight(Height * 2 / 7);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setPaddingBottom(5);
        baseView_06 = new MyBaseView(MainActivity.getmContext(), params);
        drawable_left = R.mipmap.temp27_01;
        baseView_06.setBackgroundResource(drawable_left);
        baseView_06.setDrawableColor(drawable_left, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(Width / 3, Height * 2 / 7);
        layoutParams.setMargins(0, Height * 4 / 7, Width * 2 / 3, 0);
        myStyleViewTwentySeven.addView(baseView_06, layoutParams);
    }

    public void customviewFive(){
        params =  new Params();
        params.setWidth(Width / 3);
        params.setHeight(Height * 2 / 7);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setPaddingBottom(5);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_07 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width / 3, Height * 2 / 7);
        layoutParams.setMargins(Width / 3, Height * 4 / 7, Width / 3, 0);
        myStyleViewTwentySeven.addView(baseView_07, layoutParams);
    }

    public void customviewSix(){
        params =  new Params();
        params.setWidth(Width / 3);
        params.setHeight(Height * 2 / 7);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setPaddingBottom(5);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_08 = new MyBaseView(MainActivity.getmContext(), params);
        drawable_right = R.mipmap.temp27_04;
        baseView_08.setBackgroundResource(drawable_right);
        baseView_08.setDrawableColor(drawable_right, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(Width / 3, Height * 2 / 7);
        layoutParams.setMargins(Width * 2 / 3, Height * 4 / 7, 0, 0);
        myStyleViewTwentySeven.addView(baseView_08, layoutParams);
    }

    public void viewLine_bottom(){
        params_bottom = new Params();
        params_bottom.setWidth(Width);
        params_bottom.setHeight(Height / 7);
        params_bottom.setBackgroundColor(TextToolFragment.getColor());
        baseView_09 = new MyBaseView(MainActivity.getmContext(), params_bottom);
        drawable_bottom = R.mipmap.temp27_02;
        baseView_09.setBackgroundResource(drawable_bottom);
        baseView_09.setDrawableColor(drawable_bottom, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(Width, Height / 7);
        layoutParams.setMargins(0, Height * 6 / 7, 0, 0);
        myStyleViewTwentySeven.addView(baseView_09, layoutParams);

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

        if (baseView_02 != null && baseView_04 != null && baseView_05 != null && baseView_07 !=null) {
            baseView_01.setDrawableColor(drawable_top, color);
            baseView_02.setTextColor(color);
            baseView_04.setTextColor(color);
            baseView_05.setTextColor(color);
            baseView_06.setDrawableColor(drawable_left, color);
            baseView_07.setTextColor(color);
            baseView_08.setDrawableColor(drawable_right, color);
            baseView_09.setDrawableColor(drawable_bottom, color);
        }
    }

    @Override
    public void onShadowChange(int shading, int color) {
        super.onShadowChange(shading, color);
        if (baseView_02 != null && baseView_04 != null && baseView_05 != null && baseView_07 !=null) {
            baseView_01.setTextShadow(shading, color);
            baseView_02.setTextShadow(shading, color);
            baseView_04.setTextShadow(shading, color);
            baseView_05.setTextShadow(shading, color);
            baseView_06.setTextShadow(shading, color);
            baseView_07.setTextShadow(shading, color);
            baseView_08.setTextShadow(shading, color);
            baseView_09.setTextShadow(shading, color);
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
        if (k >= 3){
            analyseString = new AnalyseString(3);
            setTextTH2();
        }else {
            analyseString = new AnalyseString(k);
            setTextTH1();
        }
    }

    public void setTextTH1(){
        if (k == 2){
            baseView_02.setText(analyseString.result()[0]);
            baseView_04.setText(analyseString.result()[1]);
            baseView_05.setText(analyseString.result()[2]);
            baseView_07.setText("");
        }else if (k==1){
            baseView_02.setText(analyseString.result()[0]);
            baseView_04.setText(analyseString.result()[1]);
            baseView_05.setText("");
            baseView_07.setText("");
        }else if (k==0){
            baseView_02.setText(analyseString.result()[0]);
            baseView_04.setText("");
            baseView_05.setText("");
            baseView_07.setText("");
        }
    }

    public void setTextTH2(){
        if (baseView_02 != null && baseView_04 != null && baseView_05 != null&& baseView_07 != null){
            baseView_02.setText(analyseString.result()[0]);
            baseView_04.setText(analyseString.result()[1]);
            baseView_05.setText(analyseString.result()[2]);
            baseView_07.setText(analyseString.result()[3]);
        }
    }


}
