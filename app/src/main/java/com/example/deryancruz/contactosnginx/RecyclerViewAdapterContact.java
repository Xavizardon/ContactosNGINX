package com.example.deryancruz.contactosnginx;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RecyclerViewAdapterContact extends RecyclerView.Adapter<RecyclerViewAdapterContact.MyViewHolder> {

    Context mContext;
    List<Contact> mData;
    Dialog dialogo;

    public RecyclerViewAdapterContact(Context mContext, List<Contact> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_contact, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(v);

        dialogo = new Dialog(mContext);
        dialogo.setContentView(R.layout.dialog_contact);
        dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        viewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView dialog_name_tv = (TextView) dialogo.findViewById(R.id.dialog_name);
                final TextView dialog_phone_tv = (TextView) dialogo.findViewById(R.id.dialog_phone);
                dialog_name_tv.setText(mData.get(viewHolder.getAdapterPosition()).getName());
                dialog_phone_tv.setText(mData.get(viewHolder.getAdapterPosition()).getPhone());
                Button llamar_button = (Button) dialogo.findViewById(R.id.dialog_call_button);
                Button share_button = (Button) dialogo.findViewById(R.id.dialog_share_button);

                llamar_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent llamar = new Intent(Intent.ACTION_CALL);
                        llamar.setData(Uri.parse("tel:" + dialog_phone_tv.getText().toString()));
                        if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        v.getContext().startActivity(llamar);
                    }
                });

                share_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent compartir = new Intent(Intent.ACTION_SEND);
                        compartir.putExtra(Intent.EXTRA_TEXT,dialog_name_tv.getText().toString()
                        +"/n"+dialog_phone_tv.getText().toString());
                        compartir.setType("text/plain");
                        v.getContext().startActivity(Intent.createChooser(compartir,"Comparte la informacion de:"+dialog_name_tv.getText().toString()));
                    }
                });

                dialogo.show();
            }

        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_phone.setText(mData.get(position).getPhone());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(),mData.get(position).getName(), Toast.LENGTH_LONG).show();
                return true;
            }
        });

        /*holder.boton_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent llamar = new Intent(Intent.ACTION_CALL);
                llamar.setData(Uri.parse("tel:"+mData.get(position).getPhone()));
                v.getContext().startActivity(llamar);

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /*public void filterLis(List<Contact> filteredList) {
        mData = filteredList;
        notifyDataSetChanged();
    }*/

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private TextView tv_phone;
        private ImageView img;
        private ImageButton boton_llamar;
        private LinearLayout item_contact;

        public MyViewHolder(View itemView) {
            super(itemView);

            item_contact = (LinearLayout) itemView.findViewById(R.id.contact_item_id);
            tv_name = (TextView) itemView.findViewById(R.id.name_contact);
            tv_phone = (TextView) itemView.findViewById(R.id.phone_contact);
            boton_llamar = (ImageButton) itemView.findViewById(R.id.boton_llamar);
            //img = (ImageView) itemView.findViewById(R.id.img_contact);

        }

    }

}
