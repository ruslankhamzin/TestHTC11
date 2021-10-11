package ru.startandroid.develop.testhtc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
    public static void parseJson(String json) throws JSONException {
        JSONObject jsonObject1 = new JSONObject(json);
        JSONObject jsonObject =jsonObject1.getJSONObject("company");
        String companyname = jsonObject.getString("name");
        String companyage = jsonObject.getString("age");
        JSONArray compArray = jsonObject.getJSONArray("competences");
        String companycompetences = compArray.toString();
        Company.company.add(new Company("company name: "+companyname,"age"+companyage,"Competences: "+companycompetences));
        JSONArray employees1 = jsonObject.getJSONArray("employees");
        for (int i = 0; i < employees1.length(); i++) {
            Employees employee = new Employees();
            JSONObject employees1JSONObject = employees1.getJSONObject(i);
            try {
                String name = employees1JSONObject.getString("name");
                employee.setName("name:"+name);
            }
            catch (JSONException e){
                employee.setName("name: -");
            }
            try{
            String phone_number = employees1JSONObject.getString("phone_number");
            employee.setPhone_number("phone number: "+phone_number);
            }
            catch (JSONException e){
                employee.setPhone_number("phone number: -");
            }
            try {


                JSONArray skillsArray = employees1JSONObject.getJSONArray("skills");
                String skills = skillsArray.toString();
                employee.setSkills("skills: "+skills);
            }
            catch (JSONException e){
                employee.setSkills("skills: -");
            }
            EmployeesRepository.employees.add(employee);
        }

    }
}
