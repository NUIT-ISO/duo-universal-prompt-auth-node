package edu.northwestern.adminSystems.duoNode;

import static org.junit.jupiter.api.Assertions.*;

import edu.northwestern.adminSystems.duoNode.DuoNodePlugin;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DuoNodePluginTest {
    private DuoNodePlugin plugin;

    public DuoNodePluginTest() throws IOException {
        plugin = new DuoNodePlugin();
    }

    @Test
    void currentVersion() {
        assertNotEquals(null, plugin.getPluginVersion());
    }

    @Test
    void getNodesByVersion() {
        assertEquals(1, plugin.getNodesByVersion().size());
    }
}
