package com.itchunyang.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.itchunyang.fragment.fragment.MyListFragment;

public class ListFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fragment);

        getFragmentManager().beginTransaction().replace(R.id.container,new MyListFragment()).commit();
    }
}
