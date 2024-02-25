package com.nicholas.alpha_amega;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.nicholas.alpha_amega.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private boolean useDarkTheme;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("preferences", MODE_PRIVATE);
        useDarkTheme = sharedPreferences.getBoolean("DarkTheme", false);

//        System.out.println("Theme: " + sharedPreferences.getBoolean("DarkTheme", false));

        if (useDarkTheme) {
            setTheme(R.style.Theme_Dark);
        } else {
            setTheme(R.style.Theme_Light);
        }

//        setTheme(R.style.Theme_Light);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    public void changeTheme(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        useDarkTheme = !useDarkTheme;
        editor.putBoolean("DarkTheme", useDarkTheme);
        editor.apply();
//        Snackbar.make(binding.container, "Theme has been changed to ", BaseTransientBottomBar.LENGTH_SHORT).show();
//        new Handler().postDelayed(()->recreate(), 1000);
        recreate();
    }

    public String changeLanguage(String lang){
//        System.out.println(lang);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (lang) {
            case "Russian":
                editor.putString("lang", "ru");
                break;
            case "Romanian":
                editor.putString("lang", "ro");
                break;
            case "English":
                editor.putString("lang", "en");
                break;
        }
        editor.apply();
//        recreate();

        return lang;
    }

}