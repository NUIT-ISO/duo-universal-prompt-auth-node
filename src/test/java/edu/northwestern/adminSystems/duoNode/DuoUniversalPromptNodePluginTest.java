package edu.northwestern.adminSystems.duoNode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DuoUniversalPromptNodePluginTest {
    private DuoUniversalPromptNodePlugin plugin;

    public DuoUniversalPromptNodePluginTest() throws IOException {
        plugin = new DuoUniversalPromptNodePlugin();
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
