package ru.startandroid.develop.testhtc;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HeaderViewHolder extends RecyclerView.ViewHolder {
    private TextView name,age,competences;
    public HeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.companyTV);
        age = (TextView) itemView.findViewById(R.id.ageTV);
        competences=(TextView) itemView.findViewById(R.id.competencesTV);
        Company company= Company.company.get(0);

        name.setText(company.getName());
        age.setText(company.getAge());
        competences.setText(company.getCompetences());
    }

}
