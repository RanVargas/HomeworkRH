public class Student {
    static int computeCount;

    int id;
    String name;
    String gender;
    int age;
    long phone;
    double gpa;
    char degree;
    boolean international;
    double tuitionFees = 12000.0;
    double internationalFees = 5000.0;

    Student(int id, String name, String gender, int age, long phone, double gpa, char degree,
            boolean isInternational){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.gpa = gpa;
        this.degree = degree;
        this.international = isInternational;
    }

    Student(int newId, String newName, String newGender, int newAge, long newPhone, double newGpa, char newDegree){
        this(newId, newName, newGender, newAge, newPhone, newGpa, newDegree, false);
    }

    Student(){}


    void compute(){
        computeCount = computeCount + 1;


        System.out.println("id is: " + id);
        System.out.println("My name is: " + name);
        System.out.println("My gender is: " + gender);
        System.out.println("My age is: " + age);
        System.out.println("My phone is: " + phone);
        System.out.println("My gpa is: " + gpa);
        System.out.println("My degree is: " + degree);
        System.out.println("Compute Count is: " + computeCount);

    }

    public static void main(String[] args) {
        Student student1 = new Student(1000,"John", "Male",18, 2234567890L, 3.8, 'B', false);
        student1.id = 1000;
        student1.name = "John";
        student1.gender = "Male";
        student1.age = 18;
        student1.phone = 2234567890L;
        student1.gpa = 3.8;
        student1.degree = 'B';
        student1.international = false;
        student1.compute();

        Student student2 = new Student(1001,"Raj", "Male",21, 2234567890L, 3.4, 'M', true);
        student2.id = 1001;
        student2.name = "Raj";
        student2.gender = "Male";
        student2.age = 21;
        student2.phone = 2234567890L;
        student2.gpa = 3.4;
        student2.degree = 'M';
        student2.international = true;
        student2.compute();

        Student student3 = new Student(1002,"Anita", "Female",20, 2234567890L, 4.0, 'M', true);
        student3.id = 1002;
        student3.name = "Anita";
        student3.gender = "Female";
        student3.age = 20;
        student3.phone = 2234567890L;
        student3.gpa = 4.0;
        student3.degree = 'M';
        student3.international = true;
        student3.compute();
        Student[] students = {student1, student2, student3};
        var tempo1 = students[0];
        var tempo2 = students[2];
        students[0] = tempo2;
        students[2] = tempo1;
    }
}
