package com.word.swag.text.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.word.swag.text.R;

/**
 * Created by company on 9/23/16.
 */

public class PurchaseAdapter extends BaseAdapter {
    private Context mContext;

    public PurchaseAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_gridview_purchase, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) row.findViewById(R.id.imv_purchase);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        holder.image.setImageResource(mThumbIds[position]);
        return row;
    }

    static class ViewHolder {
        ImageView image;
    }

    // references to our images
    private Integer[] mThumbIds = {R.mipmap.new_style_purchase_one, R.mipmap.new_style_purchase_two, R.mipmap.new_style_purchase_three, R.mipmap.new_style_purchase_four, R.mipmap.new_style_purchase_five, R.mipmap.new_style_purchase_six};
}
