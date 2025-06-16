
public class ProfitOrLoss {
	public static void main(String[] args) {
		int Cost=129;
		int Sell=191;
		double Profit=((Sell-Cost)*100)/Cost;
		System.out.println("The Cost Price is INR "+Cost+" and Selling Price is INR "+ Sell);
		System.out.println("The Profit is INR "+(Sell-Cost)+" and the Profit Percentage is "+ Profit);
	}

}
