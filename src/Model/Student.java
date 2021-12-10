package Model;

public class Student {
    private int id;
    static int idNumber;
    private String name;
    private int age;
    private String sex;
    private String address;
    private int point;

    public Student(String name, int age, boolean sex, String address, int score) {
    }

    public Student(int id,String name, int age, String sex, String address, int point) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String isSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return
                 id +
                "," + name +
                "," + age +
                "," + sex +
                "," + address +
                "," + point
                ;
    }
}
