/*
[Mã câu hỏi (qCode): Q1BLs8F2].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2207 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu sinh viên xây dựng chương trình client để tương tác với server, sử dụng các luồng data (DataInputStream và DataOutputStream) để trao đổi thông tin theo thứ tự sau:
a. Gửi mã sinh viên và mã câu hỏi: Chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;D68C93F7".
b. Nhận một số nguyên hệ thập phân từ server. Ví dụ: 45
c. Chuyển đổi số nguyên nhận được sang hệ nhị phân và gửi chuỗi kết quả này lại cho server. Ví dụ: 45 sẽ thành chuỗi "101101"
d. Đóng kết nối và kết thúc chương trình.
 */
package DataStream_use_DataInputStream;
import java.io.*;
import java.net.*;
import java.util.*;
public class He10sangHe2 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2207);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        
        String request = "B21DCCN414;Q1BLs8F2";
        out.writeUTF(request);
        out.flush();
        
        int a = in.readInt();
        String bi = Integer.toBinaryString(a);
        
        out.writeUTF(bi);
        out.flush();
    }
}
