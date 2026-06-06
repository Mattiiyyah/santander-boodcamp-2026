package entities.ex3;

public non-sealed class USClock extends Clock {

    private String periodIndicator;

    public String getPeriodIndicator() {
        return periodIndicator;
    }

    public void setAfterMidDay() {
        this.periodIndicator = "PM";
    }

    public void setBeforeMidday() {
        this.periodIndicator = "AM";
    }

    public void setHour(Integer hour) {
        setBeforeMidday();
        if ((hour > 12) && (hour <= 23)) {
            setAfterMidDay();
            this.hour = hour - 12;
        } else if (hour >= 24) {
            this.hour = 0;
        } else {
            this.hour = hour;
        }
    }

    @Override
    public Clock convert(Clock clock) {
        this.second = clock.getSecond();
        this.minute = clock.getMinute();

        switch (clock) {
            case USClock usClock:
                this.hour = usClock.getHour();
                this.periodIndicator = usClock.getPeriodIndicator();
                break;

            case BRLClock brClock:
                this.setHour(brClock.getHour());
                break;
        }
        return this;
    }

}
