/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyen_tap;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TinhTong {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2206 );
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        
        String request  = "B22DCCN032;9ElQgg2I";
        out.write(request.getBytes());
        out.flush();
        
        byte[] buffer = new byte[1024];
        int n = in.read(buffer);
        String a = new String(buffer, 0 , n).trim();
        System.out.println(a);
        
        String [] part = a.split("\\|");
        int sum = 0;
        for(int i = 0 ; i < part.length; i++){
            int b = Integer.parseInt(part[i]);
            sum += b;
        }
        String kq = "" + sum;
        out.write(kq.getBytes());
        out.flush();
        
    }
}
