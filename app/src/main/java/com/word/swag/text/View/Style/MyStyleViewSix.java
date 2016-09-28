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
 * Created by ThanhDat on 12/23/15.
 */
public class MyStyleViewSix extends MyStyleBaseView {

    public MyStyleViewSix myStyleViewSix;
    public int Width = MainActivity.sizeNew / 2;
    public int Height = MainActivity.sizeNew * 2 / 3;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03, baseView_04, baseView_05;
    public Params params;
    public FrameLayout.LayoutParams layoutParams;

    public MyStyleViewSix(Context context) {
        super(context);
        myStyleViewSix = this;
        init();
    }

    public void init(){
        customViewOne();
        customViewTwo();
        customviewThree();
        customviewFour();
        customviewFive();
        checkText();
    }

    public void customViewOne(){
        params =  new Params();
        params.setWidth(Width);
        params.setHeight(Height / 5);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params);
        myStyleViewSix.addView(baseView_01, Width, Height / 5);
    }

    public void customViewTwo(){
        params =  new Params();
        params.setWidth(Width / 2);
        params.setHeight(Height * 2 / 15);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width / 2, Height * 2/15);
        layoutParams.setMargins(0, Height / 5, Width / 2, 0);
        myStyleViewSix.addView(baseView_02, layoutParams);
    }

    public void customviewThree(){
        params =  new Params();
        params.setWidth(Width / 2);
        params.setHeight(Height * 4 / 15);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_03 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width / 2, Height * 4/15);
        layoutParams.setMargins(0, Height * 5 / 15, Width / 2, 0);
        myStyleViewSix.addView(baseView_03, layoutParams);
    }

    public void customviewFour(){
        params =  new Params();
        params.setWidth(Width / 2);
        params.setHeight(Height * 2 / 5);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_04 = new MyBaseView(MainActivity.getmContext(), params);
        baseView_04.setmDrawObject(params.getDrawable());
        baseView_04.setDrawableColor(TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(Width / 2, Height * 2/5);
        layoutParams.setMargins(Width / 2, Height / 5, 0, 0);
        myStyleViewSix.addView(baseView_04, layoutParams);
    }

    public void customviewFive(){
        params =  new Params();
        params.setWidth(Width);
        params.setHeight(Height * 2 / 5);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_05 = new MyBaseView(MainActivity.getmContext(), params);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Width, Height * 2 / 5);
        layoutParams.setMargins(0, Height * 3 / 5, 0, 0);
        myStyleViewSix.addView(baseView_05, layoutParams);
    }

    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 !=null && baseView_05 != null) {
            baseView_01.setAlpha(value);
            baseView_02.setAlpha(value);
            baseView_03.setAlpha(value);
            baseView_04.setAlpha(value);
            baseView_05.setAlpha(value);
        }
    }

    @Override
    public void onColorChange(int color) {
        super.onColorChange(color);

        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 != null && baseView_05 != null){
            baseView_01.setTextColor(color);
            baseView_02.setTextColor(color);
            baseView_03.setTextColor(color);
            baseView_04.setDrawableColor(color);
            baseView_05.setTextColor(color);
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
            baseView_05.setText("");
        }else if (k==1){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText("");
            baseView_05.setText("");
        }else if (k==0){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText("");
            baseView_03.setText("");
            baseView_05.setText("");
        }
    }

    public void setTextTH2(){
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null&& baseView_05 != null){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
            baseView_05.setText(analyseString.result()[3]);
        }
    }


}
