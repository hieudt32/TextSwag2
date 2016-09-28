package com.word.swag.text.View.Style;

import android.content.Context;
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
 * Created by ThanhDat on 1/18/16.
 */
public class MyStyleViewThree extends MyStyleBaseView {

    public MyStyleViewThree myStyleViewThree;
    public int rlWidth = MainActivity.sizeNew * 4/ 5;
    public int rlHeight = MainActivity.sizeNew / 3;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03;
    public Params params;
    public FrameLayout.LayoutParams layoutParams;

    public MyStyleViewThree(Context context) {
        super(context);
        myStyleViewThree = this;
        init();
    }

    public void init(){
        customViewOne();
        customViewTwo();
        customViewThree();
        checkText();
    }

    public void customViewOne(){
        params =  new Params();
        params.setWidth(rlWidth / 2);
        params.setHeight(rlHeight / 2 - 10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        if (baseView_01 == null)baseView_01 = new MyBaseView(MainActivity.getmContext(), params);
        myStyleViewThree.addView(baseView_01, rlWidth / 2, rlHeight / 2 - 10);
    }

    public void customViewTwo(){
        params =  new Params();
        params.setWidth(rlWidth);
        params.setHeight(4);
        params.setPaddingTop(10);
        if (baseView_02 == null)baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        baseView_02.setBackGroundColor(TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(rlWidth, 4);
        layoutParams.setMargins(0, rlHeight / 2, 0, 0);
        myStyleViewThree.addView(baseView_02, layoutParams);
    }

    public void customViewThree(){
        params =  new Params();
        params.setWidth(rlWidth / 2);
        params.setHeight(rlHeight / 2 - 10);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        if (baseView_03 == null)baseView_03 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth /2, rlHeight / 2 - 10);
        layoutParams.setMargins(rlWidth/ 2, rlHeight / 2 + 14, 0, 0);
        myStyleViewThree.addView(baseView_03, layoutParams);
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
            baseView_02.setBackGroundColor(color);
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
        if (k >= 1){
            analyseString = new AnalyseString(1);
            setTextTH2();
        }else {
            analyseString = new AnalyseString(k);
            setTextTH1();
        }
    }

    public void setTextTH1(){
        if (k == 0) {
            baseView_01.setText(analyseString.result()[0]);
            baseView_03.setText("");
        }
    }

    public void setTextTH2(){
        if (baseView_01 != null && baseView_03 != null){
            baseView_01.setText(analyseString.result()[0]);
            baseView_03.setText(analyseString.result()[1]);
        }
    }


}
