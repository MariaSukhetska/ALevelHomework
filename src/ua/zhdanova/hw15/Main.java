package ua.zhdanova.hw15;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\HomeworkALevel\\Homework_3\\src\\ua\\zhdanova\\hw15\\Text");
        List<User> userList = readUsersFromFile(file);
        //printUserNames(userList);
        sortUsers(userList);
        printUsersWithMinSalary(userList);
        printAllUsersWithMinSalary(userList);
        printTotalSalary(userList);
        printSalaryDifferenceBetweenYoungestAndOldest(userList);
        printFullNameOfUsersWithA(userList);
    }

    private static List<User> readUsersFromFile(File file) throws FileNotFoundException {
        List<User> userList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String name = scanner.nextLine().split(":")[1].trim().replace("\"", "");
                String secondName = scanner.nextLine().split(":")[1].trim().replace("\"", "");

                int age = Integer.parseInt(scanner.nextLine().split(":")[1].replace("\"", "").trim());
                int salary = Integer.parseInt(scanner.nextLine().split(":")[1].replace("\"", "").trim());

                User user = new User(name, secondName, age, salary);
                userList.add(user);

                if (scanner.hasNext()) {
                    scanner.nextLine();
                }
            }
        } catch (FileNotFoundException o) {
            o.printStackTrace();
        }
        return userList;
    }

    private static void printUserNames(List<User> userList) {
        System.out.println("Full Names of Employees with Names Starting with 'A':");
        userList.stream()
                .forEach(user -> System.out.println(user.getName() + " " + user.getSecondName()));
    }

    private static void sortUsers(List<User> userList) {
        Comparator<User> firstNameComparator = Comparator.comparing(User::getName);
        userList.stream()
                .sorted(firstNameComparator)
                .forEach(user -> System.out.println(user.getName() + " " + user.getSecondName()));
    }

    private static void printUsersWithMinSalary(List<User> userList) {
        int minSalary = userList.stream()
                .map(User::getSalary)
                .min(Integer::compareTo)
                .orElseThrow();

        System.out.println("Minimum Salary: " + minSalary);
        System.out.println("User with Minimum Salary:");
        userList.stream()
                .filter(user -> user.getSalary() == minSalary)
                .forEach(user -> System.out.println(user.getName() + " " + user.getSecondName()));
    }

    private static void printAllUsersWithMinSalary(List<User> userList) {
        int minSalary = userList.stream()
                .map(User::getSalary)
                .min(Integer::compareTo)
                .orElseThrow();

        System.out.println("Minimum Salary: " + minSalary);
        System.out.println("All Users with Minimum Salary:");
        userList.stream()
                .filter(user -> user.getSalary() == minSalary)
                .forEach(user -> System.out.println(user.getName() + " " + user.getSecondName()));
    }

    private static void printTotalSalary(List<User> userList) {
        int totalSalary = userList.stream()
                .mapToInt(User::getSalary)
                .sum();

        System.out.println("Total Salary of all Users: " + totalSalary);
    }

    private static void printSalaryDifferenceBetweenYoungestAndOldest(List<User> userList) {
        int youngestAge = userList.stream()
                .mapToInt(User::getAge)
                .min()
                .orElseThrow();

        int oldestAge = userList.stream()
                .mapToInt(User::getAge)
                .max()
                .orElseThrow();

        int youngestSalary = userList.stream()
                .filter(user -> user.getAge() == youngestAge)
                .mapToInt(User::getSalary)
                .findFirst()
                .orElseThrow();

        int oldestSalary = userList.stream()
                .filter(user -> user.getAge() == oldestAge)
                .mapToInt(User::getSalary)
                .findFirst()
                .orElseThrow();

        int salaryDifference = oldestSalary - youngestSalary;

        System.out.println("Salary Difference between Youngest and Oldest User: " + salaryDifference);
    }

    private static void printFullNameOfUsersWithA(List<User> userList) {
        System.out.println("Full Names of Employees with Names Starting with 'A':");

        userList.stream()
                .filter(user -> user.getName().startsWith("A"))
                .forEach(user -> System.out.println(user.getName() + " " + user.getSecondName()));
    }
}