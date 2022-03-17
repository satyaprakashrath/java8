package java8codeclasses;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import java8interfaces.FileFilter;

public class ListFilesWithFilter {

	public static void main(String[] args) {
		ListFilesWithFilter listFilesWithFilter = new ListFilesWithFilter();	
		FileFilter filter = new FileFilterImpl();
		File dir = new File("/Users/satya/Music");
		File[] filesBefore = dir.listFiles();
		System.out.println("# Files before filter:"+filesBefore.length);
		Object[] files = listFilesWithFilter.applyFilter(filesBefore, filter);
		System.out.println("# Files after filter:"+files.length);

	}
	
	private Object[] applyFilter(File[] files, FileFilter filter) {
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

}
