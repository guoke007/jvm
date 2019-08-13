package com.jvm.oom;

/**
 * VM Args：-Xss2M （这时候不妨设大些）
 * @author zzm
 */
public class JavaVMStackOOM {
 
       private void dontStop() {
              while (true) {
                     System.out.println("-------------");
              }
       }
 
       public void stackLeakByThread() {
              while (true) {
                     Thread thread = new Thread(new Runnable() {
                            public void run() {
                                   dontStop();
                            }
                     });
                     thread.start();
              }
       }
 
       public static void main(String[] args) throws Throwable {
              JavaVMStackOOM oom = new JavaVMStackOOM();
              oom.stackLeakByThread();
       }
}