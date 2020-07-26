package codes.acmc.picapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.transition.Slide;

import android.content.Intent;
import android.graphics.drawable.AnimatedImageDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import codes.acmc.picapp.ui.questionnaire.QuestionnaireFragment;

public class QuestionnaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaire_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.questionnaire_container, QuestionnaireFragment.newInstance())
                    .commitNow();
        }


        /*final ProgressBar progress = findViewById(R.id.progressBar);
        progress.setMax(6);
        progress.setInterpolator(new FastOutLinearInInterpolator());*/

        findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right).replace(R.id.questionnaire_container, QuestionnaireFragment.newInstance()).commitNow();
            }
        });

        /*ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                progress.setProgress(progress.getProgress() == progress.getMax() ? 0 : progress.getProgress() + 1);
            }
        },
                0L, 1L, TimeUnit.SECONDS);*/

    }
}