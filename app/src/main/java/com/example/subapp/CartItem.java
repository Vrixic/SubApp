package com.example.subapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

public class CartItem implements View.OnClickListener
{
    private BaseSub Sub;

    public CartItem(BaseSub inSub)
    {
        Sub = inSub;
    }

    public BaseSub GetSub()
    {
        return Sub;
    }

    DialogInterface.OnClickListener DialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
                    GenericInfo.GetInstance().RemoveFromCart(Sub.GetSubId());
                    GenericInfo.CartFragRef.RefreshCartDisplayItems();
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage("Are you sure?").setPositiveButton("Yes", DialogClickListener)
                .setNegativeButton("No", DialogClickListener).show();
    }
}
