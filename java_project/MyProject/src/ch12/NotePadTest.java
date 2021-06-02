package ch12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NotePadTest {
	
	// 저장 폴더 경로 설정
	public File setSaveFolder(Scanner scanner) {
		System.out.print("저장 폴더의 경로를 입력해주세요 : ");
		File saveFolder = new File(scanner.nextLine());
		
		if (saveFolder.exists()) {
			System.out.println("저장 폴더 경로 : " + saveFolder);
		} else {
			saveFolder.mkdir();
			System.out.println("저장 폴더 경로 : " + saveFolder);
			System.out.println("폴더 생성이 완료됐습니다.");
		}
		return saveFolder;
	}
	
	// 저장할 날짜, 제목, 메모 입력
	public ArrayList<String> setSaveMemo(Scanner scanner) {
		ArrayList<String> saveMemo = new ArrayList<String>();
	
		System.out.print("저장할 날짜를 입력해주세요 : ");
		saveMemo.add(scanner.nextLine());
		System.out.print("저장할 제목을 입력해주세요 : ");
		saveMemo.add(scanner.nextLine());
		System.out.print("저장할 메모를 입력해주세요 : ");
		saveMemo.add(scanner.nextLine());
		
		return saveMemo;
	}
	
	public void showSaveFolder(File saveFolder) {
		System.out.println("저장 폴더의 내용");
		for (File file : saveFolder.listFiles()) {
			if (file.isDirectory()) {
				System.out.println("[DIR]" + file);				
			} else if (file.isFile()) {
				System.out.println("[FILE]" + file);				
			}
		}
	}
	
	public void writeMemo(ArrayList<String> saveMemo, File saveNotePad) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(saveNotePad));
			
			for (String str : saveMemo) {
				bufferedWriter.write(str);
				bufferedWriter.newLine();
			}
			
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readMemo(File saveNotePad) {
		System.out.println("저장 메모의 내용");
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(saveNotePad));
			
			while (true) {
				String str = bufferedReader.readLine();
				if (str == null) {
					break;
				}
				System.out.println(str);
			}
			
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printMenu() {
		System.out.println("-----------------------");
		System.out.println("1. 저장 폴더 경로 설정");
		System.out.println("2. 메모 저장");
		System.out.println("3. 저장 폴더 내용 출력");
		System.out.println("4. 저장 메모 내용 읽기");
		System.out.println("5. 종료");
		System.out.println("-----------------------");
	}

	public static void main(String[] args) {
		
		NotePadTest notePad = new NotePadTest();
		
		Scanner scanner = new Scanner(System.in);
		
		int selection = 0;
		File saveFolder = null;
		
		while (true) {
			notePad.printMenu();
			System.out.print("메뉴 선택 >> ");
			selection = Integer.parseInt(scanner.nextLine());
			
			if (selection == 1) {
				// 저장 폴더 경로 설정
				saveFolder = notePad.setSaveFolder(scanner);				
			} else if(selection == 2) {
				// 저장 폴더 예외 처리
				if (saveFolder == null) {
					System.out.println("저장 폴더를 먼저 설정해주세요.");
					continue;
				}
				// 저장 날짜, 제목, 메모 입력
				ArrayList<String> saveMemo = notePad.setSaveMemo(scanner);
				// 저장 메모장 경로 설정
				File saveNotePad = new File(saveFolder, saveMemo.get(0) + "_" + saveMemo.get(1) + ".txt");
				// 저장 메모장 쓰기
				notePad.writeMemo(saveMemo, saveNotePad);
				System.out.println(saveNotePad.getName() + " 파일이 생성됐습니다.");
				System.out.println();				
			} else if (selection == 3) {
				// 저장 폴더 예외 처리
				if (saveFolder == null) {
					System.out.println("저장 폴더를 먼저 설정해주세요.");
					continue;
				}
				// 저장 폴더의 내용 출력
				notePad.showSaveFolder(saveFolder);				
			} else if (selection == 4) {
				// 저장 폴더 예외 처리
				if (saveFolder == null) {
					System.out.println("저장 폴더를 먼저 설정해주세요.");
					continue;
				}
				
				// 저장 메모 내용 읽기
				System.out.print("읽을 메모의 제목을 입력해주세요 : ");
				String memoTitle = scanner.nextLine();
				File readMemo = new File(saveFolder.getPath() + File.separator + memoTitle);
				if (readMemo.exists()) {
					notePad.readMemo(readMemo);			
				} else {
					System.out.println("잘못된 파일명입니다. 다시 입력해주세요.");
				}
			} else if (selection == 5) {
				break;
			} else {
				System.out.println("올바른 숫자를 입력해세요.");
			}
			
		}
		scanner.close();
	}
}
