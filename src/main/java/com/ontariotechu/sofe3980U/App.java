package com.ontariotechu.sofe3980U;

import org.joda.time.LocalTime;

import java.util.Scanner;

/**
 * A small binary calculator demonstrating the operations of the Binary class.
 *
 */
public class App 
{
	/**
	* Main program: The entry point of the program. The local time is printed first.
	*      Two binary operands are then read (from the command line arguments if given,
	*      interactively otherwise, falling back to defaults) and every supported
	*      operation is applied to them and printed.
	*
	* @param args optionally the two binary operands, e.g. <i>10001000 111000</i>
	*/
	public static void main( String[] args )
	{
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);

		String first;
		String second;
		if (args.length >= 2) {          // operands supplied on the command line
			first  = args[0];
			second = args[1];
		} else {                          // otherwise ask the user, with defaults
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the first binary number  [10001000]: ");
			first = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
			System.out.print("Enter the second binary number [111000]: ");
			second = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
			if (first.isEmpty())  first  = "10001000";
			if (second.isEmpty()) second = "111000";
		}

		Binary binary1 = new Binary(first);
		Binary binary2 = new Binary(second);

		System.out.println();
		System.out.println("First binary number is  " + binary1.getValue());
		System.out.println("Second binary number is " + binary2.getValue());
		System.out.println();
		System.out.println("Their summation is      " + Binary.add(binary1, binary2).getValue());
		System.out.println("Their bitwise OR is     " + Binary.or(binary1, binary2).getValue());
		System.out.println("Their bitwise AND is    " + Binary.and(binary1, binary2).getValue());
		System.out.println("Their product is        " + Binary.multiply(binary1, binary2).getValue());
	}
}
