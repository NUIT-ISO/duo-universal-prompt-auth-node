# Duo Universal Prompt Authentication Node for OpenAM
This is an OpenAM authentication node using the Duo v4 SDK, which gives you their Universal Prompt instead of the iframe.

## Installation
1. Copy the jar file to the WEB-INF/lib/ folder where OpenAM is deployed.
2. Restart OpenAM to load the plugin.
3. Create or edit an authentication tree. Add the Duo Universal Prompt node to your tree.
4. Configure it. You will need to consult Duo's documentation on enabling Universal Prompt if you are migrating from the old iframe.

![Node configuration](./images/config.png)

The client ID, client secret, and API hostname can be found in your Duo console.

The failure mode indicates how the node should handle Duo being unavailable. Prior to redirecting users to Duo's universal prompt, a health check API endpoint is called. If the response is not positive, Duo is considered unreachable. The closed failure mode errors out, preventing authentication from proceeding. The open failure mode will bypass Duo.

The OpenAM callback URL is where Duo should redirect users to after they have finished with the Universal Prompt. This should be your OpenAM URL and include the realm you are authenticating to, e.g. `https://my-server.com/am/XUI/?realm=/my-auth-realm`.

## Development
You will need a ForgeRock Backstage account attached to an OpenAM subscription in order to download the dependencies. [Create an account](https://backstage.forgerock.com/) & then contact your OpenAM administrators for help with that.

Once you are part of a subscription, visit [their article on accessing their private Maven repositories](https://backstage.forgerock.com/knowledge/kb/article/a74096897) for instructions on configuring your Maven install with credentials. Notably, [their generated ~/.m2/settings.xml](https://maven.forgerock.org/artifactory/private-releases/settings.xml) must be downloaded & put in place.

From there, you can load the project up. Maven will retrieve all necessary dependencies.

## Releasing
To prepare a release, update the `pom.xml` file and bump the version. Then, create a tag prefixed with a `v`. There is a GitHub Action to release the package, which will convert the tag into a release and attach the jar file.

```
# Edit the pom.xml and bump the version before proceeding!
git tag v1.0.1
git push --tags
```

## Contributing
If you'd like to contribute to the project, you are welcome to submit a pull request!

