package academy.learnProgramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Slf4j
@Getter//create getter for each field except manually exempted
@Component
public class GameImpl implements Game {
    // == constants ==
//    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);//using @Slf4j


    // == fields ==
//    @Autowired
    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;

//    @Autowired
//    @GuessCount
    private final int guessCount;
    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Setter//we only need setter for guess
    private int guess;

    // == constructor ==
    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    //== init ==
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
//        log.info("The number is {}", number);
    }

    // == destroy ==
//    @PreDestroy
//    public void preDestroy() {
//        log.info("In Game preDestroy()");
//    }


    // == public methods ==

    @Override
    public void check() {
        checkValidNumberRange();
        if(validNumberRange) {
            if(guess > number) {
                biggest = guess - 1;
            }
            if(guess < number) {
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

//    @Override
//    public boolean isValidNumberRange() {
//        return validNumberRange;
//    }
    //as it is considered as getter for validNumberRange and it's already generated using lombok

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==
    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest && guess <= biggest);
    }

}
