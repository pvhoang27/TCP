/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyen_tap;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class tong {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2206 );
        OutputStream out = socket.getOutputStream();
        InputStream in =  socket.getInputStream();
        
        String request = "B22DCCN019;FDTXvOox";
        out.write(request.getBytes());
        out.flush();
        
        byte [] buffer = new byte[1024];
        int n = in.read(buffer);
        String a = new String(buffer, 0, buffer.length).trim();
        System.out.println(a);
        String [] part = a.split("\\|");
        long  sum = 0; 
        for(String b : part){
            int c = Integer.parseInt(b);
            sum += c ;
        }
        System.out.println(sum);
        String h = "" + sum;
        out.write(h.getBytes());
        out.flush();
        
    }
}
