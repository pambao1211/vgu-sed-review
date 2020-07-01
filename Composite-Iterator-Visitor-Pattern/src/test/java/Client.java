import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Client {
    @Test
    public void bfsDisplay(){
        HashMap<String, Tournament> tournaments = generateTournaments();
        tournaments.get("final").bfsDisplay();
    }

    @Test
    public void dfsDisplay(){
        HashMap<String, Tournament> tournaments = generateTournaments();
        tournaments.get("final").dfsDisplay();
    }

    @Test
    public void getYoungestPlayer(){
        HashMap<String, Tournament> tournaments = generateTournaments();
        Player player = tournaments.get("final").getYoungestPlayer();
        System.out.println("Youngest participant");
        player.display();

    }
    @Test
    public void fistOpponent(){
        HashMap<String, Tournament> tournaments = generateTournaments();
        Tournament finalMatch = tournaments.get("final");
        System.out.println(finalMatch.firstOppenent(new Player("Player2", 30)).getName());
    }

    @Test
    public void bFSIterator(){
        System.out.println("BFS Iterator");
        HashMap<String, Tournament> tournaments = generateTournaments();
        Tournament finalMatch = tournaments.get("final");
        Iterator iterator = finalMatch.getIterator("BFS");

        while(iterator.hasNext()){
            ((Tournament) iterator.next()).display();
        }
    }

    @Test
    public void dFSIterator(){
        System.out.println("DFS Iterator");
        HashMap<String, Tournament> tournaments = generateTournaments();
        Tournament finalMatch = tournaments.get("final");
        Iterator iterator = finalMatch.getIterator("DFS");

        while(iterator.hasNext()){
            ((Tournament)iterator.next()).display();
        }
    }

    @Test
    public void firstOpponentIterator(){
        HashMap<String, Tournament> tournaments = generateTournaments();
        Tournament finalMatch = tournaments.get("final");
        Iterator iterator = finalMatch.getIterator("BFS");
        Player oppenent = new Player("Player6", 30);
        Player firstOpponent = null;
        while(iterator.hasNext()){
            Tournament current = (Tournament) iterator.next();
            if(current.getClass().getSimpleName().equals("SingleBadmintonTournament")){
                if(((SingleBadmintonTournament)current).getTournamentLeftBracket().getWinner().getName().equals(oppenent.getName())){
                    iterator = ((SingleBadmintonTournament)current).getTournamentLeftBracket().getIterator("DFS");
                } else if(((SingleBadmintonTournament)current).getTournamentRightBracket().getWinner().getName().equals(oppenent.getName())){
                    iterator = (((SingleBadmintonTournament)current).getTournamentRightBracket().getIterator("DFS"));
                }
            } else {
                if(!(current.player1.getName().equals(oppenent.getName()) || current.player2.getName().equals(oppenent.getName()) )){
                    continue;
                } else {
                    firstOpponent = current.player1.getName().equals(oppenent.getName()) ? current.player2 : current.player1;
                }
            }
        }

        System.out.println(
                "First Opponent of "
                + oppenent.getName()
                + " is "
                + firstOpponent.getName()
        );

    }

    @Test
    public void youngestParticipantIterator(){
        HashMap<String, Tournament> tournaments = generateTournaments();
        Tournament finalMatch = tournaments.get("final");
        Iterator iterator = finalMatch.getIterator("DFS");
        Player youngestPlayer = null;
        while(iterator.hasNext()){
            Tournament current = (Tournament) iterator.next();
            if(current.getClass().getSimpleName().equals("SingleBadminton")){
                if(youngestPlayer != null){
                    if(youngestPlayer.getAge() > current.player1.getAge()){
                        youngestPlayer = current.player1;
                    }
                    if(youngestPlayer.getAge() > current.player2.getAge()){
                        youngestPlayer = current.player2;
                    }
                } else {
                    youngestPlayer = current.player1.getAge() > current.player2.getAge() ? current.player1 : current.player2;
                }
            }
        }
        System.out.println("Youngest player is: ");
        youngestPlayer.display();

    }
    @Test
    public void displayMatchesWithLevel(){
        HashMap<String, Tournament> tournaments = generateTournaments();
        Tournament finalMatch = tournaments.get("final");
        Visitor visitor = new DisplayMatchesWithLevel();
        finalMatch.accept(visitor);
    }
    @Test
    public void firstOpponentVisitor(){
        HashMap<String, Tournament> tournaments = generateTournaments();
        Tournament finalMatch = tournaments.get("final");
        Visitor visitor = new FirstOpponentVisitor(new Player("Player5", 10));
        finalMatch.accept(visitor);
    }
    public static ArrayList<Player> generatePlayers(){
        ArrayList<Player> players = new ArrayList<Player>();

        players.add(new Player("Player1" , 15));
        players.add(new Player("Player2" , 20));
        players.add(new Player("Player3" , 14));
        players.add(new Player("Player4" , 21));
        players.add(new Player("Player5" , 32));
        players.add(new Player("Player6" , 25));
        players.add(new Player("Player7" , 35));
        players.add(new Player("Player8" , 40));

        return players;
    }

    public static HashMap<String, Tournament> generateTournaments(){
        HashMap<String, Tournament> tournaments = new HashMap<String, Tournament>();
        ArrayList<Player> players = generatePlayers();

        Tournament quarter1 = new SingleBadminton("quarter1", players.get(0), players.get(1));
        Tournament quarter2 = new SingleBadminton("quarter2", players.get(2), players.get(3));
        Tournament quarter3 = new SingleBadminton("quarter3", players.get(4), players.get(5));
        Tournament quarter4 = new SingleBadminton("quarter4", players.get(6), players.get(7));

        quarter1.setWinner(players.get(0));
        quarter2.setWinner(players.get(2));
        quarter3.setWinner(players.get(4));
        quarter4.setWinner(players.get(6));

        Tournament semi1 = new SingleBadmintonTournament("semi1", quarter1, quarter2);
        Tournament semi2 = new SingleBadmintonTournament("semi2", quarter3, quarter4);
        semi1.setWinner(players.get(0));
        semi2.setWinner(players.get(4));

        Tournament finalMatch = new SingleBadmintonTournament("final", semi1, semi2);

        tournaments.put(quarter1.getName(), quarter1);
        tournaments.put(quarter2.getName(), quarter2);
        tournaments.put(quarter3.getName(), quarter3);
        tournaments.put(quarter4.getName(), quarter4);
        tournaments.put(semi1.getName(), semi1);
        tournaments.put(semi2.getName(), semi2);
        tournaments.put(finalMatch.getName(), finalMatch);

        return tournaments;
    }
}