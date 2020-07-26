package codes.acmc.picapp.ui.questionnaire;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.lifecycle.ViewModelProviders;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.ripple.RippleDrawableCompat;

import org.w3c.dom.Text;

import java.lang.reflect.Field;

import codes.acmc.picapp.R;

public class QuestionnaireFragment extends Fragment {

    private QuestionnaireViewModel mViewModel;

    public static QuestionnaireFragment newInstance() {
        return new QuestionnaireFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        LinearLayout finalView = (LinearLayout) inflater.inflate(R.layout.main_fragment, container, false);
        View question_item;
        for (int i = 0; i < 7; i++) {
            question_item = inflateCardView(inflater, finalView, "Pregunta " + String.valueOf(i +1));
            question_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Clicked: " + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                }
            });
            finalView.addView(question_item);
        }
        return finalView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(QuestionnaireViewModel.class);
        // TODO: Use the ViewModel
    }

    private View inflateCardView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, String text) {
        Button finalView = (Button) inflater.inflate(R.layout.inflatable_question, container, false);
        ((Button) finalView).setText(text);

        finalView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    int initial_color;
                    ((RippleDrawable) view.getBackground()).getConstantState().;
                    ValueAnimator animator = ValueAnimator.ofArgb(initial_color, ContextCompat.getColor(view.getContext(), R.color.blueLight)).setDuration(2000);
                    animator.setInterpolator(new AccelerateDecelerateInterpolator());
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            view.setBackgroundColor((Integer) valueAnimator.getAnimatedValue());
                        }
                    });
                    animator.start();
                }
                return false;
            }
        });

        return finalView;
    }
}