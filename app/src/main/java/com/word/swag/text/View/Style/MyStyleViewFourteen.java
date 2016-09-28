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
public class MyStyleViewFourteen extends MyStyleBaseView {

    public MyStyleViewFourteen myStyleViewFourteen;
    public int rlWidth = MainActivity.sizeNew / 2;
    public int rlHeight = MainActivity.sizeNew * 2 / 3;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03, baseView_04, baseView_05, baseView_06;
    public FrameLayout.LayoutParams layoutParams;
    public Params params;

    public MyStyleViewFourteen(Context context) {
        super(context);
        myStyleViewFourteen = this;
        init();
    }

    public void init(){
        customViewOne();
        customViewTwo();
        customViewThree();
        customViewFour();
        customViewFive();
        customViewSix();
        checkText();
    }

    public void customViewOne(){
        params = new Params();
        params.setWidth(rlWidth);
        params.setHeight(rlHeight / 6);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params);
        myStyleViewFourteen.addView(baseView_01, rlWidth, rlHeight / 6);
    }

    public void customViewTwo(){
        params = new Params();
        params.setWidth(rlWidth);
        params.setHeight(rlHeight / 6);
        params.setPaddingBottom(10);
        params.setPaddingTop(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth, rlHeight / 6);
        layoutParams.setMargins(0, rlHeight / 6, 0, 0);
        myStyleViewFourteen.addView(baseView_02, layoutParams);
    }

    public void customViewThree(){
        params =  new Params();
        params.setWidth(rlWidth);
        params.setHeight(rlHeight / 6);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_03 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth, rlHeight/6);
        layoutParams.setMargins(0, rlHeight / 3, 0, 0);
        myStyleViewFourteen.addView(baseView_03, layoutParams);
    }

    public void customViewFour(){
        params =  new Params();
        params.setWidth(rlWidth);
        params.setHeight(rlHeight / 6);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_04 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth, rlHeight/6);
        layoutParams.setMargins(0, rlHeight / 2, 0, 0);
        myStyleViewFourteen.addView(baseView_04, layoutParams);
    }
    public void customViewFive(){
        params =  new Params();
        params.setWidth(rlWidth);
        params.setHeight(rlHeight / 6);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_05 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth, rlHeight/6);
        layoutParams.setMargins(0, rlHeight * 2/3, 0, 0);
        myStyleViewFourteen.addView(baseView_05, layoutParams);
    }
    public void customViewSix(){
        params =  new Params();
        params.setWidth(rlWidth);
        params.setHeight(rlHeight / 6);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_06 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(rlWidth, rlHeight/6);
        layoutParams.setMargins(0, rlHeight * 5/6, 0, 0);
        myStyleViewFourteen.addView(baseView_06, layoutParams);
    }


    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 != null && baseView_05 != null && baseView_06 != null){
            baseView_01.setTextOpacity(value);
            baseView_02.setTextOpacity(value);
            baseView_03.setTextOpacity(value);
            baseView_04.setTextOpacity(value);
            baseView_05.setTextOpacity(value);
            baseView_06.setTextOpacity(value);
        }
    }

    @Override
    public void onColorChange(int color) {
        super.onColorChange(color);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 != null && baseView_05 != null && baseView_06 != null){
            baseView_01.setTextColor(color);
            baseView_02.setTextColor(color);
            baseView_03.setTextColor(color);
            baseView_04.setTextColor(color);
            baseView_05.setTextColor(color);
            baseView_06.setTextColor(color);
        }
    }

    @Override
    public void onShadowChange(int shading, int color) {
        super.onShadowChange(shading, color);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 != null && baseView_05 != null && baseView_06 != null) {
            baseView_01.setTextShadow(shading, color);
            baseView_02.setTextShadow(shading, color);
            baseView_03.setTextShadow(shading, color);
            baseView_04.setTextShadow(shading, color);
            baseView_05.setTextShadow(shading, color);
            baseView_06.setTextShadow(shading, color);
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
        if (k >= 5){
            analyseString = new AnalyseString(5);
            setTextTH2();
        }else {
            analyseString = new AnalyseString(k);
            setTextTH1();
        }
    }

    public void setTextTH1(){
        if (k==4){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
            baseView_04.setText(analyseString.result()[3]);
            baseView_05.setText(analyseString.result()[4]);
            baseView_06.setText("");
        }else if (k==3){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
            baseView_04.setText(analyseString.result()[3]);
            baseView_05.setText("");
            baseView_06.setText("");
        }else if (k==2){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
            baseView_04.setText("");
            baseView_05.setText("");
            baseView_06.setText("");
        }else if (k == 1) {
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText("");
            baseView_04.setText("");
            baseView_05.setText("");
            baseView_06.setText("");
        }else if (k==0){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText("");
            baseView_03.setText("");
            baseView_04.setText("");
            baseView_05.setText("");
            baseView_06.setText("");
        }
    }

    public void setTextTH2(){
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 != null && baseView_05 != null && baseView_06 != null){
            baseView_01.setText(analyseString.result()[0]);
            baseView_02.setText(analyseString.result()[1]);
            baseView_03.setText(analyseString.result()[2]);
            baseView_04.setText(analyseString.result()[3]);
            baseView_05.setText(analyseString.result()[4]);
            baseView_06.setText(analyseString.result()[5]);
        }
    }

}
