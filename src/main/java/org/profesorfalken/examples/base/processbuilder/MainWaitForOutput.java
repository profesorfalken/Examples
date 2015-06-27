package org.profesorfalken.examples.base.processbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainWaitForOutput {
	public static final String RUTA = "C:\\test\\";

	public static void main(String[] args) {
		System.out.println("Comienza el programa");
		try {
			Process p = Runtime.getRuntime().exec(RUTA + "HolaMundo.bat");

			BufferedReader output = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			BufferedReader error = new BufferedReader(new InputStreamReader(
					p.getErrorStream()));
			String linea = "";

			while ((linea = output.readLine()) != null) {
				System.out.println(linea);
			}

			while ((linea = error.readLine()) != null) {
				System.out.println(linea);
			}

			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin del programa");
	}
}
