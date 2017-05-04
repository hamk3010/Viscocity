package com.hfad.viscosity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hamzakhan on 8/1/16.
 */
public class ViscosityData implements Serializable{
    private String jobName;
    private float[] powerData;
    private float[] freqData;
    private float[] tempData;
    private String[] videoUri;

    public ViscosityData(){
        jobName= "Unknown";
        powerData=null;
        freqData = null;
        tempData=null;
        videoUri= null;
    }

    public void setJobName(String jobName){this.jobName = jobName;}

    public void setFreqData(float[] frequencyList) {
        freqData = frequencyList;
    }

    public void setPowerData(float[] powerList ){
        powerData = powerList;
    }

    public void setTempData(float[] tempData) {
        this.tempData = tempData;
    }

    public void setVideoUri(String[] videoUri) {
        this.videoUri = videoUri;
    }

    public float[] getFreqData() {
        return freqData;
    }

    public String getJobName(){return jobName;}

    public float[] getPowerData() {
        return powerData;
    }

    public float[] getTempData() {
        return tempData;
    }

    public String[] getVideoUri() {
        return videoUri;
    }

}
