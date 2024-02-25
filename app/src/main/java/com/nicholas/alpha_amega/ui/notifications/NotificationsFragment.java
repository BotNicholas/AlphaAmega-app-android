package com.nicholas.alpha_amega.ui.notifications;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nicholas.alpha_amega.R;
import com.nicholas.alpha_amega.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    private SharedPreferences preferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        preferences = getActivity().getSharedPreferences("preferences", MODE_PRIVATE);

        final TextView textView = binding.textNotifications;

        switch (preferences.getString("lang", "en")) {
            case "ru":
                textView.setText(R.string.text_notifications_ru);
                break;
            case "ro":
                textView.setText(R.string.text_notifications_ro);
                break;
            case "en":
                textView.setText(R.string.text_notifications_en);
                break;
        }


//        final TextView textView = binding.textNotifications;
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = binding.helloButton;
//        button.setOnClickListener(v -> {
//            new AlertDialog.Builder(getContext())
//                    .setTitle("How Are you")
//                    .setMessage("How are you today?")
//                    .setView(new EditText(getContext()))
//                    .setPositiveButton(android.R.string.yes, (d, i)->{
//                        System.out.println(d.toString());
//                    })
//                    .setNegativeButton(android.R.string.no, (d, i)->{
//                        System.out.println(d.toString());
//                    }).setIcon(R.drawable.question).show();
//
//        });

        button.setOnClickListener(v -> {
            Dialog dialog = new Dialog(getContext());
            dialog.setContentView(R.layout.custom_dialog);

            Button send = dialog.findViewById(R.id.button_send);
            EditText inputField = dialog.findViewById(R.id.editTextText);
            TextView textView = dialog.findViewById(R.id.textView);

            switch(preferences.getString("lang", "en")){
                case "ru":
                    send.setText("Отправить!");
                    textView.setText("Как поживаете сегодня?");
                    break;
                case "ro":
                    send.setText("Tremite!");
                    textView.setText("Cum va simtiti azi?");
                    break;
                case "en":
                    send.setText("Send!");
                    textView.setText("How are you today?");
                    break;
            }

            send.setOnClickListener(view1 -> {
                Dialog notion = new Dialog(getContext());
                notion.setContentView(R.layout.poput_confirm);

                Button ok = notion.findViewById(R.id.button_ok);
                TextView info = notion.findViewById(R.id.info);
                String lang = preferences.getString("lang", "en");

                if (inputField.getText().toString().matches("^ok$|^Оk$|^OK$|^good$|^GOOD$|^Good$|^nice$|^Nice$|^NICE$") && lang.equals("en")){
                    info.setText("Glad to hear that!");
                } else if (inputField.getText().toString().matches("^хорошо$|^Хорошо$|^ХОРОШО$|^НОРМАЛЬНО$|^Нормально$|^нормально$|^отлично$|^Отлично$|^ОТЛИЧНО$|^ok$|^Оk$|^OK$|^ок$|^Ок$|^ОК$") && lang.equals("ru")){
                    info.setText("Рад это слышать!");
                } else if (inputField.getText().toString().matches("^ok$|^oK$|^OK$|^bun|^Bun$|^BUN$|^superb$|^Superb$|^SUPERB$") && lang.equals("ro")){
                    info.setText("Eu's fericit!");
                } else {

                    switch(lang){
                        case "ru":
                            info.setText("Береги себя!");
                            break;
                        case "ro":
                            info.setText("Ai grija!");
                            break;
                        case "en":
                            info.setText("Take care!");
                            break;
                    }
                }

                ok.setOnClickListener(v1 -> notion.dismiss());

                notion.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                notion.show();


                dialog.dismiss();
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}