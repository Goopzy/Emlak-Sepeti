package com.example.emlaksepeti;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private int layout;

    public ListAdapter(Context context, int layout, ArrayList<Model> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    private ArrayList<Model> list;


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    private class ViewHolder{
        ImageView image;
        TextView txtİl,txtİlce,txtMesaj;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row=view;
        ViewHolder holder = new ViewHolder();
        if (row == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout,null);
            holder.txtİl = row.findViewById(R.id.txtİl);
            holder.txtİlce = row.findViewById(R.id.txtİlce);
            holder.txtMesaj = row.findViewById(R.id.txtMesaj);
            holder.image = row.findViewById(R.id.imgs);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder)row.getTag();
        }
        Model model = list.get(i);
        holder.txtİl.setText(model.getIl());
        holder.txtİlce.setText(model.getIlce());
        holder.txtMesaj.setText(model.getMesaj());

        byte[] Vimage=model.getImage();
        Bitmap bitmap= BitmapFactory.decodeByteArray(Vimage,0,Vimage.length);
        holder.image.setImageBitmap(bitmap);
        return row;
    }
}
