package com.ozer.eray.adventskalender2018;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,
            imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16,
            imageView17,imageView18,imageView19,imageView20,imageView21;

    private String mesaj = null;
    private Integer gun;
    private Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        calendar.setTime(new Date());
        final int ay = calendar.get(Calendar.MONTH);
        final int yil = calendar.get(Calendar.YEAR);
        ImageView[] tuslar = {imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,
                imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,
                imageView14,imageView15,imageView16,imageView17,imageView18,imageView19,
                imageView20,imageView21};


        for (ImageView aTuslar : tuslar) {
            aTuslar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dinle(view);
                    if ((calendar.get(Calendar.DAY_OF_MONTH) >= gun) && ay == 9 && yil == 2017){
                        kuralAlertDialogGoster(MainActivity.this);
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
    }

    public void dinle(View view) {
        switch (view.getId()){
            case R.id.resim1:
                gun = 3;
                mesajSetle();
                break;
            case R.id.resim2:
                gun = 4;
                mesajSetle();
                break;
            case R.id.resim3:
                gun = 5;
                mesajSetle();
                break;
            case R.id.resim4:
                gun = 6;
                mesajSetle();
                break;
            case R.id.resim5:
                gun = 7;
                mesajSetle();
                break;
            case R.id.resim6:
                gun = 8;
                mesajSetle();
                break;
            case R.id.resim7:
                gun = 9;
                mesajSetle();
                break;
            case R.id.resim8:
                gun = 10;
                mesajSetle();
                break;
            case R.id.resim9:
                gun = 11;
                mesajSetle();
                break;
            case R.id.resim10:
                gun = 12;
                mesajSetle();
                break;
            case R.id.resim11:
                gun = 13;
                mesajSetle();
                break;
            case R.id.resim12:
                gun = 14;
                mesajSetle();
                break;
            case R.id.resim13:
                gun = 15;
                mesajSetle();
                break;
            case R.id.resim14:
                gun = 16;
                mesajSetle();
                break;
            case R.id.resim15:
                gun = 17;
                mesajSetle();
                break;
            case R.id.resim16:
                gun = 18;
                mesajSetle();
                break;
            case R.id.resim17:
                gun = 19;
                mesajSetle();
                break;
            case R.id.resim18:
                gun = 20;
                mesajSetle();
                break;
            case R.id.resim19:
                gun = 21;
                mesajSetle();
                break;
            case R.id.resim20:
                gun = 22;
                mesajSetle();
                break;
            case R.id.resim21:
                gun = 23;
                mesajSetle();
                break;
            default:
                mesaj = "bu default mesaj";
        }
    }
    
    private void mesajSetle(){
        mesaj = gettingMesaj(gun);
    }

    @Nullable
    private String loadJSONFromAsset(){
        String json;
        try {
            InputStream is = getAssets().open("properties.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            int isRead = is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public String gettingMesaj(int gun){
        try{
            JSONObject reader = new JSONObject(loadJSONFromAsset());
            return reader.getString(Integer.toString(gun));
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void kuralAlertDialogGoster(Context context){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle("Gunun Kuralı")
                .setMessage(gununKuraliniGoster())
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(MainActivity.this,FaceTrackerActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                        finish();
                    }
                })
                .show();
    }

    public String gununKuraliniGoster(){
        int gun = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int kural = gun % 8;
        String gununMesajı;
        if (kural == 0){
            gununMesajı = "İki gözün açık gül";
        } else if (kural == 1){
            gununMesajı = "Sol göz kapalı sağ göz açık gül";
        } else if (kural == 2){
            gununMesajı = "Sol göz açık sağ göz kapalı gül";
        } else if (kural == 3){
            gununMesajı = "İki gözün kapalı gül";
        } else if (kural == 4){
            gununMesajı = "İki gözün açık gülme";
        } else if (kural == 5){
            gununMesajı = "Sol göz kapalı sağ göz açık gülme";
        } else if (kural == 6){
            gununMesajı = "Sol göz açık sağ göz kapalı gülme";
        } else {
            gununMesajı = "İki gözün kapalı gülme";
        }
        return gununMesajı;
    }
}