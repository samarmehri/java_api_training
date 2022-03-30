package fr.lernejo.navy_battle;

public final class Request {

    private final String url;
    private final String id;
    private final String message;

    public Request(String url, String id, String message) {
        this.url = url;
        this.id = id;
        this.message = message;
    }

    public Request() {
        this.url = "";
        this.id = "";
        this.message = "";
    }

    public String getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
