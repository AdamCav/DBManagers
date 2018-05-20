public class GameState {
    int day=0;
    int action=0;
    int maxAction=2;


    public String determineDate(){
        String date = null;
        int year = day/365;
        int days = day%365;
        String season;
        if (days<=90){
            season="Winter";
        } else if (days<=180) {
            days=days-90;
            season="Spring";
        } else if (days<=270){
            days=days-180;
            season="Summer";
        } else {
            days=days-270;
            season="Fall";
        }
        return season+" "+days+", Year "+year+((action==0)?" Morning":" Afternoon");
    }
}
