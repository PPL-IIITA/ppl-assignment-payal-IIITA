
import java.io.*;
import static java.lang.Math.abs;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class q7 {
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
        Scanner s=new Scanner(System.in);
        int[] compat1=new int[100];
        initialize i=new initialize(args,happy1,compat1);
        relationship r=new relationship();
        int barray[][]=new int[100][2];
        int gf[]=new int[100];
        Random ran=new Random();
        int choice;
        choice=abs(ran.nextInt())%2;
        i.pair_making();
        switch(choice){
            case 0:  i.createboyhash(i.gs,i.bs,gf);
                    for(int j=0;j<5;j++){
                        int k,temp=abs(ran.nextInt())%i.bs;
                        k=i.findinhash(gf, i.bs, temp);
                        if(k!=-1)
                         System.out.println(b[temp].name+" "+g[k].name);
                        else
                            System.out.println(-1);
                    }
                       break;
            case 1:  int size=i.createboyarray(i.gs, barray);
                        for(int j=0;j<5;j++){
                        int temp=abs(ran.nextInt())%i.bs;;
                        int k=i.bsearch(0,size, barray,temp);
                        if(k!=-1)
                            System.out.println(b[temp].name+" "+g[k].name);
                        else
                            System.out.println(-1);
                        }
                        break;
            default:  for(int j=0;j<5;j++){
                        int k,temp=abs(ran.nextInt())%i.bs;
                        for(k=0;k<i.gs;k++)
                            if(committed[k]==temp)
                                System.out.println(b[temp].name+" "+g[k].name);
                        if(k==i.gs)
                            System.out.println(-1);
                        }
        }
         //i.createlog(committed); 
        
   }
}

