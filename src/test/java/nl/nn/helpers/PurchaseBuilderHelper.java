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

package nl.nn.helpers;

import static nl.nn.helpers.RecipeBuilderHelper.OTHER_TENDER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import nl.nn.app.purchase.view.PurchaseItemVO;
import nl.nn.app.purchase.view.PurchaseVO;
import nl.nn.app.recipe.view.RecipeVO;

public final class PurchaseBuilderHelper {
    public static final UUID DEFAULT_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");

    public static final UUID OTHER_ID = UUID.fromString("00000000-0000-0000-0000-000000000001");

    public static final PurchaseItemVO DEFAULT_PURCHASE_ITEM = PurchaseItemBuilderHelper.builder().build();

    public static final PurchaseItemVO OTHER_PURCHASE_ITEM = PurchaseItemBuilderHelper.builder()
            .item(OTHER_ID)
            .build();

    public static final RecipeVO DEFAULT_RECIPE = RecipeBuilderHelper.builder().build();

    public static final RecipeVO OTHER_RECIPE = RecipeBuilderHelper.builder()
            .tender(OTHER_TENDER)
            .build();

    private final PurchaseVO purchase;

    /**
     * Initialize the {@link PurchaseVO} with default values
     */
    private PurchaseBuilderHelper() {
        purchase = PurchaseVO.builder()
                .id(DEFAULT_ID)
                .purchaseItems(new ArrayList<>() {{
                    add(DEFAULT_PURCHASE_ITEM);
                }})
                .recipe(DEFAULT_RECIPE)
                .build();
    }

    /**
     * Builder initialize
     * @return the {@link PurchaseBuilderHelper} instance
     */
    public static PurchaseBuilderHelper builder() {
        return new PurchaseBuilderHelper();
    }

    /**
     * Change the {@link PurchaseItemVO} elements
     * @param items all items
     * @return self {@link PurchaseBuilderHelper} instance
     */
    public PurchaseBuilderHelper items(final PurchaseItemVO... items) {
        purchase.setPurchaseItems(new ArrayList<>(Arrays.stream(items).toList()));
        return this;
    }

    /**
     * Set a new {@link RecipeVO}
     * @param recipe the recipe
     * @return self {@link PurchaseBuilderHelper} instance
     */
    public PurchaseBuilderHelper recipe(final RecipeVO recipe) {
        purchase.setRecipe(recipe);
        return this;
    }

    /**
     * @return the instance of {@link PurchaseVO}
     */
    public PurchaseVO build() {
        return purchase;
    }
}
