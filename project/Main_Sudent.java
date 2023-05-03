package com.project;

import java.util.Scanner;

public class Main_Sudent {

	public static void main(String[] args) {
      student st=new student();
       System.out.println("\tStudent Login Portal");
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Student Username: ");
		String stuname=sc.next();
		System.out.print("Enter the Student Password: ");
		String stupass=sc.next();
		
		if(st.stlog(stuname,stupass)) {
			while(true) {
				System.out.println("1.View\n2.Exit");
				System.out.println("Enter the Choice:");
				int n=sc.nextInt();
				if(n==1){
					st.stselect();
				}
				else if(n==2){
					System.out.println("Exiting!!");	
					break;
				}
				else {
				System.out.println("Invalid Option");
					}
				}
			}else{
			System.out.println("Not Registered: "+stuname);	
			System.out.println("Enter the Student Name:");
			String stname=sc.next();
			System.out.println("Enter the Student Email:");
			String stemail=sc.next();
			System.out.println("Enter the Student State:");
			String st_state=sc.next();
			System.out.println("Enter the Student Password:");
			String stpass=sc.next();
			int res=st.stinsert(stname,stemail,st_state,stpass);
			System.out.println((res>=1)?"Added":"NotAdded");
			if(res>=1) {
				int stu=st.stregister(stuname,stupass);
				System.out.println((res>=1)?"Registered":"NotRegistered");
			}
	   }	
		
		sc.close();		
		
	}
	}

