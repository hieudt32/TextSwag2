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
import com.word.swag.text.Utils.ImageSmall;
import com.word.swag.text.View.MyBaseView;
import com.word.swag.text.View.MyStyleBaseView;

/**
 * Created by ThanhDat on 12/23/15.
 */
public class MyStyleViewSeven extends MyStyleBaseView {

    public MyStyleViewSeven myStyleViewSeven;
    public int Width = MainActivity.sizeNew / 2;
    public int Height = MainActivity.sizeNew * 2 / 3;
    public Fonts mFont = new Fonts();
    int k = Calculate.countSpace(MainActivity.getmText());
    public AnalyseString analyseString;
    public MyBaseView baseView_01, baseView_02, baseView_03, baseView_04, baseView_05, baseView_06,
    baseView_07, baseView_08, baseView_09;
    public Params params_top, params_center, params_bottom;
    public Params params;
    public int drawable1, drawable2, drawable3;
    public FrameLayout.LayoutParams layoutParams;

    public MyStyleViewSeven(Context context) {
        super(context);
        myStyleViewSeven = this;
        init();
    }

    public void init(){
        viewLine_top();
        customViewOne();
        viewLine_center();
        customViewTwo();
        customviewThree();
        customviewFour();
        customviewFive();
        customviewSix();
        viewLine_bottom();
        checkText();
    }

    public int getDrawable(){
        return new ImageSmall().getRandomChalk();
    }


    public void viewLine_top(){
        params_top = new Params();
        params_top.setWidth(Width);
        params_top.setHeight(Height / 20);
        baseView_01 = new MyBaseView(MainActivity.getmContext(), params_top);
        drawable1 = getDrawable();
        baseView_01.setBackgroundResource(drawable1);
        baseView_01.setDrawableColor(drawable1, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(Width, Height / 20);
        layoutParams.setMargins(0, 0, 0, 0);
        myStyleViewSeven.addView(baseView_01, layoutParams);

    }

    public void customViewOne(){
        params =  new Params();
        params.setWidth(Width);
        params.setHeight(Height / 3);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_02 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width, Height / 3);
        layoutParams.setMargins(0, Height / 20, 0, 0);
        myStyleViewSeven.addView(baseView_02, layoutParams);
    }

    public void viewLine_center(){
        params_center = new Params();
        params_center.setWidth(Width * 2 / 3);
        params_center.setHeight(Height / 20);
        baseView_03 = new MyBaseView(MainActivity.getmContext(), params_center);
        drawable2 = getDrawable();
        baseView_03.setBackgroundResource(drawable2);
        baseView_03.setDrawableColor(drawable2, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(Width * 2 / 3, Height / 20);
        layoutParams.setMargins(Width / 6, Height / 3 + Height / 20, Width / 6, 0);
        myStyleViewSeven.addView(baseView_03, layoutParams);

    }

    public void customViewTwo(){
        params =  new Params();
        params.setWidth(Width / 2);
        params.setHeight(Height / 8);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        baseView_04 = new MyBaseView(MainActivity.getmContext(), params);
        baseView_04.setText("{");
        layoutParams = new FrameLayout.LayoutParams(Width / 5, Height / 8);
        layoutParams.setMargins(0, Height / 3 + Height / 10, Width * 4 / 5, 0);
        myStyleViewSeven.addView(baseView_04, layoutParams);
    }

    public void customviewThree(){
        params =  new Params();
        params.setWidth(Width * 3 / 5);
        params.setHeight(Height / 8);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_05 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width * 3 / 5, Height / 8);
        layoutParams.setMargins(Width / 5, Height / 3 + Height / 10, Width / 5, 0);
        myStyleViewSeven.addView(baseView_05, layoutParams);
    }

    public void customviewFour(){
        params =  new Params();
        params.setWidth(Width / 2);
        params.setHeight(Height / 8);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        baseView_06 = new MyBaseView(MainActivity.getmContext(), params);
        baseView_06.setText("}");
        layoutParams = new FrameLayout.LayoutParams(Width / 5, Height / 8);
        layoutParams.setMargins(Width * 4 /5, Height / 3 + Height / 10, 0, 0);
        myStyleViewSeven.addView(baseView_06, layoutParams);
    }

    public void customviewFive(){
        params =  new Params();
        params.setWidth(Width);
        params.setHeight(Height / 4);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_07 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width , Height /4);
        layoutParams.setMargins(0, Height / 8 + Height / 3 + Height / 10, 0, 0);
        myStyleViewSeven.addView(baseView_07, layoutParams);
    }

    public void customviewSix(){
        params =  new Params();
        params.setWidth(Width);
        params.setHeight(Height / 8);
        params.setPaddingBottom(10);
        params.setPaddingRight(10);
        params.setPaddingLeft(10);
        params.setTypeface(mFont.getRandomTypeface());
        baseView_08 = new MyBaseView(MainActivity.getmContext(), params);
        layoutParams = new FrameLayout.LayoutParams(Width , Height /8);
        layoutParams.setMargins(0, Height / 8 + Height / 3 + Height / 10 + Height / 4, 0, 0);
        myStyleViewSeven.addView(baseView_08, layoutParams);
    }

    public void viewLine_bottom(){
        params_bottom = new Params();
        params_bottom.setWidth(Width);
        params_bottom.setHeight(Height / 20);
        params_bottom.setBackgroundColor(TextToolFragment.getColor());
        baseView_09 = new MyBaseView(MainActivity.getmContext(), params_bottom);
        drawable3 = getDrawable();
        baseView_09.setBackgroundResource(drawable3);
        baseView_09.setDrawableColor(drawable3, TextToolFragment.getColor());
        layoutParams = new FrameLayout.LayoutParams(Width, Height / 20);
        layoutParams.setMargins(0, Height / 2 + Height / 3 + Height / 10, 0, 0);
        myStyleViewSeven.addView(baseView_09, layoutParams);

    }


    @Override
    public void onAlphaChange(float value) {
        super.onAlphaChange(value);
        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 !=null && baseView_05 != null
                && baseView_06 != null && baseView_07 != null && baseView_08 !=null && baseView_09 != null) {
            baseView_01.setAlpha(value);
            baseView_02.setAlpha(value);
            baseView_03.setAlpha(value);
            baseView_04.setAlpha(value);
            baseView_05.setAlpha(value);
            baseView_06.setAlpha(value);
            baseView_07.setAlpha(value);
            baseView_08.setAlpha(value);
            baseView_09.setAlpha(value);
        }
    }

    @Override
    public void onColorChange(int color) {
        super.onColorChange(color);

        if (baseView_01 != null && baseView_02 != null && baseView_03 != null && baseView_04 !=null && baseView_05 != null
                && baseView_06 != null && baseView_07 != null && baseView_08 !=null && baseView_09 != null) {
            baseView_01.setDrawableColor(drawable1, color);
            baseView_02.setTextColor(color);
            baseView_03.setDrawableColor(drawable2, color);
            baseView_04.setTextColor(color);
            baseView_05.setTextColor(color);
            baseView_06.setTextColor(color);
            baseView_07.setTextColor(color);
            baseView_08.setTextColor(color);
            baseView_09.setDrawableColor(drawable3, color);
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
            baseView_06.setTextShadow(shading, color);
            baseView_07.setTextShadow(shading, color);
            baseView_08.setTextShadow(shading, color);
            baseView_09.setTextShadow(shading, color);
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
            baseView_02.setText(analyseString.result()[0]);
            baseView_05.setText(analyseString.result()[1]);
            baseView_07.setText(analyseString.result()[2]);
            baseView_08.setText("");
            baseView_09.setBackGroundColor(Color.TRANSPARENT);
        }else if (k==1){
            baseView_02.setText(analyseString.result()[0]);
            baseView_05.setText(analyseString.result()[1]);
            baseView_07.setText("");
            baseView_08.setText("");
            baseView_09.setBackGroundColor(Color.TRANSPARENT);
        }else if (k==0){
            baseView_02.setText(analyseString.result()[0]);
            baseView_05.setText("");
            baseView_07.setText("");
            baseView_08.setText("");
            baseView_09.setBackGroundColor(Color.TRANSPARENT);
        }
    }

    public void setTextTH2(){
        if (baseView_02 != null && baseView_05 != null && baseView_07 != null&& baseView_08 != null){
            baseView_02.setText(analyseString.result()[0]);
            baseView_05.setText(analyseString.result()[1]);
            baseView_07.setText(analyseString.result()[2]);
            baseView_08.setText(analyseString.result()[3]);
        }
    }

}
