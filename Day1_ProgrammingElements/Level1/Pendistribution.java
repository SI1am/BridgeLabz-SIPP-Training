public class Pendistribution{
    public static void main(String[] args) {
        int NumberOfPens=14;
        int NumberOfStudents=3;
        int PensPerStudent=NumberOfPens/NumberOfStudents;
        int RemainingPens=NumberOfPens%NumberOfStudents;
        System.out.print("The pens per student is " + PensPerStudent);
        System.out.println(" and the remaining pen not distributed is " + RemainingPens);
    }
}