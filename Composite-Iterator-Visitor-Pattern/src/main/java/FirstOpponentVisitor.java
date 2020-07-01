public class FirstOpponentVisitor implements Visitor {
    public FirstOpponentVisitor(Player opponent) {
        this.opponent = opponent;
    }

    private Player opponent;
    @Override
    public void visit(SingleBadminton singleBadminton) {
        if (opponent.getName().equals(singleBadminton.player1.getName())) {
            System.out.println(
                    "First opponent of "
                            + opponent.getName()
                            + " is "
                            + singleBadminton.player2.getName()
            );
        } else if (opponent.getName().equals(singleBadminton.player2.getName())) {
            System.out.println(
                    "First opponent of "
                            + opponent.getName()
                            + " is "
                            + singleBadminton.player1.getName()
            );
        }
    }
    @Override
    public void visit(SingleBadmintonTournament singleBadmintonTournament) {
        singleBadmintonTournament.getTournamentLeftBracket().accept(this);
        singleBadmintonTournament.getTournamentRightBracket().accept(this);
    }
}
