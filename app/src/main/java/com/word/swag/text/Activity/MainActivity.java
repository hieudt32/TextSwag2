package com.word.swag.text.Activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.media.MediaScannerConnection;
import android.media.effect.Effect;
import android.media.effect.EffectContext;
import android.media.effect.EffectFactory;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.vending.billing.IInAppBillingService;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.word.swag.text.Adapter.DialogShareAdapter;
import com.word.swag.text.Fragment.FilterFragment;
import com.word.swag.text.Fragment.InputTextFragmentNew;
import com.word.swag.text.Fragment.PurchaseFragment;
import com.word.swag.text.Fragment.StyleFragment;
import com.word.swag.text.Fragment.TextToolFragment;
import com.word.swag.text.R;
import com.word.swag.text.StringText.Calculate;
import com.word.swag.text.Utils.PurchaseUtils.IabHelper;
import com.word.swag.text.Utils.PurchaseUtils.IabResult;
import com.word.swag.text.Utils.PurchaseUtils.Inventory;
import com.word.swag.text.Utils.PurchaseUtils.Purchase;
import com.word.swag.text.Utils.Share;
import com.word.swag.text.View.MyStyleBaseView;
import com.word.swag.text.View.Other.TypefaceTextView;
import com.word.swag.text.View.TouchBaseView;
import com.word.swag.text.fillter.GLToolbox;
import com.word.swag.text.fillter.TextureRenderer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.IntBuffer;
import java.util.List;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by ThanhDat on 11/30/15.
 */
public class MainActivity extends Activity implements TextToolFragment.OnValueChangeListener,
        TouchBaseView.OnChangeLayoutListener, InputTextFragmentNew.OnSentTextListener,
        FilterFragment.OnClickFilter, GLSurfaceView.Renderer, PurchaseFragment.OnClickListenerPurchase{

    private static final int CATEGORY_ID = 100;
    private static TouchBaseView frm_container;
    private static RelativeLayout rl_container;
    private LinearLayout ll_option;
    private static View vi_baseview_delete;
    private FrameLayout fl_home_main, fl_done_main;
    private View vi_art, vi_text_tool, vi_filter;
    private FrameLayout fl_art, fl_text_tool, fl_filter;
    public static Context mContext;
    public Dialog dialog;
    public static String mText = "DOUBLE TAB TO EDIT TEXT HERE";
    public static Point size;

    private InterstitialAd interstitialAd;

    public static Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public static TouchBaseView getFrm_container() {
        return frm_container;
    }

    public static void setFrm_container(TouchBaseView frm_container) {
        MainActivity.frm_container = frm_container;
    }

    public static View getVi_baseview_delete() {
        return vi_baseview_delete;
    }

    public static void setVi_baseview_delete(View vi_baseview_delete) {
        MainActivity.vi_baseview_delete = vi_baseview_delete;
    }

    public static String getmText() {
        return mText;
    }

    public static void setmText(String mText) {
        MainActivity.mText = mText;
    }

    public static int color = Color.WHITE;

    public static int getColor() {
        return color;
    }

    public static void setColor(int color) {
        MainActivity.color  = color;
    }

    public static Bitmap bitmap;

    public View view_guider;

    public String imageLocalPath;

    // GL

    public GLSurfaceView GLView;

    public RelativeLayout boxView, relContainerView;
    private EffectContext mEffectContext;
    private Effect mEffect;
    private TextureRenderer mTexRenderer = new TextureRenderer();
    private int[] mTextures = new int[2];
    private int mCurrentEffect;
    private int mImageWidth;
    private int mImageHeight;
    private int boxHeigth, boxWidth;
    private float ratioBox;
    private int glWidth = 100, glHeight = 100;
    private RelativeLayout.LayoutParams relGLViewParams;
    private Bitmap bitmapEffected;
    private ImageView imvExported;
    private boolean mInitialized = false;
    private boolean isExport = false;
    private TypefaceTextView tv_title;

    // size style

    public static int sizeNew;

    // Purchase

    private IInAppBillingService mService;

        ServiceConnection mServiceConn = new ServiceConnection() {
            @Override
            public void onServiceDisconnected(ComponentName name) {
                mService = null;
            }

            @Override
            public void onServiceConnected(ComponentName name,
                                           IBinder service) {
                mService = IInAppBillingService.Stub.asInterface(service);
            }
        };
    IabHelper mHelper;
    private String SKU_ITEM = "";


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGL();
        initialization();
        Thread timer = new Thread() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            setFragment(styleFragment, "style");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };
        timer.start();

        setUpPurchase();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public Bitmap getBitmapCrop() {
//        byte[] byteArray = getIntent().getByteArrayExtra("image_bitmap");
//        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//        return bmp;

//        Bitmap bmp = null;
//        String filename = getIntent().getStringExtra("image_bitmap");
//        try {
//            FileInputStream is = this.openFileInput(filename);
//            bmp = BitmapFactory.decodeStream(is);
//            is.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Uri imageUri = getIntent().getData();
        if (imageUri == null) return null;
        Bitmap bmp = null;
        try {
            bmp = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmp;
    }

    public void initGL() {
        boxView = (RelativeLayout) findViewById(R.id.rl_box);
        relContainerView = (RelativeLayout) findViewById(R.id.rl_container);
        imvExported = (ImageView) findViewById(R.id.imv_exported);
        GLView = (GLSurfaceView) findViewById(R.id.GlView);
        GLView.setEGLContextClientVersion(2);
        GLView.setRenderer(this);
        GLView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        ViewTreeObserver vto = boxView.getViewTreeObserver();
        if (vto.isAlive()) {
            vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @SuppressWarnings("deprecation")
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                public void onGlobalLayout() {
                    // remove the listener
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        boxView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        boxView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    bitmap = getBitmapCrop();
                    boxHeigth = boxView.getHeight();
                    boxWidth = boxView.getWidth();
                    Log.d("HUNG", "boxHeigth: " + boxHeigth + " boxWidth: " + boxWidth);
                    ratioBox = (1.0f * boxHeigth) / boxWidth;
                    reCalculatorGLView();
                }
            });
        }
    }

    public void initialization() {
        setmContext(getBaseContext());
        rl_container = (RelativeLayout) findViewById(R.id.rl_container);
        frm_container = (TouchBaseView) findViewById(R.id.frm_container);
        vi_baseview_delete = (View) findViewById(R.id.vi_baseview_delete);
        fl_home_main = (FrameLayout) findViewById(R.id.fl_home_main);
        fl_done_main = (FrameLayout) findViewById(R.id.fl_done_main);
        setFrm_container(frm_container);
        setVi_baseview_delete(vi_baseview_delete);
        vi_art = (View) findViewById(R.id.vi_art);
        vi_text_tool = (View) findViewById(R.id.vi_texttool);
        vi_filter = (View) findViewById(R.id.vi_filter);
        fl_art = (FrameLayout) findViewById(R.id.fl_art);
        fl_text_tool = (FrameLayout) findViewById(R.id.fl_text_tool);
        fl_filter = (FrameLayout) findViewById(R.id.fl_filter);
        fl_art.setBackgroundColor(Color.parseColor("#212a33"));

        tv_title = (TypefaceTextView)findViewById(R.id.tv_title);
        tv_title.setText("STYLE");

        vi_art.setSelected(true);
//        setFragment(styleFragment, "style");
        size = Calculate.getScreenInfo(this);
        fl_home_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackStartActivity();
            }
        });

    }

    Fragment styleFragment = new StyleFragment(),
            toolFragment = new TextToolFragment(),
            filterFragment = new FilterFragment();
    Fragment currentFragment;

    public void onClickContent(View view) {
        resetSelected();
        resetSelectedContainerColor();
        switch (view.getId()) {
            case R.id.fl_art:
                setFragment(styleFragment, "style");
                vi_art.setSelected(true);
                fl_art.setBackgroundColor(Color.parseColor("#212a33"));
                tv_title.setText("STYLE");
                break;
            case R.id.fl_text_tool:
                setFragment(toolFragment, "tool");
                vi_text_tool.setSelected(true);
                fl_text_tool.setBackgroundColor(Color.parseColor("#212a33"));
                tv_title.setText("TEXT TOOL");
                break;
            case R.id.fl_filter:
                setFragment(filterFragment, "filter");
                vi_filter.setSelected(true);
                fl_filter.setBackgroundColor(Color.parseColor("#212a33"));
                tv_title.setText("FILTER");
                break;
        }
    }

    public void onClickDoneAndDel(View view) {
        switch (view.getId()) {
            case R.id.fl_done_main:
                new ExportTask().execute();
                break;
            case R.id.vi_baseview_delete:
                frm_container.setVisibility(View.GONE);
                vi_baseview_delete.setVisibility(View.GONE);
                break;
        }
    }

    public void resetSelected(){
        vi_art.setSelected(false);
        vi_text_tool.setSelected(false);
        vi_filter.setSelected(false);

    }

    public void resetSelectedContainerColor(){
        fl_art.setBackgroundColor(Color.BLACK);
        fl_text_tool.setBackgroundColor(Color.BLACK);
        fl_filter.setBackgroundColor(Color.BLACK);
    }

    public void setFragment(Fragment frag, String tag) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        if (currentFragment != null && currentFragment != frag) ft.hide(currentFragment);
        if (fm.findFragmentByTag(tag) == null) {
            ft.add(R.id.ll_change_option, frag, tag);
        } else {
            ft.show(frag);
        }
        ft.commit();
        currentFragment = frag;

    }

    @Override
    protected void onResume() {
        super.onResume();
        GLView.onResume();
        refreshView();
    }


    private void refreshView() {
        GLView.setVisibility(View.VISIBLE);
        imvExported.setVisibility(View.GONE);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        GLView.onPause();
    }

    @Override
    public void onAlphaChange(float value) {
        if (frm_container.getChildCount() > 0) {

            MyStyleBaseView baseView = (MyStyleBaseView) frm_container.getChildAt(0);
            baseView.onAlphaChange(value);
            frm_container.invalidate();

        }
    }

    @Override
    public void onColorChange(int color) {
        if (frm_container.getChildCount() > 0) {

            MyStyleBaseView baseView = (MyStyleBaseView) frm_container.getChildAt(0);
            baseView.onColorChange(color);
            frm_container.invalidate();

        }
//        this.setColor(color);
    }

    @Override
    public void onShadowChange(int shading, int color) {

        if (frm_container.getChildCount() > 0) {

            MyStyleBaseView baseView = (MyStyleBaseView) frm_container.getChildAt(0);
            baseView.onShadowChange(shading, color);
            frm_container.invalidate();

        }
    }

    @Override
    public void OnSentText(String text) {
        this.setmText(text);
        MyStyleBaseView baseView = (MyStyleBaseView) frm_container.getChildAt(0);
        baseView.onTextChange(text);
    }

    @Override
    public void onClick(int pos) {
        setCurrentEffect(pos);
        GLView.requestRender();
    }

    @Override
    public void onDoubleTab(MotionEvent event) {
        addFragmentToShow();
    }

    public void addFragmentToShow() {
        InputTextFragmentNew inputTextFragment = new InputTextFragmentNew();
        Bundle bundle = new Bundle();
        bundle.putString("text", this.getmText());
        inputTextFragment.setArguments(bundle);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(android.R.id.content, inputTextFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    // GL
    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {

        if (mTexRenderer != null) {
            mTexRenderer.updateViewSize(i, i1);
        }

    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        //Only need to do this once
        if (!mInitialized) {
            //Only need to do this once
            mEffectContext = EffectContext.createWithCurrentGlContext();
            mTexRenderer.init();
            loadTextures();
            mInitialized = true;
        }

        if (mCurrentEffect != 0) {
            //if an effect is chosen initialize it and apply it to the texture
            initEffect();
            applyEffect();
        }
        renderResult();
        if (isExport) {
            if (bitmapEffected != null) {
                bitmapEffected.recycle();
                bitmapEffected = null;
            }
            bitmapEffected = createBitmapFromGLSurface(0, 0, glWidth, glHeight, gl10);
            isExport = false;
        }

    }

    private void reCalculatorGLView() {
        relGLViewParams = (RelativeLayout.LayoutParams) relContainerView.getLayoutParams();

        mImageWidth = bitmap.getWidth();
        mImageHeight = bitmap.getHeight();
        float ratioImage = (1.0f * mImageHeight) / mImageWidth;
        if (ratioBox > ratioImage) {
            glWidth = boxWidth;
            glHeight = (int) (boxWidth * ratioImage);
        } else {
            glWidth = (int) (boxHeigth / ratioImage);
            glHeight = boxHeigth;
        }
        Log.d("HUNG", "glHeight: " + glHeight + " glWidth: " + glWidth);
        relGLViewParams.width = glWidth;
        relGLViewParams.height = glHeight;
        caculateSize(glWidth, glHeight);
        relContainerView.setLayoutParams(relGLViewParams);
    }

    public void caculateSize(int w, int h) {
        frm_container.setCenterX(w / 2);
        frm_container.setCenterY(h / 2);
        if (w >= h) {
            sizeNew = h;
        } else {
            sizeNew = w;
        }
    }

    private void setCurrentEffect(int effect) {
        mCurrentEffect = effect;
    }

    private void loadTextures() {
        // Load input bitmap
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.puppy);
//        if(bitmap == null){
//            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
//        }

//        mImageWidth = bitmap.getWidth();
//        mImageHeight = bitmap.getHeight();

        // Generate textures
        GLES20.glGenTextures(2, mTextures, 0);


        mTexRenderer.updateTextureSize(mImageWidth, mImageHeight);

        // Upload to texture
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mTextures[0]);
        GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bitmap, 0);

        // Set texture parameters
        GLToolbox.initTexParams();
        bitmap.recycle();
        bitmap = null;
    }

    private Bitmap createBitmapFromGLSurface(int x, int y, int w, int h, GL10 gl)
            throws OutOfMemoryError {
        int bitmapBuffer[] = new int[w * h];
        int bitmapSource[] = new int[w * h];
        IntBuffer intBuffer = IntBuffer.wrap(bitmapBuffer);
        intBuffer.position(0);

        try {
            gl.glReadPixels(x, y, w, h, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, intBuffer);
            int offset1, offset2;
            for (int i = 0; i < h; i++) {
                offset1 = i * w;
                offset2 = (h - i - 1) * w;
                for (int j = 0; j < w; j++) {
                    int texturePixel = bitmapBuffer[offset1 + j];
                    int blue = (texturePixel >> 16) & 0xff;
                    int red = (texturePixel << 16) & 0x00ff0000;
                    int pixel = (texturePixel & 0xff00ff00) | red | blue;
                    bitmapSource[offset2 + j] = pixel;
                }
            }
        } catch (GLException e) {
            return null;
        }

        return Bitmap.createBitmap(bitmapSource, w, h, Bitmap.Config.ARGB_8888);
    }

    private void initEffect() {
        EffectFactory effectFactory = mEffectContext.getFactory();
        if (mEffect != null) {
            mEffect.release();
        }
        // Initialize the correct effect based on the selected menu/action item
        switch (mCurrentEffect) {

            case 0:
                break;
            case 1:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_AUTOFIX);
                mEffect.setParameter("scale", 0.5f);
                break;

            case 2:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_BLACKWHITE);
                mEffect.setParameter("black", .1f);
                mEffect.setParameter("white", .7f);
                break;

            case 3:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_BRIGHTNESS);
                mEffect.setParameter("brightness", 2.0f);
                break;

            case 4:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_CONTRAST);
                mEffect.setParameter("contrast", 1.4f);
                break;

            case 5:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_CROSSPROCESS);
                break;

            case 6:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_DOCUMENTARY);
                break;

            case 7:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_DUOTONE);
                mEffect.setParameter("first_color", Color.YELLOW);
                mEffect.setParameter("second_color", Color.DKGRAY);
                break;

            case 8:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_FILLLIGHT);
                mEffect.setParameter("strength", .8f);
                break;

            case 9:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_FISHEYE);
                mEffect.setParameter("scale", .5f);
                break;

            case 10:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_GRAIN);
                mEffect.setParameter("strength", 1.0f);
                break;
            case 11:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_GRAYSCALE);
                break;

            case 12:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_LOMOISH);
                break;
            case 13:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_NEGATIVE);
                break;
            case 14:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_POSTERIZE);
                break;
            case 15:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_SATURATE);
                mEffect.setParameter("scale", .5f);
                break;
            case 16:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_SEPIA);
                break;
            case 17:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_SHARPEN);
                break;
            case 18:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_TEMPERATURE);
                mEffect.setParameter("scale", .9f);
                break;
            case 19:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_TINT);
                mEffect.setParameter("tint", Color.MAGENTA);
                break;
            case 20:
                mEffect = effectFactory.createEffect(EffectFactory.EFFECT_VIGNETTE);
                mEffect.setParameter("scale", .5f);
                break;
            default:
                break;
        }
    }

    private void applyEffect() {
        mEffect.apply(mTextures[0], mImageWidth, mImageHeight, mTextures[1]);
    }

    private void renderResult() {
        if (mCurrentEffect != 0) {
            // if no effect is chosen, just render the original bitmap
            mTexRenderer.renderTexture(mTextures[1]);
        } else {
            // render the result of applyEffect()
            mTexRenderer.renderTexture(mTextures[0]);
        }
    }

    //set up purchase

    private void setUpPurchase(){
        // init purchase
        Intent serviceIntent =
                new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        bindService(serviceIntent, mServiceConn, Context.BIND_AUTO_CREATE);


        String base64EncodedPublicKey = null;

        // compute your public key and store it in base64EncodedPublicKey
        mHelper = new IabHelper(this, base64EncodedPublicKey);

        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            @Override
            public void onIabSetupFinished(IabResult result) {
                if (!result.isSuccess()) {
                    // Oh no, there was a problem.
                    Log.d("TW", "Problem setting up In-app Billing: " + result);
                }else {
                    Log.d("TW", "In-app Billing is set up OK");
                }
                // Hooray, IAB is fully set up!
            }
        });
    }

    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener(){

        @Override
        public void onIabPurchaseFinished(IabResult result, Purchase info) {
            if (result.isFailure()){
                // Handle error
                return;
            }else if (info.getSku().equals(SKU_ITEM)){
                //succes
                consumeItem();
            }
        }
    };

    public void consumeItem() {
        try {
            mHelper.queryInventoryAsync(mReceivedInventoryListener);
        } catch (IabHelper.IabAsyncInProgressException e) {
            e.printStackTrace();
        }
    }

    IabHelper.QueryInventoryFinishedListener mReceivedInventoryListener
            = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result,
                                             Inventory inventory) {


            if (result.isFailure()) {
                // Handle failure
            } else {
                try {
                    mHelper.consumeAsync(inventory.getPurchase(SKU_ITEM),
                            mConsumeFinishedListener);
                } catch (IabHelper.IabAsyncInProgressException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener =
            new IabHelper.OnConsumeFinishedListener() {
                public void onConsumeFinished(Purchase purchase,
                                              IabResult result) {

                    if (result.isSuccess()) {
                        // succes
                    } else {
                        // handle error
                    }
                }
            };

    // Implement in purchase fragment
    @Override
    public void onClosePurchase(DialogInterface dialog) {
        dialog.dismiss();
    }

    @Override
    public void onClickPurchase() {
        try {
            mHelper.launchPurchaseFlow(this, SKU_ITEM, 10001, mPurchaseFinishedListener, "mypurchasetoken");
        } catch (IabHelper.IabAsyncInProgressException e) {
            e.printStackTrace();
        }
    }


    private class ExportTask extends AsyncTask<Void, Void, Void> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Please wait, Processing...");
            progressDialog.show();
            isExport = true;
            GLView.requestRender();
        }

        @Override
        protected Void doInBackground(Void... params) {
            do {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (isExport);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    imvExported.setImageBitmap(bitmapEffected);
                    GLView.setVisibility(View.GONE);
                    imvExported.setVisibility(View.VISIBLE);
                }
            });
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            View content = findViewById(R.id.rl_box);
            content.setDrawingCacheEnabled(true);
            content.buildDrawingCache();
            Bitmap rlBitmap = content.getDrawingCache();
            String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
            File myDir = new File(root + "/TextSwag");
            myDir.mkdirs();
            final String fname = "TextSwag-" + System.currentTimeMillis() + ".png";
            final File file = new File(myDir, fname);
            if (file.exists()) file.delete();
            try {
                FileOutputStream out = new FileOutputStream(file);
                rlBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                out.flush();
                out.close();
                content.invalidate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                content.setDrawingCacheEnabled(false);
            }
//            imageLocalPath = file.getAbsolutePath();
//            Toast.makeText(getBaseContext(), "The image has been saved in sd card: "
//                    + file.getAbsolutePath(), Toast.LENGTH_LONG).show();
//            onCreateDialog(CATEGORY_ID);
            refreshView();

            showActivityShare(file.getAbsolutePath());

            //add 10/04/16
            // Tell the media scanner about the new file so that it is
            // immediately available to the user.
            MediaScannerConnection.scanFile(getBaseContext(), new String[] { file.toString() }, null,
                    new MediaScannerConnection.OnScanCompletedListener() {
                        public void onScanCompleted(String path, Uri uri) {
                            imageLocalPath = path;
                            Log.i("ExternalStorage", "Scanned " + path + ":");
                            Log.i("ExternalStorage", "-> uri=" + uri);
                        }
                    });
            //end
            //SonTH
            interstitialAd = new InterstitialAd(mContext);
            interstitialAd.setAdUnitId("ca-app-pub-9530168898799729/8364966695");
            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    displayAds();
                }
            });
            loadAd();
        }
    }

    public void showActivityShare(String imageLocalPath){
        this.finish();
        Intent it_share = new Intent(this, ShareActivity.class);
        it_share.putExtra("ddt", imageLocalPath);
        startActivity(it_share);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    private void loadAd()
    {
        interstitialAd.loadAd(new AdRequest.Builder().build());
    }

    private void displayAds()
    {
        if (interstitialAd.isLoaded())
        {
            interstitialAd.show();
        }
    }

    public void onBackStartActivity(){
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        setResult(RESULT_CANCELED);
        finish();
        overridePendingTransition(R.anim.slide_in_back, R.anim.slide_out_back);
    }

    @Override
    public void onBackPressed() {
        onBackStartActivity();
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mService != null) {
            unbindService(mServiceConn);
        }
    }
}
