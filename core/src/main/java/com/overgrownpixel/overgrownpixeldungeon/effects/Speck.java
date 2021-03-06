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

import com.overgrownpixel.overgrownpixeldungeon.Assets;
import com.overgrownpixel.overgrownpixeldungeon.R;
import com.watabou.noosa.Game;
import com.watabou.noosa.Image;
import com.watabou.noosa.TextureFilm;
import com.watabou.noosa.particles.Emitter;
import com.watabou.utils.ColorMath;
import com.watabou.utils.PointF;
import com.watabou.utils.Random;
import com.watabou.utils.SparseArray;

public class Speck extends Image {

	public static final int HEALING     = 0;
	public static final int STAR        = 1;
	public static final int LIGHT       = 2;
	public static final int QUESTION    = 3;
	public static final int UP          = 4;
	public static final int SCREAM      = 5;
	public static final int BONE        = 6;
	public static final int WOOL        = 7;
	public static final int ROCK        = 8;
	public static final int NOTE        = 9;
	public static final int CHANGE      = 10;
	public static final int HEART       = 11;
	public static final int BUBBLE      = 12;
	public static final int STEAM       = 13;
	public static final int COIN        = 14;
	
	public static final int DISCOVER    = 101;
	public static final int EVOKE       = 102;
	public static final int MASTERY     = 103;
	public static final int KIT         = 104;
	public static final int RATTLE      = 105;
	public static final int JET         = 106;
	public static final int TOXIC       = 107;
	public static final int CORROSION   = 108;
	public static final int PARALYSIS   = 109;
	public static final int DUST        = 110;
	public static final int STENCH      = 111;
	public static final int FORGE       = 112;
	public static final int CONFUSION   = 113;
	public static final int RED_LIGHT   = 114;
	public static final int CALM        = 115;
	public static final int SMOKE       = 116;
	public static final int STORM       = 117;
	public static final int INFERNO     = 118;
	public static final int BLIZZARD    = 119;
    public static final int MIASMA      = 120;
    public static final int NECTAR      = 121;
    public static final int DEPRESSANT  = 122;
    public static final int FIREWIND    = 123;
    public static final int DIRTCLOUD   = 124;
    public static final int KNOWWIND    = 125;
    public static final int CLOUDOFCORR = 126;
    public static final int POPGAS      = 127;
    public static final int GLOWGAS     = 128;
    public static final int BALLGAS     = 129;
    public static final int FEAGAS      = 130;
    public static final int HIGHGAS     = 131;
    public static final int SLOW        = 132;
    public static final int SOWINGWIND  = 133;
    public static final int HARVESTWIND = 134;
	
	private static final int SIZE = 7;
	
	private int type;
	private float lifespan;
	private float left;
	
	private static TextureFilm film;
	
	private static SparseArray<Emitter.Factory> factories = new SparseArray<>();
	
	public Speck() {
		super();
		
		texture( Assets.SPECKS );
		if (film == null) {
			film = new TextureFilm( texture, SIZE, SIZE );
		}
		
		origin.set( SIZE / 2f );
	}
	
	public void reset( int index, float x, float y, int type ) {
		revive();
		
		this.type = type;
		switch (type) {
		case DISCOVER:
		case RED_LIGHT:
			frame( film.get( LIGHT ) );
			break;
		case EVOKE:
		case MASTERY:
		case KIT:
		case FORGE:
			frame( film.get( STAR ) );
			break;
		case RATTLE:
			frame( film.get( BONE ) );
			break;
		case JET:
		case TOXIC:
		case CORROSION:
		case PARALYSIS:
		case STENCH:
		case CONFUSION:
		case STORM:
		case DUST:
		case SMOKE:
		case BLIZZARD:
		case INFERNO:
            case DIRTCLOUD:
            case POPGAS:
            case CLOUDOFCORR:
            case KNOWWIND:
            case FIREWIND:
            case MIASMA:
            case NECTAR:
            case DEPRESSANT:
            case GLOWGAS:
            case BALLGAS:
            case FEAGAS:
            case HIGHGAS:
            case SLOW:
            case SOWINGWIND:
            case HARVESTWIND:
			frame( film.get( STEAM ) );
			break;
		case CALM:
			frame( film.get( SCREAM ) );
			break;
		default:
			frame( film.get( type ) );
		}
		
		this.x = x - origin.x;
		this.y = y - origin.y;
		
		resetColor();
		scale.set( 1 );
		speed.set( 0 );
		acc.set( 0 );
		angle = 0;
		angularSpeed = 0;
		
		switch (type) {
			
		case HEALING:
			speed.set( 0, -20 );
			lifespan = 1f;
			break;

            case MIASMA:
                hardlight( Game.instance.getResources().getInteger(R.integer.miasma) );
                angularSpeed = -30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 1f, 3f );
                break;

            case FIREWIND:
                hardlight( Game.instance.getResources().getInteger(R.integer.firewind) );
                angularSpeed = -30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 1f, 3f );
                break;

            case POPGAS:
                hardlight( Game.instance.getResources().getInteger(R.integer.poppoplarpoisonparticle) );
                angularSpeed = -30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 1f, 3f );
                break;

            case HARVESTWIND:
                hardlight( Game.instance.getResources().getInteger(R.integer.harvestwind) );
                angularSpeed = -30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 1f, 3f );
                break;

            case GLOWGAS:
                hardlight( Game.instance.getResources().getInteger(R.integer.chandaliertailoisonparticle) );
                angularSpeed = -30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 1f, 3f );
                break;

            case BALLGAS:
                hardlight( Game.instance.getResources().getInteger(R.integer.ballcroppoisonparticle) );
                angularSpeed = -30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 1f, 3f );
                break;

            case FEAGAS:
                hardlight( Game.instance.getResources().getInteger(R.integer.flesheatingacidcloud) );
                angularSpeed = -30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 1f, 2f );
                break;

            case HIGHGAS:
                hardlight( Game.instance.getResources().getInteger(R.integer.highsmoke) );
                angularSpeed = 30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 1f, 1.5f );
                break;

            case SLOW:
                hardlight( Game.instance.getResources().getInteger(R.integer.slowcloud) );
                angularSpeed = 30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 1f, 1.5f );
                break;

            case SOWINGWIND:
                hardlight( Game.instance.getResources().getInteger(R.integer.sowingwind) );
                angularSpeed = 30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 1f, 1.5f );
                break;

            case CLOUDOFCORR:
                hardlight( Game.instance.getResources().getInteger(R.integer.cloudofcorr) );
                angularSpeed = -30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 1f, 2f );
                break;

            case KNOWWIND:
                hardlight( Game.instance.getResources().getInteger(R.integer.knowwind) );
                angularSpeed = -30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 1f, 4f );
                break;

            case DIRTCLOUD:
                hardlight( Game.instance.getResources().getInteger(R.integer.dirtcloud) );
                angularSpeed = -30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 3f, 5f );
                break;

            case NECTAR:
                hardlight( Game.instance.getResources().getInteger(R.integer.nectar) );
                angularSpeed = -30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 0.5f, 1.5f );
                break;

            case DEPRESSANT:
                hardlight( Game.instance.getResources().getInteger(R.integer.depressant) );
                angularSpeed = -30;
                angle = Random.Float( 360 );
                lifespan = Random.Float( 3f, 5f );
                break;
			
		case STAR:
			speed.polar( Random.Float( 2 * 3.1415926f ), Random.Float( 128 ) );
			acc.set( 0, 128 );
			angle = Random.Float( 360 );
			angularSpeed = Random.Float( -360, +360 );
			lifespan = 1f;
			break;
		
		case FORGE:
			speed.polar( Random.Float( -3.1415926f ), Random.Float( 64 ) );
			acc.set( 0, 128 );
			angle = Random.Float( 360 );
			angularSpeed = Random.Float( -360, +360 );
			lifespan = 0.51f;
			break;
			
		case EVOKE:
			speed.polar( Random.Float( -3.1415926f ), 50 );
			acc.set( 0, 50 );
			angle = Random.Float( 360 );
			angularSpeed = Random.Float( -180, +180 );
			lifespan = 1f;
			break;
			
		case KIT:
			speed.polar( index * 3.1415926f / 5, 50 );
			acc.set( -speed.x, -speed.y );
			angle = index * 36;
			angularSpeed = 360;
			lifespan = 1f;
			break;
			
		case MASTERY:
			speed.set( Random.Int( 2 ) == 0 ? Random.Float( -128, -64 ) : Random.Float( +64, +128 ), 0 );
			angularSpeed = speed.x < 0 ? -180 : +180;
			acc.set( -speed.x, 0 );
			lifespan = 0.5f;
			break;

		case RED_LIGHT:
			tint(Game.instance.getResources().getInteger(R.integer.specktint));
		case LIGHT:
			angle = Random.Float( 360 );
			angularSpeed = 90;
			lifespan = 1f;
			break;
			
		case DISCOVER:
			angle = Random.Float( 360 );
			angularSpeed = 90;
			lifespan = 0.5f;
			am = 0;
			break;
			
		case QUESTION:
			lifespan = 0.8f;
			break;
			
		case UP:
			speed.set( 0, -20 );
			lifespan = 1f;
			break;
			
		case CALM:
			color(0, 1, 1);
		case SCREAM:
			lifespan = 0.9f;
			break;
			
		case BONE:
			lifespan = 0.2f;
			speed.polar( Random.Float( 2 * 3.1415926f ), 24 / lifespan );
			acc.set( 0, 128 );
			angle = Random.Float( 360 );
			angularSpeed = 360;
			break;
			
		case RATTLE:
			lifespan = 0.5f;
			speed.set( 0, -200 );
			acc.set( 0, -2 * speed.y / lifespan );
			angle = Random.Float( 360 );
			angularSpeed = 360;
			break;
			
		case WOOL:
			lifespan = 0.5f;
			speed.set( 0, -50 );
			angle = Random.Float( 360 );
			angularSpeed = Random.Float( -360, +360 );
			break;
			
		case ROCK:
			angle = Random.Float( 360 );
			angularSpeed = Random.Float( -360, +360 );
			scale.set( Random.Float( 1, 2 ) );
			speed.set( 0, 64 );
			lifespan = 0.2f;
			y -= speed.y * lifespan;
			break;
			
		case NOTE:
			angularSpeed = Random.Float( -30, +30 );
			speed.polar( (angularSpeed - 90) * PointF.G2R, 30 );
			lifespan = 1f;
			break;
			
		case CHANGE:
			angle = Random.Float( 360 );
			speed.polar( (angle - 90) * PointF.G2R, Random.Float( 4, 12 ) );
			lifespan = 1.5f;
			break;
			
		case HEART:
			speed.set( Random.Int( -10, +10 ), -40 );
			angularSpeed = Random.Float( -45, +45 );
			lifespan = 1f;
			break;
			
		case BUBBLE:
			speed.set( 0, -15 );
			scale.set( Random.Float( 0.8f, 1 ) );
			lifespan = Random.Float( 0.8f, 1.5f );
			break;
			
		case STEAM:
			speed.y = -Random.Float( 20, 30 );
			angularSpeed = Random.Float( +180 );
			angle = Random.Float( 360 );
			lifespan = 1f;
			break;
			
		case JET:
			speed.y = +32;
			acc.y = -64;
			angularSpeed = Random.Float( 180, 360 );
			angle = Random.Float( 360 );
			lifespan = 0.5f;
			break;
			
		case TOXIC:
			hardlight( Game.instance.getResources().getInteger(R.integer.speck1) );
			angularSpeed = 30;
			angle = Random.Float( 360 );
			lifespan = Random.Float( 1f, 3f );
			break;

		case CORROSION:
			hardlight( Game.instance.getResources().getInteger(R.integer.speck2) );
			angularSpeed = 30;
			angle = Random.Float( 360 );
			lifespan = Random.Float( 1f, 3f );
			break;
			
		case PARALYSIS:
			hardlight( Game.instance.getResources().getInteger(R.integer.speck3) );
			angularSpeed = -30;
			angle = Random.Float( 360 );
			lifespan = Random.Float( 1f, 3f );
			break;

		case STENCH:
			hardlight( Game.instance.getResources().getInteger(R.integer.speck4) );
			angularSpeed = -30;
			angle = Random.Float( 360 );
			lifespan = Random.Float( 1f, 3f );
			break;

		case CONFUSION:
			hardlight( Random.Int( Game.instance.getResources().getInteger(R.integer.speck5) ) | Game.instance.getResources().getInteger(R.integer.speck6) );
			angularSpeed = Random.Float( -20, +20 );
			angle = Random.Float( 360 );
			lifespan = Random.Float( 1f, 3f );
			break;
			
		case STORM:
			hardlight( Game.instance.getResources().getInteger(R.integer.speck7) );
			angularSpeed = Random.Float( -20, +20 );
			angle = Random.Float( 360 );
			lifespan = Random.Float( 1f, 3f );
			break;
			
		case INFERNO:
			hardlight( Game.instance.getResources().getInteger(R.integer.speck8) );
			angularSpeed = Random.Float( 200, 300 ) * (Random.Int(2) == 0 ? -1 : 1);
			angle = Random.Float( 360 );
			lifespan = Random.Float( 1f, 3f );
			break;
			
		case BLIZZARD:
			hardlight( Game.instance.getResources().getInteger(R.integer.speck9) );
			angularSpeed = Random.Float( 200, 300 ) * (Random.Int(2) == 0 ? -1 : 1);
			angle = Random.Float( 360 );
			lifespan = Random.Float( 1f, 3f );
			break;
			
		case SMOKE:
			hardlight( Game.instance.getResources().getInteger(R.integer.speck10) );
			angularSpeed = 30;
			angle = Random.Float( 360 );
			lifespan = Random.Float( 1f, 1.5f );
			break;

		case DUST:
			hardlight( Game.instance.getResources().getInteger(R.integer.speck11) );
			angle = Random.Float( 360 );
			speed.polar( Random.Float( 2 * 3.1415926f ), Random.Float( 16, 48 ) );
			lifespan = 0.5f;
			break;

		case COIN:
			speed.polar( -PointF.PI * Random.Float( 0.3f, 0.7f ), Random.Float( 48, 96 ) );
			acc.y = 256;
			lifespan = -speed.y / acc.y * 2;
			break;
		}
		
		left = lifespan;
	}
	
	@Override
	public void update() {
		super.update();
		
		left -= Game.elapsed;
		if (left <= 0) {
			
			kill();
			
		} else {
			
			float p = 1 - left / lifespan;	// 0 -> 1
			
			switch (type) {
				
			case STAR:
			case FORGE:
				scale.set( 1 - p );
				am = p < 0.2f ? p * 5f : (1 - p) * 1.25f;
				break;
				
			case KIT:
			case MASTERY:
				am = 1 - p * p;
				break;
				
			case EVOKE:
				
			case HEALING:
				am = p < 0.5f ? 1 : 2 - p * 2;
				break;

			case RED_LIGHT:
			case LIGHT:
				am = scale.set( p < 0.2f ? p * 5f : (1 - p) * 1.25f ).x;
				break;
				
			case DISCOVER:
				am = 1 - p;
				scale.set( (p < 0.5f ? p : 1 - p) * 2 );
				break;
				
			case QUESTION:
				scale.set( (float)(Math.sqrt( p < 0.5f ? p : 1 - p ) * 3) );
				break;
				
			case UP:
				scale.set( (float)(Math.sqrt( p < 0.5f ? p : 1 - p ) * 2) );
				break;
				
			case CALM:
			case SCREAM:
				am = (float)Math.sqrt( (p < 0.5f ? p : 1 - p) * 2f );
				scale.set( p * 7 );
				break;
				
			case BONE:
			case RATTLE:
				am = p < 0.9f ? 1 : (1 - p) * 10;
				break;
				
			case ROCK:
				am = p < 0.2f ? p * 5 : 1 ;
				break;
				
			case NOTE:
				am = 1 - p * p;
				break;
				
			case WOOL:
				scale.set( 1 - p );
				break;
				
			case CHANGE:
				am = (float)Math.sqrt( (p < 0.5f ? p : 1 - p) * 2);
				scale.y = (1 + p) * 0.5f;
				scale.x = scale.y * (float)Math.cos( left * 15 );
				break;
				
			case HEART:
				scale.set( 1 - p );
				am = 1 - p * p;
				break;
				
			case BUBBLE:
				am = p < 0.2f ? p * 5 : 1;
				break;
				
			case STEAM:
			case TOXIC:
			case PARALYSIS:
			case CONFUSION:
			case STORM:
			case BLIZZARD:
			case INFERNO:
			case DUST:
                case MIASMA:
                case KNOWWIND:
                case FIREWIND:
                case DIRTCLOUD:
                case DEPRESSANT:
                case SLOW:
                case SOWINGWIND:
                case HARVESTWIND:
				am = (float)Math.sqrt( (p < 0.5f ? p : 1 - p) * 0.5f );
				scale.set( 1 + p );
				break;

			case CORROSION:
				hardlight( ColorMath.interpolate( Game.instance.getResources().getInteger(R.integer.speckinterpolate1), Game.instance.getResources().getInteger(R.integer.speckinterpolate2) , p ));
			case STENCH:
			case SMOKE:
                case NECTAR:
                case CLOUDOFCORR:
                case POPGAS:
                case GLOWGAS:
                case BALLGAS:
                case FEAGAS:
                case HIGHGAS:
				am = (float)Math.sqrt( (p < 0.5f ? p : 1 - p) );
				scale.set( 1 + p );
				break;
				
			case JET:
				am = (p < 0.5f ? p : 1 - p) * 2;
				scale.set( p * 1.5f );
				break;
				
			case COIN:
				scale.x = (float)Math.cos( left * 5 );
				rm = gm = bm = (Math.abs( scale.x ) + 1) * 0.5f;
				am = p < 0.9f ? 1 : (1 - p) * 10;
				break;
			}
		}
	}

	public static Emitter.Factory factory( final int type ) {
		return factory( type, false );
	}

	public static Emitter.Factory factory( final int type, final boolean lightMode ) {

		Emitter.Factory factory = factories.get( type );

		if (factory == null) {
			factory = new Emitter.Factory() {
				@Override
				public void emit ( Emitter emitter, int index, float x, float y ) {
					Speck p = (Speck)emitter.recycle( Speck.class );
					p.reset( index, x, y, type );
				}
				@Override
				public boolean lightMode() {
					return lightMode;
				}
			};
			factories.put( type, factory );
		}

		return factory;
	}
}
