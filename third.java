//package computer2;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
////괄호 깊이에 따른 시각화
//
///*
//[입력 4]
//4
//(a(bc)
//
//[출력 4]
//Input:(A(BC)
// A
//  B
//  C
//Mismatch
// */
//
//public class third {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int n = Integer.parseInt(br.readLine());
//		String sentence = br.readLine();
//		String[] word = sentence.split("");
//
//
//		switch (n) {
//		case 1: 
//			System.out.println("Input:"+sentence);
//			break;
//		case 2:
//			System.out.println("Input:"+sentence.toUpperCase());
//			break;
//		case 3:
//			String newsentence=sentence.toUpperCase();
//			String[] word1 = newsentence.split("");
//			System.out.println("Input:"+ newsentence);
//			int count1=0;
//			int a1=0;
//			for(int i=0;i<word1.length;i++) {
//				if(word1[i].equals("(")) {
//					count1++;
//					a1=count1;
//				}
//				if(word1[i].equals(")")) {
//					count1=a1;
//				}
//				else if(!word1[i].equals("(") && !word1[i].equals(")")) {
//					for(int j=0;j<count1;j++) {
//						System.out.print(" ");
//					}
//					System.out.println(word1[i]);
//				}
//			}
//			break;
//		case 4:
//			newsentence=sentence.toUpperCase();
//			word1 = newsentence.split("");
//			System.out.println("Input:"+ newsentence);
//			int count=0;
//			int close=0;
//			int open=0;
//			int a=0;
//			for(int i=0;i<word1.length;i++) {
//				if(word1[i].equals("(")) {
//					open++;
//					count++;
//					a=count;
//				}
//				if(word1[i].equals(")")) {
//					close++;
//					if(close>open) {
//						System.out.println("Mismatch");
//						System.exit(0);
//					}
//					count=a-1;
//				}
//				else if(!word1[i].equals("(") && !word1[i].equals(")")) {
//					for(int j=0;j<count;j++) {
//						System.out.print(" ");
//					}
//					System.out.println(word1[i]);
//				}
//			}
//			
//			if(open!=close) {
//				System.out.println("Mismatch");
//			}
//			break;
//
//		}		
//	}
//
//}
