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
import com.overgrownpixel.overgrownpixeldungeon.Badges;
import com.overgrownpixel.overgrownpixeldungeon.OGPDSettings;
import com.overgrownpixel.overgrownpixeldungeon.OvergrownPixelDungeon;
import com.overgrownpixel.overgrownpixeldungeon.R;
import com.overgrownpixel.overgrownpixeldungeon.Rankings;
import com.overgrownpixel.overgrownpixeldungeon.effects.BannerSprites;
import com.overgrownpixel.overgrownpixeldungeon.effects.Fireball;
import com.overgrownpixel.overgrownpixeldungeon.journal.Document;
import com.overgrownpixel.overgrownpixeldungeon.journal.Journal;
import com.overgrownpixel.overgrownpixeldungeon.messages.Messages;
import com.overgrownpixel.overgrownpixeldungeon.ui.RedButton;
import com.overgrownpixel.overgrownpixeldungeon.ui.RenderedTextMultiline;
import com.overgrownpixel.overgrownpixeldungeon.windows.WndStartGame;
import com.watabou.glwrap.Blending;
import com.watabou.noosa.Camera;
import com.watabou.noosa.Game;
import com.watabou.noosa.Image;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.FileUtils;

public class WelcomeScene extends PixelScene {

	private static int LATEST_UPDATE = OvergrownPixelDungeon.v0_7_3;

	@Override
	public void create() {
		super.create();

		final int previousVersion = OGPDSettings.version();

		if (OvergrownPixelDungeon.versionCode == previousVersion) {
			OvergrownPixelDungeon.switchNoFade(TitleScene.class);
			return;
		}

		uiCamera.visible = false;

		int w = Camera.main.width;
		int h = Camera.main.height;

		Image title = BannerSprites.get( BannerSprites.Type.PIXEL_DUNGEON );
		title.brightness(0.6f);
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
				if (time >= 1.5f*Math.PI) time = 0;
			}
			@Override
			public void draw() {
				Blending.setLightMode();
				super.draw();
				Blending.setNormalMode();
			}
		};
		signs.x = title.x + (title.width() - signs.width())/2f;
		signs.y = title.y;
		add( signs );

		DarkRedButton okay = new DarkRedButton(Messages.get(this, "continue")){
			@Override
			protected void onClick() {
				super.onClick();
				if (previousVersion == 0){
					OGPDSettings.version(OvergrownPixelDungeon.versionCode);
					WelcomeScene.this.add(new WndStartGame(1));
				} else {
					updateVersion(previousVersion);
					OvergrownPixelDungeon.switchScene(TitleScene.class);
				}
			}
		};

		if (previousVersion != 0){
			DarkRedButton changes = new DarkRedButton(Messages.get(this, "changelist")){
				@Override
				protected void onClick() {
					super.onClick();
					updateVersion(previousVersion);
					OvergrownPixelDungeon.switchScene(ChangesScene.class);
				}
			};
			okay.setRect(title.x, h-20, (title.width()/2)-2, 16);
			okay.textColor(Game.instance.getResources().getInteger(R.integer.welcomesceneokay1));
			add(okay);

			changes.setRect(okay.right()+2, h-20, (title.width()/2)-2, 16);
			changes.textColor(Game.instance.getResources().getInteger(R.integer.welcomescenechanges));
			add(changes);
		} else {
			okay.setRect(title.x, h-20, title.width(), 16);
			okay.textColor(Game.instance.getResources().getInteger(R.integer.welcomesceneokay2));
			add(okay);
		}

		RenderedTextMultiline text = PixelScene.renderMultiline(6);
		String message;
		if (previousVersion == 0) {
			message = Messages.get(this, "welcome_msg");
		} else if (previousVersion <= OvergrownPixelDungeon.versionCode) {
			if (previousVersion < LATEST_UPDATE){
				message = Messages.get(this, "update_intro");
				message += "\n\n" + Messages.get(this, "update_msg");
			} else {
				//TODO: change the messages here in accordance with the type of patch.
				message = Messages.get(this, "patch_intro");
				message += "\n";
				//message += "\n" + Messages.get(this, "patch_balance");
				message += "\n" + Messages.get(this, "patch_bugfixes");
				message += "\n" + Messages.get(this, "patch_translations");

			}
		} else {
			message = Messages.get(this, "what_msg");
		}
		text.text(message, w-20);
		float textSpace = h - title.y - (title.height() - 10) - okay.height() - 2;
		text.setPos((w - text.width()) / 2f, title.y+(title.height() - 10) + ((textSpace - text.height()) / 2));
		add(text);

	}

	private void updateVersion(int previousVersion){
		
		//update rankings, to update any data which may be outdated
		if (previousVersion < LATEST_UPDATE){
			try {
				Rankings.INSTANCE.load();
				Rankings.INSTANCE.save();
			} catch (Exception e) {
				//if we encounter a fatal error, then just clear the rankings
				FileUtils.deleteFile( Rankings.RANKINGS_FILE );
			}
		}
		
		//give classes to people with saves that have previously unlocked them
		if (previousVersion <= OvergrownPixelDungeon.v0_7_0c){
			Badges.loadGlobal();
			Badges.addGlobal(Badges.Badge.UNLOCK_MAGE);
			Badges.addGlobal(Badges.Badge.UNLOCK_ROGUE);
			if (Badges.isUnlocked(Badges.Badge.BOSS_SLAIN_3)){
				Badges.addGlobal(Badges.Badge.UNLOCK_HUNTRESS);
			}
			Badges.saveGlobal();
		}
		
		if (previousVersion <= OvergrownPixelDungeon.v0_6_5c){
			Journal.loadGlobal();
			Document.ALCHEMY_GUIDE.addPage("Potions");
			Document.ALCHEMY_GUIDE.addPage("Stones");
			Document.ALCHEMY_GUIDE.addPage("Energy_Food");
			Journal.saveGlobal();
		}
		
		OGPDSettings.version(OvergrownPixelDungeon.versionCode);
	}

	private void placeTorch( float x, float y ) {
		Fireball fb = new Fireball();
		fb.setPos( x, y );
		add( fb );
	}

	private class DarkRedButton extends RedButton{
		{
			bg.brightness(0.4f);
		}

		DarkRedButton(String text){
			super(text);
		}

		@Override
		protected void onTouchDown() {
			bg.brightness(0.5f);
			Sample.INSTANCE.play( Assets.SND_CLICK );
		}

		@Override
		protected void onTouchUp() {
			super.onTouchUp();
			bg.brightness(0.4f);
		}
	}
}
