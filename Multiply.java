/*
 * Copyright (c) 2015-2017 Annie Hui @ NVCC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// The goal of this program is to explore the problem of overflow in integer
// multiplication.
// The multiply method is supposed to catch any overflow that might occurr
// when doing x*y. However, this implementation will not work. Please fix
// the bug in this method so that overflow is properly caught.

// Note: There may be many ways to patch the code. A good approach would work
// for both int and long.


import java.util.Scanner;
import java.math.BigInteger;
import java.lang.ArithmeticException;
import java.lang.Math;


public class Multiply {
    
    
    // This method intends to check if x*y causes overflow before assigning it to z.
    // However, it is not working properly.
    // Please fix it.
    static boolean multiply(int x, int y) {
        int z = 0;
        System.out.println("x: " + x + "  and  y: " + y);
        if (x*y>=Integer.MIN_VALUE && x*y<=Integer.MAX_VALUE) {
            z = x*y;
            System.out.println("x * y = "+z);
            return true;
        }
        else {
            System.out.println("Integer overflow occurred!");
            return false;
        }
    }
    
    
    
    
    
    
    static void testInteractive() {
        Scanner in = new Scanner(System.in);
        System.out.print("x: ");
        int x = in.nextInt();
        System.out.print("y: ");
        int y = in.nextInt();
        multiply(x, y);
    }

    
    static void testSampled() {
        int values[] = {Integer.MAX_VALUE, Integer.MAX_VALUE/2*3, Integer.MAX_VALUE/2, 5, 2, 0, -2, -4, Integer.MIN_VALUE/2, Integer.MIN_VALUE/2*3, Integer.MIN_VALUE};
        int total = values.length * values.length;
        int badCounts = 0;
        for (int i=0; i<values.length; i++) {
            for (int j=0; j<values.length; j++) {
                
                // Use long to find the correct value of z=x*y
                // The only situation where the long may overflow is when x=y=Integer.MIN_VALUE.
                // Handle this special case separately.
                // All other cases may be automatically checked.
                boolean expected;

                long x = values[i];
                long y = values[j];
                long z = x * y;
                if (x<0 && y<0 && z<0) expected = false;
                else expected = (z>=Integer.MIN_VALUE && z<=Integer.MAX_VALUE);
                
                boolean result = multiply(values[i], values[j]);
                if (result==expected) {
                    System.out.println("Correct.");
                }
                else {
                    System.out.println("Incorrect.");
                    badCounts++;
                }
            }
        }
        System.out.println("Total incorrects = " + badCounts + " out of " + total);
    }
    
    public static void main(String[] args) {
        if (args.length!=0)
            testInteractive();
        else
            testSampled();
    }
    
}
