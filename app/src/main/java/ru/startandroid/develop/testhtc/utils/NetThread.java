package ru.startandroid.develop.testhtc.utils;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import ru.startandroid.develop.testhtc.models.Employees;
import ru.startandroid.develop.testhtc.JSONParser;

public class NetThread extends Thread {
    static ArrayList<Employees> list;

    @Override
    public void run() {
        try {
            URL url = new URL("http://www.mocky.io/v2/5ddcd3673400005800eae483");
            String response = NetworkUtils.getResponseFromURL(url);
            JSONParser.parseJson(response);


        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
