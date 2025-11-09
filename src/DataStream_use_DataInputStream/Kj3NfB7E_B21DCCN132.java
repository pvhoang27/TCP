/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStream_use_DataInputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class Kj3NfB7E_B21DCCN132 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        // gui msv + qcode len sv
        String request = "B21DCCN132;Kj3NfB7E";
        out.writeUTF(request);
        out.flush();
        
        // nhan du lieu tu sv ve 
        int a = in.readInt();
        System.out.println(a);
        
        // xu ly bai toan 
        String decToBi = Integer.toBinaryString(a);
        System.out.println(decToBi);
        String decToHex = Integer.toHexString(a).toUpperCase();
        System.out.println(decToHex);
        
        // gui len sv
        String result = decToBi +";" + decToHex;
        System.out.println(result);
        out.writeUTF(result);
        out.flush();
        
        // dong ket noi
        in.close();
        out.close();
        socket.close();
        
    }
}
