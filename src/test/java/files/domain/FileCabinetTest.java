package files.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileCabinetTest {
    private Cabinet fileCabinet;

    @BeforeEach
    void setUp() {
        Folder firstFolder = FolderFactory.basic("First folder", FolderSize.SMALL);
        Folder secondFolder = FolderFactory.basic("Second folder", FolderSize.MEDIUM);

        // Create a multi-folder
        Folder firstChild = FolderFactory.basic("First child", FolderSize.SMALL);
        Folder secondChild = FolderFactory.basic("Second child", FolderSize.MEDIUM);
        Folder parentFolder = FolderFactory.multiFolder("Parent folder", FolderSize.LARGE, List.of(firstChild, secondChild));

        List<Folder> folders = List.of(firstFolder, secondFolder, parentFolder);
        fileCabinet = new FileCabinet(folders);
    }

    @Test
    void shouldFindFolderByName() {
        String name = "First folder";
        Optional<Folder> folderByName = fileCabinet.findFolderByName(name);
        assertTrue(folderByName.isPresent());
    }

    @Test
    void shouldNotFindFolderForNonExistingName() {
        String name = "NON EXISTING NAME";
        Optional<Folder> folderByName = fileCabinet.findFolderByName(name);
        assertTrue(folderByName.isEmpty());
    }

    @Test
    void shouldFindAllFoldersBySize() {
        FolderSize size = FolderSize.SMALL;
        List<Folder> foldersBySize = fileCabinet.findFoldersBySize(size);
        assertEquals(2, foldersBySize.size());
    }

    @Test
    void shouldCountAllFolders() {
        assertEquals(5, fileCabinet.count());
    }

}
