/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): mVBXqYVj].  Thông tin sản phẩm vì một lý do nào đó đã bị sửa đổi thành không đúng, cụ thể:
//a) Tên sản phẩm bị đổi ngược từ đầu tiên và từ cuối cùng, ví dụ: “lenovo thinkpad T520” bị chuyển thành “T520 thinkpad lenovo”
//b) Số lượng sản phẩm cũng bị đảo ngược giá trị, ví dụ từ 9981 thành 1899
//
//Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2209 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng đối tượng (ObjectInputStream / ObjectOutputStream) để gửi/nhận và sửa các thông tin bị sai của sản phẩm. Chi tiết dưới đây:
//a) Đối tượng trao đổi là thể hiện của lớp Laptop được mô tả như sau
//      •	Tên đầy đủ của lớp: TCP.Laptop
//      •	Các thuộc tính: id int, code String, name String, quantity int
//      •	Hàm khởi tạo đầy đủ các thuộc tính được liệt kê ở trên
//      •	Trường dữ liệu: private static final long serialVersionUID = 20150711L; 
//b)	Tương tác với server theo kịch bản
//1)	Gửi đối tượng là chuỗi chứa mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;5AD2B818"
//2)	Nhận một đối tượng là thể hiện của lớp Laptop từ server
//3)	Sửa các thông tin sai của sản phẩm về tên và số lượng.  Gửi đối tượng vừa được sửa sai lên server
//4)	Đóng socket và kết thúc chương trình.
package luyen_tap;
import TCP.Laptop;
import java.util.*;
import java.net.*;
import java.io.*;
/**
 *
 * @author hoang
 */
public class B17DCCN043_mVBXqYVj_suaLaptop {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in  = new ObjectInputStream(socket.getInputStream());
        
        String request = "B17DCCN043;mVBXqYVj";
        // nhớ là write object 
        out.writeObject(request);
        out.flush();
        
        Laptop lap = (Laptop) in.readObject();
        System.out.println(lap);
        
        // xử lý đề bài 
        // a. sua ten , ten bi dao nguoc dau dit 
        String name = lap.getName().trim();
        System.out.println(name);
        String[] part = name.split(" ");
        System.out.println(part[0]);
        System.out.println(part[1]);
        String daumoi = part[part.length - 1];
        String ditmoi = part[0];
        String newName = "";
        for(int i = 1 ; i < part.length -1 ; i++){
            // để ý dấu cách
            newName +=  part[i] + " " ;
        }
        // để ý dâu cách 
        String newName2 = daumoi +" "+newName  + ditmoi;
        System.out.println(newName2);
        // day vao object 
        lap.setName(newName2);
        
        // b) Số lượng sản phẩm cũng bị đảo ngược giá trị, ví dụ từ 9981 thành 1899
        int sl = lap.getQuantity();
        StringBuilder h  = new StringBuilder();
        h.append(sl);
        h.reverse();
        System.out.println(h);
        String tmp = h.toString();
        int slmoi = Integer.parseInt(tmp);
        
        lap.setQuantity(slmoi);
        
        out.writeObject(lap);
        out.flush();
        
        in.close();out.close(); socket.close();
        
        
        
        
        
    }
            
}
