public class FootballPlayer {

    //Too much duplication in constructors

    private String name;
    private int shootedGoal;
    private int goalPass;
    private double ballPossession;
    private int succesfullDefense;

    public FootballPlayer(String name, int shootedGoal, int goalPass, int succesfullDefense) {
        this.name = name;
        this.shootedGoal = shootedGoal;
        this.goalPass = goalPass;
        this.succesfullDefense = succesfullDefense;
    }

    public FootballPlayer(String name, double ballPossession, int succesfullDefense) {
        this.name = name;
        this.ballPossession = ballPossession;
        this.succesfullDefense = succesfullDefense;
    }

    public FootballPlayer(String name, int shootedGoal) {
        this.name = name;
        this.shootedGoal = shootedGoal;
    }

    //
//------------------------------------------------------------------------------------
//
//    After refactoring
//
    public FootballPlayer(String name, int shootedGoal, int goalPass, double ballPossession, int succesfullDefense) {
        this.name = name;
        this.shootedGoal = shootedGoal;
        this.goalPass = goalPass;
        this.ballPossession = ballPossession;
        this.succesfullDefense = succesfullDefense;
    }

    public FootballPlayer(String name, int goalPass, int succesfullDefense) {
        this(name, 0, goalPass, 0, succesfullDefense);
    }

    public FootballPlayer(String name, int goalPass, double ballPossession, int succesfullDefense) {
        this(name, 0, goalPass, ballPossession, succesfullDefense);
    }


    public String getName() {
        return name;
    }

    public int getGoalPass() {
        return goalPass;
    }


    public static void main(String[] args) {
        FootballPlayer ronaldo = new FootballPlayer("Ronaldo", 37, 27);
        FootballPlayer neymar = new FootballPlayer("Neymar", 29, 18.5, 4);
        System.out.println(ronaldo.getName());
        System.out.println(neymar.getGoalPass());
    }
}
