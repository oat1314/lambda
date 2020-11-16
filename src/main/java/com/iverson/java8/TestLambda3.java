package com.iverson.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @program: lambda
 * @author: ouguoxin
 * @create: 2020-11-13 18:05
 **/

/*
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 *
 * Supplier<T> : 供给型接口
 * 		T get();
 *
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 *
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 *
 */

public class TestLambda3 {

    @Test
    public void test1() {
        happy(10000,(m) -> System.out.println("出去快乐消费" + m + "元"));
    }

    public void happy(double money, Consumer<Double> consumer) {consumer.accept(money);}

    @Test
    public void test2() {
        List<Integer> numList = getNumList(10,() -> (int)(Math.random()*100));

        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    private List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0 ; i < num ; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    @Test
    public void test3() {
        String newStr = strHandler("\t\t\t 我很快乐" ,(str) -> str.trim());
        System.out.println(newStr);

        String subStr = strHandler("非常快乐!!!",(str)->str.substring(2,5));
        System.out.println(subStr);
    }

    public String strHandler(String str, Function<String, String> fun) {return fun.apply(str);}

    @Test
    public void test4(){
        List<String> list = Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);

        for (String str : strList) {
            System.out.println(str);
        }
    }

    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();

        for (String str : list) {
            if(pre.test(str)){
                strList.add(str);
            }
        }

        return strList;
    }
}

