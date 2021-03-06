/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2019 Evan Debenham
 *
 * Overgrown Pixel Dungeon
 * Copyright (C) 2016-2019 Anon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This Program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without eben the implied warranty of
 * GNU General Public License for more details.
 *
 * You should have have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses>
 */

package com.overgrownpixel.overgrownpixeldungeon.items.weapon.enchantments;

import com.overgrownpixel.overgrownpixeldungeon.Dungeon;
import com.overgrownpixel.overgrownpixeldungeon.R;
import com.overgrownpixel.overgrownpixeldungeon.actors.Char;
import com.overgrownpixel.overgrownpixeldungeon.actors.mobs.Mob;
import com.overgrownpixel.overgrownpixeldungeon.effects.Speck;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.Weapon;
import com.overgrownpixel.overgrownpixeldungeon.sprites.items.ItemSprite;
import com.watabou.noosa.Game;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class Whirlwind extends Weapon.Enchantment {

	private static ItemSprite.Glowing COLOR = new ItemSprite.Glowing( Game.instance.getResources().getInteger(R.integer.whirlwind) );

	@Override
	public int proc(Weapon weapon, Char attacker, Char defender, int damage) {
		// lvl 0 - 20%
		// lvl 1 - 33%
		// lvl 2 - 43%
		int level = Math.max( 0, weapon.level() );

		boolean hitOtherMobs = false;

        ArrayList<Mob> mobs = new ArrayList<Mob>();

		if (Random.Int( level + 5 ) >= 4) {
            attacker.sprite.emitter().burst( Speck.factory( Speck.EVOKE ), 3);

            for(Mob mob : Dungeon.level.mobs.toArray(new Mob[0])){
                if(Dungeon.level.distance(attacker.pos, mob.pos) <= weapon.RCH){
                    mobs.add(mob);
                }
            }

            if(!mobs.isEmpty()){
                hitOtherMobs = true;
                for (Mob mob : mobs){
                    hitOtherMobs = true;
                    mob.damage(Math.round(damage/2), attacker);
                }
            }

		}

        if(hitOtherMobs){
            return damage/2;
        }

        return damage;
	}

	@Override
	public ItemSprite.Glowing glowing() {
		return COLOR;
	}

}