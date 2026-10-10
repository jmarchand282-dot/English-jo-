package com.josephmarchand.englishjoe.planning;

import android.content.Context;
import java.util.List;
import java.util.UUID;

public class StudySessionManager {

    private final StudySessionStorage storage;

    public StudySessionManager(Context context) {
        storage = new StudySessionStorage(context);
    }

    public synchronized StudySession create(
            String subject,
            long startTime,
            int plannedMinutes) {

        StudySession session = new StudySession(
                UUID.randomUUID().toString(),
                subject,
                startTime,
                plannedMinutes
        );

        List<StudySession> sessions = storage.loadAll();
        sessions.add(session);
        storage.saveAll(sessions);

        return session;
    }

    public synchronized List<StudySession> getAll() {
        return storage.loadAll();
    }

    public synchronized boolean recordProgress(
            String sessionId,
            int minutes) {

        List<StudySession> sessions = storage.loadAll();

        for (StudySession session : sessions) {
            if (session.getId().equals(sessionId)) {
                session.addCompletedMinutes(minutes);
                storage.saveAll(sessions);
                return true;
            }
        }

        return false;
    }

    public synchronized boolean delete(String sessionId) {
        if (sessionId == null) return false;

        List<StudySession> sessions = storage.loadAll();
        boolean removed = sessions.removeIf(
                session -> session.getId().equals(sessionId));

        if (removed) storage.saveAll(sessions);
        return removed;
    }

    public synchronized void clear() {
        storage.clear();
    }
                                       }
