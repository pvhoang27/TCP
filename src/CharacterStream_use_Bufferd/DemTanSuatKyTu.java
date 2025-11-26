//[Mã câu hỏi (qCode): bsUEW3hb].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng byte (BufferedWriter/BufferedReader) theo kịch bản sau: 
//a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;BAA62945"
//b.	Nhận một chuỗi ngẫu nhiên từ server
//Ví dụ: dgUOo ch2k22ldsOo
//c.	Liệt kê các ký tự (là chữ hoặc số) xuất hiện nhiều hơn một lần trong chuỗi và số lần xuất hiện của chúng và gửi lên server
//Ví dụ: d:2,O:2,o:2,2:3,
//d.	Đóng kết nối và kết thúc chương trình.
package CharacterStream_use_Bufferd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class DemTanSuatKyTu {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String request = "B22DCCN008;bsUEW3hb";
        out.write(request);
        out.newLine();
        out.flush();
        
        String a = in.readLine().trim().replace(" ", "");
        System.out.println(a);
        
        int [] cnt = new int [256];
        String kq ="";
        for(int i = 0 ; i < a.length(); i++){
            char c = a.charAt(i);
            cnt[c] ++;
        }
        for(int i = 0 ; i < a.length(); i++){
            char c =a.charAt(i);
            if(cnt[c] > 1 ){
                kq+= (c +":" +cnt[c] +",");
                cnt[c] = 0 ;
            }
        }
        out.write(kq);
        out.newLine();
        out.flush();
        
        in.close(); out.close();socket.close();
    }
}
