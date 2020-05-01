package com.main.apiAutomation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < t; i++) {
            a = in.nextInt();
            b = in.nextInt();
            n = in.nextInt();
        }
        in.close();
        int x = 0;
        for (int j = 0, k = 0; j < n && k <= n - 1; j++, k++) {
            x = (int) Math.pow(2, k) * b + x;
            System.out.print(a + x + " ");
        }
    }


}
