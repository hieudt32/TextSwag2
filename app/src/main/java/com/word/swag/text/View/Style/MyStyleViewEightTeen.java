package com.word.swag.text.View.Style;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

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
public class MyStyleViewEightTeen extends MyStyleBaseView {

    public MyStyleViewEightTeen myStyleViewEightTeen;
    public int Width = MainActivity.sizeNew / 2;
    public int Height = MainActivity.sizeNew * 7 / 10;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03, baseView_04, baseView_05, baseView_06, baseView_07;
    public MyBaseView baseViewBg;
    public Params params;
    public FrameLayout.LayoutParams layoutParams;

    public MyStyleViewEightTeen(Context context) {
        super(context);
        myStyleViewEightTeen = this;
        setBaseViewBg(context);
        init();
    }

    public void init(){
        customViewOne();
        customViewTwo();
        customviewThree();
        customviewFour();
        customviewFive();
        customviewSix();
        customviewSeven();
//        setBaseViewBg();
        checkText();


    }

    public void customViewOne(){
        params =  new Params();
        params.setWidth(Width * 136 / 243);
        params.setHeight(Height * 34 / 243);
        params.setPaddingTop(10);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width * 136 / 243, Height * 34 / 243);
        layoutParams.setMargins(Width * 53 / 243, Height * 10 / 243, Width * 53 / 243, 0);
        myStyleViewEightTeen.addView(baseView_01, layoutParams);
    }

    public void customViewTwo(){
        params =  new Params();
        params.setWidth(Width * 155 / 243);
        params.setHeight(Height * 34 / 243);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width * 155 / 243, Height * 34 / 243);
        layoutParams.setMargins(Width * 44 / 243, Height * 44 / 243, Width * 44 / 243, 0);
        myStyleViewEightTeen.addView(baseView_02, layoutParams);
    }

    public void customviewThree(){
        params =  new Params();
        params.setWidth(Width * 97 / 243);
        params.setHeight(Height * 34 / 243);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_03 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width * 97 / 243, Height * 34 / 243);
        layoutParams.setMargins(Width * 73 / 243, Height * 78 / 243, Width * 73 / 243, 0);
        myStyleViewEightTeen.addView(baseView_03, layoutParams);
    }

    public void customviewFour(){
        params =  new Params();
        params.setWidth(Width * 215 / 243);
        params.setHeight(Height * 34 / 243);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_04 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width * 215 / 243 , Height * 34 / 243);
        layoutParams.setMargins(Width * 14 / 243, Height * 112 / 243, Width * 14 / 243, 0);
        myStyleViewEightTeen.addView(baseView_04, layoutParams);
    }

    public void customviewFive(){
        params =  new Params();
        params.setWidth(Width * 205 / 243);
        params.setHeight(Height * 34 / 243);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_05 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width * 205 / 243, Height * 34 / 243);
        layoutParams.setMargins(Width * 19 / 243, Height * 146 / 243, Width * 19 / 243, 0);
        myStyleViewEightTeen.addView(baseView_05, layoutParams);
    }

    public void customviewSix(){
        params =  new Params();
        params.setWidth(Width * 169 / 243);
        params.setHeight(Height * 34 / 243);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_06 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width * 169 / 243, Height * 34 / 243);
        layoutParams.setMargins(Width * 37/243, Height * 180 / 243, Width * 37/243, 0);
        myStyleViewEightTeen.addView(baseView_06, layoutParams);
    }

    public void customviewSeven(){
        params =  new Params();
        params.setWidth(Width * 100/243);
        params.setHeight(Height * 20 / 243);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_07 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width * 100/243, Height * 20 / 243);
        layoutParams.setMargins(Width * 71/243, Height * 214 / 243, Width * 71/243, 0);
        myStyleViewEightTeen.addView(baseView_07, layoutParams);
    }

    //background
    public void setBaseViewBg(Context context){
        params = new Params();
        baseViewBg = new MyBaseView(context, params);
        baseViewBg.setBackgroundResource(R.mipmap.border);
        baseViewBg.setDrawableColor(R.mipmap.border, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(Width, Height);
        layoutParams.gravity = Gravity.CENTER;
        myStyleViewEightTeen.addView(baseViewBg, layoutParams);
    }

    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 != null &&
                baseView_05 != null && baseView_06 != null && baseView_07 !=null){
            baseView_01.setAlpha(value);
            baseView_02.setAlpha(value);
            baseView_03.setAlpha(value);
            baseView_04.setAlpha(value);
            baseView_05.setAlpha(value);
            baseView_06.setAlpha(value);
            baseView_07.setAlpha(value);
            baseViewBg.setAlpha(value);
        }
    }

    @Override
    public void onColorChange(int color) {
        super.onColorChange(color);

        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 != null &&
                baseView_05 != null && baseView_06 != null && baseView_07 !=null){
            baseView_01.setTextColor(color);
            baseView_02.setTextColor(color);
            baseView_03.setTextColor(color);
            baseView_04.setTextColor(color);
            baseView_05.setTextColor(color);
            baseView_06.setTextColor(color);
            baseView_07.setTextColor(color);
            baseViewBg.setDrawableColor(R.mipmap.border, color);
        }
    }

    @Override
    public void onShadowChange(int shading, int color) {
        super.onShadowChange(shading, color);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 !=null &&
                baseView_05 != null && baseView_06 != null && baseView_07 !=null) {
            baseView_01.setTextShadow(shading, color);
            baseView_02.setTextShadow(shading, color);
            baseView_03.setTextShadow(shading, color);
            baseView_04.setTextShadow(shading, color);
            baseView_05.setTextShadow(shading, color);
            baseView_06.setTextShadow(shading, color);
            baseView_07.setTextShadow(shading, color);
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
        if (k >= 6){
            analyseString = new AnalyseString(6);
            setTextTH2();
        }else {
            analyseString = new AnalyseString(k);
            setTextTH1();
        }
    }

    public void setTextTH1(){

        if (k==5){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
            baseView_04.setText(analyseString.result()[3]);
            baseView_05.setText(analyseString.result()[4]);
            baseView_06.setText(analyseString.result()[5]);
            baseView_07.setText("");
        }else if (k==4){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
            baseView_04.setText(analyseString.result()[3]);
            baseView_05.setText(analyseString.result()[4]);
            baseView_06.setText("");
            baseView_07.setText("");
        } else if (k == 3){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
            baseView_04.setText(analyseString.result()[3]);
            baseView_05.setText("");
            baseView_06.setText("");
            baseView_07.setText("");
        }else if (k == 2){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
            baseView_04.setText("");
            baseView_05.setText("");
            baseView_06.setText("");
            baseView_07.setText("");
        }else if (k==1){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText("");
            baseView_04.setText("");
            baseView_05.setText("");
            baseView_06.setText("");
            baseView_07.setText("");
        }else if (k==0){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText("");
            baseView_03.setText("");
            baseView_04.setText("");
            baseView_05.setText("");
            baseView_06.setText("");
            baseView_07.setText("");
        }
    }

    public void setTextTH2(){
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null&& baseView_04 != null&& baseView_05 != null){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
            baseView_04.setText(analyseString.result()[3]);
            baseView_05.setText(analyseString.result()[4]);
            baseView_06.setText(analyseString.result()[5]);
            baseView_07.setText(analyseString.result()[6]);
        }
    }
}
