package com.word.swag.text.Activity;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.isseiaoki.simplecropview.CropImageView;
import com.isseiaoki.simplecropview.callback.CropCallback;
import com.isseiaoki.simplecropview.callback.LoadCallback;
import com.isseiaoki.simplecropview.callback.SaveCallback;
import com.word.swag.text.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ThanhDat on 1/10/16.
 */
public class CropActivity extends Activity implements View.OnClickListener {

    private CropImageView cropImageView;
    private Bitmap mBitmap;
    private Bitmap mBitmapPath;
    private ContentResolver mContentResolver;
    private ProgressDialog progressDialog;
    final int IMAGE_MAX_SIZE = 1024;
    private TextView tv_crop_free, tv_crop_1x1, tv_crop_3x4, tv_crop_4x3, tv_crop_16x9, tv_crop_9x16,
            tv_crop, tv_cancel;
    private FrameLayout fl_home, fl_done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (Build.VERSION.SDK_INT < 16) {
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        }else {
//
//            View decorView = getWindow().getDecorView();
//            // Hide the status bar.
//            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//            // Remember that you should never show the action bar if the
//            // status bar is hidden, so hide that too if necessary.
//            ActionBar actionBar = getActionBar();
//            if (actionBar != null){
//                actionBar.hide();
//            }
//
//        }
        setContentView(R.layout.activity_crop);
        mContentResolver = getContentResolver();
        cropImageView = (CropImageView) findViewById(R.id.cropImageView);
        cropImageView.setCropMode(CropImageView.CropMode.FREE);
        init();
        getStringPath();


    }

    public void init() {
        tv_crop_free = (TextView) findViewById(R.id.tv_crop_free);
        tv_crop_1x1 = (TextView) findViewById(R.id.tv_crop_1x1);
        tv_crop_3x4 = (TextView) findViewById(R.id.tv_crop_3x4);
        tv_crop_4x3 = (TextView) findViewById(R.id.tv_crop_4x3);
        tv_crop_16x9 = (TextView) findViewById(R.id.tv_crop_16x9);
        tv_crop_9x16 = (TextView) findViewById(R.id.tv_crop_9x16);
//        tv_crop = (TextView) findViewById(R.id.tv_crop);
//        tv_cancel = (TextView) findViewById(R.id.tv_crop_cancel);
        fl_home = (FrameLayout) findViewById(R.id.fl_home);
        fl_done = (FrameLayout) findViewById(R.id.fl_done);
        tv_crop_free.setOnClickListener(this);
        tv_crop_1x1.setOnClickListener(this);
        tv_crop_3x4.setOnClickListener(this);
        tv_crop_4x3.setOnClickListener(this);
        tv_crop_16x9.setOnClickListener(this);
        tv_crop_9x16.setOnClickListener(this);
//        tv_crop.setOnClickListener(this);
//        tv_cancel.setOnClickListener(this);
        fl_home.setOnClickListener(this);
        fl_done.setOnClickListener(this);
        tv_crop_free.setEnabled(false);
    }

    public void onClickRotateFlip(View view) {
        switch (view.getId()) {
            case R.id.vi_rotate_left:
                cropImageView.rotateImage(CropImageView.RotateDegrees.ROTATE_270D);
                break;
            case R.id.vi_rotate_right:
                cropImageView.rotateImage(CropImageView.RotateDegrees.ROTATE_90D);
                break;
            case R.id.vi_flip:
                flipImage();
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fl_done:
//                new MyTask(CropActivity.this).execute();
                this.cropImage();
                break;
            case R.id.fl_home:
                loadBackStartActivity();

                break;
            case R.id.tv_crop_free:
                refreshEnabled();
                tv_crop_free.setEnabled(false);
                cropImageView.setCropMode(CropImageView.CropMode.FREE);
                break;
            case R.id.tv_crop_1x1:
                refreshEnabled();
                tv_crop_1x1.setEnabled(false);
                cropImageView.setCropMode(CropImageView.CropMode.SQUARE);
                break;
            case R.id.tv_crop_3x4:
                refreshEnabled();
                tv_crop_3x4.setEnabled(false);
                cropImageView.setCropMode(CropImageView.CropMode.RATIO_3_4);
                break;
            case R.id.tv_crop_4x3:
                refreshEnabled();
                tv_crop_4x3.setEnabled(false);
                cropImageView.setCropMode(CropImageView.CropMode.RATIO_4_3);
                break;
            case R.id.tv_crop_16x9:
                refreshEnabled();
                tv_crop_16x9.setEnabled(false);
                cropImageView.setCropMode(CropImageView.CropMode.RATIO_16_9);
                break;
            case R.id.tv_crop_9x16:
                refreshEnabled();
                tv_crop_9x16.setEnabled(false);
                cropImageView.setCropMode(CropImageView.CropMode.RATIO_9_16);
                break;
        }
    }

    public void refreshEnabled() {
        tv_crop_free.setEnabled(true);
        tv_crop_1x1.setEnabled(true);
        tv_crop_3x4.setEnabled(true);
        tv_crop_4x3.setEnabled(true);
        tv_crop_16x9.setEnabled(true);
        tv_crop_9x16.setEnabled(true);
    }

    public void loadBackStartActivity() {
        setResult(RESULT_CANCELED);
        finish();
        Intent it_back = new Intent(this, StartActivity.class);
        startActivity(it_back);
        overridePendingTransition(R.anim.slide_in_back, R.anim.slide_out_back);
    }

    public void getStringPath() {
        Bundle bundle = getIntent().getExtras();
        String path = bundle.getString("image");
        Log.d("path", "cropA: " + path);
        try {
            if (path != null)
                cropImageView.setImageBitmap(rotateImageIfRequired(getBitmap(path), path));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void flipImage() {
        Bitmap source = cropImageView.getImageBitmap();
        if (source == null) return;
        Matrix matrix = new Matrix();
        matrix.setScale(-1, 1);
        matrix.postTranslate(source.getWidth(), 0);
        Bitmap flip = Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
        cropImageView.setImageBitmap(flip);
    }

    private Uri getImageUri(String path) {

        return Uri.fromFile(new File(path));
    }

    private Bitmap getBitmap(String path) {

        Uri uri = getImageUri(path);
        InputStream in = null;
        if (uri != null) {
            try {
                in = mContentResolver.openInputStream(uri);

                //Decode image size
                BitmapFactory.Options o = new BitmapFactory.Options();
                o.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(in, null, o);
                in.close();

                int scale = 1;
                if (o.outHeight > IMAGE_MAX_SIZE || o.outWidth > IMAGE_MAX_SIZE) {
                    scale = (int) Math.pow(2, (int) Math.round(Math.log(IMAGE_MAX_SIZE / (double) Math.max(o.outHeight, o.outWidth)) / Math.log(0.5)));
                }

                BitmapFactory.Options o2 = new BitmapFactory.Options();
                o2.inSampleSize = scale;
                in = mContentResolver.openInputStream(uri);
                Bitmap b = BitmapFactory.decodeStream(in, null, o2);
                in.close();
                return b;
            } catch (FileNotFoundException e) {
                Log.e("dat", "file " + path + " not found");
            } catch (IOException e) {
                Log.e("dat", "file " + path + " not found");
            }
        } else {
            Toast.makeText(this, "Image has been deleted!", Toast.LENGTH_SHORT).show();
            finish();
        }
        return null;
    }

    private static Bitmap rotateImageIfRequired(Bitmap img, String path) throws IOException {

        ExifInterface ei = new ExifInterface(path);
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return rotateImage(img, 90);
            case ExifInterface.ORIENTATION_ROTATE_180:
                return rotateImage(img, 180);
            case ExifInterface.ORIENTATION_ROTATE_270:
                return rotateImage(img, 270);
            default:
                return img;
        }
    }

    private static Bitmap rotateImage(Bitmap img, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
        img.recycle();
        return rotatedImg;
    }

//    public class MyTask extends AsyncTask<String, String, String> {
//        private Context context;
//        private ProgressDialog progressDialog;
//
//        public MyTask(Context context) {
//            this.context = context;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            progressDialog = new ProgressDialog(context);
//            progressDialog.setMessage("Processing...");
//            progressDialog.show();
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            //Write file
//            String filename = "bitmap.png";
//            FileOutputStream stream = null;
//            try {
//                stream = context.openFileOutput(filename, Context.MODE_PRIVATE);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            cropImageView.getCroppedBitmap().compress(Bitmap.CompressFormat.PNG, 100, stream);
//
//
//            //Cleanup
//            try {
//                stream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return filename;
//        }
//        @Override
//        protected void onPostExecute(String result) {
//            cropImageView.getCroppedBitmap().recycle();
//            progressDialog.dismiss();
//            //Start other Activity or do whatever you want
//            ((Activity)context).finish();
//            Intent intent = new Intent(context, MainActivity.class);
//            intent.putExtra("image_bitmap", result);
//            startActivity(intent);
//        }
//    }

    public void cropImage() {
        showProgress();
        cropImageView.startCrop(createSaveUri(), mCropCallback, mSaveCallback);
    }

    public Uri createSaveUri() {
        return Uri.fromFile(new File(this.getCacheDir(), "cropped"));
    }


    // Progress ////////////

    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Processing...");
        progressDialog.show();

    }

    public void dismissProgress() {
        progressDialog.dismiss();
    }

    // Callbacks ///////////////////////////////////////////////////////////////////////////////////

    private final LoadCallback mLoadCallback = new LoadCallback() {
        @Override
        public void onSuccess() {
            dismissProgress();
        }

        @Override
        public void onError() {
            dismissProgress();
        }
    };

    private final CropCallback mCropCallback = new CropCallback() {
        @Override
        public void onSuccess(Bitmap cropped) {
        }

        @Override
        public void onError() {
        }
    };

    private final SaveCallback mSaveCallback = new SaveCallback() {
        @Override
        public void onSuccess(Uri outputUri) {
            finish();
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
//            intent.putExtra("imageUri", outputUri);
            intent.setData(outputUri);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            dismissProgress();
        }

        @Override
        public void onError() {
            dismissProgress();
        }
    };

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        setResult(RESULT_CANCELED);
        finish();
        overridePendingTransition(R.anim.slide_in_back, R.anim.slide_out_back);
        super.onBackPressed();
    }
}
