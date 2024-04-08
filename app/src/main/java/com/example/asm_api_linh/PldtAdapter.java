package com.example.asm_api_linh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PldtAdapter extends BaseAdapter {
    List<PldtModel> qldtModelList;
    Context context;

    public PldtAdapter(Context context, List<PldtModel> qldtModelList, APIService apiService) {
        this.context = context;
        this.qldtModelList = qldtModelList;
    }

    @Override
    public int getCount() {
        return qldtModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return qldtModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_pldt, parent, false);


        TextView tvID = rowView.findViewById(R.id.tvId);
        ImageView imgAvatar = rowView.findViewById(R.id.imgAvatatr);
        TextView tvName = rowView.findViewById(R.id.tvName);
        TextView tvNamSX = rowView.findViewById(R.id.tvNamSX);
        TextView tvHang = rowView.findViewById(R.id.tvHang);
        TextView tvGia = rowView.findViewById(R.id.tvGia);

        PldtModel model = qldtModelList.get(position);
        tvID.setText(String.valueOf(model.get_id()));
        tvName.setText(model.getTen());
        tvNamSX.setText(String.valueOf(model.getNamsx()));
        tvHang.setText(model.getHang());
        tvGia.setText(String.valueOf(model.getGia()));

        String imageUrl = qldtModelList.get(position).getImgAvatar();

        // Sử dụng Picasso để tải hình ảnh từ URL và hiển thị nó trong ImageView
        Picasso.get().load(imageUrl).into(imgAvatar);
        return rowView;
    }
    }




