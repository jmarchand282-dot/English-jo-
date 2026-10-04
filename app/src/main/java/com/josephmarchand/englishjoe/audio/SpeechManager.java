package com.josephmarchand.englishjoe.audio;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class SpeechManager {

    private final TextToSpeech textToSpeech;
    private boolean ready = false;

    public SpeechManager(Context context) {

        textToSpeech = new TextToSpeech(
                context.getApplicationContext(),
                status -> {
                    if (status == TextToSpeech.SUCCESS) {
                        int result = textToSpeech.setLanguage(Locale.US);

                        ready = result != TextToSpeech.LANG_MISSING_DATA
                                && result != TextToSpeech.LANG_NOT_SUPPORTED;
                    }
                }
        );
    }

    public void speak(String text) {
        if (!ready || text == null || text.trim().isEmpty()) {
            return;
        }

        textToSpeech.speak(
                text,
                TextToSpeech.QUEUE_FLUSH,
                null,
                "english_joe_audio"
        );
    }

    public boolean isReady() {
        return ready;
    }

    public void stop() {
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
    }

    public void shutdown() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
