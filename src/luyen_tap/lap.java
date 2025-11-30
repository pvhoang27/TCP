//[Mã câu hỏi (qCode): GSgVvq9W].  Thông tin khách hàng cần thay đổi định dạng lại cho phù hợp với khu vực, cụ thể:
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
package luyen_tap;

import TCP.Customer;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class lap {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109",2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        
        
        String request = "B21DCCN414;GSgVvq9W";
        out.writeObject(request);
        out.flush();
        
        Customer a = (Customer) in.readObject();
        String name = a.getName().trim().toLowerCase();
        String [] partName = name.split(" ");
        String dauHoa = partName[partName.length-1].toUpperCase() +", ";
        String sau ="";
        for(int i = 0; i < partName.length-1; i++){
            sau += (Character.toUpperCase(partName[i].charAt(0)) + partName[i].substring(1)) + " " ;
        }
        String nameMoi = dauHoa + sau;
        System.out.println(nameMoi.trim());
        a.setName(nameMoi);
        
        String dauU = "";
        for(int i = 0; i < partName.length-1; i++){
            dauU += partName[i].charAt(0);
        }
        String uMoi = dauU + partName[partName.length-1];
        a.setUserName(uMoi);
        
        String ns = a.getDayOfBirth();
        String [] partNs  = ns.split("-");
        String nsMoi = partNs[1] +"/" + partNs[0] +"/"+partNs[2];
        a.setDayOfBirth(nsMoi);
        
        out.writeObject(a);
        out.flush();
        
    }
}
