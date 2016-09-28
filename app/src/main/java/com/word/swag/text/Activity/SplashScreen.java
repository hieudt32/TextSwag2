package com.word.swag.text.Activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by ThanhDat on 1/19/16.
 */
public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadStartActivity();
    }

    public void loadStartActivity(){
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
    }
}
