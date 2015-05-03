package org.profesorfalken.examples.base.processbuilder;

import java.io.IOException;

public class MainWaitFor {

	public static final String RUTA = "C:\\test\\";

	public static void main(String[] args) {
		System.out.println("Comienza el programa");
		try {
			Process p = Runtime.getRuntime().exec(RUTA + "HolaMundo.bat");
			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin del programa");
	}
}