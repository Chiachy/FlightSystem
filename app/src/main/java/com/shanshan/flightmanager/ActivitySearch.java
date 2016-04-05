package com.shanshan.flightmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Shakugan on 16/4/5.
 */
public class ActivitySearch extends AppCompatActivity {

    private EditText searchEdit;
    private Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchEdit = (EditText) findViewById(R.id.search_edit);
        searchBtn = (Button) findViewById(R.id.search_btn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String row = searchEdit.getText().toString();
                if (row.equals("")||row.contains(" ")) {
                    Toast.makeText(ActivitySearch.this,"请输入合法关键字",Toast.LENGTH_LONG).show();
                } else {
                    ActivitySearchResult.datases = FlightManagerDB.getInstance(ActivitySearch.this).searchFlight(searchEdit.getText().toString());
                    Intent intent = new Intent(ActivitySearch.this,ActivitySearchResult.class);
                    startActivity(intent);
                }
            }
        });
    }
}
