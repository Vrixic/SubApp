package com.code.JMHSub;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.code.JMHSUb.R;
import com.code.JMHSUb.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
      binding = FragmentFirstBinding.inflate(inflater, container, false);
      return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        int MaxButtonWidth = (width - 30) / 2;

        // Set all the buttons text on start up
        binding.Button1.setText(GenericInfo.GetInstance().GetSubById(GenericInfo.SUB_64));
        binding.Button2.setText(GenericInfo.GetInstance().GetSubById(GenericInfo.SUB_66));
        binding.Button3.setText(GenericInfo.GetInstance().GetSubById(GenericInfo.SUB_65));
        binding.Button4.setText(GenericInfo.GetInstance().GetSubById(GenericInfo.SUB_17));
        binding.Button5.setText(GenericInfo.GetInstance().GetSubById(GenericInfo.SUB_43));
        binding.Button6.setText(GenericInfo.GetInstance().GetSubById(GenericInfo.SUB_56));
        binding.Button7.setText(GenericInfo.GetInstance().GetSubById(GenericInfo.SUB_16));
        binding.Button8.setText(GenericInfo.GetInstance().GetSubById(GenericInfo.SUB_42));
        binding.Button9.setText(GenericInfo.GetInstance().GetSubById(GenericInfo.SUB_55));
        binding.Button10.setText(GenericInfo.GetInstance().GetSubById(GenericInfo.SUB_26));
        binding.Button11.setText(GenericInfo.GetInstance().GetSubById(GenericInfo.SUB_44));

        binding.Button1.setMaxWidth(MaxButtonWidth);
        binding.Button1.setWidth(MaxButtonWidth);

        binding.Button2.setMaxWidth(MaxButtonWidth);
        binding.Button2.setWidth(MaxButtonWidth);

        binding.Button3.setMaxWidth(MaxButtonWidth);
        binding.Button3.setWidth(MaxButtonWidth);

        binding.Button4.setMaxWidth(MaxButtonWidth);
        binding.Button4.setWidth(MaxButtonWidth);

        binding.Button5.setMaxWidth(MaxButtonWidth);
        binding.Button5.setWidth(MaxButtonWidth);

        binding.Button6.setMaxWidth(MaxButtonWidth);
        binding.Button6.setWidth(MaxButtonWidth);

        binding.Button7.setMaxWidth(MaxButtonWidth);
        binding.Button7.setWidth(MaxButtonWidth);

        binding.Button8.setMaxWidth(MaxButtonWidth);
        binding.Button8.setWidth(MaxButtonWidth);

        binding.Button9.setMaxWidth(MaxButtonWidth);
        binding.Button9.setWidth(MaxButtonWidth);

        binding.Button10.setMaxWidth(MaxButtonWidth);
        binding.Button10.setWidth(MaxButtonWidth);

        binding.Button11.setMaxWidth(MaxButtonWidth);
        binding.Button11.setWidth(MaxButtonWidth);

        binding.Button12.setMaxWidth(MaxButtonWidth);
        binding.Button12.setWidth(MaxButtonWidth);

        // Bind all of the on click button listeners
        binding.Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetSubTextAndChangeScreen(GenericInfo.SUB_64);
            }
        });

        binding.Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetSubTextAndChangeScreen(GenericInfo.SUB_66);
            }
        });

        binding.Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetSubTextAndChangeScreen(GenericInfo.SUB_65);
            }
        });

        binding.Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetSubTextAndChangeScreen(GenericInfo.SUB_17);
            }
        });

        binding.Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetSubTextAndChangeScreen(GenericInfo.SUB_43);
            }
        });

        binding.Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetSubTextAndChangeScreen(GenericInfo.SUB_56);
            }
        });

        binding.Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetSubTextAndChangeScreen(GenericInfo.SUB_16);
            }
        });

        binding.Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetSubTextAndChangeScreen(GenericInfo.SUB_42);
            }
        });

        binding.Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetSubTextAndChangeScreen(GenericInfo.SUB_55);
            }
        });

        binding.Button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetSubTextAndChangeScreen(GenericInfo.SUB_26);
            }
        });

        binding.Button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetSubTextAndChangeScreen(GenericInfo.SUB_44);
            }
        });

        binding.CartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_CartFragment);
            }
        });
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void SetSubTextAndChangeScreen(int subId)
    {
        GenericInfo.GetInstance().SetSubTextString(GenericInfo.GetInstance().GetSubById(subId));

        NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_SubScreen1);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        ((MainActivity)getActivity()).SetActionBarTitle("Hot Subs");
    }
}