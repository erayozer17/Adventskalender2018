package com.ozer.eray.adventskalender2018;

import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class kameraSonrasiActivity extends AppCompatActivity {

    private static final int VIBRATION_DURATION = 700;
    private String mesaj;
    private JsonHelper jsonHelper;
    private Calendar calendar = Calendar.getInstance();
    private MainActivity mainActivity;
    private int gun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera_sonrasi);

        mainActivity = new MainActivity();
        gun = mainActivity.getGun();
        jsonHelper = new JsonHelper(getApplicationContext());
        mesaj = jsonHelper.gettingMesaj(gun);

        ringRing();
        vibrate();
        kuralAlertDialogGoster();
    }

    private void ringRing(){
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void vibrate(){
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(VIBRATION_DURATION);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(kameraSonrasiActivity.this,MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }

    public void kuralAlertDialogGoster(){
        SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText(gun+ " December")
                .setContentText(mesaj)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        Intent i = new Intent(kameraSonrasiActivity.this,MainActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                        finish();
                    }
                });
        pDialog.show();
    }
}
