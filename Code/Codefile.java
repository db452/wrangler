/**
 * Main Codefile for Wrangler Project, used to open up Erlang and pass commands based on selected option.
 *
 * @ Dennis Bettels
 * @ 26/01/2018
 */


import java.io.IOException;
import com.ericsson.otp.erlang.*;
public class Codefile {

	public static void main(String[] args) throws IOException {
		
			OtpNode node = new OtpNode("gurka");
			OtpMbox mbox = node.createMbox("server");  
			if (node.ping("remote",2000)) {
				System.out.println("remote is up");
			  }
			  else {
				System.out.println("remote is not up");
			 } 

	}
}
