package codes.acmc.picapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView intro = findViewById(R.id.textview_app_intro);
        AlphaAnimation animacion_entrada = new AlphaAnimation(0.0f, 1.0f);
        animacion_entrada.setStartOffset(1000);
        animacion_entrada.setDuration(3000);
        animacion_entrada.setInterpolator(new DecelerateInterpolator());
        intro.startAnimation(animacion_entrada);

        Button start_button = findViewById(R.id.button_start);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),QuestionnaireActivity.class));
            }
        });
    }
}