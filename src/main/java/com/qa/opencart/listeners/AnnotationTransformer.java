package com.qa.opencart.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {
	// this method will be called when any test case is going to execute
	@Override
	public void transform(ITestAnnotation annotation, // this is the testng annotation
			Class testClass, // this is the test class where the test method is present
			Constructor testConstructor, // this is the constructor of the test class
			Method testMethod) { // this is the actual test method
		// set the retry analyzer class to ITestAnnotation
		annotation.setRetryAnalyzer(Retry.class);  // Retry is the class name which implements IRetryAnalyzer
	}
}