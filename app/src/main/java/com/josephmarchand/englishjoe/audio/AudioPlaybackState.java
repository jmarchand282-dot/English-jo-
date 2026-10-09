package com.josephmarchand.englishjoe.audio;

public class AudioPlaybackState {

    public enum Status {
        IDLE,
        PLAYING,
        PAUSED,
        COMPLETED,
        ERROR
    }

    private Status status = Status.IDLE;
    private String currentText = "";
    private float speechRate = 1.0f;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status == null ? Status.IDLE : status;
    }

    public String getCurrentText() {
        return currentText;
    }

    public void setCurrentText(String text) {
        currentText = text == null ? "" : text;
    }

    public float getSpeechRate() {
        return speechRate;
    }

    public void setSpeechRate(float rate) {
        speechRate = Math.max(0.5f, Math.min(2.0f, rate));
    }

    public boolean isPlaying() {
        return status == Status.PLAYING;
    }

    public void reset() {
        status = Status.IDLE;
        currentText = "";
        speechRate = 1.0f;
    }
}
