package com.word.swag.text.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.word.swag.text.Adapter.PurchaseAdapter;
import com.word.swag.text.R;

/**
 * Created by company on 9/5/16.
 */
public class PurchaseFragment extends DialogFragment {

    private Context mContext;

    private OnClickListenerPurchase mListener;

    public interface OnClickListenerPurchase{
        void onClosePurchase(DialogInterface dialog);
        void onClickPurchase();
    }
    public static PurchaseFragment newInstance(String key) {

        Bundle args = new Bundle();

        PurchaseFragment fragment = new PurchaseFragment();
        args.putString("pur", key);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mListener = (OnClickListenerPurchase ) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnClickListenerPurchase");
        }
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mContext = context;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        getArguments().getString("pur");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View vi = inflater.inflate(R.layout.fragment_purchase_item, null);
        GridView gridview = (GridView) vi.findViewById(R.id.gv_purchase);
        gridview.setAdapter(new PurchaseAdapter(getActivity()));

        RelativeLayout close_purchase = (RelativeLayout)vi.findViewById(R.id.rl_close_purchase);
        close_purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClosePurchase(getDialog());
            }
        });

        FrameLayout start_purchase = (FrameLayout) vi.findViewById(R.id.fl_purchase);
        start_purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClickPurchase();
                Toast.makeText(getActivity(), "pur", Toast.LENGTH_LONG).show();
            }
        });

        builder.setView(vi);

        return builder.create();
    }
}
