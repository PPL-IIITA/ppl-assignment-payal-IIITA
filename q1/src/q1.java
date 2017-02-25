/**
 * <h> solution to question 1 <h>
 */
import java.io.IOException;
import java.util.*;

public class q1 {
    public static void main(String [] args) throws IOException{
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
        
        
        
        for(int j=0;j<i.gs;j++){
            
                System.out.println("<"+g[j].name+","+b[committed[j]].name+">");
        }
                
    }
}
