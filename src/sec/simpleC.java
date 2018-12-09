package sec;
import java.io.*;
import java.net.*;
public class simpleC  {
	public final static int SOCKET_PORT=13267;
	public final static String server="127.0.0.1";
	public final static String FILER="E:\\source2.txt";
	public final static int filesize=6022386;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int bytesRead;
		int current=0;
		FileOutputStream fos=null ;
		BufferedOutputStream bos=null ;
		Socket sock=null;
	try {
		sock=new Socket(server,SOCKET_PORT);
		System.out.println(" Connect i ng. . . ");
		byte[ ]mybytearray=new byte[filesize];
		InputStream is=sock.getInputStream( ) ;
		fos=new FileOutputStream(FILER);
		bos=new BufferedOutputStream(fos);
		bytesRead=is.read(mybytearray,0,mybytearray.length);
		current=bytesRead;
		do{
			bytesRead=
			is.read(mybytearray,current,(mybytearray.length-current)) ;
			if(bytesRead>=0)current+=bytesRead;
			}while(bytesRead>1) ;
			bos.write(mybytearray,0,current);
			bos.flush( ) ;
			System.out.println(" Fi l e"+FILER
			+"downl oaded( "+current+"bytesread) " ) ;

	}finally{
		if(bos!=null )bos.close( ) ;
		if(fos!=null )fos.close( ) ;
		if(sock!=null )sock.close( ) ;}

	}

}
