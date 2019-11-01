package com.example.demo_qlkho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DanhMucAdapter extends RecyclerView.Adapter<DanhMucAdapter.DanhMucHolder>{

    private List<DanhMuc> danhMucList;
    private Context context;
    private ItemClickListener itemClick;


    public DanhMucAdapter(List<DanhMuc> danhMucList, Context context) {
        this.danhMucList = danhMucList;
        this.context = context;
    }

    public class DanhMucHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name,mota;



        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        private ItemClickListener itemClickListener;

        public DanhMucHolder(View view){
            super(view);
            name = view.findViewById(R.id.tendanhmuc);
            mota = view.findViewById(R.id.motadanhmuc);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            if(itemClick!=null)
                itemClick.onClick(view,getAdapterPosition());
        }
    }

    public void setClick(ItemClickListener itemClick){
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public DanhMucAdapter.DanhMucHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.item_danhmuc,viewGroup,false);
        return new DanhMucAdapter.DanhMucHolder(itemview);
    }

    @Override
    public void onBindViewHolder (@NonNull DanhMucAdapter.DanhMucHolder holder, final int position) {
        holder.name.setText(danhMucList.get(position).getTendanhmuc());
        holder.mota.setText(danhMucList.get(position).getMotadanhmuc());


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int postional) {
                //Toast.makeText(context,"chào"+position,Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return danhMucList.size();
    }
}
