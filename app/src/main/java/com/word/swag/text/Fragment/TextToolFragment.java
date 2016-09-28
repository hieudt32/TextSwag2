package com.word.swag.text.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.word.swag.text.R;

/**
 * Created by ThanhDat on 12/18/15.
 */
public class TextToolFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private SeekBar sb_opacity;
    private SeekBar sb_shadow;
    private LinearLayout ll_view_color;
    private static int color = Color.WHITE;
    private static float opacity = 1;
    static int posSbOpacity = 255, posSbShadow = 0, posColor = 0;

    public static int getColor() {
        return color;
    }

    public static float getOpacity() {
        return opacity;
    }

    public static int getPosSbShadow() {
        return posSbShadow;
    }

    public OnValueChangeListener mListener;


    public interface OnValueChangeListener {
        void onAlphaChange(float value);

        void onColorChange(int color);

        void onShadowChange(int shading, int color);
    }

    LinearLayout.LayoutParams params;

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("color", color);
//        outState.putFloat("opacity", opacity);
//        outState.putInt("posSbShadow", posSbShadow);
//        outState.putInt("posSbOpacity", posSbOpacity);
//        Log.d("TextToolFragment", "onSaveInstanceState");
//    }
//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        if (savedInstanceState != null) {
//            color = savedInstanceState.getInt("color");
//            opacity = savedInstanceState.getFloat("opacity");
//            posSbShadow = savedInstanceState.getInt("posSbShadow");
//            posSbOpacity = savedInstanceState.getInt("posSbOpacity");
//            onRestoreInstance();
//
//        }
//        Log.d("TextToolFragment", "onActivityCreated");
//    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnValueChangeListener) {
            mListener = (OnValueChangeListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_tool, container, false);
        init(view);
        return view;
    }


    public void init(View view){
        sb_opacity = (SeekBar) view.findViewById(R.id.sb_opacity);
        sb_shadow = (SeekBar) view.findViewById(R.id.sb_shadow);
        sb_opacity.setOnSeekBarChangeListener(this);
        sb_shadow.setOnSeekBarChangeListener(this);
        ll_view_color = (LinearLayout) view.findViewById(R.id.ll_view_color);
        insertViewColorInScrollView();
    }


    public void insertViewColorInScrollView() {

        for (int i = 0; i < getColorResource().length; i++) {
            LayoutInflater vi = (LayoutInflater) getActivity().getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = vi.inflate(R.layout.item_color, null);
            View vi_color = (View)v.findViewById(R.id.vi_color);
            final View vi_check_color = (View)v.findViewById(R.id.vi_check_color);
            vi_check_color.setVisibility(View.GONE);
            if (i == 0){
                vi_check_color.setVisibility(View.VISIBLE);
            }
            vi_color.setBackgroundColor(getColorResource()[i]);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.rightMargin = 2;
            v.setLayoutParams(params);
            final int finalI = i;
            vi_color.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int j = 0; j < ll_view_color.getChildCount(); j++) {
                        View item = ll_view_color.getChildAt(j);
                        View stick = item.findViewById(R.id.vi_check_color);
                        if (stick != null) stick.setVisibility(View.GONE);
                    }
                    color = getColorResource()[finalI];
                    if (mListener != null) mListener.onColorChange(color);
                    if (mListener != null) mListener.onShadowChange(posSbShadow, color);
                    vi_check_color.setVisibility(View.VISIBLE);
                }
            });

            ll_view_color.addView(v);

        }
    }

    public int[] getColorResource() {
        TypedArray ta = getActivity().getResources().obtainTypedArray(R.array.colorOption);
        int[] colors = new int[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            colors[i] = ta.getColor(i, 0);
        }
        ta.recycle();
        return colors;
    }

    public void onRestoreValueTextTool(){
        sb_opacity.setProgress(posSbOpacity);
        sb_shadow.setProgress(posSbShadow);
        mListener.onColorChange(color);

    }

    @Override
    public void onStart() {
        super.onStart();
        onRestoreValueTextTool();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TextToolFragment", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TextToolFragment", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TextToolFragment", "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TextToolFragment", "onDestroy");
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()) {
            case R.id.sb_opacity:
                posSbOpacity = i;
                int progress = seekBar.getProgress();
                int maxProgress = seekBar.getMax();
                opacity = (float) progress / (float) maxProgress;
                if (mListener != null) mListener.onAlphaChange(opacity);
                break;
            case R.id.sb_shadow:
                posSbShadow = i;
                if (mListener != null) mListener.onShadowChange(posSbShadow, color);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


}
