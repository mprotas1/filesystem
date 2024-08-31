package files.domain;

import java.util.List;
import java.util.Objects;

public record FolderContainer(String name,
                              FolderSize size,
                              List<Folder> children) implements MultiFolder {

    @Override
    public List<Folder> getFolders() {
        return children;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public FolderSize getSize() {
        return this.size;
    }

    @Override
    public boolean isSize(FolderSize size) {
        return Objects.equals(this.size, size);
    }

}
