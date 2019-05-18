package com.example.mvpdemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtMa;
    Button btnXacNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMa = findViewById(R.id.txtMa);
        btnXacNhan = findViewById(R.id.btnXacNhan);
        btnXacNhan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String maloaicha = txtMa.getText().toString();
        String duongdan = "http://192.168.43.10:81/lazada/loaisanpham/loaisanpham.php?maloaicha="+maloaicha;
        DownloadJSON downloadJSON = new DownloadJSON();
        downloadJSON.execute(duongdan);
    }
    public class DownloadJSON extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
               // connection.setRequestMethod("GET");
                connection.connect();


                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = "";
                StringBuilder dulieu = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    dulieu.append(line);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
