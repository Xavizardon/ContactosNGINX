package com.example.deryancruz.contactosnginx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentoFavoritos extends Fragment {

    View VistaAuxiliar;

    public FragmentoFavoritos() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        VistaAuxiliar = inflater.inflate(R.layout.favoritos_fragmento,container,false);
        return VistaAuxiliar;
    }
}
