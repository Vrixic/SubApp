package com.code.JMHSub;

public class ReceiptCreator
{
    public static final String LEFT_ALIGNMENT  = "[L]";
    public static final String RIGHT_ALIGNMENT  = "[R]";
    public static final String CENTER_ALIGNMENT  = "[C]";

    public static String BoldString(String str)
    {
        return ReceiptString(str, 'b');
    }

    public static String UnderlineString(String str)
    {
        return ReceiptString(str, 'u');
    }

    private static String ReceiptString(String str, char c)
    {
        return "<" + c + ">" + str + "</" + c + ">";
    }

}
