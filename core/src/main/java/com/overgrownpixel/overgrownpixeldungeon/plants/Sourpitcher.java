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
import com.overgrownpixel.overgrownpixeldungeon.actors.Actor;
import com.overgrownpixel.overgrownpixeldungeon.actors.Char;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.Blob;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Buff;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Digesting;
import com.overgrownpixel.overgrownpixeldungeon.actors.mobs.PitcherPlant;
import com.overgrownpixel.overgrownpixeldungeon.effects.Pushing;
import com.overgrownpixel.overgrownpixeldungeon.effects.particles.poisonparticles.SourPitcherPoisonParticle;
import com.overgrownpixel.overgrownpixeldungeon.scenes.GameScene;
import com.overgrownpixel.overgrownpixeldungeon.sprites.items.ItemSpriteSheet;
import com.watabou.noosa.particles.Emitter;
import com.watabou.noosa.particles.PixelParticle;
import com.watabou.noosa.tweeners.AlphaTweener;

public class Sourpitcher extends Plant {

	{
		image = 51;
	}

    @Override
    public void attackProc(Char enemy, int damage) {
        Buff.prolong(enemy, Digesting.class, Digesting.DURATION);
    }

    @Override
    public void activate(Char ch) {
        Buff.prolong(ch, Digesting.class, Digesting.DURATION);
    }

    @Override
    public void activate() {
        PitcherPlant pitcherPlant = new PitcherPlant();
        pitcherPlant.pos = pos;
        pitcherPlant.spawn(Dungeon.depth, 0);
        GameScene.add( pitcherPlant );
        Actor.addDelayed( new Pushing( pitcherPlant, pos, pos ), -1f );

        pitcherPlant.sprite.alpha( 0 );
        pitcherPlant.sprite.parent.add( new AlphaTweener( pitcherPlant.sprite, 1, 0.15f ) );
    }

    @Override
    public void spiceEffect(Char ch) {
        ch.sprite.burst(new SourPitcherPoisonParticle().getColor(), 10);
        Buff.prolong(ch, Digesting.class, 2f);
    }

    @Override
    public Blob immunity() {
        return null;
    }

    public static class Seed extends Plant.Seed{

		{
			image = ItemSpriteSheet.NEWSEEDS_SOURPITCHER;

			plantClass = Sourpitcher.class;
		}

        @Override
        public void procEffect(Char attacker, Char defender, int damage) {
            attacker.HP += Math.round(damage/2);
            if(attacker.HP > attacker.HT) attacker.HP = attacker.HT;
            defender.damage(Math.round(damage/2), attacker);
        }

        @Override
        public Emitter.Factory getPixelParticle() {
            return SourPitcherPoisonParticle.FACTORY;
        }

        @Override
        public PixelParticle poisonEmitterClass() {
            return new SourPitcherPoisonParticle();
        }

        @Override
		public int price() {
			return 30 * quantity;
		}
	}
}
