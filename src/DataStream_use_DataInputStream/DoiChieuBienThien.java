/*
BÀI 1. ĐỔI CHIỀU VÀ BIẾN THIÊN [Mã câu hỏi (qCode): oNGj55wV]. Một chương trình server cho phép kết nối qua TCP tại cổng 807 (hỗ trợ thời gian liên lạc tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu xây dựng chương trình client thực hiện giao tiếp với server sử dụng luồng data (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự:

a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B10DCCN002;B4C5D6E7"

b. Nhận chuỗi chứa mảng số nguyên từ server, các phần tử được phân tách bởi dấu phẩy ",". Ví dụ: "1,3,2,5,4,7,6" 

c. Tính số lần đổi chiều và tổng độ biến thiên trong dãy số. 


Đổi chiều: Khi dãy chuyển từ tăng sang giảm hoặc từ giảm sang tăng. 


Độ biến thiên: Tổng giá trị tuyệt đối của các hiệu số liên tiếp. 

Gửi lần lượt lên server: số nguyên đại diện cho số lần đổi chiều, sau đó là số nguyên đại diện cho tổng độ biến thiên. Ví dụ: Với mảng "1,3,2,5,4,7,6", số lần đổi chiều: 5 lần, Tổng độ biến thiên 11 -> Gửi lần lượt số nguyên 5 và 11 lên server. 


d. Đóng kết nối và kết thúc chương trình.
 */
package DataStream_use_DataInputStream;

/**
 *
 * @author hoang
 */
public class DoiChieuBienThien {

    public static void main(String[] args) {
        // Giả lập dữ liệu nhận từ Server
        String inputFromServer = "1,3,2,5,4,7,6";
        
        // Gọi hàm xử lý
        processLogic(inputFromServer);
    }

    public static void processLogic(String data) {
        // --- BƯỚC 1: Parse dữ liệu đầu vào ---
        String[] tokens = data.trim().split(",");
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i].trim());
        }

        // --- BƯỚC 2: Xử lý thuật toán ---
        int totalVariation = 0; // Tổng độ biến thiên
        int changeCount = 0;    // Số lần đổi chiều
        
        // lastTrend: Lưu xu hướng bước trước đó
        // 1: Tăng, -1: Giảm, 0: Chưa xác định hoặc bằng nhau
        int lastTrend = 0; 

        // Duyệt từ phần tử thứ 2
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i-1];
            
            // 1. Tính độ biến thiên (Tích lũy trị tuyệt đối hiệu 2 số)
            totalVariation += Math.abs(diff);

            // 2. Tính số lần đổi chiều
            int currentTrend = 0;
            if (diff > 0) currentTrend = 1;       // Đang tăng
            else if (diff < 0) currentTrend = -1; // Đang giảm
            
            // Nếu có sự thay đổi giá trị (không phải bằng nhau)
            if (currentTrend != 0) {
                // Nếu đã có xu hướng trước đó VÀ xu hướng mới ngược xu hướng cũ
                // (VD: Đang 1 chuyển sang -1 hoặc ngược lại)
                if (lastTrend != 0 && currentTrend != lastTrend) {
                    changeCount++;
                }
                // Cập nhật xu hướng mới nhất
                lastTrend = currentTrend;
            }
        }

        // --- BƯỚC 3: In kết quả (Output gửi lên Server) ---
        // Đề bài yêu cầu gửi lần lượt 2 số nguyên
        System.out.println("Gửi lên Server số 1: " + changeCount);
        System.out.println("Gửi lên Server số 2: " + totalVariation);
    }
}
