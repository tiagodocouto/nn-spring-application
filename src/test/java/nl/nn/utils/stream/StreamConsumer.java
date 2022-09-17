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

package nl.nn.utils.stream;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public abstract class StreamConsumer<T> {
    private final CountDownLatch latch = new CountDownLatch(1);

    private ConsumerRecord<UUID, T> record;

    /**
     * Process the received record from Kafka
     * @param record the record data
     */
    public void received(ConsumerRecord<UUID, T> record) {
        this.record = record;
        latch().countDown();
    }

    /**
     * Define the Topic to listen to
     * @see KafkaListener
     * @param record the record data
     */
    public abstract void receive(ConsumerRecord<UUID, T> record);

    /**
     * @return the latch
     */
    public CountDownLatch latch() {
        return latch;
    }

    /**
     * @return the record
     */
    public ConsumerRecord<UUID, T> record() {
        return record;
    }
}
