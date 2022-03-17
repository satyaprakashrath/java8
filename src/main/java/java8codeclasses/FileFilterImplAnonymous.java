package java8codeclasses;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import java8interfaces.FileFilter;

public class FileFilterImplAnonymous {
	
	private Object[] filterFiles(File[] files) {
		FileFilter filter = new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return file.getName().endsWith(".java");
			}
		};
		
		List filtered = new ArrayList<File>();
		int counter = 0;
		for(File file : files) {
			if(filter.accept(file)) {
				System.out.println("Inside loop for file:"+file.getName());
				filtered.add(file);
				counter++;
			}
		}
		System.out.println("filtered: ");
		return filtered.toArray();
	}
	
	public static void main(String[] args) {
		FileFilterImplAnonymous filterFiles = new FileFilterImplAnonymous();
		File dir = new File("/Users/satya/Music");
		File[] filesBefore = dir.listFiles();
		System.out.println("# Files before filter:"+filesBefore.length);
		Object[] files = filterFiles.filterFiles(filesBefore);
		System.out.println("# Files after filter:"+files.length);
	}

}
