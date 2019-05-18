package com.dinh.fragment_list;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FragmentList extends ListFragment {
    String []arrCity = {"Quảng Trị","Huế","Đà Nẵng","TP HCM","Vũng Tàu"};
    ArrayAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,arrCity);
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(),arrCity[position], Toast.LENGTH_SHORT).show();
        super.onListItemClick(l, v, position, id);
    }
}
