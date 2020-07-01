import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public abstract class Tournament implements Iterable, Visitable {
    String name;
    Player player1;
    Player player2;
    Player winner;

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println(
                name
                        + ": "
                        + player1.getName()
                        + " vs "
                        + player2.getName()
        );
    }

    public void dfsDisplay() {
        System.out.println(">>>DFS<<<");
        Stack<Tournament> stack = new Stack<Tournament>();
        stack.push(this);

        while (!stack.isEmpty()) {
            Tournament current = stack.pop();
            current.display();
            if (current.getClass().getSimpleName().equals("SingleBadmintonTournament")) {
                stack.push(((SingleBadmintonTournament) current).getTournamentRightBracket());
                stack.push(((SingleBadmintonTournament) current).getTournamentLeftBracket());
            }
        }
    }

    public void bfsDisplay() {
        System.out.println(">>>BFS<<<");
        Queue<Tournament> queue = new LinkedList<Tournament>();
        queue.add(this);

        while (!queue.isEmpty()) {
            Tournament current = queue.poll();
            current.display();
            if (current.getClass().getSimpleName().equals("SingleBadmintonTournament")) {
                queue.add(((SingleBadmintonTournament) current).getTournamentLeftBracket());
                queue.add(((SingleBadmintonTournament) current).getTournamentRightBracket());
            }
        }
    }

    public abstract Player getYoungestPlayer();

    public Player firstOppenent(Player player) {
        Queue<Tournament> queue = new LinkedList<>();
        queue.add(this);
        Player opponent = null;
        while (!queue.isEmpty()) {
            Tournament tournament = queue.poll();
            if (tournament.getClass().getSimpleName().equals("SingleBadmintonTournament")) {
                Tournament tournamentLeft = ((SingleBadmintonTournament) tournament).getTournamentLeftBracket();
                Tournament tournamentRight = ((SingleBadmintonTournament) tournament).getTournamentRightBracket();
                if(tournamentLeft.getWinner().getName().equals(player.getName())){
                    opponent = tournamentLeft.firstOppenent(player);
                    break;
                } else if(tournamentRight.getWinner().getName().equals(player.getName())){
                    opponent = tournamentRight.firstOppenent(player);
                    break;
                } else {
                    System.out.println("AAA");
                    queue.add(tournamentLeft);
                    queue.add(tournamentRight);
                }
            } else {
                if(!tournament.player1.getName().equals(player.getName()) && !tournament.player2.getName().equals(player.getName())){
                    continue;
                } else {
                    opponent = player1.getName().equals(player.getName()) ? player2 : player1;
                    break;
                }
            }
        }
        return opponent;
    }

    @Override
    public Iterator getIterator(String type) {
        Iterator iterator = null;
        if(type.equals("BFS")){
            iterator = new BFSIterator(this);
        } else if(type.equals("DFS")){
            iterator = new DFSIterator(this);
        }
        return iterator;
    }
}
class BFSIterator implements Iterator{
    private Tournament tournament;
    private Queue<Tournament> queue;
    public BFSIterator(Tournament tournament) {
        this.tournament = tournament;
        queue = new LinkedList<>();
        queue.add(this.tournament);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Iterable next() {
        Tournament tournament = queue.poll();
        if(tournament.getClass().getSimpleName().equals("SingleBadmintonTournament")){
            queue.add(((SingleBadmintonTournament)tournament).getTournamentLeftBracket());
            queue.add(((SingleBadmintonTournament)tournament).getTournamentRightBracket());
        }
        return tournament;
    }
}

class DFSIterator implements Iterator{
    private Tournament tournament;
    private Stack<Tournament> stack;

    public DFSIterator(Tournament tournament) {
        this.tournament = tournament;
        stack = new Stack<>();
        stack.push(this.tournament);
    }


    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Iterable next() {
        Tournament tournament = stack.pop();
        if(tournament.getClass().getSimpleName().equals("SingleBadmintonTournament")){
            stack.push(((SingleBadmintonTournament)tournament).getTournamentRightBracket());
            stack.push(((SingleBadmintonTournament)tournament).getTournamentLeftBracket());
        }
        return tournament;
    }
}
