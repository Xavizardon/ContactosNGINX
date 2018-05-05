package com.example.deryancruz.contactosnginx;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapterCall extends RecyclerView.Adapter<RecyclerViewAdapterCall.MyViewHolder>{

    Context mContext;
    List<Call> mData;

    public RecyclerViewAdapterCall(Context mContext, List<Call> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_call,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_phone.setText(mData.get(position).getPhone());
        holder.tv_type.setText(mData.get(position).getType());
        holder.tv_duration.setText(mData.get(position).getDuration());

        holder.boton_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent llamar = new Intent(Intent.ACTION_CALL);
                llamar.setData(Uri.parse("tel:"+mData.get(position).getPhone()));
                v.getContext().startActivity(llamar);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private TextView tv_phone;
        private TextView tv_type;
        private TextView tv_duration;
        private ImageView img;
        private ImageButton boton_llamar;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.name_contact_call);
            tv_phone = (TextView) itemView.findViewById(R.id.phone_contact_call);
            tv_type = (TextView) itemView.findViewById(R.id.type_of_call);
            tv_duration = (TextView) itemView.findViewById(R.id.duration);
            boton_llamar = (ImageButton) itemView.findViewById(R.id.boton_llamar_call);
            //img = (ImageView) itemView.findViewById(R.id.img_contact_call);

        }
    }

}
