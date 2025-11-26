//[Mã câu hỏi (qCode): UsLuWWET].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2207 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu sinh viên xây dựng chương trình client để tương tác với server, sử dụng các luồng data (DataInputStream và DataOutputStream) để trao đổi thông tin theo thứ tự sau:
//a. Gửi mã sinh viên và mã câu hỏi: Chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;D68C93F7".
//b. Nhận một số nguyên hệ thập phân từ server. Ví dụ:: 15226.
//c. Chuyển đổi số nguyên nhận được sang hệ nhị phân và thập lục phân, ghép thành chuỗi và gửi lên server. Ví dụ: 15226 sẽ thành "11101101111010;3B7A"
//d. Đóng kết nối: Kết thúc chương trình sau khi gửi kết quả chuyển đổi.
package DataStream_use_DataInputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ChuyenHe10SangHe2va16 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2207);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        
        String request = "B22DCCN008;UsLuWWET";
        out.writeUTF(request);
        out.flush();
        
        int a = in.readInt();
        System.out.println(a);
        String bi = Integer.toBinaryString(a);
        String he = Integer.toHexString(a).toUpperCase();
        String kq = bi+";"+ he;
        
        out.writeUTF(kq);
        out.flush();
    }
}
