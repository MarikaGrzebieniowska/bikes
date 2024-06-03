package pl.marika.pjatk.mas.bikes.exception;

public class MaximumParticipantsReachedException extends Throwable {

    public MaximumParticipantsReachedException(int maxParticipants) {
        super(String.format("Maximum number of %s participants reached", maxParticipants));
    }
}
