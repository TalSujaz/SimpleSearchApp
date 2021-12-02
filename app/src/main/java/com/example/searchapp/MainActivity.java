package com.example.searchapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExmpleList;

    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();
        EditText editText=findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
             filter(s.toString());
            }
        });
    }

    private void filter(String text) {
        ArrayList<ExampleItem> filteredList= new ArrayList<>();
        for(ExampleItem item: mExmpleList){
            if(item.getText1().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
    }

    private void createExampleList() {
        mExmpleList= new ArrayList<>();
        mExmpleList.add(new ExampleItem(R.drawable.pic1,"One","Line 2"));
        mExmpleList.add(new ExampleItem(R.drawable.pic2,"Two","Line 2"));
        mExmpleList.add(new ExampleItem(R.drawable.pic3,"Three","Line 2"));
    }
    private void buildRecyclerView() {
        mRecyclerView= findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager= new LinearLayoutManager(this);
        mAdapter= new ExampleAdapter(mExmpleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
