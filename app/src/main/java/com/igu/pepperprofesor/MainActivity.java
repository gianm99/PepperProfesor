package com.igu.pepperprofesor;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentTransaction;

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
import com.igu.pepperprofesor.question.Question;
import com.igu.pepperprofesor.question.QuestionType;
import com.igu.pepperprofesor.question.QuestionUtils;

import java.util.List;

import static com.igu.pepperprofesor.question.QuestionType.NORMAL;

public class MainActivity extends RobotActivity implements RobotLifecycleCallbacks  {
    public static final String TAG = "MainActivityProfesor";
    FragmentTransaction fragmentTransaction;
    Topic topicPreguntas;
    TopicStatus topicStatusPreguntas;
    Subject subject;
    QiChatbot qiChatbot;
    Chat chat;
    public static final int N_QUESTIONS = 10;
    private List<Question> questions;
    private int puntuacion;
    private int current;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Register the RobotLifecycleCallbacks to this Activity.
        setContentView(R.layout.activity_main);
        QiSDK.register(this, this);
        puntuacion = 0;
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
        topicPreguntas = TopicBuilder.with(qiContext).withResource(R.raw.preguntas).build();
        qiChatbot = QiChatbotBuilder.with(qiContext).withTopic(topicPreguntas).build();
        topicStatusPreguntas = qiChatbot.topicStatus(topicPreguntas);
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
                    goToSelection();
                    break;
                case "CORRECTO":
                    aumentarPuntuacion();
                    nextQuestion();
                    break;
                case "INCORRECTO":
                    nextQuestion();
                    break;
                case "OTRO_EXAMEN":
                    resetScore();
                    goToSelection();
                    break;
            }
        });
        chat.addOnStartedListener(this::goToIntroduction);
        topicStatusPreguntas.addOnFocusedChangedListener(focused -> Log.i(TAG, "addOnFocusedChanged: " + focused));
    }

    private void resetScore() {
        puntuacion = 0;
        current = 0;
    }

    private void aumentarPuntuacion() {
        puntuacion++;
    }

    private void goToIntroduction() {
        goToBookmark("INTRO");
    }

    private void startSubject(Subject subject) {
        this.subject = subject;
        questions = QuestionUtils.randomQuestions(N_QUESTIONS, subject);
        Bundle bundle = new Bundle();
        bundle.putString("edttext", questions.get(current).getQuestion());
// set Fragmentclass Arguments
        questionfragment fragobj = new questionfragment();
        fragobj.setArguments(bundle);
        nextQuestion();
    }

    private void nextQuestion() {
        if (current < questions.size()) {
            goToQuestion(questions.get(current));
            current++;
        } else {
            qiChatbot.variable("puntos").setValue(Integer.toString(puntuacion));
            goToResults();
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

    private void goToSelection() {
        goToBookmark("SELECCION");
    }

    private void goToQuestion(Question question) {
        goToBookmark(question.getBookmark());
    }

    private void goToResults() {
        goToBookmark("RESULTADOS");
    }

    private void goToBookmark(String bookmarkName) {
        qiChatbot.goToBookmark(
                topicPreguntas.getBookmarks().get(bookmarkName),
                AutonomousReactionImportance.HIGH,
                AutonomousReactionValidity.IMMEDIATE
        );

    }


}
