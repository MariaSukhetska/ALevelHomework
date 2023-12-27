package ua.zhdanova.hw16;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student student = new Student("John", "Doe", 20, 90);
        //student.firstName = "John";
        //student.lastName = "Doe";
        //student.age = 20;
        StudentInfoPrinter printer = new StudentInfoPrinter();
        printer.printStudentInfo(student);
        try {

            Method passExamMethod = Student.class.getDeclaredMethod("passExamSuccessfully");
            passExamMethod.setAccessible(true);
            passExamMethod.invoke(student);

            Field examScoreField = Student.class.getDeclaredField("examScore");
            examScoreField.setAccessible(true);
            System.out.println("Updated Exam Score: " + examScoreField.get(student));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}