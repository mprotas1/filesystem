package files.domain;

import java.util.Objects;

record BasicFolder(String name, FolderSize size) implements Folder {

    @Override
    public String getName() {
        return name;
    }

    @Override
    public FolderSize getSize() {
        return size;
    }

    @Override
    public boolean isSize(FolderSize size) {
        return Objects.equals(this.size, size);
    }

}
