package com.word.swag.text.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.word.swag.text.R;

/**
 * Created by ThanhDat on 12/27/15.
 */
public class FilterFragment extends Fragment{

    private LinearLayout ll_filter_container;
    private String text_name[] = {"None", "Autofix", "Intensity", "Brightness", "Contrast", "Cross", "Document", "DuoTone", "Light",
                                    "FishEye", "Grain", "Grayscale", "Lomoish", "Negative", "Posterize", "Saturate", "Sepia", "Sharpen",
                                    "Tempera", "Tint", "Vignette"};
    private int image [] = {R.mipmap.none, R.mipmap.autofix, R.mipmap.intensity, R.mipmap.brightness,
            R.mipmap.contrast,R.mipmap.cross,R.mipmap.documentar,R.mipmap.duatone,R.mipmap.light, R.mipmap.fisheye,
            R.mipmap.grain, R.mipmap.grayscale, R.mipmap.lomoish, R.mipmap.negative, R.mipmap.posterize,
            R.mipmap.saturate, R.mipmap.sepia, R.mipmap.sharpen, R.mipmap.temperature, R.mipmap.tint, R.mipmap.vignette};


    public OnClickFilter mListener;
    public interface OnClickFilter{
        public void onClick(int pos);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (OnClickFilter)activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);
        ll_filter_container = (LinearLayout)view
                .findViewById(R.id.ll_filter_container);
        inflateItem();
        return view;
    }

    public void inflateItem() {
        for (int i = 0; i < text_name.length; i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            View row = View.inflate(getActivity().getBaseContext(), R.layout.item_image_filter, null);
            final TextView tv_name = (TextView)row.findViewById(R.id.tv_item);
            final RelativeLayout rl_boder_filter = (RelativeLayout)row.findViewById(R.id.rl_boder_filter);
            if (i == 0){
                tv_name.setSelected(true);
                rl_boder_filter.setBackgroundColor(Color.WHITE);
            }
            row.setLayoutParams(params);
            ViewHolder viewHolder = new ViewHolder(row);
            viewHolder.tv_item.setText(text_name[i]);
            viewHolder.imv_item_thumb.setImageResource(image[i]);
            final int finalI = i;

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int j = 0; j < ll_filter_container.getChildCount(); j++){
                        View v = ll_filter_container.getChildAt(j);
                        TextView textView = (TextView) v.findViewById(R.id.tv_item);
                        if (textView != null) textView.setSelected(false);
                        RelativeLayout relativeLayout = (RelativeLayout) v.findViewById(R.id.rl_boder_filter);
                        if (relativeLayout != null) relativeLayout.setBackgroundColor(Color.parseColor("#69bddf"));

                    }
                    mListener.onClick(finalI);
//                    tv_name.setTextColor(getActivity().getResources().getColor(R.color.color_text_selector));
                    tv_name.setSelected(true);
                    rl_boder_filter.setBackgroundColor(Color.WHITE);
                }
            });



            ll_filter_container.addView(row);
        }
    }

    static class ViewHolder {
        TextView tv_item;
        ImageView imv_item_thumb;

        public ViewHolder(View view) {
            tv_item = (TextView) view.findViewById(R.id.tv_item);
            imv_item_thumb = (ImageView) view.findViewById(R.id.imv_item_thumb);

        }

    }


}
