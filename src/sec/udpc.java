package sec;
import java.io.*;
import java.net.*;
public class udpc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 DatagramSocket skt;
 try {
	 skt=new DatagramSocket();
	 String msg="text message";
	 byte[] b=msg.getBytes();
	 InetAddress host= InetAddress.getByName("127.0.0.1");
	 int sock=6788;
	 DatagramPacket req=new DatagramPacket(b,b.length,host,sock);
	 skt.send(req);
	 byte[] buffer=new byte[100000];
	 DatagramPacket rep=new DatagramPacket(buffer,buffer.length);
	 skt.receive(rep);
	 System.out.print("client received:"+new String(rep.getData()));
	 skt.close();
	 
 }catch(Exception e) {}
	}

}
