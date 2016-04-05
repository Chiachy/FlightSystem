package com.shanshan.flightmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shakugan on 16/4/5.
 */
public class ActivitySearchResult extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private RecyclerView resultList;
    private SearchResultAdapter adapter;
    public static List<FlightDatas> datases = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        resultList = (RecyclerView) findViewById(R.id.result_list);
        linearLayoutManager = new LinearLayoutManager(this);
        resultList.setLayoutManager(linearLayoutManager);
        adapter = new SearchResultAdapter(this,datases);
        resultList.setAdapter(adapter);
        if (datases.size() > 0) {
            TextView textView = (TextView) findViewById(R.id.result_text);
            textView.setVisibility(View.GONE);
        }
    }
}
