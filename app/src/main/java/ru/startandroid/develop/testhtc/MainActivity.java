package ru.startandroid.develop.testhtc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.startandroid.develop.testhtc.Adapter.EmployeesAdapter;
import ru.startandroid.develop.testhtc.models.Employees;
import ru.startandroid.develop.testhtc.repository.EmployeesRepository;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView textView;



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
