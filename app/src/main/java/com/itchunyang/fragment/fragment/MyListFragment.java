package com.itchunyang.fragment.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.itchunyang.fragment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcy on 2016/11/15.
 */

public class MyListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        //定义一个数组
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            data.add("smyh" + i);
        }

        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,data));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(),((TextView)v).getText().toString(),Toast.LENGTH_SHORT).show();
    }
}
