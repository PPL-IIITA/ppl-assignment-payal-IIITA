/**
 * <h1> Class to initialize object arrays and create log file</h1>
 * <p> contains sizes of all the object arrays</p>
 * <p> contains a function to create log of relationship events</p>
 */

/*INITIALIZES THE OBJECT ARRAYS*/
import java.io.*;
import static java.lang.Math.abs;
import java.util.*;



public class initialize {
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
     * @param g girl object array
     * @param b boy object array
     * @param e essential_gift object array
     * @param l luxury_gift object array
     * @param u utility_gift object array
     * @param c array containing details of relationships
     * @param happy array containing happiness of couples
     * @param compat array containing compatibility of couples
     * @throws IOException 
     */
    public initialize(String [] args,girl g[],boy b[],essential_gift e[],luxury_gift l[],utility_gift u[],int[] c,double[] happy,int[] compat,double[] happy1,int[] compat1) throws IOException{
     
        
       Scanner gl= new Scanner(new FileReader(args[0]));
       Scanner bo =new Scanner(new FileReader(args[1]));
       Scanner eg =new Scanner(new FileReader(args[2]));
       Scanner lg =new Scanner(new FileReader(args[3]));
       Scanner ug =new Scanner(new FileReader(args[4]));
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
        for(int i=0;i<gs;i++){
            int j=g[i].pair_making(b,bs);
            if(j!=-1)
            c[i]=j;
            //System.out.println("<"+i+","+j+">");
        }
        for(int i=0;i<bs;i++)
            if(b[i].status==1)
                b[i].gift_basket(g,gs,l,ls,e,es);
        
        for(int j=0;j<gs;j++){
            if(c[j]!=-1){
                happy[j]=g[j].happiness+b[c[j]].happiness;
                compat[j]=b[c[j]].budget-g[j].budget+abs(b[c[j]].attractiveness-g[j].attractiveness)+abs(b[c[j]].intelligence-g[j].intelligence);
                //System.out.println("<"+happy[j]+","+compat[j]+">");
            }
        }
        for(int j=0;j<gs;j++){
            happy1[j]=happy[j];
            compat1[j]=compat[j];
        }
        for(int i=0;i<gs;i++){
            for(int j=i;j<gs;j++)
                if(happy1[i]<happy1[j]){
                    double temp=happy1[i];
                    happy1[i]=happy1[j];
                    happy1[j]=temp;
                }
                    
        }
        for(int i=0;i<gs;i++){
            for(int j=i;j<gs;j++)
                if(compat1[i]<compat1[j]){
                    int temp=compat1[i];
                    compat1[i]=compat1[j];
                    compat1[j]=temp;
                }
                    
        }
        
        
        
        
    }
    /**
     * 
     * @param c array containing details of relationships
     * @param g girl object array
     * @param b boy object array
     * @throws IOException 
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
