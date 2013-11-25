import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: martinpettersson
 * Date: 2013-11-25
 * Time: 19:39
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    private final static BigInteger     ZERO  = BigInteger.ZERO;
    private final static BigInteger     ONE  = BigInteger.ONE;
    private final static BigInteger     TWO  = new BigInteger("2");
    private static       Kattio         io = new Kattio(System.in, System.out);

    public static void main(String[] args) {
        Long a = new Long("9101273416");
        Long b = new Long("9101273417");
        longEuclideanGCD(a,b);
        io.close();
    }

    private static void euclideadGCD(BigInteger a, BigInteger b) {
        BigInteger s = ZERO;
        BigInteger olds = ONE;
        BigInteger t = ONE;
        BigInteger oldt = ZERO;
        BigInteger r = b;
        BigInteger oldr = a;

        while(!(r.compareTo(ZERO) == 0)) {
            BigInteger quotient = oldr.divide(r);
            System.err.println("oldr: " + oldr + " r: " + r + " oldr/r: " + quotient);

            oldr = r;
            BigInteger tmp = quotient.multiply(r);
            r = oldr.subtract(tmp);

            olds = s;
            tmp = quotient.multiply(s);
            s = olds.subtract(tmp);

            oldt = t;
            tmp = quotient.multiply(t);
            t = oldt.subtract(tmp);
        }
        System.out.println("Bézout coefficients: s: " + olds + " t: " + oldt);
        System.out.println("greatest common divisor: " + oldr);
        System.out.println("quotients by the gcd: t: " + t + " s: " + s);
    }

    private static void longEuclideanGCD(long a, long b) {

        long s = 0; long olds = 1;
        long t = 1; long oldt = 0;
        long r = b; long oldr = a;

        System.err.println(r);
        while(r != 0) {
            long quotient = oldr / r;
            System.err.println("oldr: " + oldr + " r: " + r + " oldr/r: " + quotient);
            oldr = r; r = oldr - quotient *r;
            olds = s; s = olds - quotient *s;
            oldt = t; t = oldt - quotient *t;
        }

        System.out.println("greatest common divisor: " + oldr);
        System.out.println("Bézout coefficients: s: " + olds + " t: " + oldt);
        System.out.println("quotients by the gcd: t: " + t + " s: " + s);

        long u1 = oldt * a;
        long u2 = olds * b;

        System.out.println("U1: " + u1 + " U2: " + u2);
        System.out.println("U1 + U2: " + (u1+u2));

        long a1 = 123456789;
        long a2 = 987654321;
        long x = a1*u1 + a2*u2;

        System.out.println("x = " + x);
        System.out.println("a_1 mod p_1 = " + (a1%a));
        System.out.println("a_2 mod p_2 = " + (a2%b));
        System.out.println("x mod p__1 = " + (x%a));
        System.out.println("x mod p_2 = " + (x%b));

    }

    public static int[] ExtendedEuclid(int a, int b)
    /*  This function will perform the Extended Euclidean algorithm
        to find the GCD of a and b.  We assume here that a and b
        are non-negative (and not both zero).  This function also
        will return numbers j and k such that
               d = j*a + k*b
        where d is the GCD of a and b.
    */
    {
        int[] ans = new int[3];
        int q;

        if (b == 0)  {  /*  If b = 0, then we're done...  */
            ans[0] = a;
            ans[1] = 1;
            ans[2] = 0;
        }
        else
        {     /*  Otherwise, make a recursive function call  */
            q = a/b;
            ans = ExtendedEuclid (b, a % b);
            int temp = ans[1] - ans[2]*q;
            ans[1] = ans[2];
            ans[2] = temp;
        }

        return ans;
    }

    public static BigInteger[] bigExtendedEuclid(BigInteger a, BigInteger b) {
        BigInteger[] ans = new BigInteger[3];
        BigInteger q;
        if(b.compareTo(ZERO) == 0) {
            ans[0] = a;
            ans[1] = ONE;
            ans[2] = ZERO;
        } else {
            q = a.divide(b);
            ans = bigExtendedEuclid(b, a.mod(b));
            BigInteger tmp = ans[1].subtract(ans[2].multiply(q));
            ans[1] = ans[2];
            ans[2] = tmp;
        }
        return ans;
    }
}
