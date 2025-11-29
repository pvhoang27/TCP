/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyen_tap;
import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author hoang
 */
public class B21DCCN238_lp0LW7lf_GiaiMaCaesar {
    
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        String request = "B21DCCN238;lp0LW7lf";
        out.writeUTF(request);
        out.flush();
        
        String  chuoi = in.readUTF();
        System.out.println(chuoi);
        int s = in.readInt();
        System.out.println(s);
        
        // xu ly de bai 
        String a = "";
        for(int i = 0 ; i < chuoi.length(); i++){
            char c =   chuoi.charAt(i);
            
            // xu ly chu hoa
            if(Character.isUpperCase(c)){
                // nho doan quan trong nay nhe 
                char ch = (char ) ('A'+ (c - 'A' - s + 26) % 26 );
                a += ch ;
            }
            // cong them 26 de no het am ? + cong them 26 cung ko thay doi ket qua vi ki tu co 26 ki tu thoi
            // xu ly chu thuong 
            else if(Character.isLowerCase(c)){
                // nho doan quan trong nay nhe 
                char ch = (char ) ('a'+ (c - 'a' - s + 26 ) % 26 );
                a += ch ;
            }
            // ky tu con lai : dac biet , so 
            else a += c;
        }
        System.out.println(a);
        
        out.writeUTF(a);
        out.flush();
        
        
       
    }
}
