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
        items.add(new ListItem(R.drawable.cowbell, "COWBELL WARRIOR"));
        items.add(new ListItem(R.drawable.toad, "THINK OF A DRIVE"));
        items.add(new ListItem(R.drawable.vendetta, "Vendetta"));
        items.add(new ListItem(R.drawable.lad, "Live Another Day"));
        items.add(new ListItem(R.drawable.dis, "DEMONS IN MY SOUL"));
        items.add(new ListItem(R.mipmap.icon, "9mm"));
        items.add(new ListItem(R.drawable.mm, "METAMORPHOSIS"));
        items.add(new ListItem(R.drawable.fu, "Fed Up"));
        items.add(new ListItem(R.drawable.wn, "Why Not"));
        items.add(new ListItem(R.drawable.teq, "Tequila"));
        items.add(new ListItem(R.drawable.nb, "NEON BLADE"));
        items.add(new ListItem(R.drawable.awm, "Always Want Me"));
        items.add(new ListItem(R.drawable.rukm, "RUKIDDINGME"));
        items.add(new ListItem(R.drawable.scopin, "SCOPIN"));
        items.add(new ListItem(R.drawable.kftns, "Killers From The Northside"));
        items.add(new ListItem(R.drawable.calmness, "CALMNESS"));
        items.add(new ListItem(R.drawable.limbo, "Limbo"));
        items.add(new ListItem(R.drawable.cristals, "Crystals"));
        items.add(new ListItem(R.drawable.ci, "Close Eyes"));
        items.add(new ListItem(R.drawable.saharah, "Sahara"));
        items.add(new ListItem(R.drawable.demice, "Demice"));
        items.add(new ListItem(R.drawable.disaster, "Disaster"));

        ListAdapter adapter = new ListAdapter(getContext(), items);


        listView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}