/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//[Mã câu hỏi (qCode): jHma50N3].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2206 (thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s).
//Yêu cầu là xây dựng một chương trình client tương tác tới server ở trên sử dụng các luồng byte (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 
//a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;2B3A6510"
//b.	Nhận dữ liệu từ server là một số nguyên n nhỏ hơn 400. Ví dụ: 7
//c.	Thực hiện các bước sau đây để sinh ra chuỗi từ số nguyên n ban đầu và gửi lên server.
//        Bắt đầu với số nguyên nn:
//            Nếu n là số chẵn, chia nn cho 2 để tạo ra số tiếp theo trong dãy.
//            Nếu n là số lẻ và khác 1, thực hiện phép toán n=3*n+1 để tạo ra số tiếp theo.
//        Lặp lại quá trình trên cho đến khi n=1, tại đó dừng thuật toán.
//Kết quả là một dãy số liên tiếp, bắt đầu từ n ban đầu, kết thúc tại 1 và độ dài của chuỗi theo format "chuỗi kết quả; độ dài"  Ví dụ: kết quả với n = 7 thì dãy: 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1; 17;  
//d.	Đóng kết nối và kết thúc chương trình.
package ByteStream_use_InputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class jHma50N3_B21DCCN132 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        String request = "B21DCCN393;jHma50N3";
        out.write(request.getBytes());
        
        byte [] buffer = new byte[1024];
        int length = in.read(buffer);
        String received = new String(buffer, 0, buffer.length);
        System.out.println(received);
        
        // xu ly bai toan
        Long n = Long.parseLong(received.trim());
        int cnt = 0 ;
        String a = "";
        while (true) {            
            if(cnt == 0 )  a = a + n;
            else  a = a + " " + n;
            cnt ++;
            
            if( n == 1 ) break;
            if(n % 2 == 0 )  n = n / 2 ;
            else n = 3*n + 1;
        }
        System.out.println(a );
        String result = a +"; " +  cnt;
        System.out.println(result);
        
        // gui len sv
        out.write(result.getBytes());
        out.flush();  
   
    }
}
//[Mã câu hỏi (qCode): jHma50N3].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2206 (thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s).
//Yêu cầu là xây dựng một chương trình client tương tác tới server ở trên sử dụng các luồng byte (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 
//a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;2B3A6510"
//b.	Nhận dữ liệu từ server là một số nguyên n nhỏ hơn 400. Ví dụ: 7
//c.	Thực hiện các bước sau đây để sinh ra chuỗi từ số nguyên n ban đầu và gửi lên server.
//        Bắt đầu với số nguyên nn:
//            Nếu n là số chẵn, chia nn cho 2 để tạo ra số tiếp theo trong dãy.
//            Nếu n là số lẻ và khác 1, thực hiện phép toán n=3*n+1 để tạo ra số tiếp theo.
//        Lặp lại quá trình trên cho đến khi n=1, tại đó dừng thuật toán.
//Kết quả là một dãy số liên tiếp, bắt đầu từ n ban đầu, kết thúc tại 1 và độ dài của chuỗi theo format "chuỗi kết quả; độ dài"  Ví dụ: kết quả với n = 7 thì dãy: 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1; 17;  
//d.	Đóng kết nối và kết thúc chương trình.
