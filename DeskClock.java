public class DeskClock implements Clock{
    private int hour;
    private int minute;
    public DeskClock(){
        hour=12;
        minute=0;
    }
    public DeskClock(int hour, int minute){
        this.hour=hour;
        this.minute=minute;
    }
    public int getHour(){
        return hour;
    }
    public int getMinutes(){
        return minute;
    }
    public void setHour(int h){
        hour=h;
    }
    public void setMinutes(int m){
        minute=m;
    }
    public String toString(){
        String answer="";
        if(minute<10 && hour<10){
            answer+="0" + hour + ":0" + minute;
        } else if(minute<10){
            answer+=hour + ":0" + minute;
        } else if(hour<10){
            answer+="0" + hour + ":" + minute;
        } else{
            answer+=hour + ":" + minute;
        }
        return answer;
    }
    public boolean equals(Object obj){
        return true;
    }
    public void normalizeTime(){
        if(minute >= 60){
            hour+=minute % 60;
            minute=minute-(60 *(minute % 60));
            if(minute==60){
                hour++;
                minute=0;
            }
            if(hour>12){
                hour=1;
            }
        }
    }
    public void addOneMinute(){
        minute++;
        normalizeTime();
    }
    public void addMinutes(int min){
        minute+=min;
        normalizeTime();
    }
    public void addTime(int h, int m){
        hour+=h;
        minute+=m;
        normalizeTime();
    }
    public void resetTime(int h, int m){
        hour=h;
        minute=m;
        normalizeTime();
    }
}
