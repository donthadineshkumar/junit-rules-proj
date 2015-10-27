package com.junit.rules;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TemporaryFolderRule {
	
	@Rule
	public TemporaryFolder temp = new TemporaryFolder();

	
	@Test
	public void testTemp() throws IOException{
		File fi = temp.newFile("myfilex.txt");
		File fo = temp.newFolder("Pics");
		
		
	}
	
	
}
