package problem1;

import java.util.Scanner;

public class main {

    public main() {};

    public static void main(String args[]) {
        System.out.println(Integer.MAX_VALUE);

        int n = 0;

        Scanner sc = new Scanner(System.in);

        try {
            n = sc.nextInt();
        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();

        int sum1 = sum_to_n_a(n);
        System.out.println("sum1 = " + sum1);

        int sum2 = sum_to_n_b(n);
        System.out.println("sum2 = " + sum2);

        int sum3 = sum_to_n_c(n);
        System.out.println("sum3 = " + sum3);
    }

    // Beauty of naivety
    public static int sum_to_n_a(int n) {
        int sum = 0;
        int count = n;

        while (count != 0) {
            sum += count;
            count--;
        }
        
        return sum;
    }

    // Radix by 10
    public static int sum_to_n_b(int n) {
        
        int numsOfSetsOf10 = n / 10;
        int numOfRemainder = n % 10;
        int sumOfOneToNine = 45;

        int sum = 0;

        for (int i = 0; i < numsOfSetsOf10; i++) {
            sum += sumOfOneToNine;
            sumOfOneToNine += 100;
        }

        for (int i = 0; i <= numOfRemainder; i++) {
            sum += (numsOfSetsOf10 * 10) + i;
        }

        return sum;
    }

    // Beauty of math
    public static int sum_to_n_c(int n) {
        return (int)(n * ((1 + n) / 2.0));
    }
}
