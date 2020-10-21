package controller;

public interface Valve
{
  /**
  * Performs certain action in response to message.
  *
  */
  public ValveResponse execute(Message message);
  
  public enum ValveResponse
  {
    MISS,
    EXECUTED,
    FINISH
  };  
}
