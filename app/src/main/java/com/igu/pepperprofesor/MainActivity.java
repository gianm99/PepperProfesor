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
import com.aldebaran.qi.sdk.object.conversation.Bookmark;
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
    private int[] questions;
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
        topic = TopicBuilder.with(qiContext).withResource(R.raw.preguntas).build();
        qiChatbot = QiChatbotBuilder.with(qiContext).withTopic(topic).build();
        qiChatbot.addOnBookmarkReachedListener(new QiChatbot.OnBookmarkReachedListener() {
            @Override
            public void onBookmarkReached(Bookmark bookmark) {
                String name = bookmark.getName();
                if ("CORRECTO".equals(name)) puntuacion++;
                if ("CORRECTO".equals(name) || "INCORRECTO".equals(name)) {
                    nextQuestion();
                }
                switch (name) {
                    case "CASTELLANO":
                        changeSubject(Subject.CASTELLANO);
                        break;
                    case "MATEMATICAS":
                        changeSubject(Subject.MATEMATICAS);
                        break;
                    case "SOCIALES":
                        changeSubject(Subject.SOCIALES);
                        break;
                    case "TEMA_INCORRECTO":
                        goToSelection();
                }
            }
        });
        chat = ChatBuilder.with(qiContext).withChatbot(qiChatbot).build();
        chat.run();
    }

    private void changeSubject(Subject subject) {
        this.subject = subject;
        questions = Utilities.randomQuestions(subject.getLower(), subject.getUpper(), N_QUESTIONS);
    }

    private void nextQuestion() {
        if (current < N_QUESTIONS) {
            current++;
            goToQuestion(questions[current]);
        } else {
            goToResults();
        }
    }

    @Override
    public void onRobotFocusLost() {
        Log.i(TAG, "Focus perdido");
        //TODO Poner que diga algún mensaje gracioso
    }

    @Override
    public void onRobotFocusRefused(String reason) {
        Log.i(TAG, String.format("Focus recuperado por %s", reason));
    }

    private void goToSelection() {
        goToBookmark("SELECCION");
    }

    private void goToQuestion(int numero) {
        goToBookmark("PREGUNTA" + numero);
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
