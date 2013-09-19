package chapter5.resources;

/**
 * TODO Write purpose of Type
 *
 * @author adahotre
 */
public class _4_TrickQuestion {
  public void processData( Object a, Object b) {
    synchronized (a) {
      synchronized (b) {
        System.out.println(a.toString() + b.toString());
      }
    }
  }
}
