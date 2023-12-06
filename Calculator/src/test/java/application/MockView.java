package application;

import java.util.function.Consumer;

public class MockView implements ViewInterface {

  private String expression;

  @Override
  public void addCalculateObserver(Runnable f) {
    // No need to store the calculate observer in the mock implementation
  }

  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    // No need to store the type observer in the mock implementation
  }

  @Override
  public String getExpression() {
    return expression;
  }

  @Override
  public void setAnswer(String a) {
    // No need to store the answer in the mock implementation
  }

  @Override
  public void startView() {
    // Optional: Initialization logic for starting the view
  }
}
