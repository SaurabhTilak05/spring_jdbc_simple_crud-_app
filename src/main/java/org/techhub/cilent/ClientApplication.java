package org.techhub.cilent;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.techhub.config.config;
import org.techhub.model.Employee;
import org.techhub.service.EmpServiseImp;


public class ClientApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(config.class);
		EmpServiseImp empService =(EmpServiseImp)context.getBean("empService");

		if (empService != null) {
			Scanner s = new Scanner(System.in);
			do {
				System.out.println("1: Add Employee ");
				System.out.println("2: View Employees ");
				System.out.println("3: Delete Employee  ");
				System.out.println("4: Update Employee ");
				System.out.println("5: Exist ");
				System.out.println("Enter Your choise ");
				int choise = s.nextInt();
				switch (choise) {
				case 1:
					s.nextLine();
					System.out.println("Enter  name email and contact");
					String name = s.nextLine();
					String email = s.nextLine();
					String contact = s.nextLine();
					Employee emp = new Employee();
					emp.setName(name);
					emp.setEmail(email);
					emp.setContact(contact);
					boolean b = empService.isSave(emp);
					if (b) {
						System.out.println("Record save");
					} else {
						System.out.println("Some problem is there....");
					}
					break;
				case 2:
					List<Employee> list=empService.getAllEmployees();
						for(Employee e:list)
						{
							System.out.println(e.getName()+"\t"+e.getEmail()+"\t"+e.getContact());
						}
					break;
				case 3:
					s.nextLine();
					System.out.println("Enter email for delete employee");
					 email=s.nextLine();
					 b=empService.isDelete(email);
					 if(b)
					 {
						 System.out.println("Record delete successfully .....");
					 }
					 else {
						 System.out.println("Record not deleted... ");
					 }
					break;
				case 4:
					System.out.println("Enter  name email and contact");
					s.nextLine();
					name = s.nextLine();
					email = s.nextLine();
					contact = s.nextLine();
					emp = new Employee();
					emp.setName(name);
					emp.setEmail(email);
					emp.setContact(contact);
					
					b=empService.isUpdate(emp);
					if(b)
					{
						System.out.println("Record update successfully......");
					}
					
					else {
						System.out.println("Record not update......");
					}
					
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choise ");
					break;
				}

			} while (true);
		} else {
			System.out.println("Database not connect.........");
		}
	}
}
