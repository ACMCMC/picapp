package codes.acmc.picapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import codes.acmc.picapp.ui.main.QuestionnaireFragment;

public class QuestionnaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaire_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, QuestionnaireFragment.newInstance())
                    .commitNow();
        }
    }
}