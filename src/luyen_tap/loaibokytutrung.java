/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyen_tap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author hoang
 */
public class loaibokytutrung {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2208);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String request = "B21DCCN414;nkg3wrpO";
        out.write(request);
        out.newLine();
        out.flush();
        
        String a = in.readLine();
        System.out.println(a);
        int[] cnt = new int[256];
        for(int i = 0 ; i < a.length(); i++){
            char c =a.charAt(i);
            cnt[c] ++;
        }
        String kq ="";
        for(int i = 0 ; i < a.length(); i++){
            char c =a.charAt(i);
            if(Character.isLetter(c ) && cnt[c] > 0){
                kq+=c ;
                cnt[c] = 0;
            }
        }
        out.write(kq);
        out.newLine();
        out.flush();
    }
}
