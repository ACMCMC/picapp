package codes.acmc.picapp.ui.questionnaire;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        finalView.addView(inflateCardView(inflater, container, "Dolor agudo"));
        finalView.addView(inflateCardView(inflater, container, "Dolor moderado"));
        finalView.addView(inflateCardView(inflater, container, "Dolor leve"));
        return finalView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(QuestionnaireViewModel.class);
        // TODO: Use the ViewModel
    }

    private View inflateCardView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, String text) {
        View finalView = inflater.inflate(R.layout.inflatable_question, container, false);
        ((Button) finalView).setText(text);
        return finalView;
    }
}