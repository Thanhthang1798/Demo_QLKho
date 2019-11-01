package com.example.demo_qlkho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class frm_test extends AppCompatActivity {

    Button btn ;
    TextView txt;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_test);
        Intent i = getIntent();
        Bundle b = i.getBundleExtra("bundle");
        String str4 =  b.getString("abc");
        String str = i.getStringExtra("Name");
        btn = findViewById(R.id.button);
        txt = findViewById(R.id.textView2);
        String str2 = str4;//i.getStringExtra("Name2");
        Log.d("ead",str2);
        txt.setText(str2);
//        img = findViewById(R.id.imageView);
//        img.setImageResource(i.getIntExtra("image",-1));
        btn.setText(str);
    }

    public void btnabc_onclick(View view) {
    }
}
