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

import com.overgrownpixel.overgrownpixeldungeon.actors.Char;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.Blob;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.Dirtcloud;
import com.overgrownpixel.overgrownpixeldungeon.effects.particles.poisonparticles.DirtdaisyPoisonParticle;
import com.overgrownpixel.overgrownpixeldungeon.scenes.GameScene;
import com.overgrownpixel.overgrownpixeldungeon.sprites.items.ItemSpriteSheet;
import com.watabou.noosa.particles.Emitter;
import com.watabou.noosa.particles.PixelParticle;

public class Dirtdaisy extends Plant {

	{
		image = 58;
	}

    @Override
    public void attackProc(Char enemy, int damage) {
        GameScene.add(Blob.seed(enemy.pos, damage+1, Dirtcloud.class));
    }

    @Override
    public void activate(Char ch) {
        GameScene.add(Blob.seed(ch.pos, 20, Dirtcloud.class));
    }

    @Override
    public void activate() {
        GameScene.add(Blob.seed(pos, 20, Dirtcloud.class));
    }

    @Override
    public Blob immunity() {
        return null;
    }

    public static class Seed extends Plant.Seed{

		{
			image = ItemSpriteSheet.SEED_DIRTDAISY;

			plantClass = Dirtdaisy.class;
		}

        @Override
        public void procEffect(Char attacker, Char defender, int damage) {
            GameScene.add(Blob.seed(defender.pos, damage+1, Dirtcloud.class));
        }

        @Override
        public Emitter.Factory getPixelParticle() {
            return DirtdaisyPoisonParticle.FACTORY;
        }

        @Override
        public PixelParticle poisonEmitterClass() {
            return new DirtdaisyPoisonParticle();
        }

        @Override
		public int price() {
			return 30 * quantity;
		}
	}
}