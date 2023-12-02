package com.marvel.openpay;

import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MarvelApiClient {

    public static void main(String[] args) {
        JsonObject chars = new MarvelApiClient().getCharacters();
        JsonObject char1 = new MarvelApiClient().getCharacterById(1011334);
        JsonObject char2 = new MarvelApiClient().getCharacterById(1011334);
    }

    private static final String PROPERTIES_FILE = "config.properties";
    private static final Properties properties = loadProperties();

    private static final String API_BASE_URL = properties.getProperty("marvel.api.base.url");
    private static final String API_KEY = properties.getProperty("marvel.api.key");

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
    
    public JsonObject getCharacters() {
        String url = API_BASE_URL + "characters?apikey=" + API_KEY;
        return sendRequest(url);
    }

    public JsonObject getCharacterById(int characterId) {
        String url = API_BASE_URL + "characters/" + characterId + "?apikey=" + API_KEY;
        return sendRequest(url);
    }

    private JsonObject sendRequest(String url) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            // Procesar la respuesta JSON
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(response.getEntity().getContent());
            return jsonElement.getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
