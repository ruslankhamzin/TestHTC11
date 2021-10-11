package ru.startandroid.develop.testhtc;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.startandroid.develop.testhtc.models.Company;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    @SuppressLint("SetTextI18n")
    public HeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        TextView name = itemView.findViewById(R.id.companyTV);
        TextView age = itemView.findViewById(R.id.ageTV);
        TextView competences = itemView.findViewById(R.id.competencesTV);
        TextView employees = itemView.findViewById(R.id.employeesTv);
        Company company = Company.company.get(0);
        name.setText("Company name: " + company.getName());
        age.setText("Age: " + company.getAge());
        competences.setText("Competences: " + company.getCompetences());
        employees.setText("Employees: ");
    }

}
