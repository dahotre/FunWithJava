package chapter5.resources;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO Write purpose of Type
 *
 * @author adahotre
 */
public class _5_UsingLock {


  public static void main(String[] args) {
    Locking java5StyleLocking = new Locking();
    java5StyleLocking.doOp1();

    Locker.runLocked(new ReentrantLock(), () -> System.out.println("Working..") );
  }

  static class Locking {
    Lock lock = new ReentrantLock(); //or mock

    protected void setLock(final Lock mock) {
      lock = mock;
    }

    public void doOp1() { lock.lock();
      try {
        System.out.println("Doing old style stuff..");
        //...critical code...
      }
      finally {
        lock.unlock();
      }
    }
  }


  static class Locker {

    public static void runLocked(Lock lock, Runnable block) {
      lock.lock();
      try {
        block.run();
      } finally {
        lock.unlock();
      }
    }
  }

}
