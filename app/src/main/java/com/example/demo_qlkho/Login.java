package com.example.demo_qlkho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText edtUser;
    EditText edtPass;

    Button btnDangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //ánh xạ
        edtUser = (EditText) findViewById(R.id.txtUser);
        edtPass = (EditText) findViewById(R.id.txtPass);

        btnDangnhap = (Button) findViewById(R.id.btnLogin);

//        btnDangnhap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//            }
//        });

    }

    public void Clickabc(View view) {
        String user = edtUser.getText().toString();
        String pass = edtPass.getText().toString();

        if(edtUser.length()==0){
            edtUser.setError("Nhập tài khoản");
        }
        if(edtPass.length()==0){
            edtPass.setError("Nhập mật khẩu");
        }

        //chuyển màn hình
        if(edtUser.length()!=0 && edtPass.length()!=0){
            Intent intent = new Intent(Login.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(Login.this,"Bạn cần nhập tài khoản mật khẩu để đăng nhập",Toast.LENGTH_LONG).show();
        }
    }
}