package com.hfad.viscosity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.media.tv.TvContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TopLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

    }

    public void captureClicked(View view){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent intent = new Intent(TopLevelActivity.this, BluetoothActivity.class);
                        startActivity(intent);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //NO THEN GO STRAIGHT TO CAPTURING FROM PHONE!
                        break;
                }
            }
        };
        Context context = view.getContext();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Do you want to use the temperature sensor?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();

    }

    public  void processClicked(View view){
        Intent intent = new Intent(TopLevelActivity.this, ProcessPhotos.class);
        startActivity(intent);
    }

    public  void historyClicked(View view){
        Intent intent = new Intent(TopLevelActivity.this, DisplayHistory.class);
        startActivity(intent);
    }

    public  void loadClicked(View view){
        Intent intent = new Intent(TopLevelActivity.this, Load.class);
        startActivity(intent);
    }


}
