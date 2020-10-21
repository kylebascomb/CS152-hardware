package app;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import view.*;
import model.*;

/**
* Hardware application.
*
*/
public class hardware
{
  public static void main (String[] args)
  {
    view = View.wait(queue);
    model = new Model();
    
    Controller hardware = new Controller(view, model, queue);
    try
    {
      hardware.mainLoop();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    queue.clear()
  }
  private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
  private static View view;
  private static Model model;
}
