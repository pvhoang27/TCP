/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStream_use_DataInputStream;

/**
 *
 * @author hoang
 */
public class PhuongsaivaTBC {
    public static void main(String[] args) {
        int [] a = {1 , 3 ,6 ,7};
        int n = a.length;
        int sum = 0 ; 
        for(int i = 0 ;  i < a.length; i++){
            sum += a[i];
        }
        // nho ep kieu
        float tbc = (float )sum / n;
        System.out.println(tbc);
        // tinh phuong sai
        int sum2  = 0 ;
        for(int x : a){
            sum2 +=  (x - tbc) * (x - tbc);
        }
        // nho ep kieu 
        float phuongsai =(float) sum2/ n;
        System.out.println(phuongsai);
          
    }
}
