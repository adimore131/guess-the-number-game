package academy.learnProgramming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator{

    // == fields ==
    private final Random random = new Random();

//    @Autowired //instead of adding Autowired to field level, the best practice is to add it on Constructor level
//    @MaxNumber//also add this annotation to constructor
    private final int maxNumber;

//    @Autowired
//    @MinNumber
    private final int minNumber;

    // == Constructor ==
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    //== Public Methods ==
    @Override
    //logic for getting random number between min(exclusive) and max(inclusive)
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }

}
