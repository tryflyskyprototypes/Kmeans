package com.tryflysky.kmeans.alltest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tryflysky.kmeans.utils.BlockSorterTest;
import com.tryflysky.kmeans.utils.SheetTranslatorTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	
	BlockSorterTest.class, 
	SheetTranslatorTest.class, 
	

})



public class AllTests {

}
