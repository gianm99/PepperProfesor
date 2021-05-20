package com.igu.pepperprofesor.question;

import com.igu.pepperprofesor.MainActivity;
import com.igu.pepperprofesor.R;
import com.igu.pepperprofesor.Subject;
import com.igu.pepperprofesor.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.igu.pepperprofesor.Subject.CASTELLANO;
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
                                new Option('c', "Segunda Guerra Mundial"))),
                new OptionQuestion(CASTELLANO, 1, "¿Cuál es la palabra intrusa en esta familia?",
                        Arrays.asList(new Option('a', "Arena"),
                                new Option('b', "Área"),
                                new Option('c', "Arenal"))),
                new OptionQuestion(CASTELLANO, 2, "En la oración La vieja fábrica, ¿qué función realiza la?",
                        Arrays.asList(new Option('a', "Determinante"),
                                new Option('b', "Núcleo"),
                                new Option('c', "Complemento"))),
                new OptionQuestion(CASTELLANO, 3, "¿Cuál es el pretérito imperfecto de subjuntivo del verbo decir?",
                        Arrays.asList(new Option('a', "Dijera o dijese."),
                                new Option('b', "Dije"),
                                new Option('c', "Dijere"))),
                new OptionQuestion(CASTELLANO, 4, "¿Cuándo llevan tilde las palabras agudas?",
                        Arrays.asList(new Option('a', "Siempre"),
                                new Option('b', "Si terminan en vocal o en consonante n,s."),
                                new Option('c', "Si terminan en consonante diferente a n o s."))),
                new OptionQuestion(CASTELLANO, 5, "¿Cuál de estas palabras lleva tilde?",
                        Arrays.asList(new Option('a', "Cartera"),
                                new Option('b', "Parpado"),
                                new Option('c', "Tenedor"))),
                new Question(CASTELLANO, 6, "¿Cuál es el femenino de la palabra alcalde?"),
                new ImageQuestion(CASTELLANO, 7, "¿Cómo se llama la persona que toca este instrumento?", R.drawable.violin),
                new OptionQuestion(CASTELLANO, 8, "¿Cuál de estos sustantivos es propio?",
                        Arrays.asList(new Option('a', "Rebaño"),
                                new Option('b', "Árbol"),
                                new Option('c', "Andrés"))),
                new ImageQuestion(CASTELLANO, 9, "¿Quién es?", R.drawable.cervantes),
                new OptionQuestion(CASTELLANO, 10, "¿Qué palabra lleva hache?",
                        Arrays.asList(new Option('a', "Invierno"),
                                new Option('b', "Orario"))),
                new OptionQuestion(CASTELLANO, 11, "¿Por qué el enunciado Rebajas de invierno no es una oración?",
                        Arrays.asList(new Option('a', "No tiene sujeto."),
                                new Option('b', "No consta de sujeto y predicado y no posee un verbo en forma personal."))),
                new OptionQuestion(CASTELLANO, 12, "¿Cuál de estos grupos son sinónimos entre ellos?",
                        Arrays.asList(new Option('a', "Limpiar, lavar, asear."),
                                new Option('b', "Andar, caminar, contemplar."))),
                new Question(CASTELLANO, 13, "¿Cuál es el antónimo de coser?"),
                new OptionQuestion(CASTELLANO, 14, "¿Cuál empieza por Y?",
                        Arrays.asList(new Option('a', "Llugular/Yugular."),
                                new Option('b', "Lluvia/Yuvia"))),
                new Question(CASTELLANO, 15, "¿Qué letra le falta a jerse...?"),
                new Question(CASTELLANO, 16, "¿Cuál es el prefijo de superdotado?"),
                new Question(CASTELLANO, 17, "¿Cuál es el prefijo de antigripal?"),
                new OptionQuestion(CASTELLANO, 18, "Completa la oración, Este utensilio sirve para ... el pan.",
                        Arrays.asList(new Option('a', "Rallar con ll."),
                                new Option('b', "Rayar con y"))),
                new OptionQuestion(CASTELLANO, 19, "¿Cuál es la palabra correcta? Los jueces ... al acusado porque era inocente.",
                        Arrays.asList(new Option('a', "Absolvieron"),
                                new Option('b', "Absorbieron"))),
                new OptionQuestion(CASTELLANO, 20, "¿Cuál de estas afirmaciones es falsa?",
                        Arrays.asList(new Option('a', "Las palabras monosílabas jamás se acentúan."),
                                new Option('b', "Más lleva tilde cuando significa cantidad."))),
                new OptionQuestion(CASTELLANO, 21, "La palabra UNICEF es",
                        Arrays.asList(new Option('a', "Una abreviatura"),
                                new Option('b', "Siglas"))),
                new OptionQuestion(CASTELLANO, 22, "La palabra Dña es",
                        Arrays.asList(new Option('a', "Una abreviatura"),
                                new Option('b', "Siglas"))),
                new OptionQuestion(CASTELLANO, 23, "¿Cuál es la palabra castellana correspondiente al extranjerismo confort?",
                        Arrays.asList(new Option('a', "Comodidad"),
                                new Option('b', "Encanto"))),
                new OptionQuestion(CASTELLANO, 24, "¿Cuál es la palabra castellana correspondiente al extranjerismo grill?",
                        Arrays.asList(new Option('a', "Hamburguesa"),
                                new Option('b', "Parrilla"))),
                new OptionQuestion(CASTELLANO, 25, "Las preposiciones son",
                        Arrays.asList(new Option('a', "Enlaces que unen dos palabras o grupos de palabras que corresponden a ideas semejantes"),
                                new Option('b', "Enlaces que unen dos palabras de modo que la segunda complementa a la primera"))),
                new OptionQuestion(CASTELLANO, 26, "Las conjunciones son",
                        Arrays.asList(new Option('a', "Enlaces que unen dos palabras o grupos de palabras que corresponden a ideas semejantes"),
                                new Option('b', "Enlaces que unen dos palabras de modo que la segunda complementa a la primera"))),
                new OptionQuestion(CASTELLANO, 27, "El eufemismo de muerte es",
                        Arrays.asList(new Option('a', "Sustracción"),
                                new Option('b', "Defunción"))),
                new OptionQuestion(CASTELLANO, 28, "Completa la palabra a...edrez.",
                        Arrays.asList(new Option('a', "J"),
                                new Option('b', "G"))),
                new OptionQuestion(CASTELLANO, 29, "Completa la palabra e...emplo",
                        Arrays.asList(new Option('a', "J"),
                                new Option('b', "G"))),
                new OptionQuestion(CASTELLANO, 30, "Completa la palabra ...eranio",
                        Arrays.asList(new Option('a', "J"),
                                new Option('b', "G"))),
                new OptionQuestion(CASTELLANO, 31, "Completa la palabra e...pléndido",
                        Arrays.asList(new Option('a', "X"),
                                new Option('b', "S"))),
                new OptionQuestion(CASTELLANO, 32, "Completa la palabra e...plícito",
                        Arrays.asList(new Option('a', "X"),
                                new Option('b', "S"))),
                new OptionQuestion(CASTELLANO, 33, "Completa la palabra e...quema",
                        Arrays.asList(new Option('a', "X"),
                                new Option('b', "S"))),
                new Question(CASTELLANO, 34, "¿Cuáles son las siglas del Documento Nacional de Identidad?"),
                new OptionQuestion(CASTELLANO, 35, "La oración Martín es una joya tiene",
                        Arrays.asList(new Option('a', "Sentido literal"),
                                new Option('b', "Sentido figurado"))),
                new OptionQuestion(CASTELLANO, 36, "La oración Eva es una lapa, no te la quitas de encima tiene",
                        Arrays.asList(new Option('a', "Sentido literal"),
                                new Option('b', "Sentido figurado"))),
                new OptionQuestion(CASTELLANO, 37, "La oración Entro en el gallinero a recoger los huevos tiene",
                        Arrays.asList(new Option('a', "Sentido literal"),
                                new Option('b', "Sentido figurado"))),
                new OptionQuestion(CASTELLANO, 38, "En Alicia escribió un cuento precioso. Un cuento precioso es",
                        Arrays.asList(new Option('a', "Complemento indirecto CI"),
                                new Option('b', "Complemento directo CD"))),
                new OptionQuestion(CASTELLANO, 39, "En Vino ayer su primo Juan. Ayer es",
                        Arrays.asList(new Option('a', "Complemento circunstancial de modo"),
                                new Option('b', "Complemento circunstancial de tiempo"))),
                new OptionQuestion(CASTELLANO, 40, "Algo que no es legal es",
                        Arrays.asList(new Option('a', "Contralegal"),
                                new Option('b', "Ilegal"),
                                new Option('c', "Antilegal")))
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
