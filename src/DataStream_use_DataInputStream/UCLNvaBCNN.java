/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStream_use_DataInputStream;

/**
 *
 * @author hoang
 */
public class UCLNvaBCNN {
    public static int ucln(int a , int b){
        while(b != 0 ){
            int temp = b;
            b = a % b;
            a = temp ;
        }
        return a ; 
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 24;
        int uc = ucln(a, b);
        System.out.println(uc);
        int bc =  ( a * b) / uc ;
        System.out.println(bc);
    }
}
