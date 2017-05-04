package com.hfad.viscosity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Load extends AppCompatActivity {
    EditText jobName;
    Button OkButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        jobName = (EditText) findViewById(R.id.job);
        OkButton = (Button) findViewById(R.id.OK);
        OkButton.setEnabled(false);


        jobName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                OkButton.setEnabled(true);
                return true;
            }
        });

    }

    public void okClicked(View view){
        Intent intent = new Intent(Load.this, Measurements.class);
        intent.putExtra("JobName", jobName.getText().toString().trim());
        startActivity(intent);
    }
}
