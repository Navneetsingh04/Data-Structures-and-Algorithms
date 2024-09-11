import java.math.BigInteger;
import java.util.Scanner;

public class FermatLittleTheorem {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter value of p: ");
        BigInteger p = s.nextBigInteger();
        System.out.print("Enter value of a: ");
        BigInteger a = s.nextBigInteger();
        
        BigInteger pMinus1 = p.subtract(BigInteger.ONE); // p-1
        BigInteger pow = a.modPow(pMinus1, p); // a^(p-1) % p
        
        boolean result = false;
        if (isPrime(p.intValue()) && a.compareTo(BigInteger.ZERO) > 0) {
            result = pow.equals(BigInteger.ONE); // check if (a^(p-1) % p) == 1
        }

        if (result) {
            System.out.println("It is Fermat's Little Theorem");
        } else {
            System.out.println("It is not Fermat's Little Theorem");
        }
        s.close();
    }
}
