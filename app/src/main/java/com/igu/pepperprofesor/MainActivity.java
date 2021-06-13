package com.igu.pepperprofesor;

import android.os.Bundle;
import android.util.Log;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.QiSDK;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;
import com.aldebaran.qi.sdk.builder.ChatBuilder;
import com.aldebaran.qi.sdk.builder.QiChatbotBuilder;
import com.aldebaran.qi.sdk.builder.TopicBuilder;
import com.aldebaran.qi.sdk.design.activity.RobotActivity;
import com.aldebaran.qi.sdk.object.conversation.AutonomousReactionImportance;
import com.aldebaran.qi.sdk.object.conversation.AutonomousReactionValidity;
import com.aldebaran.qi.sdk.object.conversation.Chat;
import com.aldebaran.qi.sdk.object.conversation.QiChatbot;
import com.aldebaran.qi.sdk.object.conversation.Topic;
import com.aldebaran.qi.sdk.object.conversation.TopicStatus;
import com.igu.pepperprofesor.databinding.ActivityMainBinding;
import com.igu.pepperprofesor.object.Subject;
import com.igu.pepperprofesor.object.question.ImageQuestion;
import com.igu.pepperprofesor.object.question.OptionQuestion;
import com.igu.pepperprofesor.object.question.Question;
import com.igu.pepperprofesor.util.QuestionUtils;

import java.util.List;

public class MainActivity extends RobotActivity implements RobotLifecycleCallbacks {
    // General
    public static final int N_QUESTIONS = 10;
    public static final int ANSWER_DELAY = 3 * 1000;
    public static final String QUESTION_KEY = "question";
    public static final String QUESTION_NUMBER_KEY = "questionNumber";
    public static final String SCORE_KEY = "score";
    private List<Question> questions;
    private int score;
    private int current;
    public static final String TAG = "MainActivityProfesor";
    public ActivityMainBinding binding;
    // Chat con Pepper
    Topic topic;
    Subject subject;
    QiChatbot qiChatbot;
    Chat chat;
    TopicStatus topicStatusPreguntas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Register the RobotLifecycleCallbacks to this Activity.
        QiSDK.register(this, this);
        score = 0;
        current = 0;
    }

    @Override
    protected void onDestroy() {
        // Unregister the RobotLifecycleCallbacks for this Activity.
        QiSDK.unregister(this, this);
        super.onDestroy();
    }

    @Override
    public void onRobotFocusGained(QiContext qiContext) {
        initChatbot(qiContext);
        addListeners();
        chat.run();
    }

    private void initChatbot(QiContext qiContext) {
        topic = TopicBuilder.with(qiContext).withResource(R.raw.preguntas).build();
        qiChatbot = QiChatbotBuilder.with(qiContext).withTopic(topic).build();
        topicStatusPreguntas = qiChatbot.topicStatus(topic);
        chat = ChatBuilder.with(qiContext).withChatbot(qiChatbot).build();
    }

    private void addListeners() {
        qiChatbot.addOnBookmarkReachedListener(bookmark -> {
            switch (bookmark.getName()) {
                case "CASTELLANO":
                    startSubject(Subject.CASTELLANO);
                    break;
                case "MATEMATICAS":
                    startSubject(Subject.MATEMATICAS);
                    break;
                case "SOCIALES":
                    startSubject(Subject.SOCIALES);
                    break;
                case "TEMA_INCORRECTO":
                    goToSelectionBookmark();
                    break;
                case "CORRECTO":
                    showAnswer(true);
                    increaseScore();
                    waitFor(ANSWER_DELAY);
                    nextQuestion();
                    break;
                case "INCORRECTO":
                    showAnswer(false);
                    waitFor(ANSWER_DELAY);
                    nextQuestion();
                    break;
                case "OTRO_EXAMEN":
                    resetScore();
                    goToSelection(false);
                    break;
                case "SELECCION":
                    Navigation.findNavController(this, R.id.myNavHostFragment)
                            .navigate(R.id.action_titleFragment_to_subjectSelectionFragment);
                case "FIN_INTRO":
                    goToSelection(true);
                    break;
                case "TERMINAR_JUEGO":
                    goToStartingScreen();
                    break;
            }
        });
        chat.addOnStartedListener(this::goToIntroduction);
        topicStatusPreguntas.addOnFocusedChangedListener(focused -> Log.i(TAG, "addOnFocusedChanged: " + focused));
    }

    private void waitFor(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void resetScore() {
        score = 0;
        current = 0;
    }

    private void increaseScore() {
        score++;
    }

    private void goToIntroduction() {
        goToBookmark("INTRO");
    }

    private void goToStartingScreen() {
        Navigation.findNavController(this, R.id.myNavHostFragment).navigate(R.id.action_scoreFragment_to_titleFragment);
    }

    private void startSubject(Subject subject) {
        this.subject = subject;
        questions = QuestionUtils.randomQuestions(N_QUESTIONS, subject);
        Bundle bundle = new Bundle();
        bundle.putString("edttext", questions.get(current).getQuestion());
        nextQuestion();
    }

    private void nextQuestion() {
        if (current < questions.size()) {
            showQuestion(questions.get(current));
            goToQuestion(questions.get(current));
            current++;
        } else {
            qiChatbot.variable("puntos").setValue(Integer.toString(score));
            goToResults();
        }
    }

    private void showQuestion(Question question) {
        NavController navController = Navigation.findNavController(this, R.id.myNavHostFragment);
        Bundle bundle = new Bundle();
        bundle.putSerializable(QUESTION_KEY, question);
        bundle.putInt(QUESTION_NUMBER_KEY, current + 1);
        if (question instanceof OptionQuestion) {
            if (((OptionQuestion) question).getOptionList().size() < 3) {
                navController.navigate(R.id.action_global_twoOptionQuestionFragment, bundle);
            } else {
                navController.navigate(R.id.action_global_threeOptionQuestionFragment, bundle);
            }
        } else if (question instanceof ImageQuestion) {
            navController.navigate(R.id.action_global_imageQuestionFragment, bundle);
        } else {
            navController.navigate(R.id.action_global_questionFragment, bundle);
        }
    }

    private void showAnswer(boolean isCorrect) {
        NavController navController = Navigation.findNavController(this, R.id.myNavHostFragment);
        if (isCorrect) {
            navController.navigate(R.id.action_global_correctAnswerFragment);
        } else {
            navController.navigate(R.id.action_global_incorrectAnswerFragment);
        }
    }

    @Override
    public void onRobotFocusLost() {
        Log.i(TAG, "Focus perdido");
    }

    @Override
    public void onRobotFocusRefused(String reason) {
        Log.i(TAG, String.format("Focus rechazado por %s", reason));
    }

    private void goToSelection(boolean wait) {
        NavController navController = Navigation.findNavController(this, R.id.myNavHostFragment);
        if (wait) {
            waitFor(2000L);
            navController.navigate(R.id.action_titleFragment_to_subjectSelectionFragment);
        } else navController.navigate(R.id.action_scoreFragment_to_subjectSelectionFragment);
        goToSelectionBookmark();
    }

    private void goToSelectionBookmark() {
        goToBookmark("SELECCION");
    }

    private void goToQuestion(Question question) {
        goToBookmark(question.getBookmark());
    }

    private void goToResults() {
        Bundle bundle = new Bundle();
        bundle.putInt("score", score);
        bundle.putSerializable("subject", subject);
        Navigation.findNavController(this, R.id.myNavHostFragment).navigate(R.id.action_global_scoreFragment, bundle);
        goToBookmark("RESULTADOS");
    }

    private void goToBookmark(String bookmarkName) {
        qiChatbot.goToBookmark(
                topic.getBookmarks().get(bookmarkName),
                AutonomousReactionImportance.HIGH,
                AutonomousReactionValidity.IMMEDIATE
        );

    }
}
