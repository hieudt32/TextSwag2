package com.word.swag.text.View.Style;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;

import com.word.swag.text.Activity.MainActivity;
import com.word.swag.text.Fragment.TextToolFragment;
import com.word.swag.text.Params.Params;
import com.word.swag.text.StringText.AnalyseString;
import com.word.swag.text.StringText.Calculate;
import com.word.swag.text.Utils.Fonts;
import com.word.swag.text.View.MyBaseView;
import com.word.swag.text.View.MyStyleBaseView;

/**
 * Created by ThanhDat on 1/8/16.
 */
public class MyStyleViewFour extends MyStyleBaseView {

    public MyStyleViewFour myStyleViewFour;
    public int rlWidth = MainActivity.sizeNew * 3 / 4;
    public int rlHeight = MainActivity.sizeNew / 2;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03, baseView_04, baseView_05;
    public FrameLayout.LayoutParams layoutParams;
    public Params params;

    public MyStyleViewFour(Context context) {
        super(context);
        myStyleViewFour = this;
        init();
    }

    public void init(){
        customViewOne();
        customViewTwo();
        customViewThree();
        viewLine_bottom_left();
        viewLine_bottom_right();
        checkText();
    }

    public void customViewOne(){
        params =  new Params();
        params.setWidth(rlWidth);
        params.setHeight(rlHeight * 2 / 5);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params);
        myStyleViewFour.addView(baseView_01, rlWidth, rlHeight * 2 / 5);
    }

    public void customViewTwo(){
        params =  new Params();
        params.setWidth(rlWidth * 2/ 3);
        params.setHeight(rlHeight * 2 / 5);
        params.setPaddingBottom(10);
        params.setPaddingTop(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 2/3, rlHeight * 2 / 5);
        layoutParams.setMargins(rlWidth / 6, rlHeight * 2 / 5, rlWidth/6, 0);
        myStyleViewFour.addView(baseView_02, layoutParams);
    }

    public void customViewThree(){
        params =  new Params();
        params.setWidth(rlWidth / 5);
        params.setHeight(rlHeight / 5);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_03 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth / 5, rlHeight/5);
        layoutParams.setMargins(rlWidth * 2/5, rlHeight *4/5, rlWidth * 2/5, 0);
        myStyleViewFour.addView(baseView_03, layoutParams);
    }

    public void viewLine_bottom_left(){
        params = new Params();
        params.setWidth(rlWidth * 2 / 5);
        params.setHeight(rlHeight / 150);
        params.setBackgroundColor(TextToolFragment.getColor());
        baseView_04 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth * 2/5, rlHeight/150);
        layoutParams.setMargins(0, rlHeight *4/5 + rlHeight /10, rlWidth * 2/5, 0);
        myStyleViewFour.addView(baseView_04, layoutParams);

    }

    public void viewLine_bottom_right(){
        params = new Params();
        params.setWidth(rlWidth* 2/5);
        params.setHeight(rlHeight/150);
        params.setBackgroundColor(TextToolFragment.getColor());
        baseView_05 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth*2/5, rlHeight/150);
        layoutParams.setMargins(rlWidth * 3/5, rlHeight *4/5 + rlHeight/10, 0, 0);
        myStyleViewFour.addView(baseView_05, layoutParams);

    }


    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null){
            baseView_01.setTextOpacity(value);
            baseView_02.setTextOpacity(value);
            baseView_03.setTextOpacity(value);
            baseView_04.setTextOpacity(value);
            baseView_05.setTextOpacity(value);
        }
    }

    @Override
    public void onColorChange(int color) {
        super.onColorChange(color);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null){
            baseView_01.setTextColor(color);
            baseView_02.setTextColor(color);
            baseView_03.setTextColor(color);
            baseView_04.setBackGroundColor(color);
            baseView_05.setBackGroundColor(color);
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
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText("");
            baseView_04.setBackGroundColor(Color.TRANSPARENT);
            baseView_05.setBackGroundColor(Color.TRANSPARENT);
        }else if (k==0){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText("");
            baseView_03.setText("");
            baseView_04.setBackGroundColor(Color.TRANSPARENT);
            baseView_05.setBackGroundColor(Color.TRANSPARENT);
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
