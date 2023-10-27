package com.example.test.problem.BitManipulation;

public class BitManipulationLIVE {
    public static void main(String[] args) {
//        int a[] = {2, 2, 7, 2, 3, 9, 3, 9, 3, 9};
//        System.out.println(uniqueII(a));
//        int a[] = {1, 3, 5};
//        System.out.println(differentBitsSumPairwise(a));
        System.out.println(divideIntegers(-100, -6));
    }

    static int divideIntegers(int dnd, int dsr) {
        int sign = (dnd < 0) ^ (dsr<0) ? -1 : 1;
        int ans = 0;

        dnd = Math.abs(dnd);
        dsr = Math.abs(dsr);

        while(dnd > dsr) {
            int i = 0;
            int temp = dsr;
            while(dnd > (temp << 1)) {
                temp = temp << 1;
                i++;
            }
            ans += (1 << i);
            dnd = dnd - temp;
        }

        return ans * sign;
    }

    static int differentBitsSumPairwise(int a[]) {
        int n = a.length;
        int ans = 0;
        for(int i = 0; i<32; i++) {
            int k = 0;
            for(int e: a) {
                if((e & (1<<i)) != 0) {
                    k++;
                }
            }
            ans += k * (n-k) * 2;
        }
        return ans;
    }

    static int uniqueII(int a[]) {
        int ans = 0;
        for(int i = 0; i<32; i++) {
            int count = 0;
            for(int e: a) {
                if((e & (1 << i)) != 0) {
                    count++;
                }
            }
            if(count%3 != 0) {
                ans = ans | 1<<i;
            }
        }
        return ans;
    }
}
