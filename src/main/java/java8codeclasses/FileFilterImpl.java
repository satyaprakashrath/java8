package java8codeclasses;

import java.io.File;
import java.io.FilenameFilter;

import java8interfaces.FileFilter;

public class FileFilterImpl implements FileFilter {

	@Override
	public boolean accept(File file) {
		System.out.println("File name is :"+file.getName());
		return file.getName().endsWith(".java");
	}
	

}
