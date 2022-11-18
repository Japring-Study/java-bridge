package bridge.Model;

public class Player {
    private int nextLocation;
    private String lastSelection;
    private boolean alive;


    public Player() {
        this.nextLocation = 0;
        this.lastSelection = null;
        this.alive = true;
    }


    public void setLastSelection(String lastSelection) {
        this.lastSelection = lastSelection;
    }


    public boolean isAlive() {
        return this.alive;
    }

    public int getNextLocation() {
        return this.nextLocation;
    }

    public String getLastSelection() {
        return this.lastSelection;
    }

    public void die() {
        this.alive = false;
    }

    public void success() {
        this.nextLocation++;
    }

    public void revive() {
        this.alive = true;
        this.nextLocation = 0;
    }

}
