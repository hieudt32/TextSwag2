package com.word.swag.text.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.word.swag.text.R;

/**
 * Created by ThanhDat on 12/27/15.
 */
public class DialogShareAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;

    public DialogShareAdapter(Context mContext) {
        mInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mImageItem.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {

            view = mInflater.inflate(R.layout.item_share_dialog, null);
            GridView.LayoutParams params = new GridView.LayoutParams(
                    GridView.LayoutParams.MATCH_PARENT, GridView.LayoutParams.MATCH_PARENT);
//            params.leftMargin = 2;
//            params.rightMargin = 2;
//            params.bottomMargin = 2;
            view.setLayoutParams(params);
            view.setBackgroundColor(mContext.getResources().getColor(R.color.abc_boder));
            holder = new ViewHolder();
            holder.title = (TextView) view.findViewById(R.id.tv_item);
            holder.icon = (ImageView) view.findViewById(R.id.imv_icon);
            holder.ll_share = (LinearLayout)view.findViewById(R.id.ll_share);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.icon.setAdjustViewBounds(true);
        holder.icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        holder.icon.setPadding(8, 8, 8, 8);
        holder.title.setText(mContext.getString(mTextItem[i]));
        holder.icon.setImageResource(mImageItem[i]);
        return view;
    }

    class ViewHolder {
        TextView title;
        ImageView icon;
        LinearLayout ll_share;
    }

    private Integer[]
            mImageItem = {R.drawable.selector_view_share_fb, R.drawable.selector_view_share_isg, R.drawable.selector_view_share_em,
            R.drawable.selector_view_share_ptr, R.drawable.selector_view_share_tt, R.drawable.selector_view_share_other};


    private int[]
            mTextItem = {R.string.share_facebook, R.string.share_instagram, R.string.share_main,
            R.string.share_pinterest, R.string.share_twitter, R.string.share_other};


}
