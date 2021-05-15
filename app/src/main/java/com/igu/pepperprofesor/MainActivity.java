package com.igu.pepperprofesor;

import android.os.Bundle;
import android.util.Log;

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

public class MainActivity extends RobotActivity implements RobotLifecycleCallbacks {
    public static final String TAG = "MainActivityProfesor";
    Topic topic;
    Subject subject;
    QiChatbot qiChatbot;
    Chat chat;
    public static final int N_QUESTIONS = 10;
    private int[] questionNumbers;
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
        topic = TopicBuilder.with(qiContext).withResource(R.raw.preguntas).build();
        qiChatbot = QiChatbotBuilder.with(qiContext).withTopic(topic).build();
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
                    puntuacion++;
                    nextQuestion();
                    break;
                case "INCORRECTO":
                    nextQuestion();
                    break;
            }
        });
        chat.addOnStartedListener(this::goToIntroduction);
    }

    private void goToIntroduction() {
        goToBookmark("INTRO");
    }

    private void startSubject(Subject subject) {
        this.subject = subject;
        questionNumbers = Utilities.randomQuestions(subject.getSize(), N_QUESTIONS);
        nextQuestion();
    }

    private void nextQuestion() {
        if (current == N_QUESTIONS) {
            goToResults();
            return;
        }
        goToQuestion(questionNumbers[current]);
        current++;
    }

    @Override
    public void onRobotFocusLost() {
        Log.i(TAG, "Focus perdido");
        //TODO Poner que diga algún mensaje gracioso
    }

    @Override
    public void onRobotFocusRefused(String reason) {
        Log.i(TAG, String.format("Focus rechazado por %s", reason));
    }

    private void goToSelection() {
        goToBookmark("SELECCION");
    }

    private void goToQuestion(int numero) {
        goToBookmark(subject.name() + numero);
    }

    private void goToResults() {
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
