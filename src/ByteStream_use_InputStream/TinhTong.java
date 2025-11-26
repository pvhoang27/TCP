//[Mã câu hỏi (qCode): mMMcW2g0].  Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). 
//Yêu cầu xây dựng chương trình client thực hiện kết nối tới server trên sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 
//a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;C64967DD"
//b.	Nhận dữ liệu từ server là một chuỗi gồm các giá trị nguyên được phân tách với nhau bằng  "|"
//Ex: 2|5|9|11
//c.	Thực hiện tìm giá trị tổng của các số nguyên trong chuỗi và gửi lên server
//Ex: 27
//d.	Đóng kết nối và kết thúc
package ByteStream_use_InputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class TinhTong {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2206);
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        String request = "B22DCCN008;mMMcW2g0";
        out.write(request.getBytes());
        out.flush();
        
        byte[] buffer = new byte[1024];
        int n = in.read(buffer);
        String s = new String(buffer, 0, n).trim();
        System.out.println(s);
        int sum = 0 ;
        String []part = s.split("\\|");
        for(String h : part){
            int k = Integer.parseInt(h);
            sum += k;
        }
        System.out.println(sum );
        String kq = "" + sum;
        out.write(kq.getBytes());
        out.flush();
        
    }
}
