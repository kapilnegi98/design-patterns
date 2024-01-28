package designpatterns.behavioral.state.musicplayer;

/**
 * @author Kapil Negi
 */
public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        //create dummy objects and dry run
        System.out.println(player.getState());
        System.out.println(player.getState().onPlay());
        System.out.println(player.getState().onNext());
        System.out.println(player.getState().onPrevious());
        System.out.println(player.getState());
        System.out.println(player.getState().onLock());
        System.out.println(player.getState().onPlay());
    }
}
