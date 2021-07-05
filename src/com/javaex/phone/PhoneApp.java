package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList;
		int iCount;
		
		start();
		
		boolean flag = true;
		while(flag) {
			switch(menu()) {
				case "1":
					System.out.println("<1.리스트>");
					personList = phoneDao.getList();
					printList(personList);
					break;
				case "2":
					System.out.println("<2.등록>");
					iCount = phoneDao.insert(insertInfo());
					System.out.println("[" + iCount + "건 등록되었습니다.]");
					break;
				case "3":
					System.out.println("<3.수정>");
					iCount = phoneDao.update(updateInfo());
					System.out.println("[" + iCount + "건 수정되었습니다.]");
					break;
				case "4":
					System.out.println("<4.삭제>");
					System.out.print(">번호 : ");
					int personId = sc.nextInt();
					sc.nextLine();
					iCount = phoneDao.delete(personId);
					System.out.println("[" + iCount + "건 삭제되었습니다.]");
					break;
				case "5":
					System.out.println("<5.검색>");
					personList = phoneDao.search(searchWord());
					printList(personList);
					break;
				case "6":
					flag = close();
					break;
				default:
					System.out.println("[다시 입력해주세요.]");
					break;
			}
			
			
		}
	}
	
	private static void start() {
		System.out.println("****************************************");
		System.out.println("*        전화번호 관리 프로그램        *");
		System.out.println("****************************************");
	}
	
	private static String menu() {
		System.out.println("\n" + "1.리스트  2.등록  3.수정  4.삭제  5.검색 6.종료");
		System.out.println("----------------------------------------");
		System.out.print(">메뉴번호: ");
		String sMenu = sc.nextLine();
		
		return sMenu;
	}
	
	private static boolean close() {
		System.out.println("****************************************");
		System.out.println("*              감사합니다              *");
		System.out.println("****************************************");
		
		sc.close();

		return false;
	}
	
	private static PersonVo insertInfo() {
		System.out.print("이름 > ");
		String name = sc.nextLine();
		
		System.out.print("휴대전화 > ");
		String hp = sc.nextLine();
		
		System.out.print("회사번호 > ");
		String company = sc.nextLine();
		
		PersonVo personVo = new PersonVo(name, hp, company);
		
		return personVo;
	}
	
	private static PersonVo updateInfo() {
		System.out.print("번호 > ");
		int personId = sc.nextInt();
		sc.nextLine();
		
		PersonVo personVo = insertInfo();
		
		personVo.setPersonId(personId);
		
		return personVo;
	}
	
	private static String searchWord() {
		System.out.print("검색어 > ");
		String searchWord = sc.nextLine();
		searchWord = "%" + searchWord + "%";
		return searchWord;
	}
	
	
	private static void printList(List<PersonVo> personList) {
		for(PersonVo personInfo : personList) {
			System.out.println(personInfo);
		}
	}
	
}
