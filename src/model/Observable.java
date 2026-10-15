package model;

public interface Observable {
    public void addObserver(Observer obs);
    public void deleteObserver(Observer obs);
    public void notifyObservers();
}
