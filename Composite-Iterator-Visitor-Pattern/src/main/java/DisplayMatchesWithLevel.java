public class DisplayMatchesWithLevel implements Visitor {
    int level = 1;
    @Override
    public void visit(SingleBadminton singleBadminton) {
        System.out.printf("Level%d: ", level);
        singleBadminton.display();
    }

    @Override
    public void visit(SingleBadmintonTournament singleBadmintonTournament) {
        System.out.printf("Level%d: ", level);
        singleBadmintonTournament.display();
        level++;
        singleBadmintonTournament.getTournamentLeftBracket().accept(this);
        singleBadmintonTournament.getTournamentRightBracket().accept(this);
        level--;
    }
}
