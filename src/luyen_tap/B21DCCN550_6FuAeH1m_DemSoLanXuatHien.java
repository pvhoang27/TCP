/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): 6FuAeH1m].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng byte (BufferedWriter/BufferedReader) theo kịch bản sau: 
//a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;BAA62945"
//b.	Nhận một chuỗi ngẫu nhiên từ server
//Ví dụ: dgUOo ch2k22ldsOo
//c.	Liệt kê các ký tự (là chữ hoặc số) xuất hiện nhiều hơn một lần trong chuỗi và số lần xuất hiện của chúng và gửi lên server
//Ví dụ: d:2,O:2,o:2,2:3,
//d.	Đóng kết nối và kết thúc chương trình.
package luyen_tap;
import java.net.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author hoang
 */
public class B21DCCN550_6FuAeH1m_DemSoLanXuatHien {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        String request = "B21DCCN550;6FuAeH1m";
        out.write(request);
        out.newLine();
        out.flush();
        
        String s = in.readLine().trim().replaceAll("\\s", "");
        System.out.println(s);
        
        String result  = "";
        int [] cnt = new int[256];
        // dau tien la dem so lan 
        for(int i = 0 ; i < s.length(); i++){
           char c = s.charAt(i);
           cnt[c] ++;
           
  
        }
        // in ra phan tu do + so lan xuat hien
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            // neu so lan > 1 thi bat dau in ra 
            if(cnt[c] > 1 ){
               result += c + ":" +cnt[c] +",";
               cnt[c] = 0; // reset no de ko in lai
           }
        }
         System.out.println(result);
         
         out.write(result);
         out.newLine();
         out.flush();

    }
}
