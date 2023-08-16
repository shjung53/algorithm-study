package 스위치켜고끄기_1244;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchNum = Integer.parseInt(br.readLine());
		int[] onOffArr = new int[switchNum + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i <= switchNum; i++) {
			onOffArr[i] = Integer.parseInt(st.nextToken());
		}
		int studentNum = Integer.parseInt(br.readLine());
		Student[] studentArr = new Student[studentNum];
		for(int i=0; i<studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			studentArr[i] = new Student(gender, number);
			
		}
		
		for(int i=0; i<studentNum; i++) {
			if(studentArr[i].getGender() == 1) {
				boy(onOffArr, studentArr[i].getNumber());
			}else {
				girl(onOffArr, studentArr[i].getNumber());
			}
		}
		
		for(int i=1; i <= switchNum; i++) {
			System.out.print(onOffArr[i]);
			if(i != switchNum) {
				System.out.print(" ");
			}
		}
	}
	
	private static void boy(int[] onOffArr, int number) {
		for(int i=1; i <= onOffArr.length; i++) {
			if(i%number==0) {
				if(onOffArr[i]==1) {
					onOffArr[i] = 0;
				}else {
					onOffArr[i] = 1;
				}
			}
		}
	}
	private static void girl(int[] onOffArr, int number) {
		int farFromNum=0;
		for(int i=0; i < onOffArr.length; i++) {
			if(onOffArr[number+i] > onOffArr.length-1 || onOffArr[number-i] <= 0) break;
			if(onOffArr[number+i]==onOffArr[number-i]) {
				farFromNum = i;
			}
		}
		for(int i=(number-farFromNum); i<=(number + farFromNum); i++) {
			if(onOffArr[i]==1) {
				onOffArr[i] = 0;
			}else {
				onOffArr[i] = 1;
			}
		}
	}
}

class Student {
	private int gender;
	private int number;
	
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Student(int gender, int number) {
		super();
		this.gender = gender;
		this.number = number;
	}
	
}
