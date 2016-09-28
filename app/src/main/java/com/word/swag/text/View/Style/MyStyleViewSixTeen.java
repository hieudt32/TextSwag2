package com.word.swag.text.View.Style;

import android.content.Context;
import android.graphics.Color;

import com.word.swag.text.Activity.MainActivity;
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
public class MyStyleViewSixTeen extends MyStyleBaseView {

    public MyStyleViewSixTeen myStyleViewSixTeen;
    public int rlWidth = MainActivity.sizeNew * 2 / 3;
    public int rlHeight = MainActivity.sizeNew / 2;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03, baseView_04;
    public LayoutParams layoutParams;
    public Params params1, params2, params3, params4;

    public MyStyleViewSixTeen(Context context) {
        super(context);
        myStyleViewSixTeen = this;
        init();
    }

    public void init(){
        customViewOne();
        customViewTwo();
        customViewThree();
        customViewFour();
        checkText();
    }

    public void customViewOne(){
        params1 =  new Params();
        params1.setWidth(rlWidth / 2);
        params1.setHeight(rlHeight * 2 / 3);
        params1.setPaddingRight(10);
        params1.setPaddingTop(5);
        params1.setPaddingBottom(5);
        params1.setPaddingLeft(10);
        params1.setTypeface(mFont.getRandomTypeface());
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params1);
        myStyleViewSixTeen.addView(baseView_01, rlWidth / 2, rlHeight * 2 / 3);
    }

    public void customViewTwo(){
        params2 =  new Params();
        params2.setWidth(rlWidth / 2);
        params2.setHeight(rlHeight / 3);
        params2.setPaddingBottom(5);
        params2.setPaddingTop(5);
        params2.setPaddingLeft(10);
        params2.setPaddingRight(10);
        params2.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params2);
        layoutParams = new LayoutParams(rlWidth / 2, rlHeight / 3);
        layoutParams.setMargins(rlWidth / 2, 0, 0, 0);
        myStyleViewSixTeen.addView(baseView_02, layoutParams);
    }

    public void customViewThree(){
        params3 =  new Params();
        params3.setWidth(rlWidth / 2);
        params3.setHeight(rlHeight / 3);
        params3.setPaddingBottom(5);
        params3.setPaddingRight(10);
        params3.setPaddingLeft(10);
        params3.setPaddingTop(5);
        params3.setTypeface(mFont.getRandomTypeface());
        baseView_03 = new MyBaseView(MainActivity.getmContext(), params3);
        layoutParams = new LayoutParams(rlWidth / 2, rlHeight / 3);
        layoutParams.setMargins(rlWidth / 2, rlHeight / 3, 0, 0);
        myStyleViewSixTeen.addView(baseView_03, layoutParams);
    }

    public void customViewFour(){
        params4 =  new Params();
        params4.setWidth(rlWidth);
        params4.setHeight(rlHeight / 3);
        params4.setPaddingBottom(5);
        params4.setPaddingRight(10);
        params4.setPaddingLeft(10);
        params4.setPaddingTop(5);
        params4.setTypeface(mFont.getRandomTypeface());
        baseView_04 = new MyBaseView(MainActivity.getmContext(), params3);
        layoutParams = new LayoutParams(rlWidth, rlHeight / 3);
        layoutParams.setMargins(0, rlHeight * 2 / 3, 0, 0);
        myStyleViewSixTeen.addView(baseView_04, layoutParams);
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
