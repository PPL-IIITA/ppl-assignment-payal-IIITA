
import java.io.*;
import java.util.Arrays;

public class q6 {
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
        i.createlog(committed); 
        for(int k=1;k<=92;k++){
            for(int j=0;j<i.gs;j++){
                if(committed[j]!=-1){
                    i.calculate_happiness(j);
                    b[g[j].bfno].gift_basket(g, i.gs, l,i. ls, e, i.es);
                }
            }
            r.kbreakups(k, i.gs, i.bs);
        }
       /* for(int j=0;j<i.gs;j++)
            System.out.println(happy[j]);*/
        r.kbreakups(92, i.gs, i.bs);
        //i.calculate_order_of_happiness(i.gs, happy1, compat1);
       // r.khappiest(4, happy1, compat1, i.gs);
        //i.createlog(committed,g,b); 
        
   }
}
