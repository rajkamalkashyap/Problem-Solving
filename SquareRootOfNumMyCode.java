package gs;

public class SquareRootOfNumMyCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double n=2,i;
		for( i= 0.001 ; i*i<n ; i=(i+0.001));
		
		System.out.printf("%.2f",i);
		/*double ans= squareRoot(4);
		System.out.println(ans);*/
			
	}
	/*public static double squareRoot( double x )
	  {
	    double threshold = 0.001;
	    double guess = x/2.0;
	    for(int iterations=500; iterations > 0 && Math.abs(guess*guess-x) > threshold; iterations--)
	    {
	      guess = guess - ((guess*guess-x)/(2.0*guess));
	    }

	    return guess;
	  }*/
}
