package files.domain;

import java.util.List;

public class FolderFactory {

    public static Folder basic(String name, FolderSize size) {
        return new BasicFolder(name, size);
    }

    public static MultiFolder multiFolder(String name, FolderSize size, List<Folder> children) {
        return new FolderContainer(name, size, children);
    }

}
