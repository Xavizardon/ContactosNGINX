package com.example.deryancruz.contactosnginx;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class RecyclerViewAdaptadorFavoritos
        extends RecyclerView.Adapter<RecyclerViewAdaptadorFavoritos.MyViewHolder>{

    private Context Contexto;
    private static List<Contactos> DatosContactos;

    public RecyclerViewAdaptadorFavoritos(Context contexto, List<Contactos> datosContactos) {
        this.Contexto = contexto;
        this.DatosContactos = datosContactos;
    }


    @Override
    public RecyclerViewAdaptadorFavoritos.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(Contexto);
        view = inflater.inflate(R.layout.contactos_cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdaptadorFavoritos.MyViewHolder holder, int position) {
        holder.TextViewNombre.setText(DatosContactos.get(position).getNombreContacto());
        //holder.FotoContacto.setImageResource(DatosContactos.get(position).getFotoContacto());
        holder.FotoContacto.setImageResource(R.drawable.ic_person_black_24dp);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView TextViewNombre;
        ImageView FotoContacto;
        ImageView Favoritos;
        CardView ContactosCardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            TextViewNombre = (TextView) itemView.findViewById(R.id.nombre_cardview);
            FotoContacto = (ImageView)  itemView.findViewById(R.id.foto_contacto);
            ContactosCardView = (CardView) itemView.findViewById(R.id.contactos_cardview);
            Favoritos = (ImageView) itemView.findViewById(R.id.boton_favorito);

        }
    }
}
