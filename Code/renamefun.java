/**
 * Main Codefile for Wrangler Project, used to open up Erlang and pass commands based on selected option.
 *
 * @ Dennis Bettels
 * @ 26/01/2018
 */

import java.applet.*;
import java.io.IOException;
import com.ericsson.otp.erlang.*;
public class renamefun extends Applet{

	private static OtpSelf client;
	private static OtpPeer server;
	private static OtpConnection connection;
	public static String oldVar;
	public static String stringArity;
	public static String newVar;
    public static int arity;
    private static final long serialVersionUID = 12345;

    
    public void startApp() throws IOException, OtpErlangExit, OtpErlangDecodeException, OtpAuthException {
		

		client = new OtpSelf("client", "cookie");
		server = new OtpPeer("server@db-VirtualBox");
		connection = client.connect(server);
        
        connection.sendRPC("api_wrangler", "start", startArgs());
		OtpErlangObject response = connection.receiveMsg().getMsg();
		System.out.println(response);

	}
	

	public void renameFunction(String olVar, String aritystring, String newVar) throws IOException,OtpAuthException, OtpErlangExit, OtpErlangDecodeException{

        arity = Integer.parseInt(aritystring);
        
        String fileLoc = "/home/db/Desktop/test.erl";
		String emacs = "/usr/bin/emacs"; //Please replace with emacs (or eclipse) location!
		
		connection.sendRPC("api_wrangler", "rename_fun", renamefunArgs(fileLoc, oldVar, arity, newVar, emacs));
		OtpErlangObject response1 = connection.receiveMsg().getMsg();
        System.out.println(response1);
        
        //connection.sendRPC("api_wrangler", "stop", startArgs());
		//OtpErlangObject response2 = connection.receiveMsg().getMsg();
		//System.out.println(response2);

	}

	
	
	private OtpErlangObject[] startArgs() {
		return new OtpErlangObject[] { 

		};
	}

	private OtpErlangObject[] renamefunArgs(String fileLoc, String oldVar, int arity, String newVar, String emacs){

		return new OtpErlangObject[] { 
			new OtpErlangString(fileLoc),
			new OtpErlangAtom(oldVar),
			new OtpErlangInt(arity),
			new OtpErlangAtom(newVar),
			new OtpErlangList(emacs)
		};

	} 


}
