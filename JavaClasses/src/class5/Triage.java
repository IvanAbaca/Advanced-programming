package class5;

public enum Triage {
	RESUSCITATION(0),
	EMERGENCY(1),
	URGENT(2),
	SEMIURGENT(3),
	NONURGENT(4);
	
	private final int priority;
	
	Triage(int value) {
        this.priority = value;
    }

    public int getPriority() {
        return priority;
    }
}
