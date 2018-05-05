package com.example.deryancruz.contactosnginx;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapterContact extends RecyclerView.Adapter<RecyclerViewAdapterContact.MyViewHolder> {

    private Context context1;
    private List<Contact> data;

    public RecyclerViewAdapterContact(Context context1, List<Contact> data) {
        this.context1 = context1;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context1);
        view = inflater.inflate(R.layout.cardview1,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.txt_nom.setText(data.get(position).getNombre());
        //holder.img.setImageResource(data.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_nom;
        ImageView img;
        ImageView bot;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_nom = (TextView) itemView.findViewById(R.id.txt1);
            img = (ImageView)  itemView.findViewById(R.id.img1);
            cardView = (CardView) itemView.findViewById(R.id.cardv_id);
        }
    }
}
