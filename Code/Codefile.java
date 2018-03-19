/**
 * Main Codefile for Wrangler Project, used to open up Erlang and pass commands based on selected option.
 *
 * @ Dennis Bettels
 * @ 26/01/2018
 */


import java.io.IOException;
import com.ericsson.otp.erlang.*;
public class Codefile {

	private static OtpSelf client;
	private static OtpPeer server;
	private static OtpConnection connection;

	public static void main(String[] args) throws IOException, OtpErlangExit, OtpErlangDecodeException, OtpAuthException {
		
		

		
		client = new OtpSelf("client", "cookie");
		server = new OtpPeer("server@db-VirtualBox");
		connection = client.connect(server);
		
		invokeWrangler();
		renameFunction();
		stopWrangler();
	}
	
	private static void invokeWrangler() throws IOException,OtpAuthException, OtpErlangExit, OtpErlangDecodeException {

		connection.sendRPC("api_wrangler", "start", startArgs());
		OtpErlangObject response = connection.receiveMsg().getMsg();
		System.out.println(response);



	}

	private static void renameFunction() throws IOException,OtpAuthException, OtpErlangExit, OtpErlangDecodeException{

		String fileLoc = "/home/db/Desktop/test.erl";
		String oldVar = "blobLoop";
		int arity = 0;
		String newVar = "fLoop";
		String emacs = "/usr/bin/emacs"; //Please replace with emacs (or eclipse) location!
		
		connection.sendRPC("api_wrangler", "rename_fun", renamefunArgs(fileLoc, oldVar, arity, newVar, emacs));
		OtpErlangObject response1 = connection.receiveMsg().getMsg();
		System.out.println(response1);

	}

	private static void stopWrangler() throws IOException,OtpAuthException, OtpErlangExit, OtpErlangDecodeException{

		connection.sendRPC("api_wrangler", "stop", startArgs());
		OtpErlangObject response = connection.receiveMsg().getMsg();
		System.out.println(response);

	}
	
	
	private static OtpErlangObject[] startArgs() {
		return new OtpErlangObject[] { 

		};
	}

	private static OtpErlangObject[] renamefunArgs(String fileLoc, String oldVar, int arity, String newVar, String emacs){

		return new OtpErlangObject[] { 
			new OtpErlangString(fileLoc),
			new OtpErlangAtom(oldVar),
			new OtpErlangInt(arity),
			new OtpErlangAtom(newVar),
			new OtpErlangList(emacs)
		};

	} 


}

