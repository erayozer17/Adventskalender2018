package com.ozer.eray.adventskalender2018;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,
            imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,
            imageView15,imageView16,imageView17,imageView18,imageView19,imageView20,imageView21,
            imageView22,imageView23,imageView24;

    private String mesaj = null;
    private Integer gun;
    private Calendar calendar = Calendar.getInstance();
    private JsonHelper jsonHelper;
    private ImageView[] tuslarYardimci;
    public static int gunYardimci;
    private static final int HANGI_AYDA_BASLASIN = 11;
    private static final int HANGI_YILDA_BASLASIN = 2017;
    private static final int ADVENT_HANGİ_GUN_BASLIYOR = 1;
    private static final int RC_HANDLE_CAMERA_PERM = 2;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        calendar.setTime(new Date());
        jsonHelper = new JsonHelper(getApplicationContext());
        final int hangiGun = calendar.get(Calendar.DAY_OF_MONTH);
        final int ay = calendar.get(Calendar.MONTH);
        final int yil = calendar.get(Calendar.YEAR);
        if (!isDateValidToShow(hangiGun,ay,yil)){
            zamaniGelmeyenAlert();
        } else {
            int rc = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
            if (rc != PackageManager.PERMISSION_GRANTED) {
                requestCameraPermission();
            }
        }
        ImageView[] tuslar = {imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,
                imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,
                imageView14,imageView15,imageView16,imageView17,imageView18,imageView19,
                imageView20,imageView21,imageView22,imageView23,imageView24};
        tuslarYardimci = tuslar;

        for (ImageView aTuslar : tuslar) {
            aTuslar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dinle(view);
                    if (isDateValidToActivateButton(hangiGun,ay,yil)){
                        kuralAlertDialogGoster();
                    } else {
                        Toast.makeText(getApplicationContext(),"Daha zamanı değil",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void init(){
        imageView1 = (ImageView) findViewById(R.id.resim1);
        imageView2 = (ImageView) findViewById(R.id.resim2);
        imageView3 = (ImageView) findViewById(R.id.resim3);
        imageView4 = (ImageView) findViewById(R.id.resim4);
        imageView5 = (ImageView) findViewById(R.id.resim5);
        imageView6 = (ImageView) findViewById(R.id.resim6);
        imageView7 = (ImageView) findViewById(R.id.resim7);
        imageView8 = (ImageView) findViewById(R.id.resim8);
        imageView9 = (ImageView) findViewById(R.id.resim9);
        imageView10 = (ImageView) findViewById(R.id.resim10);
        imageView11 = (ImageView) findViewById(R.id.resim11);
        imageView12 = (ImageView) findViewById(R.id.resim12);
        imageView13 = (ImageView) findViewById(R.id.resim13);
        imageView14 = (ImageView) findViewById(R.id.resim14);
        imageView15 = (ImageView) findViewById(R.id.resim15);
        imageView16 = (ImageView) findViewById(R.id.resim16);
        imageView17 = (ImageView) findViewById(R.id.resim17);
        imageView18 = (ImageView) findViewById(R.id.resim18);
        imageView19 = (ImageView) findViewById(R.id.resim19);
        imageView20 = (ImageView) findViewById(R.id.resim20);
        imageView21 = (ImageView) findViewById(R.id.resim21);
        imageView22 = (ImageView) findViewById(R.id.resim22);
        imageView23 = (ImageView) findViewById(R.id.resim23);
        imageView24 = (ImageView) findViewById(R.id.resim24);
    }

    public void dinle(View view) {
        switch (view.getId()){
            case R.id.resim1:
                setGun(1);
                break;
            case R.id.resim2:
                setGun(2);
                break;
            case R.id.resim3:
                setGun(3);
                break;
            case R.id.resim4:
                setGun(4);
                break;
            case R.id.resim5:
                setGun(5);
                break;
            case R.id.resim6:
                setGun(6);
                break;
            case R.id.resim7:
                setGun(7);
                break;
            case R.id.resim8:
                setGun(8);
                break;
            case R.id.resim9:
                setGun(9);
                break;
            case R.id.resim10:
                setGun(10);
                break;
            case R.id.resim11:
                setGun(11);
                break;
            case R.id.resim12:
                setGun(12);
                break;
            case R.id.resim13:
                setGun(13);
                break;
            case R.id.resim14:
                setGun(14);
                break;
            case R.id.resim15:
                setGun(15);
                break;
            case R.id.resim16:
                setGun(16);
                break;
            case R.id.resim17:
                setGun(17);
                break;
            case R.id.resim18:
                setGun(18);
                break;
            case R.id.resim19:
                setGun(19);
                break;
            case R.id.resim20:
                setGun(20);
                break;
            case R.id.resim21:
                setGun(21);
                break;
            case R.id.resim22:
                setGun(22);
                break;
            case R.id.resim23:
                setGun(23);
                break;
            case R.id.resim24:
                setGun(24);
                break;
            default:
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Application crashed",Toast.LENGTH_LONG).show();
                    finish();
                }
        }
    }

    public void kuralAlertDialogGoster(){
        Drawable drawable = tuslarYardimci[gun-1].getDrawable();
        SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText(gun+ " December")
                .setContentText("Today's Rule: "+gununKuraliniGoster())
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        Intent i = new Intent(MainActivity.this,FaceTrackerActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                        finish();
                    }
                });
        if(drawable != null){
            pDialog.setCustomImage(drawable);
        } else {
            pDialog.setCustomImage(R.drawable.crystalball);
        }
        pDialog.show();
    }

    public void zamaniGelmeyenAlert(){
        SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("Hallo")
                .setContentText("It's Not The Time Yet :)")
                .setCustomImage(R.drawable.christmastree)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        finish();
                    }
                });
        pDialog.show();
    }

    public String gununKuraliniGoster(){
        int gun = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int kural = gun % 8;
        String gununMesajı;
        if (kural == 0){
            gununMesajı = "Smile, both eyes open";
        } else if (kural == 1){
            gununMesajı = "Smile, left eye closed, right eye open";
        } else if (kural == 2){
            gununMesajı = "Smile, left eye open, right eye closed";
        } else if (kural == 3){
            gununMesajı = "Smile, both eyes closed";
        } else if (kural == 4){
            gununMesajı = "Don't smile, both eyes open";
        } else if (kural == 5){
            gununMesajı = "Don't smile, left eye closed, right eye open";
        } else if (kural == 6){
            gununMesajı = "Don't smile, left eye open, right eye closed";
        } else {
            gununMesajı = "Don't smile, both eyes closed";
        }
        return gununMesajı;
    }

    private boolean isDateValidToShow(int hangiGun, int ay, int yil){
        return ay == HANGI_AYDA_BASLASIN
                && yil == HANGI_YILDA_BASLASIN
                && hangiGun >= ADVENT_HANGİ_GUN_BASLIYOR;
    }

    private boolean isDateValidToActivateButton(int hangiGun, int ay, int yil){
        return hangiGun >= gun
                && ay == HANGI_AYDA_BASLASIN
                && yil == HANGI_YILDA_BASLASIN;
    }

    public Integer getGun() {
        return gunYardimci;
    }

    public void setGun(Integer gun) {
        this.gun = gun;
        gunYardimci = gun;
    }

    private void requestCameraPermission() {
        Log.w(TAG, "Camera permission is not granted. Requesting permission");

        final String[] permissions = new String[]{Manifest.permission.CAMERA};

        if (!ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(this, permissions, RC_HANDLE_CAMERA_PERM);
            return;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode != RC_HANDLE_CAMERA_PERM) {
            Log.d(TAG, "Got unexpected permission result: " + requestCode);
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            return;
        }

        if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Camera permission granted - initialize the camera source");
            //createCameraSource();
            return;
        }

        Log.e(TAG, "Permission not granted: results len = " + grantResults.length +
                " Result code = " + (grantResults.length > 0 ? grantResults[0] : "(empty)"));

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Face Tracker sample")
                .setMessage(R.string.no_camera_permission)
                .setPositiveButton(R.string.ok, listener)
                .show();
    }
}