package se.kth.iv1350.startup;

import se.kth.iv1350.view.*;
import se.kth.iv1350.controller.*;
import se.kth.iv1350.integration.*;


/**
  Contains the <code>main<code> method. All startup of the program.
 */
public class startup {
    /**
    *Starts application
    @param args the application does not take any parameters. 
    */
    public static void main(String[] args) {
        ExternalInventory extInv = new ExternalInventory();
        ExternalAccounting extAcc = new ExternalAccounting();
        Printer printer = new Printer();
        controller contr = new controller(extInv, extAcc, printer);
        new view(contr).test();
    }
}
