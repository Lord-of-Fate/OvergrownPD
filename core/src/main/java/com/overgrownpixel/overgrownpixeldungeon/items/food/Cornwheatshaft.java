/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2019 Evan Debenham
 *
 * Overgrown Pixel Dungeon
 * Copyright (C) 2018-2019 Anon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.overgrownpixel.overgrownpixeldungeon.items.food;

import com.overgrownpixel.overgrownpixeldungeon.items.Recipe;
import com.overgrownpixel.overgrownpixeldungeon.sprites.items.ItemSpriteSheet;

public class Cornwheatshaft extends Food {

	{
		image = ItemSpriteSheet.CORNWHEATSHAFT;
		energy = 1f;
	}
	
	@Override
	public int price() {
		return 1 * quantity;
	}

    public static class threeWheat extends Recipe.SimpleRecipe{
        {
            inputs =  new Class[]{Cornwheatshaft.class};
            inQuantity = new int[]{3};

            cost = 1;

            output = Food.class;
            outQuantity = 1;
        }
    }
}
