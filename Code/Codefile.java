/**
 * Main Codefile for Wrangler Project, used to open up Erlang and pass commands based on selected option.
 *
 * @ Dennis Bettels
 * @ 26/01/2018
 */


import java.io.IOException;

public class Codefile {

	public static void main(String[] args) {
		try {
			System.out.println("Opening Erlang");
			Runtime runTime = Runtime.getRuntime();
			Process process = runTime.exec("C:\\Program Files (x86)\\erl5.9\\bin\\werl.exe");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Closing Erlang");
			process.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
