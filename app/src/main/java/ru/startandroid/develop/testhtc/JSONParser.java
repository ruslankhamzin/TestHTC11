package ru.startandroid.develop.testhtc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
    public static void parseJson(String json) throws JSONException {
        JSONObject jsonObject1 = new JSONObject(json);
        JSONObject jsonObject = jsonObject1.getJSONObject("company");
        String companyname = jsonObject.getString("name");
        String companyage = jsonObject.getString("age");
        JSONArray compArray = jsonObject.getJSONArray("competences");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < compArray.length(); i++) {
            if (i == compArray.length() - 1) {
                sb.append(compArray.get(i));
            } else {
                sb.append(compArray.get(i)).append(", ");
            }

        }

        String companycompetences = sb.toString();
        Company.company.add(new Company(companyname, companyage, companycompetences));
        JSONArray employees1 = jsonObject.getJSONArray("employees");
        for (int i = 0; i < employees1.length(); i++) {
            Employees employee = new Employees();
            JSONObject employees1JSONObject = employees1.getJSONObject(i);
            try {
                String name = employees1JSONObject.getString("name");
                employee.setName(name);
            } catch (JSONException e) {
                employee.setName("unknown name");
            }
            try {
                String phone_number = employees1JSONObject.getString("phone_number");
                employee.setPhone_number(phone_number);
            } catch (JSONException e) {
                employee.setPhone_number("-");
            }
            try {

                JSONArray skillsArray = employees1JSONObject.getJSONArray("skills");
                sb.delete(0, sb.length());
                for (int j = 0; j < skillsArray.length(); j++) {
                    if (j == skillsArray.length() - 1) {
                        sb.append(skillsArray.get(j));
                    } else {
                        sb.append(skillsArray.get(j)).append(", ");
                    }
                }
                String skills = sb.toString();
                employee.setSkills(skills);
                sb.delete(0, sb.length());


            } catch (JSONException e) {
                employee.setSkills("-");
            }
            EmployeesRepository.employees.add(employee);
        }

    }
}
