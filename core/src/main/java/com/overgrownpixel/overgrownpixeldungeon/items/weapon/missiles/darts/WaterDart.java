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

package com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts;

import com.overgrownpixel.overgrownpixeldungeon.Dungeon;
import com.overgrownpixel.overgrownpixeldungeon.actors.Char;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.WaterOfAwareness;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.WaterOfHealth;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.WaterOfTransmutation;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.WellWater;
import com.overgrownpixel.overgrownpixeldungeon.levels.Level;
import com.overgrownpixel.overgrownpixeldungeon.levels.Terrain;
import com.overgrownpixel.overgrownpixeldungeon.scenes.GameScene;
import com.overgrownpixel.overgrownpixeldungeon.sprites.items.ItemSpriteSheet;
import com.watabou.utils.Random;

public class WaterDart extends TippedDart {
	
	{
		image = ItemSpriteSheet.DART_WATER;
	}

    private static final Class<?>[] WATERS =
            {WaterOfAwareness.class, WaterOfHealth.class, WaterOfTransmutation.class};
	
	@Override
	public int proc(Char attacker, Char defender, int damage) {
        if(Dungeon.level.map[defender.pos] == Terrain.EMPTY || Dungeon.level.map[defender.pos] == Terrain.GRASS){
            Level.set(defender.pos, Terrain.WATER);
            GameScene.updateMap(defender.pos);
        }
        if(Dungeon.level.map[defender.pos] == Terrain.EMPTY_WELL){
            @SuppressWarnings("unchecked")
            Class<? extends WellWater> waterClass = (Class<? extends WellWater>) Random.element( WATERS );
            WellWater.seed(defender.pos, 1, waterClass, Dungeon.level);
            Level.set(defender.pos, Terrain.WELL);
            GameScene.updateMap(defender.pos);
        }
        if (attacker.alignment == defender.alignment){
            return 0;
        }
		return super.proc(attacker, defender, damage);
	}
}
