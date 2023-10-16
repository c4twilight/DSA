package com.example.test.problem.BitManipulation;

public class Mathematics2 {
    static int m = (int) (1e9+7);

    public static void main(String[] args) {
//        System.out.println(fastPowerm(3, 5));
//        System.out.println(fact(5));

        System.out.println(ncrm(5000, 100));
    }

    static int ncrm(int n, int r) {
        return mulm(mulm(fact(n), inv(fact(n-r))), inv(fact(r)));
    }

    static int fact(int n) {
        int res = 1;
        for(int i = 1; i<=n; i++) {
            res = mulm(res, i);
        }
        return res;
    }

    static int inv(int a) {
        return fastPowerm(a, m-2);
    }

    static int divm(int a, int b) {
//        return mulm(a, fastPowerm(b, m-2));
        return mulm(a, inv(b));
    }

    static int fastPowerm(int a, int b) {
        int res = 1;
        while (b > 0) {
            if ((b&1) != 0) {
                res = mulm(res, a);
            }

            a = mulm(a, a);
            b = b >> 1;
        }
        return res;
    }

    static int addm(int a, int b) {
        return (a%m + b%m) % m;
    }

    static int mulm(int a, int b) {
        return (int) (((long)a%m * (long)b%m) % m);
    }

    static int subm(int a, int b) {
        return (a%m - b%m + m) % m;
    }

}
