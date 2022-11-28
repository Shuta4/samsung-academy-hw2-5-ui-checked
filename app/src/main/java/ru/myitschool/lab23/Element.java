package ru.myitschool.lab23;

public class Element {
    private final String id;
    private final String cannonicalName;

    public Element(String id, String cannonicalName) {
        this.id = id;
        this.cannonicalName = cannonicalName;
    }

    public String getId() {
        return id;
    }

    public String getCannonicalName() {
        return cannonicalName;
    }
}
