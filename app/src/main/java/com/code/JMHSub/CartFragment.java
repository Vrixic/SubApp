package com.code.JMHSub;

import android.Manifest;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.code.JMHSUb.R;
import com.code.JMHSUb.databinding.FragmentCartBinding;
import com.dantsu.escposprinter.EscPosPrinter;
import com.dantsu.escposprinter.connection.bluetooth.BluetoothConnection;
import com.dantsu.escposprinter.connection.bluetooth.BluetoothPrintersConnections;
import com.dantsu.escposprinter.exceptions.EscPosBarcodeException;
import com.dantsu.escposprinter.exceptions.EscPosConnectionException;
import com.dantsu.escposprinter.exceptions.EscPosEncodingException;
import com.dantsu.escposprinter.exceptions.EscPosParserException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentCartBinding Binding;

    private LinearLayout CartLayout = null;

    public CartFragment() {
        // Required empty public constructor
        GenericInfo.CartFragRef = this;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Binding = FragmentCartBinding.inflate(inflater, container, false);
        return Binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Binding.clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GenericInfo.GetInstance().ClearCart();
                CartLayout.removeAllViews();
            }
        });

        Binding.printButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintReceipt();
            }
        });
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        ((MainActivity) getActivity()).SetActionBarTitle("Cart");

        if (CartLayout == null) {
            CartLayout = (LinearLayout) getView().findViewById(R.id.cartLayout);
        }

        RefreshCartDisplayItems();
    }

    public void RefreshCartDisplayItems() {
        CartLayout.removeAllViews();
        for (int i = 0; i < GenericInfo.GetInstance().Cart.size(); ++i) {
            LinearLayout HLayout = new LinearLayout(getContext());
            HLayout.setOrientation(LinearLayout.HORIZONTAL);
            HLayout.setBackground(ContextCompat.getDrawable(getContext(), android.R.drawable.editbox_dropdown_light_frame));

            LinearLayout VLayout = new LinearLayout(getContext());
            VLayout.setOrientation(LinearLayout.VERTICAL);

            TextView TView2 = new TextView(getContext());
            TextView TView1 = new TextView(getContext());

            Button MinusBtn = new Button(getContext());
            MinusBtn.setText("-");
            MinusBtn.setOnClickListener(GenericInfo.GetInstance().Cart.get(i));

            String SubName = SubCreator.MakeSubNameText(GenericInfo.GetInstance().Cart.get(i).GetSub());
            String Text = SubCreator.MakeSubItemsText(GenericInfo.GetInstance().Cart.get(i).GetSub());

            TView1.setText(SubName);
            TView1.setTextSize(30);

            TView2.setText(Text + "\n\n");
            TView2.setTextSize(25);

            VLayout.addView(TView1);
            VLayout.addView(TView2);

            HLayout.addView(MinusBtn);
            HLayout.addView(VLayout);

            CartLayout.addView(HLayout);
        }
    }

    public void PrintReceipt() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.BLUETOOTH) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.BLUETOOTH}, MainActivity.PERMISSION_BLUETOOTH);
        } else if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.BLUETOOTH_ADMIN) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.BLUETOOTH_ADMIN}, MainActivity.PERMISSION_BLUETOOTH_ADMIN);
        } else if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S && ContextCompat.checkSelfPermission(getContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.BLUETOOTH_CONNECT}, MainActivity.PERMISSION_BLUETOOTH_CONNECT);
        } else if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S && ContextCompat.checkSelfPermission(getContext(), Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.BLUETOOTH_SCAN}, MainActivity.PERMISSION_BLUETOOTH_SCAN);
        } else {
            Print();
        }
    }

    public void ShowApkNotSupportedMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Are you sure?").setPositiveButton("Yes", null)
                .setNegativeButton("No", null).show();
    }

    public void Print(){
        if(GenericInfo.GetInstance().Cart.size() < 1) {return;}

        BluetoothConnection Device = BluetoothPrintersConnections.selectFirstPaired();
        EscPosPrinter Printer = null;

        if (Device == null) {
            Toast.makeText(getContext(), "Error: unable to find a printer", Toast.LENGTH_SHORT).show();
            return;
        } else {
            try {
                Printer = new EscPosPrinter(Device, 0, 72f, 48);
            } catch (EscPosConnectionException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
            }

            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.BLUETOOTH_CONNECT}, MainActivity.PERMISSION_BLUETOOTH_CONNECT);
                return;
            }
            Toast.makeText(getContext(), "Printer Selected: " + Device.getDevice().getName(), Toast.LENGTH_SHORT).show();
        }

        String ReceiptText = "";
        for (int i = 0; i < GenericInfo.GetInstance().Cart.size(); ++i) {
            ReceiptText += SubCreator.MakeSubReceiptString(GenericInfo.GetInstance().Cart.get(i).GetSub());
        }

        try {
            Printer.printFormattedTextAndCut("[C]<u><font size='big'>ORDER</font></u>\n" +
                    "[L]\n" +
                    "[C]================================\n" +
                    "[L]\n" + ReceiptText, 255);

            Printer.printFormattedTextAndCut("[C]<u><font size='big'>ORDER</font></u>\n" +
                    "[L]\n" +
                    "[C]================================\n" +
                    "[L]\n" + ReceiptText, 255);

            Toast.makeText(getContext(), "Sent to printer", Toast.LENGTH_SHORT).show();
        } catch (EscPosParserException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
        } catch (EscPosEncodingException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
        } catch (EscPosBarcodeException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
        } catch (EscPosConnectionException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}