package ru.startandroid.develop.testhtc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ru.startandroid.develop.testhtc.utils.NetworkUtils;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView textView;
    static String s;


    private List<Employees> employees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            employees.addAll(EmployeesRepository.getInstance().getEmployees());
        } catch (IOException | JSONException | InterruptedException e) {
            e.printStackTrace();
        }
        textView = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new EmployeesAdapter(LayoutInflater.from(this), employees));

    }
}
