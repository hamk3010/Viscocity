package com.hfad.viscosity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ProcessData extends AppCompatActivity {
    private ViscosityData[] myData=new ViscosityData[3];
    private EditText edtext;
    URL url;
    URLConnection client = null;
    BufferedReader reader;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_data);
        edtext= (EditText) findViewById(R.id.reponse);
        for(int i=0; i<myData.length; i++) {
            if (myData[i] == null) {
                myData[i] = new ViscosityData();
            }
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            myData[0].setPowerData(extras.getFloatArray("PowerData1"));
            myData[0].setFreqData(extras.getFloatArray("FreqData1"));
            myData[0].setTempData(extras.getFloatArray("TempData1"));
            myData[0].setVideoUri(extras.getStringArray("VideoUri1"));

            myData[1].setPowerData(extras.getFloatArray("PowerData2"));
            myData[1].setFreqData(extras.getFloatArray("FreqData2"));
            myData[1].setTempData(extras.getFloatArray("TempData2"));
            myData[1].setVideoUri(extras.getStringArray("VideoUri2"));

            myData[2].setPowerData(extras.getFloatArray("PowerData3"));
            myData[2].setFreqData(extras.getFloatArray("FreqData3"));
            myData[2].setTempData(extras.getFloatArray("TempData3"));
            myData[2].setVideoUri(extras.getStringArray("VideoUri3"));
        }



        try {
//            url = new URL("SERVER NAME GOES HERE");
            url = new URL("http://www.example.com/comment");
            client =  url.openConnection();
//            client.setRequestMethod("POST");
//            client.setRequestProperty("deviceID", Float.toString(myData[0].getPowerData()[0]));
//            client.setRequestProperty("jobName", "Test");
            client.setDoOutput(true);

            String powData = "[";

            if(myData[0].getPowerData() != null) {
                for (int i = 0; i < 10; i++) {
                    powData += URLEncoder.encode(Float.toString(myData[0].getPowerData()[i]), "UTF-8");
                    if (i == 9) {
                        powData += "]";
                    } else {
                        powData += ",";
                    }
                }
            }


            if(myData[1].getPowerData() != null) {
                powData+=",[";
                for (int i = 0; i < 10; i++) {
                    powData += URLEncoder.encode(Float.toString(myData[1].getPowerData()[i]), "UTF-8");
                    if (i == 9) {
                        powData += "]";
                    } else {
                        powData += ",";
                    }
                }
            }


            if(myData[2].getPowerData() != null) {
                powData+=",[";
                for (int i = 0; i < 10; i++) {
                    powData += URLEncoder.encode(Float.toString(myData[2].getPowerData()[i]), "UTF-8");
                    if (i == 9) {
                        powData += "]";
                    } else {
                        powData += ",";
                    }
                }
            }
            OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
            writer.write(powData);
            writer.flush();
            writer.close();

            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null) {
                sb.append(line+"\n");
            }
            edtext.setText(sb.toString());


        }
        catch(MalformedURLException e){
            edtext.setText("There was Malformed Error");
        }
        catch(IOException e){
            edtext.setText("There was IO Error");
        }finally
        {
            try
            {

                reader.close();
            }

            catch(Exception ex) {}
        }

        // Show response on activity
        edtext.setText( text  );






    }

}
