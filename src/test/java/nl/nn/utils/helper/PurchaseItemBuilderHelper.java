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

package nl.nn.utils.helper;

import java.util.UUID;

import nl.nn.app.purchase.view.PurchaseItemVO;

public final class PurchaseItemBuilderHelper {
    public static final UUID DEFAULT_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");

    public static final UUID OTHER_ID = UUID.fromString("00000000-0000-0000-0000-000000000001");

    public static final Double DEFAULT_AMOUNT = 1D;

    public static final Double OTHER_AMOUNT = 9D;

    public static final Double DEFAULT_DISCOUNT = 2D;

    public static final Double OTHER_DISCOUNT = 8D;

    public static final Double DEFAULT_PURCHASE_VALUE = 3D;

    public static final Double OTHER_PURCHASE_VALUE = 7D;

    private final PurchaseItemVO purchaseItem;

    /**
     * Initialize the {@link PurchaseItemVO} with default values
     */
    private PurchaseItemBuilderHelper() {
        purchaseItem = PurchaseItemVO.builder()
                .id(DEFAULT_ID)
                .itemId(DEFAULT_ID)
                .amount(DEFAULT_AMOUNT)
                .discount(DEFAULT_DISCOUNT)
                .purchaseValue(DEFAULT_PURCHASE_VALUE)
                .build();
    }

    /**
     * Builder initialize
     * @return the {@link PurchaseItemBuilderHelper} instance
     */
    public static PurchaseItemBuilderHelper builder() {
        return new PurchaseItemBuilderHelper();
    }

    /**
     * Set a new id
     * @param id the name
     * @return self {@link ItemBuilderHelper} instance
     */
    public PurchaseItemBuilderHelper id(final UUID id) {
        purchaseItem.setId(id);
        return this;
    }

    /**
     * Set a new item ID
     * @param id the id
     * @return self {@link PurchaseItemBuilderHelper} instance
     */
    public PurchaseItemBuilderHelper item(final UUID id) {
        purchaseItem.setItemId(id);
        return this;
    }

    /**
     * @return the instance of {@link PurchaseItemBuilderHelper}
     */
    public PurchaseItemVO build() {
        return purchaseItem;
    }
}
