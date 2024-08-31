package files.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/*
    * NOTE: In the exercise description, the FolderCabinet is mentioned but the class name in the listing is 'FileCabinet'
 */
class FileCabinet implements Cabinet {
    private final List<Folder> folders;

    public FileCabinet(List<Folder> folders) {
        this.folders = folders;
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
        List<Folder> result = new ArrayList<>();

        for(Folder folder : folders) {
            result.add(folder);
            handleMultiFolder(folder, result);
        }

        return result;
    }

    private void handleMultiFolder(Folder folder, List<Folder> result) {
        if(folder instanceof MultiFolder) {
            result.addAll(((MultiFolder) folder).getFolders());
        }
    }

}
