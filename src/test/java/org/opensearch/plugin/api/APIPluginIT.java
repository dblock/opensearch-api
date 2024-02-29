/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */
package org.opensearch.plugin.api;

import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;

import org.apache.http.util.EntityUtils;
import org.opensearch.client.Request;
import org.opensearch.client.Response;
import org.opensearch.plugins.Plugin;
import org.opensearch.test.OpenSearchIntegTestCase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;

@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)
public class APIPluginIT extends OpenSearchIntegTestCase {

    @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        return Collections.singletonList(APIPlugin.class);
    }

    public void testPluginInstalled() throws IOException {
        Response response = getRestClient().performRequest(new Request("GET", "/_cat/plugins"));
        String body = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

        logger.info("response body: {}", body);
        assertTrue(body.contains("api"));
    }

    public void testPluginGetAPI() throws IOException {
        Response response = getRestClient().performRequest(new Request("GET", "/_plugins/api"));
        String body = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        logger.info("response body: {}", body);
        assertTrue(body.startsWith("{\"openapi\":\"3.0.1\""));
    }
}