package com.marvel.api.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MarvelApiClient {

    private static final String PROPERTIES_FILE = "config.properties";
    private static final Properties properties = loadProperties();

    private static final String API_BASE_URL = properties.getProperty("marvel.api.base.url");
    private static final String API_KEY = properties.getProperty("marvel.api.key");
    private static final String API_HASH = properties.getProperty("marvel.api.hash");

    private static Properties loadProperties() {
        Properties prop = new Properties();
        try (InputStream input = MarvelApiClient.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + PROPERTIES_FILE);
                return prop;
            }
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public String buildUlrParamenters() {
        return "apikey=" + API_KEY + "&hash=" + API_HASH + "&ts=1";
    }

    public JsonObject getCharacters() {
        String url = API_BASE_URL + "characters?" + buildUlrParamenters();
        return sendRequest(url);
    }

    public JsonObject getCharacterById(int characterId) {
        String url = API_BASE_URL + "characters/" + characterId + "?" +  buildUlrParamenters();
        return sendRequest(url);
    }

    private JsonObject sendRequest(String url) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");

            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(responseString);
            return jsonElement.getAsJsonObject();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

}
