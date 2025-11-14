/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjectStream_use_ObjectInputStream;
import TCP.Customer;
import java.util.*;
import java.io.*;
import java.net.*;
/**
 *
 * @author hoang
 */
public class B21DCCN662_hJF7KpRE_ChuanHoaCustomer {
    public static void main(String[] args) throws  Exception{
        Socket socket = new Socket("203.162.10.109",2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        
        String requet ="B21DCCN662;hJF7KpRE";
        out.writeObject(requet);
        out.flush();
        
        // nhận object về 
        Customer cus = (Customer) in.readObject();
        System.out.println(cus);
        
        String name = cus.getName();
//        System.out.println(name);
        String dob = cus.getDayOfBirth();
//        System.out.println(dob);
        
        // xử lý bài toán 
// a.Tên khách hàng cần được chuẩn hóa theo định dạng mới. Ví dụ: nguyen van hai duong -> DUONG, Nguyen Van Hai
//c.Tài khoản khách hàng là các chữ cái in thường được sinh tự động từ họ tên khách hàng. Ví dụ: nguyen van hai duong -> nvhduong
//nguyen van hai duong -> nvhduong      
// nguyen van hai duong -- > DUONG, Nguyen Van Hai
        String [] part = name.toLowerCase().split("\\s+"); // chia thanh cac phan thong qua cac dau cach
//        System.out.println(part[0]);
        String newName = part[part.length - 1].toUpperCase()+","; // moi la xu ly phan first name (DUONG,)
//        System.out.println(newName);
        String userName = part[part.length - 1]; // username nay moi chi la cai firstName(duong)
//        System.out.println(userName);
        
        String tmp = "";
        for(int i = 0 ; i < part.length - 1  ; i++){ // -1 vì bỏ cái firstName ( Duong) di 
//            // cach viet nay kha la kho hieu 
//            newName += " "+ String.valueOf(part[i].charAt(0)).toUpperCase() + part[i].substring(1);
//            tmp += part[i].charAt(0);
            // cach viet nay de hieu va tuong minh hon
            String word = part[i]; // từng từ một ( nguyen , vam , hai )
            System.out.print(word + " , ");
            // tách chữ cái đầu rồi viết hoa nó  ( n -> N)
            String firstChar = String.valueOf(word.charAt(0)).toUpperCase();
            System.out.println (firstChar);
            // tách phần còn lại sau khi lấy chữ hoa (nguyen -> guyen)
            String rest = word.substring(1); // lấy từ kí tự 1
            //ghép lại theo chuẩn hóa 
            newName += " "+firstChar + rest;
            
            // xử lý phần username
            // lấy kí tự đầu của mỗi cái word cho user + firstName ( nguyen van hai --> nvh)
            tmp += word.charAt(0); // lay chu thuong ( n , v ,h)
            
        }
        // ghép username
        userName = tmp + userName;
        System.out.println(newName);
        System.out.println(userName);
        // day dap an vao object 
        cus.setName(newName);
        cus.setUserName(userName);
//b.Ngày sinh của khách hàng hiện đang ở dạng mm-dd-yyyy, cần được chuyển thành định dạng dd/mm/yyyy. Ví dụ: 10-11-2012 -> 11/10/2012
//        Ví dụ: 10-11-2012 -> 11/10/2012
           
        String[] partDob = dob.split("-");
        dob = partDob[1] +"/" + partDob[0] + "/" + partDob[2];
        System.out.println(dob);
        // day dap an vao objec
        cus.setDayOfBirth(dob);
        
        //gui len sv
        out.writeObject(cus);
        out.flush();
        
        // dong sv
        in.close();
        out.close();
        socket.close();
        
    }
}
