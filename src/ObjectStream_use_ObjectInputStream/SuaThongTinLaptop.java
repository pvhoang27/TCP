//[Mã câu hỏi (qCode): jdaFAc8d].  Thông tin sản phẩm vì một lý do nào đó đã bị sửa đổi thành không đúng, cụ thể:
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

public class SuaThongTinLaptop {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        
        String request = "B22DCCN008;jdaFAc8d";
        out.writeObject(request);
        out.flush();
        
        Laptop laptop = (Laptop) in.readObject();
        System.out.println(laptop);
        
        String name = laptop.getName();
        String [] part = name.split(" ");
        String tmp =part[0];
        part[0] = part[part.length -1];
        part[part.length-1 ] = tmp;
        System.out.println(part[0]);
        System.out.println(part[part.length-1]);
        String kq = "";
        for(int i = 0 ; i < part.length; i++){
            kq += part[i] +" ";
        }
        System.out.println(kq);
        laptop.setName(kq.trim());
        int a = laptop.getQuantity();
        String b = ""+a ;
        String d="";
        for(int i = b.length() -1 ; i >=0; i--){
            char c = b.charAt(i);
            d += c;
        }
        int kq2 = Integer.parseInt(d);
        System.out.println(kq2);
        laptop.setQuantity(kq2);
        
        out.writeObject(laptop);
        out.flush();
        
        in.close();out.close();socket.close();
    }
}
