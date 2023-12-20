## OpenSearch API Plugin

A plugin that returns the OpenSearch API in the OpenAPI format.

### Build

Build a distribution.

```sh
./gradlew assemble
```

This produces `build/distributions/opensearch-api.zip`.

### Install

Check out OpenSearch code, run it once with `./gradlew run`.

Install the plugin, you may need to adjust `darwin-arm64-tar` below to your platform, and use the location of your plugin zip.

```sh
$ ./distribution/archives/darwin-arm64-tar/build/install/opensearch-3.0.0-SNAPSHOT/bin/opensearch-plugin install file:///Users/dblock/source/opensearch-project/opensearch-api/dblock-opensearch-api/build/distributions/opensearch-api.zip

-> Installed opensearch-api with folder name opensearch-api
```

When you run OpenSeaerch with `./gradlew run` you should see the plugin loaded in the logs.

```
[2023-09-27T08:35:48,627][INFO ][o.o.p.PluginsService] [runTask-0] loaded plugin [opensearch-api]
```

### Test

```sh
$ curl http://localhost:9200/_plugins/api
```

### Uninstall

```sh
./distribution/archives/darwin-arm64-tar/build/install/opensearch-3.0.0-SNAPSHOT/bin/opensearch-plugin remove opensearch-api

-> removing [opensearch-api]...
```

## License

This code is licensed under the Apache 2.0 License. See [LICENSE.txt](LICENSE.txt).

## Copyright

Copyright OpenSearch Contributors. See [NOTICE](NOTICE.txt) for details.