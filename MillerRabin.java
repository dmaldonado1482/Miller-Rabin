/**
 * David Maldonado
 */
import java.util.Random;
import java.math.BigInteger;
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

		BigInteger bigQ = new BigInteger(Integer.toString(q));
		BigInteger bigA = new BigInteger(Integer.toString(a));
		BigInteger bigN = new BigInteger(Integer.toString(n));

		// a to the q mod n
		BigInteger result = bigA.modPow(bigQ, bigN);
		int intResult = result.intValue();

		if(intResult == 1)
		{
			return true;
		}
		for(int j=0; j < k; j++)
		{
			if(intResult == n-1)
			{
				return true;
			}
			intResult = (intResult*intResult) % n;
		}

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

		int t = 1;

		double pr = 0;
		while(pr < p)
		{
			pr = 1 - (1 / Math.pow(4, t));
			t++;
		}
		System.out.println("Running Miller-Rabin " + t + " times.\n");

		for(int i=0; i < t; i++)
		{
			boolean check = millerRabin(n);
			if(!check)
			{
				System.out.println(n + " is definitely NOT prime.");
				return false;
			}
		}
		System.out.println(n + " is prime with a probability of at least " + p);
		return true;
	}
	
	public static void main(String[] args) {
		// Write some code here to test that your functions work.

		//System.out.println(millerRabin(999983));
		isProbablyPrime(999983, .99999);
	}
	
}