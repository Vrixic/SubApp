package com.example.subapp;

public class SubCreator {
    public static BaseSub MakeSubById(int inSubID)
    {
        switch (inSubID)
        {
            case GenericInfo.SUB_64:
                return MakeGrilledPortabellaMushroomAndSwiss();

            case GenericInfo.SUB_66:
                return MakePortabellaCheeseSteak();

            case GenericInfo.SUB_65:
                return MakePortabellaChickenCheeseSteak();

            case GenericInfo.SUB_17:
                return MakeFamousPhilly();

            case GenericInfo.SUB_43:
                return MakeChipotleCheeseSteak();

            case GenericInfo.SUB_56:
                return MakeBigKahunaCheeseSteak();

            case GenericInfo.SUB_16:
                return MakeChickenPhilly();

            case GenericInfo.SUB_42:
                return MakeChipotleChickenCheeseSteak();

            case GenericInfo.SUB_55:
                return MakeBigKahunaChickenCheeseSteak();

            case GenericInfo.SUB_26:
                return MakeBaconRanchChickenCheeseSteak();

            case GenericInfo.SUB_44:
                return MakeBuffaloChickenCheeseSteak();
        }

        return null;
    }

    public static BaseSub MakeGrilledPortabellaMushroomAndSwiss()
    {
        BaseSub Sub = new BaseSub(GenericInfo.SUB_64, GenericInfo.SUB_ID++);
        Sub.AddItem(new SubItem(SubItem.FRESH_PORTABELLA_MUSHROOMS));
        Sub.AddItem(new SubItem(SubItem.FRESH_GREEN_BELL_PEPPERS));
        Sub.AddItem(new SubItem(SubItem.ONIONS));
        Sub.AddItem(new SubItem(SubItem.SWISS_CHEESE));

        PostAddDefaultSubItems(Sub);

        return Sub;
    }

    public static BaseSub MakePortabellaCheeseSteak()
    {
        BaseSub Sub = new BaseSub(GenericInfo.SUB_66, GenericInfo.SUB_ID++);
        Sub.AddItem(new SubItem(SubItem.STEAK));
        Sub.AddItem(new SubItem(SubItem.FRESH_PORTABELLA_MUSHROOMS));
        Sub.AddItem(new SubItem(SubItem.PEPPERS));
        Sub.AddItem(new SubItem(SubItem.ONIONS));
        Sub.AddItem(new SubItem(SubItem.AMERICAN_CHEESE));

        // Addons
        Sub.AddItem(new SubItem(SubItem.BACON, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_CHEESE, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_MEAT, false));

        return Sub;
    }

    public static BaseSub MakePortabellaChickenCheeseSteak()
    {
        BaseSub Sub = new BaseSub(GenericInfo.SUB_65, GenericInfo.SUB_ID++);
        Sub.AddItem(new SubItem(SubItem.CHICKEN));
        Sub.AddItem(new SubItem(SubItem.FRESH_PORTABELLA_MUSHROOMS));
        Sub.AddItem(new SubItem(SubItem.PEPPERS));
        Sub.AddItem(new SubItem(SubItem.ONIONS));
        Sub.AddItem(new SubItem(SubItem.AMERICAN_CHEESE));

        // Addons
        Sub.AddItem(new SubItem(SubItem.BACON, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_CHEESE, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_MEAT, false));

        return Sub;
    }

    public static BaseSub MakeFamousPhilly()
    {
        BaseSub Sub = new BaseSub(GenericInfo.SUB_17, GenericInfo.SUB_ID++);
        Sub.AddItem(new SubItem(SubItem.GRILLED_ONIONS));
        Sub.AddItem(new SubItem(SubItem.PEPPERS));
        Sub.AddItem(new SubItem(SubItem.AMERICAN_CHEESE));

        // Addons
        Sub.AddItem(new SubItem(SubItem.BACON, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_CHEESE, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_MEAT, false));

        return Sub;
    }

    public static BaseSub MakeChipotleCheeseSteak()
    {
        BaseSub Sub = new BaseSub(GenericInfo.SUB_43, GenericInfo.SUB_ID++);
        Sub.AddItem(new SubItem(SubItem.GRILLED_ONIONS));
        Sub.AddItem(new SubItem(SubItem.PEPPERS));
        Sub.AddItem(new SubItem(SubItem.AMERICAN_CHEESE));
        Sub.AddItem(new SubItem(SubItem.CHIPOTLE_MAYO));

        // Addons
        Sub.AddItem(new SubItem(SubItem.BACON, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_CHEESE, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_MEAT, false));

        return Sub;
    }

    public static BaseSub MakeBigKahunaCheeseSteak()
    {
        BaseSub Sub = new BaseSub(GenericInfo.SUB_56, GenericInfo.SUB_ID++);
        Sub.AddItem(new SubItem(SubItem.GRILLED_ONIONS));
        Sub.AddItem(new SubItem(SubItem.PEPPERS));
        Sub.AddItem(new SubItem(SubItem.MUSHROOMS));
        Sub.AddItem(new SubItem(SubItem.JALAPENOS));
        Sub.AddItem(new SubItem(SubItem.AMERICAN_CHEESE));

        // Addons
        Sub.AddItem(new SubItem(SubItem.BACON, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_CHEESE, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_MEAT, false));

        return Sub;
    }

    public static BaseSub MakeChickenPhilly()
    {
        BaseSub Sub = new BaseSub(GenericInfo.SUB_16, GenericInfo.SUB_ID++);
        Sub.AddItem(new SubItem(SubItem.GRILLED_ONIONS));
        Sub.AddItem(new SubItem(SubItem.PEPPERS));
        Sub.AddItem(new SubItem(SubItem.AMERICAN_CHEESE));

        // Addons
        Sub.AddItem(new SubItem(SubItem.BACON, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_CHEESE, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_MEAT, false));

        return Sub;
    }

    public static BaseSub MakeChipotleChickenCheeseSteak()
    {
        BaseSub Sub = new BaseSub(GenericInfo.SUB_42, GenericInfo.SUB_ID++);
        Sub.AddItem(new SubItem(SubItem.GRILLED_ONIONS));
        Sub.AddItem(new SubItem(SubItem.PEPPERS));
        Sub.AddItem(new SubItem(SubItem.AMERICAN_CHEESE));
        Sub.AddItem(new SubItem(SubItem.CHIPOTLE_MAYO));

        // Addons
        Sub.AddItem(new SubItem(SubItem.BACON, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_CHEESE, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_MEAT, false));

        return Sub;
    }

    public static BaseSub MakeBigKahunaChickenCheeseSteak()
    {
        BaseSub Sub = new BaseSub(GenericInfo.SUB_55, GenericInfo.SUB_ID++);
        Sub.AddItem(new SubItem(SubItem.GRILLED_ONIONS));
        Sub.AddItem(new SubItem(SubItem.PEPPERS));
        Sub.AddItem(new SubItem(SubItem.MUSHROOMS));
        Sub.AddItem(new SubItem(SubItem.JALAPENOS));
        Sub.AddItem(new SubItem(SubItem.AMERICAN_CHEESE));

        // Addons
        Sub.AddItem(new SubItem(SubItem.BACON, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_CHEESE, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_MEAT, false));

        return Sub;
    }

    public static BaseSub MakeBaconRanchChickenCheeseSteak()
    {
        BaseSub Sub = new BaseSub(GenericInfo.SUB_26, GenericInfo.SUB_ID++);
        Sub.AddItem(new SubItem(SubItem.APPLEWOOD_SMOKED_BACON));
        Sub.AddItem(new SubItem(SubItem.LETTUCE));
        Sub.AddItem(new SubItem(SubItem.TOMATO));
        Sub.AddItem(new SubItem(SubItem.AMERICAN_CHEESE));
        Sub.AddItem(new SubItem(SubItem.RANCH_DRESSING));

        // Addons
        Sub.AddItem(new SubItem(SubItem.BACON, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_CHEESE, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_MEAT, false));

        return Sub;
    }

    public static BaseSub MakeBuffaloChickenCheeseSteak()
    {
        BaseSub Sub = new BaseSub(GenericInfo.SUB_26, GenericInfo.SUB_ID++);
        Sub.AddItem(new SubItem(SubItem.FRANKS_RED_HOT_SAUCE));
        Sub.AddItem(new SubItem(SubItem.LETTUCE));
        Sub.AddItem(new SubItem(SubItem.TOMATO));
        Sub.AddItem(new SubItem(SubItem.AMERICAN_CHEESE));
        Sub.AddItem(new SubItem(SubItem.BLUE_CHEESE));

        // Addons
        Sub.AddItem(new SubItem(SubItem.BACON, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_CHEESE, false));
        Sub.AddItem(new SubItem(SubItem.EXTRA_MEAT, false));

        return Sub;
    }

    private static void PostAddDefaultSubItems(BaseSub inSub)
    {
        // Addons
        inSub.AddItem(new SubItem(SubItem.BACON, false));
        inSub.AddItem(new SubItem(SubItem.EXTRA_CHEESE, false));
        inSub.AddItem(new SubItem(SubItem.EXTRA_MEAT, false));
    }

    public static String MakeSubItemsText(BaseSub inSub){
        String Sub = "";

        BaseSub OriginalSub = MakeSubById(inSub.GetNameId());

        for(int i = 0; i < inSub.GetItemsCount(); ++i){
            if(SubItem.GetItemName(inSub.GetItem(i).GetId()).charAt(0) == '$'){
                if(inSub.GetItem(i).GetIsIncluded()){
                    Sub += "\n\t\t\t";
                    Sub += SubItem.GetItemName(inSub.GetItem(i).GetId());
                }
            }else if(inSub.GetItemsCount() != OriginalSub.GetItemsCount() && i >= OriginalSub.GetItemsCount() - 3){
                if(inSub.GetItem(i).GetIsIncluded()) {
                    Sub += "\n\t\t\t";
                    Sub += "+" + SubItem.GetItemName(inSub.GetItem(i).GetId());
                }
            } else if(!inSub.GetItem(i).GetIsIncluded()){
                Sub += "\n\t\t\t";
                Sub += "--" + SubItem.GetItemName(inSub.GetItem(i).GetId());
            }
        }

        return Sub;
    }

    public static String MakeSubNameText(BaseSub inSub)
    {
        String Sub = GenericInfo.GetInstance().GetSubById(inSub.GetNameId());

        int Index = 1;
        for(; Index < Sub.length(); ++Index)
        {
            if(Sub.charAt(Index) == 10)
            {
                break;
            }
        }

        String SubNum = Sub.substring(0, Index + 1);
        Sub = Sub.substring(Index + 1);

        if(inSub.GetSubSize() == SubSize.Regular){
            Sub = "Regular " + Sub;
        }else{
            Sub = "Giant " + Sub;
        }

        Sub = SubNum + Sub;

        return Sub;
    }

    public static String MakeSubReceiptString(BaseSub inSub)
    {
        String Sub = GenericInfo.GetInstance().GetSubById(inSub.GetNameId());

        int Index = 1;
        for(; Index < Sub.length(); ++Index)
        {
            if(Sub.charAt(Index) == 10)
            {
                break;
            }
        }

        String SubNum = Sub.substring(0, Index);
        Sub = Sub.substring(Index + 1);

        if(inSub.GetSubSize() == SubSize.Regular){
            Sub = "Regular " + Sub;
        }else{
            Sub = "Giant " + Sub;
        }

        Sub = SubNum + " " + Sub;
        Sub = ReceiptCreator.LEFT_ALIGNMENT + Sub;
        Sub += "\n";

        BaseSub OriginalSub = MakeSubById(inSub.GetNameId());

        for(int i = 0; i < inSub.GetItemsCount(); ++i){
            if(SubItem.GetItemName(inSub.GetItem(i).GetId()).charAt(0) == '$'){
                if(inSub.GetItem(i).GetIsIncluded()){
                    Sub += "   " + SubItem.GetItemName(inSub.GetItem(i).GetId());
                    Sub += "\n";
                }
            }else if(inSub.GetItemsCount() != OriginalSub.GetItemsCount() && i >= OriginalSub.GetItemsCount() - 3){
                if(inSub.GetItem(i).GetIsIncluded()) {
                    Sub += "   +" + SubItem.GetItemName(inSub.GetItem(i).GetId());
                    Sub += "\n";
                }
            } else if(!inSub.GetItem(i).GetIsIncluded()){
                Sub += "   -" + SubItem.GetItemName(inSub.GetItem(i).GetId());
                Sub += "\n";
            }
        }

        return Sub;
    }

}
