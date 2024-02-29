package com.nicholas.alpha_amega.ui.home;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nicholas.alpha_amega.MainActivity;
import com.nicholas.alpha_amega.R;
import com.nicholas.alpha_amega.databinding.FragmentHomeBinding;

import java.util.ArrayList;

import models.ListAdapter;
import models.ListItem;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private SharedPreferences preferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        preferences = getActivity().getSharedPreferences("preferences", MODE_PRIVATE);

        final TextView textView = binding.textHome;

        switch (preferences.getString("lang", "en")) {
            case "ru":
                textView.setText(R.string.text_home_ru);
                break;
            case "ro":
                textView.setText(R.string.text_home_ro);
                break;
            case "en":
                textView.setText(R.string.text_home_en);
                break;
        }

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = binding.listView1;

        ArrayList<ListItem> items = new ArrayList<>();

        //...заполнение
        items.add(new ListItem(R.drawable.cowbell, "COWBELL WARRIOR", "https://www.youtube.com/watch?v=FHWgDichnMo"));
        items.add(new ListItem(R.drawable.toad, "THINK OF A DRIVE", "https://www.youtube.com/watch?v=LiovUkBWOos"));
        items.add(new ListItem(R.drawable.vendetta, "Vendetta", "https://www.youtube.com/watch?v=Y8qPp4pBNz8"));
        items.add(new ListItem(R.drawable.lad, "Live Another Day", "https://www.youtube.com/watch?v=7pmUQJ5KAlU"));
        items.add(new ListItem(R.drawable.dis, "DEMONS IN MY SOUL", "https://www.youtube.com/watch?v=jvENNPVz6s4"));
        items.add(new ListItem(R.mipmap.icon, "9mm", "https://www.youtube.com/watch?v=ArNiVyd7skk"));
        items.add(new ListItem(R.drawable.mm, "METAMORPHOSIS", "https://www.youtube.com/watch?v=317RHaFF7Xk"));
        items.add(new ListItem(R.drawable.fu, "Fed Up", "https://www.youtube.com/watch?v=DKLuL1IE2PA"));
        items.add(new ListItem(R.drawable.wn, "Why Not", "https://www.youtube.com/watch?v=Hh5jEQraXaw"));
        items.add(new ListItem(R.drawable.teq, "Tequila", "https://www.youtube.com/watch?v=DO-8K1AzoXc"));
        items.add(new ListItem(R.drawable.nb, "NEON BLADE", "https://www.youtube.com/watch?v=dvQJIgjlR3I"));
        items.add(new ListItem(R.drawable.awm, "Always Want Me", "https://www.youtube.com/watch?v=VJGwqhtMvnU"));
        items.add(new ListItem(R.drawable.rukm, "RUKIDDINGME", "https://www.youtube.com/watch?v=E4DhSl3-vmc"));
        items.add(new ListItem(R.drawable.scopin, "SCOPIN", "https://www.youtube.com/watch?v=VXaq77GiyEo"));
        items.add(new ListItem(R.drawable.kftns, "Killers From The Northside", "https://www.youtube.com/watch?v=DK6IRG4CAbw"));
        items.add(new ListItem(R.drawable.calmness, "CALMNESS", "https://www.youtube.com/watch?v=bAhTfoMVbwI"));
        items.add(new ListItem(R.drawable.limbo, "Limbo", "https://www.youtube.com/watch?v=GDeZetYSAzo"));
        items.add(new ListItem(R.drawable.cristals, "Crystals", "https://www.youtube.com/watch?v=Ov6ymmqp27s"));
        items.add(new ListItem(R.drawable.ci, "Close Eyes", "https://www.youtube.com/watch?v=ao4RCon11eY"));
        items.add(new ListItem(R.drawable.saharah, "Sahara", "https://www.youtube.com/watch?v=pIZ0QRWK0zg"));
        items.add(new ListItem(R.drawable.demice, "Demice", "https://www.youtube.com/watch?v=mUeOEhisJso"));
        items.add(new ListItem(R.drawable.disaster, "Disaster", "https://www.youtube.com/watch?v=q1sKU-cpUDk"));

        ListAdapter adapter = new ListAdapter(getContext(), items);


        listView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}