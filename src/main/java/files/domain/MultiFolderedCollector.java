package files.domain;

import java.util.ArrayList;
import java.util.List;

class MultiFolderedCollector {

    List<Folder> findAll(List<Folder> folders) {
        return findRecursively(folders, new ArrayList<>());
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
