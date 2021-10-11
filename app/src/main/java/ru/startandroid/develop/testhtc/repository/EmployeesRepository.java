package ru.startandroid.develop.testhtc.repository;


import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.startandroid.develop.testhtc.models.Employees;
import ru.startandroid.develop.testhtc.utils.NetThread;

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

