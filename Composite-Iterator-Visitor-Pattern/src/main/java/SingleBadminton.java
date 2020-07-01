public class SingleBadminton extends Tournament {
    public SingleBadminton(String name, Player player1, Player player2) {
        this.name = name;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public Player getYoungestPlayer() {
        return player1.getAge() < player2.getAge() ? player1 : player2;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
