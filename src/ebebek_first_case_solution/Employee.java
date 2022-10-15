package ebebek_first_case_solution;

import java.time.Year;

public class Employee {
	private String _name;
	private int _salary;
	private int _workHours;
	private Year _hireYear;
	
	public Employee(String name,int salary,int workHours,Year hireYear)
	{
		_name = name;
		_salary = salary;
		_workHours = workHours;
		_hireYear = hireYear;
	}
	
	public Employee(String name,int salary,int workHours,int hireYear)
	{
		_name = name;
		_salary = salary;
		_workHours = workHours;
		_hireYear = Year.of(hireYear);
	}
	
	//! If Employee is newly hired
	public Employee(String name,int salary,int workHours)
	{
		_name = name;
		_salary = salary;
		_workHours = workHours;
		_hireYear = Year.now();
	}
	
	//! Calculating tax , getTax
	public int tax()
	{
		return _salary < 1000 ? 0 : (_salary * 3)/100;
	}
	
	//! Calculating bonus, getBonus
	public int bonus()
	{
		return _workHours > 40 ? ((_workHours-40) << 1) * 15 : 0;
	}
	
	//! Raise salary by gap between now and hired year
	public void raiseSalary()
	{
		Year diff = Year.now().minusYears(_hireYear.getValue());
		
		int diffY = diff.getValue();
		
		if(diffY < 10)
		{
			_salary += (_salary >> 1) /10;
			
		}
		else if(diffY >= 10 && diffY < 20)
		{
			_salary += (_salary)/10;
		}
		else
		{
			_salary += (_salary >> 1)* 3/10;
		}
		
	}
	
	public String toString()
	{
		
		int tax = tax();
		int bonus = bonus();
		
		
		return String.format("Name : %s\nSalary : %d\nWork Hours : %d\nHire Year : "
				+ "%d\nTax : %d\nBonus : %d\nReal Salary : %d",_name,_salary,_workHours,_hireYear.getValue(),tax,bonus,(_salary + bonus - tax));
	}
	
	
	
	
	
}
