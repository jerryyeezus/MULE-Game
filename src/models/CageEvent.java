package models;

public class CageEvent extends Event {
    public CageEvent() {
	this.eventString = "Something happen blah blah";
    }

    @Override
    public void doEvent() {
	System.out.println("TODO shit");
    }
}
