package aden.dev.site.rwlock;

public class MainFunc {
    public static void main(String[] args) {
        // Unsafe demo
//        ReadWriteUnsafe rwu = new ReadWriteUnsafe();
//        rwu.run();

//        // Safe demo
       ReadWriteSafe readWriteSafe = new ReadWriteSafe();
       readWriteSafe.run();
       // Should change to using synchronize inside of sharingResource(get, set)

        // 2 thread read with reentrant lock
        // Read2Threads read2Threads = new Read2Threads();
        // read2Threads.run();
    }
}
