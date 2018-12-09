package sec;

import java.io.*;
import java.net.*;
public class simpleS{
public final static int SOCKET_PORT=13267;
public final static String FILE="E:\\source1.txt" ;
public static void main(String[ ] args)throws IOException{
FileInputStream fis=null;
BufferedInputStream bis=null ;
OutputStream os=null ;
ServerSocket servsock=null ;
Socket sock=null ;
try{
servsock=new ServerSocket(SOCKET_PORT);
while(true){
System.out.println("Wai t i ng.   ");
try{
sock=servsock.accept();
System.out.println("accepted connetion:"+sock);
File myfile=new File(FILE);
byte[] mybyte= new byte[(int)myfile.length()];
fis=new FileInputStream(myfile);
bis=new BufferedInputStream(fis); 
bis.read(mybyte,0,mybyte.length);
os=sock.getOutputStream();
System.out.println("sending"+FILE+"("+mybyte.length+"bytes)");
os.write(mybyte, 0, mybyte.length);
os.flush();
System.out.println("Done.");
}finally{
	if(bis!=null )bis.close( ) ;
	if(os!=null )os.close( ) ;
	if(sock!=null )sock.close( ) ;
}}}finally{
	if(servsock!=null)servsock.close( ) ;
	}
	}
	}

