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

import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.nn.app.core.view.ViewObject;
import nl.nn.app.item.enums.ItemType;

/**
 * Item View Object
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
public class ItemVO extends ViewObject {
    @NotNull
    private ItemType type;

    @NotBlank
    private String name;

    @NotBlank
    private String sku;

    @Min(0)
    @NotNull
    private Double discount;

    @Min(0)
    @NotNull
    private Double value;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o))
            return false;
        if (!(o instanceof ItemVO i))
            return false;
        return Objects.equals(getType(), i.getType()) &&
                Objects.equals(getName(), i.getName()) &&
                Objects.equals(getSku(), i.getSku()) &&
                Objects.equals(getDiscount(), i.getDiscount()) &&
                Objects.equals(getValue(), i.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                            String.valueOf(getType()),
                            getName(),
                            getSku(),
                            getDiscount(),
                            getValue());
    }
}
