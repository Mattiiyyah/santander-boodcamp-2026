package entities.ex3;

public sealed abstract class Clock permits BRLClock, USClock {
    protected Integer hour;
    protected Integer minute;
    protected Integer second;

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        if (hour >= 24) {
            this.hour = 24;
            return;
        }
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        if(minute >= 60) {
            this.minute = 60;
            return;
        }

        this.minute = minute;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        if(second >= 60) {
            this.second = 60;
            return;
        }

        this.second = second;
    }

    private String format(int value) {
        return value <= 9 ? "0" + value : String.valueOf(value);
    }

    public String getTime() {
        return format(hour) + ":" + format(minute) + ":" + format(second);
    }

    public abstract Clock convert(Clock clock);

}
