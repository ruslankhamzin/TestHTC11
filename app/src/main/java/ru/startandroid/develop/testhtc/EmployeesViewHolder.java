package ru.startandroid.develop.testhtc;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeesViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTV,numberTV,skillsTV;
    public EmployeesViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTV=itemView.findViewById(R.id.nameTV);
        numberTV=itemView.findViewById(R.id.numberTV);
        skillsTV=itemView.findViewById(R.id.skillsTV);
    }
    public void bind(Employees employee){
        nameTV.setText("name: "+employee.name);
        numberTV.setText("phone number: "+employee.phone_number);
        skillsTV.setText("skills: "+employee.skills.toString());
    }
}
