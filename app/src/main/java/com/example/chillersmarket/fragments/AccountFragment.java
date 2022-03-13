package com.example.chillersmarket.fragments;

import android.app.Activity;
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

import com.example.chillersmarket.ChangePasswordActivity;
import com.example.chillersmarket.EditProfileActivity;
import com.example.chillersmarket.NotificationSettingActivity;
import com.example.chillersmarket.OrderHistoryActivity;
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

        //Navigate to Edit Profile Activity
        toDifferentActivity(view.findViewById(R.id.txtEditProfile), new EditProfileActivity());

        //Navigate to Change Password Activity
        toDifferentActivity(view.findViewById(R.id.txtChangePassword), new ChangePasswordActivity());

        //Navigate to Order History Activity
        toDifferentActivity(view.findViewById(R.id.txtOrderHistory), new OrderHistoryActivity());

        //Setup AddListing textview to redirect to a browser site
        redirectToBrowserSetup(view.findViewById(R.id.txtAddListing), redirectToBrowser.LISTING);

        //Setup Help textview to redirect to a browser site
        redirectToBrowserSetup(view.findViewById(R.id.txtHelp), redirectToBrowser.HELP);

        toDifferentActivity(view.findViewById(R.id.txtNotifications), new NotificationSettingActivity());

        return view;
    }

    //Navigate to a different Fragment
    private void toDifferentActivity(final TextView textView, final Activity activity){
        textView.setOnClickListener(v -> {
            final Intent intent = new Intent(getContext(), activity.getClass());
            startActivity(intent);
        });
    }

    //Navigate to browser page
    private void redirectToBrowserSetup(final TextView textView, final redirectToBrowser redirect){
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
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
