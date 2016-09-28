package com.word.swag.text.Activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.word.swag.text.Adapter.ShareAdapter;
import com.word.swag.text.Fragment.RatingFragment;
import com.word.swag.text.R;
import com.word.swag.text.Utils.Share;

import java.io.File;

/**
 * Created by company on 8/17/16.
 */
public class ShareActivity extends Activity {

    private int [] mIcon = new int[]{R.mipmap.ic_facebook_share, R.mipmap.ic_twitter_share, R.mipmap.ic_instagram_share, R.mipmap.ic_email_share, R.mipmap.ic_pinterest_share, R.mipmap.ic_other_share};
    private String[] mName = new String[]{"Facebook", "Twitter", "Instagram", "Email", "Pinterest", "Other"};
    private Boolean isRating = false;
    private String imageLocalPath;
    private Share shareIntent = new Share();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        hideStatusBar();

        // Execute some code after 2 seconds have passed
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!checkKeyRating()){
                    onShowDialogRating();
                }
            }
        }, 2000);

        getPathFromMainActivity();
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideStatusBar();
    }

    private void init(){

        GridView gv_share = (GridView) findViewById(R.id.gv_share);

        ShareAdapter shareAdapter = new ShareAdapter(this, mIcon, mName);

        gv_share.setAdapter(shareAdapter);

        gv_share.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                shareSocialNetwork(position);
            }
        });

        FrameLayout fl_home = (FrameLayout)findViewById(R.id.fl_home_share);
        fl_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackStartActivity();
            }
        });

    }

    public void shareSocialNetwork(int pos){
        switch (pos){
            case 0:
                if (imageLocalPath!= null)shareIntent.shareFacebook(this, imageLocalPath);
                break;
            case 1:
                if (imageLocalPath!=null)shareIntent.shareTwitter(this, imageLocalPath);
                break;
            case 2:
                if (imageLocalPath!=null)shareIntent.shareInstagram(this, imageLocalPath);
                break;
            case 3:
                if (imageLocalPath!=null)shareIntent.shareEmail(this, imageLocalPath);
                break;
            case 4:
                if (imageLocalPath!=null)shareIntent.sharePinterest(this, imageLocalPath);
                break;
            case 5:
                if (imageLocalPath!= null)shareIntent.shareOther(this, imageLocalPath);
                break;
        }
    }

    private void hideStatusBar(){
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }else {

            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
            ActionBar actionBar = getActionBar();
            if (actionBar != null){
                actionBar.hide();
            }

        }
    }

    private void onBackStartActivity(){
        finish();
        Intent intent_start_activity = new Intent(ShareActivity.this, StartActivity.class);
        startActivity(intent_start_activity);
        overridePendingTransition(R.anim.slide_in_back, R.anim.slide_out_back);
    }

    private void getPathFromMainActivity(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            String path = bundle.getString("ddt");
            if(path != null)
            {
                imageLocalPath = path;
                Bitmap myBitmap = BitmapFactory.decodeFile(path);
                ImageView imv_preview =(ImageView)findViewById(R.id.imv_preview);
                imv_preview.setImageBitmap(myBitmap);
            }
        }
    }

    //This is dialog rating
    private void onShowDialogRating(){
        RatingFragment newFragment = new RatingFragment().newInstance("Rate App");
        newFragment.show(getFragmentManager(), "title");
    }

    //This is check key rating from storage

    private boolean checkKeyRating(){
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String rating = sharedPref.getString("KEY_RATING", null);
        if (rating != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        onBackStartActivity();
        super.onBackPressed();
    }

}
