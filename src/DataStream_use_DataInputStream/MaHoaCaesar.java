/*
[Mã câu hỏi (qCode): lHRjI8fD].  Mật mã caesar, còn gọi là mật mã dịch chuyển, để giải mã thì mỗi ký tự nhận được sẽ được thay thế bằng một ký tự cách nó một đoạn s. Ví dụ: với s = 3 thì ký tự “A” sẽ được thay thế bằng ký tự “D”.
Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2207 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng chương trình client tương tác với server trên, sử dụng các luồng byte (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự:
a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;D68C93F7"
b.	Nhận lần lượt chuỗi đã bị mã hóa caesar và giá trị dịch chuyển s nguyên
c.	Thực hiện giải mã ra thông điệp ban đầu và gửi lên Server
d.	Đóng kết nối và kết thúc chương trình.
 */
package DataStream_use_DataInputStream;
import java.net.*;
import java.rmi.*;
import java.io.*;
public class MaHoaCaesar {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2207);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        
        String request = "B22DCCN104;lHRjI8fD";
        out.writeUTF(request);
        out.flush();
        
        String a = in.readUTF().trim();
        System.out.println(a);
        int n = in.readInt();
        System.out.println(n);
        String kq ="";
        for(int i = 0 ; i < a.length(); i++){
            char c = a.charAt(i);
            // chu thuong
            if(Character.isLowerCase(c)){
                kq+= (char ) ('a'+ (c - 'a' - n + 26) % 26 );
                
            }
            else if(Character.isUpperCase(c)){
                  kq +=  (char ) ('A'+ (c - 'A' - n + 26) % 26 );
                
            } 
            else kq += c;
        }
        System.out.println(kq);
        out.writeUTF(kq);
        out.flush();
    }
}
