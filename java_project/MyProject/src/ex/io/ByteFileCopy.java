package ex.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteFileCopy {

	public static void main(String[] args) {
		
		try {
			// 1. 파일의 바이너리 데이터를 읽어올 스트림 생성 : FileInputStream
			FileInputStream in = new FileInputStream("origin.pdf");
			// 2. 파일을 쓰기위한 스트림 생성 : FileOutputStream
			FileOutputStream out = new FileOutputStream("Copy.pdf");
			
			// 카피한 데이터의 크기
			int copyByte = 0;
			// 파일에서 읽어올 바이트 데이터
			int bData = 0;
			long startTime = System.currentTimeMillis();
			
			while (bData != -1) {
				bData = in.read();
				out.write(bData);
				copyByte++;
			}
			long endTime = System.currentTimeMillis();
			
			// 스트림 닫기
			in.close();
			out.close();
			
			System.out.println("복사완료. 복사된 바이트 사이즈 : " + copyByte + " Byte");
			System.out.println("실행 시간 : " + (endTime - startTime));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
