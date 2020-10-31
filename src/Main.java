import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {

	private static String numbers[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen",
			"nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five",
			"twenty-six", "twenty-seven", "twenty-eight", "twenty-nine", "half" };

	static String timeInWords(int h, int m) {

		StringBuilder str = new StringBuilder();

		if (m == 0) {
			return (str.append(getStringNumber(h)).append(getStringMinutsRules(m))).toString();
		} else {
			return (str.append(getStringMinutsRules(m)).append(getStringHourRules(h, m))).toString();
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Digite a Hora:");
		int h = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println("Digite os Minutos:");
		int m = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = timeInWords(h, m);
		System.out.println(result);

		scanner.close();
	}

	private static String getStringNumber(Integer num) {
		return numbers[num];
	}

	private static String getStringMinutsRules(Integer num) {
		StringBuilder str = new StringBuilder();
		if (num == 0) {
			return " o' clock";
		} else if (num > 0 && num <= 30) {
			if (num == 1) {
				return (str.append(getStringNumber(num)).append(" minute past ")).toString();
			} else if (num == 15 || num == 30) {
				return (str.append(getStringNumber(num)).append(" past ")).toString();
			}
			return (str.append(getStringNumber(num)).append(" minutes past ")).toString();
		} else {
			int val = 60 - num;
			if (val == 1) {
				return (str.append(getStringNumber(val)).append(" minute to ")).toString();
			} else if (val == 15 || val == 30) {
				return (str.append(getStringNumber(val)).append(" to ")).toString();
			}
			return (str.append(getStringNumber(val)).append(" minutes to ")).toString();
		}

	}

	private static String getStringHourRules(Integer hour, Integer min) {
		StringBuilder str = new StringBuilder();
		if (min <= 30) {
			return str.append(getStringNumber(hour)).toString();
		} else {
			if (hour < 23) {
				int val = hour + 1;
				return str.append(getStringNumber(val)).toString();
			} else {
				return str.append(getStringNumber(0)).toString();
			}
		}
	}
}