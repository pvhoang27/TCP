/*
 [Mã câu hỏi (qCode): uTXGgAQS].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng byte (BufferedWriter/BufferedReader) theo kịch bản sau: 
a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;EC4F899B"
b.	Nhận một chuỗi ngẫu nhiên là danh sách các một số tên miền từ server
Ví dụ: giHgWHwkLf0Rd0.io, I7jpjuRw13D.io, wXf6GP3KP.vn, MdpIzhxDVtTFTF.edu, TUHuMfn25chmw.vn, HHjE9.com, 4hJld2m2yiweto.vn, y2L4SQwH.vn, s2aUrZGdzS.com, 4hXfJe9giAA.edu
c.	Tìm kiếm các tên miền .edu và gửi lên server
Ví dụ: MdpIzhxDVtTFTF.edu, 4hXfJe9giAA.edu
d.	Đóng kết nối và kết thúc chương trình.
 */
package CharacterStream_use_Bufferd;
import java.net.*;
import java.util.*;
import java.io.*;
public class TimChuoiCoDuoiEdu {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2208);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String request = "B22DCCN104;uTXGgAQS";
        out.write(request);
        out.newLine();
        out.flush();
        
        String a = in.readLine();
        System.out.println(a);
        String [] part = a.split(",");
        String kq = "";
        for(String b : part ){
            // dung contains cung dc nma nen dung endwith
            if(b.endsWith(".edu")){
                kq += b.trim() +", ";
            }
            
        }
        System.out.println(kq);
        kq = kq.substring(0,kq.length()-2).trim();
        out.write(kq);
        out.newLine();
        out.flush();
        
        
    }
}
