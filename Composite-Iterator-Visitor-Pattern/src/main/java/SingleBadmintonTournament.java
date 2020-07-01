public class SingleBadmintonTournament extends Tournament {
    private Tournament tournamentLeftBracket;
    private Tournament tournamentRightBracket;

    public SingleBadmintonTournament(String name, Tournament tournamentLeftBracket, Tournament tournamentRightBracket) {
        this.name = name;
        this.tournamentLeftBracket = tournamentLeftBracket;
        this.tournamentRightBracket = tournamentRightBracket;
        player1 = tournamentLeftBracket.getWinner();
        player2 = tournamentRightBracket.getWinner();
    }

    public Tournament getTournamentLeftBracket() {
        return tournamentLeftBracket;
    }

    public Tournament getTournamentRightBracket() {
        return tournamentRightBracket;
    }

    @Override
    public Player getYoungestPlayer() {
        Player player1 = tournamentLeftBracket.getWinner();
        Player player2 = tournamentRightBracket.getWinner();
        return player1.getAge() < player2.getAge() ? player1 : player2;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
