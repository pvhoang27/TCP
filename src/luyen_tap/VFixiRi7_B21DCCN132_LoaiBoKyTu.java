/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): VFixiRi7].  [Loại bỏ ký tự đặc biệt, trùng và giữ nguyên thứ tự xuất hiện] Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác tới server sử dụng các luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản dưới đây:
//a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;7D6265E3"
//b.	Nhận một chuỗi ngẫu nhiên từ server
//c.	Loại bỏ ký tự đặc biệt, số, ký tự trùng và giữ nguyên thứ tự xuất hiện của ký tự. Gửi chuỗi đã được xử lý lên server.
//d.	Đóng kết nối và kết thúc chương trình
package luyen_tap;

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
public class VFixiRi7_B21DCCN132_LoaiBoKyTu {
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
//[Mã câu hỏi (qCode): VFixiRi7].  [Loại bỏ ký tự đặc biệt, trùng và giữ nguyên thứ tự xuất hiện] Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác tới server sử dụng các luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản dưới đây:
//a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;7D6265E3"
//b.	Nhận một chuỗi ngẫu nhiên từ server
//c.	Loại bỏ ký tự đặc biệt, số, ký tự trùng và giữ nguyên thứ tự xuất hiện của ký tự. Gửi chuỗi đã được xử lý lên server.
//d.	Đóng kết nối và kết thúc chương trình