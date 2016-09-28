package com.word.swag.text.View.Style.TemplatePurchase;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;

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
public class MyStyleViewTwentyFour extends MyStyleBaseView{
    public MyStyleViewTwentyFour myStyleViewTwentyFour;
    public int rlWidth = MainActivity.sizeNew / 2;
    public int rlHeight = MainActivity.sizeNew / 2;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03;
    public MyBaseView baseView_bg;
    public Params params;
    public FrameLayout.LayoutParams layoutParams;
    public int drawable;

    public MyStyleViewTwentyFour(Context context) {
        super(context);
        myStyleViewTwentyFour = this;
        this.setBaseViewBg(context);
        init();
    }

    public void init(){
        customViewOne();
        customViewTwo();
        checkText();
    }

    public void customViewOne(){
        params =  new Params();
        params.setWidth(rlWidth / 2);
        params.setHeight(rlHeight / 10);
        params.setPaddingRight(20);
        params.setPaddingLeft(20);
        params.setTypeface(mFont.getRandomTypeface());
        if (baseView_01 == null)baseView_01 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth / 2, rlHeight / 10);
        layoutParams.setMargins(rlWidth / 4, rlHeight * 2 / 5, rlWidth / 4, 0);
        myStyleViewTwentyFour.addView(baseView_01, layoutParams);
    }

    public void customViewTwo(){
        params =  new Params();
        params.setWidth(rlWidth / 2);
        params.setHeight(rlHeight / 10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setPaddingBottom(10);
        params.setTypeface(mFont.getRandomTypeface());
        if (baseView_02 == null)baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth / 2, rlHeight / 10);
        layoutParams.setMargins(rlWidth / 4, rlHeight * 2 / 5 + rlHeight / 10 + rlHeight / 20, rlWidth / 4, 0);
        myStyleViewTwentyFour.addView(baseView_02, layoutParams);
    }

    public int getDrawable(){
        return new ImageSmall().getRandomTemp24();
    }

    //background
    public void setBaseViewBg(Context context){
        params = new Params();
        baseView_bg = new MyBaseView(context, params);
        drawable = getDrawable();
        baseView_bg.setBackgroundResource(drawable);
        baseView_bg.setDrawableColor(drawable, TextToolFragment.getColor());
        layoutParams = new LayoutParams(rlWidth, rlHeight);
        layoutParams.gravity = Gravity.CENTER;
        myStyleViewTwentyFour.addView(baseView_bg, layoutParams);
    }


    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_01 != null && baseView_02 != null){
            baseView_01.setTextOpacity(value);
            baseView_02.setTextOpacity(value);
            baseView_bg.setTextOpacity(value);
        }
    }

    @Override
    public void onColorChange(int color) {
        super.onColorChange(color);
        if (baseView_01 != null && baseView_02 != null){
            baseView_01.setTextColor(color);
            baseView_02.setTextColor(color);
            baseView_bg.setDrawableColor(drawable, color);
        }
    }

    @Override
    public void onShadowChange(int shading, int color) {
        super.onShadowChange(shading, color);
        if (baseView_01 != null && baseView_02 != null) {
            baseView_01.setTextShadow(shading, color);
            baseView_02.setTextShadow(shading, color);
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
            baseView_02.setText("");
        }
    }

    public void setTextTH2(){
        if (baseView_01 != null && baseView_02 != null){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
        }
    }
}
