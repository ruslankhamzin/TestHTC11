package ru.startandroid.develop.testhtc;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class EmployeesRepository {
    public static List<Employees> employees = new ArrayList<>();
    private static EmployeesRepository instance;


    //private EmployeesRepository( ) throws IOException, JSONException {

      //  }

        //Gson g = new Gson();
        //Employees[] employeesArray = g.fromJson(JSONParser.parseJson(),Employees[].class);
        //employees.addAll(Arrays.asList(employeesArray));

     //  }
    public static EmployeesRepository getInstance() throws IOException, JSONException {
        if (instance==null){
            instance=new EmployeesRepository();
        }
        return instance;
    }
    public List<Employees> getEmployees(){return employees;}
}
