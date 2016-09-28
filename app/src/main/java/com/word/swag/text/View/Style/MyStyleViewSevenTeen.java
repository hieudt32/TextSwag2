package com.word.swag.text.View.Style;

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
 * Created by ThanhDat on 1/8/16.
 */
public class MyStyleViewSevenTeen extends MyStyleBaseView {

    public MyStyleViewSevenTeen myStyleViewSevenTeen;
    public int rlWidth = MainActivity.sizeNew / 2;
    public int rlHeight = MainActivity.sizeNew * 2 / 3;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_line_01, baseView_line_02, baseView_line_03, baseView_line_04, baseView_line_05, baseView_line_06;
    public MyBaseView baseView_01, baseView_02, baseView_03, baseView_04;
    public MyBaseView baseView_drawable;
    public FrameLayout.LayoutParams layoutParams;
    public Params params;

    public MyStyleViewSevenTeen(Context context) {
        super(context);
        myStyleViewSevenTeen = this;
        init();
    }

    public void init(){
        viewLine_top_left();
        customViewOne();
        viewLine_top_right();
        customViewTwo();
        viewLine_center_left();
        customViewThree();
        viewLine_center_right();
        customViewFour();
        viewLine_bottom_left();
        customViewDrawable();
        viewLine_bottom_right();
        checkText();
    }

    public void viewLine_top_left(){
        params = new Params();
        params.setWidth(rlWidth * 165 / 456);
        params.setHeight(rlHeight * 10 / 600);
        params.setBackgroundColor(TextToolFragment.getColor());
        baseView_line_01 = new MyBaseView(MainActivity.getmContext(), params);
        baseView_line_01.setmDrawObject(R.mipmap.waves);
        baseView_line_01.setDrawableColor(R.mipmap.waves, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 165 / 456, rlHeight * 10 / 600);
        layoutParams.setMargins(0, rlHeight * 35 / 600, rlWidth * 291 /456, 0);
        myStyleViewSevenTeen.addView(baseView_line_01, layoutParams);

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
        layoutParams.setMargins(rlWidth * 165 / 456, 0, rlWidth * 165 / 456, 0);
        myStyleViewSevenTeen.addView(baseView_01, layoutParams);
    }

    public void viewLine_top_right(){
        params = new Params();
        params.setWidth(rlWidth * 165 / 456);
        params.setHeight(rlHeight * 10 / 600);
        params.setBackgroundColor(TextToolFragment.getColor());
        baseView_line_02 = new MyBaseView(MainActivity.getmContext(), params);
        baseView_line_02.setmDrawObject(R.mipmap.waves);
        baseView_line_02.setDrawableColor(R.mipmap.waves, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 165 / 456, rlHeight * 10 / 600);
        layoutParams.setMargins(rlWidth * 291 / 456, rlHeight * 35 / 600, 0, 0);
        myStyleViewSevenTeen.addView(baseView_line_02, layoutParams);

    }

    public void customViewTwo(){
        params =  new Params();
        params.setWidth(rlWidth);
        params.setHeight(rlHeight / 3);
        params.setPaddingBottom(10);
        params.setPaddingTop(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth, rlHeight / 3);
        layoutParams.setMargins(0, rlHeight * 70 / 600, 0, 0);
        myStyleViewSevenTeen.addView(baseView_02, layoutParams);
    }

    public void viewLine_center_left(){
        params = new Params();
        params.setWidth(rlWidth * 100 / 456);
        params.setHeight(rlHeight * 10 / 600);
        params.setBackgroundColor(TextToolFragment.getColor());
        baseView_line_03 = new MyBaseView(MainActivity.getmContext(), params);
        baseView_line_03.setmDrawObject(R.mipmap.waves);
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 100 / 456, rlHeight * 10 / 600);
        layoutParams.setMargins(0, rlHeight * 70 / 600 + rlHeight / 3 + rlHeight * 35 / 600, rlWidth * 356 /456, 0);
        myStyleViewSevenTeen.addView(baseView_line_03, layoutParams);

    }

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
        layoutParams.setMargins(rlWidth * 100 / 456, rlHeight * 70 / 600 + rlHeight / 3, rlWidth * 100 / 456, 0);
        myStyleViewSevenTeen.addView(baseView_03, layoutParams);
    }

    public void viewLine_center_right(){
        params = new Params();
        params.setWidth(rlWidth * 100 / 456);
        params.setHeight(rlHeight * 10 / 600);
        params.setBackgroundColor(TextToolFragment.getColor());
        baseView_line_04 = new MyBaseView(MainActivity.getmContext(), params);
        baseView_line_04.setmDrawObject(R.mipmap.waves);
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 100 / 456, rlHeight * 10 / 600);
        layoutParams.setMargins(rlWidth * 356 / 456, rlHeight * 70 / 600 + rlHeight / 3 + rlHeight * 35 / 600, 0, 0);
        myStyleViewSevenTeen.addView(baseView_line_04, layoutParams);

    }

    public void customViewFour(){
        params =  new Params();
        params.setWidth(rlWidth);
        params.setHeight(rlHeight * 180 / 600);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_04 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth, rlHeight * 180 / 600);
        layoutParams.setMargins(0, rlHeight * 140 / 600 + rlHeight / 3, 0, 0);
        myStyleViewSevenTeen.addView(baseView_04, layoutParams);
    }

    public void viewLine_bottom_left(){
        params = new Params();
        params.setWidth(rlWidth * 178 / 456);
        params.setHeight(rlHeight * 10 / 600);
        params.setPaddingRight(5);
        params.setBackgroundColor(TextToolFragment.getColor());
        baseView_line_05 = new MyBaseView(MainActivity.getmContext(), params);
        baseView_line_05.setmDrawObject(R.mipmap.waves);
        baseView_line_05.setDrawableColor(R.mipmap.waves, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 178 / 456, rlHeight * 10 / 600);
        layoutParams.setMargins(0, rlHeight * 355 / 600 + rlHeight / 3, rlWidth * 278 /456, 0);
        myStyleViewSevenTeen.addView(baseView_line_05, layoutParams);

    }

    public void customViewDrawable(){
        params =  new Params();
        params.setWidth(rlWidth * 100 / 456);
        params.setHeight(rlHeight * 70 / 600);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_drawable = new MyBaseView(MainActivity.getmContext(), params);
        baseView_drawable.setmDrawObject(R.mipmap.anchor);
        baseView_drawable.setDrawableColor(R.mipmap.anchor, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 100 / 456, rlHeight * 70 / 600);
        layoutParams.setMargins(rlWidth * 178 / 456, rlHeight * 320 / 600 + rlHeight / 3, rlWidth * 178 / 456, 0);
        myStyleViewSevenTeen.addView(baseView_drawable, layoutParams);
    }

    public void viewLine_bottom_right(){
        params = new Params();
        params.setWidth(rlWidth * 178 / 456);
        params.setHeight(rlHeight * 10 / 600);
        params.setPaddingLeft(5);
        params.setBackgroundColor(TextToolFragment.getColor());
        baseView_line_06 = new MyBaseView(MainActivity.getmContext(), params);
        baseView_line_06.setmDrawObject(R.mipmap.waves);
        baseView_line_06.setDrawableColor(R.mipmap.waves, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 178 / 456, rlHeight * 10 / 600);
        layoutParams.setMargins(rlWidth * 278 / 456, rlHeight * 355 / 600 + rlHeight / 3, 0, 0);
        myStyleViewSevenTeen.addView(baseView_line_06, layoutParams);

    }


    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 != null){
            baseView_01.setAlpha(value);
            baseView_02.setAlpha(value);
            baseView_03.setAlpha(value);
            baseView_04.setAlpha(value);
        }

        if (baseView_line_01 != null && baseView_line_02 != null && baseView_line_03 != null && baseView_line_04 != null &&
            baseView_line_05 != null && baseView_line_06 != null && baseView_drawable != null){
            baseView_line_01.setAlpha(value);
            baseView_line_02.setAlpha(value);
            baseView_line_03.setAlpha(value);
            baseView_line_04.setAlpha(value);
            baseView_line_05.setAlpha(value);
            baseView_line_06.setAlpha(value);
            baseView_drawable.setAlpha(value);
        }
    }

    @Override
    public void onColorChange(int color) {
        super.onColorChange(color);

        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 != null){
            baseView_01.setTextColor(color);
            baseView_02.setTextColor(color);
            baseView_03.setTextColor(color);
            baseView_04.setTextColor(color);
        }

        if (baseView_line_01 != null && baseView_line_02 != null && baseView_line_03 != null && baseView_line_04 != null &&
                baseView_line_05 != null && baseView_line_06 != null && baseView_drawable != null){
            baseView_line_01.setDrawableColor(R.mipmap.waves, color);
            baseView_line_02.setDrawableColor(R.mipmap.waves, color);
            baseView_line_03.setDrawableColor(R.mipmap.waves, color);
            baseView_line_04.setDrawableColor(R.mipmap.waves, color);
            baseView_line_05.setDrawableColor(R.mipmap.waves, color);
            baseView_line_06.setDrawableColor(R.mipmap.waves, color);
            baseView_drawable.setDrawableColor(R.mipmap.anchor, color);
        }
    }

    @Override
    public void onShadowChange(int shading, int color) {
        super.onShadowChange(shading, color);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 !=null) {
            baseView_01.setTextShadow(shading, color);
            baseView_02.setTextShadow(shading, color);
            baseView_03.setTextShadow(shading, color);
            baseView_04.setTextShadow(shading, color);
        }

        if (baseView_line_01 != null && baseView_line_02 != null && baseView_line_03 != null && baseView_line_04 != null &&
                baseView_line_05 != null && baseView_line_06 != null && baseView_drawable != null){
            baseView_line_01.setTextShadow(shading, color);
            baseView_line_02.setTextShadow(shading, color);
            baseView_line_03.setTextShadow(shading, color);
            baseView_line_04.setTextShadow(shading, color);
            baseView_line_05.setTextShadow(shading, color);
            baseView_line_06.setTextShadow(shading, color);
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
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
            baseView_04.setText("");
        }else if (k==1){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText("");
            baseView_04.setText("");
        }else if (k==0){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText("");
            baseView_03.setText("");
            baseView_04.setText("");
        }
    }

    public void setTextTH2(){
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null&& baseView_04 != null){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
            baseView_04.setText(analyseString.result()[3]);
        }
    }
}
