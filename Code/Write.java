import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Write {

    public static void main(String[] args) throws IOException, InterruptedException {

        String[] command = { "code", };
        Process proc = new ProcessBuilder(command).start();
    }
}