package ru.startandroid.develop.testhtc;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.startandroid.develop.testhtc.models.Employees;

public class EmployeesViewHolder extends RecyclerView.ViewHolder {
    private final TextView nameTV;
    private final TextView numberTV;
    private final TextView skillsTV;

    public EmployeesViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTV = itemView.findViewById(R.id.nameTV);
        numberTV = itemView.findViewById(R.id.numberTV);
        skillsTV = itemView.findViewById(R.id.skillsTV);
    }

    @SuppressLint("SetTextI18n")
    public void bind(Employees employee) {
        nameTV.setText("name: " + employee.name);
        numberTV.setText("phone number: " + employee.phone_number);
        skillsTV.setText("skills: " + employee.skills);
    }
}
