package com.iverson.java8;

/**
 * @program: lambda
 * @author: ouguoxin
 * @create: 2020-11-13 15:57
 **/

public class FilterEmployeeForSalary implements MyPredicate<Employee>{


    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}

