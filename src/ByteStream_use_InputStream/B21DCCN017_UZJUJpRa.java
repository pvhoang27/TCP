/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): UZJUJpRa].  Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu xây dựng chương trình client thực hiện kết nối tới server sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:
//    a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;76B68B3B".
//    b. Nhận dữ liệu từ server là một chuỗi các giá trị số nguyên được phân tách bởi ký tự ",". Ví dụ: 5,10,20,25,50,40,30,35.
//    c. Tìm chuỗi con tăng dần dài nhất và gửi độ dài của chuỗi đó lên server theo format "chuỗi tăng dài nhất; độ dài". Ví dụ: 5,10,20,25,50;5
//    d. Đóng kết nối và kết thúc chương trình.
package ByteStream_use_InputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class B21DCCN017_UZJUJpRa {
    public static void main(String[] args) throws Exception{
        // khai báo luồng
        Socket socket = new Socket("203.162.10.109",2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        // khai báo msv + qcode rồi đẩy lên sv
        String request = "B21DCCN017;UZJUJpRa";
        out.write(request.getBytes());
        out.flush();
        
        // nhận dữ liệu từ sv về 
        String data = in.readLine();
        System.out.println(data);
        
        
        
    }
}
