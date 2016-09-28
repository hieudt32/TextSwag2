package com.word.swag.text.Utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * Created by ThanhDat on 1/18/16.
 */
public class Share {

    public void shareFacebook(Activity activity, String path){
        Intent intent = activity.getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
        if (intent != null)
        {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setPackage("com.facebook.katana");
            shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + path));
            shareIntent.setType("image/*");
            activity.startActivity(shareIntent);
        }
        else
        {
            // bring user to the market to download the app.
            // or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id="+"com.facebook.katana"));
            activity.startActivity(intent);
        }
    }

    public void shareInstagram(Activity activity, String path){
        Intent intent = activity.getPackageManager().getLaunchIntentForPackage("com.instagram.android");
        if (intent != null)
        {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setPackage("com.instagram.android");
            try {
                shareIntent.putExtra(Intent.EXTRA_STREAM,
                        Uri.parse("file://" + path));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            shareIntent.setType("image/*");
            activity.startActivity(shareIntent);
        }
        else
        {
            // bring user to the market to download the app.
            // or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id="+"com.instagram.android"));
            activity.startActivity(intent);
        }
    }

    public void shareEmail(Activity activity, String path){
        Intent intent = activity.getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
        if (intent != null)
        {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setPackage("com.google.android.gm");
            shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + path));
            shareIntent.setType("image/*");
            activity.startActivity(shareIntent);
        }
        else
        {
            // bring user to the market to download the app.
            // or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id="+"com.google.android.gm"));
            activity.startActivity(intent);
        }
    }

    public void sharePinterest(Activity activity, String path){
        Intent intent = activity.getPackageManager().getLaunchIntentForPackage("com.pinterest");
        if (intent != null)
        {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setPackage("com.pinterest");
            shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + path));
            shareIntent.setType("image/*");
            activity.startActivity(shareIntent);
        }
        else
        {
            // bring user to the market to download the app.
            // or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id="+"com.pinterest"));
            activity.startActivity(intent);
        }
    }

    public void shareTwitter(Activity activity, String path){
        Intent intent = activity.getPackageManager().getLaunchIntentForPackage("com.twitter.android");
        if (intent != null)
        {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setPackage("com.twitter.android");
            shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + path));
            shareIntent.setType("image/*");
            activity.startActivity(shareIntent);
        }
        else
        {
            // bring user to the market to download the app.
            // or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id="+"com.twitter.android"));
            activity.startActivity(intent);
        }
    }

    public void shareOther(Activity activity, String path){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + path));
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        shareIntent.setType("image/*");
        activity.startActivity(Intent.createChooser(shareIntent, "Share to"));
    }
}
