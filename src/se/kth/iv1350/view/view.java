package se.kth.iv1350.view;

import se.kth.iv1350.controller.*;

public class view {
    controller contr;
    public view(controller contr){
        this.contr = contr;
    }
    
    public void test(){
        contr.startSale();
        contr.registerItem(2, 2.0);
        contr.registerItem(2, 2.0);
        contr.registerItem(3, 4.0);
        contr.registerItem(1, 10.0);
        contr.registerItem(4, 5.0);
        contr.registerItem(6, 4.0);
        contr.pay(600.0); 
    }
}
