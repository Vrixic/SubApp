package com.example.subapp;

import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

public class SubItem implements View.OnClickListener {
    public static final ArrayList<String> SubItemsArr = new ArrayList<String>(Arrays.asList("Fresh portabella mushrooms", "Fresh green bell peppers", "Onions", "Swiss Cheese", "Steak",
        "Peppers", "American Cheese", "Chicken", "Grilled Onions", "Mushrooms", "Jalapenos", "Applewood smoked bacon", "Lettuce", "Tomato",
            "$$$ Bacon", "$$$ Extra Cheese", "$$$ Extra Meat", "Chipotle Mayo", "Ranch Dressing", "Frank's Red Hot Sauce", "Blue Cheese"));

    private static final String[] SubCondimentsArr = {"Chipotle Mayo"};

    public static final int FRESH_PORTABELLA_MUSHROOMS      = 0;
    public static final int FRESH_GREEN_BELL_PEPPERS        = 1;
    public static final int ONIONS                          = 2;
    public static final int SWISS_CHEESE                    = 3;
    public static final int STEAK                           = 4;
    public static final int PEPPERS                         = 5;
    public static final int AMERICAN_CHEESE                 = 6;
    public static final int CHICKEN                         = 7;
    public static final int GRILLED_ONIONS                  = 8;
    public static final int MUSHROOMS                       = 9;
    public static final int JALAPENOS                       = 10;
    public static final int APPLEWOOD_SMOKED_BACON          = 11;
    public static final int LETTUCE                         = 12;
    public static final int TOMATO                          = 13;
    public static final int BACON                           = 14;
    public static final int EXTRA_CHEESE                    = 15;
    public static final int EXTRA_MEAT                      = 16;
    public static final int CHIPOTLE_MAYO                   = 17;
    public static final int RANCH_DRESSING                  = 18;
    public static final int FRANKS_RED_HOT_SAUCE            = 19;
    public static final int BLUE_CHEESE                     = 20;

    //public static final int CHIPOTLE_MAYO                   = 1;

    private int ID;
    private boolean IsIncluded;

    public SubItem(int inItemId)
    {
        ID = inItemId;
        IsIncluded = true;
    }

    public SubItem(int inItemId, boolean inIsIncluded)
    {
        ID = inItemId;
        IsIncluded = inIsIncluded;
    }

    public void Exclude()
    {
        IsIncluded = false;
    }

    public void Include()
    {
        IsIncluded = true;
    }

    public static String GetItemName(int inItemId)
    {
        return SubItemsArr.get(inItemId);
    }

    //public static String GetCondimentName(int inCondId) {return SubCondimentsArr[inCondId];}

    public boolean GetIsIncluded()
    {
        return IsIncluded;
    }

    public int GetId()
    {
        return ID;
    }

    @Override
    public void onClick(View view) {
        IsIncluded = !IsIncluded;
    }
}
