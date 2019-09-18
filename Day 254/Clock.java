// Jorge Sanchez
// A01635375
// Clock.java
// En general no hubo problemas solamente tengo curiosidad en que tan bien estaria usar de esta manera los ternarios
// más que nada por legibilidad
public class Clock implements Comparable{
        private int hr,
                min,
                sec;

        public Clock(){
            this(12,0,0);
        }
        public Clock(int hr, int min, int sec){
            this.hr=hr;
            this.min=min;
            this.sec=sec;
        }
        public void setTime(int hr, int min, int sec){
            if(hr>=0&&hr<24){
                this.hr=hr;
            }else{
                this.hr=12;
            }
            if(min>=0&&min<60){
                this.min=min;
            }else{
                this.min=12;
            }
            if(sec>=0&&sec<60){
                this.sec=sec;
            }else{
                this.sec=00;
            }

        }

        public int getHours(){
            return this.hr;
        }
        public int getMinutes(){
            return this.min;
        }
        public int getSeconds(){
            return this.sec;
        }

        public void printTime(){
            System.out.println(this.hr+":"+this.min+":"+this.sec);
        }
        public void incrementHours(){
            this.hr=++this.hr%24;
        }
        public void incrementMinutes(){
            this.min=++this.min%60;
            if (this.min==0) { incrementHours(); }
        }
        public void incrementSeconds(){
            this.min=++this.min%60;
            if (this.min==0) { incrementMinutes(); }

        }

        public boolean equals(Clock clock){
            return this.hr == clock.hr && this.min == clock.min && this.sec==clock.sec;
        }

        public void makeCopy(Clock clock){
            this.hr = clock.hr;
            this.min = clock.min;
            this.sec = clock.sec;
        }

        public Clock getCopy(){
            return new Clock(this.hr, this.min, this.sec);
        }


        public int compareTo(Object obj){
            Clock reloj = (Clock) obj;
            return reloj.getHours() == this.hr ? 0: reloj.getHours() < this.hr ? -1:1;
        }

}