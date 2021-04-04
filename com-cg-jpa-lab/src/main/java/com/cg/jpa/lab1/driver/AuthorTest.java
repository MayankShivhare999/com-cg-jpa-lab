package com.cg.jpa.lab1.driver;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.cg.jpa.lab1.bean.Author;
import com.cg.jpa.lab1.sevices.AuthorService;
import com.cg.jpa.lab1.sevices.AuthorServiceImpl;

public class AuthorTest {

	private static AuthorService authorservice = new AuthorServiceImpl();
	
	public static int menu() {
		Scanner kb = new Scanner(System.in);
		System.out.println("**************************************************");
		System.out.println("---Select Option---");
		System.out.println("1. Add Author");
		System.out.println("2. Display All Author");
		System.out.println("3. Display Author by Authod Id");
		System.out.println("4. Update Author by Author Id");
		System.out.println("5. Delete Author");
		System.out.println("6. Exit");
		System.out.println("**************************************************");
		return kb.nextInt();
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String fName = "";
		String mName = "";
		String lName = "";
		String phoneNo = "";
		Author author = new Author();
		int id = 0;
		int choice = menu();
		while(choice!=6) {
			switch(choice){
				case 1:
					System.out.println("Enter First Name : ");
					fName = kb.next();
					System.out.println("Enter Middle Name : ");
					mName = kb.next();
					System.out.println("Enter Last Name : ");
					lName = kb.next();
					System.out.println("Enter Phone Number : ");
					phoneNo = kb.next();
					author = new Author(fName, mName, lName, phoneNo);
					authorservice.addAuthor(author);
					System.out.println("Inserted...");
					choice = menu();
					continue;
				case 2:
					List<Author> list = authorservice.getAuthors();
					Collections.sort(list);
					list.forEach(a-> System.out.println(a.getAuthorId()+" "+a.getFirstName()+" "+a.getMiddleName()+" "+a.getLastName()+" "+a.getPhoneNo()));
					choice = menu();
					continue;
				case 3:
					System.out.println("Enter Id : ");
					id = kb.nextInt();
					author = authorservice.getAuthor(id);
					if(author==null) {
						System.out.println("No Authour Found!!!\ntry with different id...");
					}
					else {
						System.out.println(author.getAuthorId()+"\t"+author.getFirstName()+"\t"+author.getMiddleName()+"\t"+author.getLastName()+"\t"+author.getPhoneNo());
					}
					choice = menu();
					continue;
				case 4:
					System.out.println("Enter Id : ");
					id = kb.nextInt();
					System.out.println("Enter First Name : ");
					fName = kb.next();
					System.out.println("Enter Middle Name : ");
					mName = kb.next();
					System.out.println("Enter Last Name : ");
					lName = kb.next();
					System.out.println("Enter Phone Number : ");
					phoneNo = kb.next();
					author = new Author(fName, mName, lName, phoneNo);
					authorservice.updateAuthor(id, author);
					System.out.println("Updated");
					choice = menu();
					continue;
				case 5:
					id = kb.nextInt();
					author = authorservice.getAuthor(id);
					if(author==null) {
						System.out.println("No such user found!!!");
					}
					else {
						authorservice.deleteAuthor(id);
						System.out.println("Deleted...");
					}
					choice = menu();
					continue;
				case 6: 
					System.out.println("He");
					choice = 6;
					continue;
			}				
		}
		System.out.println("Thank You");
	}
}
