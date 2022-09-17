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

package nl.nn.app.purchase.view;

import static nl.nn.helpers.PurchaseItemBuilderHelper.DEFAULT_AMOUNT;
import static nl.nn.helpers.PurchaseItemBuilderHelper.DEFAULT_DISCOUNT;
import static nl.nn.helpers.PurchaseItemBuilderHelper.DEFAULT_ID;
import static nl.nn.helpers.PurchaseItemBuilderHelper.DEFAULT_PURCHASE_VALUE;
import static nl.nn.helpers.PurchaseItemBuilderHelper.OTHER_AMOUNT;
import static nl.nn.helpers.PurchaseItemBuilderHelper.OTHER_DISCOUNT;
import static nl.nn.helpers.PurchaseItemBuilderHelper.OTHER_ID;
import static nl.nn.helpers.PurchaseItemBuilderHelper.OTHER_PURCHASE_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

import nl.nn.helpers.PlayerBuilderHelper;
import nl.nn.helpers.PurchaseItemBuilderHelper;
import org.junit.jupiter.api.Test;

class PurchaseVOItemTest {
    /**
     * Test instancing a {@link PurchaseItemVO}
     * and checking the getters, hashCode, equals 
     */
    @Test
    void testGivenAPurchaseItemExpectGettersHashCodeEqualsToBeOk() {
        //given
        final var purchaseItem = PurchaseItemBuilderHelper.builder().build();

        //when
        //then
        assertThat(purchaseItem).isNotNull();

        assertThat(purchaseItem.equals(null)).isFalse();
        assertThat(purchaseItem.equals(0)).isFalse();
        assertThat(purchaseItem.equals(PlayerBuilderHelper.builder().build())).isFalse();

        assertThat(purchaseItem.hashCode()).isEqualTo(123842878);
        assertThat(purchaseItem.getId()).isEqualTo(DEFAULT_ID);
        assertThat(purchaseItem.getItemId()).isEqualTo(DEFAULT_ID);
        assertThat(purchaseItem.getAmount()).isEqualTo(DEFAULT_AMOUNT);
        assertThat(purchaseItem.getDiscount()).isEqualTo(DEFAULT_DISCOUNT);
        assertThat(purchaseItem.getPurchaseValue()).isEqualTo(DEFAULT_PURCHASE_VALUE);
        assertThat(purchaseItem).hasToString("PurchaseItemVO(super=ViewObject(" +
                                                     "id=" + DEFAULT_ID + "), " +
                                                     "itemId=" + DEFAULT_ID + ", " +
                                                     "amount=" + DEFAULT_AMOUNT + ", " +
                                                     "discount=" + DEFAULT_DISCOUNT + ", " +
                                                     "purchaseValue=" + DEFAULT_PURCHASE_VALUE + ")");
    }

    /**
     * Test instancing a {@link PurchaseItemVO}
     * and checking the getters, hashCode, equals 
     */
    @Test
    void testGivenAPurchaseItemExpectToBeEqualsOtherPurchaseItemWithSameValues() {
        //given
        final var purchaseItem1 = PurchaseItemBuilderHelper.builder().build();
        final var purchaseItem2 = PurchaseItemBuilderHelper.builder().build();

        //when
        //then
        assertThat(purchaseItem1)
                .isNotEqualTo(null)
                .isEqualTo(purchaseItem2);
    }

    /**
     * Test instancing a {@link PurchaseItemVO}
     * and changing the properties values 
     */
    @Test
    void testGivenPurchaseItemsWhenChangingItPropertiesExpectSettersToBeOk() {
        //given
        final var purchaseItem1 = PurchaseItemBuilderHelper.builder().build();
        final var purchaseItem2 = PurchaseItemBuilderHelper.builder().build();

        //when
        assertThat(purchaseItem1).isNotNull();
        assertThat(purchaseItem2).isNotNull();
        assertThat(purchaseItem1).isEqualTo(purchaseItem2);

        purchaseItem1.setPurchaseValue(OTHER_PURCHASE_VALUE);
        assertThat(purchaseItem1).isNotEqualTo(purchaseItem2);

        purchaseItem1.setDiscount(OTHER_DISCOUNT);
        assertThat(purchaseItem1).isNotEqualTo(purchaseItem2);

        purchaseItem1.setAmount(OTHER_AMOUNT);
        assertThat(purchaseItem1).isNotEqualTo(purchaseItem2);

        purchaseItem1.setItemId(OTHER_ID);
        assertThat(purchaseItem1).isNotEqualTo(purchaseItem2);

        purchaseItem1.setId(OTHER_ID);
        assertThat(purchaseItem1).isNotEqualTo(purchaseItem2);

        //then
        assertThat(purchaseItem1.hashCode()).isEqualTo(-954843874);
        assertThat(purchaseItem1.getId()).isEqualTo(OTHER_ID);
        assertThat(purchaseItem1.getItemId()).isEqualTo(OTHER_ID);
        assertThat(purchaseItem1.getAmount()).isEqualTo(OTHER_AMOUNT);
        assertThat(purchaseItem1.getDiscount()).isEqualTo(OTHER_DISCOUNT);
        assertThat(purchaseItem1.getPurchaseValue()).isEqualTo(OTHER_PURCHASE_VALUE);
        assertThat(purchaseItem1).hasToString("PurchaseItemVO(super=ViewObject(" +
                                                      "id=" + OTHER_ID + "), " +
                                                      "itemId=" + OTHER_ID + ", " +
                                                      "amount=" + OTHER_AMOUNT + ", " +
                                                      "discount=" + OTHER_DISCOUNT + ", " +
                                                      "purchaseValue=" + OTHER_PURCHASE_VALUE + ")");
    }
}
