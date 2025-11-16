/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): 3MKtH9VV].  Một chương trình máy chủ cho phép kết nối qua TCP tại cổng 2207 (hỗ trợ thời gian liên lạc tối đa cho mỗi yêu cầu là 5s), yêu cầu xây dựng chương trình (tạm gọi là client) thực hiện kết nối tới server tại cổng 2207, sử dụng luồng byte dữ liệu (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự: 
//a.	Gửi chuỗi là mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;1D25ED92"
//b.	Nhận lần lượt hai số nguyên a và b từ server
//c.	Thực hiện tính toán tổng, tích và gửi lần lượt từng giá trị theo đúng thứ tự trên lên server
//d.	Đóng kết nối và kết thúc
package DataStream_use_DataInputStream;

import java.net.*;
import  java.io.*;
import java.util.*;

/**
 *
 * @author hoang
 */
public class B21DCCN763_3MKtH9VV_TongTich  {
    public static void main(String[] args)  throws  Exception{
        Socket socket = new Socket("203.162.10.109",2207);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        
        String request ="B21DCCN763;3MKtH9VV";
        out.writeUTF(request);
        out.flush();
        
        int a = in.readInt();
        int b = in.readInt();
        
        System.out.println(a +" " + b);
        
        int sum = a + b;
        int  tich = a * b;
        
        System.out.println(sum+ " "+ tich);
        // khi gui ket qua phai viet rieng tung dong vao write+kieu du lieu do 
        out.writeInt(sum);
        out.writeInt(tich);
        
        in.close();
        out.close();
        socket.close();
    }
    

}
