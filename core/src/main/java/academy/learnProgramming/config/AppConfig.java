package academy.learnProgramming.config;

import academy.learnProgramming.MessageGenerator;
import academy.learnProgramming.MessageGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "academy.learnProgramming")
//we can import bean definitions from another config class
@Import(GameConfig.class)
public class AppConfig {
    //The main reason for this config class is to configure dependency injection from one location(file)
    //like using xml but through java code
    //This configuration classes often contains bean methods that represent bean definitions
    //The also instantiate and produce beans
    //for using bean methods we don't need componentScan and also component annotation

    // == bean definitions ==
//    @Bean
//    public NumberGenerator numberGenerator(){
//        return new NumberGeneratorImpl();
//    }
//    @Bean
//    public Game game(){
//        return new GameImpl();
//    }
    //Bean for messageGenerator
//    @Bean
//    public MessageGenerator messageGenerator(){
//        return new MessageGeneratorImpl();
//    }
}
