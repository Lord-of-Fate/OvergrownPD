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

package com.overgrownpixel.overgrownpixeldungeon.items.spells;

import com.overgrownpixel.overgrownpixeldungeon.Dungeon;
import com.overgrownpixel.overgrownpixeldungeon.R;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Invisibility;
import com.overgrownpixel.overgrownpixeldungeon.actors.hero.Hero;
import com.overgrownpixel.overgrownpixeldungeon.actors.mobs.LivingPlant;
import com.overgrownpixel.overgrownpixeldungeon.actors.mobs.Mob;
import com.overgrownpixel.overgrownpixeldungeon.effects.Flare;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.exotic.PotionOfEarthenArmor;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfLullaby;
import com.overgrownpixel.overgrownpixeldungeon.messages.Messages;
import com.overgrownpixel.overgrownpixeldungeon.sprites.items.ItemSpriteSheet;
import com.overgrownpixel.overgrownpixeldungeon.utils.GLog;
import com.watabou.noosa.Game;

public class NaturesLullaby extends Spell {
	
	{
		image = ItemSpriteSheet.NATURES_LULLABY;
	}

    @Override
    protected void onCast(Hero hero) {
        new Flare(8, 14).color(Game.instance.getResources().getInteger(R.integer.natureslullaby),true).show(hero.sprite, 0.5f);
        Invisibility.dispel();
        GLog.h(Messages.get(this, "sleep"));
        for(Mob mob : Dungeon.level.mobs.toArray(new Mob[0])){
            if(mob instanceof LivingPlant){
                if(Dungeon.level.heroFOV[mob.pos]){
                    ((LivingPlant) mob).becomePlant = true;
                }
            }
        }
        detach( curUser.belongings.backpack );
        updateQuickslot();

    }

	@Override
	public int price() {
		//prices of ingredients, divided by output quantity
		return Math.round(quantity * ((30 + 50) / 6f));
	}

    public static class Recipe extends com.overgrownpixel.overgrownpixeldungeon.items.Recipe.SimpleRecipe {
		
		{
			inputs =  new Class[]{ScrollOfLullaby.class, PotionOfEarthenArmor.class};
			inQuantity = new int[]{1, 1};
			
			cost = 3;
			
			output = NaturesLullaby.class;
			outQuantity = 6;
		}
		
	}
}
