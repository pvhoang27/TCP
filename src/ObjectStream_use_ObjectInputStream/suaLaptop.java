/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjectStream_use_ObjectInputStream;

import TCP.Laptop;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class suaLaptop {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2209 );
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        
        String request  = "B22DCCN032;eGq2H2IV";
        out.writeObject(request);
        out.flush();
        
        Laptop a =(Laptop) in.readObject();
        System.out.println(a);
        
        String name = a.getName();
        String [] partName = name.split(" ");
        String temp = partName[0];
        partName[0] = partName[partName.length-1];
        partName[partName.length-1] = temp;
        String nameMoi ="";
        for(int i = 0 ; i < partName.length; i++){
            nameMoi  += partName[i] +" ";
        }
        a.setName(nameMoi.trim());
        String b = "" + a.getQuantity();
        String c = "";
        for(int i = b.length() - 1 ; i>=0 ; i--){
            char d = b.charAt(i);
            c += d ;
        }
        int e = Integer.parseInt(c);
        a.setQuantity(e);
        
        out.writeObject(a);
        out.flush();
        
        in.close(); out.close();socket.close();
    }
}
