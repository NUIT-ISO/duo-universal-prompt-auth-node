package edu.northwestern.adminSystems.duoNode;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import org.forgerock.openam.auth.node.api.AbstractNodeAmPlugin;
import org.forgerock.openam.auth.node.api.Node;

public class DuoUniversalPromptNodePlugin extends AbstractNodeAmPlugin {
    private String currentVersion;

    public DuoUniversalPromptNodePlugin() throws IOException {
        Properties props = new Properties();
        props.load(this.getClass().getClassLoader().getResourceAsStream("DuoNode.properties"));

        currentVersion = props.getProperty("pluginVersion");
    }

    @Override
    protected Map<String, Iterable<? extends Class<? extends Node>>> getNodesByVersion() {
        return Collections.singletonMap(currentVersion,
                Collections.singletonList(DuoUniversalPromptNode.class));
    }

    @Override
    public String getPluginVersion() {
        return currentVersion;
    }
}
