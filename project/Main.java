package com.project;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Admin db=new Admin();
		
		System.out.println("\tStudent Admin Portal");
		//Inputs 
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Username:");
		String uname=sc.next();
		System.out.print("Enter the Password:");
		String upass=sc.next();
		
		if(db.adlog(uname,upass)) {
			while(true) {
				System.out.println("1.Add\n2.View\n3.Edit\n4.Remove\n5.Exit");
				System.out.println("Enter the Choice:");
				int n=sc.nextInt();
				if(n==1){
					System.out.println("Enter the Name:");
					String name=sc.next();
					System.out.println("Enter the Email:");
					String email=sc.next();
					System.out.println("Enter the Mark:");
					Float mark=sc.nextFloat();
					int res=db.insert(name,email,mark);
					System.out.println((res>=1)?"Added":"NotAdded");
				}
				else if(n==2){
					db.select();
				}
				else if(n==3){
				System.out.println("Enter the Email:");
				String email=sc.next();
				System.out.print("Enter the ID:");
				int id=sc.nextInt();
				System.out.print("Enter the Password to update:");
				String pass=sc.next();
				int res=db.update(email,pass,id);
				System.out.println((res>=1)?"Password Updated":"Password Not Updated");
				}
				else if(n==4){
				System.out.print("Enter the ID:");
				int id=sc.nextInt();
				int res=db.delete(id);	
				System.out.println((res>=1)?"Record deleted":"Record Not deleted");		
				}
				else if(n==5){
				System.out.println("Exiting!!");	
				break;
				}
				else {
				System.out.println("Invalid Option");
					}
				}
			}else{
			System.out.println("Invalid User"+uname);		
	   }	
		sc.close();		
	}
}


