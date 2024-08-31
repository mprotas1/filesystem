package files.domain;

import java.util.List;

public interface MultiFolder extends Folder {
    List<Folder> getFolders();
}