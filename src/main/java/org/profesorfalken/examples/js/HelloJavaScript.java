package org.profesorfalken.examples.js;

import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class HelloJavaScript {
	public static void main(String[] args) throws Exception {
		// create a script engine manager
		ScriptEngineManager factory = new ScriptEngineManager();
		// create a JavaScript engine
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		// evaluate JavaScript code from String
		engine.eval("print('Hello JavaScript')");

		engine.eval(new FileReader(
				"src/main/java/org/profesorfalken/examples/js/sample.js"));
	}
}
