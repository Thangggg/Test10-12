package Controller;

import Comparato.SortPointDown;
import Comparato.SortPontUp;
import Io.ReadAndWrite;
import Model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {
    List<Student> studentList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    ReadAndWrite readAndWrite = new ReadAndWrite();
    public  Controller(){
        studentList = readAndWrite.readFile("student.txt");
    }

    public List<Student> getList(){
        studentList = readAndWrite.readFile("student.txt");
        return studentList;
    }

    public String creatName() {
        String name;
        while (true) {
            System.out.println("Nhập Tên");
            name = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\"+\n" +
                    "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\"+\n" +
                    "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$");
            if (pattern.matcher(name).find()) {
                break;
            } else {
                System.err.println("Tên phải là chữ và viết hoa chữ cái đầu");
            }
        }
        return name;
    }

    public int creatAge() {
        int age = 0;
        boolean check = true;
        while (check) {
            try {
                System.out.println("Nhập Tuổi");
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 6 && age <= 65) {
                    check = false;
                } else if (age < 6) {
                    System.out.println("Bạn chưa đủ tuổi");
                } else {
                    System.out.println("Bạn quá già rồi");
                }

            } catch (Exception e) {
                System.err.println("Tuổi phải là số lớn hơn 6 và nhỏ hơn 65");
            }
        }
        return age;
    }

    public String creatAddress() {
        String address;
        while (true) {
            System.out.println("Nhập Địa chỉ");
            address = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[A-Za-z0-9]{3,}+$");
            if (pattern.matcher(address).find()) {
                break;
            } else {
                System.err.println("Địa chỉ phải là chữ hoặc số và có ít nhất 3 kí tự");
            }
        }
        return address;
    }

    public int creatPoint() {
        int point = 0;
        while (true) {
            try {
                System.out.println("Nhập Điểm");
                point = Integer.parseInt(scanner.nextLine());
                return point;
            } catch (Exception e) {
                System.err.println("Điểm là số");
            }
        }

    }

    public int creatID() {
        int id = 0;
        while (true) {
            try {
                System.out.println("Nhập ID");
                id = Integer.parseInt(scanner.nextLine());
                return id;
            } catch (Exception e) {
                System.err.println("ID là số");
            }
        }

    }



    public Student creatStudent(){
        return new Student(creatID(),creatName(),creatAge(),creatSex(),creatAddress(),creatPoint());
    }

    public void add(){
        Student student = creatStudent();
        if (studentList.size() > 0 && student.getId() <= studentList.get(studentList.size() - 1).getId()) {
            student.setId(studentList.get(studentList.size() - 1).getId() + 1);
        }
        studentList.add(student);
    }

    public void show(){
        for (Student student: studentList) {
            System.out.println(student.toString());
        }
    }

    public String creatSex() {
        System.out.println("Nhập Giới tính");
        String sex = scanner.nextLine();
        if (sex.equals("Nam")){
            return "Nam";
        }else if (sex.equals("Nữ")){
            return "Nữ";
        }else {
            return "Không xác định";
        }
    }


    public int findIndexById(){
        System.out.println("Nhập ID");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("ID phải là số, mời nhập lại");
            }
        }
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    public void edit(){
        int index = findIndexById();
        if (index >= 0){
            studentList.get(index).setName(creatName());
            studentList.get(index).setAge(creatAge());
            studentList.get(index).setAddress(creatAddress());
            studentList.get(index).setSex(creatSex());
            studentList.get(index).setPoint(creatPoint());
        }else {
            System.out.println("Không tìm thấy ID");
        }
    }

    public void delete(){
        int index = findIndexById();
        if (index >=0){
            studentList.remove(index);
        }else {
            System.out.println("Không tìm thấy ID");
        }
    }

    public void sortPointDown() {
        Collections.sort(studentList, new SortPontUp());
    }

    public void sortPointUp() {
        Collections.sort(studentList, new SortPointDown());
    }











}
