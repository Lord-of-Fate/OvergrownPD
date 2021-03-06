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

package com.overgrownpixel.overgrownpixeldungeon.items.weapon.enchantments;

import com.overgrownpixel.overgrownpixeldungeon.R;
import com.overgrownpixel.overgrownpixeldungeon.actors.Char;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Buff;
import com.overgrownpixel.overgrownpixeldungeon.items.Generator;
import com.overgrownpixel.overgrownpixeldungeon.items.Gold;
import com.overgrownpixel.overgrownpixeldungeon.items.Item;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.Weapon;
import com.overgrownpixel.overgrownpixeldungeon.sprites.items.ItemSprite;
import com.overgrownpixel.overgrownpixeldungeon.sprites.items.ItemSprite.Glowing;
import com.watabou.noosa.Game;
import com.watabou.utils.Random;

public class Lucky extends Weapon.Enchantment {

	private static ItemSprite.Glowing COLOR = new ItemSprite.Glowing( Game.instance.getResources().getInteger(R.integer.lucky) );
	
	@Override
	public int proc( Weapon weapon, Char attacker, Char defender, int damage ) {
		int level = Math.max( 0, weapon.level() );
		
		//10% chance, + 1% per weapon level
		if (defender.HP <= damage && Random.Float() < (0.1f + .01f*level)){
			Buff.affect(defender, LuckProc.class);
		}
		
		return damage;

	}
	
	public static Item genLoot(){
		float roll = Random.Float();
		if (roll < 0.6f){
			Item result = new Gold().random();
			result.quantity(Math.round(result.quantity() * 0.5f));
			return result;
		} else if (roll < 0.9f){
			return Random.Int(2) == 0
					? Generator.random(Generator.Category.SEED)
					: Generator.random(Generator.Category.STONE);
		} else {
			return Random.Int(2) == 0
					? Generator.random(Generator.Category.POTION)
					: Generator.random(Generator.Category.SCROLL);
		}
	}

	@Override
	public Glowing glowing() {
		return COLOR;
	}
	
	//used to keep track of whether a luck proc is incoming. see Mob.die()
	public static class LuckProc extends Buff {
		
		@Override
		public boolean act() {
			detach();
			return true;
		}
	}
	
}
