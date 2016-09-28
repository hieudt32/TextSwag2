package com.word.swag.text.View.Style.TemplatePurchase;

import android.content.Context;
import android.view.Gravity;
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
 * Created by ThanhDat on 1/8/16.
 */
public class MyStyleViewTwentyTwo extends MyStyleBaseView {

    public MyStyleViewTwentyTwo myStyleViewTwentyTwo;
    public int Width = MainActivity.sizeNew * 2 / 3;
    public int rlHeight = MainActivity.sizeNew * 2 / 3;
    public int rlWidth = Width * 9 / 10;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_line_01, baseView_line_02, baseView_line_03, baseView_line_04, baseView_line_05, baseView_line_06;
    public MyBaseView baseView_01, baseView_02, baseView_03, baseView_04;
    public MyBaseView baseView_drawable, baseViewBg;;
    public FrameLayout.LayoutParams layoutParams;
    public Params params;
    private int drawable;

    public MyStyleViewTwentyTwo(Context context) {
        super(context);
        myStyleViewTwentyTwo = this;
        setBaseViewBg(context);
        init();
    }

    public void init(){
        viewLine_top_left();
        customViewOne();
        viewLine_top_right();
        customViewTwo();
//        viewLine_center_left();
        customViewThree();
//        viewLine_center_right();
//        customViewFour();
//        viewLine_bottom_left();
        customViewDrawable();
//        viewLine_bottom_right();
        checkText();
    }

    public void viewLine_top_left(){
        params = new Params();
        params.setWidth(rlWidth * 165 / 456);
        params.setHeight(rlHeight * 70 / 600);
        params.setBackgroundColor(TextToolFragment.getColor());
        baseView_line_01 = new MyBaseView(MainActivity.getmContext(), params);
        baseView_line_01.setmDrawObject(R.mipmap.temp22_left);
        baseView_line_01.setDrawableColor(R.mipmap.temp22_left, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 165 / 456, rlHeight * 70 / 600);
        layoutParams.setMargins(rlWidth / 20, rlHeight * 60 / 600, rlWidth * 291 /456, 0);
        myStyleViewTwentyTwo.addView(baseView_line_01, layoutParams);

    }

    public void customViewOne(){
        params =  new Params();
        params.setWidth(rlWidth * 126 / 456);
        params.setHeight(rlHeight * 70 / 600);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 126 / 456, rlHeight * 70 / 600);
        layoutParams.setMargins(rlWidth * 165 / 456 + rlWidth / 20, rlHeight * 50 / 600, rlWidth * 165 / 456, 0);
        myStyleViewTwentyTwo.addView(baseView_01, layoutParams);
    }

    public void viewLine_top_right(){
        params = new Params();
        params.setWidth(rlWidth * 165 / 456);
        params.setHeight(rlHeight * 70 / 600);
        params.setBackgroundColor(TextToolFragment.getColor());
        baseView_line_02 = new MyBaseView(MainActivity.getmContext(), params);
        baseView_line_02.setmDrawObject(R.mipmap.temp22_right);
        baseView_line_02.setDrawableColor(R.mipmap.temp22_right, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 165 / 456, rlHeight * 70 / 600);
        layoutParams.setMargins(rlWidth * 291 / 456 + rlWidth / 20, rlHeight * 60 / 600, 0, 0);
        myStyleViewTwentyTwo.addView(baseView_line_02, layoutParams);

    }

    public void customViewTwo(){
        params =  new Params();
        params.setWidth(rlWidth * 8 / 10);
        params.setHeight(rlHeight / 3);
        params.setPaddingBottom(10);
        params.setPaddingTop(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 8 / 10, rlHeight / 3);
        layoutParams.setMargins(rlWidth / 10 + rlWidth / 20, rlHeight * 130 / 600, rlWidth / 10, 0);
        myStyleViewTwentyTwo.addView(baseView_02, layoutParams);
    }

//    public void viewLine_center_left(){
//        params = new Params();
//        params.setWidth(rlWidth * 100 / 456);
//        params.setHeight(rlHeight * 10 / 600);
//        params.setBackgroundColor(TextToolFragment.getColor());
//        baseView_line_03 = new MyBaseView(MainActivity.getmContext(), params);
//        baseView_line_03.setmDrawObject(R.mipmap.waves);
//        layoutParams = new FrameLayout.LayoutParams(rlWidth * 100 / 456, rlHeight * 10 / 600);
//        layoutParams.setMargins(0, rlHeight * 70 / 600 + rlHeight / 3 + rlHeight * 35 / 600, rlWidth * 356 /456, 0);
//        myStyleViewTwentyTwo.addView(baseView_line_03, layoutParams);
//
//    }

    public void customViewThree(){
        params =  new Params();
        params.setWidth(rlWidth * 256 / 456);
        params.setHeight(rlHeight * 70 / 600);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_03 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 256 / 456, rlHeight * 70 / 600);
        layoutParams.setMargins(rlWidth * 100 / 456 + rlWidth / 20, rlHeight * 130 / 600 + rlHeight / 3, rlWidth * 100 / 456, 0);
        myStyleViewTwentyTwo.addView(baseView_03, layoutParams);
    }

//    public void viewLine_center_right(){
//        params = new Params();
//        params.setWidth(rlWidth * 100 / 456);
//        params.setHeight(rlHeight * 10 / 600);
//        params.setBackgroundColor(TextToolFragment.getColor());
//        baseView_line_04 = new MyBaseView(MainActivity.getmContext(), params);
//        baseView_line_04.setmDrawObject(R.mipmap.waves);
//        layoutParams = new FrameLayout.LayoutParams(rlWidth * 100 / 456, rlHeight * 10 / 600);
//        layoutParams.setMargins(rlWidth * 356 / 456, rlHeight * 70 / 600 + rlHeight / 3 + rlHeight * 35 / 600, 0, 0);
//        myStyleViewTwentyTwo.addView(baseView_line_04, layoutParams);
//
//    }

//    public void customViewFour(){
//        params =  new Params();
//        params.setWidth(rlWidth);
//        params.setHeight(rlHeight * 180 / 600);
//        params.setPaddingBottom(10);
//        params.setPaddingRight(10);
//        params.setPaddingLeft(10);
//        params.setTypeface(mFont.getRandomTypeface());
//        baseView_04 = new MyBaseView(MainActivity.getmContext(), params);
//        layoutParams = new FrameLayout.LayoutParams(rlWidth, rlHeight * 180 / 600);
//        layoutParams.setMargins(0, rlHeight * 140 / 600 + rlHeight / 3, 0, 0);
//        myStyleViewTwentyTwo.addView(baseView_04, layoutParams);
//    }

//    public void viewLine_bottom_left(){
//        params = new Params();
//        params.setWidth(rlWidth * 178 / 456);
//        params.setHeight(rlHeight * 10 / 600);
//        params.setPaddingRight(5);
//        params.setBackgroundColor(TextToolFragment.getColor());
//        baseView_line_05 = new MyBaseView(MainActivity.getmContext(), params);
//        baseView_line_05.setmDrawObject(R.mipmap.waves);
//        baseView_line_05.setDrawableColor(R.mipmap.waves, TextToolFragment.getColor());
//        layoutParams = new FrameLayout.LayoutParams(rlWidth * 178 / 456, rlHeight * 10 / 600);
//        layoutParams.setMargins(0, rlHeight * 355 / 600 + rlHeight / 3, rlWidth * 278 /456, 0);
//        myStyleViewTwentyTwo.addView(baseView_line_05, layoutParams);
//
//    }

    public void customViewDrawable(){
        params =  new Params();
        params.setWidth(rlWidth * 200 / 456);
        params.setHeight(rlHeight * 150 / 600);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_drawable = new MyBaseView(MainActivity.getmContext(), params);
        baseView_drawable.setmDrawObject(R.mipmap.temp22_bottom);
        baseView_drawable.setDrawableColor(R.mipmap.temp22_bottom, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 200 / 456, rlHeight * 150 / 600);
        layoutParams.setMargins(rlWidth * 128 / 456 + rlWidth / 20, rlHeight * 200 / 600 + rlHeight / 3, rlWidth * 128 / 456, 0);
        myStyleViewTwentyTwo.addView(baseView_drawable, layoutParams);
    }

//    public void viewLine_bottom_right(){
//        params = new Params();
//        params.setWidth(rlWidth * 178 / 456);
//        params.setHeight(rlHeight * 10 / 600);
//        params.setPaddingLeft(5);
//        params.setBackgroundColor(TextToolFragment.getColor());
//        baseView_line_06 = new MyBaseView(MainActivity.getmContext(), params);
//        baseView_line_06.setmDrawObject(R.mipmap.waves);
//        baseView_line_06.setDrawableColor(R.mipmap.waves, TextToolFragment.getColor());
//        layoutParams = new FrameLayout.LayoutParams(rlWidth * 178 / 456, rlHeight * 10 / 600);
//        layoutParams.setMargins(rlWidth * 278 / 456, rlHeight * 355 / 600 + rlHeight / 3, 0, 0);
//        myStyleViewTwentyTwo.addView(baseView_line_06, layoutParams);
//
//    }

    //background
    public void setBaseViewBg(Context context){
        params = new Params();
        baseViewBg = new MyBaseView(context, params);
        drawable = R.mipmap.temp22_bg;
        baseViewBg.setBackgroundResource(drawable);
        baseViewBg.setDrawableColor(drawable, TextToolFragment.getColor());
        layoutParams = new LayoutParams(Width, rlHeight);
        layoutParams.gravity = Gravity.CENTER;
        myStyleViewTwentyTwo.addView(baseViewBg, layoutParams);
    }



    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null){
            baseView_01.setTextOpacity(value);
            baseView_02.setTextOpacity(value);
            baseView_03.setTextOpacity(value);
//            baseView_04.setAlpha(value);
        }

        if (baseView_line_01 != null && baseView_line_02 != null &&  baseView_drawable != null){
            baseView_line_01.setTextOpacity(value);
            baseView_line_02.setTextOpacity(value);
//            baseView_line_03.setAlpha(value);
//            baseView_line_04.setAlpha(value);
//            baseView_line_05.setAlpha(value);
//            baseView_line_06.setAlpha(value);
            baseView_drawable.setTextOpacity(value);
            baseViewBg.setTextOpacity(value);
        }
    }

    @Override
    public void onColorChange(int color) {
        super.onColorChange(color);

        if (baseView_01 != null && baseView_02 != null && baseView_03 != null){
            baseView_01.setTextColor(color);
            baseView_02.setTextColor(color);
            baseView_03.setTextColor(color);
//            baseView_04.setTextColor(color);
            baseViewBg.setDrawableColor(drawable, color);
        }

        if (baseView_line_01 != null && baseView_line_02 != null && baseView_drawable != null){
            baseView_line_01.setDrawableColor(R.mipmap.temp22_left, color);
            baseView_line_02.setDrawableColor(R.mipmap.temp22_right, color);
//            baseView_line_03.setDrawableColor(R.mipmap.waves, color);
//            baseView_line_04.setDrawableColor(R.mipmap.waves, color);
//            baseView_line_05.setDrawableColor(R.mipmap.waves, color);
//            baseView_line_06.setDrawableColor(R.mipmap.waves, color);
            baseView_drawable.setDrawableColor(R.mipmap.temp22_bottom, color);
        }
    }

    @Override
    public void onShadowChange(int shading, int color) {
        super.onShadowChange(shading, color);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null) {
            baseView_01.setTextShadow(shading, color);
            baseView_02.setTextShadow(shading, color);
            baseView_03.setTextShadow(shading, color);
//            baseView_04.setTextShadow(shading, color);
        }

        if (baseView_line_01 != null && baseView_line_02 != null && baseView_drawable != null){
            baseView_line_01.setTextShadow(shading, color);
            baseView_line_02.setTextShadow(shading, color);
//            baseView_line_03.setTextShadow(shading, color);
//            baseView_line_04.setTextShadow(shading, color);
//            baseView_line_05.setTextShadow(shading, color);
//            baseView_line_06.setTextShadow(shading, color);
            baseView_drawable.setTextShadow(shading, color);
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
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText("");
        }else if (k==0){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText("");
            baseView_03.setText("");
        }
    }

    public void setTextTH2(){
        if (baseView_01 != null && baseView_03 != null){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
        }
    }
}
