package com.josephmarchand.englishjoe.bot;

import java.util.Locale;

public class JoBot {

    public String answer(String message) {

        if (message == null) {
            return "Je suis JoBot. Pose-moi une question sur l'anglais.";
        }

        String text = message.trim().toLowerCase(Locale.US);

        if (text.isEmpty()) {
            return "Écris une question et je vais essayer de t'aider.";
        }

        if (text.contains("hello") || text.contains("bonjour")) {
            return "Hello ! En anglais, « Hello » signifie « Bonjour ».";
        }

        if (text.contains("thank")) {
            return "Thank you signifie « Merci ». Tu peux aussi dire Thanks.";
        }

        if (text.contains("how are you")) {
            return "How are you? signifie « Comment vas-tu ? ».";
        }

        if (text.contains("name")) {
            return "Pour demander le nom de quelqu'un, tu peux dire : What is your name?";
        }

        if (text.contains("pronunciation")
                || text.contains("prononce")) {
            return "Je peux t'aider à comprendre la prononciation et le vocabulaire anglais.";
        }

        if (text.contains("grammar")
                || text.contains("grammaire")) {
            return "La grammaire explique comment construire correctement les phrases en anglais.";
        }

        if (text.contains("vocabulary")
                || text.contains("vocabulaire")) {
            return "Le vocabulaire correspond aux mots que tu apprends et utilises en anglais.";
        }

        if (text.contains("help")
                || text.contains("aide")) {
            return "Bien sûr ! Tu peux me demander une traduction, une explication de grammaire ou du vocabulaire.";
        }

        return "Je comprends ta question. Continue ton apprentissage et essaie de formuler ta question avec quelques mots simples en anglais ou en français.";
    }
    }
