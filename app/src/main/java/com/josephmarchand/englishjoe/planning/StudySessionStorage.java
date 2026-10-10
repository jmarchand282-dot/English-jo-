package com.josephmarchand.englishjoe.planning;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class StudySessionStorage {

    private static final String PREFS = "english_joe_study_sessions";
    private static final String KEY_SESSIONS = "sessions";

    private final SharedPreferences preferences;

    public StudySessionStorage(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public synchronized void saveAll(List<StudySession> sessions) {
        JSONArray array = new JSONArray();

        try {
            if (sessions != null) {
                for (StudySession session : sessions) {
                    if (session == null) continue;

                    JSONObject object = new JSONObject();
                    object.put("id", session.getId());
                    object.put("subject", session.getSubject());
                    object.put("start", session.getStartTime());
                    object.put("planned", session.getPlannedMinutes());
                    object.put("completed", session.getCompletedMinutes());
                    array.put(object);
                }
            }

            preferences.edit()
                    .putString(KEY_SESSIONS, array.toString())
                    .apply();
        } catch (Exception ignored) {
        }
    }

    public synchronized List<StudySession> loadAll() {
        List<StudySession> sessions = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(
                    preferences.getString(KEY_SESSIONS, "[]"));

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                StudySession session = new StudySession(
                        object.optString("id", ""),
                        object.optString("subject", ""),
                        object.optLong("start", 0),
                        object.optInt("planned", 1)
                );

                session.addCompletedMinutes(
                        object.optInt("completed", 0));

                sessions.add(session);
            }
        } catch (Exception ignored) {
        }

        return sessions;
    }

    public synchronized void clear() {
        preferences.edit().remove(KEY_SESSIONS).apply();
    }
                      }
