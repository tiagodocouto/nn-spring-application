/*
 * MIT License
 *
 * Copyright (c) 2022 Tiago Couto.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN
 * AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package nl.nn.app.purchase.stream;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

import nl.nn.app.purchase.view.PurchaseVO;
import nl.nn.utils.config.TestBeanConfiguration;
import nl.nn.utils.helper.PurchaseBuilderHelper;
import nl.nn.utils.stream.PurchaseStreamConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
@ContextConfiguration(classes = {TestBeanConfiguration.class})
class PurchaseStreamProducerTest {
    @Value("${spring.kafka.properties.topic.purchase}")
    private String topic;

    @Autowired
    private PurchaseStreamProducer purchaseStreamProducer;

    @Autowired
    private PurchaseStreamConsumer purchaseStreamConsumer;

    /**
     * Test creating a new {@link PurchaseVO}
     * and sending it through {@link PurchaseStreamProducer} Kafka Stream
     * expect to be produced and consumed. 
     */
    @Test
    void testGivenAPurchaseWhenPostingToControllerExpectToBeAccepted() throws Exception {
        final var purchase = PurchaseBuilderHelper.builder().build();
        final var result = purchaseStreamProducer.send(purchase).get().getProducerRecord();
        assertThat(result.topic()).isEqualTo(topic);
        assertThat(result.key()).isEqualTo(purchase.getId());
        assertThat(result.value()).isEqualTo(purchase);

        final var consumed = purchaseStreamConsumer.latch().await(10, SECONDS);
        assertThat(consumed).isTrue();
        final var record = purchaseStreamConsumer.record();
        assertThat(record.key()).isEqualTo(purchase.getId());
        assertThat(record.value()).isEqualTo(purchase);
    }
}
