package cz.czechitas.java2webapps.ukol5.controller;

public enum Sport {
    SWIMMING("Swimming"),
    RUNNING("Running"),
    HIKING("Hiking"),
    FOOTBALL("Football"),
    BASKETBALL("Basketball"),
    VOLLEYBALL("Volleyball"),
    QUIDDITCH("Quidditch"),
    HORSE_RIDING("Horse Riding"),
    CYCLING("Cyclint");

    public final String sportsLabel;

    private Sport(String sportsLabel) {
        this.sportsLabel = sportsLabel;

    }


}
