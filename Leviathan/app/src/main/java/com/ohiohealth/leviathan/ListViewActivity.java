package com.ohiohealth.leviathan;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListViewActivity extends AppCompatActivity {


    private int int_number_of_rows = 10;
private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);

        listView = (ListView) this.findViewById(R.id.list_view_widget);
        getList("");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "Postion: " + position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ListViewActivity.this, ListViewActivity.class);
                startActivity(intent);

                //TODO: Based on choice load new list, create and populate new list or display content

            }
        });
    }


    private String[] getList(String choice) {

        //TODO: Use web services to get the category list, pass in choice as param

        String[] string1 = new String[]{};

        //Build list
        populateList();

        return string1;

    }

    private void populateList(){

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_cell_layout, R.id.listcelltext);
        listView.setAdapter(adapter);

        for (int i = 0; i < int_number_of_rows; i++) {
            adapter.add("Cell: " + i);
        }

        adapter.notifyDataSetChanged();

    }
}
