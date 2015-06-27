package org.profesorfalken.examples.base.processbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ThreadedMainWaitForOutput {
	public static final String RUTA = "C:\\test\\";

	public static void main(String[] args) {
		System.out.println("Comienza el programa");
		try {
			Process p = Runtime.getRuntime().exec(RUTA + "HolaMundo.bat");

			ReadProcessOutput stdOutput = new ThreadedMainWaitForOutput().new ReadProcessOutput(
					p.getInputStream());
			ReadProcessOutput errOutput = new ThreadedMainWaitForOutput().new ReadProcessOutput(
					p.getErrorStream());

			new Thread(stdOutput).start();
			new Thread(errOutput).start();

			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin del programa");
	}

	class ReadProcessOutput implements Runnable {
		private final InputStream inputStream;

		public ReadProcessOutput(InputStream inputStream) {
			this.inputStream = inputStream;
		}

		@Override
		public void run() {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					inputStream));
			String linea = "";
			try {
				while ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}