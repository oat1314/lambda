package com.iverson.java8;

import com.iverson.exer.MyFun;
import com.iverson.exer.MyInterface;

public class SubClass /*extends MyClass*/ implements MyFun, MyInterface {

	@Override
	public String getName() {
		return MyInterface.super.getName();
	}

}
