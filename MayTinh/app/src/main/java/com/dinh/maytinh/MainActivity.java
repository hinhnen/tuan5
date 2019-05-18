package com.dinh.maytinh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtA,txtB,txtKQ;

    Button btnCong,btnTru,btnNhan,btnChia;

    int a,b;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.parseInt(txtA.getText().toString());
                b = Integer.parseInt(txtB.getText().toString());
                txtKQ.setText(a+b);
            }
        });
    }

    private void addControls() {
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        btnChia = findViewById(R.id.btnChia);
        btnCong = findViewById(R.id.btnCong);
        btnNhan = findViewById(R.id.btnNhan);
        btnTru = findViewById(R.id.btnTru);
    }

    public void click(View view) {
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
    }
}
