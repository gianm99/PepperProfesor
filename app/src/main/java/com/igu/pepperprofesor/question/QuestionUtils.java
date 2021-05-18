package com.igu.pepperprofesor.question;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.igu.pepperprofesor.MainActivity;
import com.igu.pepperprofesor.Subject;
import com.igu.pepperprofesor.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.igu.pepperprofesor.Subject.SOCIALES;

public class QuestionUtils {
    private static final List<Question> questions;

    static {
        questions = Arrays.asList(
                new OptionQuestion(SOCIALES, 1, "¿Alrededor de qué tipo de astro orbitan los satélites?",
                        Arrays.asList(new Option('a', "Planetas"),
                                new Option('b', "Estrellas"),
                                new Option('c', "Agujeros negros"))),
                new OptionQuestion(SOCIALES, 2, "¿Qué forma tiene la galaxia en la que se encuentra la Tierra?",
                        Arrays.asList(new Option('a', "Quásar"),
                                new Option('b', "Elíptica"),
                                new Option('c', "Espiral"))),
                new OptionQuestion(SOCIALES, 3, "¿Qué tipo de estrella es el Sol?",
                        Arrays.asList(new Option('a', "Enana"),
                                new Option('b', "Mediana"),
                                new Option('c', "Grande"))),
                new Question(SOCIALES, 4, "¿En qué planeta del sistema solar a parte de la Tierra se encuentra el Monte Olimpo?"),
                new OptionQuestion(SOCIALES, 5, "¿En qué año llegaron los humanos a la Luna?",
                        Arrays.asList(new Option('a', "1973"),
                                new Option('b', "1969"),
                                new Option('c', "1968"))),
                new Question(SOCIALES, 6, "¿Cómo se llaman las circunferencias imaginarias paralelas al Ecuador?"),
                new Question(SOCIALES, 7, "¿Cómo se llaman las circunferencias imaginarias que pasan por los Polos Norte y Sur?"),
                new OptionQuestion(SOCIALES, 8, "¿Entre qué paises están los Pirineos?",
                        Arrays.asList(new Option('a', "España y Francia"),
                                new Option('b', "Portugal y España"),
                                new Option('c', "Italia y Francia"))),
                new OptionQuestion(SOCIALES, 9, "¿Cuál es el río más largo de España?",
                        Arrays.asList(new Option('a', "Duero"),
                                new Option('b', "Guadalquivir"),
                                new Option('c', "Tajo"))),
                new OptionQuestion(SOCIALES, 10, "¿Cuál es la montaña más alta de España?",
                        Arrays.asList(new Option('a', "Mulhacén"),
                                new Option('b', "Teide"),
                                new Option('c', "Aneto"))),
                new OptionQuestion(SOCIALES, 11, "¿Con qué océano está en contacto España?",
                        Arrays.asList(new Option('a', "Atlántico"),
                                new Option('b', "Pacífico"),
                                new Option('c', "Índico"))),
                new Question(SOCIALES, 12, "¿A qué continente pertenece Australia?"),
                new Question(SOCIALES, 13, "¿A qué continente pertenece Tailandia?"),
                new Question(SOCIALES, 14, "¿A qué continente pertenece Kenia?"),
                new Question(SOCIALES, 15, "¿A qué continente pertenece Suecia?"),
                new Question(SOCIALES, 16, "¿A qué continente pertenece Guatemala?"),
                new Question(SOCIALES, 17, "¿Cuál es el continente más grande del mundo?"),
                new Question(SOCIALES, 18, "¿Qué nombre reciben las aguas subterráneas?"),
                new Question(SOCIALES, 19, "¿En qué unidades se miden la latitud y la longitud de un punto?"),
                new Question(SOCIALES, 20, "¿Cuál es la región española más al sur?"),
                new Question(SOCIALES, 21, "¿Cuál es la capital de España?"),
                new Question(SOCIALES, 22, "¿Cuál es la capital de Francia?"),
                new Question(SOCIALES, 23, "¿Cuál es la capital de Alemania?"),
                new Question(SOCIALES, 24, "¿Cuál es la capital de Reino Unido?"),
                new Question(SOCIALES, 25, "¿Cuál es la capital de Australia?"),
                new Question(SOCIALES, 26, "¿Cuál es la capital de Noruega?"),
                new Question(SOCIALES, 27, "¿En qué año fue aprobada la Constitución española que tenemos actualmente?"),
                new Question(SOCIALES, 28, "¿Cuántas comunidades autónomas hay en España?"),
                new Question(SOCIALES, 29, "¿Cuántas ciudades autónomas hay en España?"),
                new Question(SOCIALES, 30, "¿Cuál es la comunidad autónoma más grande de España?"),
                new Question(SOCIALES, 31, "¿Cuál es la comunidad autónoma más poblada de España?"),
                new Question(SOCIALES, 32, "¿Cuáles son los tres tipos de poder político que hay en España? Legislativo, judicial y..."),
                new OptionQuestion(SOCIALES, 33, "¿Qué modelo de gobierno tiene España?",
                        Arrays.asList(new Option('a', "Monarquía absoluta"),
                                new Option('b', "República"),
                                new Option('c', "Monarquía parlamentaria"))),
                new Question(SOCIALES, 34, "¿Qué lengua oficial hay en las Illes Balears aparte del castellano?"),
                new Question(SOCIALES, 35, "¿Qué lengua oficial hay en el País Vasco aparte del castellano?"),
                new OptionQuestion(SOCIALES, 36, "¿Qué sector económico es el predominante en la economía de España?",
                        Arrays.asList(new Option('a', "Primario"),
                                new Option('b', "Secundario"),
                                new Option('c', "Terciario"))),
                new OptionQuestion(SOCIALES, 37, "¿En cuántas etapas se divide la historia según los expertos?",
                        Arrays.asList(new Option('a', "3"),
                                new Option('b', "5"),
                                new Option('c', "7"))),
                new Question(SOCIALES, 38, "¿Cómo se llaman los pueblos que no permanecían en sitios fijos y se trasladaban en busca de alimentos?"),
                new Question(SOCIALES, 39, "¿Cómo se llaman los pueblos que dejaron de ir de un sitio a otro y se quedaron fijos en un sitio?"),
                new Question(SOCIALES, 40, "¿Cómo llamaron los romanos a la península Ibérica?"),
                new Question(SOCIALES, 41, "¿Qué idioma hablaban los romanos?"),
                new OptionQuestion(SOCIALES, 42, "¿En qué siglo se deshizo el Imperio romano?",
                        Arrays.asList(new Option('a', "V d.C."),
                                new Option('b', "I a.C."),
                                new Option('c', "IV d.C."))),
                new Question(SOCIALES, 43, "¿Qué etapa histórica comienza con la aparición de la escritura?"),
                new Question(SOCIALES, 44, "¿Qué etapa histórica comienza con la caída del imperio romano?"),
                new Question(SOCIALES, 45, "¿Qué etapa histórica comienza tras el descubrimiento de América?"),
                new Question(SOCIALES, 46, "¿Qué etapa histórica comienza tras la Revolución Francesa?"),
                new OptionQuestion(SOCIALES, 47, "¿A quién se le atribuye la invención de la imprenta?",
                        Arrays.asList(new Option('a', "Leonardo da Vinci"),
                                new Option('b', "Johannes Guttenberg"),
                                new Option('c', "Thomas Edison"))),
                new OptionQuestion(SOCIALES, 48, "¿Cuál fue el invento que resultó esencial para el desarrollo de la Revolución Industrial?",
                        Arrays.asList(new Option('a', "Coche"),
                                new Option('b', "Rueda"),
                                new Option('c', "Máquina de vapor"))),
                new OptionQuestion(SOCIALES, 49, "¿A qué inventor se le atribuye la invención del teléfono?",
                        Arrays.asList(new Option('a', "Thomas Edison"),
                                new Option('b', "Alexander Graham Bell"),
                                new Option('c', "Nikola Tesla"))),
                new OptionQuestion(SOCIALES, 50, "¿Cuál fue el conflicto bélico más importante del siglo XX?",
                        Arrays.asList(new Option('a', "Primera Guerra Mundial"),
                                new Option('b', "Guerra de Corea"),
                                new Option('c', "Segunda Guerra Mundial")))
        );
    }

    /**
     * Devuelve una lista de preguntas con el tamaño indicado y sobre la temática indicada.
     *
     * @param limit   cantidad de preguntas
     * @param subject temática de las preguntas
     * @return lista de preguntas con el tamaño indicado y sobre la temática indicada
     */
    public static List<Question> randomQuestions(int limit, Subject subject) {
        if (limit >= subject.getSize()) throw new IllegalArgumentException();
        int[] randomNumbers = Utilities.randomNumbers(1, subject.getSize(), MainActivity.N_QUESTIONS);
        List<Question> questions = new ArrayList<>(limit);
        for (int number : randomNumbers) {
            Question question = getQuestionBy(number, subject);
            if (question != null && questions.size() < limit) questions.add(question);
        }
        return questions;
    }

    /**
     * Devuelve una lista de preguntas con el tamaño indicado
     *
     * @param limit cantidad de preguntas
     * @return lista de preguntas con el tamaño indicado
     */
    public static List<Question> randomQuestions(int limit) {
        List<Question> questions = new ArrayList<>(limit);
        int[] randomNumbers = Utilities.randomNumbers(0, questions.size() - 1, MainActivity.N_QUESTIONS);
        for (int number : randomNumbers) {
            Question question = QuestionUtils.questions.get(number);
            if (question != null) questions.add(question);
        }
        return questions;
    }

    /**
     * Devuelve la pregunta con el id y de la temática indicada
     *
     * @param id      identificador de la pregunta a buscar
     * @param subject temática de la pregunta a buscar
     * @return pregunta con el id y de la temática indicada o null si no existe
     */
    public static Question getQuestionBy(int id, Subject subject) {
        for (Question question : questions)
            if (question.getId() == id && question.getSubject().equals(subject)) return question;
        return null;
    }
}
