package sec;
import java.io.*;
import java.net.*;
public class udps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket skt=null;
		try {
skt=new DatagramSocket(6788);
byte[] bu=new byte[100000];
while(true) {
	DatagramPacket req=new DatagramPacket(bu,bu.length);
	skt.receive(req);
	String[] message=(new String(req.getData())).split(" ");
	byte[] sendmsg=(message[1]+"Severed processed").getBytes();
	DatagramPacket rep=new DatagramPacket(sendmsg,sendmsg.length,req.getAddress(),req.getPort());
	skt.send(rep);
}

	}catch(Exception e) {}

}
}