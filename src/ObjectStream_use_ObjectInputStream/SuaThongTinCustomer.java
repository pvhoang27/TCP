//[Mã câu hỏi (qCode): R4LLB7BF].  Thông tin khách hàng cần thay đổi định dạng lại cho phù hợp với khu vực, cụ thể:
//a.	Tên khách hàng cần được chuẩn hóa theo định dạng mới. Ví dụ: nguyen van hai duong -> DUONG, Nguyen Van Hai
//b.	Ngày sinh của khách hàng hiện đang ở dạng mm-dd-yyyy, cần được chuyển thành định dạng dd/mm/yyyy. Ví dụ: 10-11-2012 -> 11/10/2012
//c.	Tài khoản khách hàng là các chữ cái in thường được sinh tự động từ họ tên khách hàng. Ví dụ: nguyen van hai duong -> nvhduong
//
//Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2209 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng đối tượng (ObjectInputStream / ObjectOutputStream) thực hiện gửi/nhận đối tượng khách hàng và chuẩn hóa. Cụ thể:
//a.	Đối tượng trao đổi là thể hiện của lớp Customer được mô tả như sau
//      •	Tên đầy đủ của lớp: TCP.Customer
//      •	Các thuộc tính: id int, code String, name String, dayOfBirth String, userName String
//      •	Hàm khởi tạo đầy đủ các thuộc tính được liệt kê ở trên
//      •	Trường dữ liệu: private static final long serialVersionUID = 20170711L; 
//b.	Tương tác với server theo kịch bản dưới đây:
//	1) Gửi đối tượng là một chuỗi gồm mã sinh viên và mã câu hỏi ở định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;F2DA54F3"
//	2) Nhận một đối tượng là thể hiện của lớp Customer từ server với các thông tin đã được thiết lập
//	3) Thay đổi định dạng theo các yêu cầu ở trên và gán vào các thuộc tính tương ứng.  Gửi đối tượng đã được sửa đổi lên server
//	4) Đóng socket và kết thúc chương trình.
package ObjectStream_use_ObjectInputStream;

import TCP.Customer;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class SuaThongTinCustomer {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        
        String request = "B22DCCN067;R4LLB7BF";
        out.writeObject(request);
        out.flush();
        
        Customer a = (Customer) in.readObject();
        System.out.println(a);
        // xử lý ngày sinh 
        String ns = a.getDayOfBirth();
        String [] part = ns.split("-");
        String nsMoi = part[1] +"/"+part[0] +"/"+part[2];
        a.setDayOfBirth(nsMoi.trim());
        // xử lý username
        String name = a.getName().toLowerCase();
        String [] partName = name.split(" ");
        String dau ="";
        for(int i = 0 ;i < partName.length -1; i ++){
            dau +=  partName[i].charAt(0);
        }
        System.out.println(dau);
        String userName = dau + partName[partName.length-1];
        a.setUserName(userName.trim());
        
        // xử lý tên
        String dauTen = partName[partName.length-1 ].toUpperCase()+", ";
        String tiep = "";
        String sau = "";
        for(int i = 0 ; i < partName.length - 1; i++){
            tiep = Character.toUpperCase(partName[i].charAt(0)) + partName[i].substring(1);
            sau += tiep +" ";
        }
        String tenMoi = dauTen + sau;
        a.setName(tenMoi);
        
        out.writeObject(a);
        out.flush();      
        
        in.close();out.close();socket.close();
    }
}
