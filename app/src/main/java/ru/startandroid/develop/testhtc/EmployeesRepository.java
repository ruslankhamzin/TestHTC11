package ru.startandroid.develop.testhtc;

import android.app.Activity;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ru.startandroid.develop.testhtc.utils.NetworkUtils;

public class EmployeesRepository {
    public static List<Employees> employees = new ArrayList<>();
    private static EmployeesRepository instance;
    public static String s;



    private EmployeesRepository() throws IOException, JSONException, InterruptedException {
      NetThread thread = new NetThread();
      thread.start();
      thread.join();



    }




    public static EmployeesRepository getInstance() throws IOException, JSONException, InterruptedException {
        if (instance == null) {
            instance = new EmployeesRepository();
        }
        return instance;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

}
    class NetThread extends Thread{
        static ArrayList<Employees> list;
        @Override
        public void run() {
                    try {
                        URL url = new URL("http://www.mocky.io/v2/5ddcd3673400005800eae483");
                            String response =NetworkUtils.getResponseFromURL(url);
                            JSONParser.parseJson(response);


                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
        }
            }

