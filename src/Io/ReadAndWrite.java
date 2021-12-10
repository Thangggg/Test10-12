package Io;

import Model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public void writer(String filePath, List<Student> list){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for (int i = 0; i < list.size(); i++) {
                fileWriter.write(list.get(i)+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public List<Student> readFile(String FILE_PATH) {
        List<Student> studentsList = new ArrayList<>();
        File file = new File(FILE_PATH);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine())!=null){
                String[] str  = line.split(",");
                int id = Integer.parseInt(str[0]);
                String name = str[1];
                int age = Integer.parseInt(str[2]);
                String sex  = (str[3]);
                String address = str[4];
                int point = Integer.parseInt(str[5]);
                Student student = new Student(id,name,age,sex,address,point);
                studentsList.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentsList;
    }
}