package edu.eci.cosw.pancomido.service;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class UtilService {

    private static String authKey = "AAAAKpzergM:APA91bHSCZbfp7LyScDPl25l49f8WoV_O6FFWwLMn-W0sAtk4R7ksVBH4wk26UjMCujZKJUyNRiiHzsIl7jTY7lkIaLajH2XuALKoKIYXCc19ToaM6D0mtV-R72Px2vCMqqT3MMgfgZJ";
    private static String FMCurl = "http://fcm.googleapis.com/fcm/send";

    public static void sendNotifications(String u, String message, String title){
        String real_email = u.replaceAll("\\.","dot").replaceAll("@","at");
        URL url = null;
        try {
            url = new URL(FMCurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization","key="+authKey);
            conn.setRequestProperty("Content-Type","application/json");

            JSONObject generalRequest = new JSONObject();

            JSONObject data = new JSONObject();

            JSONObject notification = new JSONObject();
            notification.put("body",message);
            notification.put("message",title);

            data.put("notification",notification);
            data.put("topic","user~"+real_email);

            generalRequest.put("message", data);

            System.out.println(generalRequest.toString());

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(generalRequest.toString());
            wr.flush();
            conn.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
