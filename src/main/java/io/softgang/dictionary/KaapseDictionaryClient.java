package io.softgang.dictionary;

import com.google.gson.Gson;
import io.softgang.dictionary.model.WordData;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class KaapseDictionaryClient {
    public WordData getRandomWord() throws Exception {
        URL url = new URL("https://kaapsedictionary.co.za/api/random");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responsecode = conn.getResponseCode();
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {

            String word = "";
            Scanner scanner = new Scanner(url.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                word += scanner.nextLine();
            }

            //Close the scanner
            scanner.close();
            System.out.println(word);
            Gson gson = new Gson();
            WordData wordData = gson.fromJson(word, WordData.class);
            return wordData;

        }

    }
}
