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

package nl.nn.app.item.controller;

import static java.util.concurrent.TimeUnit.SECONDS;
import static nl.nn.app.item.stream.ItemStreamProducer.TOPIC;
import static org.assertj.core.api.Assertions.assertThat;

import nl.nn.app.item.stream.ItemStreamProducer;
import nl.nn.app.item.view.ItemVO;
import nl.nn.utils.config.TestBeanConfiguration;
import nl.nn.utils.helper.ItemBuilderHelper;
import nl.nn.utils.stream.ItemStreamConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
@ContextConfiguration(classes = {TestBeanConfiguration.class})
class ItemStreamTest {
    @Autowired
    private ItemStreamProducer itemStreamProducer;

    @Autowired
    private ItemStreamConsumer itemStreamConsumer;

    /**
     * Test creating a new {@link ItemVO}
     * and sending it through {@link ItemStreamProducer} Kafka Stream
     * expect to be produced and consumed. 
     */
    @Test
    void testGivenAnItemWhenPostingToControllerExpectToBeAccepted() throws Exception {
        final var item = ItemBuilderHelper.builder().build();
        final var result = itemStreamProducer.send(item).get().getProducerRecord();
        assertThat(result.topic()).isEqualTo(TOPIC);
        assertThat(result.key()).isEqualTo(item.getId());
        assertThat(result.value()).isEqualTo(item);

        final var consumed = itemStreamConsumer.latch().await(10, SECONDS);
        assertThat(consumed).isTrue();
        final var record = itemStreamConsumer.record();
        assertThat(record.key()).isEqualTo(item.getId());
        assertThat(record.value()).isEqualTo(item);
    }
}
