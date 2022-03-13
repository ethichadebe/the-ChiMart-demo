package com.example.chillersmarket.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chillersmarket.CategoryDetailActivity;
import com.example.chillersmarket.EditProfileActivity;
import com.example.chillersmarket.R;

public class AccountFragment extends Fragment {

    enum redirectToBrowser {
        LISTING,
        HELP
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        //Navigate to Edit Profile Fragment
        toDifferentFragment(view.findViewById(R.id.txtEditProfile), new EditProfileFragment());

        //Navigate to Change Password Fragment
        toDifferentFragment(view.findViewById(R.id.txtChangePassword), new ChangePasswordFragment());

        //Navigate to Order History Fragment
        toDifferentFragment(view.findViewById(R.id.txtOrderHistory), new OrderHistoryFragment());

        //Setup AddListing textview to redirect to a browser site
        redirectToBrowserSetup(view.findViewById(R.id.txtAddListing), redirectToBrowser.LISTING);

        //Setup Help textview to redirect to a browser site
        redirectToBrowserSetup(view.findViewById(R.id.txtHelp), redirectToBrowser.HELP);

        return view;
    }

    //Navigate to a different Fragment
    private void toDifferentFragment(TextView textView, Fragment fragment){
        textView.setOnClickListener(v -> {
//            getActivity().getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, fragment)
//                    .commit();

            Intent intent = new Intent(getContext(), EditProfileActivity.class);
            startActivity(intent);

        });
    }

    //Navigate to browser page
    private void redirectToBrowserSetup(TextView textView, redirectToBrowser redirect){
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = null;

                switch (redirect){
                    case LISTING:
                        url = "https://chillersmarket.com/submit-listing/";
                        break;
                    case HELP:
                        url = "https://chillersmarket.com/contact-us/";
                        break;
                    default:
                        break;
                }

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
