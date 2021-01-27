package project1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class warTester {

    public static void main(String[] args) {

        Hands hand = new Hands();

        hand.CreateUserHand();
        hand.CreateCpuHand();
        Scanner scanner = new Scanner(System.in);

        Queue<Card> userHand =  new LinkedList<>();
        userHand = hand.getUSERhand();
        Queue<Card> cpuHand =  new LinkedList<>();
        cpuHand = hand.getCPUhand();
        Queue<Card> warHand =  new LinkedList<>();  // queue for war
        int war = 0;

        // play until on player is out of cards.
        while((userHand.size() > 0) && (cpuHand.size() > 0)){
            Card first_User = userHand.remove();
            Card first_Cpu = cpuHand.remove();

            if(first_User.value > first_Cpu.value) {
                System.out.printf("CPU card is: " + first_Cpu + ", User Card is : " + first_User + ". you won that round... ");
                userHand.add(first_Cpu);                 //User wins, gets CPU card
                userHand.add(first_User);
                System.out.println("now you have "+userHand.size() +" cards");
            }

            else if (first_User.value < first_Cpu.value) {
                System.out.println("CPU card is: " + first_Cpu + ", User Card is: " + first_User + ". CPU is winning, would you like to play another card? y/n ");
                String keepPlaying = scanner.next();
                if( keepPlaying.equalsIgnoreCase("y")) {
                    Card tied_User = userHand.remove();
                    int sum = tied_User.value + first_User.value;
                    System.out.println("your played card is: " + tied_User +". the sum is " + sum);
                    if(sum < first_Cpu.value) {
                        System.out.println("you won that round");
                        userHand.add(first_Cpu);          // user wins after 2nd card
                        userHand.add(first_User);
                        userHand.add(tied_User);             //user losses both cards
                        System.out.println("now you have "+userHand.size() +" cards");
                    }
                    else if (sum > first_Cpu.value) {
                        System.out.println("you lost both cards.");
                        cpuHand.add(first_User);
                        cpuHand.add(tied_User);             //user losses both cards
                        cpuHand.add(first_Cpu);
                        System.out.println("now you have "+userHand.size() +" cards");
                    }
                    else
                    {
                        System.out.println("game was tied. time to war!");
                        warHand.add(tied_User);
                        warHand.add(first_User);   // use temporary queue for hand
                        warHand.add(first_Cpu);
                        war = 1;
                    }
                }
                else {
                    System.out.println("You lost"
                            + " card "+ first_User);
                    cpuHand.add(first_User);
                    cpuHand.add(first_Cpu);
                    System.out.println("now you have "+userHand.size() +" cards");
                }

            }
            else if(first_User.value == first_Cpu.value) {
                System.out.println("CPU card is: " + first_Cpu + " User Hands is : " + first_User + ". game is tied. time to war!!");
                warHand.add(first_User);
                warHand.add(first_Cpu);
                war = 1;
            }

            while(war == 1) {
                if(userHand.size() < 4 ) {
                    System.out.println("You don't have enough hands to war.");
                    for(int i =0; i < userHand.size(); i ++) {
                        Card notEnough = userHand.remove();
                        cpuHand.add(notEnough);
                    }
                    break;
                }
                else if(cpuHand.size() < 4 ) {
                    System.out.println("Cpu doesn't have enough cards to war.");
                    for(int i = 0; i < cpuHand.size(); i ++) {
                        Card notEnough = cpuHand.remove();
                        userHand.add(notEnough);
                    }
                    break;
                }
                for(int i = 0; i < 3 ; i++) {
                    Card userWar = userHand.remove();
                    warHand.add(userWar);
                    Card cpuWar = cpuHand.remove();
                    warHand.add(cpuWar);
                }
                Card userWarWinningCard = userHand.remove();         //Deciding cards
                Card cpuWarWinningCard = cpuHand.remove();					System.out.println("Your deciding card is "+ userWarWinningCard.value +", cpu card is "+cpuWarWinningCard.value);
                if(userWarWinningCard.value > cpuWarWinningCard.value) {
                    for(int i =0; i <= warHand.size(); i++ ) {
                        Card cpuWar = warHand.remove();
                        userHand.add(cpuWar);
                    }
                    System.out.println("You won the war! Now you have "+ userHand.size() +" cards");
                }
                else if(userWarWinningCard.value < cpuWarWinningCard.value) {
                    for(int i =0; i <= warHand.size(); i++ ) {
                        Card cpuWar = warHand.remove();
                        cpuHand.add(cpuWar);
                    }
                    System.out.println("You lost the war. You lose 5 cards to cpu. Now you have "+ userHand.size() +" cards");
                }

                war = 0;
            }

        }
        if (userHand.size() > cpuHand.size()) {
            System.out.println("game over. You won!");
        }
        else if(userHand.size() < cpuHand.size()) {
            System.out.println("game over, You lost.");
        }
        else
            System.out.println("tied. Something went wrong.");
    }
}
