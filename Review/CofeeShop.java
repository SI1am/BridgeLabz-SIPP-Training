package level;
import java.util.*;
public class CofeeShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome To Dev.Coffeee... A perfect Coffee palce for Devs");
		boolean leave=false;
		
		double tax=.18;
		double total=0.0;
		
		
		while(!leave) {
			System.out.println("Select Your Coffee here :");
			System.out.println("1-Latte");
			System.out.println("2-Hot coffee");
			System.out.println("3-Choclate Coffee");
			System.out.println("4-Cold Coffee");
			System.out.println("5-Complete Order");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Price : 100Rs");
				total+=bill(choice,tax,sc,100);
				break;
			case 2:
				System.out.println("Price : 150Rs");
				total+=bill(choice,tax,sc,150);
				break;
			case 3:
				System.out.println("Price : 170Rs");
				total+=bill(choice,tax,sc,170);
				break;
			case 4:
				System.out.println("Price : 200Rs");
				total+=bill(choice,tax,sc,200);
				break;
			case 5:
				total+=(tax*total);
				System.out.println("Your total is: "+total);
				System.out.println("Thankyou!!!");
				leave=true;
				break;
			default: 
				System.out.println("Please choose from the menu :1");
			}
			
		}
		
		System.out.println();

	}
	static double bill(int choice, double tax, Scanner sc,int price) {
		System.out.println("Enter the quantity:");
		int quat=sc.nextInt();
		double total=price*quat;
		return total;
	}

}
