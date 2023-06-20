package com.lab;

import com.lab.data.domain.Department;
import com.lab.data.domain.Employee;
import com.lab.service.api.CompanyService;
import com.lab.tool.EntityParser;
import com.lab.ui.ConsoleReaderWriter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class Main {
    private final ConsoleReaderWriter console = new ConsoleReaderWriter();
    private final EntityParser<Employee> employeeEntityParser = new EntityParser<>();

    private final EntityParser<Department> departmentEntityParser = new EntityParser<>();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(CompanyService companyService) {
        return (args) -> {
            boolean programIsRunning = true;
            while (programIsRunning) {
                String command = console.read("Enter command:");
                String[] input = command.trim().split(" ");

                Object result = switch (input[0].toLowerCase()) {
                    case "add" -> {
                        if ("employee".equalsIgnoreCase(input[1]) || "e".equalsIgnoreCase(input[1]))
                            yield companyService.addEmployee(
                                        employeeEntityParser.parse(input[2], Employee.class)
                            );
                        else if ("department".equalsIgnoreCase(input[1]) || "d".equalsIgnoreCase(input[1]))
                            yield companyService.addDepartment(
                                         departmentEntityParser.parse(input[2], Department.class)
                            );

                        yield null;
                    }
                    case "remove" -> {
                        if ("employee".equalsIgnoreCase(input[1]) || "e".equalsIgnoreCase(input[1]))
                            yield companyService.removeEmployee(
                                    employeeEntityParser.parse(input[2], Employee.class)
                            );
                        else if ("department".equalsIgnoreCase(input[1]) || "d".equalsIgnoreCase(input[1]))
                            yield companyService.removeDepartment(
                                    departmentEntityParser.parse(input[2], Department.class)
                            );

                        yield null;
                    }
                    case "find" -> {
                        if ("employee".equalsIgnoreCase(input[1]) || "e".equalsIgnoreCase(input[1]))
                            yield companyService.findEmployee(
                                    employeeEntityParser.parse(input[2], Employee.class)
                            );
                        else if ("department".equalsIgnoreCase(input[1]) || "d".equalsIgnoreCase(input[1]))
                            yield companyService.findDepartment(
                                    departmentEntityParser.parse(input[2], Department.class)
                            );

                        yield null;
                    }
                    case "quit" -> {
                        programIsRunning = false;
                        yield Optional.empty();
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + input[0].toLowerCase());
                };
                console.write(result == null ? "" : result.toString());
            }
        };
    }
}
