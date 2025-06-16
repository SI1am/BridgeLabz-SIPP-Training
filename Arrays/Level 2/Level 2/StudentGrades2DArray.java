import java.util.Scanner;

public class StudentGrades2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[][] marks = new double[n][3];
        double[] percent = new double[n];
        String[] grade = new String[n];
        String remarks = "";

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for Physics, Chemistry, Maths for student " + (i + 1));
            for (int j = 0; j < 3; j++) {
                marks[i][j] = sc.nextDouble();
                if (marks[i][j] < 0) {
                    System.out.println("Invalid marks. Try again.");
                    j--;
                }
            }

            percent[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

           
            if (percent[i] >= 80){
                grade[i] = "A";
                remarks = "above agency-normalized standards";
            }
            else if (percent[i] >= 70){
                grade[i] = "B"; 
                remarks = "at agency-normalized standards";}
            else if (percent[i] >= 60){
                grade[i] = "C";
                remarks = "below, but approaching agency-normalized standards";
            }
            else if (percent[i] >= 50){

                grade[i] = "D";
                remarks = "well below agency-normalized standards";
            }
                else if (percent[i] >= 40){

                    grade[i] = "E";
                    remarks = "too below agency-normalized standards";
                }
            else{
                remarks = "Remedial standards";
                grade[i] = "R";
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d: Physics=%.1f, Chemistry=%.1f, Maths=%.1f, Percentage=%.2f%%, Grade=%s%n",
                i + 1, marks[i][0], marks[i][1], marks[i][2], percent[i], grade[i]);
        }
    }
}
