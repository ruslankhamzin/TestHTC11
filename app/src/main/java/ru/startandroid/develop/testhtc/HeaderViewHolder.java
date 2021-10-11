package ru.startandroid.develop.testhtc;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HeaderViewHolder extends RecyclerView.ViewHolder {
    private TextView name,age,competences,employees;
    public HeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.companyTV);
        age = (TextView) itemView.findViewById(R.id.ageTV);
        competences=(TextView) itemView.findViewById(R.id.competencesTV);
        employees=(TextView) itemView.findViewById(R.id.employeesTv);
        Company company= Company.company.get(0);

        name.setText("Company name: "+company.getName());
        age.setText("Age: "+company.getAge());
        competences.setText("Competences: "+company.getCompetences());
        employees.setText("Employees: ");
    }

}
