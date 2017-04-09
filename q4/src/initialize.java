/**
 *
 */

/*INITIALIZES THE OBJECT ARRAYS*/
import java.io.*;
import static java.lang.Math.abs;
import java.util.*;



public class initialize extends q4 {
    /* 1st input:girl.txt 
          2nd input:boy.txt
          3rd input:essential.txt
          4th input:luxury.txt
          5th input:utility.txt
       */
    int gs,bs,es,us,ls;
    /**
     * constructor to read from files and initialize objects
     * @param args All command Line arguments
     * @param happy1 array containing happiness of couples
     * @param compat1 array containing compatibility of couples
     * @throws IOException when text files not found
     */
    public initialize(String [] args,int[] happy1,int[] compat1) throws IOException{
     
        
       Scanner gl= new Scanner(new FileReader("girl.txt"));
       Scanner bo =new Scanner(new FileReader("boy.txt"));
       Scanner eg =new Scanner(new FileReader("essential.txt"));
       Scanner lg =new Scanner(new FileReader("luxury.txt"));
       Scanner ug =new Scanner(new FileReader("utility.txt"));
       gs=gl.nextInt();bs=bo.nextInt();es=eg.nextInt();us=ug.nextInt();ls=lg.nextInt();
       for(int i=0;i<gs;i++){
               g[i]=new girl();
               g[i].name=gl.next();
               g[i].attractiveness=gl.nextInt();
               g[i].budget=gl.nextInt();
               g[i].intelligence=gl.nextInt();
               g[i].choice=gl.nextInt();
               g[i].property=gl.nextInt();
              
        }
       for(int i=0;i<bs;i++){
               b[i]=new boy();
               b[i].name=bo.next();
               b[i].attractiveness=bo.nextInt();
               b[i].intelligence=bo.nextInt();
               b[i].budget=bo.nextInt();
               
               b[i].attraction_require=bo.nextInt();
               b[i].property=bo.nextInt();
        }
       for(int i=0;i<es;i++){
               e[i]=new essential_gift();
               e[i].price=eg.nextInt();
               e[i].value=eg.nextInt();
        }
       for(int i=0;i<ls;i++){
               l[i]=new luxury_gift();
               l[i].price=lg.nextInt();
               l[i].value=lg.nextInt();
               l[i].difficulty=lg.nextInt();
               l[i].luxury_rating=lg.nextInt();
        }
       for(int i=0;i<us;i++){
               u[i]=new utility_gift();
               u[i].price=ug.nextInt();
               u[i].value=ug.nextInt();
               u[i].utility_value=ug.nextInt();
               u[i].utility_class=ug.nextInt();
        }
       relationship r=new relationship();
      // r.pair_making_by_girl(b,g,gs,bs);
        for(int i=0;i<gs;i++){
           // int j=g[i].pair_making(b,bs);
            r.pair_making_by_girl(gs,bs,i,0);
           if(g[i].status==1)
            committed[i]=g[i].bfno;
           else
               committed[i]=-1;
            //System.out.println("<"+i+","+j+">");
        }
     //   r.pair_making_by_girl(b,g,gs,bs);
        for(int i=0;i<bs;i++)
            if(b[i].status==1)
                b[i].gift_basket(g,gs,l,ls,e,es);
        
        for(int j=0;j<gs;j++){
            calculate_happiness(j);
        }
        
        
        calculate_order_of_happiness(gs,happy,compat,happy1,compat1);
        
        
    }
    /**
     * Function to calculate happiness
     * @param j happiness index 
     */
    public void calculate_happiness(int j){
        if(g[j].bfno!=-1){
                happy[j]=g[j].happiness+b[g[j].bfno].happiness;
                compat[j]=b[g[j].bfno].budget-g[j].budget+abs(b[g[j].bfno].attractiveness-g[j].attractiveness)+abs(b[g[j].bfno].intelligence-g[j].intelligence);
               // System.out.println("<"+happy[j]+","+compat[j]+">");
            }
            
            else{
                happy[j]=-999;
                compat[j]=-999;
            }
    }
    /**
     * Function to calculate order of happiness
     * @param gs girl size
     * @param happy array containing happiness of couples
     * @param compat array containing compatibility of couples
     * @param happy1 array containing happiness of couples
     * @param compat1 array containing compatibility of couples
     */
    public void calculate_order_of_happiness(int gs,double happy[],int compat[],int happy1[],int compat1[]){
        int mi=-1,mj=-1;
        double max=-9999;
        for(int j=0;j<gs;j++){
            //happy1[j]=happy[j];
            if(happy[j]>max){
                mi=j;
                max=happy[j];
            }
            if(compat[j]>max){
                mj=j;
                max=compat[j];
            }
        }
        happy1[0]=mi;
        compat1[0]=mj;
        //System.out.print(happy1[0]);
        for(int i=1;i<=gs-1;i++){
            max=-9999;
            for(int j=0;j<gs;j++)
                if(happy[j]>=max && happy[j]<happy[happy1[i-1]]){
                    mi=j;
                    max=happy[j];
                }
            happy1[i]=mi;
            //System.out.print(happy1[i]);
                    
        }
        for(int i=1;i<=gs-1;i++){
            max=0;
            for(int j=0;j<gs;j++)
                if(compat[j]>=max && compat[j]<compat[compat1[i-1]]){
                    mj=j;
                    max=compat[j];
                }
            compat1[i]=mj;
           // System.out.print(compat1[i]+" ");
                    
        }
    }
    /**
     * 
     * @param c array containing details of relationships
     * @param g girl object array
     * @param b boy object array
     * @throws IOException when log file not found
     */
    public void createlog(int c[],girl g[],boy b[]) throws IOException{
        Date d=new Date();
        File file = new File("Log.txt");
        FileWriter writer = new FileWriter(file,true); 
        for(int i=0;i<gs;i++){
            
            if(g[i].status==1){
                writer.write(d.toString() +" "+"commitment "+g[i].name+" "+b[c[i]].name+" "+g[i].gift_price);
                writer.write(System.getProperty( "line.separator" ));
            
               // writer.write(+" ");
            }
        }
        writer.flush();
       writer.close();
    }
    
}
