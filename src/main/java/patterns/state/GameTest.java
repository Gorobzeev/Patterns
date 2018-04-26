package patterns.state;

public class GameTest {

    public static void main(String[] args) {

    }

    class Game{

        public Game() {
        }

        private State state;
        private int [][] desk = new int [3][3];
        private String player1 = "x";
        private String player2 = "o";

        public void changeState(State state){
            this.state = state;
        }

        public State getState(){
            return state;
        }
    }

    abstract class State {

        public Game game;

        public State(Game game) {
            this.game = game;
        }

        public abstract String startGame();
        public abstract String stepPlayer1();
        public abstract String stepPlayer2();
        public abstract String winPlayer1();
        public abstract String winPlayer2();
        public abstract String draw();
    }

    class StartState extends State{

        public StartState(Game game) {
            super(game);
        }

        @Override
        public String startGame() {
            return null;
        }

        @Override
        public String stepPlayer1() {
            return null;
        }

        @Override
        public String stepPlayer2() {
            return null;
        }

        @Override
        public String winPlayer1() {
            return null;
        }

        @Override
        public String winPlayer2() {
            return null;
        }

        @Override
        public String draw() {
            return null;
        }
    }
}
