package com.example.databindingdemo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.databindingdemo.model.Employee;
import com.example.databindingdemo.model.EmployeeRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
  private EmployeeRepository employeeRepository;

  public MainViewModel(@NonNull Application application) {
    super(application);
    employeeRepository = new EmployeeRepository();
  }

  public LiveData<List<Employee>> getAllEmployee() {
    return employeeRepository.getMutableLiveData();
  }
}