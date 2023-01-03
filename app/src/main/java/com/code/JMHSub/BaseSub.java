package com.code.JMHSub;

import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

enum SubSize
{
    Regular,
    Giant
};

public class BaseSub implements AdapterView.OnItemSelectedListener{

    private int SubID;
    private int NameID;

    private SubSize Size;

    private ArrayList<SubItem> Items;

    public BaseSub(int inNameID, int inSubID)
    {
        NameID = inNameID;
        SubID = inSubID;
        Items = new ArrayList<SubItem>();
        Size = SubSize.Regular;
    }

    public void AddItem(SubItem inItem) {
        Items.add(inItem);
    }

    public SubItem GetItem(int index)
    {
        return Items.get(index);
    }

    public void ExcludeItem(int index)
    {
        Items.get(index).Exclude();
    }

    public void IncludeItem(int index)
    {
        Items.get(index).Include();
    }

    public int GetSubId() {return SubID;}

    public int GetNameId()
    {
        return NameID;
    }

    public int GetItemsCount()
    {
        return Items.size();
    }

    public SubSize GetSubSize() {return Size;}

    public void SetSubSize(SubSize inSize) { Size = inSize;}

    public boolean HasItem(SubItem inSubItem){
        return Items.contains(inSubItem);
    }

    public void RemoveAllItems(){Items.clear();}

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Items.add(Items.size() - 3, new SubItem(SubItem.SubItemsArr.indexOf(adapterView.getItemAtPosition(i).toString())));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Size = SubSize.Regular;
    }
}
