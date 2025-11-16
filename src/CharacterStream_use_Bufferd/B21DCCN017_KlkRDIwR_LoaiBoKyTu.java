/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): KlkRDIwR].  [Loại bỏ ký tự đặc biệt, trùng và giữ nguyên thứ tự xuất hiện] Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác tới server sử dụng các luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản dưới đây:
//a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;7D6265E3"
//b.	Nhận một chuỗi ngẫu nhiên từ server
//c.	Loại bỏ ký tự đặc biệt, số, ký tự trùng và giữ nguyên thứ tự xuất hiện của ký tự. Gửi chuỗi đã được xử lý lên server.
//d.	Đóng kết nối và kết thúc chương trình
package CharacterStream_use_Bufferd;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class B21DCCN017_KlkRDIwR_LoaiBoKyTu {
    public static void main(String[] args) throws  Exception{
        Socket socket = new Socket("203.162.10.109",2206);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        //đẩy msv + qcode len sv 
        String request = "B21DCCN017;KlkRDIwR";
        out.write(request);
        out.newLine();
        out.flush();
        
        // nhận dữ liệu từ sv về 
        String data = in.readLine();
        System.out.println(data);
        
        // xử lý đề bài 
        String a = "";
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            // chỉ giữ lại ký tự chữ (A-Z, a-z)
            if (Character.isLetter(c)) {
                // nếu chưa có trong chuỗi kết quả thì thêm vào
                if (a.indexOf(c) == -1) {
                    a += c;
                }
            }
        }
        System.out.println(a);
        
        //gửi kết quả lên sv
        out.write(a);
        out.newLine();
        out.flush();
        
        // đóng connect 
        in.close();
        out.close();
        socket.close();
             
    }
}
