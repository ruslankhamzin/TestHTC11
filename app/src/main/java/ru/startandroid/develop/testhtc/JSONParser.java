package ru.startandroid.develop.testhtc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {
    public static List<Employees> parseJson(String json) throws IOException, JSONException {

        List<Employees> employees = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray employees1 = jsonObject.getJSONArray("employees");
        for (int i = 0; i < employees1.length(); i++) {
            JSONObject employee = employees1.getJSONObject(i);
            String name = employee.getString("name");
            String phone_number = employee.getString("phone_number");
            JSONArray skills = employee.getJSONArray("skills");
            EmployeesRepository.employees.add(new Employees(name, phone_number, "12341"));
        }
        return employees;

    }
}
