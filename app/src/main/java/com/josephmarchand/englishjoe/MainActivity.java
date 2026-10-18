
package com.josephmarchand.englishjoe;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.josephmarchand.englishjoe.ui.CourseScreen;
import com.josephmarchand.englishjoe.ui.ReviewScreen;
import com.josephmarchand.englishjoe.ui.SettingsScreen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    private void showHome() {
        setContentView(R.layout.activity_main);

        bindButton(R.id.btnStart, this::openCourses);
        bindButton(R.id.btnCourses, this::openCourses);
        bindButton(R.id.btnReview, this::openReview);
        bindButton(R.id.btnSettings, this::openSettings);
    }

    private void bindButton(int id, Runnable action) {
        View button = findViewById(id);

        if (button != null) {
            button.setOnClickListener(view -> action.run());
        }
    }

    private void openCourses() {
        setContentView(new CourseScreen(this));
    }

    private void openReview() {
        setContentView(new ReviewScreen(this));
    }

    private void openSettings() {
        setContentView(new SettingsScreen(this));
    }

    @Override
    public void onBackPressed() {
        showHome();
    }
            }
