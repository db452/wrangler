import java.io.*;


public class Write {

    private static String oldVar;
    private static String arity;
    private static String newVar;
    public static void main(String[] args)
    {
        String classPath = ".:/usr/lib/erlang/lib/jinterface-1.8/priv/OtpErlang.jar";
        try {
            runProcess("javac -classpath " + classPath +  " Codefile.java ");
          } catch (Exception e) {
            e.printStackTrace();
          }
    };

    private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
      }

      private static void printLines(String name, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(name + " " + line);
        }
      }

    private void setoldVar(String oldVar){
        this.oldVar=oldVar;
    };

    private void setArity(String arity){
        this.arity=arity;
    };

    private void setnewVar(String oldVar){
        this.newVar=newVar;
    };
}