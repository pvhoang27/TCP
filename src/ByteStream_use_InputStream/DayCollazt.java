/*
[Mã câu hỏi (qCode): nu28E4tL].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2206 (thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s).
Yêu cầu là xây dựng một chương trình client tương tác tới server ở trên sử dụng các luồng byte (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 
a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;2B3A6510"
b.	Nhận dữ liệu từ server là một số nguyên n nhỏ hơn 400. Ví dụ: 7
c.	Thực hiện các bước sau đây để sinh ra chuỗi từ số nguyên n ban đầu và gửi lên server.
        Bắt đầu với số nguyên nn:
            Nếu n là số chẵn, chia nn cho 2 để tạo ra số tiếp theo trong dãy.
            Nếu n là số lẻ và khác 1, thực hiện phép toán n=3*n+1 để tạo ra số tiếp theo.
        Lặp lại quá trình trên cho đến khi n=1, tại đó dừng thuật toán.
Kết quả là một dãy số liên tiếp, bắt đầu từ n ban đầu, kết thúc tại 1 và độ dài của chuỗi theo format "chuỗi kết quả; độ dài"  Ví dụ: kết quả với n = 7 thì dãy: 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1; 17;  
d.	Đóng kết nối và kết thúc chương trình.
 */
package ByteStream_use_InputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DayCollazt {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2206);
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        
        String request = "B22DCCN090;nu28E4tL";
        out.write(request.getBytes());
        out.flush();
        
        byte[] buffer = new byte[1024];
        int n = in.read(buffer);
        String b = new String(buffer, 0, n);
        int c =  Integer.parseInt(b);
        System.out.println(c);
        String kq = "";
        int cnt = 0 ;
        
        while(true){
            if(cnt == 0 ) kq += c;
            cnt++;
            if(c  == 1 ) break;
            else {
                if(c % 2 ==0 ){
                    c = c / 2 ;
                    kq += " " + c;
                }else{
                    c = 3*c +1;
                    kq += " " + c;
                }
            } 
        }
        String kq2 = kq +"; " + cnt;
        System.out.println(kq2);
        
        out.write(kq2.getBytes());
        out.flush();
        
    }
}
