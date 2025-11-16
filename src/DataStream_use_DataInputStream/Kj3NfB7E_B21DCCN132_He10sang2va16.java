/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): Kj3NfB7E].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2207 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu sinh viên xây dựng chương trình client để tương tác với server, sử dụng các luồng data (DataInputStream và DataOutputStream) để trao đổi thông tin theo thứ tự sau:
//a. Gửi mã sinh viên và mã câu hỏi: Chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;D68C93F7".
//b. Nhận một số nguyên hệ thập phân từ server. Ví dụ:: 15226.
//c. Chuyển đổi số nguyên nhận được sang hệ nhị phân và thập lục phân, ghép thành chuỗi và gửi lên server. Ví dụ: 15226 sẽ thành "11101101111010;3B7A"
//d. Đóng kết nối: Kết thúc chương trình sau khi gửi kết quả chuyển đổi.
package DataStream_use_DataInputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class Kj3NfB7E_B21DCCN132_He10sang2va16 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        // gui msv + qcode len sv
        String request = "B21DCCN132;Kj3NfB7E";
        out.writeUTF(request);
        out.flush();
        
        // nhan du lieu tu sv ve 
        int a = in.readInt();
        System.out.println(a);
        
        // xu ly bai toan 
        String decToBi = Integer.toBinaryString(a);
        System.out.println(decToBi);
        String decToHex = Integer.toHexString(a).toUpperCase();
        System.out.println(decToHex);
        
        // gui len sv
        String result = decToBi +";" + decToHex;
        System.out.println(result);
        out.writeUTF(result);
        out.flush();
        
        // dong ket noi
        in.close();
        out.close();
        socket.close();
        
    }
}


//[Mã câu hỏi (qCode): Kj3NfB7E].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2207 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu sinh viên xây dựng chương trình client để tương tác với server, sử dụng các luồng data (DataInputStream và DataOutputStream) để trao đổi thông tin theo thứ tự sau:
//a. Gửi mã sinh viên và mã câu hỏi: Chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;D68C93F7".
//b. Nhận một số nguyên hệ thập phân từ server. Ví dụ:: 15226.
//c. Chuyển đổi số nguyên nhận được sang hệ nhị phân và thập lục phân, ghép thành chuỗi và gửi lên server. Ví dụ: 15226 sẽ thành "11101101111010;3B7A"
//d. Đóng kết nối: Kết thúc chương trình sau khi gửi kết quả chuyển đổi.