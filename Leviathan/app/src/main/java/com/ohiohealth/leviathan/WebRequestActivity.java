package com.ohiohealth.leviathan;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ohiohealth.leviathan.API.Bobert;
import com.ohiohealth.leviathan.API.entities.CategoryPositionResults;
import com.ohiohealth.leviathan.API.entities.DictionaryList;
import com.ohiohealth.leviathan.API.entities.dictionaryObject;
import com.ohiohealth.leviathan.API.services.BobertService;

import java.util.List;

public class WebRequestActivity extends AppCompatActivity {


private TextView mResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webrequest);
        mResults = (TextView) findViewById(R.id.retrofitResults);
        new categoryRequest().execute();



    }

    public class categoryRequest extends AsyncTask<String, String, String>
    {
        DictionaryList resultsList;
        CategoryPositionResults results2;
        @Override
        protected String doInBackground(String... params) {
            BobertService bobertService = new Bobert().bobertService();
            resultsList =  bobertService.getCategories();
            results2 = bobertService.GetCategoryPositionsResult(1);
            return null;
        }

        @Override
        protected void onPostExecute(String returnValue)
        {
            String resultsString = "";
            for (dictionaryObject d : resultsList.getDictionaryList())
            {
                resultsString += "\r\n\r\nID: " + d.getID() + "\r\nDecription: " + d.getDescription();
            }
            for (dictionaryObject d : results2.getDictionaryList())
            {
                resultsString += "\r\n\r\nID: " + d.getID() + "\r\nDecription: " + d.getDescription();
            }
            mResults.setText(resultsString);
        }
    }
}
