package problem1;

public class main {

    public main() {};

    public static void main(String args[]) {
        System.out.println(Integer.MAX_VALUE);
        int sum1 = sumToN1(33000);
        int sum2 = sumToN2(35000);
        int sum3 = sumToN3(100000);

        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);
        System.out.println("sum3 = " + sum3);
    }

    // Beauty of recursion
    public static int sumToN1(int n) {

        // to prevent stack overflow
        if (n > 20000) {
            System.out.println("Sorry! Number is too big for sumToN1() :(");
            return -1;
        }
        return n == 0 ? 0 : n + sumToN1(n - 1);
    }

    // Beauty of iterative recursion
    public static int sumToN2(int n) {
        if (n > 20000) {
            System.out.println("Sorry! Number is too big for sumToN2() :(");
            return -1;
        }
        return sumToN2_helper(n, 0);
    }

    public static int sumToN2_helper(int n, int total) {
        return n == 0 ? total : sumToN2_helper(n - 1, total += n);
    }

    // Beauty of math
    public static int sumToN3(int n) {
        return (n * (1 + n) / 2);
    }
}
