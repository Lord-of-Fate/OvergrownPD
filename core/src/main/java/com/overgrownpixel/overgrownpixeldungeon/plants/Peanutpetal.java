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

package com.overgrownpixel.overgrownpixeldungeon.plants;

import com.overgrownpixel.overgrownpixeldungeon.Dungeon;
import com.overgrownpixel.overgrownpixeldungeon.actors.Char;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.Blob;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Buff;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.MarkOfTheNut;
import com.overgrownpixel.overgrownpixeldungeon.effects.particles.poisonparticles.PeanutpetalPoisonParticle;
import com.overgrownpixel.overgrownpixeldungeon.items.food.Peanut;
import com.overgrownpixel.overgrownpixeldungeon.sprites.items.ItemSpriteSheet;
import com.watabou.noosa.particles.Emitter;
import com.watabou.noosa.particles.PixelParticle;

public class Peanutpetal extends Plant {

	{
		image = 34;
	}

    @Override
    public void attackProc(Char enemy, int damage) {
        Buff.prolong(enemy, MarkOfTheNut.class, MarkOfTheNut.DURATION);
    }

    @Override
    public void activate(Char ch) {
        Buff.prolong(ch, MarkOfTheNut.class, MarkOfTheNut.DURATION);
    }

    @Override
    public void activate() {
        Dungeon.level.drop(new Peanut(), pos).sprite.drop(pos);
    }

    @Override
    public void spiceEffect(Char ch) {
        ch.sprite.burst(new PeanutpetalPoisonParticle().getColor(), 10);
        Buff.prolong(ch, MarkOfTheNut.class, 2f);
    }

    @Override
    public Blob immunity() {
        return null;
    }

    public static class Seed extends Plant.Seed{

		{
			image = ItemSpriteSheet.NEWSEEDS_PEANUTPETAL;

			plantClass = Peanutpetal.class;
		}

        @Override
        public void procEffect(Char attacker, Char defender, int damage) {
		    int d = defender.HP;
            if(d - damage <= 0){
                Dungeon.level.drop(new Peanut(), defender.pos).sprite.drop(defender.pos);
            }
        }

        @Override
        public Emitter.Factory getPixelParticle() {
            return PeanutpetalPoisonParticle.FACTORY;
        }

        @Override
        public PixelParticle poisonEmitterClass() {
            return new PeanutpetalPoisonParticle();
        }

        @Override
		public int price() {
			return 30 * quantity;
		}
	}
}
