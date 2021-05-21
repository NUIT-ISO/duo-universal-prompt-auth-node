import static org.junit.jupiter.api.Assertions.*;
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
