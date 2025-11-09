/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CharacterStream_use_Bufferd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class VFixiRi7_B21DCCN132 {
    public static void main(String[] args) throws Exception{
        
        // khai báo socket và phuong thuc 
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        // khai bao msv + qcode roi gui len sv 
        String request = "B21DCCN132;VFixiRi7";
        out.write(request);
        out.newLine();
        out.flush();
        
        // nhan du lieu
        String s = in.readLine();
        // in ra nhìn cho dễ
        System.out.println(s);
        
        // xử lý bài toán
        String ans = "" ;// tao 1 cai mang de add ket qua , dung string nhe 
        for(int i = 0 ;  i < s.length(); i ++){
            char c = s.charAt(i); // lấy từng kí tự từ string ra
            //chỉ giữ lại kí tự ( bỏ số + kí tự db)
            if (Character.isLetter(c)){
                if(ans.indexOf(c) == - 1){
                    ans += c ;
                }
            }
        }   
        System.out.println(ans);
        // gửi lên sv
        out.write(ans);
        out.newLine();
        out.flush();
        
        // thêm đóng kết nối vào cho chắc
        in.close();
        out.close();
        socket.close();
        
        
    }
}
