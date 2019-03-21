package com.example.fintech.data;

import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MsUrl {

    public void m_getContext_fromWebSite_sendPost(String sUrl, String query, Handler hwnd){ m_getContext_fromWebSite_sendPost(sUrl, "POST", "UTF-8", query, hwnd); }
    public void m_getContext_fromWebSite_sendPost(String sUrl, String connect_Method, String encode_Web, String query, Handler hwnd) {
        class Thread_getContext extends Thread {
            String sUrl;
            String connect_Method;
            String encode_Web;
            String query;
            Handler hwnd;

            public Thread_getContext(String sUrl, String connect_Method, String encode_Web, String query, Handler hwnd) {
                this.sUrl = sUrl;
                this.connect_Method = connect_Method;
                this.encode_Web = encode_Web;
                this.query = query;
                this.hwnd = hwnd;
            }

            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                int status = 0;
                String m_f_s_line = "";
                StringBuilder str_return = new StringBuilder();

                BufferedReader bufferedReader = null;

                try {
                    URL url = new URL(sUrl);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod(connect_Method);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(8000);
                    httpURLConnection.setDoOutput(true);

                    // httpURLConnection.setRequestProperty("Content-Type",
                    // "multipart/form-data;
                    // boundary=---------------------------7d115d2a20060c");
                } catch (Exception e) {
                    e.printStackTrace();
                    hwnd.sendEmptyMessage(-1);
                    return;
                }

                try {
                    if (query != null && query.length() > 0)
                    {
                        PrintWriter pw = new PrintWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), encode_Web));
                        pw.write(query);
                        pw.flush();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    hwnd.sendEmptyMessage(-2);
                    return;
                }

                try {
                    status = httpURLConnection.getResponseCode();
                    bufferedReader = new BufferedReader(
                            new InputStreamReader(httpURLConnection.getInputStream(), encode_Web));
                } catch (Exception e) {
                    e.printStackTrace();
                    hwnd.sendEmptyMessage(-status);
                    return;
                }

                try {
                    while ((m_f_s_line = bufferedReader.readLine()) != null) {
                        str_return.append(m_f_s_line);
                        //System.out.println(m_f_s_line);
                        str_return.append("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    hwnd.sendEmptyMessage(-3);
                    return;
                }

                Message.obtain(hwnd, 0, str_return.toString()).sendToTarget();
            }
        }

        Thread thread_getContext = new Thread_getContext(sUrl, connect_Method, encode_Web, query, hwnd);
        thread_getContext.setDaemon(true);
        thread_getContext.start();
    }
}
