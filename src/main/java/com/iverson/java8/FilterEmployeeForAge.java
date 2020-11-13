package com.iverson.java8;

/**
 * @program: lambda
 * @author: ouguoxin
 * @create: 2020-11-13 15:57
 **/

public class FilterEmployeeForAge implements MyPredicate<Employee>{

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() <= 35;
    }
}

