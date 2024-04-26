package com.dxfeed.sample;

import com.dxfeed.api.DXEndpoint;
import com.dxfeed.api.DXPublisher;
import com.dxfeed.event.market.Quote;

import java.util.Collections;
import java.util.Random;

/**
 * Using address like ":7700" it starts a server on a specified port where it provides Quote
 * event for the "AAPL" symbol.
 */
public class SampleQdPublisher {
    public static void main(final String[] args) throws InterruptedException {
        DXPublisher publisher = DXEndpoint
            .create(DXEndpoint.Role.PUBLISHER)
            .connect(":7700")
            .getPublisher();

        Random random = new Random();

        while (true) {
            Quote quote = new Quote("AAPL");
            quote.setEventTime(System.currentTimeMillis());
            quote.setAskSize(random.nextLong());
            quote.setAskPrice(random.nextDouble());
            publisher.publishEvents(Collections.singleton(quote));
            Thread.sleep(1000);
        }
    }
}
