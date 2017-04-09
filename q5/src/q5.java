/**
 * 
 */
import java.io.*;
import java.util.Arrays;

public class q5 {
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
        
        
        i.pair_making();
        i.calculate_order_of_happiness(i.gs, happy1, compat1);
        r.khappiest(4, happy1, compat1, i.gs);
       i.createlog(committed,g,b); 
        
   }
}
