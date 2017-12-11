package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.Command;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class UtilService {

    private static String authKey = "AAAAKpzergM:APA91bHSCZbfp7LyScDPl25l49f8WoV_O6FFWwLMn-W0sAtk4R7ksVBH4wk26UjMCujZKJUyNRiiHzsIl7jTY7lkIaLajH2XuALKoKIYXCc19ToaM6D0mtV-R72Px2vCMqqT3MMgfgZJ";
    private static String FMCurl = "http://fcm.googleapis.com/fcm/send";

    public static String sendGenericNotification(String u, String message, String title)
            throws IOException {
        String real_email = u.replaceAll("\\.","dot").replaceAll("@","at");
        String result = "";
        URL url = new URL(FMCurl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + authKey);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject json = new JSONObject();

        json.put("to","/topics/user~"+real_email );

        JSONObject info = new JSONObject();
        info.put("title", title); // Notification title
        info.put("body", message); // Notification
        // body
        json.put("notification", info);
        try {
            OutputStreamWriter wr = new OutputStreamWriter(
                    conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            result = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            result = "BAD";
        }
        System.out.println("GCM Notification is sent successfully");

        return result;

    }

    public static String sendCommandReadyNotification(String u, String message, String title, Command command)
            throws IOException {
        String real_email = u.replaceAll("\\.","dot").replaceAll("@","at");
        String result = "";
        URL url = new URL(FMCurl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + authKey);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject json = new JSONObject();

        json.put("to","/topics/user~"+real_email );

        JSONObject data = new JSONObject();

        data.put("command_id", command.getId_command());

        JSONObject info = new JSONObject();
        info.put("title", title); // Notification title
        info.put("body", message); // Notification
        // body
        json.put("notification", info);
        json.put("data", data);
        try {
            OutputStreamWriter wr = new OutputStreamWriter(
                    conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            result = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            result = "BAD";
        }
        System.out.println("GCM Notification is sent successfully");

        return result;
    }
}
