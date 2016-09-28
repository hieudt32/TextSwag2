package com.word.swag.text.View.Style;

import android.content.Context;
import android.widget.FrameLayout;

import com.word.swag.text.Activity.MainActivity;
import com.word.swag.text.Params.Params;
import com.word.swag.text.StringText.AnalyseString;
import com.word.swag.text.StringText.Calculate;
import com.word.swag.text.Utils.Fonts;
import com.word.swag.text.View.MyBaseView;
import com.word.swag.text.View.MyStyleBaseView;

/**
 * Created by ThanhDat on 1/17/16.
 */
public class MyStyleViewEleven extends MyStyleBaseView {
    public MyStyleViewEleven myStyleViewEleven;
    public int rlWidth = MainActivity.sizeNew * 2 / 3;
    public int rlHeight = MainActivity.sizeNew * 2 / 3;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03, baseView_04;
    public FrameLayout.LayoutParams layoutParams;
    public Params params;

    public MyStyleViewEleven(Context context) {
        super(context);
        myStyleViewEleven = this;
        init();
    }

    public void init(){
        customViewOne();
        customViewTwo();
        customViewThree();
        customviewFour();
        checkText();
    }

    public void customViewOne(){
        params =  new Params();
        params.setWidth(rlWidth * 4 / 5);
        params.setHeight(rlHeight / 4);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setRotation(10f);
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 4 / 5, rlHeight / 4);
        layoutParams.setMargins(rlWidth / 5, 0, 0, 0);
        myStyleViewEleven.addView(baseView_01, layoutParams);
    }

    public void customViewTwo(){
        params =  new Params();
        params.setWidth(rlWidth * 3 / 4);
        params.setHeight(rlHeight * 3 / 8);
        params.setPaddingBottom(10);
        params.setPaddingTop(10);
        params.setRotation(-5f);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 3 / 4, rlHeight * 3/ 8);
        layoutParams.setMargins(0, rlHeight/ 4, rlWidth / 4, 0);
        myStyleViewEleven.addView(baseView_02, layoutParams);
    }

    public void customViewThree(){
        params =  new Params();
        params.setWidth(rlWidth * 3 / 4);
        params.setHeight(rlHeight * 3 / 16);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setRotation(-5f);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_03 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 3 / 4, rlHeight * 3 / 16);
        layoutParams.setMargins(rlWidth / 4, rlHeight * 5 / 8, 0, 0);
        myStyleViewEleven.addView(baseView_03, layoutParams);
    }
    public void customviewFour(){
        params = new Params();
        params.setWidth(rlWidth * 3 / 4);
        params.setHeight(rlHeight * 3 / 16);
        params.setPaddingBottom(5);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setRotation(-5f);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_04 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 3 / 4, rlHeight * 3 / 16);
        layoutParams.setMargins(0, rlHeight * 13 / 16, rlWidth / 4, rlHeight/10);
        myStyleViewEleven.addView(baseView_04, layoutParams);
    }

    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null){
            baseView_01.setTextOpacity(value);
            baseView_02.setTextOpacity(value);
            baseView_03.setTextOpacity(value);
            baseView_04.setTextOpacity(value);
        }
    }

    @Override
    public void onColorChange(int color) {
        super.onColorChange(color);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null){
            baseView_01.setTextColor(color);
            baseView_02.setTextColor(color);
            baseView_03.setTextColor(color);
            baseView_04.setTextColor(color);
        }
    }

    @Override
    public void onShadowChange(int shading, int color) {
        super.onShadowChange(shading, color);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null) {
            baseView_01.setTextShadow(shading, color);
            baseView_02.setTextShadow(shading, color);
            baseView_03.setTextShadow(shading, color);
            baseView_04.setTextShadow(shading, color);
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
