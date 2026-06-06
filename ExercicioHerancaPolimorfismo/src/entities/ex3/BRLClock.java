package entities.ex3;

public non-sealed class BRLClock extends Clock {

    @Override
    public Clock convert(Clock clock) {
        this.second = clock.getSecond();
        this.minute = clock.getMinute();

        switch (clock) {
            case USClock usClock:
                this.hour = (usClock.getPeriodIndicator().equals("PM")) ? usClock.getHour() + 12 : usClock.getHour();
                break;

            case BRLClock brClock:
                this.hour = brClock.getHour();
                break;
        }
        return this;
    }

}
