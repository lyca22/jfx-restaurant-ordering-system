package model;

import java.util.Comparator;

public class EmployeeSurnameAndNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		int comparation=0;
		String employee1=e1.getSurname();
		String employee2=e2.getSurname();
		String nameEmployee1=e1.getName();
		String nameEmployee2=e2.getName();
		if(employee1.compareTo(employee2)<0){
			comparation=1;
		}else if(employee1.compareTo(employee2)>0){
			comparation=-1;
		}else{
			comparation= nameEmployee2.compareTo(nameEmployee1);
		}
		return comparation;
	}

}
