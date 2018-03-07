/**
 * Main Codefile for Wrangler Project, used to open up Erlang and pass commands based on selected option.
 *
 * @ Dennis Bettels
 * @ 26/01/2018
 */


import java.io.IOException;
import com.ericsson.otp.erlang.*;
public class Codefile {

	public static void main(String[] _args) throws IOException, OtpErlangExit, OtpErlangDecodeException {
		
			OtpNode node = new OtpNode("MainNode");
			OtpMbox mbox = node.createMbox("server");  

			OtpErlangObject o;
 			OtpErlangTuple msg;
			OtpErlangPid from;			 
 			OtpErlangAtom ok = new OtpErlangAtom("ok");

 			mbox.send(from,tuple);

			//communicate with rename_var by including them in the same package
			//receive input from html file.

	}
}
