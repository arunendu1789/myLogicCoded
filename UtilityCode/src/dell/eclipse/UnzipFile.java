package dell.eclipse;

/*
 * author Arunendu Ravi
 * 
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipFile {

public void unzipFile(String filePath){
		
		FileInputStream fis = null;
		ZipInputStream zipIs = null;
		ZipEntry entry = null;
		try {
			fis = new FileInputStream(filePath);
			zipIs = new ZipInputStream(new BufferedInputStream(fis));
			while((entry = zipIs.getNextEntry()) != null){
				try{
					byte[] tmp = new byte[4*1024];
					FileOutputStream fos = null;
					String opFilePath = "C:/"+entry.getName();
					System.out.println("Extracting file to "+opFilePath);
					fos = new FileOutputStream(opFilePath);
					int size = 0;
					while((size = zipIs.read(tmp)) != -1){
						fos.write(tmp, 0 , size);
					}
					fos.flush();
					fos.close();
				} catch(Exception ex){
					System.out.println("Some error is there in the Program!!!");
				}
			}
			zipIs.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
			UnzipFile file = new UnzipFile();
			file.unzipFile("‪‪C:/Users/ArunenduRavi/Desktop/Anurag.zip");
	}

}
