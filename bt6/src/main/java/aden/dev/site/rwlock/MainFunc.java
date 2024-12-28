package aden.dev.site.rwlock;

public class MainFunc {
    public static void main(String[] args) {
        ReadWriteUnsafe rwu = new ReadWriteUnsafe();
        rwu.run();
    }
}
