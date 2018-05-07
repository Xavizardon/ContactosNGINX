package com.example.deryancruz.contactosnginx;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdaptadorContactos
        extends RecyclerView.Adapter<RecyclerViewAdaptadorContactos.MyViewHolder> {

    private Context Contexto;
    private static List<Contactos> DatosContactos;

    public RecyclerViewAdaptadorContactos(Context contexto, List<Contactos> datosContactos) {
        this.Contexto = contexto;
        this.DatosContactos = datosContactos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(Contexto);
        view = inflater.inflate(R.layout.contactos_cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.TextViewNombre.setText(DatosContactos.get(position).getNombreContacto());
        //holder.FotoContacto.setImageResource(DatosContactos.get(position).getFotoContacto());
        holder.FotoContacto.setImageResource(R.drawable.ic_person_black_24dp);
    }

    @Override
    public int getItemCount() {
        return DatosContactos.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView TextViewNombre;
        ImageView FotoContacto;
        ImageView Favoritos;
        CardView ContactosCardView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            TextViewNombre = (TextView) itemView.findViewById(R.id.nombre_cardview);
            FotoContacto = (ImageView)  itemView.findViewById(R.id.foto_contacto);
            ContactosCardView = (CardView) itemView.findViewById(R.id.contactos_cardview);
            Favoritos = (ImageView) itemView.findViewById(R.id.boton_favorito);

            /**
             * Seteo un evento para que se levante un cuadro de diálogo
             * @author Davis Developer
             * @event OnLongClickListener
             * @params recibe como parámetro el cardview
             */
            // TODO: 5/7/2018
            ContactosCardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position  = getLayoutPosition();

                    if(position != RecyclerView.NO_POSITION){

                    }
                    return false;
                }
            });

            Favoritos.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    boolean isFavoritos;

                    if (!FragmentoContactos.ListaDeContactos.get(position).isFavoritos()) {
                        FragmentoContactos.ListaDeContactos.get(position).setFavoritos(true);
                        Favoritos.setImageResource(R.drawable.ic_star_black_24dp);
                    }
                    else{
                        Favoritos.setImageResource(R.drawable.ic_star_border_black_24dp);
                        FragmentoContactos.ListaDeContactos.get(position).setFavoritos(false);
                    }
                }
            });
        }
    }
}
