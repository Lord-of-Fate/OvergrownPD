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

package com.overgrownpixel.overgrownpixeldungeon.scenes;

import com.overgrownpixel.overgrownpixeldungeon.Assets;
import com.overgrownpixel.overgrownpixeldungeon.GamesInProgress;
import com.overgrownpixel.overgrownpixeldungeon.OGPDSettings;
import com.overgrownpixel.overgrownpixeldungeon.OvergrownPixelDungeon;
import com.overgrownpixel.overgrownpixeldungeon.R;
import com.overgrownpixel.overgrownpixeldungeon.effects.BannerSprites;
import com.overgrownpixel.overgrownpixeldungeon.messages.Messages;
import com.overgrownpixel.overgrownpixeldungeon.ui.Archs;
import com.overgrownpixel.overgrownpixeldungeon.ui.ChangesButton;
import com.overgrownpixel.overgrownpixeldungeon.ui.ExitButton;
import com.overgrownpixel.overgrownpixeldungeon.ui.LanguageButton;
import com.overgrownpixel.overgrownpixeldungeon.ui.PrefsButton;
import com.overgrownpixel.overgrownpixeldungeon.windows.WndStartGame;
import com.watabou.noosa.BitmapText;
import com.watabou.noosa.Camera;
import com.watabou.noosa.Game;
import com.watabou.noosa.Image;
import com.watabou.noosa.RenderedText;
import com.watabou.noosa.audio.Music;
import com.watabou.noosa.audio.Sample;
import com.watabou.noosa.ui.Button;
import com.watabou.utils.DeviceCompat;

public class TitleScene extends PixelScene {
	
	@Override
	public void create() {
		
		super.create();

		Music.INSTANCE.play( Assets.THEME, true );

		uiCamera.visible = false;
		
		int w = Camera.main.width;
		int h = Camera.main.height;
		
		Archs archs = new Archs();
		archs.setSize( w, h );
		add( archs );
		
		final Image title = new Image(BannerSprites.get( BannerSprites.Type.PIXEL_DUNGEON )){
            private float time = 0;
            @Override
            public void update() {
                super.update();
                int h = Camera.main.height;
                float topRegion = Math.max(95f, h*0.45f);
                if (OGPDSettings.landscape())
                    y = (topRegion - height()) / 2f;
                else
                    y = 16 + (topRegion - height() - 16) / 2f;
                y = y + (3 * Math.max(0f, (float)Math.sin( time += Game.elapsed )));
                if (time >= 1f*Math.PI) time = 0;
            }
        };
		add( title );

		float topRegion = Math.max(95f, h*0.45f);

		title.x = (w - title.width()) / 2f;
		if (OGPDSettings.landscape())
			title.y = (topRegion - title.height()) / 2f;
		else
			title.y = 16 + (topRegion - title.height() - 16) / 2f;

		align(title);

		Image signs = new Image( BannerSprites.get( BannerSprites.Type.PIXEL_DUNGEON_SIGNS ) ) {
			private float time = 0;
			@Override
			public void update() {
				super.update();
				am = Math.max(0f, (float)Math.sin( time += Game.elapsed ));
				y = title.y;
				angle = title.angle;
				scale.y = title.scale.y;
				scale.x = title.scale.x;
				if (time >= 1.5f*Math.PI) time = 0;
			}
		};
		signs.x = title.x + (title.width() - signs.width())/2f;
		signs.y = title.y;
		add( signs );
		
		DashboardItem btnBadges = new DashboardItem( Messages.get(this, "badges"), 3 ) {
			@Override
			protected void onClick() {
				OvergrownPixelDungeon.switchNoFade( BadgesScene.class );
			}
		};
		add(btnBadges);
		
		DashboardItem btnAbout = new DashboardItem( Messages.get(this, "about"), 1 ) {
			@Override
			protected void onClick() {
				OvergrownPixelDungeon.switchNoFade( AboutScene.class );
			}
		};
		add( btnAbout );
		
		DashboardItem btnPlay = new DashboardItem( Messages.get(this, "play"), 0 ) {
			@Override
			protected void onClick() {
				if (GamesInProgress.checkAll().size() == 0){
					TitleScene.this.add( new WndStartGame(1) );
				} else {
					OvergrownPixelDungeon.switchNoFade( StartScene.class );
				}
			}
			
			@Override
			protected boolean onLongClick() {
				//making it easier to start runs quickly while debugging
				if (DeviceCompat.isDebug()) {
					TitleScene.this.add( new WndStartGame(1) );
					return true;
				}
				return super.onLongClick();
			}
		};
		add( btnPlay );
		
		DashboardItem btnRankings = new DashboardItem( Messages.get(this, "rankings"), 2 ) {
			@Override
			protected void onClick() {
				OvergrownPixelDungeon.switchNoFade( RankingsScene.class );
			}
		};
		add( btnRankings );

		if (OGPDSettings.landscape()) {
			btnRankings     .setPos( w / 2 - btnRankings.width(), topRegion );
			btnBadges       .setPos( w / 2, topRegion );
			btnPlay         .setPos( btnRankings.left() - btnPlay.width(), topRegion );
			btnAbout        .setPos( btnBadges.right(), topRegion );
		} else {
			btnPlay.setPos( w / 2 - btnPlay.width(), topRegion );
			btnRankings.setPos( w / 2, btnPlay.top() );
			btnBadges.setPos( w / 2 - btnBadges.width(), btnPlay.top() + DashboardItem.SIZE );
			btnAbout.setPos( w / 2, btnBadges.top() );
		}

		BitmapText version = new BitmapText( "v " + Game.version + "", pixelFont);
		version.measure();
		version.hardlight( Game.instance.getResources().getInteger(R.integer.titlescene) );
		version.x = w - version.width();
		version.y = h - version.height();
		add( version );

		Button changes = new ChangesButton();
		changes.setPos( w-changes.width(), h - version.height() - changes.height());
		add( changes );
		
		int pos = 0;
		
		PrefsButton btnPrefs = new PrefsButton();
		btnPrefs.setRect( pos, 0, 16, 16 );
		add( btnPrefs );
		
		pos += btnPrefs.width();

		LanguageButton btnLang = new LanguageButton();
		btnLang.setRect(pos, 0, 14, 16);
		add( btnLang );

		ExitButton btnExit = new ExitButton();
		btnExit.setPos( w - btnExit.width(), 0 );
		add( btnExit );

		fadeIn();
	}
	
	private static class DashboardItem extends Button {
		
		public static final float SIZE	= 48;
		
		private static final int IMAGE_SIZE	= 32;
		
		private Image image;
		private RenderedText label;
		
		public DashboardItem( String text, int index ) {
			super();
			
			image.frame( image.texture.uvRect( index * IMAGE_SIZE, 0, (index + 1) * IMAGE_SIZE, IMAGE_SIZE ) );
			this.label.text( text );
			
			setSize( SIZE, SIZE );
		}
		
		@Override
		protected void createChildren() {
			super.createChildren();
			
			image = new Image( Assets.DASHBOARD );
			add( image );
			
			label = renderText( 9 );
			add( label );
		}
		
		@Override
		protected void layout() {
			super.layout();
			
			image.x = x + (width - image.width()) / 2;
			image.y = y;
			align(image);
			
			label.x = x + (width - label.width()) / 2;
			label.y = image.y + image.height() +2;
			align(label);
		}
		
		@Override
		protected void onTouchDown() {
			image.brightness( 1.5f );
			Sample.INSTANCE.play( Assets.SND_CLICK, 1, 1, 0.8f );
		}
		
		@Override
		protected void onTouchUp() {
			image.resetColor();
		}
	}
}
