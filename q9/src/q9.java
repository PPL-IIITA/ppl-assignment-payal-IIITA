
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class q9 {
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
        int k;
        //Scanner s=new Scanner(System.in);
        Random rk=new Random();
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
        //System.out.println("Enter choice:");
        k=rk.nextInt(2)+1;
        gift g1=new gift();
        int[] boyatt=new int[100];
        int bar[]=new int[100];
        int gar[]=new int[100];
        int ear[]=new int[100];
        int lar[]=new int[100];
        generic_class bo=new generic_class();
        //generic_class<girl> go=new generic_class<girl>();
        //relationship r=new relationship();
        
        
        i.makearray(bar,gar,ear,lar);
        switch(k){
            case 1:bo.sort(b, bar, i.bs);
                   for(int j=0;j<i.bs;j++)
                        r.pair_making_by_girl(i.gs, i.bs,j,6);
                   g1.gift_basket(b, g, i.gs, l, i.ls, e, i.es);
                   break;
            case 2:bo.sort(g, gar, i.gs);
                   for(int j=0;j<i.bs;j++)
                        r.pair_making_by_boy(i.gs, i.bs,j,6);
                   g1.gift_basket(b, g, i.gs, l, i.ls, e, i.es);
                   break;
        }
            //System.out.println(b[j].attractiveness);
       /* go.sort(g, gar, i.gs);
        
        i.pair_making();*/
        
        
        i.createlog(committed); 
        
   }
}
