package com.example.chillersmarket.fragments;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chillersmarket.R;

public class ProductDetailsFragment extends Fragment {
    private TextView tvDetails;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product_details,container,false);

        tvDetails = v.findViewById(R.id.tvDetails);

        tvDetails.setText("Quick Spec:\n" +
                "Display – Main: 6.7\" Dynamic AMOLED 2X | Cover: 1.9\" Super AMOLED 60Hz\n" +
                "Memory - 8GB RAM | 256GB ROM\n" +
                "Camera - Rear Camera: 12MP + 12MP | Front Camera: 10MP\n" +
                "SIM - Dual SIM \n" +
                "Battery – 3300mAh\n" +
                "\n" +
                "Features:\n" +
                "A good thing just got better\n" +
                "- Folds into your pocket. Tucks into your purse. Slips into your skinniest jeans. Then you can take it out and it flips open into a full-screened 5G smartphone and flexes to your favorite angles.\n" +
                "Big things happen, even on the small screen\n" +
                "- Check messages, take photos, play music and so much more, all without opening your phone. The 1.9-inch Cover Screen displays notifications and lets you intuitively interact with them. Pick your favorite display options for easy access, then make it your own with different styles and colors.\n" +
                "Main Screen. Welcome to the main attraction\n" +
                "- Silky smooth scrolling with 120Hz on the 6.7-inch Infinity Flex Display delivers smooth scrolling, swiping, dragging and dropping. It even optimizes the refresh rate based on what you're viewing.7 And with Dynamic AMOLED 2X in the mix, it's the most vivid, brightest and smoothest display in Galaxy Z ever.\n" +
                "Quick Shot\n" +
                "- No time to unfold? Take selfies with the dual Rear Camera — the Cover Screen will give you a preview. Simply hit the volume button on the side to trigger the shutter.\n" +
                "Flex Mode Camera\n" +
                "- Capturing Single Take moments has changed for the better. Now you can take photos and videos more easily than you ever could before with Flex mode. All you have to do is adjust the angle and step back for hands-free selfies.\n" +
                "Dual Preview\n" +
                "- Let your friends check their pose with Dual Preview on the Cover Screen so everyone looks good on the first shot.\n" +
                "Multitasking\n" +
                "- Split your screen in two and multitask like a pro. You can catch up on your YouTube playlist and text your friend — then send off a stunning selfie and watch the reactions roll in. And when you're watching something, let the sound immerse you with Dolby Atmos and stereo speakers.\n" +
                "IPX8. Wet phone? No sweat\n" +
                "- Make a splash with the world’s first water-resistant foldable smartphone, with an IPX8 rating. It can hang out in 1.5 meters of water for up to 30 minutes without leaving the live stream (pun intended).\n" +
                "You wish you were this flexible\n" +
                "- The Main Screen is made of Samsung Ultra Thin Glass — the biggest leap in our foldable display technology. With the addition of a panel layer and protective film, it's 80% more durable than before and withstands up to 200,000 folds.");
        tvDetails.setMovementMethod(new ScrollingMovementMethod());
        return v;
    }
}
