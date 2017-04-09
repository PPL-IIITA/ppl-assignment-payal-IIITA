/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author win 8.1
 */
public class gift_type2 extends gift {
    /**
     * Function to prepare gift basket
     * @param b the object array of class boy
     * @param bindex  boy index
     * @param g the object array of class girl
     * @param gs no of girls
     * @param l the object array of class luxury_gift
     * @param ls no of luxury gifts
     * @param e the object array of class essential_gift
     * @param es no of essential gifts
     * @param u the object array of class utility_gift
     * @param us  no of utility gifts
     */
    public void gift_basket_2(boy b[],int bindex,girl g[],int gs,luxury_gift l[],int ls,essential_gift e[],int es,utility_gift u[],int us){
        /* gifts array sorted in asc order*/
               // System.out.println("4");

        int index=-1,i,j;
        int balance,value=0;
        for( i=0;i<gs;i++)
            if(g[i].status==1 && g[i].bfname==b[bindex].name)
                index=i;
        //System.out.println("i="+index);
        switch(b[bindex].property){
            case 1:
                balance=g[index].budget;
                i=1;
                balance-=(e[0].price+l[0].price+u[0].price);
                value+=(e[0].value+l[0].value+u[0].value);
                while(balance>0 && i<es){
                    balance-=e[i].price;
                    value+=e[i++].value;
                   
                }
                i=1;
                while(balance>0 ){
                    
                    balance-=l[i].price;
                    value+=(2*l[i++].value);
                    
                }
                g[index].gift_value+=value;
                //System.out.println("v="+value);
                g[index].gift_price+=g[index].budget-balance;
                b[bindex].happiness=b[bindex].budget-(g[index].budget-balance);
                g[index].calculate_happiness();
                
                break;
            case 2:
                balance=b[bindex].budget;
                i=ls-1;
                balance-=(e[0].price+l[0].price+u[0].price);
                value+=(e[0].value+l[0].value+u[0].value);
                while(i>0 && balance-l[i].price>=0){
                    balance-=l[i].price;
                    value+=(2*l[i--].value);
                }
                i=es-1;
                while(i>0 && balance-e[i].price>=0){
                    balance-=e[i].price;
                    value+=(e[i--].value);
                }
                g[index].gift_value=value;
                g[index].gift_price=b[bindex].budget-balance;
                b[bindex].happiness=g[index].calculate_happiness();
                break;
                
            case 3:
                balance=g[index].budget;
                balance-=(e[0].price+l[0].price+u[0].price);
                value+=(e[0].value+l[0].value+u[0].value);
                i=1;
                while(balance>0 && i<es){
                    balance-=e[i].price;
                    value+=e[i++].value;
                }
                i=1;
                if(l[1].price+ g[index].budget-balance <= b[bindex].budget){
                    
                    balance-=l[1].price;
                    value+=(2*l[1].value);
                }
                g[index].gift_value=value;
                g[index].gift_price=g[index].budget-balance;
                b[bindex].happiness=g[index].intelligence;
                g[index].calculate_happiness();
                break;
                
        }
        b[bindex].budget-=g[index].gift_value;
        
            
        
    
    
     
    }
}
