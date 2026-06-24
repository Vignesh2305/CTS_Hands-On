class Main
{
	public static void main(String[] args)
	{
		double amount = 10000.0;
		int years = 5;
		double rate = 1.02;
		double forecast = Main.forecaster(amount, years, rate);
		System.out.printf("%.0f after %.0f years is %.2f", amount,(double) years, forecast);
	}
	//Recursive algorithm to find future growth of the amount
	public static double forecaster(double amount, int year, double rate)
	{
		if(year <= 0) return amount;
		return forecaster(amount, year - 1, rate) * rate;
	}
	//The time and space complexity of this algorithm is O(N)
	//We can optimize the algorithm by using an iterative approach or Dynamic Programming
}