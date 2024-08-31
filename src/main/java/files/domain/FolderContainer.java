package files.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record FolderContainer(String name,
                              FolderSize size,
                              List<Folder> children) implements MultiFolder {

    @Override
    public List<Folder> getFolders() {
        return findRecursively(this.children, new ArrayList<>());
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
    private List<Folder> findRecursively(List<Folder> folders, List<Folder> collected) {
        for(Folder folder : folders) {
            if(folder instanceof MultiFolder) {
                processMultiFolder(collected, (MultiFolder) folder);
            }
            collected.add(folder);
        }

        return collected;
    }

    private void processMultiFolder(List<Folder> collected, MultiFolder folder) {
        collected.addAll(folder.getFolders());
    }

}
