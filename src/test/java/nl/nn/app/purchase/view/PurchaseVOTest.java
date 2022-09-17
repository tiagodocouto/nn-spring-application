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

import static nl.nn.helpers.PurchaseBuilderHelper.DEFAULT_ID;
import static nl.nn.helpers.PurchaseBuilderHelper.DEFAULT_PURCHASE_ITEM;
import static nl.nn.helpers.PurchaseBuilderHelper.DEFAULT_RECIPE;
import static nl.nn.helpers.PurchaseBuilderHelper.OTHER_ID;
import static nl.nn.helpers.PurchaseBuilderHelper.OTHER_PURCHASE_ITEM;
import static nl.nn.helpers.PurchaseBuilderHelper.OTHER_RECIPE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import nl.nn.helpers.PlayerBuilderHelper;
import nl.nn.helpers.PurchaseBuilderHelper;
import org.junit.jupiter.api.Test;

class PurchaseVOTest {
    /**
     * Test instancing a {@link PurchaseVO}
     * and checking the getters, hashCode, equals 
     */
    @Test
    void testGivenAPurchaseExpectGettersHashCodeEqualsToBeOk() {
        //given
        final var purchase = PurchaseBuilderHelper.builder().build();

        //when
        //then
        assertThat(purchase).isNotNull();

        assertThat(purchase.equals(null)).isFalse();
        assertThat(purchase.equals(0)).isFalse();
        assertThat(purchase.equals(PlayerBuilderHelper.builder().build())).isFalse();

        assertThat(purchase.hashCode()).isEqualTo(1422945049);
        assertThat(purchase.getId()).isEqualTo(DEFAULT_ID);
        assertThat(purchase.getPurchaseItems())
                .hasSize(1)
                .contains(DEFAULT_PURCHASE_ITEM);
        assertThat(purchase.getRecipe()).isEqualTo(DEFAULT_RECIPE);
        assertThat(purchase).hasToString("PurchaseVO(super=ViewObject(" +
                                                 "id=" + DEFAULT_ID + "), " +
                                                 "purchaseItems=" + List.of(DEFAULT_PURCHASE_ITEM) + ", " +
                                                 "recipe=" + DEFAULT_RECIPE + ")");
    }

    /**
     * Test instancing a {@link PurchaseVO}
     * and checking the getters, hashCode, equals 
     */
    @Test
    void testGivenAPurchaseExpectToBeEqualsOtherPurchaseWithSameValues() {
        //given
        final var purchase1 = PurchaseBuilderHelper.builder().build();
        final var purchase2 = PurchaseBuilderHelper.builder().build();

        //when
        //then
        assertThat(purchase1)
                .isNotEqualTo(null)
                .isEqualTo(purchase2);
    }

    /**
     * Test instancing a {@link PurchaseVO}
     * and changing the properties values 
     */
    @Test
    void testGivenPurchasesWhenChangingItPropertiesExpectSettersToBeOk() {
        //given
        final var purchase1 = PurchaseBuilderHelper.builder().build();
        final var purchase2 = PurchaseBuilderHelper.builder().build();

        //when
        assertThat(purchase1).isNotNull();
        assertThat(purchase2).isNotNull();
        assertThat(purchase1).isEqualTo(purchase2);

        purchase1.setRecipe(OTHER_RECIPE);
        assertThat(purchase1).isNotEqualTo(purchase2);

        purchase1.setPurchaseItems(List.of(OTHER_PURCHASE_ITEM));
        assertThat(purchase1).isNotEqualTo(purchase2);

        purchase1.setId(OTHER_ID);
        assertThat(purchase1).isNotEqualTo(purchase2);

        //then
        assertThat(purchase1.hashCode()).isEqualTo(1898240184);
        assertThat(purchase1.getId()).isEqualTo(OTHER_ID);
        assertThat(purchase1.getPurchaseItems())
                .hasSize(1)
                .contains(OTHER_PURCHASE_ITEM);
        assertThat(purchase1.getRecipe()).isEqualTo(OTHER_RECIPE);
        assertThat(purchase1).hasToString("PurchaseVO(super=ViewObject(" +
                                                  "id=" + OTHER_ID + "), " +
                                                  "purchaseItems=" + List.of(OTHER_PURCHASE_ITEM) + ", " +
                                                  "recipe=" + OTHER_RECIPE + ")");
    }
}
