package com.enigma;

import com.enigma.dao.StudentDao;
import com.enigma.dao.StudentDaoImpl;
import com.enigma.service.MajorService;
import com.enigma.service.StudentService;
import com.enigma.service.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    static Scanner scanner = new Scanner(System.in);
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    static MajorService majorService = applicationContext.getBean("majorService", MajorService.class);
    static StudentService studentService =applicationContext.getBean("studentService", StudentService.class);

    public static void main(String[] args) throws IOException, ParseException {
    mainMenu();
    }
    public static void mainMenu() throws IOException, ParseException {

        System.out.println("\tMenu");
        System.out.println("1. Major");
        System.out.println("2. Student");

        System.out.print("input : ");
        Integer num = scanner.nextInt();

        if (num == 1){
            menuMajor();
        } else if(num == 2){
            menuStudent();
        } else {
            System.out.println("choose number 1 or 2");
            mainMenu();
        }
    }

    public static void menuMajor() throws IOException, ParseException {
        System.out.println("Major Menu");
        System.out.println("1. Save Major");
        System.out.println("2. Get Major by ID");
        System.out.println("3. Get All Major");
        System.out.println("4. Back");

        System.out.print("input : ");
        Integer number = scanner.nextInt();

        if(number == 1 ){
            System.out.print("major : " );
            String name = bufferedReader.readLine();
            Major major = new Major();
            major.setName(name);

            majorService.saveMajor(major);
            menuMajor();
        } else if(number==2){
            System.out.print("id : ");
          Integer id = scanner.nextInt();

            System.out.println(majorService.getMajorByID(id));
          menuMajor();
        }
        else if(number == 3){

        for(Major majors : majorService.getAllMajor()) {
           System.out.println(majors);
            }
        menuMajor();
        } else {
            mainMenu();
        }
    }
    public static void menuStudent() throws IOException, ParseException {
        System.out.println("Student Menu");
        System.out.println("1. Save Student");
        System.out.println("2. Get Student by ID");
        System.out.println("3. Get All Student");
        System.out.println("4. The number of Student");
        System.out.println("5. Update Student");
        System.out.println("6. Delete Student");
        System.out.println("7. Back");

        System.out.println("input : ");
        Integer number = scanner.nextInt();

        if(number==1){
            Student student = new Student();
            System.out.print("name : ");
            String name = bufferedReader.readLine();
            System.out.print("address : ");
            String address = bufferedReader.readLine();
            System.out.print("phone : ");
            String phone = bufferedReader.readLine();
            System.out.print("birthDate : ");
            String birth = bufferedReader.readLine();
            System.out.print("Major id : ");
            Integer major = scanner.nextInt();

            String[] born = birth.split("-");
            Integer year = Integer.parseInt(born[0]);
            Integer month = Integer.parseInt(born[1]);
            Integer date = Integer.parseInt(born[2]);
            LocalDate localDate = LocalDate.of(year, month, date);

            student.setName(name);
            student.setAddress(address);
            student.setPhoneNumber(phone);
            student.setBirthDate(localDate);
            student.setMajor(majorService.getMajorByID(major));
            studentService.saveStudent(student);
            menuStudent();

        } else if(number==2){
            System.out.print("input id : ");
            Integer id = scanner.nextInt();

            System.out.println(studentService.getStudentById(id));
            menuStudent();
        } else if (number==3){
            for (Student student : studentService.getAllStudent()){
                System.out.println(student);
            }
            menuStudent();
        } else if(number==4){
            System.out.println(studentService.countAllStudent());
            menuStudent();
        } else if(number == 5){
            System.out.println("input id : ");
            Integer id = scanner.nextInt();
            System.out.println("input new name");
            String name = bufferedReader.readLine();

            Student student = studentService.getStudentById(id);
            student.setName(name);
            studentService.updateStudent(student);

            menuStudent();
        } else if(number ==6){
            System.out.println("input id : ");
            Integer id = scanner.nextInt();

            Student student = studentService.getStudentById(id);
            studentService.deleteStudent(student);

            menuStudent();
        } else {
            mainMenu();
        }
    }
}
