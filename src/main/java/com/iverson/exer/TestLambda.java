package com.iverson.exer;

import com.iverson.java8.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: lambda
 * @author: ouguoxin
 * @create: 2020-11-13 15:37
 **/

public class TestLambda {

    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test1() {
        Collections.sort(emps,(e1,e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for (Employee emp: emps
             ) {
            System.out.println(emp);
        }
    }

    @Test
    public void test2() {
        String trimStr = strHandler("\t\t\t 一路上有你",(str -> str.trim()));
        System.out.println(trimStr);

        String upper = strHandler("abcdef",(str -> str.toUpperCase()));
        System.out.println(upper);

        String newStr = strHandler("一二三四五",(str -> str.substring(2,5)));
        System.out.println(newStr);
    }

    public String strHandler(String str,MyFunction mf) {return mf.getValue(str);}

    @Test
    public void test3(){
        op(100L,200L,(x,y)-> x+y);

        op(100L,200L,(x,y)-> x*y);
    }

    public void op(Long l1,Long l2,MyFunction2<Long,Long > mf) {
        System.out.println(mf.getValue(l1,l2));
    }


}

