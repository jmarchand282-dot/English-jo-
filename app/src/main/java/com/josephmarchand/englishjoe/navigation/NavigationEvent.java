package com.josephmarchand.englishjoe.navigation;

public final class NavigationEvent {

    private final ScreenType destination;
    private final Object data;
    private final long timestamp;

    public NavigationEvent(ScreenType destination, Object data) {
        if (destination == null) {
            throw new IllegalArgumentException(
                    "La destination ne peut pas être nulle."
            );
        }

        this.destination = destination;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public ScreenType getDestination() {
        return destination;
    }

    public Object getData() {
        return data;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
