import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;


public class coding {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		int testCaseNumber = scanner.nextInt();
		scanner.close();

		switch(testCaseNumber) {
		case 1: // 
			String sentence = "1 html http://coding.cnu.ac.kr";
			String[] word = sentence.split(" ");
			int step = Integer.parseInt(word[0]);
			String keyword = word[1];
			String URL = word[2];
			step_1(keyword,URL);
			break;
		case 2: // 
			sentence = "2 http http://coding.cnu.ac.kr";
			word = sentence.split(" ");
			step = Integer.parseInt(word[0]);
			keyword = word[1];
			URL = word[2];
			step_1(keyword,URL);
			step_2(URL);
			break;

		case 3: // 
			sentence = "3 html https://naver.com";
			word = sentence.split(" ");
			step = Integer.parseInt(word[0]);
			keyword = word[1];
			URL = word[2];
			step_1(keyword,URL);
			step_2(URL);
			step_3(URL);
			break;

		case 4: //
			sentence = "3 html http://coding.cnu.ac.kr";
			word = sentence.split(" ");
			step = Integer.parseInt(word[0]);
			keyword = word[1];
			URL = word[2];
			step_1(keyword,URL);
			step_2(URL);
			step_3(URL);
			break;

		case 5:
			sentence = "3 html coding.cnu.ac.kr";
			word = sentence.split(" ");
			step = Integer.parseInt(word[0]);
			keyword = word[1];
			URL = word[2];
			step_1(keyword,URL);
			step_2(URL);
			step_3(URL);
			break;
		case 6: // 4 
			sentence = "4 html http://coding.cnu.ac.kr";
			word = sentence.split(" ");
			step = Integer.parseInt(word[0]);
			keyword = word[1];
			URL = word[2];
			step_1(keyword,URL);
			step_2(URL);
			step_3(URL);
			step_4(URL,keyword);
			break;
		case 7:
			sentence = "4 http http://google.com";
			word = sentence.split(" ");
			step = Integer.parseInt(word[0]);
			keyword = word[1];
			URL = word[2];
			step_1(keyword,URL);
			step_2(URL);
			step_3(URL);
			step_4(URL,keyword);
			break;
		case 8:
			sentence = "4 http https://google.com";
			word = sentence.split(" ");
			step = Integer.parseInt(word[0]);
			keyword = word[1];
			URL = word[2];
			step_1(keyword,URL);
			step_2(URL);
			step_3(URL);
			step_4(URL,keyword);
			break;
		case 9:
			sentence = "4 http https://www.google.com";
			word = sentence.split(" ");
			step = Integer.parseInt(word[0]);
			keyword = word[1];
			URL = word[2];
			step_1(keyword,URL);
			step_2(URL);
			step_3(URL);
			step_4(URL,keyword);
			break;
		case 10:
			sentence = "4 http https://m.google.com";
			word = sentence.split(" ");
			step = Integer.parseInt(word[0]);
			keyword = word[1];
			URL = word[2];
			step_1(keyword,URL);
			step_2(URL);
			step_3(URL);
			step_4(URL,keyword);
			break;

		}
	}
	public static void step_1(String keyword, String URL) {
		int aCount = URL.length() - URL.replace(keyword, "").length();
		if(aCount!=0) {
			System.out.println("Step-1:keyword("+keyword+") found in URL("+URL+")");
		}
		else {
			System.out.println("Step-1:keyword("+keyword+") NOT found in URL("+URL+")");
		}
	}

	public static void step_2(String urlPath) {
		try {

			URL url = new URL(urlPath);
			InputStream is =url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			PrintWriter fw = new PrintWriter(new FileOutputStream("C:/Users/정현제/Pictures/Desktop/새 폴더/output.html"));
			System.out.println("Step-2:success to open stream");
			String line = "";
			while ((line = br.readLine()) != null) {

				fw.println(line);
				fw.flush();
			}
			br.close();
			is.close();

			fw.close();

		} catch (IOException e) {
			System.out.println("Step-2:fail to open stream");  
			System.exit(0);
		} catch (Exception e) {
			System.out.println("Step-2:fail to open stream");  
			System.exit(0);
		}
	}  
	public static void step_3(String urlPath) throws IOException {
		File file = new File("C:/Users/정현제/Pictures/Desktop/새 폴더/output.html");

		int size = (int) Math.ceil(file.length() / 1024.);
		System.out.println("Step-3:size("+size+"KB)");
	} 
	public static void step_4(String urlPath,String keyword){
		   try {  
			   URL url = new URL(urlPath);  
	            URLConnection conn = url.openConnection();  
	              
	            InputStream is = conn.getInputStream();  
	            Scanner scan = new Scanner(is);  
	              
	            int line = 1;  
	            int result=0;
	            while (scan.hasNext()) {  
	                String str = scan.nextLine();  
	                int aCount = str.length() - str.replace(keyword, "").length();
	                result+=aCount/keyword.length();
	            } 
	            System.out.println(result);
	            scan.close();  
	              
		   } catch (MalformedURLException e) { 
	            System.out.println("The URL address is incorrect.");  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            System.out.println("It can't connect to the web page.");  
	            e.printStackTrace();  
	        }  
	}
}





