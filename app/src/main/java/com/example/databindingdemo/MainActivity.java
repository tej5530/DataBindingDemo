package com.example.databindingdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.databindingdemo.adapter.EmployeeDataAdapter;
import com.example.databindingdemo.databinding.ActivityMainBinding;
import com.example.databindingdemo.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private EmployeeDataAdapter employeeDataAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        initialization(activityMainBinding);
        bindData();
    }

    private void bindData() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        employeeDataAdapter = new EmployeeDataAdapter();
        recyclerView.setAdapter(employeeDataAdapter);
        getAllEmployee();
    }

    private void initialization(ActivityMainBinding activityMainBinding) {
        recyclerView = activityMainBinding.viewEmployees;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private void getAllEmployee() {
        mainViewModel.getAllEmployee().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable List<Employee> employees) {
                employeeDataAdapter.setEmployeeList((ArrayList<Employee>) employees);
            }
        });
    }
}
