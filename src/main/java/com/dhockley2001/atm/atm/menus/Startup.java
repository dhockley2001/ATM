package com.dhockley2001.atm.atm.menus;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Startup {

    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'£'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();
    
    public void getLogin() {

        System.out.println("Welcome to this ATM");
        System.out.println("");
    }

}
