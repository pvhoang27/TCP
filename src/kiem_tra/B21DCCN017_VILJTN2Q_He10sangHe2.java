/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): VILJTN2Q].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2207 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu sinh viên xây dựng chương trình client để tương tác với server, sử dụng các luồng data (DataInputStream và DataOutputStream) để trao đổi thông tin theo thứ tự sau:
//a. Gửi mã sinh viên và mã câu hỏi: Chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;D68C93F7".
//b. Nhận một số nguyên hệ thập phân từ server. Ví dụ: 45
//c. Chuyển đổi số nguyên nhận được sang hệ nhị phân và gửi chuỗi kết quả này lại cho server. Ví dụ: 45 sẽ thành chuỗi "101101"
//d. Đóng kết nối và kết thúc chương trình.
package kiem_tra;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class B21DCCN017_VILJTN2Q_He10sangHe2  {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2206);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        // gửi code + msv lên sv 
        String request = "B21DCCN017;VILJTN2Q";
        out.writeUTF(request);
        out.flush();
        
        //nhận data từ sv về 
        int a = in.readInt();
        System.out.println(a);
        
        // xử lý đề bài
        String s = Integer.toBinaryString(a);
        System.out.println(s);
        
        // gửi kêt quả lên sv
        out.writeUTF(s);
        out.flush();
        
        // đóng connect 
        in.close();
        out.close();
        socket.close();
    }
}
