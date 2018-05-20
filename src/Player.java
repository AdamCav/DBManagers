public class Player {
    String name="Test";
    int age=18;
    double powerlevel=100;
    double powerlevelMod=1;
    double fitness=1;
    double trainingMod=1;
    double ageMod=1;
    double fatigue=0;
    boolean hasTrained=false;



    public int determinePowerLevel(){
        return (int)(powerlevel+(powerlevel*powerlevelMod-powerlevel)+(powerlevel*trainingMod-powerlevel))/1;

    }

    public int trainingGains(){
        return 1+(int)powerlevel/500;
    }

    public void modifyFatigue(int x){
        fatigue+=x;
        if (fatigue>100){
            fatigue=100;
        } else if (fatigue<0){
            fatigue=0;
        }
    }

    public void modifyFitness(int x){
        fitness+=x;
        if(fitness>100){
            fitness=100;
        } else if (fitness<1){
            fitness=1;
        }
        trainingMod=1+(fitness*(.1/trainingMod));
        if (trainingMod>3){
            trainingMod=3;
        }
    }

    public String getLocation(){
        return "Home";
    }
}
