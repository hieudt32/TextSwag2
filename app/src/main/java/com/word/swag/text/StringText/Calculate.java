package com.word.swag.text.StringText;

import android.app.Activity;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ThanhDat on 1/7/16.
 */
public class Calculate {


    public static int countSpace(String mText) {
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(mText);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        Log.d("dat", "countSpace: " + count);
        return count;
    }

    public static Point getScreenInfo(Activity activity){
        Point size = new Point();
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        size.x = metrics.widthPixels;
        size.y = metrics.heightPixels;
        return size;
    }



}
