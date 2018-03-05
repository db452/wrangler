/**
 * Main Codefile for Wrangler Project, used to open up Erlang and pass commands based on selected option.
 *
 * @ Dennis Bettels
 * @ 26/01/2018
 */


import java.io.IOException;
import com.ericsson.otp.erlang.*;
import java.math.BigInteger;
public class Codefile {

	public static void main(String[] _args) throws IOException, OtpErlangExit, OtpErlangDecodeException {
		
			OtpNode node = new OtpNode("MainNode");
			OtpMbox mbox = node.createMbox("server");  

			OtpErlangObject o;
 			OtpErlangTuple msg;
			OtpErlangPid from;
			 
			BigInteger n;
 			OtpErlangAtom ok = new OtpErlangAtom("ok");

 			mbox.send(from,tuple);



	}
}
