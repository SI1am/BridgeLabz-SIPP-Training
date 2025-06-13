import java.util.Scanner;

public class SubjectGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks for Physics: ");
        int physics = sc.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        int chemistry = sc.nextInt();
        System.out.print("Enter marks for Maths: ");
        int maths = sc.nextInt();

        int total = physics + chemistry + maths;
        double percentage = total / 3.0;
        String  remarks;

         if (percentage >= 80) {
            remarks = "Level 4, above agency-normalized standards";
        } else if (percentage >= 70) {
           
            remarks = "Level 3, at agency-normalized standards";
        } else if (percentage >= 60) {
            
            remarks = "Level 2, below, but approaching agency-normalized standards";
        } else if (percentage >= 50) {
            
            remarks = "Level 1, well below agency-normalized standards";
        } else if (percentage >= 40) {
            
            remarks = "Level 1-, too below agency-normalized standards";
        } else {
            
            remarks = "Remedial standards";
        }

        System.out.printf("Average Mark: %.2f\n", percentage);
        
        System.out.println("Remarks: " + remarks);
    }
}
