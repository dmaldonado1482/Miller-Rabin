/**
 * David Maldonado
 */
import java.util.Random;
public class MillerRabin {
	
	/**
	* Tests if n is a prime number.  Returns False if n is
    * definitely a composite.  Returns True if n might be a prime
    * number.
	*
    * @param n the number to test for primality.
	*/
	public static boolean millerRabin(int n) {
		if(n == 1){
			return false;
		}

		int k = Integer.numberOfTrailingZeros(n-1);
		int q = (n-1) >> k;

		// a must be greater than 1 and less than n-1
		int a = 0;
		Random r = new Random();
		if(n < 4)
		{
			a = 2;
		}
		else
		{
			a = r.nextInt(((n-2) - 2) + 1) + 2;
		}
		System.out.println(a);

		return false;
	}
	
	/**
	* Tests if n is a prime number.  If this function returns False,
    * then n is definitely a prime number.  If this function returns True,
    * then the probability that n is a prime number is at least p.
	*
	* @param n the number to test for primality.
	* @param p target probability.
	*/
	public static boolean isProbablyPrime(int n, double p) {
		return false;
	}
	
	public static void main(String[] args) {
		// Write some code here to test that your functions work.

        System.out.println(millerRabin(35));
	}
	
}