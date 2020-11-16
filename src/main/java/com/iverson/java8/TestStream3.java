package com.iverson.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: lambda
 * @author: ouguoxin
 * @create: 2020-11-16 18:16
 **/

public class TestStream3 {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Employee.Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY)
    );
    //3. 终止操作
	/*
		归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Integer sum = list.stream()
                .reduce(0,(x,y)->x+y);

        System.out.println(sum);

        System.out.println("--------------");

        Optional<Double> op = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        System.out.println(op.get());
    }

    //collect--将流转换为其他形式,接收一个Collector接口的实现,用于给Stream中元素做汇总的方法
    @Test
    public void test3() {
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        list.forEach(System.out::println);

        System.out.println("----------------------");

        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());

        set.forEach(System.out::println);

        System.out.println("---------------------");

        HashSet<String> hashSet = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        hashSet.forEach(System.out::println);
    }

    @Test
    public void test4() {
        Optional<Double> max = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.maxBy(Double::compare));

        System.out.println(max.get());

        Optional<Employee> op = emps.stream()
                .collect(Collectors.minBy((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary())));
        System.out.println(op.get());

        System.out.println("-----------------");

        Double sum = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        System.out.println("-----------------");

        Double avg = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        System.out.println("-----------------");

        Long count = emps.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        System.out.println("-----------------");

        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
    }

    //分组
    @Test
    public void test5() {
        Map<Employee.Status,List<Employee>> map =emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));

        System.out.println(map);
    }

    //多级分组
    @Test
    public void  test6() {
        Map<Employee.Status,Map<String,List<Employee>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,Collectors.groupingBy((e)->{
                    if (e.getAge() >= 60) {
                        return "老年";}
                    else if (e.getAge() >= 35) {
                        return "中年";}
                    else {
                        return "成年";}
                })));
        System.out.println(map);
    }
}
