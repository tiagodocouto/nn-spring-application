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

package nl.nn.app.player.stream;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

import nl.nn.app.player.view.PlayerVO;
import nl.nn.utils.config.TestBeanConfiguration;
import nl.nn.utils.helper.PlayerBuilderHelper;
import nl.nn.utils.stream.PlayerStreamConsumer;
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
class PlayerStreamProducerTest {
    @Value("${spring.kafka.properties.topic.player}")
    private String topic;

    @Autowired
    private PlayerStreamProducer playerStreamProducer;

    @Autowired
    private PlayerStreamConsumer playerStreamConsumer;

    /**
     * Test creating a new {@link PlayerVO}
     * and sending it through {@link PlayerStreamProducer} Kafka Stream
     * expect to be produced and consumed. 
     */
    @Test
    void testGivenAnItemWhenPostingToControllerExpectToBeAccepted() throws Exception {
        final var player = PlayerBuilderHelper.builder().build();
        final var result = playerStreamProducer.send(player).get().getProducerRecord();
        assertThat(result.topic()).isEqualTo(topic);
        assertThat(result.key()).isEqualTo(player.getId());
        assertThat(result.value()).isEqualTo(player);

        final var consumed = playerStreamConsumer.latch().await(10, SECONDS);
        assertThat(consumed).isTrue();
        final var record = playerStreamConsumer.record();
        assertThat(record.key()).isEqualTo(player.getId());
        assertThat(record.value()).isEqualTo(player);
    }
}
