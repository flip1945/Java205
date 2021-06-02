package ex.io;

import java.io.File;

public class FileMove {

	public static void main(String[] args) {
		
		File myFile = new File("D:"+File.separator+"myJava"+File.separator+"origin.pdf");
//		File myFile = new File("D:\\myJava", "origin.pdf");
		System.out.println(myFile);
		
		if (!myFile.exists()) {
			System.out.println("파일이 존재하지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		
		// 새로운 폴더를 생성 : 경로 생성 -> 생성
		
		File newDir = new File("D:\\yourJava");
		
		if (!newDir.exists()) {
			// 폴더 생성
			newDir.mkdir();
			System.out.println("Exists : " + newDir.exists());
		}
		
		// 이동할 경로와 파일 이름
		File newFile = new File(newDir, myFile.getName());
		// 이동
		myFile.renameTo(newFile);
		
		if (newFile.exists()) {
			System.out.println("파일 이동 성공");
		} else {
			System.out.println("파일 이동 실패");
		}
		
	}
}
