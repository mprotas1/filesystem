package files.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/*
    * NOTE: In the exercise description, the FolderCabinet is mentioned but the class name in the listing is 'FileCabinet'
 */
class FileCabinet implements Cabinet {
    private final List<Folder> folders;
    private final MultiFolderedCollector folderedCollector;

    public FileCabinet(List<Folder> folders) {
        this.folders = folders;
        this.folderedCollector = new MultiFolderedCollector();
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return getAllFolders().stream()
                .filter(folder -> Objects.equals(folder.getName(), name))
                .findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(FolderSize size) {
        return getAllFolders().stream()
                .filter(folder -> folder.isSize(size))
                .toList();
    }

    @Override
    public int count() {
        return getAllFolders().size();
    }

    private List<Folder> getAllFolders() {
        return folderedCollector.findAll(folders);
    }

}
