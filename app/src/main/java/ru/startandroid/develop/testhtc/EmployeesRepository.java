package ru.startandroid.develop.testhtc;


import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.startandroid.develop.testhtc.utils.NetworkUtils;

public class EmployeesRepository {
    public static List<Employees> employees = new ArrayList<>();
    private static EmployeesRepository instance;


    private EmployeesRepository() throws IOException, JSONException, InterruptedException {
        NetThread thread = new NetThread();
        thread.start();
        thread.join();
        Collections.sort(employees, (o1, o2) -> o1.getName().compareTo(o2.getName()));


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

class NetThread extends Thread {
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

