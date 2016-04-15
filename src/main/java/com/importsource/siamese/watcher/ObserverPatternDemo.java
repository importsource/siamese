package com.importsource.siamese.watcher;


public class ObserverPatternDemo {
   public static void main(String[] args) {
      WatchedEvent subject = new WatchedEvent();
      subject.attach(new AppWatcher());
      System.out.println("First state change: 15");	
      //subject.setState(15);
      System.out.println("Second state change: 10");	
     // subject.setState(10);
   }
}