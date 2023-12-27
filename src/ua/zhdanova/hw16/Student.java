package ua.zhdanova.hw16;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
class Student {
    public static void main(String[] args) {
        Student student = new Student("John", "Doe", 20, 90);
    }
    @ShowInfo
    private String firstName;
    @ShowInfo
    private String lastName;
    @ShowInfo
    private int age;
    @ShowInfo(show = false)
    private int examScore;
    public Student(String firstName, String lastName, int age, int examScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.examScore = examScore;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public int getExamScore() {
        return examScore;
    }
    private void passExamSuccessfully() {
        this.examScore = 100;
    }
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface ShowInfo {
    boolean show() default true;
}
class StudentInfoPrinter {
    public void printStudentInfo(Student student) {
        Class<?> studentClass = student.getClass();
        Field[] fields = studentClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ShowInfo.class)) {
                ShowInfo annotation = field.getAnnotation(ShowInfo.class);
                if (annotation.show()) {
                    String fieldName = field.getName();
                    try {
                        String getterMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                        Method getterMethod = studentClass.getMethod(getterMethodName);
                        Object value = getterMethod.invoke(student);
                        System.out.println(fieldName + ": " + value);
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
