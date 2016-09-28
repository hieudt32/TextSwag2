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
 * Created by ThanhDat on 1/8/16.
 */
public class MyStyleViewTwo extends MyStyleBaseView {

    public MyStyleViewTwo myStyleViewTwo;
    public int rlWidth = MainActivity.sizeNew / 2;
    public int rlHeight = MainActivity.sizeNew / 2;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03;
    public FrameLayout.LayoutParams layoutParams;
    public Params params3, params1, params2;

    public MyStyleViewTwo(Context context) {
        super(context);
        myStyleViewTwo = this;
        init();
    }

    public void init(){
        customViewOne();
        customViewTwo();
        customViewThree();
        checkText();
    }

    public void customViewOne(){
        params1 =  new Params();
        params1.setWidth(rlWidth);
        params1.setHeight(rlHeight / 3);
        params1.setPaddingRight(10);
        params1.setPaddingLeft(10);
        params1.setTypeface(mFont.getRandomTypeface());
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params1);
        myStyleViewTwo.addView(baseView_01, rlWidth, rlHeight / 3);
    }

    public void customViewTwo(){
        params2 =  new Params();
        params2.setWidth(rlWidth);
        params2.setHeight(rlHeight / 3);
        params2.setPaddingBottom(10);
        params2.setPaddingTop(10);
        params2.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params2);
        layoutParams = new FrameLayout.LayoutParams(rlWidth, rlHeight / 3);
        layoutParams.setMargins(0, rlHeight / 3, 0, 0);
        myStyleViewTwo.addView(baseView_02, layoutParams);
    }

    public void customViewThree(){
        params3 =  new Params();
        params3.setWidth(rlWidth);
        params3.setHeight(rlHeight / 3);
        params3.setPaddingBottom(10);
        params3.setPaddingRight(10);
        params3.setPaddingLeft(10);
        params3.setTypeface(mFont.getRandomTypeface());
        baseView_03 = new MyBaseView(MainActivity.getmContext(), params3);
        layoutParams = new FrameLayout.LayoutParams(rlWidth, rlHeight/3);
        layoutParams.setMargins(0, rlHeight * 2/3, 0, 0);
        myStyleViewTwo.addView(baseView_03, layoutParams);
    }


    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null){
            baseView_01.setTextOpacity(value);
            baseView_02.setTextOpacity(value);
            baseView_03.setTextOpacity(value);
        }
    }

    @Override
    public void onColorChange(int color) {
        super.onColorChange(color);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null){
            baseView_01.setTextColor(color);
            baseView_02.setTextColor(color);
            baseView_03.setTextColor(color);
        }
    }

    @Override
    public void onShadowChange(int shading, int color) {
        super.onShadowChange(shading, color);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null) {
            baseView_01.setTextShadow(shading, color);
            baseView_02.setTextShadow(shading, color);
            baseView_03.setTextShadow(shading, color);
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
