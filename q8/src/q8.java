
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class q8 {
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
        int choice;
        Random s=new Random();
        committed=new int[100];
        e=new essential_gift[100];
        l=new luxury_gift[100];
        u=new utility_gift[100];
        happy=new double[100];
        int[] happy1=new int[100];
        compat=new int[100];
        int[] compat1=new int[100];
        initialize i=new initialize(args,happy1,compat1);
        //System.out.println("Enter choice:");
        choice=s.nextInt(2)+1;
        gift_type1 g1=new gift_type1();
        gift_type2 g2=new gift_type2();
        
        
        
        i.pair_making();
        switch(choice){
            case 1:for(int j=0;j<i.gs;j++){
                        gift gt=(gift)g1;
                        if(committed[j]!=-1)
                            gt.gift_basket_1(b,g[j].bfno,g,i.gs,l,i.ls,e,i.es);
                    }
                    break;
            case 2:for(int j=0;j<i.gs;j++){
                        gift gt=(gift)g2;
                        if(committed[j]!=-1)
                            gt.gift_basket_2(b,g[j].bfno,g,i.gs,l,i.ls,e,i.es,u,i.us);
                    }
                    break;
            default:for(int j=0;j<i.gs;j++){
                        gift gt=(gift)g1;
                        if(committed[j]!=-1)
                            gt.gift_basket_1(b,g[j].bfno,g,i.gs,l,i.ls,e,i.es);
                    }
        }
        
        i.createlog(committed); 
        
   }
}
