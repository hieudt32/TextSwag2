package com.word.swag.text.Activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.word.swag.text.Fragment.PurchaseFragment;
import com.word.swag.text.Fragment.RatingFragment;
import com.word.swag.text.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.jar.Manifest;

/**
 * Created by ThanhDat on 1/11/16.
 */
public class StartActivity extends Activity {

    public static final int ID_CAMERA = 1001;
    public static final int ID_ALBUM = 1002;
    private String pictureImagePath = "";
    private File mFileTemp;
    public static final int MY_PERMISSIONS_ALL = 2000;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 2001;
    public static final int MY_PERMISSIONS_EXTERNAL_STORAGE = 2002;


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
        setContentView(R.layout.activity_start);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.M){
            this.checkALlPermissions();
        }else {
            return;
        }

        AdView adView = (AdView) this.findViewById(R.id.adsView);
        AdRequest adRequest = new AdRequest.Builder().build();
        if (adView != null) {
            adView.loadAd(adRequest);
        }

        // Test show dialog
//        onShowDialogRating();
//        showActivityShare();
//        PurchaseFragment purchaseFragment = new PurchaseFragment().newInstance("pur");
//        purchaseFragment.show(getFragmentManager(), "dialofg");
    }

    public void onClickChoose(View view) {
        switch (view.getId()) {
            case R.id.fl_camera:
                // check camera request permission on android marshmallow
                if (Build.VERSION.SDK_INT == Build.VERSION_CODES.M){
                    ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA},
                            MY_PERMISSIONS_REQUEST_CAMERA);
                }else {
                    loadCamera();
                }


                break;
            case R.id.fl_album:
                // check external storage request permission on android marshmallow
                if (Build.VERSION.SDK_INT == Build.VERSION_CODES.M) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE,
                                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            MY_PERMISSIONS_EXTERNAL_STORAGE);
                }else {
                    loadAlbum();
                }

                break;
            case R.id.fl_help:
                dialogHelp();
                break;
        }
    }

    // check all permissions
    private void checkALlPermissions(){
        ActivityCompat.requestPermissions(this,
                new String[]{android.Manifest.permission.CAMERA,
                        android.Manifest.permission.READ_EXTERNAL_STORAGE,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                MY_PERMISSIONS_ALL);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {

            case MY_PERMISSIONS_ALL:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    Toast.makeText(this, "permission denied",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case MY_PERMISSIONS_REQUEST_CAMERA: {

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        loadCamera();

                } else {
                    Toast.makeText(this, "permission denied",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case MY_PERMISSIONS_EXTERNAL_STORAGE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    loadAlbum();
                }else {
                    Toast.makeText(this, "permission denied",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    private void loadAlbum() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, ID_ALBUM);
    }

    private void loadCamera() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = timeStamp + ".jpg";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        pictureImagePath = storageDir.getAbsolutePath() + "/" + imageFileName;
        File file = new File(pictureImagePath);
        Uri outputFileUri = Uri.fromFile(file);
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        startActivityForResult(cameraIntent, ID_CAMERA);
    }

    private void startActivityCrop(String path) {
        Intent intent = new Intent(this, CropActivity.class);
        intent.putExtra("image", path);
        startActivity(intent);
        this.finish();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public void dialogHelp() {
        TextView title = new TextView(this);
        // You Can Customise your Title here
        title.setText("Help");
        title.setPadding(10, 10, 10, 10);
        title.setGravity(Gravity.CENTER);
        title.setTextSize(25);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCustomTitle(title);
        builder.setCancelable(false);
        builder.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        final AlertDialog dialog = builder.create();
        LayoutInflater inflater = getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.dialog_help, null);
        dialog.setView(dialogLayout);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.show();

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface d) {
                ImageView image = (ImageView) dialog.findViewById(R.id.imv_help);
                Bitmap icon = BitmapFactory.decodeResource(getResources(),
                        R.mipmap.help);
                float imageWidthInPX = (float) image.getWidth();

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Math.round(imageWidthInPX),
                        Math.round(imageWidthInPX * (float) icon.getHeight() / (float) icon.getWidth()));
                image.setLayoutParams(layoutParams);


            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case ID_CAMERA:
                    if (pictureImagePath != null) startActivityCrop(pictureImagePath);
                    break;
                case ID_ALBUM:
                    Uri uri_album = data.getData();
                    String pathFromAlbum;
                    // SDK >= 11 && SDK < 19
                    if (Build.VERSION.SDK_INT < 19 && Build.VERSION.SDK_INT >= 11) {
                        pathFromAlbum = getRealPathFromURI_API11to18(this,
                                uri_album);
                    }
                    // SDK > 19 (Android 4.4)
                    else {

                        pathFromAlbum = getPathFromAPI19Above(this, uri_album);
                    }

                    if (pathFromAlbum != null) {
                        startActivityCrop(pathFromAlbum);
                    } else {
                        if (isNetworkAvailable(StartActivity.this)){
                            new TaskDownloadPicture(StartActivity.this).execute(data);
                        }else {
                            Toast.makeText(StartActivity.this, "Oops! No internet connection.", Toast.LENGTH_LONG).show();
                        }

                    }
                    break;
            }
        }
    }


    //get path from uri
    @SuppressLint("NewApi")
    public static String getRealPathFromURI_API11to18(Context context,
                                                      Uri contentUri) {
        String[] proj = {MediaStore.Video.Media.DATA};
        String result = null;

        CursorLoader cursorLoader = new CursorLoader(context, contentUri, proj,
                null, null, null);
        Cursor cursor = cursorLoader.loadInBackground();

        if (cursor != null) {
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            result = cursor.getString(column_index);
        }
        return result;
    }

    //for KitKat

    /**
     * Get a file path from a Uri. This will get the the path for Storage Access
     * Framework Documents, as well as the _data field for the MediaStore and
     * other file-based ContentProviders.
     *
     * @param context The context.
     * @param uri     The Uri to query.
     * @author paulburke
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String getPathFromAPI19Above(final Context context, final Uri uri) {

        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }

                // TODO handle non-primary volumes
            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{
                        split[1]
                };

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            // Return the remote address
            if (isGooglePhotosUri(uri))
                return uri.getLastPathSegment();
            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        } else {
            Toast.makeText(context, "Opp", Toast.LENGTH_LONG).show();
        }

        return null;
    }


    /**
     * Get the value of the data column for this Uri. This is useful for
     * MediaStore Uris, and other file-based ContentProviders.
     *
     * @param context       The context.
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    public static String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }


    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Photos.
     */
    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing App")
                .setMessage("Are you sure you want to close this app?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    public String createPictureOnInternet(Intent data) {

        String pathPictureOnDrive = "";
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            mFileTemp = new File(Environment.getExternalStorageDirectory(), "TEMP_PHOTO_FILE_NAME");
        } else {
            mFileTemp = new File(getFilesDir(), "TEMP_PHOTO_FILE_NAME");
        }
        try {

            InputStream inputStream = getContentResolver().openInputStream(data.getData());
            FileOutputStream fileOutputStream = new FileOutputStream(mFileTemp);
            copyStream(inputStream, fileOutputStream);
            fileOutputStream.close();
            inputStream.close();

            pathPictureOnDrive = mFileTemp.getPath();

        } catch (Exception e) {

            Log.e("TAG", "Error while creating temp file", e);
        }

        return pathPictureOnDrive;

    }

    public static void copyStream(InputStream input, OutputStream output)
            throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
    }

    public class TaskDownloadPicture extends AsyncTask<Intent, String, String> {
        private Context context;
        private ProgressDialog progressDialog;

        public TaskDownloadPicture(Context context) {
            this.context = context;
        }



        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Downloading...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Intent... params) {
            return createPictureOnInternet(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null){
                startActivityCrop(s);
            }else {
                Toast.makeText(context, "Oops! Please try again.", Toast.LENGTH_LONG).show();
            }

        }
    }

    public boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
