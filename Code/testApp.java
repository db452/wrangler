import java.applet.Applet;
import java.awt.Graphics;
import java.io.*;

public class testApp extends Applet {
    //require java.security.AllPermission, very unsafe
    public void start() {
        
            String classPath = ".:/usr/lib/erlang/lib/jinterface-1.8/priv/OtpErlang.jar";
            try {
                runProcess("javac -classpath " + classPath +  " Codefile.java ");
              } catch (Exception e) {
                e.printStackTrace();
              }
        
    }
    private void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
      }

      private void printLines(String name, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(name + " " + line);
        }
      }
}