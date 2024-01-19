[![Build and Test Plugin](https://github.com/dblock/opensearch-api/actions/workflows/test.yml/badge.svg)](https://github.com/dblock/opensearch-api/actions/workflows/test.yml)

## OpenSearch API Plugin

A plugin that returns the OpenSearch API in the OpenAPI format.

### Build

Build a distribution.

```sh
./gradlew assemble
```

This produces `./build/distributions/opensearch-api-2.12.0.0-SNAPSHOT.zip`.

### Install

Check out OpenSearch code, run it once with `./gradlew run`.

Install the plugin, you may need to adjust `darwin-arm64-tar` below to your platform, and use the location of your plugin zip (mine is `~/source/opensearch-project/opensearch-api/dblock-opensearch-api`).

```sh
$ ./distribution/archives/darwin-arm64-tar/build/install/opensearch-2.12.0-SNAPSHOT/bin/opensearch-plugin install file:///Users/dblock/source/opensearch-project/opensearch-api/dblock-opensearch-api/build/distributions/opensearch-api-2.12.0.0-SNAPSHOT.zip

-> Installed opensearch-api with folder name opensearch-api
```

When you run OpenSearch with `./gradlew run` you should see the plugin loaded in the logs.

```
[2024-01-22T10:58:58,338][INFO ][o.o.p.PluginsService] [runTask-0] loaded plugin [opensearch-api]
```

### Test

```sh
$ curl http://localhost:9200/_plugins/api | jq
```

Returns an OpenAPI spec.

```json
{
  "openapi": "3.0.1",
  "info": {
    "title": "opensearch",
    "description": "The OpenSearch Project: https://opensearch.org/",
    "version": "2.12.0-SNAPSHOT"
  },
  ...
}
```

### Uninstall

```sh
./distribution/archives/darwin-arm64-tar/build/install/opensearch-2.12.0-SNAPSHOT/bin/opensearch-plugin remove opensearch-api

-> removing [opensearch-api]...
```

## License

This code is licensed under the Apache 2.0 License. See [LICENSE.txt](LICENSE.txt).

## Copyright

Copyright Daniel Doubrovkine (dB.), and OpenSearch Contributors. See [NOTICE](NOTICE.txt) for details.
