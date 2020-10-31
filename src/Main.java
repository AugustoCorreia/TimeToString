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

	// Complete the timeInWords function below.
	static String timeInWords(int h, int m) {

		StringBuilder str = new StringBuilder();

		if (m == 0) {
			return (str.append(getStringNumber(h)).append(getMinutsRules(m))).toString();
		} else {
			return (str.append(getMinutsRules(m)).append(getHourRules(h, m))).toString();
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));
		System.out.println("Digite a Hora:");
		int h = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println("Digite os Minutos:");
		int m = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = timeInWords(h, m);
		System.out.println(result);
		// bufferedWriter.write(result);
		// bufferedWriter.newLine();
		//
		// bufferedWriter.close();

		scanner.close();
	}

	private static String getStringNumber(Integer num) {
		return numbers[num];
	}

	private static String getMinutsRules(Integer num) {
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
		} else if (num >= 30){
			int val = 60 - num;
			if (val == 1) {
				return (str.append(getStringNumber(val)).append(" minute to ")).toString();
			} else if (val == 15 || val == 30) {
				return (str.append(getStringNumber(val)).append(" to ")).toString();
			}
			return (str.append(getStringNumber(val)).append(" minutes to ")).toString();
		}
		return null;

	}

	private static String getHourRules(Integer hour, Integer min) {
		StringBuilder str = new StringBuilder();
		if (min <= 30) {
			return str.append(getStringNumber(hour)).toString();
		} else if (min >= 30) {
			if (hour < 23) {
				int val = hour + 1;
				return str.append(getStringNumber(val)).toString();
			} else {
				return str.append(getStringNumber(0)).toString();
			}
		}
		return null;
	}
}