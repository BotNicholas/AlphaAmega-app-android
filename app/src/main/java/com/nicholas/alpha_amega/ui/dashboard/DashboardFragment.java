package com.nicholas.alpha_amega.ui.dashboard;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nicholas.alpha_amega.R;
import com.nicholas.alpha_amega.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private SharedPreferences preferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        preferences = getActivity().getSharedPreferences("preferences", MODE_PRIVATE);

        final TextView textView = binding.textDashboard;

        final TextView selectedTitle = binding.selectedBooks;
        final CheckBox checkBoxKids = binding.booksKids;
        final CheckBox checkBoxAdults = binding.booksAdults;
        final CheckBox checkBoxFiction = binding.booksFiction;

//        final CheckBox checkBoxKids = view.findViewById(R.id.books_kids);
//        final CheckBox checkBoxAdults = view.findViewById(R.id.books_adults);
//        final CheckBox checkBoxFiction = view.findViewById(R.id.books_fiction);

//        final CheckBox checkBoxKids = binding.getRoot().findViewById(R.id.books_kids);
//        final CheckBox checkBoxAdults = binding.getRoot().findViewById(R.id.books_adults);
//        final CheckBox checkBoxFiction = binding.getRoot().findViewById(R.id.books_fiction);

        switch (preferences.getString("lang", "en")) {
            case "ru":
                textView.setText(R.string.text_dashboard_ru);
                selectedTitle.setText(R.string.text_books_title_ru);
                checkBoxKids.setText(R.string.text_books_kids_ru);
                checkBoxAdults.setText(R.string.text_books_adults_ru);
                checkBoxFiction.setText(R.string.text_books_fiction_ru);
                break;
            case "ro":
                textView.setText(R.string.text_dashboard_ro);
                selectedTitle.setText(R.string.text_books_title_ro);
                checkBoxKids.setText(R.string.text_books_kids_ro);
                checkBoxAdults.setText(R.string.text_books_adults_ro);
                checkBoxFiction.setText(R.string.text_books_fiction_ro);
                break;
            case "en":
                textView.setText(R.string.text_dashboard_en);
                selectedTitle.setText(R.string.text_books_title_en);
                checkBoxKids.setText(R.string.text_books_kids_en);
                checkBoxAdults.setText(R.string.text_books_adults_en);
                checkBoxFiction.setText(R.string.text_books_fiction_en);
                break;
        }

//        final TextView textView = binding.textDashboard;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        LinearLayout layout = view.findViewById(R.id.books);

        CheckBox checkBoxKids = view.findViewById(R.id.books_kids);
        CheckBox checkBoxAdults = view.findViewById(R.id.books_adults);
        CheckBox checkBoxFiction = view.findViewById(R.id.books_fiction);

        checkBoxKids.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                buttonView.setTextColor(android.R.attr.colorPrimary);
//            } else {
//                buttonView.setTextColor(android.R.attr.textColor);
//            }
            changeResult(buttonView.getText().toString(), isChecked);
        });
        checkBoxAdults.setOnCheckedChangeListener((buttonView, isChecked) -> {
            changeResult(buttonView.getText().toString(), isChecked);
        });
        checkBoxFiction.setOnCheckedChangeListener((buttonView, isChecked) -> {
            changeResult(buttonView.getText().toString(), isChecked);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void changeResult(String book, boolean isChecked){
        TextView textView = (TextView) binding.getRoot().findViewById(R.id.selected_books_list);

        String text = (String) textView.getText();

        if (isChecked && !text.contains(book)) {
            text += ("-> " + book + "\n");
        } else if(!isChecked && text.contains(book)) {
            text = text.replace("-> " + book+"\n", "");
        }

        textView.setText(text);


    }
}