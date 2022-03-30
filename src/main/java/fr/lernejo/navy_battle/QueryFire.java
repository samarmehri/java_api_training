package fr.lernejo.navy_battle;

public class QueryFire {
    private final Actions result;
    private final boolean shipLeft;

    public QueryFire(Actions consequence, boolean shipLeft) {
        this.result = consequence;
        this.shipLeft = shipLeft;
    }

    public QueryFire() {
        this.result = Actions.miss;
        this.shipLeft = false;
    }
    public Actions getResult() {
        return result;
    }

    public boolean isShipLeft() {
        return shipLeft;
    }
}
