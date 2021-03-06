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

package com.overgrownpixel.overgrownpixeldungeon.levels.traps;

import com.overgrownpixel.overgrownpixeldungeon.Assets;
import com.overgrownpixel.overgrownpixeldungeon.Dungeon;
import com.overgrownpixel.overgrownpixeldungeon.R;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.Blob;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.Freezing;
import com.overgrownpixel.overgrownpixeldungeon.effects.Splash;
import com.overgrownpixel.overgrownpixeldungeon.scenes.GameScene;
import com.watabou.noosa.Game;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.PathFinder;

public class ChillingTrap extends Trap{

	{
		color = WHITE;
		shape = DOTS;
	}

	@Override
	public void activate() {
		if (Dungeon.level.heroFOV[ pos ]){
			Splash.at( pos, Game.instance.getResources().getInteger(R.integer.chillingtrapsplash), 5);
			Sample.INSTANCE.play( Assets.SND_SHATTER );
		}
		
		for( int i : PathFinder.NEIGHBOURS9) {
			if (!Dungeon.level.solid[pos + i]) {
				GameScene.add(Blob.seed(pos + i, 10, Freezing.class));
			}
		}
	}
}
