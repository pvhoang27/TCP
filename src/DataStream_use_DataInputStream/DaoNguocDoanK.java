//BÀI 2. ĐẢO NGƯỢC ĐOẠN DÀI K [Mã câu hỏi (qCode): dCNDHojG]. Một chương trình server cho phép kết nối qua TCP tại cổng 2207 (hỗ trợ thời gian liên lạc tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu xây dựng chương trình client thực hiện giao tiếp với server sử dụng luồng data (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự:
//
//a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B10DCCN003;C6D7E8F9"
//
//b. Nhận lần lượt:
//
//Một số nguyên k là độ dài đoạn.
//
//Chuỗi chứa mảng số nguyên, các phần tử được phân tách bởi dấu phẩy ",". Ví dụ: Nhận k = 3 và "1,2,3,4,5,6,7,8".
//
//c. Thực hiện chia mảng thành các đoạn có độ dài k và đảo ngược mỗi đoạn, sau đó gửi mảng đã xử lý lên server. Ví dụ: Với k = 3 và mảng "1,2,3,4,5,6,7,8", kết quả là "3,2,1,6,5,4,8,7". Gửi chuỗi kết quả "3,2,1,6,5,4,8,7" lên server.
//
//d. Đóng kết nối và kết thúc chương trình .

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DaoNguocDoanK {

    public static void main(String[] args) {
        // Giả lập dữ liệu nhận được từ Server
        int k = 3;
        String inputData = "1,2,3,4,5,6,7,8";
        
        System.out.println("k = " + k);
        System.out.println("Input: " + inputData);
        
        // Gọi hàm xử lý
        String result = processLogic(k, inputData);
        System.out.println("Gửi lên Server: " + result);
    }

    public static String processLogic(int k, String data) {
        // --- BƯỚC 1: Parse dữ liệu ---
        if (data == null || data.isEmpty()) return "";
        
        String[] parts = data.trim().split(",");
        List<String> list = new ArrayList<>();
        
        // Dùng List<String> để xử lý đảo ngược cho tiện (vì không cần tính toán cộng trừ)
        for (String p : parts) {
            list.add(p.trim());
        }

        // --- BƯỚC 2: Xử lý thuật toán ---
        int n = list.size();
        
        // Duyệt từng đoạn độ dài k
        for (int i = 0; i < n; i += k) {
            // Xác định vị trí bắt đầu và kết thúc của đoạn con
            // Math.min để xử lý trường hợp đoạn cuối cùng có độ dài < k
            int start = i;
            int end = Math.min(i + k, n);
            
            // Lấy đoạn con (subList trả về view của list gốc)
            List<String> subList = list.subList(start, end);
            
            // Đảo ngược đoạn con (sẽ thay đổi trực tiếp lên list gốc)
            Collections.reverse(subList);
        }

        // --- BƯỚC 3: Ghép kết quả ---
        // Java 8: Ghép lại thành chuỗi cách nhau bởi dấu phẩy
        String result = String.join(",", list);
        
        return result;
    }
}