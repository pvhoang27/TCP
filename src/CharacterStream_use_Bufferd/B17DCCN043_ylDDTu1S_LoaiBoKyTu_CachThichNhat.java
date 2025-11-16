/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): ylDDTu1S].  [Loại bỏ ký tự đặc biệt, trùng và giữ nguyên thứ tự xuất hiện] Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác tới server sử dụng các luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản dưới đây:
//a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;7D6265E3"
//b.	Nhận một chuỗi ngẫu nhiên từ server
//c.	Loại bỏ ký tự đặc biệt, số, ký tự trùng và giữ nguyên thứ tự xuất hiện của ký tự. Gửi chuỗi đã được xử lý lên server.
//d.	Đóng kết nối và kết thúc chương trình
package CharacterStream_use_Bufferd;

import java.net.*;
import  java.util.*;
import java.io.*;

/**
 *
 * @author hoang
 */
public class B17DCCN043_ylDDTu1S_LoaiBoKyTu_CachThichNhat {
    public static void main(String[] args) throws  Exception{
        Socket socket = new Socket("203.162.10.109",2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        String request = "B17DCCN043;ylDDTu1S";
        out.write(request);
        out.newLine();
        out.flush();
        
        String s = in.readLine();
        System.out.println(s);
        //tao ra 1 mang boolean check xem no da xuat hien chua 
        boolean[] used = new boolean[256];
        String result = "";
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            // chi lay chu cai 
            if(Character.isLetter(c)){
                // neu chua xuat hien
                if(!used[c]) {
                    result += c;
                    used[c] = true ; // danh dau da dung 
                }
            }
        }
        System.out.println(result);
        
        out.write(result);
        out.newLine();
        out.flush();
         
    }
}
