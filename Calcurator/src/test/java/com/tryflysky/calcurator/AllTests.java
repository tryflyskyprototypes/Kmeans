package com.tryflysky.calcurator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tryflysky.calcurator.helper.ExpressionDequeGeneratorTest;
import com.tryflysky.calcurator.helper.TranslatorTest;

@RunWith(Suite.class)
@SuiteClasses({

	ExpressionDequeGeneratorTest.class,
	AllOperatorCalcuratorTest.class,
	ParenthesesRemoverTest.class,
	OneOperatorCalculatorTest.class,
	TranslatorTest.class,
	
})
public class AllTests {

}
