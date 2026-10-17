
package com.josephmarchand.englishjoe.audio;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class SpeechManager {

    private TextToSpeech textToSpeech;
    private boolean ready = false;

    public SpeechManager(Context context) {
        textToSpeech = new TextToSpeech(
                context.getApplicationContext(),
                status -> {
                    TextToSpeech tts = textToSpeech;

                    if (status == TextToSpeech.SUCCESS && tts != null) {
                        int result = tts.setLanguage(Locale.US);

                        ready = result != TextToSpeech.LANG_MISSING_DATA
                                && result != TextToSpeech.LANG_NOT_SUPPORTED;
                    } else {
                        ready = false;
                    }
                }
        );
    }

    public void speak(String text) {
        TextToSpeech tts = textToSpeech;

        if (!ready || tts == null || text == null
                || text.trim().isEmpty()) {
            return;
        }

        tts.speak(
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
        TextToSpeech tts = textToSpeech;

        if (tts != null) {
            tts.stop();
        }
    }

    public void shutdown() {
        TextToSpeech tts = textToSpeech;

        if (tts != null) {
            tts.stop();
            tts.shutdown();
            textToSpeech = null;
            ready = false;
        }
    }
}
