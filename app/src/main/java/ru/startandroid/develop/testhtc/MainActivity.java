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
    URL url;

    {
        try {
            url = new URL("http://www.mocky.io/v2/5ddcd3673400005800eae483");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private List<Employees> employees=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new MockyQueryTask().execute(url);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            employees.addAll(EmployeesRepository.getInstance().getEmployees());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        textView = findViewById(R.id.button);
        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new EmployeesAdapter(LayoutInflater.from(this),employees));

    }
   public class MockyQueryTask extends AsyncTask<URL,Void,String>{

        @Override
        protected String doInBackground(URL... urls) {
            String response=null;
            try {
                response= NetworkUtils.getResponseFromURL(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;

        }

       @Override
       protected void onPostExecute(String s) {
            String first=null;
           try {
               JSONObject jsonObject = new JSONObject(s);
               JSONObject object = jsonObject.getJSONObject("company");
              JSONArray array = object.getJSONArray("employees");
              JSONObject object1 = array.getJSONObject(0);
                first = object1.getString("name");



           } catch (JSONException e) {
               e.printStackTrace();
           }

           try {
               JSONParser.parseJson(s);
           } catch (IOException | JSONException e) {
               e.printStackTrace();
           }
           textView.setText(first);
       }
   }
}
