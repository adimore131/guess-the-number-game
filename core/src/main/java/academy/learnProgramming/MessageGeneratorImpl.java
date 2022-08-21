package academy.learnProgramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // == constants ==
    private static final Logger logger = LoggerFactory.getLogger(MessageGeneratorImpl.class);
    private final Game game;

    // == fields ==
//    @Autowired
//    private Game game;// it's always best practice to use constructor based dependency injection

    // == Constructor ==
//    @Autowired //we can also remove Autowired ann. as it's by default for only one dependency
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }


    // == public methods ==
    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() + " and " + game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon())
            return "You guessed it! \nThe number was " + game.getNumber();

        else if(game.isGameLost())
            return "You lost :( \nThe number was " + game.getNumber();

        else if(!game.isValidNumberRange())
            return "Invalid number range.";
        else if(game.getRemainingGuesses() == game.getGuessCount())
            return"What is your first guess?";
        else {
            String direction = "Lower";
            if(game.getGuess() < game.getNumber())
                direction = "Higher";
            return direction + "! You have " + game.getRemainingGuesses() +
                    " guesses left.";
        }
    }

    // == init ==
    //add a postConstruct method and log value of game to confirm autowiring
    @PostConstruct
    public void init(){
        logger.info("game = {}", game);
    }
}
