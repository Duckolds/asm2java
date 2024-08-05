public class Student {
    private String name;
    private int age;
    private String email;
    private String phone;
    private String code;
    private int gender; // 0 for Female, 1 for Male
    private float grade;

    public Student(String name, int age, String email, String phone, String code, int gender, float grade) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.code = code;
        this.gender = gender;
        this.grade = grade;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", gender=" + (gender == 0 ? "Female" : "Male") +
                ", grade=" + grade +
                '}';
    }
}
