package com.example.demo_qlkho;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NhapHang extends AppCompatActivity implements ItemClickListener {

    TextView txtnhap,name;
    Button btnktra;

    LinearLayout layout1,layout2;

    int[] listanh = {R.drawable.anh1,
            R.drawable.anh2,
            R.drawable.anh3,
            R.drawable.anh4,
            R.drawable.anh4,
            R.drawable.anh1,
            R.drawable.anh2,
            R.drawable.anh3,
            R.drawable.anh4,
            R.drawable.anh4
    };

    String[] list_name = {"Bia","Rượu","Mồi","Cồn","Gas","Bia","Rượu","Mồi","Cồn","Gas"};
    String[] list_ma = {"s001","s002","s003","s004","s005","s001","s002","s003","s004","s005"};
    int[] list_soluong = {10,5,2,6,3,10,5,2,6,3};
    String[] list_dvt = {"cái","hộp","lon","thùng","chai","cái","hộp","lon","thùng","chai"};

    RecyclerView recyclerView;
    HangHoaAdapter hangHoaAdapter;
    List<HangHoa> hangHoaList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_phieunhap);
        //ánh xạ
        txtnhap = (TextView) findViewById(R.id.txtPhieu);
        btnktra = (Button) findViewById(R.id.btnKiemtraNhap);
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout2 = (LinearLayout) findViewById(R.id.layout2);
        //thay đổi phiếu nhập
        name = (TextView) findViewById(R.id.IdName);

        //LoadList();
        ClearLayout();




    }

    public void ClearLayout(){
        layout1.setVisibility(View.INVISIBLE);
        layout2.setVisibility(View.INVISIBLE);
    }




    public void KtraClick(View view) {
        String a = txtnhap.getText().toString();
        if(txtnhap.length()==0){
            txtnhap.setError("Hãy nhập mã đơn hàng");
        }else{
            if(a.equals("abc")||a.equals("a")){
                ClearLayout();
                layout1.setVisibility(View.VISIBLE);
                name.setText(txtnhap.getText());
            }
            else{
                Toast.makeText(NhapHang.this,"Nhập sai mã kìa!",Toast.LENGTH_LONG);
                txtnhap.setError("Sai mã");
                txtnhap.setText("");

            }

        }
    }

    public void LoadDS(View view) {
        layout2.setVisibility(View.INVISIBLE);
        layout2.setVisibility(View.VISIBLE);
        hangHoaList.clear();
        LoadList();
    }


    //load recyclerview
    public void LoadList(){

        recyclerView = findViewById(R.id.recycler_Nhaphang);

        recyclerView.clearOnScrollListeners();

        hangHoaAdapter = new HangHoaAdapter(hangHoaList,NhapHang.this);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,((LinearLayoutManager) layoutManager).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(hangHoaAdapter);
        hangHoaAdapter.setItemClickListener(this);

        for(int i=0;i<listanh.length;i++){
            int anh = listanh[i];
            String ten = list_name[i];
            String ma = list_ma[i];
            int soluong = list_soluong[i];
            String dvt = list_dvt[i];

            HangHoa hangHoa = new HangHoa(anh,ten,ma,soluong,dvt);
            hangHoaList.add(hangHoa);
        }
    }

    @Override
    public void onClick(View view, int postional) {
        String name = list_name[postional];
        Toast.makeText(NhapHang.this,"Sản phẩm "+ name,Toast.LENGTH_LONG).show();

    }




}
