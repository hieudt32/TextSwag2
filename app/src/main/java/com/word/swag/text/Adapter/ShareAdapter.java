package com.word.swag.text.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.word.swag.text.R;
import com.word.swag.text.View.Other.TypefaceTextView;

/**
 * Created by company on 9/22/16.
 */

public class ShareAdapter extends BaseAdapter {

    private Context mContext;
    private int [] mIcon;
    private String [] mName;

    public ShareAdapter(Context mContext, int[] mIcon, String[] mName) {
        this.mContext = mContext;
        this.mIcon = mIcon;
        this.mName = mName;
    }

    @Override
    public int getCount() {
        return mName.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(mContext);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.item_share, null);

            // set value into textview
            TypefaceTextView textView = (TypefaceTextView) gridView
                    .findViewById(R.id.tv_icon_share);
            textView.setText(mName[position]);

            // set image based on selected text
            ImageView vi_icon =(ImageView)gridView.findViewById(R.id.vi_icon_share);
            vi_icon.setImageResource(mIcon[position]);

//            RelativeLayout rl_share_button = (RelativeLayout) gridView.findViewById(R.id.rl_share_button);
//            rl_share_button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });


        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }





}
