/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): t5VLxpf0].  Thông tin sản phẩm vì một lý do nào đó đã bị sửa đổi thành không đúng, cụ thể:
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
package ObjectStream_use_ObjectInputStream;

import TCP.Laptop;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class t5VLxpf0_B21DCCN132 {
    // hàm xử lý sai tên 
    //Tên sản phẩm bị đổi ngược từ đầu tiên và từ cuối cùng, ví dụ: “lenovo thinkpad T520” bị chuyển thành “T520 thinkpad lenovo”
    public static String xuLyTen(String tenSai) {
        // Tách chuỗi thành các từ, phân cách bởi 1 hoặc nhiều dấu cách
        String[] words = tenSai.trim().split("\\s+");
        
        // Nếu tên chỉ có 1 từ hoặc không có từ nào, trả về y nguyên
        if (words.length <= 1) {
            return tenSai;
        }
        
        // Hoán đổi từ đầu và từ cuối
        String tuDau = words[0];
        String tuCuoi = words[words.length - 1];
        
        words[0] = tuCuoi;
        words[words.length - 1] = tuDau;
        
        // Nối các từ lại với nhau bằng 1 dấu cách
        return String.join(" ", words);
    }
    // hàm xử lý số lượng bị ngược 
    //Số lượng sản phẩm cũng bị đảo ngược giá trị, ví dụ từ 9981 thành 1899
    public static int xuLySoLuong(int soLuongSai) {
        String s = String.valueOf(soLuongSai);
        String s_nguoc = new StringBuilder(s).reverse().toString();
        return Integer.parseInt(s_nguoc);
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        
        String requet = "B21DCCN132;t5VLxpf0";
        out.writeObject(requet);
        out.flush();
        
        Laptop LapNhan = (Laptop) in.readObject();
        System.out.println(LapNhan);
        
        // xử lý bài toán 
        // lấy tên sai + sl sai 
        String tenSai = LapNhan.getName();
        int slSai = LapNhan.getQuantity();
        // sửa lại cho đúng
        String tenDung = xuLyTen(tenSai);
        int slDung = xuLySoLuong(slSai);
        // cập nhật lại vào Lap
        LapNhan.setName(tenDung);
        LapNhan.setQuantity(slDung);
        System.out.println(LapNhan);
        
        // gui len sv 
        out.writeObject(LapNhan);
        out.flush();
         
    }
    
}
//[Mã câu hỏi (qCode): t5VLxpf0].  Thông tin sản phẩm vì một lý do nào đó đã bị sửa đổi thành không đúng, cụ thể:
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
