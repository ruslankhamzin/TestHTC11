package ru.startandroid.develop.testhtc;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeesAdapter extends RecyclerView.Adapter {
    private final LayoutInflater inflater;
    private final List<Employees> employees;
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_RECYCLER = 1;

    public EmployeesAdapter(LayoutInflater inflater, List<Employees> employees) {
        this.inflater = inflater;
        this.employees = employees;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_HEADER) {
            return new HeaderViewHolder(inflater.inflate(R.layout.header_employees, parent, false));
        } else {
            return new EmployeesViewHolder(inflater.inflate(R.layout.employees_list, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof EmployeesViewHolder) {
            ((EmployeesViewHolder) holder).bind(employees.get(position - 1));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_HEADER;

        } else return VIEW_TYPE_RECYCLER;
    }

    @Override
    public int getItemCount() {
        return employees.size() + 1;
    }
}
