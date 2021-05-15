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
import com.aldebaran.qi.sdk.object.conversation.EditablePhraseSet;
import com.aldebaran.qi.sdk.object.conversation.Phrase;
import com.aldebaran.qi.sdk.object.conversation.QiChatVariable;
import com.aldebaran.qi.sdk.object.conversation.QiChatbot;
import com.aldebaran.qi.sdk.object.conversation.Topic;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends RobotActivity implements RobotLifecycleCallbacks {
    public static final String TAG = "MainActivityProfesor";
    Topic topic;
    QiChatbot qiChatbot;
    Chat chat;
    EditablePhraseSet wrongNumbersSet;
    TextView txtView;
    public static int numPregunta;
    public static int[] preguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Register the RobotLifecycleCallbacks to this Activity.
        setContentView(R.layout.activity_main);
        txtView = (TextView) findViewById(R.id.tabletLabel);
        numPregunta=0;
        preguntas = new int[10];
        for(int i=0; i<preguntas.length;i++){
            preguntas[i]=0;
        }
        QiSDK.register(this, this);
    }

    @Override
    protected void onDestroy() {
        // Unregister the RobotLifecycleCallbacks for this Activity.
        QiSDK.unregister(this, this);
        super.onDestroy();
    }

    @Override
    public void onRobotFocusGained(QiContext qiContext) {
        // The robot focus is gained.
        topic = TopicBuilder.with(qiContext).withResource(R.raw.castellano).build();
        qiChatbot = QiChatbotBuilder.with(qiContext).withTopic(topic).build();
        chat = ChatBuilder.with(qiContext).withChatbot(qiChatbot).build();
        // Start the dialogue



        chat.addOnStartedListener(() -> goToBookmark("CASTELLANO40"));
        /*wrongNumbersSet = qiChatbot.dynamicConcept("wrongNumbers");
        randomize();*/
        /*qiChatbot.addOnBookmarkReachedListener(bookmark -> {
            switch(bookmark.getName()){
                case "RERANDOMIZE":
                    randomize();
            }
        });*/
        qiChatbot.variable("show").addOnValueChangedListener(it -> runOnUiThread(
                () -> txtView.setText(it)
        ));
        chat.run();
    }


    @Override
    public void onRobotFocusLost() {
        Log.i(TAG, "Focus perdido");
    }

    @Override
    public void onRobotFocusRefused(String reason) {
        Log.i(TAG, String.format("Focus recuperado por %s", reason));
    }
    private void goToBookmark(String bookmarkName) {
        qiChatbot.goToBookmark(
                topic.getBookmarks().get(bookmarkName),
                AutonomousReactionImportance.HIGH,
                AutonomousReactionValidity.IMMEDIATE
        );
    }

    //Método para comprobar si el nº se encuentra ya dentro de la array
    private Boolean estaEnarray(int j){
        Boolean esta = false;
        for(int i=0;i<preguntas.length;i++){
            if(preguntas[i]==j){
                esta=true;
                break;
            }
        }
        return esta;
    };

    private void randomize(){
        Random ra=new Random();

        /*qiChatbot.variable("numberA").setValue(Integer.toString(numberA));
        qiChatbot.variable("numberB").setValue(Integer.toString(numberB));
        qiChatbot.variable("result").setValue(Integer.toString(multiplicationResult));
*/
        if(numPregunta<10){
            int npregunta= ra.nextInt(40) + 1;

            // Si la array está vacía, podemos usar la primera pregunta que salga
            if(preguntas[0]==0){
                preguntas[0]=npregunta;
            }else { //Si no está vacía, habrá que mirar que no esté repetida esa pregunta
                Boolean existe = estaEnarray(npregunta);
                //mientras que el nº ya esté, hacemos otro random
                while(existe){
                    npregunta = ra.nextInt(40) + 1;
                    existe = estaEnarray(npregunta);
                }
                //una vez sepamos qué nº meter, miramos la posición primera libre
                int j =0;
                while(preguntas[j]!=0){
                    j++;
                }
                // y en esa posición colocamos el nº de la pregunta
                preguntas[j]=npregunta;
                //Ahora deberíamos decir que es ese proposal: PREGUNTA1 p.e
            }
        }else{
            String s="Llamar al final del juego.";
        }
        /*ArrayList<Phrase> numberPhrases = new ArrayList<Phrase>();
        for (int i=0;i<=100;i++){
            if (i!=multiplicationResult){
                numberPhrases.add(new Phrase(Integer.toString(i)));
            }
        }
        wrongNumbersSet.removePhrases(wrongNumbersSet.getPhrases());
        wrongNumbersSet.addPhrases(numberPhrases);*/

    }
}
