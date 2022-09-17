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

package nl.nn.app.item.view;

import static nl.nn.helpers.ItemBuilderHelper.DEFAULT_DISCOUNT;
import static nl.nn.helpers.ItemBuilderHelper.DEFAULT_ID;
import static nl.nn.helpers.ItemBuilderHelper.DEFAULT_NAME;
import static nl.nn.helpers.ItemBuilderHelper.DEFAULT_SKU;
import static nl.nn.helpers.ItemBuilderHelper.DEFAULT_TYPE;
import static nl.nn.helpers.ItemBuilderHelper.DEFAULT_VALUE;
import static nl.nn.helpers.ItemBuilderHelper.OTHER_DISCOUNT;
import static nl.nn.helpers.ItemBuilderHelper.OTHER_ID;
import static nl.nn.helpers.ItemBuilderHelper.OTHER_NAME;
import static nl.nn.helpers.ItemBuilderHelper.OTHER_SKU;
import static nl.nn.helpers.ItemBuilderHelper.OTHER_TYPE;
import static nl.nn.helpers.ItemBuilderHelper.OTHER_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

import nl.nn.helpers.ItemBuilderHelper;
import nl.nn.helpers.PlayerBuilderHelper;
import org.junit.jupiter.api.Test;

class ItemVOTest {
    /**
     * Test instancing an {@link ItemVO}
     * and checking the getters, hashCode, equals 
     */
    @Test
    void testGivenAnItemExpectGettersHashCodeEqualsToBeOk() {
        //given
        final var item = ItemBuilderHelper.builder().build();

        //when
        //then
        assertThat(item).isNotNull();

        assertThat(item.equals(null)).isFalse();
        assertThat(item.equals(0)).isFalse();
        assertThat(item.equals(PlayerBuilderHelper.builder().build())).isFalse();

        assertThat(item.hashCode()).isEqualTo(291526338);
        assertThat(item.getId()).isEqualTo(DEFAULT_ID);
        assertThat(item.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(item.getSku()).isEqualTo(DEFAULT_SKU);
        assertThat(item.getValue()).isEqualTo(DEFAULT_VALUE);
        assertThat(item.getDiscount()).isEqualTo(DEFAULT_DISCOUNT);
        assertThat(item.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(item).hasToString("ItemVO(super=ViewObject(" +
                                             "id=" + DEFAULT_ID + "), " +
                                             "type=" + DEFAULT_TYPE + ", " +
                                             "name=" + DEFAULT_NAME + ", " +
                                             "sku=" + DEFAULT_SKU + ", " +
                                             "discount=" + DEFAULT_DISCOUNT + ", " +
                                             "value=" + DEFAULT_VALUE + ")");
    }

    /**
     * Test instancing an {@link ItemVO}
     * and checking the getters, hashCode, equals 
     */
    @Test
    void testGivenAnItemExpectToBeEqualsOtherItemWithSameValues() {
        //given
        final var item1 = ItemBuilderHelper.builder().build();
        final var item2 = ItemBuilderHelper.builder().build();

        //when
        //then
        assertThat(item1)
                .isNotEqualTo(null)
                .isEqualTo(item2);
    }

    /**
     * Test instancing an {@link ItemVO}
     * and changing the properties values 
     */
    @Test
    void testGivenItemsWhenChangingItPropertiesExpectSettersToBeOk() {
        //given
        final var item1 = ItemBuilderHelper.builder().build();
        final var item2 = ItemBuilderHelper.builder().build();

        //when
        assertThat(item1).isNotNull();
        assertThat(item2).isNotNull();
        assertThat(item1).isEqualTo(item2);

        item1.setValue(OTHER_VALUE);
        assertThat(item1).isNotEqualTo(item2);

        item1.setDiscount(OTHER_DISCOUNT);
        assertThat(item1).isNotEqualTo(item2);

        item1.setSku(OTHER_SKU);
        assertThat(item1).isNotEqualTo(item2);

        item1.setName(OTHER_NAME);
        assertThat(item1).isNotEqualTo(item2);

        item1.setType(OTHER_TYPE);
        assertThat(item1).isNotEqualTo(item2);

        item1.setId(OTHER_ID);
        assertThat(item1).isNotEqualTo(item2);

        //then
        assertThat(item1.hashCode()).isEqualTo(723956293);
        assertThat(item1.getId()).isEqualTo(OTHER_ID);
        assertThat(item1.getType()).isEqualTo(OTHER_TYPE);
        assertThat(item1.getName()).isEqualTo(OTHER_NAME);
        assertThat(item1.getSku()).isEqualTo(OTHER_SKU);
        assertThat(item1.getDiscount()).isEqualTo(OTHER_DISCOUNT);
        assertThat(item1.getValue()).isEqualTo(OTHER_VALUE);
        assertThat(item1).hasToString("ItemVO(super=ViewObject(" +
                                              "id=" + OTHER_ID + "), " +
                                              "type=" + OTHER_TYPE + ", " +
                                              "name=" + OTHER_NAME + ", " +
                                              "sku=" + OTHER_SKU + ", " +
                                              "discount=" + OTHER_DISCOUNT + ", " +
                                              "value=" + OTHER_VALUE + ")");
    }
}
