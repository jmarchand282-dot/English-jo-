package com.josephmarchand.englishjoe;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.josephmarchand.englishjoe.ui.HomeScreen;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }
    private void showHome() { setContentView(new HomeScreen(this)); }
    @Override public void onBackPressed() { showHome(); }
}