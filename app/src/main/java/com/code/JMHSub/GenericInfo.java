package com.code.JMHSub;

import java.util.ArrayList;

/**
 * Singleton that contains all information
 */

public class GenericInfo {

    public static int SUB_ID = 0;

    public static final int SUB_64 = 0;
    public static final int SUB_66 = 1;
    public static final int SUB_65 = 2;
    public static final int SUB_17 = 3;
    public static final int SUB_43 = 4;
    public static final int SUB_56 = 5;
    public static final int SUB_16 = 6;
    public static final int SUB_42 = 7;
    public static final int SUB_55 = 8;
    public static final int SUB_26 = 9;
    public static final int SUB_44 = 10;

    private static GenericInfo Instance = null;

    private int SubTextId = -1;
    private String SubTextString = null;

    private static final String[] SubsArr = {"#64\nGRILLED PORTABELLA MUSHROOM & SWISS", "#66\nPORTABELLA CHEESE STEAK",
            "#65\nPORTABELLA CHICKEN CHEESE STEAK", "#17\nMIKE'S FAMOUS PHILLY","#43\nCHIPOTLE CHEESE STEAK", "#56\nBIG KAHUNA CHEESE STEAK",
            "#16\nMIKE'S CHICKEN PHILLY", "#42\nCHIPOTLE CHICKEN CHEESE STEAK", "#55\nBIG KAHUNA CHEESE CHEESE STEAK",
            "#26\nBACON RANCH CHICKEN CHEESE STEAK", "#44\nBUFFALO CHICKEN CHEESE STEAK"};

    public ArrayList<CartItem> Cart = new ArrayList<CartItem>();

    public static CartFragment CartFragRef = null;

    private GenericInfo()
    {

    }

    public static GenericInfo GetInstance()
    {
        if(Instance == null)
        {
            Instance = new GenericInfo();
        }

        return Instance;
    }

    public String GetSubById(int id)
    {
        SubTextId = id;
        return SubsArr[id];
    }

    public void SetSubTextString(String str)
    {
        SubTextString = str;
    }

    public String GetSubTextString()
    {
        return SubTextString;
    }

    public int GetCurrentSubId() {
        return SubTextId;
    }

    public void AddToCart(BaseSub inSub)
    {
        Cart.add(new CartItem(inSub));
    }

    // Removes a sub by id
    public boolean RemoveFromCart(int subId)
    {
        for(int i = 0; i < Cart.size(); ++i)
        {
            if(Cart.get(i).GetSub().GetSubId() == subId)
            {
                Cart.remove(i);
                return true;
            }
        }

        return false;
    }

    public void ClearCart()
    {
        Cart.clear();
        SUB_ID = 0;
    }
}
