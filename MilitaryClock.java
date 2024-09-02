public class MilitaryClock implements Clock{
    private int hour;
    private int minute;
    public MilitaryClock(){
        hour=0;
        minute=0;
    }
    public MilitaryClock(int hour, int minute){
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
        if (minute<10 && hour<10){
            answer+= "0" + hour + ":0" + minute;
        } else if(minute<10){
            answer+=hour + ":0" + minute;
        } else if(hour<10){
            answer+="0" + hour + ":" + minute;
        } else{
            answer+=hour + ":" + minute;
        }
        return answer;
    }
    public boolean equals (Object obj){
        return true;
    }
    public void normalizeTime(){
        if (minute >= 60){
            hour+=minute % 60;
            int temp=minute-(60*(minute % 60));
            minute=temp;
            if (minute==60){
                hour++;
                minute=0;
            }
            if (hour>=24){
                hour=0;
            }
        }
    }
    public void addOneMinute(){
        minute++;
        normalizeTime();
    }
    public void addMinutes(int m){
        minute+=m;
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
