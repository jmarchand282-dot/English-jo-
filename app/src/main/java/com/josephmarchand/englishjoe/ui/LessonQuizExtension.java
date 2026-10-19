package com.josephmarchand.englishjoe.ui;

import com.josephmarchand.englishjoe.models.Question;
import java.util.List;

/** Topic-specific checks for the expanded lesson set (IDs 31–60). */
final class LessonQuizExtension {
    private LessonQuizExtension() {}

    static void addQuestions(int id, List<Question> questions) {
        switch (id) {
            case 31:
                add(questions, "Choose a natural way to state your age.", new String[]{"I have sixteen years.", "I am sixteen years old.", "I do sixteen.", "I am sixteen years."}, 1, "En anglais, l'âge s'exprime avec be: I am sixteen years old.");
                break;
            case 32:
                add(questions, "My parents ___ very kind.", new String[]{"is", "am", "are", "be"}, 2, "Parents est pluriel, donc on utilise are.");
                break;
            case 33:
                add(questions, "Choose the correct daily-routine sentence.", new String[]{"She go to school.", "She goes to school.", "She going school.", "She does goes school."}, 1, "Au présent simple, he/she/it prend généralement -s : goes.");
                break;
            case 34:
                add(questions, "___ two chairs in the room.", new String[]{"There is", "There are", "It are", "They is"}, 1, "Avec un nom pluriel, on utilise There are.");
                break;
            case 35:
                add(questions, "Choose the correct sentence.", new String[]{"He can sings.", "He cans sing.", "He can sing.", "He can to sing."}, 2, "Après can, le verbe reste à sa base sans -s ni to.");
                break;
            case 36:
                add(questions, "Which expression is correct in standard English?", new String[]{"an advice", "two informations", "a piece of advice", "many water"}, 2, "Advice est indénombrable : a piece of advice.");
                break;
            case 37:
                add(questions, "Choose the correct position of the frequency adverb.", new String[]{"I often read.", "I read often always.", "Often I am read.", "I am read often."}, 0, "L'adverbe se place généralement avant le verbe principal : I often read.");
                break;
            case 38:
                add(questions, "“You mustn't park here” means:", new String[]{"You don't need to park here.", "Parking here is forbidden.", "Parking here is recommended.", "You parked here yesterday."}, 1, "Mustn't exprime une interdiction, pas une absence d'obligation.");
                break;
            case 39:
                add(questions, "What are you doing now? — I ___ English.", new String[]{"study", "studied", "am studying", "have study"}, 2, "Pour une action en cours, utilise am/is/are + verbe-ing.");
                break;
            case 40:
                add(questions, "Which phrase gives a direction?", new String[]{"Turn left at the bank.", "I am hungry.", "It costs five dollars.", "I was at home."}, 0, "Turn left at the bank signifie tourner à gauche à la banque.");
                break;
            case 41:
                add(questions, "Choose the natural sentence with a finished past time.", new String[]{"I have seen her yesterday.", "I saw her yesterday.", "I see her yesterday.", "I had see her yesterday."}, 1, "Yesterday situe l'action dans un passé terminé : past simple.");
                break;
            case 42:
                add(questions, "The person ___ called you is my teacher.", new String[]{"where", "who", "when", "whose is"}, 1, "Who sert à introduire une relative qui décrit une personne.");
                break;
            case 43:
                add(questions, "Which phrase expresses partial agreement politely?", new String[]{"You're completely wrong.", "I partly agree, but…", "Stop talking.", "I don't care at all."}, 1, "I partly agree reconnaît une partie du point de vue tout en permettant une réserve.");
                break;
            case 44:
                add(questions, "“We ran out of milk” means:", new String[]{"We bought extra milk.", "We had no milk left.", "We ran to the shop with milk.", "We spilled a glass."}, 1, "Run out of signifie ne plus avoir de quelque chose.");
                break;
            case 45:
                add(questions, "What should a topic sentence do?", new String[]{"Introduce the paragraph's main idea.", "Repeat every detail.", "Add an unrelated story.", "End without a topic."}, 0, "La topic sentence annonce l'idée principale du paragraphe.");
                break;
            case 46:
                add(questions, "If I had left earlier, I ___ the bus.", new String[]{"would catch", "will catch", "would have caught", "caught have"}, 2, "Third conditional : if + past perfect, would have + participe passé.");
                break;
            case 47:
                add(questions, "The lights are on and I hear voices. They ___ be home.", new String[]{"must", "can't to", "mustn't", "should have"}, 0, "Must peut exprimer une déduction forte fondée sur des indices.");
                break;
            case 48:
                add(questions, "Which connector best introduces a consequence?", new String[]{"Although", "Therefore", "Whereas", "Despite"}, 1, "Therefore signifie donc/par conséquent.");
                break;
            case 49:
                add(questions, "Which answer is strongest in a job interview?", new String[]{"I am perfect at everything.", "I have no examples.", "I solved a scheduling problem by organising tasks.", "I don't want to explain."}, 2, "Un exemple concret décrit une action et un résultat, plutôt qu'une affirmation vague.");
                break;
            case 50:
                add(questions, "When comparing solutions, you should consider their ___.", new String[]{"advantages and risks", "names only", "colours only", "length only"}, 0, "Comparer avantages et risques permet de justifier un choix.");
                break;
            case 51:
                add(questions, "If I had accepted the offer, I ___ there now.", new String[]{"would work", "would be working", "will work", "worked yesterday"}, 1, "Une condition passée peut avoir une conséquence présente : would be working.");
                break;
            case 52:
                add(questions, "Which phrase uses nominalisation?", new String[]{"The committee decided quickly.", "The committee's decision was announced.", "They decide tomorrow.", "Decide it now."}, 1, "Decision est le nom dérivé du verbe decide.");
                break;
            case 53:
                add(questions, "The team tested a method. ___ approach reduced errors.", new String[]{"This", "Those", "Who", "Where"}, 0, "This approach reprend clairement l'idée précédente au singulier.");
                break;
            case 54:
                add(questions, "A correlation between two events does not automatically prove ___.", new String[]{"causation", "a relationship of any kind", "that data exist", "a time sequence"}, 0, "La corrélation seule ne suffit pas à démontrer une relation causale.");
                break;
            case 55:
                add(questions, "Choose a diplomatic way to raise a concern.", new String[]{"Your idea is ridiculous.", "I appreciate the proposal; my concern is the timing.", "You never understand.", "There is nothing to discuss."}, 1, "La phrase reconnaît la proposition puis formule précisément la réserve.");
                break;
            case 56:
                add(questions, "“It's getting late” may implicitly suggest leaving depending on ___.", new String[]{"context and relationship", "spelling alone", "word length", "the alphabet"}, 0, "Le sens pragmatique dépend du contexte, de la relation et de l'intonation.");
                break;
            case 57:
                add(questions, "In “Time is a thief,” time is described metaphorically as ___.", new String[]{"a person who steals", "a clock with hands", "a calendar page", "a mathematical formula"}, 0, "La métaphore associe le temps à un voleur pour évoquer ce qu'il nous enlève.");
                break;
            case 58:
                add(questions, "To evaluate an argument, identify its premises and ___.", new String[]{"conclusion", "font", "author's age", "paragraph length only"}, 0, "Un argument relie des prémisses à une conclusion.");
                break;
            case 59:
                add(questions, "Which version is most appropriate for a formal email?", new String[]{"Gimme the file.", "Send it now.", "Could you please send me the file?", "Pass it over, yeah."}, 2, "Could you please…? adapte la demande à un registre formel et poli.");
                break;
            default:
                add(questions, "Which practice best supports precise communication?", new String[]{"Define key terms and state limits clearly.", "Use the longest words possible.", "Avoid all qualifications.", "Ignore counterarguments."}, 0, "Une communication précise définit les termes et indique les limites de la conclusion.");
                break;
        }
    }

    private static void add(List<Question> questions, String text, String[] options, int answer, String explanation) {
        questions.add(new Question(text, options, answer, explanation));
    }
}
