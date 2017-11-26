package com.aclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Button sendRequest = findViewById(R.id.search);
        responseText = findViewById(R.id.response);
       // responseText.setText(getIntent().getStringExtra("search_name"));
        sendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.search) {
            sendRequestWithHttpURLConnection();
        }
    }

    private void sendRequestWithHttpURLConnection() {
        // 开启线程来发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("https://api.cognitive.microsoft.com/bing/v7.0/news");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestProperty("Ocp-Apim-Subscription-Key","513da0e6b07e4113b6b894d88aa8a54e");
                    InputStream in = connection.getInputStream();
                    String response = new Scanner(in).useDelimiter("\\A").next();
                    JSONObject json = new JSONObject(response);
                    JSONArray values = json.getJSONArray("value");
                    showResponse(values);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) { e.printStackTrace(); }
                    }
                    if (connection != null) connection.disconnect();
                }
            }
        }).start();
    }
    private void showResponse(final JSONArray response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder builder = new StringBuilder();
                    for(int i = 0; i < 20; i++) {
                        JSONObject object = response.getJSONObject(i);
                        String name = object.getString("name");
                        builder.append(name+"\n");
                    }
                    responseText.setText(builder.toString());
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}