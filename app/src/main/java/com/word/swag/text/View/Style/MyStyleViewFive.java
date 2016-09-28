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
 * Created by ThanhDat on 12/15/15.
 */
public class MyStyleViewFive extends MyStyleBaseView{

    public MyStyleViewFive myStyleViewFive;
    public int rlWidth = MainActivity.sizeNew / 2;
    public int rlHeight = MainActivity.sizeNew * 2 / 3;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03, baseView_04;
    public Params params;
    public FrameLayout.LayoutParams layoutParams;

    public MyStyleViewFive(Context context) {
        super(context, null, 0);
        myStyleViewFive = this;
        init();

    }

    public void init(){
        customViewOne();
        customViewTwo();
        customviewThree();
        customviewFour();
        checkText();
    }
    public void customViewOne(){
        params =  new Params();
        params.setWidth(rlHeight);
        params.setHeight(rlHeight / 3);
        params.setRotation(-90.0f);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params);
        myStyleViewFive.addView(baseView_01, rlHeight, rlHeight / 3);
    }

    public void customViewTwo(){
        params =  new Params();
        params.setWidth(rlWidth - rlHeight / 3);
        params.setHeight(rlHeight / 6);
        params.setPaddingBottom(5);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth - rlHeight / 3, rlHeight / 6);
        layoutParams.setMargins(rlHeight / 3, 0, 0, 0);
        myStyleViewFive.addView(baseView_02, layoutParams);
    }

    public void customviewThree(){
        params = new Params();
        params.setWidth(rlWidth - rlHeight / 3);
        params.setHeight(rlHeight / 2);
        params.setPaddingBottom(5);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_03 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth - rlHeight/3, rlHeight/2);
        layoutParams.setMargins(rlHeight / 3, rlHeight / 6, 0, 0);
        myStyleViewFive.addView(baseView_03, layoutParams);
    }

    public void customviewFour(){
        params = new Params();
        params.setWidth(rlWidth - rlHeight / 3);
        params.setHeight(rlHeight / 3);
        params.setPaddingBottom(5);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_04 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth - rlHeight/3, rlHeight/3);
        layoutParams.setMargins(rlHeight / 3, rlHeight * 2 / 3, 0, 0);
        myStyleViewFive.addView(baseView_04, layoutParams);
    }

    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 !=null) {
            baseView_01.setAlpha(value);
            baseView_02.setAlpha(value);
            baseView_03.setAlpha(value);
            baseView_04.setAlpha(value);
        }
    }

    @Override
    public void onColorChange(int color) {
        super.onColorChange(color);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 !=null) {
            baseView_01.setTextColor(color);
            baseView_02.setTextColor(color);
            baseView_03.setTextColor(color);
            baseView_04.setTextColor(color);
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
