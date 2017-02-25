/**
 * <h> solution to question 2</h>
 */
import java.io.*;
import java.util.Arrays;

public class q2 {
   public static void main(String [] args)throws IOException {
       
       //int max=-1;
        girl[] g=new girl[100];
        boy[] b=new boy[100];
        int[] committed=new int[100];
        essential_gift[] e=new essential_gift[100];
        luxury_gift[] l=new luxury_gift[100];
        utility_gift[] u=new utility_gift[100];
        double[] happy=new double[100];
        double[] happy1=new double[100];
        int[] compat=new int[100];
        int[] compat1=new int[100];
        initialize i=new initialize(args,g,b,e,l,u,committed,happy,compat,happy1,compat1);
        
        
        
        
        
        
        int k=Integer.parseInt(args[5]);
        /*print k happiest couples*/
         System.out.println(k +" happiest couples");
        for(int j=0;j<k;j++){
            for(int m=0;m<i.gs;m++)
                if(happy1[j]==happy[m])
                    System.out.println("<"+g[m].name+","+b[committed[m]].name+">");
                
        }
        /*print k most compatible couples*/
        System.out.println(k+ " most compatible couples");
         for(int j=0;j<k;j++){
            for(int m=0;m<i.gs;m++)
                if(compat1[j]==compat[m])
                    System.out.println("<"+g[m].name+","+b[committed[m]].name+">");
        }
        for(int j=0;j<i.gs;j++)
            if(committed[j]!=-1)
                System.out.println("<"+g[j].name+","+b[committed[j]].name+ " price " +g[j].gift_price +" value "+g[j].gift_value);
       
      i.createlog(committed,g,b);
        
   }
}
