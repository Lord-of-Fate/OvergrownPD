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

package com.overgrownpixel.overgrownpixeldungeon.sprites.mobs;

import com.overgrownpixel.overgrownpixeldungeon.Assets;
import com.overgrownpixel.overgrownpixeldungeon.R;
import com.watabou.noosa.Game;
import com.watabou.noosa.TextureFilm;

public class LivingPlantSprite extends MobSprite {

	public LivingPlantSprite(int id) {
		super();


		int addpixels = id * 9;
		
		texture( Assets.PLANTS );
		
		TextureFilm frames = new TextureFilm( texture, 16, 16 );
		
		idle = new Animation( 5, true );
		idle.frames( frames, 0+addpixels, 1+addpixels );
		
		run = new Animation( 15, true );
		run.frames( frames, 0+addpixels, 1+addpixels, 2+addpixels, 3+addpixels, 4+addpixels, 5+addpixels );
		
		attack = new Animation( 12, false );
		attack.frames( frames, 0+addpixels, 2+addpixels, 3+addpixels, 4+addpixels, 0+addpixels );
		
		zap = attack.clone();
		
		die = new Animation( 5, false );
		die.frames( frames, 6+addpixels, 7+addpixels, 8+addpixels );
		
		play( idle );
	}
	
	@Override
	public int blood() {
		return Game.instance.getResources().getInteger(R.integer.livingplantblood);
	}
}
