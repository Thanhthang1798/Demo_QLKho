package com.example.demo_qlkho;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class frm_HangHoa extends AppCompatActivity implements ItemClickListener, SearchView.OnQueryTextListener {

    private static final String TAG = "abc";
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

    TextView search;
    ImageButton clear;
    private String newText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hanghoa);

        recyclerView = findViewById(R.id.recycler_Hanghoa);



        hangHoaAdapter = new HangHoaAdapter(hangHoaList,frm_HangHoa.this);
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
            Toast.makeText(frm_HangHoa.this,"Sản phẩm "+ name,Toast.LENGTH_LONG).show();
            Truyendataa(postional);
        }

    public void Truyendataa(int potational){
        Intent i = new Intent(this,frm_ChiTietSP.class);
//

        Bundle bundle = new Bundle();
        bundle.putInt("anh",listanh[potational]);
        bundle.putString("ten",list_name[potational].toString().trim());
        bundle.putString("ma",list_ma[potational].toString().trim());
        bundle.putInt("soluong",list_soluong[potational]);
        bundle.putString("dvt",list_dvt[potational].toString().trim());
//        bundle.putString("abd","bca");
//        bundle.putInt("abfd",R.drawable.bgr);
        i.putExtra("bundle",bundle);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search...");
        searchView.setOnQueryTextListener(this);
        return true;
    }




    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }



    @Override
    public boolean onQueryTextChange(String s) {
        String userinput="";
        if(s!=null) userinput = s.toLowerCase();
        List<HangHoa> HHL = new ArrayList<>();

        Log.d(TAG, "onQueryTextChange: "+hangHoaList.size());
        for( int i=0;i<hangHoaList.size();i++){
            HangHoa hangHoa = hangHoaList.get(i);
            String value = convert(hangHoa.getTensp());
            Log.d(TAG, "tensp: "+(hangHoa.getTensp())+"uss" + userinput+" "+s);
            if(value.toLowerCase().contains(userinput)){
                HHL.add(hangHoa);
            }
        }
        hangHoaAdapter.UpdateList(HHL);

        return true;
    }


    public static String convert(String str) {
        str = str.replaceAll("à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ", "a");
        str = str.replaceAll("è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ", "e");
        str = str.replaceAll("ì|í|ị|ỉ|ĩ", "i");
        str = str.replaceAll("ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ", "o");
        str = str.replaceAll("ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ", "u");
        str = str.replaceAll("ỳ|ý|ỵ|ỷ|ỹ", "y");
        str = str.replaceAll("đ", "d");

        str = str.replaceAll("À|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ", "A");
        str = str.replaceAll("È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ", "E");
        str = str.replaceAll("Ì|Í|Ị|Ỉ|Ĩ", "I");
        str = str.replaceAll("Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ", "O");
        str = str.replaceAll("Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ", "U");
        str = str.replaceAll("Ỳ|Ý|Ỵ|Ỷ|Ỹ", "Y");
        str = str.replaceAll("Đ", "D");
        return str;
    }


}
