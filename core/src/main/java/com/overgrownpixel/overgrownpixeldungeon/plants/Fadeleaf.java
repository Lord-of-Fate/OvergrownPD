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

package com.overgrownpixel.overgrownpixeldungeon.plants;

import com.overgrownpixel.overgrownpixeldungeon.Dungeon;
import com.overgrownpixel.overgrownpixeldungeon.actors.Char;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.Blob;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Buff;
import com.overgrownpixel.overgrownpixeldungeon.actors.hero.Hero;
import com.overgrownpixel.overgrownpixeldungeon.actors.hero.HeroSubClass;
import com.overgrownpixel.overgrownpixeldungeon.actors.mobs.Mob;
import com.overgrownpixel.overgrownpixeldungeon.effects.CellEmitter;
import com.overgrownpixel.overgrownpixeldungeon.effects.Speck;
import com.overgrownpixel.overgrownpixeldungeon.effects.particles.poisonparticles.ApricobushPoisonParticle;
import com.overgrownpixel.overgrownpixeldungeon.effects.particles.poisonparticles.FadeleafPoisonParticle;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.TimekeepersHourglass;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.overgrownpixel.overgrownpixeldungeon.messages.Messages;
import com.overgrownpixel.overgrownpixeldungeon.scenes.InterlevelScene;
import com.overgrownpixel.overgrownpixeldungeon.sprites.items.ItemSpriteSheet;
import com.overgrownpixel.overgrownpixeldungeon.utils.GLog;
import com.watabou.noosa.Game;
import com.watabou.noosa.particles.Emitter;
import com.watabou.noosa.particles.PixelParticle;

public class Fadeleaf extends Plant {
	
	{
		image = 10;
	}
	
	@Override
	public void activate( final Char ch ) {
		
		if (ch instanceof Hero) {
			
			((Hero)ch).curAction = null;
			
			if (((Hero) ch).subClass == HeroSubClass.WARDEN){
				
				if (Dungeon.bossLevel()) {
					GLog.w( Messages.get(ScrollOfTeleportation.class, "no_tele") );
					return;
					
				}
				
				Buff buff = Dungeon.hero.buff(TimekeepersHourglass.timeFreeze.class);
				if (buff != null) buff.detach();
				buff = Dungeon.hero.buff(Swiftthistle.TimeBubble.class);
				if (buff != null) buff.detach();
				
				InterlevelScene.mode = InterlevelScene.Mode.RETURN;
				InterlevelScene.returnDepth = Math.max(1, (Dungeon.depth - 1));
				InterlevelScene.returnPos = -2;
				Game.switchScene( InterlevelScene.class );
				
			} else {
				ScrollOfTeleportation.teleportHero((Hero) ch);
			}
			
		} else if (ch instanceof Mob && !ch.properties().contains(Char.Property.IMMOVABLE)) {

			int count = 10;
			int newPos;
			do {
				newPos = Dungeon.level.randomRespawnCell();
				if (count-- <= 0) {
					break;
				}
			} while (newPos == -1);
			
			if (newPos != -1 && !Dungeon.bossLevel()) {
			
				ch.pos = newPos;
				if (((Mob) ch).state == ((Mob) ch).HUNTING) ((Mob) ch).state = ((Mob) ch).WANDERING;
				ch.sprite.place( ch.pos );
				ch.sprite.visible = Dungeon.level.heroFOV[ch.pos];
				
			}

		}
		
		if (Dungeon.level.heroFOV[ch.pos]) {
			CellEmitter.get( ch.pos ).start( Speck.factory( Speck.LIGHT ), 0.2f, 3 );
		}
	}

    @Override
    public void activate() {
        spawnLasher(pos);
    }

    @Override
    public void spiceEffect(Char ch) {
        ch.sprite.burst(new ApricobushPoisonParticle().getColor(), 10);
        this.activate(ch);
    }

    @Override
    public void attackProc(Char enemy, int damage) {
        if (enemy instanceof Hero) {

            ((Hero)enemy).curAction = null;

            if (((Hero) enemy).subClass == HeroSubClass.WARDEN){

                if (Dungeon.bossLevel()) {
                    GLog.w( Messages.get(ScrollOfTeleportation.class, "no_tele") );
                    return;

                }

                Buff buff = Dungeon.hero.buff(TimekeepersHourglass.timeFreeze.class);
                if (buff != null) buff.detach();
                buff = Dungeon.hero.buff(Swiftthistle.TimeBubble.class);
                if (buff != null) buff.detach();

                InterlevelScene.mode = InterlevelScene.Mode.RETURN;
                InterlevelScene.returnDepth = Math.max(1, (Dungeon.depth - 1));
                InterlevelScene.returnPos = -2;
                Game.switchScene( InterlevelScene.class );

            } else {
                ScrollOfTeleportation.teleportHero((Hero) enemy);
            }

        } else if (enemy instanceof Mob && !enemy.properties().contains(Char.Property.IMMOVABLE)) {

            int count = 10;
            int newPos;
            do {
                newPos = Dungeon.level.randomRespawnCell();
                if (count-- <= 0) {
                    break;
                }
            } while (newPos == -1);

            if (newPos != -1 && !Dungeon.bossLevel()) {

                enemy.pos = newPos;
                if (((Mob) enemy).state == ((Mob) enemy).HUNTING) ((Mob) enemy).state = ((Mob) enemy).WANDERING;
                enemy.sprite.place( enemy.pos );
                enemy.sprite.visible = Dungeon.level.heroFOV[enemy.pos];

            }

        }

        if (Dungeon.level.heroFOV[enemy.pos]) {
            CellEmitter.get( enemy.pos ).start( Speck.factory( Speck.LIGHT ), 0.2f, 3 );
        }
    }

    @Override
    public Blob immunity() {
        return null;
    }
	
	public static class Seed extends Plant.Seed {
		{
			image = ItemSpriteSheet.NEWSEEDS_FADELEAF;

			plantClass = Fadeleaf.class;
		}

        @Override
        public Emitter.Factory getPixelParticle() {
            return FadeleafPoisonParticle.FACTORY;
        }

        @Override
        public PixelParticle poisonEmitterClass() {
            return new FadeleafPoisonParticle();
        }

        @Override
        public void procEffect(Char attacker, Char defender, int damage) {
            new Fadeleaf().attackProc(defender, damage);
        }
    }
}
