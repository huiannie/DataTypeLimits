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

// A program to explore the limits of four common data types:
// int
// long
// float
// double

public class Limits {

	
	// The following method may be used to find 
	// the first integer value that cannot be 
	// represented by a float. 
	// This value provides a reasonable limit on
	// the precision of the result. 
	// Any result larger than this value has the 
	// potential to be inaccurate. 
	public static int floatMaxPrecision() {
		int mantissaBits = 24; // number of bits in the mantissa of float
		int start = (int) Math.pow(2, mantissaBits);
		int maxPrecision = start;
		
		for (int i=start; i<Integer.MAX_VALUE; i++) {
			float f = (float)i;
			int ii = (int) f;
			if (ii-i!=0) {
				System.out.println("First integer that cannot be represented precisely as float is: " + i);
				maxPrecision = i-1;
				break;
			}
		}
		return maxPrecision;
	}
	
	// The following method may be used to find 
	// the first integer value that cannot be 
	// represented by a double. 
	// This value provides a reasonable limit on
	// the precision of the result. 
	// Any result larger than this value has the 
	// potential to be inaccurate. 
	public static long doubleMaxPrecision() {
		long mantissaBits = 53; // number of bits in the mantissa of double
		long start = (long) Math.pow(2, mantissaBits);
		long maxPrecision = start;
		
		for (long i=start; i<Long.MAX_VALUE; i++) {
			double f = (double)i;
			long ii = (long) f;
			if (ii-i!=0) {
				System.out.println("First integer that cannot be represented precisely as double is: " + i);
				maxPrecision = i-1;
				break;
			}
		}
		return maxPrecision;
	}
	
	public static void printTypeInfo() {
		System.out.println("Type int: bytes=" + Integer.BYTES + " max=" + Integer.MAX_VALUE + " min=" + Integer.MIN_VALUE);
		System.out.println("Type float: bytes=" + Float.BYTES + " max=" + Float.MAX_VALUE + " min=" + Float.MIN_VALUE);
		System.out.println("Type long: bytes=" + Long.BYTES + " max=" + Long.MAX_VALUE + " min=" + Long.MIN_VALUE);
		System.out.println("Type double : bytes=" + Double.BYTES + " max=" + Double.MAX_VALUE + " min=" + Double.MIN_VALUE);
	}
	
	public static void main(String[] args) {
		printTypeInfo();
		floatMaxPrecision();
		doubleMaxPrecision();
	}
}
