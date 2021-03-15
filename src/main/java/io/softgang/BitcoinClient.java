package io.softgang;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.softgang.model.PriceData;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class BitcoinClient {
    public PriceData getBitcoinPrice() throws Exception {
        URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice/usd.json");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responsecode = conn.getResponseCode();
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {

            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            //Close the scanner
            scanner.close();
            System.out.println(inline);
            Gson gson = new Gson();
            PriceData priceData = gson.fromJson(inline, PriceData.class);
            return priceData;

        }

    }
}
