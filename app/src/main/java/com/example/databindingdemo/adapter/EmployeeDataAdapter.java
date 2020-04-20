package com.example.databindingdemo.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databindingdemo.R;
import com.example.databindingdemo.databinding.RowEmployeeBinding;
import com.example.databindingdemo.model.Employee;


import java.util.ArrayList;

public class EmployeeDataAdapter
    extends RecyclerView.Adapter<EmployeeDataAdapter.EmployeeViewHolder> {

  private ArrayList<Employee> employees;

  @NonNull
  @Override
  public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    RowEmployeeBinding employeeListItemBinding =
        DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
            R.layout.row_employee, viewGroup, false);
    return new EmployeeViewHolder(employeeListItemBinding);
  }

  @Override
  public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder, int i) {
    Employee currentStudent = employees.get(i);
    employeeViewHolder.employeeListItemBinding.setEmployee(currentStudent);
  }

  @Override
  public int getItemCount() {
    if (employees != null) {
      return employees.size();
    } else {
      return 0;
    }
  }

  public void setEmployeeList(ArrayList<Employee> employees) {
    this.employees = employees;
    notifyDataSetChanged();
  }

  class EmployeeViewHolder extends RecyclerView.ViewHolder {

    /* this will be auto generated as your layout name*/
    private RowEmployeeBinding employeeListItemBinding;

    public EmployeeViewHolder(@NonNull RowEmployeeBinding employeetListItemBinding) {
      super(employeetListItemBinding.getRoot());

      this.employeeListItemBinding = employeetListItemBinding;
    }
  }
}