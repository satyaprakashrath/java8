package java8codeclasses;

import java.io.File;
import java.io.FileFilter;

public class JavaFileFilterAnonymous {

	public static void main(String[] args) {

		FileFilter filter = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		};
		
		File dir = new File("/Users/satya");
		File[] files = dir.listFiles(filter);
		System.out.println(files.length);
		
		FileFilter filterLambda = (File pathName) -> pathName.getName().endsWith(".java");
		
		File[] filesLambda = dir.listFiles(filterLambda);
		System.out.println("Lambda:"+filesLambda.length);
	}

}
