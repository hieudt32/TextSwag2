package com.word.swag.text.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.word.swag.text.R;

import java.util.List;

/**
 * Created by company on 8/18/16.
 */
public class RatingFragment extends DialogFragment {

    private boolean isSubmit = false;
    private Context mContext;
    public RatingFragment() {
    }

    public static RatingFragment newInstance(String title){

        RatingFragment ratingFragment = new RatingFragment();
        Bundle ratingBundle = new Bundle();
        ratingBundle.putString("title", title);
        ratingFragment.setArguments(ratingBundle);

        return ratingFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        getArguments().getString("title");
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//
        LayoutInflater inflater = getActivity().getLayoutInflater();


        View vi = inflater.inflate(R.layout.dialog_rating, null);
        initView(vi);
//
//        builder.setView(vi);

//        AlertDialog dialog = builder.create();
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        dialog.setView(vi, 0, 0, 0, 0);
//        dialog.show();

        Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // layout to display
        dialog.setContentView(vi);

        // set color transpartent
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;
    }

    public void initView(final View view){

        RatingBar rb = (RatingBar)view.findViewById(R.id.ratingBar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (rating > 0 && rating < 4){
                    isSubmit = false;
                }else {
                    isSubmit = true;
                }
            }
        });
        RelativeLayout rlSubmit = (RelativeLayout)view.findViewById(R.id.rl_submit);
        rlSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSubmit){
                    openAppRating(getActivity());
                    saveKeyRating();
                }else {
                    Toast.makeText(getActivity(), "Thanks for rating", Toast.LENGTH_SHORT).show();
                    saveKeyRating();
                }
                getDialog().dismiss();
            }
        });
    }

    public static void openAppRating(Context context) {

        Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            context.startActivity(myAppLinkToMarket);

        } catch (ActivityNotFoundException e) {
            //the device hasn't installed Google Play
            Toast.makeText(context, "You don't have Google Play installed", Toast.LENGTH_LONG).show();
        }
    }

    // This is save key rating

    private void saveKeyRating(){
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("KEY_RATING", "key");
        editor.commit();

    }
}
