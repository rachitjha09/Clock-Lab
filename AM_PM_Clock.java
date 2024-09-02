public class AM_PM_Clock {
    private int hour;
    private int minute;
    private boolean b;
    private boolean checkHour;
    public AM_PM_Clock(){
        hour=12;
        minute=0;
        b=true;
    }
    public AM_PM_Clock(int hour, int minute, String a){
        this.hour=hour;
        this.minute=minute;
        if(a.equals("AM")){
            b=true;
        } else{
            b=false;
        }
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
    public void setMinutes(int min){
        minute=min;
    }
    public String toString(){
        String a="PM";
        if(b){
            a="AM";
        }
        java.lang.String answer="";
        if (minute<10 && hour<10){
            answer +=  "0" + hour + ":0" + minute + a;
        } else if(minute<10){
            answer += hour + ":0" + minute + a;
        } else if(hour<10){
            answer += "0" + hour + ":" + minute + a;
        } else{
            answer += hour + ":" + minute + a;
        }
        return answer;
    }
    public boolean equals (Object obj){
        return true;
    }
    public void normalizeTime(){
        if(hour==11){
            checkHour=true;
        } else{
            checkHour=false;
        }
        if (minute >= 60){
            hour += minute % 60;
            int temp=minute-(60 * (minute % 60));
            minute=temp;
            if (minute==60){
                hour++;
                minute=0;
                if(hour>0 && checkHour){
                    b=!b;
                }
            }
        }
        if (hour>12){
            hour=1;
        }
    }
    public void addOneMinute(){
        minute++;
        normalizeTime();
    }
    public void addMinutes(int min){
        minute += min;
        normalizeTime();
    }
    public void addTime(int h, int min){
        hour += h;
        minute += min;
        normalizeTime();
    }
    public void resetTime(int h, int min, String a){
        hour=h;
        minute=min;
        if (a.equals("AM")){
            b=true;
        } else{
            b=false;
        }
        normalizeTime();
    }
}