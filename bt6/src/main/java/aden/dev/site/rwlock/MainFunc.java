package aden.dev.site.rwlock;

public class MainFunc {
    public static void main(String[] args) {
        // Unsafe demo
//        ReadWriteUnsafe rwu = new ReadWriteUnsafe();
//        rwu.run();

        // Safe demo
        ReadWriteSafe readWriteSafe = new ReadWriteSafe();
        readWriteSafe.run();
    }
}
