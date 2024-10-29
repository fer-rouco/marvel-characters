package com.marvel.api.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.marvel.api.client.dtos.MarvelItemInterface;


public class MarvelApiUrlBuilder {
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

  private static String buildUlrParamenters() {
      return "?apikey=" + API_KEY + "&hash=" + API_HASH + "&ts=1";
  }

  public static String buildUrl(String path) {
      return API_BASE_URL + path + buildUlrParamenters();
  }

  public static void buildUrlFromItems(List<? extends MarvelItemInterface> items) {
    items.forEach(item -> {
      item.setResourceURI(item.getResourceURI() + MarvelApiUrlBuilder.buildUlrParamenters());
    });
  }
}
