package edu.northwestern.adminSystems.duoNode;

import com.google.inject.assistedinject.Assisted;
import org.apache.commons.lang.NotImplementedException;
import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.AbstractDecisionNode;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Node.Metadata(
        outcomeProvider = AbstractDecisionNode.OutcomeProvider.class,
        configClass = DuoNode.Config.class, tags = {"mfa", "multi-factor authentication"}
)
public class DuoNode extends AbstractDecisionNode {
    private final Logger logger = LoggerFactory.getLogger("amAuth");
    private String clientId;
    private String clientSecret;
    private String apiHostName;
    private String failureMode;

    @Inject
    public DuoNode(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        clientId = config.clientId();
        clientSecret = config.clientSecret();
        apiHostName = config.apiHostName();
        failureMode = config.failureMode();

        // @TODO remove me once this is shown to work. but may be helpful for the 1st time we try this node out.
        logger.debug(
            "Initialized Duo node with the following config: clientID = {}, secret = {} characters, API hostname = {}, and failure mode = {}",
            clientId,
            clientSecret.length(),
            apiHostName,
            failureMode
        );
    }

    @Override
    public Action process(TreeContext context) throws NodeProcessException {
        throw new NotImplementedException();
    }

    /**
     * Configuration for the Duo node.
     */
    public interface Config {
        public enum FailureModes {
            CLOSED,
            OPEN,
        }

        @Attribute(name = "Duo Client ID (ikey)", order = 100)
        default String clientId() {
            return "";
        }

        @Attribute(name = "Duo Client Secret (skey)", order = 200)
        default String clientSecret() {
            return "";
        }

        @Attribute(name = "Duo API Hostname", order = 300)
        default String apiHostName() {
            return "";
        }

        @Attribute(name = "Failure Mode When Duo is Down", order = 400) // @TODO add choiceValuesClass key & restrict this to CLOSED/OPEN
        default String failureMode() {
            return FailureModes.CLOSED.toString();
        }

    }

}
