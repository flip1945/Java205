package ch13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyThread extends Thread {
	
	File originFile;
	File copyDir;
	
	public CopyThread(File originFile, File copyDir) {
		this.originFile = originFile;
		this.copyDir = copyDir;
	}

	@Override
	public void run() {
		try {
			FileInputStream in = new FileInputStream(originFile);
			FileOutputStream out = new FileOutputStream(new File(copyDir, "copy.pdf"));
			
			int readLen = 0;
			int copyByte = 0;
			byte[] buf = new byte[1024];
			
			while (true) {
				readLen = in.read(buf);
				if (readLen == -1) {
					break;
				}
				
				out.write(buf, 0, readLen);
				copyByte += readLen;
			}
			
			in.close();
			out.close();
			System.out.println("복사된 바이트 사이즈 : " + copyByte);
			System.out.println("복사완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
