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

package nl.nn.app.recipe.view;

import static nl.nn.helpers.RecipeBuilderHelper.DEFAULT_ID;
import static nl.nn.helpers.RecipeBuilderHelper.DEFAULT_TENDER;
import static nl.nn.helpers.RecipeBuilderHelper.OTHER_ID;
import static nl.nn.helpers.RecipeBuilderHelper.OTHER_TENDER;
import static org.assertj.core.api.Assertions.assertThat;

import nl.nn.helpers.PlayerBuilderHelper;
import nl.nn.helpers.RecipeBuilderHelper;
import org.junit.jupiter.api.Test;

class RecipeVOTest {
    /**
     * Test instancing a {@link RecipeVO}
     * and checking the getters, hashCode, equals 
     */
    @Test
    void testGivenARecipeVOExpectGettersHashCodeEqualsToBeOk() {
        //given
        final var recipe = RecipeBuilderHelper.builder().build();

        //when
        //then
        assertThat(recipe).isNotNull();

        assertThat(recipe.equals(null)).isFalse();
        assertThat(recipe.equals(0)).isFalse();
        assertThat(recipe.equals(PlayerBuilderHelper.builder().build())).isFalse();

        assertThat(recipe.hashCode()).isEqualTo(1878722584);
        assertThat(recipe.getId()).isEqualTo(DEFAULT_ID);
        assertThat(recipe.getTender()).isEqualTo(DEFAULT_TENDER);
        assertThat(recipe).hasToString("RecipeVO(super=ViewObject(" +
                                               "id=" + DEFAULT_ID + "), " +
                                               "tender=" + DEFAULT_TENDER + ")");
    }

    /**
     * Test instancing a {@link RecipeVO}
     * and checking the getters, hashCode, equals 
     */
    @Test
    void testGivenARecipeVOExpectToBeEqualsOtherRecipeVOWithSameValues() {
        //given
        final var recipe1 = RecipeBuilderHelper.builder().build();
        final var recipe2 = RecipeBuilderHelper.builder().build();

        //when
        //then
        assertThat(recipe1)
                .isNotEqualTo(null)
                .isEqualTo(recipe2);
    }

    /**
     * Test instancing a {@link RecipeVO}
     * and changing the properties values 
     */
    @Test
    void testGivenRecipeVOsWhenChangingItPropertiesExpectSettersToBeOk() {
        //given
        final var recipe1 = RecipeBuilderHelper.builder().build();
        final var recipe2 = RecipeBuilderHelper.builder().build();

        //when
        assertThat(recipe1).isNotNull();
        assertThat(recipe2).isNotNull();
        assertThat(recipe1).isEqualTo(recipe2);

        recipe1.setTender(OTHER_TENDER);
        assertThat(recipe1).isNotEqualTo(recipe2);

        recipe1.setId(OTHER_ID);
        assertThat(recipe1).isNotEqualTo(recipe2);

        //then
        assertThat(recipe1.hashCode()).isEqualTo(-1941874028);
        assertThat(recipe1.getId()).isEqualTo(OTHER_ID);
        assertThat(recipe1.getTender()).isEqualTo(OTHER_TENDER);
        assertThat(recipe1).hasToString("RecipeVO(super=ViewObject(" +
                                                "id=" + OTHER_ID + "), " +
                                                "tender=" + OTHER_TENDER + ")");
    }
}
