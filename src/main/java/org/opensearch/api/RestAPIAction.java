/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.api;

import java.io.IOException;
import java.util.List;

import org.opensearch.client.node.NodeClient;
import org.opensearch.core.rest.RestStatus;
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.rest.BytesRestResponse;
import org.opensearch.rest.RestRequest;

import static org.opensearch.rest.RestRequest.Method.GET;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * A REST handler.
 */
public class RestAPIAction extends BaseRestHandler {
    @Override
    public String getName() {
        return "api";
    }

    @Override
    public List routes() {
        return unmodifiableList(asList(
                new Route(GET, "/_plugins/api")
        ));
    }

    @Override
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        return channel -> {
            try {
                channel.sendResponse(
                        new BytesRestResponse(RestStatus.OK, "API SPEC\n"));
            } catch (final Exception e) {
                channel.sendResponse(new BytesRestResponse(channel, e));
            }
        };
    }
}