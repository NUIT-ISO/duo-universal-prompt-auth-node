# Duo Universal Prompt Authentication Node for OpenAM
This is an OpenAM authentication node using the Duo v4 SDK, which gives you their Universal Prompt instead of the iframe.

## Development
You will need a ForgeRock Backstage account attached to an OpenAM subscription in order to download the dependencies. [Create an account](https://backstage.forgerock.com/) & then contact your OpenAM administrators for help with that.

Once you are part of a subscription, visit [their article on accessing their private Maven repositories](https://backstage.forgerock.com/knowledge/kb/article/a74096897) for instructions on configuring your Maven install with credentials. Notably, [their generated ~/.m2/settings.xml](https://maven.forgerock.org/repo/private-releases/settings.xml) must be downloaded & put in place.

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

