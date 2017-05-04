package com.hfad.viscosity;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends AppCompatActivity {
    private EditText[] Temp= new EditText[10];
    private ViscosityData[] myData = new ViscosityData[3];
    final ViscosityData temporary = new ViscosityData();
    private ViscosityData temporary2 = new ViscosityData();
    private int key=10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        final EditText initialPower=(EditText) findViewById(R.id.Power1);
        final EditText initialFreq= (EditText) findViewById(R.id.Freq1);
        final EditText[] Temp= new EditText[10]; //temporary will be used later to put in the ViscosityData that is associated with the key
        myData[0]= new ViscosityData();
        myData[1]= new ViscosityData();
        myData[2]= new ViscosityData();
        Temp[0]= (EditText) findViewById(R.id.Temp1);
        Temp[1]= (EditText) findViewById(R.id.Temp2);
        Temp[2]= (EditText) findViewById(R.id.Temp3);
        Temp[3]= (EditText) findViewById(R.id.Temp4);
        Temp[4]= (EditText) findViewById(R.id.Temp5);
        Temp[5]= (EditText) findViewById(R.id.Temp6);
        Temp[6]= (EditText) findViewById(R.id.Temp7);
        Temp[7]= (EditText) findViewById(R.id.Temp8);
        Temp[8]= (EditText) findViewById(R.id.Temp9);
        Temp[9]= (EditText) findViewById(R.id.Temp10);


//---------------------------------------BEGINNING OF CODE TO USERS ENTERED DATA--------------------------------------------------
        initialPower.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    float[] powerDataList = new float[10];
                float powerData = Float.valueOf( initialPower.getText().toString().trim() );
                    powerDataList[0]= powerData;
                ((EditText) findViewById(R.id.Power2)).setText(Float.toString(powerData-=1));
                    powerDataList[1]= powerData;
                ((EditText) findViewById(R.id.Power3)).setText(Float.toString(powerData-=1));
                    powerDataList[2]= powerData;
                ((EditText) findViewById(R.id.Power4)).setText(Float.toString(powerData-=1));
                    powerDataList[3]= powerData;
                ((EditText) findViewById(R.id.Power5)).setText(Float.toString(powerData-=1));
                    powerDataList[4]= powerData;
                ((EditText) findViewById(R.id.Power6)).setText(Float.toString(powerData-=1));
                    powerDataList[5]= powerData;
                ((EditText) findViewById(R.id.Power7)).setText(Float.toString(powerData-=1));
                    powerDataList[6]= powerData;
                ((EditText) findViewById(R.id.Power8)).setText(Float.toString(powerData-=1));
                    powerDataList[7]= powerData;
                ((EditText) findViewById(R.id.Power9)).setText(Float.toString(powerData-=1));
                    powerDataList[8]= powerData;
                ((EditText) findViewById(R.id.Power10)).setText(Float.toString(powerData-=1));
                    powerDataList[9]= powerData;
                    temporary.setPowerData(powerDataList);
                    return true;
                }
                return false;
            }
        });


        initialFreq.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    float[] freqDataList = new float[10];
                    float freqData = Float.valueOf(initialFreq.getText().toString().trim());
                    freqDataList[0]=freqData;
                    ((EditText) findViewById(R.id.Freq2)).setText(Float.toString(freqData));
                    freqDataList[1]=freqData;
                     ((EditText) findViewById(R.id.Freq3)).setText(Float.toString(freqData));
                    freqDataList[2]=freqData;
                    ((EditText) findViewById(R.id.Freq4)).setText(Float.toString(freqData));
                    freqDataList[3]=freqData;
                    ((EditText) findViewById(R.id.Freq5)).setText(Float.toString(freqData));
                    freqDataList[4]=freqData;
                    ((EditText) findViewById(R.id.Freq6)).setText(Float.toString(freqData));
                    freqDataList[5]=freqData;
                    ((EditText) findViewById(R.id.Freq7)).setText(Float.toString(freqData));
                    freqDataList[6]=freqData;
                    ((EditText) findViewById(R.id.Freq8)).setText(Float.toString(freqData));
                    freqDataList[7]=freqData;
                    ((EditText) findViewById(R.id.Freq9)).setText(Float.toString(freqData));
                    freqDataList[8]=freqData;
                    ((EditText) findViewById(R.id.Freq10)).setText(Float.toString(freqData));
                    freqDataList[9]=freqData;
                    temporary.setFreqData(freqDataList);

                    return true;
                }
                return false;
            }
        });

        final float[] dataList = new float[10];
            Temp[0].setOnEditorActionListener(new TextView.OnEditorActionListener(){
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if(actionId== EditorInfo.IME_ACTION_NEXT){

                        dataList[0]=Float.valueOf( Temp[0].getText().toString().trim()  );
                        temporary.setTempData(dataList);

                        return true;
                    }
                    return false;
                }
            });
            Temp[1].setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_NEXT)//NEXT needs to be pressed to save the data
                {

                    dataList[1]=Float.valueOf( Temp[1].getText().toString().trim()  );
                    temporary.setTempData(dataList);

                    return true;
                }
                return false;
            }
        });
            Temp[2].setOnEditorActionListener(new TextView.OnEditorActionListener(){
                @Override
             public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                 if(actionId== EditorInfo.IME_ACTION_NEXT)//NEXT needs to be pressed to save the data
                 {

                      dataList[2]=Float.valueOf( Temp[2].getText().toString().trim()  );
                        temporary.setTempData(dataList);

                        return true;
                    }
                    return false;
                }
            });
            Temp[3].setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if(actionId== EditorInfo.IME_ACTION_NEXT)//NEXT needs to be pressed to save the data
                    {

                        dataList[3]=Float.valueOf( Temp[3].getText().toString().trim()  );
                        temporary.setTempData(dataList);

                        return true;
                    }
                    return false;
             }
        });
            Temp[4].setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_NEXT)//NEXT needs to be pressed to save the data
                {

                    dataList[4]=Float.valueOf( Temp[4].getText().toString().trim()  );
                    temporary.setTempData(dataList);

                    return true;
                }
                return false;
            }
        });
            Temp[5].setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_NEXT)//NEXT needs to be pressed to save the data
                {

                    dataList[5]=Float.valueOf( Temp[5].getText().toString().trim()  );
                    temporary.setTempData(dataList);

                    return true;
                }
                return false;
            }
        });
            Temp[6].setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_NEXT)//NEXT needs to be pressed to save the data
                {

                    dataList[6]=Float.valueOf( Temp[6].getText().toString().trim()  );
                    temporary.setTempData(dataList);

                    return true;
                }
                return false;
            }
        });
            Temp[7].setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_NEXT)//NEXT needs to be pressed to save the data
                {

                    dataList[7]=Float.valueOf( Temp[7].getText().toString().trim()  );
                    temporary.setTempData(dataList);

                    return true;
                }
                return false;
            }
        });
        Temp[8].setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_NEXT)//NEXT needs to be pressed to save the data
                {

                    dataList[8]=Float.valueOf( Temp[8].getText().toString().trim()  );
                    temporary.setTempData(dataList);

                    return true;
                }
                return false;
            }
        });

        Temp[9].setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE)//DONE needs to be pressed to save the data
                {

                    dataList[9]=Float.valueOf( Temp[9].getText().toString().trim()  );
                    temporary.setTempData(dataList);

                    return true;
                }
                return false;
            }
        });
//----------------------------------------end of code for DATA THAT GETS UPDATED WHEN THE USER EDITS TABLES-----------------------



//------------------------------------THIS IS THE DATA THAT WE RECIEVE WHEN WE SWITCH ACTIVITIES---------------------------------
        Bundle extras = getIntent().getExtras();
        key = (int) extras.get("Key");
        if(extras!= null){
                myData[0].setJobName(extras.getString("JobName"));
                myData[0].setPowerData(extras.getFloatArray("PowerData1"));
                myData[0].setFreqData(extras.getFloatArray("FreqData1"));
                myData[0].setTempData(extras.getFloatArray("TempData1"));
                myData[0].setVideoUri(extras.getStringArray("VideoUri1"));

                myData[1].setJobName(extras.getString("JobName"));
                myData[1].setPowerData(extras.getFloatArray("PowerData2"));
                myData[1].setFreqData(extras.getFloatArray("FreqData2") );
                myData[1].setTempData(extras.getFloatArray("TempData2") );
                myData[1].setVideoUri(extras.getStringArray("VideoUri2"));

                myData[2].setJobName(extras.getString("JobName"));
                myData[2].setPowerData( extras.getFloatArray("PowerData3") );
                myData[2].setFreqData( extras.getFloatArray("FreqData3") );
                myData[2].setTempData( extras.getFloatArray("TempData3") );
                myData[2].setVideoUri( extras.getStringArray("VideoUri3") );

            temporary2 = myData[key-1];

            if(temporary2.getPowerData() !=null){
                ((EditText) findViewById(R.id.Power1)).setText(Float.toString(myData[key-1].getPowerData()[0]));
                ((TextView) findViewById(R.id.Power2)).setText(Float.toString(myData[key-1].getPowerData()[1]));
                ((TextView) findViewById(R.id.Power3)).setText(Float.toString(myData[key-1].getPowerData()[2]));
                ((TextView) findViewById(R.id.Power4)).setText(Float.toString(myData[key-1].getPowerData()[3]));
                ((TextView) findViewById(R.id.Power5)).setText(Float.toString(myData[key-1].getPowerData()[4]));
                ((TextView) findViewById(R.id.Power6)).setText(Float.toString(myData[key-1].getPowerData()[5]));
                ((TextView) findViewById(R.id.Power7)).setText(Float.toString(myData[key-1].getPowerData()[6]));
                ((TextView) findViewById(R.id.Power8)).setText(Float.toString(myData[key-1].getPowerData()[7]));
                ((TextView) findViewById(R.id.Power9)).setText(Float.toString(myData[key-1].getPowerData()[8]));
                ((TextView) findViewById(R.id.Power10)).setText(Float.toString(myData[key-1].getPowerData()[9]));
            }
            else{
                myData[key-1].setPowerData(null);
            }

            if(temporary2.getFreqData() !=null){
                ((EditText) findViewById(R.id.Freq1)).setText(Float.toString(myData[key-1].getFreqData()[0]));
                ((TextView) findViewById(R.id.Freq2)).setText(Float.toString(myData[key-1].getFreqData()[1]));
                ((TextView) findViewById(R.id.Freq3)).setText(Float.toString(myData[key-1].getFreqData()[2]));
                ((TextView) findViewById(R.id.Freq4)).setText(Float.toString(myData[key-1].getFreqData()[3]));
                ((TextView) findViewById(R.id.Freq5)).setText(Float.toString(myData[key-1].getFreqData()[4]));
                ((TextView) findViewById(R.id.Freq6)).setText(Float.toString(myData[key-1].getFreqData()[5]));
                ((TextView) findViewById(R.id.Freq7)).setText(Float.toString(myData[key-1].getFreqData()[6]));
                ((TextView) findViewById(R.id.Freq8)).setText(Float.toString(myData[key-1].getFreqData()[7]));
                ((TextView) findViewById(R.id.Freq9)).setText(Float.toString(myData[key-1].getFreqData()[8]));
                ((TextView) findViewById(R.id.Freq10)).setText(Float.toString(myData[key-1].getFreqData()[9]));

            }
            else{
                myData[key-1].setFreqData(null);
            }

            if(temporary2.getTempData() !=null){
                ((EditText) findViewById(R.id.Temp1)).setText(Float.toString( myData[key-1].getTempData()[0] ));
                ((EditText) findViewById(R.id.Temp2)).setText(Float.toString(myData[key-1].getTempData()[1]));
                ((EditText) findViewById(R.id.Temp3)).setText(Float.toString(myData[key-1].getTempData()[2]));
                ((EditText) findViewById(R.id.Temp4)).setText(Float.toString(myData[key-1].getTempData()[3]));
                ((EditText) findViewById(R.id.Temp5)).setText(Float.toString(myData[key-1].getTempData()[4]));
                ((EditText) findViewById(R.id.Temp6)).setText(Float.toString(myData[key-1].getTempData()[5]));
                ((EditText) findViewById(R.id.Temp7)).setText(Float.toString(myData[key-1].getTempData()[6]));
                ((EditText) findViewById(R.id.Temp8)).setText(Float.toString(myData[key-1].getTempData()[7]));
                ((EditText) findViewById(R.id.Temp9)).setText(Float.toString(myData[key-1].getTempData()[8]));
                ((EditText) findViewById(R.id.Temp10)).setText(Float.toString(myData[key-1].getTempData()[9]));
            }
            else{
                myData[key-1].setTempData(null);
            }

        }
//-------------------------------------------------------end of code for THE DATA SEND BETWEEN ACTIVITIES ----------------------------------






//-----------------------THIS IS IF THE USER FLIPS THE SCREEN THE DATA WONT BE LOST --------------------------------------------

        if(savedInstanceState!= null){

            float[] Arr= new float[10];



            if(savedInstanceState.getFloatArray("PowerData") != null){
                ((EditText) findViewById(R.id.Power1)).setText(Float.toString(savedInstanceState.getFloatArray("PowerData")[0]));
                ((TextView) findViewById(R.id.Power2)).setText(Float.toString(savedInstanceState.getFloatArray("PowerData")[1]));
                ((TextView) findViewById(R.id.Power3)).setText(Float.toString(savedInstanceState.getFloatArray("PowerData")[2]));
                ((TextView) findViewById(R.id.Power4)).setText(Float.toString(savedInstanceState.getFloatArray("PowerData")[3]));
                ((TextView) findViewById(R.id.Power5)).setText(Float.toString(savedInstanceState.getFloatArray("PowerData")[4]));
                ((TextView) findViewById(R.id.Power6)).setText(Float.toString(savedInstanceState.getFloatArray("PowerData")[5]));
                ((TextView) findViewById(R.id.Power7)).setText(Float.toString(savedInstanceState.getFloatArray("PowerData")[6]));
                ((TextView) findViewById(R.id.Power8)).setText(Float.toString(savedInstanceState.getFloatArray("PowerData")[7]));
                ((TextView) findViewById(R.id.Power9)).setText(Float.toString(savedInstanceState.getFloatArray("PowerData")[8]));
                ((TextView) findViewById(R.id.Power10)).setText(Float.toString(savedInstanceState.getFloatArray("PowerData")[9]));

                for(int i =0; i<10; i++){
                    Arr[i]=savedInstanceState.getFloatArray("PowerData")[i];
                }
                temporary.setPowerData(Arr);

            }

            if(savedInstanceState.getFloatArray("FreqData") != null){
                ((EditText) findViewById(R.id.Freq1)).setText(Float.toString(savedInstanceState.getFloatArray("FreqData")[0]));
                ((TextView) findViewById(R.id.Freq2)).setText(Float.toString(savedInstanceState.getFloatArray("FreqData")[1]));
                ((TextView) findViewById(R.id.Freq3)).setText(Float.toString(savedInstanceState.getFloatArray("FreqData")[2]));
                ((TextView) findViewById(R.id.Freq4)).setText(Float.toString(savedInstanceState.getFloatArray("FreqData")[3]));
                ((TextView) findViewById(R.id.Freq5)).setText(Float.toString(savedInstanceState.getFloatArray("FreqData")[4]));
                ((TextView) findViewById(R.id.Freq6)).setText(Float.toString(savedInstanceState.getFloatArray("FreqData")[5]));
                ((TextView) findViewById(R.id.Freq7)).setText(Float.toString(savedInstanceState.getFloatArray("FreqData")[6]));
                ((TextView) findViewById(R.id.Freq8)).setText(Float.toString(savedInstanceState.getFloatArray("FreqData")[7]));
                ((TextView) findViewById(R.id.Freq9)).setText(Float.toString(savedInstanceState.getFloatArray("FreqData")[8]));
                ((TextView) findViewById(R.id.Freq10)).setText(Float.toString(savedInstanceState.getFloatArray("FreqData")[9]));

                for(int i =0; i<10; i++){
                    Arr[i]=savedInstanceState.getFloatArray("FreqData")[i];
                }
                temporary.setFreqData(Arr);

            }

            if(savedInstanceState.getFloatArray("TempData")!= null){

                ((EditText) findViewById(R.id.Temp1)).setText(Float.toString(savedInstanceState.getFloatArray("TempData")[0]));
                ((EditText) findViewById(R.id.Temp2)).setText(Float.toString(savedInstanceState.getFloatArray("TempData")[1]));
                ((EditText) findViewById(R.id.Temp3)).setText(Float.toString(savedInstanceState.getFloatArray("TempData")[2]));
                ((EditText) findViewById(R.id.Temp4)).setText(Float.toString(savedInstanceState.getFloatArray("TempData")[3]));
                ((EditText) findViewById(R.id.Temp5)).setText(Float.toString(savedInstanceState.getFloatArray("TempData")[4]));
                ((EditText) findViewById(R.id.Temp6)).setText(Float.toString(savedInstanceState.getFloatArray("TempData")[5]));
                ((EditText) findViewById(R.id.Temp7)).setText(Float.toString(savedInstanceState.getFloatArray("TempData")[6]));
                ((EditText) findViewById(R.id.Temp8)).setText(Float.toString(savedInstanceState.getFloatArray("TempData")[7]));
                ((EditText) findViewById(R.id.Temp8)).setText(Float.toString(savedInstanceState.getFloatArray("TempData")[8]));
                ((EditText) findViewById(R.id.Temp10)).setText(Float.toString(savedInstanceState.getFloatArray("TempData")[9]));

                for(int i =0; i<10; i++){
                    Arr[i]=savedInstanceState.getFloatArray("TempData")[i];
                }
                temporary.setTempData(Arr);

            }



        }



    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("JobName", temporary.getJobName());
        savedInstanceState.putFloatArray("PowerData",temporary.getPowerData());
        savedInstanceState.putFloatArray("FreqData",temporary.getFreqData());
        savedInstanceState.putFloatArray("TempData", temporary.getTempData());
        super.onSaveInstanceState(savedInstanceState);
//        savedInstanceState.putStringArray("VideoUri",myData.getVideoUri());
    }

//------------------ THIS IS WHEN THE USER FLIPS THE SCREEN THE DATA WONT BE LOST---------------------------------------------------






//-----------------------------------------THIS IS WHAT HAPPENS WHEN THE PROCESS BUTTON IS PRESSED------------------------------------
    public void processData(View view){
        if( (key==1 || key==2|| key==3) ) {
            if(temporary.getPowerData() != null ){
                myData[key-1].setPowerData(temporary.getPowerData());
            }
            if(temporary.getFreqData()!=null){
                myData[key-1].setFreqData(temporary.getFreqData());
            }
            if(temporary.getTempData()!=null){
                myData[key-1].setTempData(temporary.getTempData());
            }
        }
        Intent intent = new Intent(Data.this, Measurements.class);
        intent.putExtra("JobName", myData[0].getJobName());
        intent.putExtra("PowerData1", (float[]) myData[0].getPowerData());
        intent.putExtra("FreqData1",(float[])myData[0].getFreqData());
        intent.putExtra("TempData1", (float[]) myData[0].getTempData());
        intent.putExtra("VideoUri1",(String[]) myData[0].getVideoUri());

        intent.putExtra("PowerData2", (float[]) myData[1].getPowerData());
        intent.putExtra("FreqData2",(float[])myData[1].getFreqData());
        intent.putExtra("TempData2", (float[]) myData[1].getTempData());
        intent.putExtra("VideoUri2",(String[]) myData[1].getVideoUri());

        intent.putExtra("PowerData3", (float[]) myData[2].getPowerData());
        intent.putExtra("FreqData3",(float[])myData[2].getFreqData());
        intent.putExtra("TempData3", (float[]) myData[2].getTempData());
        intent.putExtra("VideoUri3",(String[]) myData[2].getVideoUri());
        startActivity(intent);

    }
//-----------------------------------------------------------PROCESS BUTTON IS PRESSED------------------------------------------------




//-----------------------------------------------------------CLEAR BUTTON WAS PRESSED--------------------------------------------------
    public void clearData(View view){
        Intent intent= new Intent(Data.this, Measurements.class);
        startActivity(intent);
    }
//------------------------------------------------------------------------------------------------------------------------------------

}
