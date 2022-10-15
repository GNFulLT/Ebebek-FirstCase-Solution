package ebebek_first_case_solution;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Employee emp = new Employee("Ahmet",2000,36,2020);
		emp.raiseSalary();
		String str = emp.toString();
		System.out.println(str);
	}
}
