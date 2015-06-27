package org.profesorfalken.examples.base.processbuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;

public class MainProcessBuilder {
	public static final String RUTA = "C:\\test\\";

	public static void main(String[] args) {
		System.out.println("Comienza el programa");
		try {
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", RUTA,
					"HelloWorld.bat");
			pb.directory(new File(RUTA));

			Map<String, String> env = pb.environment();
			for (final Entry<String, String> entry : env.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}

			env.put("MiVariableEntorno", "UnValor");

			Process p = pb.start();

			MainProcessBuilder.ReadProcessOutput stdOutput = new MainProcessBuilder().new ReadProcessOutput(
					p.getInputStream());
			MainProcessBuilder.ReadProcessOutput errOutput = new MainProcessBuilder().new ReadProcessOutput(
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