package com.example.newspagingapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NewsApiClient.NewsResponseListener {
    private ListView listView;
    private ArrayList<String> newsArrayList;
    private ArrayAdapter<String> adapter;
    private int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        newsArrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, newsArrayList);
        listView.setAdapter(adapter);
        if (listView.getVisibility() == View.VISIBLE) {
            Log.d("ListViewVisibility", "ListView is visible");
        } else {
            Log.d("ListViewVisibility", "ListView is not visible");
        }
        // Load the first page of news
        loadNews();
    }

    private void loadNews() {
        // Make an API call to fetch news asynchronously
        new NewsApiClient(currentPage, this).execute();
    }

    @Override
    public void onNewsResponse(ArrayList<String> newsList) {
        // Add the fetched news to the list and notify the adapter
        newsArrayList.addAll(newsList);
        adapter.notifyDataSetChanged();
    }
}

