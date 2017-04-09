/**
 * <h> solution to question 3</h>
 */
import java.io.*;
import java.util.Arrays;

public class q3 {
        public static girl[] g;
        public static boy[] b;
        public static int[] committed;
        public static essential_gift[] e;
        public static luxury_gift[] l;
        public static utility_gift[] u;
        public static double[] happy;
        public static int[] compat;
                
   public static void main(String [] args)throws IOException {
       
       //int max=-1;
        g=new girl[100];
        b=new boy[100];
        committed=new int[100];
        e=new essential_gift[100];
        l=new luxury_gift[100];
        u=new utility_gift[100];
        happy=new double[100];
        int[] happy1=new int[100];
        compat=new int[100];
        int[] compat1=new int[100];
        initialize i=new initialize(args,happy1,compat1);
        relationship r=new relationship();
        int k=4;
        /*print k happiest couples*/
        
        
        
        
        
        i.pair_making();
        i.calculate_order_of_happiness(happy1, compat1);
         System.out.println(k +" happiest couples");
        for(int j=0;j<k;j++){
             System.out.println("<"+g[happy1[j]].name+","+b[g[happy1[j]].bfno].name+">");
        }
       // print k most compatible couples;
       System.out.println(k+ " most compatible couples");
         for(int j=0;j<k;j++){
             
             System.out.println("<"+g[compat1[j]].name+","+b[g[compat1[j]].bfno].name+">");
        }
        for(int j=0;j<i.gs;j++)
            if(committed[j]!=-1)
                System.out.println("<"+g[j].name+","+b[committed[j]].name+ " price " +g[j].gift_price +" value "+g[j].gift_value);
       
      i.createlog(committed,g,b);
        
        
   }
}
