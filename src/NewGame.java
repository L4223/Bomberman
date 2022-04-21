import processing.core.PApplet;

public class NewGame {

    private int numberOfPlayers;
    private Character bomberman[];
    private CharacterController characterController[];
    private CharacterView characterView;
    private Matchfield matchfield;
    private MatchfieldController matchfieldController;
    private MatchfieldView matchfieldView;
    private PApplet pApplet;

    public NewGame (int numberOfPlayers, PApplet pApplet) {
        this.numberOfPlayers = numberOfPlayers;
        this.pApplet = pApplet;
        setBomberman();
        setMatchfield();
        setCharacterView();
        setCharacterController();
        setMatchfieldView();
        setMatchfieldController();
    }



    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    private void setBomberman () {
        bomberman = new Character[getNumberOfPlayers()];
    }

    private void setMatchfield () {
        matchfield = new Matchfield(getpApplet());
    }

    private void setCharacterController () {
       characterController = new CharacterController[getNumberOfPlayers()];
    }
    private void setCharacterView () {
        characterView = new CharacterView();
    }
    private void setMatchfieldController () {
        matchfieldController =  new MatchfieldController(getMatchfield(), getMatchfieldView(), getpApplet());
    }
    private void setMatchfieldView () {
        matchfieldView = new MatchfieldView();
    }


    public Matchfield getMatchfield() {
        return matchfield;
    }

    public MatchfieldView getMatchfieldView() {
        return matchfieldView;
    }

    public PApplet getpApplet() {
        return pApplet;
    }

    public Character[] getBomberman() {
        return bomberman;
    }

    public CharacterController getCharacterController(int playernumber) {
        return characterController[playernumber];
    }

    public CharacterView getCharacterView() {
        return characterView;
    }

    public MatchfieldController getMatchfieldController() {
        return matchfieldController;
    }

    public void newGame () {
        if (numberOfPlayers >= 0) {
            try {


                for (int i = 0; i < numberOfPlayers; i++) {
                    bomberman[i] = new Character(i, matchfield, pApplet);
                    characterController[i] = new CharacterController(bomberman[i], characterView, pApplet);
                }
            } catch (Exception exception) {
                pApplet.println("Fehler! Zwischen 1 - 4 Spieler zugelassen");
                numberOfPlayers = 0;
            }
        } else {
            PApplet.println("Fehler! Spieleranzahl muss positiv sein");
            numberOfPlayers = 0;
            newGame();
        }
    }
}
