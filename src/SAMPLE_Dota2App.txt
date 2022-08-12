import java.util.Scanner;
import java.util.ArrayList;

public class Dota2App {
    public static void main(String[] args) {
        Hero Axe = new Hero("Axe","Axe hts...",1000,1000,600,600,55,2,200,300);
        Hero Slark = new Hero("Slark","zeeeeeee Slarked!",800,800,650,650,68,-1,300,400);
        Hero Lion = new Hero("Lion","Lion Roaring...",1200,1200,400,400,70,-2,300,500);
        Hero Lifestealer = new Hero("Lifestealer","LS Tagh tagh!",1100,1100,300,300,50,3,100,300);
        Hero Beastmaster = new Hero("Beastmaster","Beastmaster shooooweah",800,800,600,600,60,0,200,300);
        Hero Bristle = new Hero("Bristle","BB is comming...",1300,1300,200,200,48,4,150,800);
        Hero Tiny = new Hero("Tiny","Tiny punch!",1100,1100,400,400,55,4,130,300);
        Hero Phoenix = new Hero("Phoenix","Hoooooooooowa Phoenix",800,800,800,800,75,0,250,350);
        Hero Medusa = new Hero("Medusa","Die by Medusa!",1000,1000,700,700,50,1,350,400);
        Hero Mirana = new Hero("Mirana","Axe hts...",900,900,800,800,55,1,270,320);

        Scanner input = new Scanner(System.in);
        ArrayList<Hero> teamA = new ArrayList<Hero>();
        ArrayList<Hero> teamB = new ArrayList<Hero>();

        for(int i = 1 ; i <= 3 ; i++){
            System.out.print("Player A, please pick a hero (select 1-10): ");
            switch (input.nextInt()){
                case 1 :
                    teamA.add(Axe);
                    break;
                case 2 :
                    teamA.add(Slark);
                    break;
                case 3 :
                    teamA.add(Lion);
                    break;
                case 4 :
                    teamA.add(Lifestealer);
                    break;
                case 5 :
                    teamA.add(Beastmaster);
                    break;
                case 6 :
                    teamA.add(Bristle);
                    break;
                case 7 :
                    teamA.add(Tiny);
                    break;
                case 8 :
                    teamA.add(Phoenix);
                    break;
                case 9 :
                    teamA.add(Medusa);
                    break;
                case 10 :
                    teamA.add(Mirana);
                    break;
            }
        }

        for(int i = 1 ; i <= 3 ; i++){
            System.out.print("Player B, please pick a hero (select 1-10): ");
            switch (input.nextInt()){
                case 1 :
                    teamB.add(Axe);
                    break;
                case 2 :
                    teamB.add(Slark);
                    break;
                case 3 :
                    teamB.add(Lion);
                    break;
                case 4 :
                    teamB.add(Lifestealer);
                    break;
                case 5 :
                    teamB.add(Beastmaster);
                    break;
                case 6 :
                    teamB.add(Bristle);
                    break;
                case 7 :
                    teamB.add(Tiny);
                    break;
                case 8 :
                    teamB.add(Phoenix);
                    break;
                case 9 :
                    teamB.add(Medusa);
                    break;
                case 10 :
                    teamB.add(Mirana);
                    break;
            }
        }

//        DEBUG
//        System.out.println(teamA);
//        System.out.println(teamB);
//        System.out.println(teamA.get(2).name);
//        printDashBoard("Player A",teamA,teamB);

        boolean IsAliveTeamA = areAlive(teamA);
        boolean IsAliveTeamB = areAlive(teamB);

        while (IsAliveTeamA && IsAliveTeamB){
            printDashBoard(teamA,teamB);
            System.out.printf("Player B, Please choose character to attack: ");
            int cB = input.nextInt();
            System.out.printf("Player B, Ultimate attack or Normal attack: ");
            char actionB = input.next().toLowerCase().charAt(0);
            System.out.printf("Player B, Please choose enemy to attack: ");
            int eB = input.nextInt();

            switch (actionB){
                case 'a' :
                    if(teamA.get(eB).isAlive()){
                        teamA.get(eB).attackBy(teamB.get(cB));
                    }
                case 'u' :
                    if(teamA.get(eB).isAlive() && teamB.get(cB).ultimate()){
                        teamA.get(eB).ultimateBy(teamB.get(cB));
                    }
            }

            printDashBoard(teamA,teamB);
            System.out.printf("Player A, Please choose character to attack: ");
            int cA = input.nextInt();
            System.out.printf("Player A, Ultimate attack or Normal attack: ");
            char actionA = input.next().toLowerCase().charAt(0);
            System.out.printf("Player A, Please choose enemy to attack: ");
            int eA = input.nextInt();

            switch (actionA){
                case 'a' :
                    if(teamB.get(eA).isAlive()){
                        teamB.get(eA).attackBy(teamA.get(cA));
                    }
                case 'u' :
                    if(teamB.get(eA).isAlive() && teamA.get(cA).ultimate()){
                        teamB.get(eA).ultimateBy(teamA.get(cA));
                    }
            }

        }
    }

    public static boolean areAlive(ArrayList<Hero> team){
//        for (int i = 0 ; i < team.size() ; i++){
//            Hero h = team.get(i);
//        }
        for (Hero h:
             team) {
            if (h.getCurrentHP() > 0){
                return true;
            }
        }
        return false;
    }

    public static void printDashBoard(ArrayList<Hero> teamA, ArrayList<Hero> teamB){
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-15s %-17s %-15s %-17s %n", "PlayerA", "(AT) HP/MP", "PlayerB", "(AT) HP/MP");
        for(int i = 0 ; i <3 ; i++){
            System.out.printf("%d)%-13s %-17s %d)%-13s %-17s %n", i, teamA.get(i).name, "("+(int)teamA.get(i).damage+") "+(int)teamA.get(i).currentHP+"/"+(int)teamA.get(i).currentMana,
                    i, teamB.get(i).name, "("+(int)teamB.get(i).damage+") "+(int)teamB.get(i).currentHP+"/"+(int)teamB.get(i).currentMana);
        }
//        System.out.printf("%s, What is your next move? ", player);
    }

}
