/**
 * <h> Class containing details of girls<h>
 * <p>
 *      contains a method to find a suitable boyfriend </p>
 * <p>
 *      contains a method to calculate the happiness of the girls </p>
 */
//class girl
import static java.lang.Math.*;
import java.util.*;


public class girl {
    String name;
    int attractiveness,budget,intelligence; //input from file
    int property; // 1.choosy 2.normal 3.desperate
    
    int choice;// 1.attractive,2.rich,3.intelligence
    int status;//0 single 1.committed
    String bfname;  //the boyfriend's name
    int gift_price,gift_value;  //gifts price and value
    double happiness;
    public girl(){
        status=0;
        bfname=null;
    }
    /**
     * 
     * @param b  the object array of boys
     * @param n. no of boys
     * @return  index of the suitable boyfriend
     */
    public int pair_making(boy b[],int n){ //boy b is according to girls choice
        float max=0;
        int index=-1;
        switch(choice){
            case 1:for(int i=0;i<n;i++)
                    if(b[i].budget>=budget && b[i].attractiveness>max && b[i].status==0 && attractiveness>=b[i].attraction_require){
                        max=b[i].attractiveness;
                        index=i;
                      }
                    break;
            case 2:for(int i=0;i<n;i++)
                    if(b[i].budget>=budget && b[i].budget>max && b[i].status==0 && attractiveness>=b[i].attraction_require){
                        max=b[i].budget;
                        index=i;
                      }
                    break;
            case 3:for(int i=0;i<n;i++)
                    if(b[i].budget>=budget && b[i].intelligence>max && b[i].status==0 && attractiveness>=b[i].attraction_require){
                        max=b[i].intelligence;
                        index=i;
                      }
                    break;
        }
        if(index!=-1){
            status=1;
            b[index].status=1;
            bfname=b[index].name;
        }
        
        return index;     // for addition in vector
    }
    /**
     * Function to calculate happiness of the girl
     * @return the happiness value 
     */
    public double calculate_happiness(){
        //double cost=gift_price *1.0;
        if(status==1){
            switch(property){
                case 1: happiness=log(gift_price);
                        break;
                case 2: happiness=gift_price-budget+gift_value;
                        break;
                case 3: happiness=exp(gift_price-budget);
                        break;
            }
        }
        return happiness;
    }
    
}
