package hw1.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.annotation.Annotation;

@Aspect
public class FuelExceptionAspect {


    @Pointcut("execution(public * hw1.mvc+.*())")
    public void callAtBusinessMethods() {}

    @Pointcut("@annotation(hw1.aspect.FuelExceptionHandle)")
    public void callAtAnnotatedMethods() {}

    @AfterThrowing("callAtAnnotatedMethods()")
    public void sendMessage() {
        try {
            throw new Exception();
        } catch(Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }
}

