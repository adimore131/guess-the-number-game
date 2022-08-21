package academy.learnProgramming.console;

import academy.learnProgramming.Game;
import academy.learnProgramming.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // == fields ==
//    @Autowired
    private final Game game;

//    @Autowired
    private final MessageGenerator messageGenerator;

    // == Constructor ==
    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }


    // == Event listeners using implementation ==

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //this is a event listener called when application context is refreshed or ready to use ie initialized
        //meaning all the beans are loaded, singleton beans are instantiated and preloaded etc.
        //so basically when application context is ready to use it's gonna fire this event for us automatically!

        log.info("Container ready to use.");
    }

    // == Event listeners using annotation ==

    //But we can use annotations for event listener and avoid the need of implementing the interface
    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent){
//        log.info("start() --> container ready to use");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = Integer.parseInt(scanner.nextLine());
            game.setGuess(guess);
            game.check();

            if(game.isGameLost() || game.isGameWon()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n ?");
                String playAgain = scanner.nextLine().trim();
                if(!playAgain.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }
        }
        scanner.close();
    }
    //here we can name method anything but the parameters are mandatory but there is alternate way
//    @EventListener(ContextRefreshedEvent.class)
//    private void start1(){
//        log.info("start() --> container ready to use");
//    }
}
