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

package com.overgrownpixel.overgrownpixeldungeon.items.weapon.curses;

import com.overgrownpixel.overgrownpixeldungeon.R;
import com.overgrownpixel.overgrownpixeldungeon.actors.Char;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.Weapon;
import com.overgrownpixel.overgrownpixeldungeon.sprites.items.ItemSprite;
import com.watabou.noosa.Game;
import com.watabou.utils.Bundle;

public class Fragile extends Weapon.Enchantment {

	private static ItemSprite.Glowing BLACK = new ItemSprite.Glowing( Game.instance.getResources().getInteger(R.integer.curse) );
	private int hits = 0;

	@Override
	public int proc( Weapon weapon, Char attacker, Char defender, int damage ) {
		//degrades from 100% to 25% damage over 150 hits
		damage *= (1f - hits*0.005f);
		if (hits < 150) hits++;
		return damage;
	}

	@Override
	public boolean curse() {
		return true;
	}

	@Override
	public ItemSprite.Glowing glowing() {
		return BLACK;
	}

	private static final String HITS = "hits";

	@Override
	public void restoreFromBundle( Bundle bundle ) {
		hits = bundle.getInt(HITS);
	}

	@Override
	public void storeInBundle( Bundle bundle ) {
		bundle.put(HITS, hits);
	}

}
