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

package com.overgrownpixel.overgrownpixeldungeon.effects;

import com.overgrownpixel.overgrownpixeldungeon.R;
import com.overgrownpixel.overgrownpixeldungeon.sprites.CharSprite;
import com.watabou.noosa.Game;
import com.watabou.noosa.Gizmo;

public class Shadow extends Gizmo {

	private float phase;

	private CharSprite target;

	public Shadow(CharSprite target ) {
		super();

		this.target = target;
		phase = 0;
	}
	
	@Override
	public void update() {
		super.update();

		if ((phase += Game.elapsed * 2) < 1) {
			target.tint( Game.instance.getResources().getInteger(R.integer.shadow), phase * 0.6f );
		} else {
			target.tint( Game.instance.getResources().getInteger(R.integer.shadow), 0.6f );
		}
	}
	
	public void dissapear() {

		target.resetColor();
		killAndErase();
	}
	
	public static Shadow cloak(CharSprite sprite ) {
		
		Shadow shadow = new Shadow( sprite );
		if (sprite.parent != null)
			sprite.parent.add( shadow );
		
		return shadow;
	}
}
