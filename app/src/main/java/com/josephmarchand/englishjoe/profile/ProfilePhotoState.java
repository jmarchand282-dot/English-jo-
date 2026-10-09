package com.josephmarchand.englishjoe.profile;

import android.net.Uri;

public class ProfilePhotoState {

    private Uri photoUri;

    public ProfilePhotoState() {
        photoUri = null;
    }

    public Uri getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(Uri uri) {
        photoUri = uri;
    }

    public boolean hasPhoto() {
        return photoUri != null;
    }

    public void clear() {
        photoUri = null;
    }

    public String getPhotoUriString() {
        return photoUri == null ? "" : photoUri.toString();
    }

    public void restoreFromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            photoUri = null;
            return;
        }

        try {
            photoUri = Uri.parse(value);
        } catch (RuntimeException exception) {
            photoUri = null;
        }
    }
}
