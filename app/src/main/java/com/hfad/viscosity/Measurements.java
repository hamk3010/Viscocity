package com.hfad.viscosity;

import android.app.ActionBar;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Stack;


public class Measurements extends AppCompatActivity {

//    This can be used if we wver try to implement the pluses and the minuses.
//    private RelativeLayout mLayout;
//    private RelativeLayout.LayoutParams layoutParams;
//    private ImageButton subButton=null;
//    static int measurementButtonCounter =1;
//    private Stack<ImageButton> addButtonStack = new Stack<>();
//    private Stack<Button> measurementButtonStack = new Stack<>();
//    private Stack<ImageButton> subButtonStack = new Stack<>();


    private static final int EXPERIMENT1 = 1;
    private static final int EXPERIMENT2 = 2;
    private static final int EXPERIMENT3 = 3;
    private ViscosityData[] myData = new ViscosityData[3];
    private Button processButton;
    private TextView update ;
    SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
    String mDate = format.format(new Date());



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements);

//        measurementButtonStack.push( (Button) findViewById(R.id.measurement) );
//        addButtonStack.push((ImageButton) findViewById(R.id.add_Button));
//        subButtonStack.push((ImageButton) findViewById(R.id.sub_Button));
//        subButtonStack.peek().setEnabled(false);
//        mLayout= (RelativeLayout) findViewById(R.id.relativeLayout);
        processButton= (Button) findViewById(R.id.measurement_process_button);
        update = (TextView) findViewById(R.id.update);
        processButton.setEnabled(false);
        for(int i= 0; i<3; i++){
            if(myData[i] == null) {
                myData[i] = new ViscosityData();
            }
        }

            Bundle extras = getIntent().getExtras();
            if(extras!= null){
                if(extras.get("JobName") != null){
                    for(int i=0; i<3; i++) {
                        myData[i].setJobName(extras.get("JobName").toString());
                    }
                }
                else{
                    for(int i=0; i<3; i++) {
                        myData[i].setJobName("Unknown");
                    }

                }

                if(extras.getFloatArray("PowerData1")!=null){
                    myData[0].setPowerData( extras.getFloatArray("PowerData1"));
                    processButton.setEnabled(true);
                }
                else{
                    myData[0].setPowerData(null);
                }

                if(extras.getFloatArray("FreqData1")!=null){
                    myData[0].setFreqData( extras.getFloatArray("FreqData1"));
                }
                else{
                    myData[0].setFreqData(null);
                }

                if(extras.getFloatArray("TempData1")!=null){
                    myData[0].setTempData( extras.getFloatArray("TempData1"));
                }
                else{
                    myData[0].setTempData(null);
                }
                //Second Data
                if(extras.getFloatArray("PowerData2")!=null){
                    myData[1].setPowerData( extras.getFloatArray("PowerData2"));
                }
                else{
                    myData[1].setPowerData(null);
                }

                if(extras.getFloatArray("FreqData2")!=null){
                    myData[1].setFreqData( extras.getFloatArray("FreqData2"));
                }
                else{
                    myData[1].setFreqData(null);
                }

                if(extras.getFloatArray("TempData2")!=null){
                    myData[1].setTempData( extras.getFloatArray("TempData2"));
                }
                else{
                    myData[1].setTempData(null);
                }
                //The third experiment and the measurements
                if(extras.getFloatArray("PowerData3")!=null){
                    myData[2].setPowerData( extras.getFloatArray("PowerData3"));
                }
                else{
                    myData[2].setPowerData(null);
                }

                if(extras.getFloatArray("FreqData3")!=null){
                    myData[2].setFreqData( extras.getFloatArray("FreqData3"));
                }
                else{
                    myData[2].setFreqData(null);
                }

                if(extras.getFloatArray("TempData3")!=null){
                    myData[2].setTempData( extras.getFloatArray("TempData3"));
                }
                else{
                    myData[2].setTempData(null);
                }






            }




    }


//    public void addClicked(){
//
////                Adds the Measurement 2 Button
//        Button newButton = new Button(measurementButtonStack.peek().getContext());
//        newButton.setId(View.generateViewId());
//        newButton.setText(" MEASUREMENT " + (++measurementButtonCounter)+" ");
//        layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutParams.setMargins(0,10,0,10);
//        layoutParams.addRule(RelativeLayout.BELOW, measurementButtonStack.peek().getId());
//        layoutParams.addRule(RelativeLayout.ALIGN_LEFT, measurementButtonStack.peek().getId());
//        newButton.setLayoutParams(layoutParams);
////      We disable the old button and enable the new button
//        measurementButtonStack.peek().setEnabled(false);
//        measurementButtonStack.push(newButton);
//        mLayout.addView(measurementButtonStack.peek());
//
//
//
//
////                     Adds the new ADD Button
//        ImageButton newAddButton = new ImageButton(addButtonStack.peek().getContext());
//        layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        newAddButton.setImageResource(R.drawable.add_button);
//        newAddButton.setId(View.generateViewId());
//        newAddButton.setBackgroundResource(R.color.addColor);
//        layoutParams.addRule(RelativeLayout.BELOW, addButtonStack.peek().getId());
//        layoutParams.addRule(RelativeLayout.ALIGN_RIGHT, addButtonStack.peek().getId());
//        layoutParams.addRule(RelativeLayout.ALIGN_LEFT, addButtonStack.peek().getId());
//        layoutParams.addRule(RelativeLayout.ALIGN_TOP, measurementButtonStack.peek().getId());
//        layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM,measurementButtonStack.peek().getId());
////        newAddButton.setRotation(90);
//        newAddButton.setLayoutParams(layoutParams);
////        We disable the old add button and push the new Add button over it in our Stack.
//        addButtonStack.peek().setEnabled(false);
//        addButtonStack.push(newAddButton);
//        mLayout.addView(addButtonStack.peek());
//
//
//
//
//
//
////                Adds the new SUBTRACT BUTTON
//        ImageButton newSubButton = new ImageButton(subButtonStack.peek().getContext());
//        layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        newSubButton.setImageResource(R.drawable.min_button);
//        newSubButton.setId(View.generateViewId());
//        newSubButton.setBackgroundResource(R.color.subColor);
//        layoutParams.addRule(RelativeLayout.BELOW, subButtonStack.peek().getId());
//        layoutParams.addRule(RelativeLayout.ALIGN_LEFT, subButtonStack.peek().getId());
//        layoutParams.addRule(RelativeLayout.ALIGN_RIGHT, subButtonStack.peek().getId());
//        layoutParams.addRule(RelativeLayout.ALIGN_TOP, addButtonStack.peek().getId());
//        layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, addButtonStack.peek().getId());
//        newSubButton.setLayoutParams(layoutParams);
//        subButton = subButtonStack.peek();
//        subButton.setEnabled(true);
//        newSubButton.setEnabled(false);
//        subButtonStack.push(newSubButton);
//        mLayout.addView(subButtonStack.peek());
//
//
//
//
//
//
////keep listening if the addButton was clicked
//        addButtonStack.peek().setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                addClicked();
//            }
//        });
//
////Keeps listening if the subtract button was clicked
//        if(subButton!=null) {
//            subButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    subClicked();
//
//                }
//            });
//        }
//
////        Keeps listening if the last measurement button was clicked
//        measurementButtonStack.peek().setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                measurementClicked();
//            }
//        });
//
//
//
//
//
//    }
//
//
//    public void subClicked(){
//        //Deletes the bottom 3 buttons and takes them out of the view bar
//        mLayout.removeView(measurementButtonStack.pop());
//        mLayout.removeView(addButtonStack.pop());
//        mLayout.removeView(subButtonStack.pop());
//        measurementButtonCounter--;
//
//        measurementButtonStack.peek().setEnabled(true);
//        addButtonStack.peek().setEnabled(true);
//        subButtonStack.peek().setEnabled(false);
//
//        ImageButton tempSubButton = subButtonStack.pop();
//        if(!subButtonStack.empty()){
//            subButton= subButtonStack.peek();
////            subButton.setEnabled(true);
//
//        }
//        else{
//            subButton = null;
//        }
//        subButtonStack.push(tempSubButton);
//
//        if(subButton != null){
//
//            subButton.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v){
//                    subClicked();
//                }
//            });
//
//        }
//
//
//    }

    public void experiment1Clicked(View view){
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);//It lets us choose more than 1 video choosing one video will give an error
//        ALL THE DATA IS BEING SENT HERE
        intent.putExtra("JobName", myData[0].getJobName());
        intent.putExtra("PowerData1", myData[0].getPowerData());
        intent.putExtra("FreqData1", myData[0].getFreqData());
        intent.putExtra("TempData1", myData[0].getTempData());
        intent.putExtra("VideoUri1", myData[0].getVideoUri());
        intent.putExtra("PowerData2", myData[1].getPowerData());
        intent.putExtra("FreqData2", myData[1].getFreqData());
        intent.putExtra("TempData2", myData[1].getTempData());
        intent.putExtra("VideoUri2", myData[1].getVideoUri());
        intent.putExtra("PowerData3", myData[2].getPowerData());
        intent.putExtra("FreqData3", myData[2].getFreqData());
        intent.putExtra("TempData3", myData[2].getTempData());
        intent.putExtra("VideoUri3", myData[2].getVideoUri());
        startActivityForResult(Intent.createChooser(intent,
                getString(R.string.select_video)), EXPERIMENT1);

    }

    public void experiment2Clicked(View view){
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);//It lets us choose more than 1 video choosing one video will give an error
//        ALL THE DATA IS BEING SENT HERE
        intent.putExtra("JobName", myData[0].getJobName());
        intent.putExtra("PowerData1", myData[0].getPowerData());
        intent.putExtra("FreqData1", myData[0].getFreqData());
        intent.putExtra("TempData1", myData[0].getTempData());
        intent.putExtra("VideoUri1", myData[0].getVideoUri());
        intent.putExtra("PowerData2", myData[1].getPowerData());
        intent.putExtra("FreqData2", myData[1].getFreqData());
        intent.putExtra("TempData2", myData[1].getTempData());
        intent.putExtra("VideoUri2", myData[1].getVideoUri());
        intent.putExtra("PowerData3", myData[2].getPowerData());
        intent.putExtra("FreqData3", myData[2].getFreqData());
        intent.putExtra("TempData3", myData[2].getTempData());
        intent.putExtra("VideoUri3", myData[2].getVideoUri());
        startActivityForResult(Intent.createChooser(intent,
                getString(R.string.select_video)), EXPERIMENT2);

    }
    public void experiment3Clicked(View view){
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);//It lets us choose more than 1 video choosing one video will give an error
//        ALL THE DATA IS BEING SENT HERE
        intent.putExtra("JobName", myData[0].getJobName());
        intent.putExtra("PowerData1", myData[0].getPowerData());
        intent.putExtra("FreqData1", myData[0].getFreqData());
        intent.putExtra("TempData1", myData[0].getTempData());
        intent.putExtra("VideoUri1", myData[0].getVideoUri());
        intent.putExtra("PowerData2", myData[1].getPowerData());
        intent.putExtra("FreqData2", myData[1].getFreqData());
        intent.putExtra("TempData2", myData[1].getTempData());
        intent.putExtra("VideoUri2", myData[1].getVideoUri());
        intent.putExtra("PowerData3", myData[2].getPowerData());
        intent.putExtra("FreqData3", myData[2].getFreqData());
        intent.putExtra("TempData3", myData[2].getTempData());
        intent.putExtra("VideoUri3", myData[2].getVideoUri());
        startActivityForResult(Intent.createChooser(intent,
                getString(R.string.select_video)), EXPERIMENT3);

    }


    public void edit1Clicked(View view){

        Intent intent = new Intent(Measurements.this, Data.class);
        intent.putExtra("Key", EXPERIMENT1);//Every experiment trial has its own key
        intent.putExtra("JobName", myData[0].getJobName());//jobName will always be the same for every experiment
        intent.putExtra("PowerData1", myData[0].getPowerData());
        intent.putExtra("FreqData1", myData[0].getFreqData());
        intent.putExtra("TempData1", myData[0].getTempData());
        intent.putExtra("VideoUri1", myData[0].getVideoUri());
        intent.putExtra("PowerData2", myData[1].getPowerData());
        intent.putExtra("FreqData2", myData[1].getFreqData());
        intent.putExtra("TempData2", myData[1].getTempData());
        intent.putExtra("VideoUri2", myData[1].getVideoUri());
        intent.putExtra("PowerData3", myData[2].getPowerData());
        intent.putExtra("FreqData3", myData[2].getFreqData());
        intent.putExtra("TempData3", myData[2].getTempData());
        intent.putExtra("VideoUri3", myData[2].getVideoUri());
        startActivity(intent);



    }

    public void edit2Clicked(View view){

        Intent intent = new Intent(Measurements.this, Data.class);
        intent.putExtra("Key", EXPERIMENT2);//Every experiment trial has its own key
        intent.putExtra("JobName", myData[0].getJobName());//jobName will always be the same for every experiment
        intent.putExtra("PowerData1", myData[0].getPowerData());
        intent.putExtra("FreqData1", myData[0].getFreqData());
        intent.putExtra("TempData1", myData[0].getTempData());
        intent.putExtra("VideoUri1", myData[0].getVideoUri());
        intent.putExtra("PowerData2", myData[1].getPowerData());
        intent.putExtra("FreqData2", myData[1].getFreqData());
        intent.putExtra("TempData2", myData[1].getTempData());
        intent.putExtra("VideoUri2", myData[1].getVideoUri());
        intent.putExtra("PowerData3", myData[2].getPowerData());
        intent.putExtra("FreqData3", myData[2].getFreqData());
        intent.putExtra("TempData3", myData[2].getTempData());
        intent.putExtra("VideoUri3", myData[2].getVideoUri());
        startActivity(intent);

    }

//    When the edit button is clicked all our data is transferred to the nextactivity.
    public void edit3Clicked(View view){

        Intent intent = new Intent(Measurements.this, Data.class);
        intent.putExtra("Key", EXPERIMENT3);//Every experiment trial has its own key
        intent.putExtra("JobName", myData[0].getJobName());
        intent.putExtra("PowerData1", myData[0].getPowerData());
        intent.putExtra("FreqData1", myData[0].getFreqData());
        intent.putExtra("TempData1", myData[0].getTempData());
        intent.putExtra("VideoUri1", myData[0].getVideoUri());
        intent.putExtra("PowerData2", myData[1].getPowerData());
        intent.putExtra("FreqData2", myData[1].getFreqData());
        intent.putExtra("TempData2", myData[1].getTempData());
        intent.putExtra("VideoUri2", myData[1].getVideoUri());
        intent.putExtra("PowerData3", myData[2].getPowerData());
        intent.putExtra("FreqData3", myData[2].getFreqData());
        intent.putExtra("TempData3", myData[2].getTempData());
        intent.putExtra("VideoUri3", myData[2].getVideoUri());
        startActivity(intent);


    }



//This mthod chooses different experiment buttons and for each button it selects the video from the camera roll
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
            if(requestCode== EXPERIMENT1) {

                if (intent != null) {
                    ClipData clipData = intent.getClipData();
                    String[] path = new String[clipData.getItemCount()];

                    if (clipData != null) {
                        for (int i = 0; i < clipData.getItemCount(); i++) {
                            ClipData.Item item = clipData.getItemAt(i);
                            Uri uri = item.getUri();

                            //In case you need image's absolute path
                            path[i] = uri.toString();

                        }

                    }
                    myData[0].setVideoUri(path);
                }
            }

            if(requestCode == EXPERIMENT2) {
                if (intent != null) {
                    ClipData clipData = intent.getClipData();
                    String[] path = new String[clipData.getItemCount()];

                    if (clipData != null) {
                        for (int i = 0; i < clipData.getItemCount(); i++) {
                            ClipData.Item item = clipData.getItemAt(i);
                            Uri uri = item.getUri();

                            //In case you need image's absolute path
                            path[i] = uri.toString();

                        }

                    }
                    myData[1].setVideoUri(path);
                }



            }

            if(requestCode == EXPERIMENT3) {
                if (intent != null) {
                    ClipData clipData = intent.getClipData();
                    String[] path = new String[clipData.getItemCount()];

                    if (clipData != null) {
                        for (int i = 0; i < clipData.getItemCount(); i++) {
                            ClipData.Item item = clipData.getItemAt(i);
                            Uri uri = item.getUri();

                            //In case you need image's absolute path
                            path[i] = uri.toString();

                        }

                    }
                    myData[2].setVideoUri(path);
                }



            }


    }










    public void processVideos(View view){
        String m1_Power = "";
        String m1_Freq = "";
        String m1_Temp = "";
        String m1_videoName = "";
        String m2_Power = "";
        String m2_Freq = "";
        String m2_Temp = "";
        String m2_videoName = "";
        String m3_Power = "";
        String m3_Freq = "";
        String m3_Temp = "";
        String m3_videoName = "";
        try {

//----------------------------------------------------- Data from Experiment 1----------------------------------------------------------

            if (myData[0].getPowerData() != null) {
                for (int i = 0; i < 10; i++) {
                    m1_Power += URLEncoder.encode(Float.toString(myData[0].getPowerData()[i]), "UTF-8");
                    if (i != 9) {
                        m1_Power += ",";
                    }
                }
            }


            if (myData[0].getFreqData() != null) {
                for (int i = 0; i < 10; i++) {
                    m1_Freq += URLEncoder.encode(Float.toString(myData[0].getFreqData()[i]), "UTF-8");
                    if (i != 9) {
                        m1_Freq += ",";
                    }
                }
            }


            if (myData[0].getTempData() != null) {
                for (int i = 0; i < 10; i++) {
                    m1_Temp += URLEncoder.encode(Float.toString(myData[0].getTempData()[i]), "UTF-8");
                    if (i != 9) {
                        m1_Temp += ",";
                    }
                }
            }


                for (int i = 0; i < 10; i++) {
                    m2_videoName += URLEncoder.encode((myData[0].getJobName() + " Experiment 1 " + i), "UTF-8");
                    if (i != 9) {
                        m2_videoName += ",";
                    }
                }

//----------------------------------------- Data from Experiment 2----------------------------------------------------------
            if (myData[1].getPowerData() != null) {
                for (int i = 0; i < 10; i++) {
                    m2_Power += URLEncoder.encode(Float.toString(myData[1].getPowerData()[i]), "UTF-8");
                    if (i != 9) {
                        m2_Power += ",";
                    }
                }
            }


            if (myData[1].getFreqData() != null) {
                for (int i = 0; i < 10; i++) {
                    m2_Freq += URLEncoder.encode(Float.toString(myData[1].getFreqData()[i]), "UTF-8");
                    if (i != 9) {
                        m2_Freq += ",";
                    }
                }
            }


            if (myData[1].getTempData() != null) {
                for (int i = 0; i < 10; i++) {
                    m2_Temp += URLEncoder.encode(Float.toString(myData[1].getTempData()[i]), "UTF-8");
                    if (i != 9) {
                        m2_Temp += ",";
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                m3_videoName += URLEncoder.encode((myData[0].getJobName() + " Experiment 2 " + i), "UTF-8");
                if (i != 9) {
                    m3_videoName += ",";
                }
            }
//------------------------------------------------- Data from Experiment 3----------------------------------------------------------
            if (myData[2].getPowerData() != null) {
                for (int i = 0; i < 10; i++) {
                    m3_Power += URLEncoder.encode(Float.toString(myData[2].getPowerData()[i]), "UTF-8");
                    if (i != 9) {
                        m3_Power += ",";
                    }
                }
            }


            if (myData[2].getFreqData() != null) {
                for (int i = 0; i < 10; i++) {
                    m3_Freq += URLEncoder.encode(Float.toString(myData[2].getFreqData()[i]), "UTF-8");
                    if (i != 9) {
                        m3_Freq += ",";
                    }
                }
            }


            if (myData[2].getTempData() != null) {
                for (int i = 0; i < 10; i++) {
                    m3_Temp += URLEncoder.encode(Float.toString(myData[2].getTempData()[i]), "UTF-8");
                    if (i != 9) {
                        m3_Temp += ",";
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                m1_videoName += URLEncoder.encode((myData[0].getJobName() + " Experiment 3 " + i), "UTF-8");
                if (i != 9) {
                    m1_videoName += ",";
                }
            }

//  ALL THE DATA IS NOW IN THE STRING WHICH WILL BE SENT TO THE SERVER





        }catch(UnsupportedEncodingException e){
            m1_Freq =null;
            m1_Power=null;
            m1_Temp = null;
        }
//IF m1_Freq, m1_Power, or m1_Temp is null than that means we encountered an issue and the program will stop.
        if(m1_Freq!=null || m1_Power!=null || m1_Temp!=null){
//            this is where all the data from the text is sent!
            ConnectionTask onLineData = new ConnectionTask(m1_Freq, m1_Power, m1_Temp,m1_videoName, m2_Freq, m2_Power, m2_Temp,m2_videoName, m3_Freq, m3_Power, m3_Temp, m3_videoName );
            onLineData.execute("http://tcmaucla.ee.ucla.edu:8072/process_sample");
        }
        else{
            update.setText("Error while entering data!");
        }





    }







    private class ConnectionTask extends AsyncTask<String, Void, String> {
       String aString=new String();

        String freq1 = "";//Has the data for frequencey from exp1
        String power1= ""; //Has the data for power from exp1
        String temp1= "";//Has the data for temperature from exp1
        String freq2 = "";//Has the data for frequencey from exp2
        String power2= "";//Has the data for power from exp2
        String temp2= "";//Has the data for temperature from exp2
        String freq3 = "";//Has the data for frequencey from exp3
        String power3= "";//Has the data for power from exp3
        String temp3= "";//Has the data for temperature from exp3
        String videoName1= "";
        String videoName2= "";
        String videoName3= "";
        URL aURL;
        HttpURLConnection aHttpURLConnection;
        BufferedReader reader;


        public ConnectionTask(String freq1, String power1, String temp1, String videoName1, String freq2, String power2, String temp2,String videoName2, String freq3, String power3, String temp3, String videoName3){
            this.freq1 = freq1;
            this.power1= power1;
            this.temp1= temp1;
            this.videoName1 = videoName1;
            this.freq2 = freq2;
            this.power2= power2;
            this.temp2= temp2;
            this.videoName2 = videoName2;
            this.freq3 = freq3;
            this.power3= power3;
            this.temp3= temp3;
            this.videoName3 = videoName3;
        }

        @Override
        protected String doInBackground(String... urls) {
            try {
                aURL = new URL("http://tcmaucla.ee.ucla.edu:8072/process_sample");


    /* Open a connection to that URL. */
                aHttpURLConnection = (HttpURLConnection) aURL.openConnection();
                aHttpURLConnection.setRequestMethod("POST");
                aHttpURLConnection.setUseCaches(false);
                aHttpURLConnection.setDoOutput(true);//enable to write data to output stream
                aHttpURLConnection.setDoInput(true);


                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("deviceId", "1")
                        .appendQueryParameter("jobName",myData[0].getJobName())
                        .appendQueryParameter("dateTime", mDate)
                        .appendQueryParameter("M1_power", power1)
                        .appendQueryParameter("M1_freq",freq1)
                        .appendQueryParameter("M1_temp", temp1)
                        .appendQueryParameter("M1_videoNames", videoName1)
                        .appendQueryParameter("M2_power", power2)
                        .appendQueryParameter("M2_freq",freq2)
                        .appendQueryParameter("M2_temp", temp2)
                        .appendQueryParameter("M2_videoNames", videoName2)
                        .appendQueryParameter("M3_power", power3)
                        .appendQueryParameter("M3_freq",freq3)
                        .appendQueryParameter("M3_temp", temp3)
                        .appendQueryParameter("M3_videoNames", videoName3);


                String query = builder.build().getEncodedQuery();


    /*Define OutputStream to read from the URLConnection*/
                OutputStream os = aHttpURLConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(os,"UTF-8"));

                writer.write(query);
                writer.flush();
                writer.close();
                os.close();


    /* Define InputStreams to read from the URLConnection. */
                reader = new BufferedReader(new InputStreamReader(aHttpURLConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                aString=sb.toString().trim();
                reader.close();


            }catch (Exception e) {
               aString="Error!";
            }
                return aString;
        }

        @Override
        protected void onPostExecute(String result) {
            // result is what you got from your connection
            update.setText(aString.toString());
            update.setMovementMethod(new ScrollingMovementMethod());

        }

    }








}
