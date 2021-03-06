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

import com.overgrownpixel.overgrownpixeldungeon.Assets;
import com.overgrownpixel.overgrownpixeldungeon.Dungeon;
import com.overgrownpixel.overgrownpixeldungeon.R;
import com.overgrownpixel.overgrownpixeldungeon.actors.Actor;
import com.overgrownpixel.overgrownpixeldungeon.actors.Char;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Invisibility;
import com.overgrownpixel.overgrownpixeldungeon.actors.hero.Hero;
import com.overgrownpixel.overgrownpixeldungeon.effects.MagicMissile;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.CrimsonEpithet;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.TargetedSpell;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.Weapon;
import com.overgrownpixel.overgrownpixeldungeon.mechanics.Ballistica;
import com.overgrownpixel.overgrownpixeldungeon.messages.Messages;
import com.overgrownpixel.overgrownpixeldungeon.scenes.CellSelector;
import com.overgrownpixel.overgrownpixeldungeon.scenes.GameScene;
import com.overgrownpixel.overgrownpixeldungeon.sprites.items.ItemSprite;
import com.overgrownpixel.overgrownpixeldungeon.ui.QuickSlotButton;
import com.overgrownpixel.overgrownpixeldungeon.utils.GLog;
import com.watabou.noosa.Game;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Callback;

public class Teleporting extends Weapon.Enchantment {

    protected static int collisionProperties = Ballistica.PROJECTILE;
    protected static Hero curUser = null;
    protected static Weapon curWeapon = null;
    protected static Weapon.Enchantment curEnchantment = null;

	private static ItemSprite.Glowing COLOR = new ItemSprite.Glowing( Game.instance.getResources().getInteger(R.integer.teleporting) );
	
	@Override
	public int proc(Weapon weapon, Char attacker, Char defender, int damage ) {

	    weapon.hasTeleport = true;
        GLog.p(Messages.get(this, "has_teleport"), Messages.capitalize(weapon.trueName()));

		return damage/2;

	}

    public void teleport(Char attacker, Weapon weapon){
        curUser = (Hero) attacker;
        curWeapon = weapon;
        curEnchantment = this;
        weapon.hasTeleport = false;
        GameScene.selectCell(targeter);
    }

    @Override
    public void affectTarget(Ballistica bolt, Hero hero) {
	    if(Dungeon.level.distance(hero.pos, bolt.collisionPos) > curWeapon.level()){
            GLog.w( Messages.get(this, "too_far") );
            return;
        }
        final Char ch = Actor.findChar(bolt.collisionPos);

        if(ch != null){
            if(!ch.properties().contains(Char.Property.IMMOVABLE)){
                int chPos = ch.pos;
                int heroPos = hero.pos;
                ScrollOfTeleportation.appear(ch, heroPos);
                ScrollOfTeleportation.appear(hero, chPos);
            } else {
                GLog.w( Messages.get(CrimsonEpithet.class, "tele_fail") );
            }
        } else {
            ScrollOfTeleportation.appear(hero, bolt.collisionPos);
        }
    }

    protected static void fx(Ballistica bolt, Callback callback ) {
        MagicMissile.boltFromChar( curUser.sprite.parent,
                MagicMissile.MAGIC_MISSILE,
                curUser.sprite,
                bolt.collisionPos,
                callback);
        Sample.INSTANCE.play( Assets.SND_ZAP );
    }

    private static CellSelector.Listener targeter = new  CellSelector.Listener(){

        @Override
        public void onSelect( Integer target ) {

            if (target != null) {

                final Ballistica shot = new Ballistica( curUser.pos, target, collisionProperties);
                int cell = shot.collisionPos;

                curUser.sprite.zap(cell);

                //attempts to target the cell aimed at if something is there, otherwise targets the collision pos.
                if (Actor.findChar(target) != null)
                    QuickSlotButton.target(Actor.findChar(target));
                else
                    QuickSlotButton.target(Actor.findChar(cell));

                curUser.busy();
                Invisibility.dispel();

                fx(shot, new Callback() {
                    public void call() {
                        curEnchantment.affectTarget(shot, curUser);
                        curUser.spendAndNext( 1f );
                    }
                });

            }

        }

        @Override
        public String prompt() {
            return Messages.get(TargetedSpell.class, "prompt");
        }
    };
	
	@Override
	public ItemSprite.Glowing glowing() {
		return COLOR;
	}
}
