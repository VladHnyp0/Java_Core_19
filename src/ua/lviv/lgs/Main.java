package ua.lviv.lgs;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File fileEmployee = new File("Employee.obj");
        Employee employee = new Employee(16, "Влад", 77777);
        System.out.println("Працівник:");
        System.out.println(employee);

        System.out.println("Працівник післе серіалізації/десеріалізації:");
        Methods.serialize(employee, fileEmployee);
        System.out.println(Methods.deserealize(fileEmployee));

        System.out.println();

        File fileEmployeeList = new File("EmployeeList.obj");
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(employee);
        employeeList.add(new Employee(73, "Катя", 8900));
        employeeList.add(new Employee(15, "Рома", 8600));
        employeeList.add(new Employee(64, "Денис", 10000));
        employeeList.add(new Employee(88, "Уляна", 28000));
        employeeList.add(new Employee(1, "Діма", 12345));

        System.out.println("Список Працівників:");
        for (Employee eachEmployee : employeeList) {
            System.out.println(eachEmployee);
        }

        System.out.println();

        System.out.println("Список Працівників післе серіалізації/десеріалізації:");
        Methods.serialize((Serializable) employeeList, fileEmployeeList);

        List<Employee> employeeListDeserialized = new ArrayList<Employee>();
        employeeListDeserialized = (List<Employee>) Methods.deserealize(fileEmployeeList);

        for (Employee eachEmployee : employeeListDeserialized) {
            System.out.println(eachEmployee);
        }

    }

}