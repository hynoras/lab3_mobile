package com.example.newspagingapp;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NewsApiClient extends AsyncTask<Void, Void, ArrayList<String>> {
    private static final String TAG = "NewsApiClient";
    private static final String BASE_URL = "https://newsapi.org/v2/everything";
    private static final String API_KEY = "65037d87299349b5bcf42e2611cbbbc4"; // Replace with your News API key
    private static final String QUERY = "tesla";
    private static final String FROM_DATE = "2024-03-24";
    private static final String SORT_BY = "publishedAt";
    private static final int PAGE_SIZE = 10;
    private int page;
    private NewsResponseListener listener;

    public NewsApiClient(int page, NewsResponseListener listener) {
        this.page = page;
        this.listener = listener;
    }

    @Override
    protected ArrayList<String> doInBackground(Void... voids) {
        ArrayList<String> newsList = new ArrayList<>();
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(buildUrl());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();
            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\n");
            }

            if (buffer.length() == 0) {
                return null;
            }
            String jsonResponse = buffer.toString();

            // Parse JSON response
            JSONObject response = new JSONObject(jsonResponse);
            JSONArray articles = response.getJSONArray("articles");
            for (int i = 0; i < articles.length(); i++) {
                JSONObject article = articles.getJSONObject(i);
                String title = article.getString("title");
                newsList.add(title);
            }

        } catch (Exception e) {
            Log.e(TAG, "Error fetching news data: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    Log.e(TAG, "Error closing reader: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return newsList;
    }

    @Override
    protected void onPostExecute(ArrayList<String> newsList) {
        if (listener != null) {
            listener.onNewsResponse(newsList);
        }
    }

    private String buildUrl() {
        return BASE_URL + "?q=" + QUERY + "&from=" + FROM_DATE + "&sortBy=" + SORT_BY +
                "&pageSize=" + PAGE_SIZE + "&page=" + page + "&apiKey=" + API_KEY;
    }

    public interface NewsResponseListener {
        void onNewsResponse(ArrayList<String> newsList);
    }
}


