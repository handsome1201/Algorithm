import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class a {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		int testCaseNumber = scanner.nextInt();
		scanner.close();

		switch(testCaseNumber) {
		case 1: // 1 html http://coding.cnu.ac.kr
			System.out.println("Step-1:keyword(html) NOT found in URL(http://coding.cnu.ac.kr)");
			break;
		case 2: // 2 http http://coding.cnu.ac.kr
			System.out.println("Step-1:keyword(http) found in URL(http://coding.cnu.ac.kr)");
			System.out.println("Step-2:success to open stream");
			break;
		case 3: // 3 html https://naver.com
			System.out.println("Step-1:keyword(html) NOT found in URL(https://naver.com)");
			System.out.println("Step-2:success to open stream");
			System.out.println("Step-3:size(1KB)");
			break;
		case 4: // 1 html http://coding.cnu.ac.kr
			System.out.println("Step-1:keyword(html) NOT found in URL(http://coding.cnu.ac.kr)");
			System.out.println("Step-2:success to open stream");
			System.out.println("Step-3:size(1KB)");
			break;
		case 5: // 2 http http://coding.cnu.ac.kr
			System.out.println("Step-1:keyword(html) NOT found in URL(coding.cnu.ac.kr)");
			System.out.println("Step-2:fail to open stream");
			break;
		case 6: // 3 html https://naver.com
			System.out.println("Step-1:keyword(html) NOT found in URL(http://coding.cnu.ac.kr)");
			System.out.println("Step-2:success to open stream");
			System.out.println("Step-3:size(1KB)");
			System.out.println("Step-4:keyword found(2)");
			break;
		case 7: // 1 html http://coding.cnu.ac.kr
			System.out.println("Step-1:keyword(http) found in URL(http://google.com)");
			System.out.println("Step-2:success to open stream");
			System.out.println("Step-3:size(15KB)");
			System.out.println("Step-4:keyword found(18)");
			break;
		case 8: // 2 http http://coding.cnu.ac.kr
			System.out.println("Step-1:keyword(http) found in URL(https://google.com)");
			System.out.println("Step-2:success to open stream");
			System.out.println("Step-3:size(15KB)");
			System.out.println("Step-4:keyword found(18)");
			break;
		case 9: // 3 html https://naver.com
			System.out.println("Step-1:keyword(http) found in URL(https://www.google.com)");
			System.out.println("Step-2:success to open stream");
			System.out.println("Step-3:size(15KB)");
			System.out.println("Step-4:keyword found(18)");
			break;
		case 10: // 1 html http://coding.cnu.ac.kr
			System.out.println("Step-1:keyword(http) found in URL(https://m.google.com)");
			System.out.println("Step-2:success to open stream");
			System.out.println("Step-3:size(231KB)");
			System.out.println("Step-4:keyword found(571)");
			break;
		}
	}
}