package ex.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferFileCopy {

	public static void main(String[] args) {
		
		try {
			// 1. 파일의 바이너리 데이터를 읽어올 스트림 생성 : FileInputStream
			FileInputStream in = new FileInputStream("origin.pdf");
			// 2. 파일을 쓰기위한 스트림 생성 : FileOutputStream
			FileOutputStream out = new FileOutputStream("Copy2.pdf");
			
			// 카피한 데이터의 크기
			int copyByte = 0;
			// 파일에서 읽어올 바이트 데이터 배열
			byte[] buf = new byte[1024];
			// 읽어온 데이터 배열의 개수
			int readLen = 1024;
			long startTime = System.currentTimeMillis();
			
			while (readLen == 1024) {
				readLen = in.read(buf);
				out.write(buf, 0, readLen);
				copyByte += readLen;
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
