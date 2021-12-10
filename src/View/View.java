package View;

import Controller.Controller;
import Io.ReadAndWrite;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        ReadAndWrite readAndWrite = new ReadAndWrite();


        while (true){
            System.out.println("Chương trình quản lý sinh viên");
            System.out.println("1.Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6.Đọc file");
            System.out.println("7.Ghi file");
            System.out.println("8.Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    controller.show();
                    break;
                case 2:
                    controller.add();
                    break;
                case 3:
                    controller.edit();
                    break;
                case 4:
                    controller.delete();
                    break;
                case 5:
                    System.out.println("1.Sắp xếp theo điểm tăng dần");
                    System.out.println("2.Sắp xếp theo điểm giảm dần");
                    int number = Integer.parseInt(scanner.nextLine());
                    switch (number){
                        case 1:
                            controller.sortPointUp();
                            break;
                        case 2:
                            controller.sortPointDown();
                            break;
                    }
                    break;

                case 6:
                    readAndWrite.readFile("student.txt");
                    break;
                case 7:
                    readAndWrite.writer("student.txt", controller.getList());
                    break;
                case 8:
            }
        }
    }
}
