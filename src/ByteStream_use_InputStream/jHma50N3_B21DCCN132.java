/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ByteStream_use_InputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class jHma50N3_B21DCCN132 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        String request = "B21DCCN393;jHma50N3";
        out.write(request.getBytes());
        
        byte [] buffer = new byte[1024];
        int length = in.read(buffer);
        String received = new String(buffer, 0, buffer.length);
        System.out.println(received);
        
        // xu ly bai toan
        Long n = Long.parseLong(received.trim());
        int cnt = 0 ;
        String a = "";
        while (true) {            
            if(cnt == 0 )  a = a + n;
            else  a = a + " " + n;
            cnt ++;
            
            if( n == 1 ) break;
            if(n % 2 == 0 )  n = n / 2 ;
            else n = 3*n + 1;
        }
        System.out.println(a );
        String result = a +"; " +  cnt;
        System.out.println(result);
        
        // gui len sv
        out.write(result.getBytes());
        out.flush();  
   
    }
}
