//package com.hfad.viscosity;
//
//import android.os.AsyncTask;
//
//import java.io.BufferedReader;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.HashMap;
//import java.util.Iterator;
//
//public class AsyncHttpPost extends AsyncTask<String, String, String> {
//    interface Listener {
//        void onResult(String result);
//    }
//    private Listener mListener;
//    private float[] mData = null;// post data
//
//    /**
//     * constructor
//     */
//    public AsyncHttpPost( float[] data) {
//        mData = data;
//    }
//    public void setListener(Listener listener) {
//        mListener = listener;
//    }
//
//    /**
//     * background
//     */
//    @Override
//    protected String doInBackground(String... params) {
//        String str = "";
//        URL url;
//        URLConnection client = null;
//        BufferedReader reader;
//        try {
//            // set up post data
//            url = new URL("http://tcmaucla.ee.ucla.edu:8072/process_sample");
//            client =  url.openConnection();
//            Iterator<String> it = mData.keySet().iterator();
//            while (it.hasNext()) {
//                String key = it.next();
//                nameValuePair.add(new BasicNameValuePair(key, mData.get(key)));
//            }
//
//            post.setEntity(new UrlEncodedFormEntity(nameValuePair, "UTF-8"));
//            HttpResponse response = client.execute(post);
//            StatusLine statusLine = response.getStatusLine();
//            if(statusLine.getStatusCode() == HttpURLConnection.HTTP_OK){
//                result = EntityUtils.toByteArray(response.getEntity());
//                str = new String(result, "UTF-8");
//            }
//        }
//        catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        catch (Exception e) {
//        }
//        return str;
//    }
//
//    /**
//     * on getting result
//     */
//    @Override
//    protected void onPostExecute(String result) {
//        // something...
//        if (mListener != null) {
//            mListener.onResult(result)
//        }
//    }
//}
