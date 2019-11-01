package com.example.demo_qlkho;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class frm_ChiTietSP extends AppCompatActivity {

    ImageView img;
    TextView txt1,txt2,txt3,txt4;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsp);

        //ánh xạ
        img = (ImageView) findViewById(R.id.imageView3);
        txt1 = (TextView) findViewById(R.id.textView4);
        txt2 = (TextView) findViewById(R.id.textView5);
        txt3 = (TextView) findViewById(R.id.textView6);
        txt4 = (TextView) findViewById(R.id.textView7);

        //nhận dữ liệu pass qua
        Intent i = getIntent();
        Bundle b = i.getBundleExtra("bundle");
        img.setImageResource(b.getInt("anh"));
        txt1.setText(b.getString("ten"));
        txt2.setText("Mã:"+b.getString("ma"));
        txt3.setText("Số lượng:"+String.valueOf(b.getInt("soluong")));
        txt4.setText("Đơn vị tính:"+b.getString("dvt"));
     //   String str = i.getStringExtra("Name");
//        btn = findViewById(R.id.button);
//        txt = findViewById(R.id.textView2);
//        String str2 = str4;//i.getStringExtra("Name2");
//        Log.d("ead",str2);
//        txt.setText(str2);
////        img = findViewById(R.id.imageView);
////        img.setImageResource(i.getIntExtra("image",-1));
//        btn.setText(str);
    }
}
