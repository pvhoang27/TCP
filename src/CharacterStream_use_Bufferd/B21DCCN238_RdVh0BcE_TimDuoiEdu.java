/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): RdVh0BcE].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng byte (BufferedWriter/BufferedReader) theo kịch bản sau: 
//a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;EC4F899B"
//b.	Nhận một chuỗi ngẫu nhiên là danh sách các một số tên miền từ server
//Ví dụ: giHgWHwkLf0Rd0.io, I7jpjuRw13D.io, wXf6GP3KP.vn, MdpIzhxDVtTFTF.edu, TUHuMfn25chmw.vn, HHjE9.com, 4hJld2m2yiweto.vn, y2L4SQwH.vn, s2aUrZGdzS.com, 4hXfJe9giAA.edu
//c.	Tìm kiếm các tên miền .edu và gửi lên server
//Ví dụ: MdpIzhxDVtTFTF.edu, 4hXfJe9giAA.edu
//d.	Đóng kết nối và kết thúc chương trình.
package CharacterStream_use_Bufferd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.Buffer;

/**
 *
 * @author hoang
 */
public class B21DCCN238_RdVh0BcE_TimDuoiEdu {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        // gửi msv + qcode len sv 
        String request = "B21DCCN238;RdVh0BcE";
        out.write(request);
        out.newLine();
        out.flush();
        
        // nhận data về ;
        String data = in.readLine().trim();
        System.out.println(data);
        
        // xử lý đề bài 
        String[] parts  = data.split(",");
        System.out.println(parts[0]);
        String result = "";
        for(String p : parts){
            System.out.println(p.trim());
            
            p = p.trim();
            if(p.endsWith(".edu")){
//                result += p; 
                // neu da co phan tu thi them dau phay vao
                if (!result.isEmpty()) result += ", "; 
                result += p; 
            } 
            
        }
        System.out.println(result);
        
        // gửi lên sv 
        out.write(result);
        out.newLine();
        out.flush();
        
        // dong sv 
        in.close();
        out.close();
        socket.close();
    }
}
