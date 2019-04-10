/**
 * 
 */
package com.madan.compilerutil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author madan Date Apr 9, 2019
 *
 */
public class MemoryJavaCompilerTest {

	private final static MemoryJavaCompiler compiler = new MemoryJavaCompiler();

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final String source = "public class Test {\n" + "public static String testMethod(String name) {\n" + "\treturn \"Hello \" + name;\n" + "}\n}\n";
		final Method greeting = compiler.compileStaticMethod("testMethod", "Test", source);
		final Object result = greeting.invoke(null, "madan");
		System.out.println(result.toString());
	}

}
