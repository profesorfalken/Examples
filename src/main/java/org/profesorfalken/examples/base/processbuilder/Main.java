package org.profesorfalken.examples.base.processbuilder;

import java.io.IOException;

public class Main {

	public static final String RUTA = "C:\\test\\";

	public static void main(String[] args) {
		System.out.println("Comienza el programa");
		try {
			Runtime.getRuntime().exec(RUTA + "HolaMundo.bat");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Fin del programa");
	}
}