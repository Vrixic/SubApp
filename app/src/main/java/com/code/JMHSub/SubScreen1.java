package com.code.JMHSub;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


import com.code.JMHSUb.R;
import com.code.JMHSUb.databinding.FragmentSubScreen1Binding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SubScreen1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubScreen1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView SubTextView = null;

    LinearLayout ItemVerticalLayout = null;

    BaseSub CurrentSub = null;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentSubScreen1Binding Binding;

    private static boolean FirstFalsePositive = false;

    public SubScreen1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SubScreen1.
     */
    // TODO: Rename and change types and number of parameters
    public static SubScreen1 newInstance(String param1, String param2) {
        SubScreen1 fragment = new SubScreen1();
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
        Binding = FragmentSubScreen1Binding.inflate(inflater, container, false);
        return Binding.getRoot();
    }

    public BaseSub CopyCurrentSub()
    {
        BaseSub Sub = SubCreator.MakeSubById(GenericInfo.GetInstance().GetCurrentSubId());
        Sub.RemoveAllItems();

        for(int i = 0; i < CurrentSub.GetItemsCount(); ++i)
        {
            Sub.AddItem(new SubItem(CurrentSub.GetItem(i).GetId(), CurrentSub.GetItem(i).GetIsIncluded()));
        }

        Sub.SetSubSize(CurrentSub.GetSubSize());

        return Sub;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;

        Binding.buttonAddToCart.getLayoutParams().width = width - 30;

        Binding.buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GenericInfo.GetInstance().AddToCart(CurrentSub);
                CurrentSub = CopyCurrentSub();

                ItemVerticalLayout.removeAllViews();
                DisplayCurrentSub();
            }
        });

        Binding.CartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SubScreen1.this)
                        .navigate(R.id.action_SubScreen1_to_CartFragment);
            }
        });
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        ShowSubOptions();
    }

    public void ShowSubOptions()
    {
        SubTextView = (TextView) getView().findViewById(R.id.subTextView1);
        ItemVerticalLayout = (LinearLayout) getView().findViewById(R.id.itemsLinearLayout);

        // Print the sub text string that is being stored
        SubTextView.setText(GenericInfo.GetInstance().GetSubTextString());
        ((MainActivity)getActivity()).SetActionBarTitle("Sub");

        if(ItemVerticalLayout != null)
        {
            CurrentSub = SubCreator.MakeSubById(GenericInfo.GetInstance().GetCurrentSubId());
            DisplayCurrentSub();
        }
    }

    public void DisplayCurrentSub()
    {
        ItemVerticalLayout.removeAllViews();
        ArrayList<String> CustomizeArrayList = new ArrayList<>(SubItem.SubItemsArr);
        CustomizeArrayList.add(0, "Nothing");

        for(int i = 0; i < CurrentSub.GetItemsCount(); ++i)
        {
            LinearLayout HLayout = new LinearLayout(ItemVerticalLayout.getContext());
            HLayout.setOrientation(LinearLayout.HORIZONTAL);

            CheckBox checkBox = new CheckBox(HLayout.getContext());
            checkBox.setChecked(CurrentSub.GetItem(i).GetIsIncluded());
            checkBox.setOnClickListener(CurrentSub.GetItem(i));

            TextView TView = new TextView(HLayout.getContext());
            TView.setText(SubItem.GetItemName(CurrentSub.GetItem(i).GetId()));
            TView.setTextSize(30);
            HLayout.addView(TView);

            HLayout.addView(checkBox);
            ItemVerticalLayout.addView(HLayout);

            CustomizeArrayList.remove(SubItem.GetItemName(CurrentSub.GetItem(i).GetId()));
        }

        LinearLayout HLayout = new LinearLayout(ItemVerticalLayout.getContext());
        HLayout.setOrientation(LinearLayout.HORIZONTAL);

       TextView TView = new TextView(HLayout.getContext());
       TView.setText("Sub Size");
       TView.setTextSize(30);
       HLayout.addView(TView);

       HLayout.setPadding(0, 0, 10, 0);

       Spinner DropDown = new Spinner(HLayout.getContext(), Spinner.MODE_DROPDOWN);
       ArrayList<String> arrayList = new ArrayList<>();
       arrayList.add("Regular");
       arrayList.add("Giant");
       ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),                         android.R.layout.simple_spinner_item, arrayList);
       arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       DropDown.setAdapter(arrayAdapter);
       DropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if(adapterView.getItemAtPosition(i).toString().equals("Regular"))
               {
                   CurrentSub.SetSubSize(SubSize.Regular);
               }else if(adapterView.getItemAtPosition(i).toString().equals("Giant")){
                   CurrentSub.SetSubSize(SubSize.Giant);
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {
               CurrentSub.onNothingSelected(adapterView);
           }
       });

        HLayout.addView(DropDown);
        ItemVerticalLayout.addView(HLayout);

        LinearLayout CustomizeLayout = new LinearLayout(ItemVerticalLayout.getContext());
        CustomizeLayout.setOrientation(LinearLayout.HORIZONTAL);

        TextView CustomizeView = new TextView(CustomizeLayout.getContext());
        CustomizeView.setText("Add Items");
        CustomizeView.setTextSize(30);
        CustomizeLayout.addView(CustomizeView);

        Spinner CustomizeDropDown = new Spinner(CustomizeLayout.getContext(), Spinner.MODE_DROPDOWN);

        ArrayAdapter<String> ArrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, CustomizeArrayList);
        ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CustomizeDropDown.setAdapter(ArrayAdapter);
        FirstFalsePositive = true;
        CustomizeDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(FirstFalsePositive){
                    FirstFalsePositive = false;
                    return;
                }
                if(i == 0) {return;}
                CurrentSub.onItemSelected(adapterView, view, i, l);
                CurrentSub = CopyCurrentSub();
                ItemVerticalLayout.removeAllViews();
                DisplayCurrentSub();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                CurrentSub.onNothingSelected(adapterView);
            }
        });

        CustomizeLayout.addView(CustomizeDropDown);
        ItemVerticalLayout.addView(CustomizeLayout);

        if(CurrentSub.GetSubSize() == SubSize.Giant){
            DropDown.setSelection(1);
        }
    }
}