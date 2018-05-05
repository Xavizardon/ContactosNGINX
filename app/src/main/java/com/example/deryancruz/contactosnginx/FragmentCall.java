package com.example.deryancruz.contactosnginx;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentCall extends Fragment {

    View v;
    private RecyclerView myrecycleview;
    private List<Call> lsCall;

    public FragmentCall() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.call_fragment,container,false);
        myrecycleview = (RecyclerView) v.findViewById(R.id.call_recyclerview);
        RecyclerViewAdapterCall recyclerViewAdapterCall = new RecyclerViewAdapterCall(getContext(),lsCall);
        myrecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleview.setAdapter(recyclerViewAdapterCall);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadRegistry();

    }

    public void loadRegistry(){

        lsCall = new ArrayList<>();

        Uri uri;
        uri = Uri.parse("content://call_log/calls");
        String[] projeccion_call = new String[]{CallLog.Calls.CACHED_NAME, CallLog.Calls.NUMBER, CallLog.Calls.TYPE, CallLog.Calls.DURATION};

        Cursor c_call = getContentResolver().query(
                uri,
                projeccion_call,
                null,
                null,
                null);


        while(c_call.moveToNext()){
            nombres_registro.add(c_call.getString(0));
            numeros_registro.add(c_call.getString(1));
            tipo_llamada.add(c_call.getString(2));
            llamada_duracion.add(c_call.getString(3));
        }
        c_call.close();

    }

}
