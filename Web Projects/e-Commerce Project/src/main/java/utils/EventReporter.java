package utils;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.Method;

public class EventReporter implements WebDriverListener
{
    @Override
    public void beforeAnyCall(Object target, Method method, Object[] args) {
        WebDriverListener.super.beforeAnyCall(target, method, args);
    }
}
