package com.example.deryancruz.contactosnginx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FragmentoFavoritos extends Fragment {

    View VistaAuxiliar;
    private RecyclerView RecyclerViewFavoritos;
    static List<Contactos> ListaDeContactos;
    //Constructos por defecto
    public FragmentoFavoritos() {}

    //getters
    public static List<Contactos> getListaDeContactos() {
        return ListaDeContactos;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        VistaAuxiliar = inflater.inflate(R.layout.favoritos_fragmento,container,false);

        RecyclerViewFavoritos = (RecyclerView) VistaAuxiliar.findViewById(R.id.recyclerview_contactos);

        RecyclerViewAdaptadorFavoritos recyclerViewAdapterContact = new RecyclerViewAdaptadorFavoritos(getContext(),ListaDeContactos);
        //Aquí truena
        RecyclerViewFavoritos.setLayoutManager(new GridLayoutManager(getActivity(),3));
        RecyclerViewFavoritos.setAdapter(recyclerViewAdapterContact);

        return VistaAuxiliar;

    }

}
