package problem1;

import java.util.Scanner;

public class main {

    public main() {};

    public static void main(String args[]) {
        //System.out.println(Integer.MAX_VALUE);

        int a = 0;
        int b = 0;
        int c = 0;

        Scanner sc = new Scanner(System.in);

        try {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();

        int sum1 = sum_to_n_a(a);
        System.out.println("sum1 = " + sum1);

        int sum2 = sum_to_n_b(b);
        System.out.println("sum2 = " + sum2);

        int sum3 = sum_to_n_c(c);
        System.out.println("sum3 = " + sum3);
    }

    // Beauty of recursion
    public static int sum_to_n_a(int n) {

        // to prevent stack overflow
        if (n > 30000) {
            System.out.println("Sorry! Number is too big for sumToN1() :(");
            return -1;
        }
        return n == 0 ? 0 : n + sum_to_n_a(n - 1);
    }

    // Beauty of naivety
    public static int sum_to_n_b(int n) {
        int sum = 0;
        int count = n;

        while (count != 0) {
            sum += count;
            count--;
        }
        
        return sum;
    }

    // Beauty of math
    public static int sum_to_n_c(int n) {
        return (n * (1 + n) / 2);
    }
}
