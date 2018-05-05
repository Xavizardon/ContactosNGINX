package com.example.deryancruz.contactosnginx;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class FragmentContact extends Fragment{

    View v;
    private RecyclerView myrecycleview;
    private List<Contact> lsContact;

    public FragmentContact() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadContacs();
    }


    public void loadContacs(){

        lsContact = new ArrayList<>();

        String[] projeccion = new String[] { ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.TYPE };

        String selectionClause = ContactsContract.Data.MIMETYPE + "='" +
                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "' AND "
                + ContactsContract.CommonDataKinds.Phone.NUMBER + " IS NOT NULL";

        String sortOrder = ContactsContract.Data.DISPLAY_NAME + " ASC";

        Cursor c = getActivity().getContentResolver().query(
                ContactsContract.Data.CONTENT_URI,
                projeccion,
                selectionClause,
                null,
                sortOrder);

        while(c.moveToNext()){
            lsContact.add(new Contact(c.getString(1), c.getString(2)));
        }
        c.close();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.contact_fragment, container, false);
        myrecycleview = (RecyclerView) v.findViewById(R.id.contact_recyclerview);

        RecyclerViewAdapterContact recyclerViewAdapterContact = new RecyclerViewAdapterContact(getContext(),lsContact);
        myrecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleview.setAdapter(recyclerViewAdapterContact);

        EditText editText = (EditText) v.findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                List<Contact> filteredList = new ArrayList<>();
                for(Contact item : lsContact){
                    if(item.getName().toLowerCase().contains(s.toString().toLowerCase())){
                        filteredList.add(item);
                    }
                }
                RecyclerViewAdapterContact recyclerViewAdapterContact = new RecyclerViewAdapterContact(getContext(),filteredList);
                myrecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
                myrecycleview.setAdapter(recyclerViewAdapterContact);
            }
        });

        //RecyclerViewAdapterContact recyclerViewAdapterContact = new RecyclerViewAdapterContact(getContext(), lsContact);

        return v;
    }

}
