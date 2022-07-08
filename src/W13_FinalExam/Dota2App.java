package W13_FinalExam;

import java.util.ArrayList;
import java.util.Scanner;

public class Dota2App {
    public static void main(String[] args) {
        Hero Axe = new Hero("Axe","Axe hts...",1000,1000,600,600,55,2,200,300);
        Hero Slark = new Hero("Slark","zeeeeeee Slarked!",800,800,650,650,68,-1,300,400);
        Hero Lion = new Hero("Lion","Lion Roaring...",1200,1200,400,400,70,-2,300,500);
        Hero Lifestealer = new Hero("Lifestealer","LS Tagh tagh!",1100,1100,300,300,50,3,100,300);
        Hero Beastmaster = new Hero("Beastmaster","Beatmaster shooooweah",800,800,600,600,60,0,200,300);
        Hero Bristleback = new Hero("Bristleback","BB is comming...",1300,1300,200,200,48,4,150,800);
        Hero Tiny = new Hero("Tiny","Tiny punch!",1100,1100,400,400,55,4,130,300);
        Hero Phoenix = new Hero("Phoenix","Hoooooooooowa Phoenix",800,800,800,800,75,0,250,350);
        Hero Medusa = new Hero("Medusa","Die by Medusa!",1000,1000,700,700,50,1,350,400);
        Hero Mirana = new Hero("Mirana","Axe hts...",900,900,800,800,55,1,270,320);

        Scanner input = new Scanner(System.in);
        ArrayList<Hero> teamA = new ArrayList<Hero>();
        ArrayList<Hero> teamB = new ArrayList<Hero>();

        for(int i = 1 ; i <= 3 ; i++){
            System.out.print("Player A, please choose your hero (select 1 - 10): ");
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
                    teamA.add(Bristleback);
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
            System.out.print("Player B, please choose your hero (select 1 - 10): ");
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
                    teamB.add(Bristleback);
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
//        System.out.println(teamA.get(0).name + teamA.get(1).name + teamA.get(2).name);
//        System.out.println(teamB.get(0).name + teamB.get(1).name + teamB.get(2).name);

        while (areAlive(teamA) && areAlive(teamB)){
            printDashBoard(teamA,teamB);
            System.out.println("Player B, select your hero to be attacker: ");
            int heroB = input.nextInt();
            System.out.println("Player B, ultimate attach or normal attack?: ");
            int actionB = input.next().toLowerCase().charAt(0);
            System.out.println("Player B, select opponent's hero to attack: ");
            int enemyB = input.nextInt();
            switch (actionB){
                case 'a' :
                    if (teamB.get(enemyB).isAlive() && teamA.get(heroB).isAlive()){
                        teamB.get(enemyB).setCurrentHP(teamB.get(enemyB).getCurrentHP() - teamA.get(heroB).getDamage());
                    }
                    break;
                case 'u' :
                    if (teamA.get(heroB).ultimate()){
                        teamB.get(enemyB).setCurrentHP(teamB.get(enemyB).getCurrentHP() - teamA.get(heroB).getUltimate_damage());
                    }
                    break;
            }

            printDashBoard(teamA,teamB);
            System.out.println("Player A, select your hero to be attacker: ");
            int heroA = input.nextInt();
            System.out.println("Player A, ultimate attach or normal attack?: ");
            int actionA = input.next().toLowerCase().charAt(0);
            System.out.println("Player A, select opponent's hero to attack: ");
            int enemyA = input.nextInt();
            switch (actionA){
                case 'a' :
                    if (teamB.get(enemyA).isAlive() && teamA.get(heroA).isAlive()){
                        teamB.get(enemyA).setCurrentHP(teamB.get(enemyA).getCurrentHP() - teamA.get(heroA).getDamage());
                    }
                    break;
                case 'u' :
                    if (teamA.get(heroA).ultimate()){
                        teamB.get(enemyA).setCurrentHP(teamB.get(enemyA).getCurrentHP() - teamA.get(heroA).getUltimate_damage());
                    }
                    break;
            }
        }
    }

    public static void printDashBoard(ArrayList<Hero> teamA, ArrayList<Hero> teamB){
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-15s %-17s %-15s %-17s %n", "PlayerA", "(AT) HP/MP", "PlayerB", "(AT) HP/MP");
        for(int i = 0 ; i < 3 ; i++){
            System.out.printf("%d)%-13s %-17s %d)%-13s %-17s %n", i, teamA.get(i).name, "("+(int)teamA.get(i).damage+") "+(int)teamA.get(i).currentHP+"/"+(int)teamA.get(i).currentMP,
                    i, teamB.get(i).name, "("+(int)teamB.get(i).damage+") "+(int)teamB.get(i).currentHP+"/"+(int)teamB.get(i).currentMP);
        }
    }

    public static boolean areAlive(ArrayList<Hero> teamMember){
        if (teamMember.get(0).isAlive() && teamMember.get(1).isAlive() && teamMember.get(2).isAlive()){
            return true;
        }
        return false;
    }
}
