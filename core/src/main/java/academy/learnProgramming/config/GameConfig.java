package academy.learnProgramming.config;

import academy.learnProgramming.GuessCount;
import academy.learnProgramming.MaxNumber;
import academy.learnProgramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == fields ==
    @Value("${game.maxNumber:20}")//this annotation is used at field or constructor level
    private int maxNumber;
    @Value("${game.guessCount:5}")//placeholder values are there in case property is not set
    private int guessCount;
    @Value("${game.minNumber:5}")
    private int minNumber;

    //== bean Methods ==
    @Bean
    @MaxNumber//this annotation is used as qualifier for this particular bean definition
    //it works even if the bean method name is changed unlike @Bean annotation
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

}
