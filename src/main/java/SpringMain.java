import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
        }
        System.out.println();
//        try (ConfigurableApplicationContext appCtx1 = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
//            System.out.println("Bean definition names: " + Arrays.toString(appCtx1.getBeanDefinitionNames()));
//            MealRestController mealRestController = appCtx1.getBean(MealRestController.class);
//            mealRestController.create(new Meal(LocalDateTime.MAX, "email", 500, 3));
//        }
    }
}
