package com.dxfeed.sample;

import com.dxfeed.api.DXEndpoint;
import com.dxfeed.api.DXFeedSubscription;
import com.dxfeed.event.market.Quote;

/**
 * A sample application that demonstrates how to subscribe to the data feed over a socket connection
 * and print received {@link Quote} events to the console.
 */
public class SampleQdEndpoint {
    public static void main(String[] args) throws InterruptedException {
        DXEndpoint dxEndpoint = DXEndpoint.create();
        // For token-based authorization, use the following address format:
        // "demo.dxfeed.com:7300[login=entitle:token]"
        dxEndpoint.connect("demo.dxfeed.com:7300"); //localhost:7700
        DXFeedSubscription<Quote> subscription = dxEndpoint.getFeed().createSubscription(Quote.class);
        subscription.addEventListener(events -> {
            for (Quote event : events) {
                System.out.println(event);
            }
        });
        subscription.addSymbols("AAPL");
        Thread.sleep(Long.MAX_VALUE);
    }
}
