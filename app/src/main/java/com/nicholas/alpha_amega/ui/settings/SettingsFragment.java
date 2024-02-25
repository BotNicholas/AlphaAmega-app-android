package com.nicholas.alpha_amega.ui.settings;

import static android.content.Context.MODE_PRIVATE;

import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.LocaleList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.nicholas.alpha_amega.MainActivity;
import com.nicholas.alpha_amega.R;
import com.nicholas.alpha_amega.databinding.FragmentHomeBinding;
import com.nicholas.alpha_amega.databinding.FragmentSettingsBinding;
import com.nicholas.alpha_amega.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.Locale;

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;
    private SharedPreferences preferences;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingsViewModel settingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        preferences = getActivity().getSharedPreferences("preferences", MODE_PRIVATE);

        MainActivity activity = (MainActivity) getActivity();

        Button button = view.findViewById(R.id.change_theme);
        button.setOnClickListener(v -> activity.changeTheme());

        Spinner spinner = view.findViewById(R.id.languages);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(activity, R.array.languages, R.layout.custom_spinner_item);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
//        adapter.setDropDownViewTheme();

        spinner.setAdapter(adapter);

        switch (preferences.getString("lang", "en")){
            case "ru":
                spinner.setSelection(1);
                break;
            case "ro":
                spinner.setSelection(2);
                break;
            case "en":
                spinner.setSelection(0);
                break;
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLang = parent.getItemAtPosition(position).toString();
//
                activity.changeLanguage(selectedLang);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}