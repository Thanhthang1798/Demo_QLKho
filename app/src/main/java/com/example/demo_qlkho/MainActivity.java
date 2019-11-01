package com.example.demo_qlkho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    String[] nameList = {"Danh mục hàng",
                         "Nhập Hàng",
                         "Xuất Hàng",
                         "Kiểm Kê",
                         "Thông tin"
    };
    String[] motaList = {
            "Thêm hàng kiểm soát số lượng",
            "Xuất hàng nhớ lập BB",
            "Cập nhật nhớ note lại",
            "Thêm hàng kiểm soát số lượng",
            "Thêm hàng kiểm soát số lượng"
    };

    RecyclerView recyclerView;
    DanhMucAdapter danhMucAdapter;
    List<DanhMuc> danhMucList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);



        danhMucAdapter = new DanhMucAdapter(danhMucList,MainActivity.this);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,((LinearLayoutManager) layoutManager).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(danhMucAdapter);
        danhMucAdapter.setClick(this);

        for(int i=0;i<nameList.length;i++){
            String name = nameList[i];
            String mota = motaList[i];

            DanhMuc danhMuc = new DanhMuc(name,mota);
            danhMucList.add(danhMuc);
        }


    }

    @Override
    public void onClick(View view, int potation){
        Toast.makeText(MainActivity.this,"chào"+potation,Toast.LENGTH_LONG).show();
        if(potation==0){
            Intent intent = new Intent(MainActivity.this,frm_HangHoa.class);
            startActivity(intent);
        }
        else if(potation==1){
            Intent intent = new Intent(MainActivity.this,NhapHang.class);
            startActivity(intent);
        }
        else if(potation==2){
            Intent intent = new Intent(MainActivity.this,frm_XuatHang.class);
            startActivity(intent);
        }
        else{
            Intent i = new Intent(this,frm_test.class);
            i.putExtra("Name",motaList[potation].toString().trim());
            String ao = getString(R.string.abc);
            i.putExtra("Name2",ao);

            Log.d("ddd",""+R.string.abc);
            Bundle bundle = new Bundle();
            bundle.putString("abc","bca");
            bundle.putString("abv","bca");
//        bundle.putString("abd","bca");
//        bundle.putInt("abfd",R.drawable.bgr);
            i.putExtra("bundle",bundle);
            startActivity(i);
        }
    }
}
