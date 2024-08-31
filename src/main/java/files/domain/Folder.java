package files.domain;

public interface Folder {
    String getName();
    FolderSize getSize();
    boolean isSize(FolderSize size);
}
