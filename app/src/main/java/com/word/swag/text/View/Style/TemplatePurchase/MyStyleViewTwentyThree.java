package com.word.swag.text.View.Style.TemplatePurchase;

import android.content.Context;
import android.view.Gravity;

import com.word.swag.text.Activity.MainActivity;
import com.word.swag.text.Fragment.TextToolFragment;
import com.word.swag.text.Params.Params;
import com.word.swag.text.StringText.AnalyseString;
import com.word.swag.text.StringText.Calculate;
import com.word.swag.text.Utils.Fonts;
import com.word.swag.text.Utils.ImageSmall;
import com.word.swag.text.View.MyBaseView;
import com.word.swag.text.View.MyStyleBaseView;

/**
 * Created by company on 8/26/16.
 */
public class MyStyleViewTwentyThree extends MyStyleBaseView {

    public MyStyleViewTwentyThree myStyleViewTwentyThree;
    public int Width = MainActivity.sizeNew / 2;
    public int Height = MainActivity.sizeNew / 2;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03, baseView_04;
    public MyBaseView baseViewBg;
    public Params params;
    public LayoutParams layoutParams;
    public int drawable;

    public MyStyleViewTwentyThree(Context context) {
        super(context);
        myStyleViewTwentyThree = this;
        setBaseViewBg(context);
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
        params =  new Params();
        params.setWidth(Width / 2);
        params.setHeight(Height / 10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new LayoutParams(Width / 2, Height / 10);
        layoutParams.setMargins(Width / 4, Height / 5, Width / 4, 0);
        myStyleViewTwentyThree.addView(baseView_01, layoutParams);
    }

    public void customViewTwo(){
        params = new Params();
        params.setWidth(Width * 2 / 3);
        params.setHeight(Height / 6);
        params.setPaddingBottom(10);
        params.setPaddingTop(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new LayoutParams(Width * 2 / 3, Height / 6);
        layoutParams.setMargins(Width / 6, Height / 3, Width / 6, 0);
        myStyleViewTwentyThree.addView(baseView_02, layoutParams);
    }

    public void customViewThree(){
        params = new Params();
        params.setWidth(Width / 2);
        params.setHeight(Height / 6);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_03 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new LayoutParams(Width / 2, Height / 6);
        layoutParams.setMargins(Width / 4, Height / 2, Width / 4, 0);
        myStyleViewTwentyThree.addView(baseView_03, layoutParams);
    }

    public void customViewFour(){
        params = new Params();
        params.setWidth(Width / 2);
        params.setHeight(Height / 10);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_04 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new LayoutParams(Width / 2, Height / 10);
        layoutParams.setMargins(Width / 4, Height * 2 / 3, Width / 4, 0);
        myStyleViewTwentyThree.addView(baseView_04, layoutParams);
    }

    public int getDrawable(){
        return new ImageSmall().getRandomTemp23();
    }

    //background
    public void setBaseViewBg(Context context){
        params = new Params();
        baseViewBg = new MyBaseView(context, params);
        drawable = getDrawable();
        baseViewBg.setBackgroundResource(drawable);
        baseViewBg.setDrawableColor(drawable, TextToolFragment.getColor());
        layoutParams = new LayoutParams(Width, Height);
        layoutParams.gravity = Gravity.CENTER;
        myStyleViewTwentyThree.addView(baseViewBg, layoutParams);
    }


    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 != null){
            baseView_01.setTextOpacity(value);
            baseView_02.setTextOpacity(value);
            baseView_03.setTextOpacity(value);
            baseView_04.setTextOpacity(value);
            baseViewBg.setTextOpacity(value);
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
            baseViewBg.setDrawableColor(drawable, color);
        }
    }

    @Override
    public void onShadowChange(int shading, int color) {
        super.onShadowChange(shading, color);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 != null) {
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
        }else if (k == 1) {
            baseView_03.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_01.setText("");
            baseView_04.setText("");
        }else if (k==0){
            baseView_02.setText(analyseString.result()[0]);
            baseView_01.setText("");
            baseView_03.setText("");
            baseView_04.setText("");
        }
    }

    public void setTextTH2(){
        if (baseView_01 != null && baseView_03 != null){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
            baseView_04.setText(analyseString.result()[3]);
        }
    }

}
