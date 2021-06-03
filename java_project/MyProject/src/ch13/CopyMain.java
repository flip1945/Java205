package ch13;

import java.io.File;
import java.util.Scanner;

public class CopyMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		File originFile = null;
		File copyDir = null;
		
		while (originFile == null || copyDir == null) {
			// 복사할 원본 파일의 경로 입력
			if (originFile == null) {
				System.out.print("복사할 파일의 경로를 입력해주세요 : ");
				originFile = new File(scanner.nextLine());				
			}
			
			if (!originFile.exists()) {
				System.out.println("올바르지 않은 경로입니다. 다시 입력해주세요.");
				originFile = null;
				continue;
			} else if (originFile.isDirectory()) {
				System.out.println("올바르지 않은 경로입니다. 파일을 입력해주세요.");
				originFile = null;
				continue;				
			}
			// 붙여넣을 디렉토리 경로 입력
			if (copyDir == null) {
				System.out.print("붙여넣을 경로를 입력해주세요 : ");
				copyDir = new File(scanner.nextLine());				
			}
			
			if (!copyDir.exists()) {
				System.out.println("올바르지 않은 경로입니다. 다시 입력해주세요.");
				copyDir = null;
				continue;
			} else if (!copyDir.isDirectory()) {
				System.out.println("올바르지 않은 경로입니다. 폴더를 입력해주세요.");
				originFile = null;
				continue;				
			}
		}
		
		CopyThread ct = new CopyThread(originFile, copyDir);
		
		ct.start();
		
		scanner.close();
		System.out.println("main 종료");
	}
}
