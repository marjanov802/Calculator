package application;

import java.util.function.Consumer;


public class MockView implements ViewInterface {

  private String expression;
  private String answer;
  private Consumer<OpType> typeObserver;
  private Runnable calculateObserver;

  @Override
  public void addCalculateObserver(Runnable f) {
    this.calculateObserver = f;
  }

  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    this.typeObserver = c;
  }

  @Override
  public String getExpression() {
    return expression;
  }

  @Override
  public void setAnswer(String a) {
    this.answer = a;
  }

  @Override
  public void startView() {
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  public String getAnswer() {
    return answer;
  }

  public void calculate() {
    if (calculateObserver != null) {
      calculateObserver.run();
    }
  }

  public void changeExpressionType(OpType type) {
    if (typeObserver != null) {
      typeObserver.accept(type);
    }
  }

  public OpType getCurrentOpType() {
    return null;
  }
  
  public boolean isCalculateObserverRegistered() {
    return calculateObserver != null;
  }

  public boolean isTypeObserverRegistered() {
    return typeObserver != null;
  }
  
}
