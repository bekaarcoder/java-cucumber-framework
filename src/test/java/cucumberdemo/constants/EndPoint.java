package cucumberdemo.constants;

public enum EndPoint {
    STORE("/store");
    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}
