package academy.learnProgramming.console;

import academy.learnProgramming.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
    //here we are trying to use project lombok which generates boiler plate code and
    //ultimately spice up the java code! which makes it more readable and concise.
//    private static final Logger log = LoggerFactory.getLogger(Main.class);//using @Slf4j directly :)

    //configuration for container: just a string value for xml file
//    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //create the context (container)
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        //this above line is defining actual IOC container or context to that

        //Using Application configuration
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //get number generator bean from the context (container)
//        NumberGenerator numberGenerator = (NumberGenerator) context.getBean("numberGeneratorImpl");
//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
        //This help us to inject dependency without the hassle of giving it an ID
        //It's good as long as we don't have multiple implementation of the interface
        //otherwise we'd need to use the qualifiers :)


        //call method next() to get a random number
//        int number = numberGenerator.next();

        //log generated number
//        log.info("number = {}", number);
        //internally slf4j is using something called formatter that will automatically replace {} with
        //arguments after comma i.e. placeholders

        //get the game bean from context
        //getBean method is overloaded so there are many ways to get bean
        //Game game = context.getBean("game", Game.class);
//        Game game = context.getBean(Game.class);

        //call reset method
//        game.reset();
        //*Instead of calling it manually we can actually configure it as a callback function
        //for bean life cycle callbacks as init method
        //best practice is to use annotation but still we can configure through xml:)



        //Get a messageGenerator bean from the context
//        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        //log some both method calls
//        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
//        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

        //close context (container) to avoid any memory resource leaks
        context.close();
    }
}
