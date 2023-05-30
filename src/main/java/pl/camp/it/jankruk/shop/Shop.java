package pl.camp.it.jankruk.shop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.camp.it.jankruk.shop.configuration.AppConfiguration;
import pl.camp.it.jankruk.shop.core.Core;

public class Shop {
    public static void main(String[] args) {
        ApplicationContext box = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Core core = box.getBean(Core.class);
        core.start();
    }
}
