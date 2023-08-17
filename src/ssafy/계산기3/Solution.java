package 계산기3;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int lineLength = Integer.parseInt(br.readLine());
			
			String line = br.readLine();
			
			ArrayDeque<Character> ad = new ArrayDeque();
			
			String str = "";
			
			for(int i=0; i<lineLength; i++) {
				char it = line.charAt(i);
				
				if(Character.isDigit(it)) {
					str += it;
					
					if(!ad.isEmpty()) {
						if(ad.peekLast()!='(') {
							str += ad.removeLast();
						}
					}
					continue;
				}
				
				if(it == '(') {
					ad.addLast(it);
					continue;
				}
				
				if(it == ')') {
					while(ad.peekLast() != '(') {
						str += ad.removeLast();
					}
					ad.removeLast();
					continue;
				}
				
			}
			
			while(!ad.isEmpty()) {
				str += ad.removeLast();
			}
			
			int answer = -1;
			
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				
				if(Character.isDigit(c)) {
					ad.addLast(c);
				}else {
					if(c=='+') {
						
					}
				}
			}
		}
		
	}
}
