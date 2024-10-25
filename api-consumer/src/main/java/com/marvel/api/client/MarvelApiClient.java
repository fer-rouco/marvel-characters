package com.marvel.api.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MarvelApiClient {

    public JsonObject getCharacters() {
        String url = MarvelApiUrlBuilder.buildUrl("characters");
        return sendRequest(url);
    }

    public JsonObject getCharacterById(int characterId) {
        String url = MarvelApiUrlBuilder.buildUrl("characters/" + characterId);
        return sendRequest(url);
    }

    private JsonObject sendRequest(String url) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");


            return JsonParser.parseString(responseString).getAsJsonObject();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

}
