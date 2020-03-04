package geektime.spring.resilience4jcircuitbreakerdemo.model;

public enum OrderState {
    INIT, PAID, BREWING, BREWED, TAKEN, CANCELLED
}