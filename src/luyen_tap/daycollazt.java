/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyen_tap;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class daycollazt {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2206);
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        
        String request = "B22DCCN584;CjhnHG1l";
        out.write(request.getBytes());
        out.flush();
        
        byte[] buffer = new byte[1024];
        int n = in.read(buffer);
        String a = new String(buffer, 0, n);
        int b = Integer.parseInt(a);
        System.out.println(b);
        int cnt = 0 ; 
        String kq= "";
        while(true){
            if(cnt == 0 ) kq += b +" ";
            cnt ++;
            if(b == 1 ) break;
            else{
                if(b% 2 == 0){
                    b = b / 2;
                    kq += b + " ";
                }
                else{
                    b = b * 3 + 1;
                    kq += b + " ";
                }
            }
        }
        String kqe = kq.trim() + "; " + cnt;
        System.out.println(kqe);
        out.write(kqe.getBytes());
        out.flush();
                
        
    }
}
