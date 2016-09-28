package com.word.swag.text.View.Style;

import android.content.Context;
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
 * Created by ThanhDat on 1/17/16.
 */
public class MyStyleViewNine extends MyStyleBaseView {
    public MyStyleViewNine myStyleViewNine;
    public int rlWidth = MainActivity.sizeNew * 2 / 3;
    public int rlHeight = MainActivity.sizeNew * 2 / 3;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_image, baseView_01, baseView_02, baseView_03, baseView_04;
    public FrameLayout.LayoutParams layoutParams;
    public Params params;

    public MyStyleViewNine(Context context) {
        super(context);
        myStyleViewNine = this;
        init();
    }

    public void init(){
        viewImage();
        customViewOne();
        customViewTwo();
        customViewThree();
        customviewFour();
        checkText();
    }

    public void viewImage(){
        params =  new Params();
        params.setWidth(rlWidth / 2);
        params.setHeight(rlHeight);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        baseView_image = new MyBaseView(MainActivity.getmContext(), params);
        baseView_image.setmDrawObject(new ImageSmall().getRandomImagePortrait());
        baseView_image.setDrawableColor(TextToolFragment.getColor());
        myStyleViewNine.addView(baseView_image, rlWidth / 2, rlHeight);
    }

    public void customViewOne(){
        params =  new Params();
        params.setWidth(rlWidth / 2);
        params.setHeight(rlHeight / 4);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth / 2, rlHeight / 4);
        layoutParams.setMargins(rlWidth / 2, 0, 0, 0);
        myStyleViewNine.addView(baseView_01, layoutParams);
    }

    public void customViewTwo(){
        params =  new Params();
        params.setWidth(rlWidth / 2);
        params.setHeight(rlHeight / 4);
        params.setPaddingBottom(10);
        params.setPaddingTop(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth / 2, rlHeight / 4);
        layoutParams.setMargins(rlWidth / 2, rlHeight/ 4, 0, 0);
        myStyleViewNine.addView(baseView_02, layoutParams);
    }

    public void customViewThree(){
        params =  new Params();
        params.setWidth(rlWidth / 2);
        params.setHeight(rlHeight / 4);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_03 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth / 2, rlHeight / 4);
        layoutParams.setMargins(rlWidth / 2, rlHeight / 2, 0, 0);
        myStyleViewNine.addView(baseView_03, layoutParams);
    }
    public void customviewFour(){
        params = new Params();
        params.setWidth(rlWidth /2);
        params.setHeight(rlHeight / 4);
        params.setPaddingBottom(5);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_04 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth / 2, rlHeight/4);
        layoutParams.setMargins(rlWidth / 2, rlHeight * 3 / 4, 0, 0);
        myStyleViewNine.addView(baseView_04, layoutParams);
    }

    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null){
            baseView_01.setTextOpacity(value);
            baseView_02.setTextOpacity(value);
            baseView_03.setTextOpacity(value);
            baseView_04.setTextOpacity(value);
            baseView_image.setTextOpacity(value);
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
            baseView_image.setDrawableColor(color);
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
            baseView_image.setTextShadow(shading, color);
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
