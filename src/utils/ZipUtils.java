package utils;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

	/**
	 * 压缩文件
	 *
	 * @param zipFileName 压缩后的zip包的目录.
	 * @param fileList    需要压缩的文件列表
	 */
	public static void compress(String zipFileName, List<String> fileList) {

		try {
			ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFileName)));
			zipOutputStream.setLevel(Deflater.BEST_COMPRESSION);

			for (String fileName : fileList) {
				File file = new File(fileName);
				zip(zipOutputStream, file);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	/**
	 * 解压文件.
	 *
	 * @param zipFileName
	 */
	public static String unZip(String zipFileName) {
		File file = new File(zipFileName);
		String parent = null;
		ZipInputStream zis = null;
		try {
			zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
			File outputFile = null;
			 parent = file.getParent();
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null && !entry.isDirectory()) {
				outputFile = new File(parent, entry.getName());
				if (!outputFile.exists()) {
					(new File(outputFile.getParent())).mkdirs();
				}

				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile));

				int b = -1;
				byte[] buffer = new byte[1024];
				while ((b = zis.read(buffer)) != -1) {
					bos.write(buffer, 0, b);
				}
				bos.close();
			}
			zis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parent;
	}


	/**
	 * 重命名.
	 * @param originName 源文件
	 * @param currentName 目标文件.
	 */
	public static Boolean rename(String originName, String currentName){
      File file = new File(originName);
      File currentFile = new File(currentName);
      if(file.renameTo(currentFile)){
      	return true;
      }
      return false;
	}

	/**
	 * 压缩的具体操作
	 */
	private static void zip(ZipOutputStream zipOutput, File file) throws IOException {
		ZipEntry zEntry = new ZipEntry(file.getName());
		zipOutput.putNextEntry(zEntry);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		byte[] buffer = new byte[1024];
		int read = 0;
		while ((read = bis.read(buffer)) != -1) {
			zipOutput.write(buffer, 0, read);
		}
		bis.close();
	}


}