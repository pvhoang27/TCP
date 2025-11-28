//[Mã câu hỏi (qCode): tbiyHOzY].  [Loại bỏ ký tự đặc biệt, trùng và giữ nguyên thứ tự xuất hiện] Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác tới server sử dụng các luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản dưới đây:
//a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;7D6265E3"
//b.	Nhận một chuỗi ngẫu nhiên từ server
//c.	Loại bỏ ký tự đặc biệt, số, ký tự trùng và giữ nguyên thứ tự xuất hiện của ký tự. Gửi chuỗi đã được xử lý lên server.
//d.	Đóng kết nối và kết thúc chương trình
package CharacterStream_use_Bufferd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class lockytu {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2208 );
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String request = "B22DCCN019;tbiyHOzY";
        out.write(request);
        out.newLine();
        out.flush();
        
        String a= in.readLine();
        System.out.println(a);
        
        String kq ="";
        int [] cnt = new int[256];
        for(int i = 0 ; i < a.length(); i++){
            char c = a.charAt(i);
            cnt[c] ++;
        }
        for(int i = 0 ; i < a.length(); i++){
            char c = a.charAt(i);
            if(Character.isLetter(c) && cnt[c] > 0){
                kq += c;
                cnt[c] = 0;
            }
        }
        out.write(kq);
        out.newLine();
        out.flush();
    }
}
