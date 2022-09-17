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

import nl.nn.app.item.enums.ItemType;
import nl.nn.app.item.view.ItemVO;

public final class ItemBuilderHelper {
    public static final UUID DEFAULT_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");

    public static final UUID OTHER_ID = UUID.fromString("00000000-0000-0000-0000-000000000001");

    public static final String DEFAULT_NAME = "Armor Of Bugs Deflecting";

    public static final String OTHER_NAME = "Potion Of Superior Testing";

    public static final String DEFAULT_SKU = "item_sku_code_1";

    public static final String OTHER_SKU = "item_sku_code_2";

    public static final ItemType DEFAULT_TYPE = ItemType.ARMOR;

    public static final ItemType OTHER_TYPE = ItemType.POTION;

    public static final Double DEFAULT_DISCOUNT = 1D;

    public static final Double OTHER_DISCOUNT = 9D;

    public static final Double DEFAULT_VALUE = 2D;

    public static final Double OTHER_VALUE = 8D;

    private final ItemVO item;

    /**
     * Initialize the {@link ItemVO} with default values
     */
    private ItemBuilderHelper() {
        item = ItemVO.builder()
                .id(DEFAULT_ID)
                .name(DEFAULT_NAME)
                .sku(DEFAULT_SKU)
                .type(DEFAULT_TYPE)
                .discount(DEFAULT_DISCOUNT)
                .value(DEFAULT_VALUE)
                .build();
    }

    /**
     * Builder initialize
     * @return the {@link ItemBuilderHelper} instance
     */
    public static ItemBuilderHelper builder() {
        return new ItemBuilderHelper();
    }

    /**
     * Set a new id
     * @param id the name
     * @return self {@link ItemBuilderHelper} instance
     */
    public ItemBuilderHelper id(final UUID id) {
        item.setId(id);
        return this;
    }

    /**
     * Set a new name
     * @param name the name
     * @return self {@link ItemBuilderHelper} instance
     */
    public ItemBuilderHelper name(final String name) {
        item.setName(name);
        return this;
    }

    /**
     * @return the instance of {@link ItemVO}
     */
    public ItemVO build() {
        return item;
    }
}
