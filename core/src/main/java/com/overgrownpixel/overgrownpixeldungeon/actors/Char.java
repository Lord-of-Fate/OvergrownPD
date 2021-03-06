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

package com.overgrownpixel.overgrownpixeldungeon.actors;

import com.overgrownpixel.overgrownpixeldungeon.Assets;
import com.overgrownpixel.overgrownpixeldungeon.Dungeon;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.Blob;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.Electricity;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.FiendFire;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.Fire;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.Miasma;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.PoisonGas;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.ToxicGas;
import com.overgrownpixel.overgrownpixeldungeon.actors.blobs.UnfilteredSunlight;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Adrenaline;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.ArcaneArmor;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Balling;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.BeetleInfected;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Bleeding;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Bless;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Buff;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Burning;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Charm;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Chill;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Cocoshield;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Corrosion;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Corruption;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Cripple;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Dehydrated;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Doom;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Drunk;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.EarthImbue;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Feelers;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.FiendBurning;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.FireImbue;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Frost;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.FrostImbue;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.HalomethaneBurning;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Haste;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.HeatAura;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.HellBurning;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.High;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Honeyed;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Hunger;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.IceAura;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.IronSkin;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.MagicalShield;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.MagicalSleep;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.MarkOfTheNut;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Numb;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Ooze;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Paralysis;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.ParasiticInfection;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.ParasiticSymbiosis;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.PlagueAura;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Poison;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Preparation;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.RoseBarrier;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Secreting;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Shadow;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Shield;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.ShieldBuff;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Slippery;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Slow;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.SoulFire;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.SpaceTimePowers;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Speed;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Sprouting;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Stamina;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Stunned;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.SugarRush;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.SuperBalling;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Terror;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.TrailOfFire;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Vertigo;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.VitaminSuper;
import com.overgrownpixel.overgrownpixeldungeon.actors.buffs.Wither;
import com.overgrownpixel.overgrownpixeldungeon.actors.hero.Hero;
import com.overgrownpixel.overgrownpixeldungeon.actors.hero.HeroSubClass;
import com.overgrownpixel.overgrownpixeldungeon.actors.mobs.Mob;
import com.overgrownpixel.overgrownpixeldungeon.actors.mobs.Shaman;
import com.overgrownpixel.overgrownpixeldungeon.items.BrokenSeal;
import com.overgrownpixel.overgrownpixeldungeon.items.armor.glyphs.AntiMagic;
import com.overgrownpixel.overgrownpixeldungeon.items.armor.glyphs.Brimstone;
import com.overgrownpixel.overgrownpixeldungeon.items.armor.glyphs.Potential;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfFirelightning;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfLightning;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.exotic.PotionOfBallLightning;
import com.overgrownpixel.overgrownpixeldungeon.items.rings.RingOfElements;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfRetribution;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.exotic.ScrollOfPsionicBlast;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.StoneOfAggression;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfFireblast;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfLightning;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.enchantments.Blazing;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.enchantments.Grim;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.enchantments.Shocking;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.MissileWeapon;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.ShockingDart;
import com.overgrownpixel.overgrownpixeldungeon.levels.Level;
import com.overgrownpixel.overgrownpixeldungeon.levels.Terrain;
import com.overgrownpixel.overgrownpixeldungeon.levels.features.Chasm;
import com.overgrownpixel.overgrownpixeldungeon.levels.features.Door;
import com.overgrownpixel.overgrownpixeldungeon.levels.traps.GrimTrap;
import com.overgrownpixel.overgrownpixeldungeon.messages.Messages;
import com.overgrownpixel.overgrownpixeldungeon.scenes.GameScene;
import com.overgrownpixel.overgrownpixeldungeon.sprites.CharSprite;
import com.overgrownpixel.overgrownpixeldungeon.utils.GLog;
import com.watabou.noosa.Camera;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundlable;
import com.watabou.utils.Bundle;
import com.watabou.utils.GameMath;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

import java.util.Arrays;
import java.util.HashSet;

public abstract class Char extends Actor {
	
	public int pos = 0;
	
	public CharSprite sprite;
	
	public String name = "mob";
	
	public int HT;
	public int HP;
	
	protected float baseSpeed	= 1;
	protected PathFinder.Path path;

	public int paralysed	    = 0;
	public boolean rooted		= false;
	public boolean flying		= false;
	public int invisible		= 0;
	
	//these are relative to the hero
	public enum Alignment{
		ENEMY,
		NEUTRAL,
		ALLY
	}
	public Alignment alignment;
	
	public int viewDistance	= 8;
	
	public boolean[] fieldOfView = null;
	
	private HashSet<Buff> buffs = new HashSet<>();
	
	@Override
	protected boolean act() {
		if (fieldOfView == null || fieldOfView.length != Dungeon.level.length()){
			fieldOfView = new boolean[Dungeon.level.length()];
		}
		Dungeon.level.updateFieldOfView( this, fieldOfView );
		return false;
	}
	
	protected static final String POS       = "pos";
	protected static final String TAG_HP    = "HP";
	protected static final String TAG_HT    = "HT";
	protected static final String TAG_SHLD  = "SHLD";
	protected static final String BUFFS	    = "buffs";
	
	@Override
	public void storeInBundle( Bundle bundle ) {
		
		super.storeInBundle( bundle );
		
		bundle.put( POS, pos );
		bundle.put( TAG_HP, HP );
		bundle.put( TAG_HT, HT );
		bundle.put( BUFFS, buffs );
	}
	
	@Override
	public void restoreFromBundle( Bundle bundle ) {
		
		super.restoreFromBundle( bundle );
		
		pos = bundle.getInt( POS );
		HP = bundle.getInt( TAG_HP );
		HT = bundle.getInt( TAG_HT );
		
		for (Bundlable b : bundle.getCollection( BUFFS )) {
			if (b != null) {
				((Buff)b).attachTo( this );
			}
		}
		
		//pre-0.7.0
		if (bundle.contains( "SHLD" )){
			int legacySHLD = bundle.getInt( "SHLD" );
			//attempt to find the buff that may have given the shield
			ShieldBuff buff = buff(Brimstone.BrimstoneShield.class);
			if (buff != null) legacySHLD -= buff.shielding();
			if (legacySHLD > 0){
				BrokenSeal.WarriorShield buff2 = buff(BrokenSeal.WarriorShield.class);
				if (buff != null) buff2.supercharge(legacySHLD);
			}
		}
	}
	
	public boolean attack( Char enemy ) {

		if (enemy == null) return false;

		if(buff(Shadow.class) != null && !this.isImmune(Shadow.class)){
		    return false;
        }
		
		boolean visibleFight = Dungeon.level.heroFOV[pos] || Dungeon.level.heroFOV[enemy.pos];
		
		if (hit( this, enemy, false )) {
			
			int dr = enemy.drRoll();
			
			if (this instanceof Hero){
				Hero h = (Hero)this;
				if (h.belongings.weapon instanceof MissileWeapon
						&& h.subClass == HeroSubClass.SNIPER
						&& !Dungeon.level.adjacent(h.pos, enemy.pos)){
					dr = 0;
				}
			}
			
			int dmg;
			Preparation prep = buff(Preparation.class);
			if (prep != null){
				dmg = prep.damageRoll(this, enemy);
			} else {
				dmg = damageRoll();
			}
			
			int effectiveDamage = enemy.defenseProc( this, dmg );
			effectiveDamage = Math.max( effectiveDamage - dr, 0 );
			effectiveDamage = attackProc( enemy, effectiveDamage );
			
			if (visibleFight) {
				Sample.INSTANCE.play( Assets.SND_HIT, 1, 1, Random.Float( 0.8f, 1.25f ) );
			}

			// If the enemy is already dead, interrupt the attack.
			// This matters as defence procs can sometimes inflict self-damage, such as armor glyphs.
			if (!enemy.isAlive()){
				return true;
			}

			//TODO: consider revisiting this and shaking in more cases.
			float shake = 0f;
			if (enemy == Dungeon.hero)
				shake = effectiveDamage / (enemy.HT / 4);

			if (shake > 1f)
				Camera.main.shake( GameMath.gate( 1, shake, 5), 0.3f );

			enemy.damage( effectiveDamage, this );

			if (buff(FireImbue.class) != null)
				buff(FireImbue.class).proc(enemy);
			if (buff(EarthImbue.class) != null)
				buff(EarthImbue.class).proc(enemy);
			if (buff(FrostImbue.class) != null)
				buff(FrostImbue.class).proc(enemy);

			enemy.sprite.bloodBurstA( sprite.center(), effectiveDamage );
			enemy.sprite.flash();

			if (!enemy.isAlive() && visibleFight) {
				if (enemy == Dungeon.hero) {
					
					if (this == Dungeon.hero) {
						return true;
					}

					Dungeon.fail( getClass() );
					GLog.n( Messages.capitalize(Messages.get(Char.class, "kill", name)) );
					
				} else if (this == Dungeon.hero) {
					GLog.i( Messages.capitalize(Messages.get(Char.class, "defeat", enemy.name)) );
				}
			}
			
			return true;
			
		} else {
			
			if (visibleFight) {
				String defense = enemy.defenseVerb();
				enemy.sprite.showStatus( CharSprite.NEUTRAL, defense );
				
				Sample.INSTANCE.play(Assets.SND_MISS);
			}
			
			return false;
			
		}
	}
	
	public static boolean hit( Char attacker, Char defender, boolean magic ) {
	    if(attacker.buff(SpaceTimePowers.class) != null) return true;
		float acuRoll = Random.Float( attacker.attackSkill( defender ) );
		float defRoll = Random.Float( defender.defenseSkill( attacker ) );
		if (attacker.buff(Bless.class) != null) acuRoll *= 1.20f;
        if (attacker.buff(MarkOfTheNut.class) != null) acuRoll *= 2f;
		if (defender.buff(Bless.class) != null) defRoll *= 1.20f;
        if (defender.buff(VitaminSuper.class) != null) defRoll *= 5f;
        if (defender.buff(Drunk.class) != null) defRoll *= 1.50f;
		return (magic ? acuRoll * 2 : acuRoll) >= defRoll;
	}
	
	public int attackSkill( Char target ) {
		return 0;
	}
	
	public int defenseSkill( Char enemy ) {
		return 0;
	}
	
	public String defenseVerb() {
		return Messages.get(this, "def_verb");
	}
	
	public int drRoll() {
		return 0;
	}
	
	public int damageRoll() {
		return 1;
	}
	
	public int attackProc( Char enemy, int damage ) {
        if(enemy.buff(MagicalShield.class) != null){
            return 0;
        }
        if ( buff( Wither.class ) != null ) Math.round(damage /= 2f);
        if ( buff(Feelers.class ) != null ) Math.round(damage *= 2f);
        if ( buff(Drunk.class ) != null ) Math.round(damage *= 2f);
		return damage;
	}
	
	public int defenseProc( Char enemy, int damage ) {
		return damage;
	}
	
	public float speed() {
		float speed = baseSpeed;
		if ( buff( Cripple.class ) != null ) speed /= 2f;
		if ( buff( Stamina.class ) != null) speed *= 1.5f;
		if ( buff( Adrenaline.class ) != null) speed *= 2f;
		if ( buff( Haste.class ) != null) speed *= 3f;
        if ( buff( Dehydrated.class ) != null ) speed /= 2f;
        if ( buff( ParasiticInfection.class ) != null) speed /= 2f;
        if ( buff( ParasiticSymbiosis.class ) != null) speed *= 2f;
        if ( buff( MarkOfTheNut.class ) != null) speed /= 2f;
        if ( buff( Sprouting.class ) != null) speed /= 2f;
        if ( buff( Stunned.class ) != null) speed /= 8f;
        if ( buff( Honeyed.class ) != null) speed /= 6f;
        if ( buff( SugarRush.class ) != null) speed *= 6f;
        if ( buff( Drunk.class ) != null) speed /= 3f;
		return speed;
	}
	
	//used so that buffs(Shieldbuff.class) isn't called every time unnecessarily
	private int cachedShield = 0;
	public boolean needsShieldUpdate = true;
	
	public int shielding(){
		if (!needsShieldUpdate){
			return cachedShield;
		}
		
		cachedShield = 0;
		for (ShieldBuff s : buffs(ShieldBuff.class)){
			cachedShield += s.shielding();
		}
		needsShieldUpdate = false;
		return cachedShield;
	}
	
	public void damage( int dmg, Object src ) {

	    //you recieve no damage while burning and having the trail of fire buff
	    if(buff(TrailOfFire.class) != null && buff(Burning.class) != null){
	        return;
        }

        if(buff(RoseBarrier.class) != null && !this.isImmune(RoseBarrier.class)){
            return;
        }

        if(buff(Shield.class) != null && !this.isImmune(Shield.class)){
            return;
        }

        if(buff(Cocoshield.class) != null && !this.isImmune(Cocoshield.class)){
            return;
        }

        if(buff(Numb.class) != null && !this.isImmune(Numb.class)){
            dmg /= 2;
        }
		
		if (!isAlive() || dmg < 0) {
			return;
		}
		Terror t = buff(Terror.class);
		if (t != null){
			t.recover();
		}
		Charm c = buff(Charm.class);
		if (c != null){
			c.recover();
		}
        if (this.buff(IronSkin.class) != null  && !this.isImmune(IronSkin.class)){
            dmg = 1;
        }
		if (this.buff(Frost.class) != null){
			Buff.detach( this, Frost.class );
		}
		if (this.buff(MagicalSleep.class) != null){
			Buff.detach(this, MagicalSleep.class);
		}
		if (this.buff(Doom.class) != null && !this.isImmune(Doom.class)){
			dmg *= 2;
		}
        if (this.buff(SoulFire.class) != null && !this.isImmune(SoulFire.class)){
            dmg *= 2;
        }
		
		Class<?> srcClass = src.getClass();
		if (isImmune( srcClass )) {
			dmg = 0;
		} else {
			dmg = Math.round( dmg * resist( srcClass ));
		}
		
		//TODO improve this when I have proper damage source logic
		if (AntiMagic.RESISTS.contains(src.getClass()) && buff(ArcaneArmor.class) != null){
			dmg -= Random.NormalIntRange(0, buff(ArcaneArmor.class).level());
			if (dmg < 0) dmg = 0;
		}
		
		if (buff( Paralysis.class ) != null) {
			buff( Paralysis.class ).processDamage(dmg);
		}

        if (buff( BeetleInfected.class ) != null && !this.isImmune(BeetleInfected.class)) {
            dmg += 2;
        }

		int shielded = dmg;
		//FIXME: when I add proper damage properties, should add an IGNORES_SHIELDS property to use here.
		if (!(src instanceof Hunger)){
			for (ShieldBuff s : buffs(ShieldBuff.class)){
				dmg = s.absorbDamage(dmg);
				if (dmg == 0) break;
			}
		}
		shielded -= dmg;
		HP -= dmg;
		
		sprite.showStatus( HP > HT / 2 ?
			CharSprite.WARNING :
			CharSprite.NEGATIVE,
			Integer.toString( dmg + shielded ) );

		if (HP < 0) HP = 0;

		if (!isAlive()
                //you cant die when you have soulfire
                && this.buff(SoulFire.class) == null) {
			die( src );
		}
	}
	
	public void destroy() {
		HP = 0;
		Actor.remove( this );
	}
	
	public void die( Object src ) {
		destroy();
		if (src != Chasm.class) sprite.die();
	}
	
	public boolean isAlive() {
		return HP > 0;
	}
	
	@Override
	protected void spend( float time ) {
		
		float timeScale = 1f;
		if (buff( Slow.class ) != null) {
			timeScale *= 0.5f;
			//slowed and chilled do not stack
		} else if (buff( Chill.class ) != null) {
			timeScale *= buff( Chill.class ).speedFactor();
		}
		if (buff( Speed.class ) != null) {
			timeScale *= 2.0f;
		}
		
		super.spend( time / timeScale );
	}
	
	public synchronized HashSet<Buff> buffs() {
		return new HashSet<>(buffs);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized <T extends Buff> HashSet<T> buffs( Class<T> c ) {
		HashSet<T> filtered = new HashSet<>();
		for (Buff b : buffs) {
			if (c.isInstance( b )) {
				filtered.add( (T)b );
			}
		}
		return filtered;
	}

	@SuppressWarnings("unchecked")
	public synchronized  <T extends Buff> T buff( Class<T> c ) {
		for (Buff b : buffs) {
			if (c.isInstance( b )) {
				return (T)b;
			}
		}
		return null;
	}

	public synchronized boolean isCharmedBy( Char ch ) {
		int chID = ch.id();
		for (Buff b : buffs) {
			if (b instanceof Charm && ((Charm)b).object == chID) {
				return true;
			}
		}
		return false;
	}

	public synchronized void add( Buff buff ) {
		
		buffs.add( buff );
		Actor.add( buff );

		if (sprite != null && buff.announced)
			switch(buff.type){
				case POSITIVE:
					sprite.showStatus(CharSprite.POSITIVE, buff.toString());
					break;
				case NEGATIVE:
					sprite.showStatus(CharSprite.NEGATIVE, buff.toString());
					break;
				case NEUTRAL: default:
					sprite.showStatus(CharSprite.NEUTRAL, buff.toString());
					break;
			}

	}
	
	public synchronized void remove( Buff buff ) {
		
		buffs.remove( buff );
		Actor.remove( buff );

	}
	
	public synchronized void remove( Class<? extends Buff> buffClass ) {
		for (Buff buff : buffs( buffClass )) {
			remove( buff );
		}
	}
	
	@Override
	protected synchronized void onRemove() {
		for (Buff buff : buffs.toArray(new Buff[buffs.size()])) {
			buff.detach();
		}
	}
	
	public synchronized void updateSpriteState() {
		for (Buff buff:buffs) {
			buff.fx( true );
		}
	}
	
	public float stealth() {
		return 0;
	}
	
	public void move( int step ) {

		if (Dungeon.level.adjacent( step, pos ) && (buff( Vertigo.class ) != null || buff( Secreting.class ) != null || buff(High.class) != null)) {
			sprite.interruptMotion();
			int newPos = pos + PathFinder.NEIGHBOURS8[Random.Int( 8 )];
			if (!(Dungeon.level.passable[newPos] || Dungeon.level.avoid[newPos]) || Actor.findChar( newPos ) != null)
				return;
			else {
				sprite.move(pos, newPos);
				step = newPos;
			}
		}

        if(buff(TrailOfFire.class) != null && !this.isImmune(TrailOfFire.class)){
            if(this instanceof Hero){
                for(Mob mob : Dungeon.hero.visibleEnemiesList()){
                    Buff.prolong(mob, Vertigo.class, Vertigo.DURATION);
                }
            }
            if(this instanceof Mob){
                if(Dungeon.hero != null && Dungeon.hero.visibleEnemiesList().contains(this)){
                    Buff.prolong(Dungeon.hero, Vertigo.class, Vertigo.DURATION);
                    for(Mob mob : Dungeon.hero.visibleEnemiesList()){
                        Buff.prolong(mob, Vertigo.class, Vertigo.DURATION);
                    }
                }
            }
        }

        if (Dungeon.level.adjacent( step, pos ) && (buff( Slippery.class ) != null)) {
            for(int p : PathFinder.NEIGHBOURS8){
                if(Dungeon.level.map[pos+p] == Terrain.CHASM){
                    sprite.interruptMotion();
                    sprite.move(pos, pos+p);
                    step = pos+p;
                }
            }
        }

        if(buff(TrailOfFire.class) != null && !this.isImmune(TrailOfFire.class)){
            GameScene.add(Blob.seed(pos, 1, Fire.class));
        }

        if(buff(Sprouting.class) != null && !this.isImmune(Sprouting.class)
                && (Dungeon.level.map[pos] == Terrain.GRASS || Dungeon.level.map[pos] == Terrain.EMPTY) ){
            Level.set( pos, Terrain.HIGH_GRASS );
            GameScene.updateMap( pos );
        }

		if (Dungeon.level.map[pos] == Terrain.OPEN_DOOR) {
			Door.leave( pos );
		}

		pos = step;
		
		if (flying && Dungeon.level.map[pos] == Terrain.DOOR) {
			Door.enter( pos );
		}
		
		if (this != Dungeon.hero) {
			sprite.visible = Dungeon.level.heroFOV[pos];
		}
		
		if (!flying) {
			Dungeon.level.press( pos, this );
		}

        if(buff(Balling.class) != null && !this.isImmune(Balling.class)){
            if(this instanceof Hero){
                for(Mob ch : ((Hero) this).visibleEnemiesList()){
                    Buff.prolong(ch, Balling.class, Balling.DURATION);
                }
            } else {
                for(Mob mob : Dungeon.level.mobs.toArray(new Mob[0])){
                    if(this.fieldOfView[mob.pos]){
                        Buff.prolong(mob, Balling.class, Balling.DURATION);
                    }
                }
                if(this.fieldOfView[Dungeon.hero.pos]){
                    Buff.prolong(Dungeon.hero, Balling.class, Balling.DURATION);
                }
            }
        }

        if(buff(SuperBalling.class) != null && !this.isImmune(SuperBalling.class)){
            if(this instanceof Hero){
                for(Mob ch : ((Hero) this).visibleEnemiesList()){
                    Buff.prolong(ch, Vertigo.class, Vertigo.DURATION);
                }
            } else {
                for(Mob mob : Dungeon.level.mobs.toArray(new Mob[0])){
                    if(this.fieldOfView[mob.pos]){
                        Buff.prolong(mob, Vertigo.class, Vertigo.DURATION);
                    }
                }
                if(this.fieldOfView[Dungeon.hero.pos]){
                    Buff.prolong(Dungeon.hero, Vertigo.class, Vertigo.DURATION);
                }
            }
        }

		if(buff(HeatAura.class) != null && !this.isImmune(HeatAura.class)){
		    for(int p : PathFinder.NEIGHBOURS9){
		        if(Dungeon.level.map[pos+p] == Terrain.WATER){
                    Level.set(pos+p, Terrain.EMPTY);
                }
            }
        }

        if(buff(IceAura.class) != null && !this.isImmune(IceAura.class)){
            if(this instanceof Hero){
                for(Mob mob : ((Hero) this).visibleEnemiesList()){
                    Buff.prolong( mob, Frost.class, Frost.duration( mob ) * Random.Float( 1.0f, 1.5f ) );
                }
            } else {
                for(Mob mob : Dungeon.level.mobs.toArray(new Mob[0])){
                    if(this.fieldOfView[mob.pos]){
                        if(mob != this){
                            Buff.prolong( mob, Frost.class, Frost.duration( mob ) * Random.Float( 1.0f, 1.5f ) );
                        }
                    }
                }
                if(this.fieldOfView[Dungeon.hero.pos]){
                    Buff.prolong( Dungeon.hero, Frost.class, Frost.duration( Dungeon.hero ) * Random.Float( 1.0f, 1.5f ) );
                }
            }
        }

        if(buff(PlagueAura.class) != null && !this.isImmune(PlagueAura.class)){
            if(this instanceof Hero){
                for(Mob mob : ((Hero) this).visibleEnemiesList()){
                    Buff.affect(mob, Doom.class);
                }
            } else {
                for(Mob mob : Dungeon.level.mobs.toArray(new Mob[0])){
                    if(this.fieldOfView[mob.pos]){
                        if(mob != this){
                            Buff.affect(mob, Doom.class);
                        }
                    }
                }
                if(this.fieldOfView[Dungeon.hero.pos]){
                    Buff.affect(Dungeon.hero, Doom.class);
                }
            }
        }
	}
	
	public int distance( Char other ) {
		return Dungeon.level.distance( pos, other.pos );
	}
	
	public void onMotionComplete() {
		//Does nothing by default
		//The main actor thread already accounts for motion,
		// so calling next() here isn't necessary (see Actor.process)
	}
	
	public void onAttackComplete() {
		next();
	}
	
	public void onOperateComplete() {
		next();
	}
	
	protected final HashSet<Class> resistances = new HashSet<>();
	
	//returns percent effectiveness after resistances
	//TODO currently resistances reduce effectiveness by a static 50%, and do not stack.
	public float resist( Class effect ){
		HashSet<Class> resists = new HashSet<>(resistances);
		for (Property p : properties()){
			resists.addAll(p.resistances());
		}
		for (Buff b : buffs()){
			resists.addAll(b.resistances());
		}
		
		float result = 1f;
		for (Class c : resists){
			if (c.isAssignableFrom(effect)){
				result *= 0.5f;
			}
		}
		return result * RingOfElements.resist(this, effect);
	}
	
	protected final HashSet<Class> immunities = new HashSet<>();
	
	public boolean isImmune(Class effect ){
		HashSet<Class> immunes = new HashSet<>(immunities);
		for (Property p : properties()){
			immunes.addAll(p.immunities());
		}
		for (Buff b : buffs()){
			immunes.addAll(b.immunities());
		}
		
		for (Class c : immunes){
			if (c.isAssignableFrom(effect)){
				return true;
			}
		}
		return false;
	}

	protected HashSet<Property> properties = new HashSet<>();

	public HashSet<Property> properties() {
		return new HashSet<>(properties);
	}

	public enum Property{
		BOSS ( new HashSet<Class>( Arrays.asList(Grim.class, GrimTrap.class, ScrollOfRetribution.class, ScrollOfPsionicBlast.class)),
				new HashSet<Class>( Arrays.asList(Corruption.class, StoneOfAggression.Aggression.class, Balling.class, SuperBalling.class) )),
		MINIBOSS ( new HashSet<Class>(),
				new HashSet<Class>( Arrays.asList(Corruption.class, Doom.class, Balling.class, SuperBalling.class) )),
		UNDEAD,
		DEMONIC ( new HashSet<Class>(),
                new HashSet<Class>( Arrays.asList(FiendBurning.class))),
		INORGANIC ( new HashSet<Class>(),
				new HashSet<Class>( Arrays.asList(Bleeding.class, ToxicGas.class, Poison.class) )),
        PLANT( new HashSet<Class>(),
                new HashSet<Class>(Arrays.asList(UnfilteredSunlight.class, Miasma.class))),
		BLOB_IMMUNE ( new HashSet<Class>(),
				new HashSet<Class>( Arrays.asList(Blob.class) )),
		FIERY ( new HashSet<Class>( Arrays.asList(WandOfFireblast.class)),
				new HashSet<Class>( Arrays.asList(Burning.class, Blazing.class, HalomethaneBurning.class, HellBurning.class, FiendFire.class, PotionOfFirelightning.class))),
		ACIDIC ( new HashSet<Class>( Arrays.asList(Corrosion.class)),
				new HashSet<Class>( Arrays.asList(Ooze.class, PoisonGas.class, ToxicGas.class))),
		ELECTRIC ( new HashSet<Class>( Arrays.asList(WandOfLightning.class, Shocking.class, Potential.class, Electricity.class, ShockingDart.class, Shaman.LightningBolt.class, PotionOfLightning.class, PotionOfBallLightning.class)),
				new HashSet<Class>()),
		IMMOVABLE;
		
		private HashSet<Class> resistances;
		private HashSet<Class> immunities;
		
		Property(){
			this(new HashSet<Class>(), new HashSet<Class>());
		}
		
		Property( HashSet<Class> resistances, HashSet<Class> immunities){
			this.resistances = resistances;
			this.immunities = immunities;
		}
		
		public HashSet<Class> resistances(){
			return new HashSet<>(resistances);
		}
		
		public HashSet<Class> immunities(){
			return new HashSet<>(immunities);
		}
	}
}
