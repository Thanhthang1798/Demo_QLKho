package com.example.demo_qlkho;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HangHoaAdapter extends RecyclerView.Adapter<HangHoaAdapter.HangHoaHolder> {
    private List<HangHoa> hangHoaList;
    private Context context;
    private ItemClickListener itemClickListener;

    public HangHoaAdapter(List<HangHoa> hangHoaList, Context context) {
        this.hangHoaList = hangHoaList;
        this.context = context;
    }



    public class HangHoaHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView anh;
        TextView ten,ma,soluong,dvt;

        private ItemClickListener itemClick;

        public void setItemClick(ItemClickListener itemClick) {
            this.itemClick = itemClick;
        }

        public HangHoaHolder(View view){
            super(view);
            anh = view.findViewById(R.id.hinhanhsp);
            ten = view.findViewById(R.id.ten_sp);
            ma = view.findViewById(R.id.ma_sp);
            soluong = view.findViewById(R.id.soluong_sp);
            dvt = view.findViewById(R.id.dvt_sp);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(itemClickListener!=null)
                itemClickListener.onClick(view,getAdapterPosition());
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public HangHoaAdapter.HangHoaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.item_hanghoa,parent,false);
        return new HangHoaAdapter.HangHoaHolder(itemview);
    }



    @Override
    public void onBindViewHolder(@NonNull HangHoaAdapter.HangHoaHolder holder,final int position) {
        holder.anh.setImageResource(hangHoaList.get(position).getHinhanh());
        holder.ten.setText(hangHoaList.get(position).getTensp());
        holder.ma.setText("Mã: "+hangHoaList.get(position).getMasp());
        holder.soluong.setText("Số lượng: "+String.valueOf(hangHoaList.get(position).getSoluong()));
        holder.dvt.setText("Đơn vị tính"+hangHoaList.get(position).getDonvitinh());

        holder.setItemClick(new ItemClickListener() {
            @Override
            public void onClick(View view, int postional) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return hangHoaList.size();
    }

    public void UpdateList(List<HangHoa> newlist){
        hangHoaList = new ArrayList<>();
        hangHoaList.addAll(newlist);
        notifyDataSetChanged();
    }

}
