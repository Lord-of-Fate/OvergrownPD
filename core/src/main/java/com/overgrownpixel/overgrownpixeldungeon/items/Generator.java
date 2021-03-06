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

package com.overgrownpixel.overgrownpixeldungeon.items;

import com.overgrownpixel.overgrownpixeldungeon.Dungeon;
import com.overgrownpixel.overgrownpixeldungeon.OvergrownPixelDungeon;
import com.overgrownpixel.overgrownpixeldungeon.items.armor.Armor;
import com.overgrownpixel.overgrownpixeldungeon.items.armor.ClothArmor;
import com.overgrownpixel.overgrownpixeldungeon.items.armor.LeatherArmor;
import com.overgrownpixel.overgrownpixeldungeon.items.armor.MailArmor;
import com.overgrownpixel.overgrownpixeldungeon.items.armor.PlateArmor;
import com.overgrownpixel.overgrownpixeldungeon.items.armor.ScaleArmor;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.AlchemistsToolkit;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.Artifact;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.CapeOfThorns;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.ChaliceOfBlood;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.CloakOfShadows;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.CursedCards;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.DriedRose;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.EtherealChains;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.HornOfPlenty;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.LloydsBeacon;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.MasterThievesArmband;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.SandalsOfNature;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.TalismanOfForesight;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.TimekeepersHourglass;
import com.overgrownpixel.overgrownpixeldungeon.items.artifacts.UnstableSpellbook;
import com.overgrownpixel.overgrownpixeldungeon.items.bags.Bag;
import com.overgrownpixel.overgrownpixeldungeon.items.food.Food;
import com.overgrownpixel.overgrownpixeldungeon.items.food.MysteryMeat;
import com.overgrownpixel.overgrownpixeldungeon.items.food.Pasty;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.Potion;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfBall;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfBanana;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfBlessing;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfButter;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfChilli;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfDew;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfDigesting;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfDirt;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfEgg;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfExperience;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfEye;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfFirelightning;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfFirestorm;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfFlora;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfFrost;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfGlowing;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfGoo;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfGrass;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfHarvest;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfHaste;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfHealing;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfHoney;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfHunger;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfHydrogenFire;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfHypno;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfIceStorm;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfInfection;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfInvisibility;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfKiwi;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfLantern;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfLevitation;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfLightning;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfLiquidFlame;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfLove;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfMindVision;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfMuscle;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfParalyticGas;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfParasites;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfPeanuts;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfPepper;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfProtection;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfPurity;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfRegrowth;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfSecreting;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfSeed;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfShadows;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfShield;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfSlowness;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfSmoke;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfSnowstorm;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfSoda;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfSteam;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfStrength;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfSun;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfTeleporting;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfTime;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfTomatoSoup;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfToxicGas;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfUltraviolett;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfVine;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfWater;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfWine;
import com.overgrownpixel.overgrownpixeldungeon.items.potions.PotionOfWithering;
import com.overgrownpixel.overgrownpixeldungeon.items.rings.Ring;
import com.overgrownpixel.overgrownpixeldungeon.items.rings.RingOfAccuracy;
import com.overgrownpixel.overgrownpixeldungeon.items.rings.RingOfElements;
import com.overgrownpixel.overgrownpixeldungeon.items.rings.RingOfEnergy;
import com.overgrownpixel.overgrownpixeldungeon.items.rings.RingOfEvasion;
import com.overgrownpixel.overgrownpixeldungeon.items.rings.RingOfForce;
import com.overgrownpixel.overgrownpixeldungeon.items.rings.RingOfFuror;
import com.overgrownpixel.overgrownpixeldungeon.items.rings.RingOfHaste;
import com.overgrownpixel.overgrownpixeldungeon.items.rings.RingOfMight;
import com.overgrownpixel.overgrownpixeldungeon.items.rings.RingOfSharpshooting;
import com.overgrownpixel.overgrownpixeldungeon.items.rings.RingOfTenacity;
import com.overgrownpixel.overgrownpixeldungeon.items.rings.RingOfWealth;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.Scroll;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfIdentify;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfLullaby;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfMirrorImage;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfRage;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfRecharging;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfRetribution;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfTerror;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfTransmutation;
import com.overgrownpixel.overgrownpixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.Alchemize;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.AquaBlast;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.ArcaneCatalyst;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.BeaconOfReturning;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.CrimsonEpithet;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.CurseInfusion;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.DoomCall;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.EnchantmentInfusion;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.FeatherFall;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.ForcePush;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.Forcefield;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.HolyBlast;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.MagicalInfusion;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.MagicalPorter;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.NaturesLullaby;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.PhaseShift;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.PlantSummon;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.ReclaimTrap;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.Recycle;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.SeasonChange;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.Spell;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.SpontaneosCombustion;
import com.overgrownpixel.overgrownpixeldungeon.items.spells.WildEnergy;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.Runestone;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.StoneOfAffection;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.StoneOfAggression;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.StoneOfAugmentation;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.StoneOfBlast;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.StoneOfBlink;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.StoneOfClairvoyance;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.StoneOfDeepenedSleep;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.StoneOfDisarming;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.StoneOfEnchantment;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.StoneOfFlock;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.StoneOfIntuition;
import com.overgrownpixel.overgrownpixeldungeon.items.stones.StoneOfShock;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.Wand;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfBlastWave;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfCorrosion;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfCorruption;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfDisintegration;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfFireblast;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfFlock;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfFrost;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfLightning;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfLivingEarth;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfMagicMissile;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfPoison;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfPrismaticLight;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfRegrowth;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfTransfusion;
import com.overgrownpixel.overgrownpixeldungeon.items.wands.WandOfWarding;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.MeleeWeapon;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.axes.BattleAxe;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.axes.Greataxe;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.axes.HandAxe;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.axes.HookedWaraxe;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.axes.TwoSidedWaraxe;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.axes.Waraxe;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.blades.AssassinsBlade;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.blades.BroadBlade;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.blades.ButcherBlade;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.blades.DoubleBlade;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.blades.Hackblade;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.blades.RunicBlade;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.blades.SteelBlade;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.bows.GoldenBow;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.bows.SmallBow;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.canes.CaneBlade;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.canes.CaneSaw;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.canes.StuddedCane;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.chains.KnifeChain;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.chains.Kusarigama;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.chains.ManrikiKusari;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.chains.Nunchaku;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.clubs.BarbedStaff;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.clubs.Club;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.clubs.ClubSword;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.clubs.Jutte;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.clubs.Kanabo;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.clubs.Mace;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.clubs.Quarterstaff;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.clubs.SpikedClub;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.clubs.SpikedStoneClub;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.curvedblades.Khopesh;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.curvedblades.PirateSabre;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.curvedblades.Sabre;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.curvedblades.Scimitar;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.fans.GunsenFan;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.fencing.DualFencingBlades;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.fencing.Rapier;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.flails.Flail;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.gloves.ClawGlove;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.gloves.Gauntlet;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.gloves.Gloves;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.gloves.Knuckleduster;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.gloves.TekkoKagi;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.gloves.Yawara;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.grates.CheeseGrater;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.halberds.Halberd;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.halberds.TripleHookedHalberd;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.hammers.Otsuchi;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.hammers.SteelWarhammer;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.hammers.WarHammer;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.harpoons.Harpoon;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.knifes.ClawKnife;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.knifes.Dagger;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.knifes.Dirk;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.knifes.HornKnife;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.knifes.ManjiSai;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.knifes.Sai;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.longswords.AdornedLongsword;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.longswords.DoubleLongsword;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.longswords.Longsword;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.longswords.SteelLongsword;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.mobweapons.gooweapons.GooWeapon;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.mobweapons.ratweapons.RatFangDagger;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.scythes.Scythe;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.scythes.ScytheWheel;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.scythes.SpikedScythe;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.shields.CrusaderKiteshield;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.shields.Greatshield;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.shields.KiteShield;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.shields.ParagonShield;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.shields.RoundShield;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.shields.Scyld;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.shields.SwordShield;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.shortswords.Shortsword;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.shortswords.WornShortsword;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.spears.BambooSpear;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.spears.BroadSpear;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.spears.Glaive;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.spears.Lance;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.spears.Naginata;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.spears.PendulumSpear;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.spears.RoundedSpear;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.spears.Sasumata;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.spears.Spear;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.staffs.MagesStaff;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.swords.Greatsword;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.swords.Katana;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.swords.Sword;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.swords.SwordWheel;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.tridents.TridentSpear;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.whips.ChainWhip;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.whips.NailWhip;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.whips.Whip;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.melee.whips.WhipSword;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.Bolas;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.FishingSpear;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.ForceCube;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.HeavyBoomerang;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.Javelin;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.Kunai;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.MissileWeapon;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.Shuriken;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.ThrowingClub;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.ThrowingHammer;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.ThrowingKnife;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.ThrowingSpear;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.ThrowingStone;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.Tomahawk;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.Trident;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.AdrenalineDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.BallDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.BananaDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.BeetleDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.BlindingDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.ChaosDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.ChillingDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.ClitDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.ClockDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.CocoDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.ConfusingDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.CornDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.CorruptionDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.CrownDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.DewDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.DirtDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.DisplacingDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.EarthquakeDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.EggDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.EyeDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.FeelerDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.FirefoxDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.FreezingDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.GooDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.GrapeDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.GrassDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.HealingDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.HealthDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.HeatDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.HolyDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.HoneyDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.HypnoDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.IncendiaryDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.LanternDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.LightningDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.ParalyticDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.ParasiticDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.PeanutMarkDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.PoisonDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.PopDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.PushingDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.RootingDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.RoseDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.RotDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.SeedChaosDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.ShadowDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.ShockingDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.SleepDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.SlownessDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.SmokingDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.SnowstormDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.SourDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.SpicyDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.StormDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.SunDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.SusanDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.TankDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.TeleportingDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.TippedDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.TomatoDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.TrackingDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.TreeDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.WaterDart;
import com.overgrownpixel.overgrownpixeldungeon.items.weapon.missiles.darts.WitherDart;
import com.overgrownpixel.overgrownpixeldungeon.plants.Apricobush;
import com.overgrownpixel.overgrownpixeldungeon.plants.Ballcrop;
import com.overgrownpixel.overgrownpixeldungeon.plants.Bananabean;
import com.overgrownpixel.overgrownpixeldungeon.plants.Blackholeflower;
import com.overgrownpixel.overgrownpixeldungeon.plants.Blindweed;
import com.overgrownpixel.overgrownpixeldungeon.plants.Blueeyedsusan;
import com.overgrownpixel.overgrownpixeldungeon.plants.Butterlion;
import com.overgrownpixel.overgrownpixeldungeon.plants.Chandaliertail;
import com.overgrownpixel.overgrownpixeldungeon.plants.Chillisnapper;
import com.overgrownpixel.overgrownpixeldungeon.plants.Clitbalm;
import com.overgrownpixel.overgrownpixeldungeon.plants.Clockcypress;
import com.overgrownpixel.overgrownpixeldungeon.plants.Cocostuft;
import com.overgrownpixel.overgrownpixeldungeon.plants.Combflower;
import com.overgrownpixel.overgrownpixeldungeon.plants.Cornwheat;
import com.overgrownpixel.overgrownpixeldungeon.plants.Crimsoncrown;
import com.overgrownpixel.overgrownpixeldungeon.plants.Crimsonpepper;
import com.overgrownpixel.overgrownpixeldungeon.plants.Dirtdaisy;
import com.overgrownpixel.overgrownpixeldungeon.plants.Dreamfoil;
import com.overgrownpixel.overgrownpixeldungeon.plants.Earthroot;
import com.overgrownpixel.overgrownpixeldungeon.plants.Eggbloom;
import com.overgrownpixel.overgrownpixeldungeon.plants.Eyeeuonymus;
import com.overgrownpixel.overgrownpixeldungeon.plants.Fadeleaf;
import com.overgrownpixel.overgrownpixeldungeon.plants.Feelerfern;
import com.overgrownpixel.overgrownpixeldungeon.plants.Firebloom;
import com.overgrownpixel.overgrownpixeldungeon.plants.Firefoxglove;
import com.overgrownpixel.overgrownpixeldungeon.plants.Flowertree;
import com.overgrownpixel.overgrownpixeldungeon.plants.Frostcorn;
import com.overgrownpixel.overgrownpixeldungeon.plants.Gobgrape;
import com.overgrownpixel.overgrownpixeldungeon.plants.Goograss;
import com.overgrownpixel.overgrownpixeldungeon.plants.Grasslilly;
import com.overgrownpixel.overgrownpixeldungeon.plants.Grassvine;
import com.overgrownpixel.overgrownpixeldungeon.plants.Hypnohemp;
import com.overgrownpixel.overgrownpixeldungeon.plants.Icecap;
import com.overgrownpixel.overgrownpixeldungeon.plants.Kiwivetch;
import com.overgrownpixel.overgrownpixeldungeon.plants.Larvaleaf;
import com.overgrownpixel.overgrownpixeldungeon.plants.Lavenderlantern;
import com.overgrownpixel.overgrownpixeldungeon.plants.Lightninglily;
import com.overgrownpixel.overgrownpixeldungeon.plants.Musclemoss;
import com.overgrownpixel.overgrownpixeldungeon.plants.Nightshadeonion;
import com.overgrownpixel.overgrownpixeldungeon.plants.Parasiteshrub;
import com.overgrownpixel.overgrownpixeldungeon.plants.Peanutpetal;
import com.overgrownpixel.overgrownpixeldungeon.plants.Plant;
import com.overgrownpixel.overgrownpixeldungeon.plants.Poppoplar;
import com.overgrownpixel.overgrownpixeldungeon.plants.Rose;
import com.overgrownpixel.overgrownpixeldungeon.plants.Rotberry;
import com.overgrownpixel.overgrownpixeldungeon.plants.Shadowbloom;
import com.overgrownpixel.overgrownpixeldungeon.plants.Snowhedge;
import com.overgrownpixel.overgrownpixeldungeon.plants.Sorrowmoss;
import com.overgrownpixel.overgrownpixeldungeon.plants.Sourpitcher;
import com.overgrownpixel.overgrownpixeldungeon.plants.Starflower;
import com.overgrownpixel.overgrownpixeldungeon.plants.Steamweed;
import com.overgrownpixel.overgrownpixeldungeon.plants.Stormvine;
import com.overgrownpixel.overgrownpixeldungeon.plants.Sunbloom;
import com.overgrownpixel.overgrownpixeldungeon.plants.Suncarnivore;
import com.overgrownpixel.overgrownpixeldungeon.plants.Sungrass;
import com.overgrownpixel.overgrownpixeldungeon.plants.Swiftthistle;
import com.overgrownpixel.overgrownpixeldungeon.plants.Tankcabbage;
import com.overgrownpixel.overgrownpixeldungeon.plants.Tomatobush;
import com.overgrownpixel.overgrownpixeldungeon.plants.Venusflytrap;
import com.overgrownpixel.overgrownpixeldungeon.plants.Waterweed;
import com.overgrownpixel.overgrownpixeldungeon.plants.Willowcane;
import com.overgrownpixel.overgrownpixeldungeon.plants.Witherfennel;
import com.watabou.utils.Bundle;
import com.watabou.utils.GameMath;
import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Generator {

	public enum Category {
		WEAPON	( 6,    MeleeWeapon.class),
		WEP_T1	( 0,    MeleeWeapon.class),
		WEP_T2	( 0,    MeleeWeapon.class),
		WEP_T3	( 0,    MeleeWeapon.class),
		WEP_T4	( 0,    MeleeWeapon.class),
		WEP_T5	( 0,    MeleeWeapon.class),
		
		ARMOR	( 4,    Armor.class ),
		
		MISSILE ( 3,    MissileWeapon.class ),
		MIS_T1  ( 0,    MissileWeapon.class ),
		MIS_T2  ( 0,    MissileWeapon.class ),
		MIS_T3  ( 0,    MissileWeapon.class ),
		MIS_T4  ( 0,    MissileWeapon.class ),
		MIS_T5  ( 0,    MissileWeapon.class ),
		
		WAND	( 3,    Wand.class ),
		RING	( 1,    Ring.class ),
		ARTIFACT( 1,    Artifact.class),
        SPELLS  ( 0,    Spell.class),
		
		FOOD	( 0,    Food.class ),
		
		POTION	( 20,   Potion.class ),
        NEWPOTION	( 0,    Potion.class ),
        ALLPOTIONS	( 0,    Potion.class ),
		SEED	    ( 0,    Plant.Seed.class ), //dropped by grass
        BASESEED	( 0,    Plant.Seed.class ),
        ALLSEEDS	( 0,    Plant.Seed.class ),
        SEEDWATER	( 0,    Plant.Seed.class ),
        SEEDSEWER	( 0,    Plant.Seed.class ),
        SEEDPRISON	( 0,    Plant.Seed.class ),
        SEEDCAVES	( 0,    Plant.Seed.class ),
        SEEDCITY	( 0,    Plant.Seed.class ),
        SEEDHELL	( 0,    Plant.Seed.class ),

        DARTS	    ( 0,    TippedDart.class ),
		
		SCROLL	( 20,   Scroll.class ),
		STONE   ( 2,    Runestone.class),
		
		GOLD	( 18,   Gold.class );
		
		public Class<?>[] classes;
		public float[] probs;
		
		public float prob;
		public Class<? extends Item> superClass;
		
		Category( float prob, Class<? extends Item> superClass ) {
			this.prob = prob;
			this.superClass = superClass;
		}
		
		public static int order( Item item ) {
			for (int i=0; i < values().length; i++) {
				if (values()[i].superClass.isInstance( item )) {
					return i;
				}
			}
			
			return item instanceof Bag ? Integer.MAX_VALUE : Integer.MAX_VALUE - 1;
		}
		
		private static final float[] INITIAL_ARTIFACT_PROBS = new float[]{ 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1};
		
		static {
			GOLD.classes = new Class<?>[]{
					Gold.class };
			GOLD.probs = new float[]{ 1 };

            DARTS.classes = new Class<?>[]{
                    BlindingDart.class, SleepDart.class, ParalyticDart.class, DisplacingDart.class, IncendiaryDart.class, ChillingDart.class, RotDart.class, PoisonDart.class, HolyDart.class, ShockingDart.class,
                    HealingDart.class, AdrenalineDart.class, HealthDart.class, TeleportingDart.class, DewDart.class, SeedChaosDart.class, EarthquakeDart.class, TrackingDart.class, HeatDart.class, SpicyDart.class,
                    FirefoxDart.class, FreezingDart.class, ChaosDart.class, RootingDart.class, PushingDart.class, SmokingDart.class, ParasiticDart.class, PeanutMarkDart.class, RoseDart.class, SnowstormDart.class,
                    StormDart.class, SunDart.class, TomatoDart.class, ConfusingDart.class, SlownessDart.class, WitherDart.class, CorruptionDart.class, BallDart.class, BananaDart.class, SusanDart.class,
                    ClitDart.class, ClockDart.class, CocoDart.class, HoneyDart.class, CornDart.class, CrownDart.class, DirtDart.class, EggDart.class, EyeDart.class, FeelerDart.class,
                    TreeDart.class, GrapeDart.class, GooDart.class, GrassDart.class, HypnoDart.class, LanternDart.class, PopDart.class, LightningDart.class, SourDart.class, ShadowDart.class,
                    BeetleDart.class, TankDart.class, WaterDart.class,
            };
            DARTS.probs = new float[]{
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1,
            };
			
			POTION.classes = new Class<?>[]{
					PotionOfStrength.class, //2 drop every chapter, see Dungeon.posNeeded()
					PotionOfHealing.class,
					PotionOfMindVision.class,
					PotionOfFrost.class,
					PotionOfLiquidFlame.class,
					PotionOfToxicGas.class,
					PotionOfHaste.class,
					PotionOfInvisibility.class,
					PotionOfLevitation.class,
					PotionOfParalyticGas.class,
					PotionOfPurity.class,
					PotionOfExperience.class};
			POTION.probs = new float[]{ 0, 6, 4, 3, 3, 3, 2, 2, 2, 2, 2, 1 };

            NEWPOTION.classes = new Class<?>[]{
                    PotionOfHunger.class, PotionOfBall.class, PotionOfBanana.class, PotionOfBlessing.class, PotionOfTeleporting.class,
                    PotionOfButter.class, PotionOfGlowing.class, PotionOfChilli.class, PotionOfLove.class, PotionOfTime.class,
                    PotionOfProtection.class, PotionOfHoney.class, PotionOfHarvest.class, PotionOfFirelightning.class, PotionOfPepper.class,
                    PotionOfDirt.class, PotionOfEgg.class, PotionOfEye.class, PotionOfRegrowth.class, PotionOfFirestorm.class,
                    PotionOfFlora.class, PotionOfIceStorm.class, PotionOfWine.class, PotionOfGoo.class, PotionOfGrass.class,
                    PotionOfVine.class, PotionOfHypno.class, PotionOfKiwi.class, PotionOfInfection.class, PotionOfLantern.class,
                    PotionOfLightning.class, PotionOfMuscle.class, PotionOfSmoke.class, PotionOfParasites.class, PotionOfPeanuts.class,
                    PotionOfSoda.class, PotionOfShield.class, PotionOfShadows.class, PotionOfSnowstorm.class, PotionOfDigesting.class,
                    PotionOfSteam.class, PotionOfSun.class, PotionOfUltraviolett.class, PotionOfHydrogenFire.class, PotionOfTomatoSoup.class,
                    PotionOfSecreting.class, PotionOfWater.class, PotionOfSlowness.class, PotionOfWithering.class, PotionOfSeed.class,
                    PotionOfDew.class};
            NEWPOTION.probs = new float[]{
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,};

            ALLPOTIONS.classes = new Class<?>[]{
                    PotionOfStrength.class,
                    PotionOfHealing.class,
                    PotionOfMindVision.class,
                    PotionOfFrost.class,
                    PotionOfLiquidFlame.class,
                    PotionOfToxicGas.class,
                    PotionOfHaste.class,
                    PotionOfInvisibility.class,
                    PotionOfLevitation.class,
                    PotionOfParalyticGas.class,
                    PotionOfPurity.class,
                    PotionOfExperience.class, PotionOfHunger.class, PotionOfBall.class, PotionOfBanana.class, PotionOfBlessing.class, PotionOfTeleporting.class,
                    PotionOfButter.class, PotionOfGlowing.class, PotionOfChilli.class, PotionOfLove.class, PotionOfTime.class,
                    PotionOfProtection.class, PotionOfHoney.class, PotionOfHarvest.class, PotionOfFirelightning.class, PotionOfPepper.class,
                    PotionOfDirt.class, PotionOfEgg.class, PotionOfEye.class, PotionOfRegrowth.class, PotionOfFirestorm.class,
                    PotionOfFlora.class, PotionOfIceStorm.class, PotionOfWine.class, PotionOfGoo.class, PotionOfGrass.class,
                    PotionOfVine.class, PotionOfHypno.class, PotionOfKiwi.class, PotionOfInfection.class, PotionOfLantern.class,
                    PotionOfLightning.class, PotionOfMuscle.class, PotionOfSmoke.class, PotionOfParasites.class, PotionOfPeanuts.class,
                    PotionOfSoda.class, PotionOfShield.class, PotionOfShadows.class, PotionOfSnowstorm.class, PotionOfDigesting.class,
                    PotionOfSteam.class, PotionOfSun.class, PotionOfUltraviolett.class, PotionOfHydrogenFire.class, PotionOfTomatoSoup.class,
                    PotionOfSecreting.class, PotionOfWater.class, PotionOfSlowness.class, PotionOfWithering.class, PotionOfSeed.class,
                    PotionOfDew.class};
            ALLPOTIONS.probs = new float[]{
                    0,6,4,3,
                    3,3,2,2,
                    2,2,2,1,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5,5,5,5,5,
                    5, };
			
			SEED.classes = new Class<?>[]{
			        Apricobush.Seed.class, Ballcrop.Seed.class, Bananabean.Seed.class, Blackholeflower.Seed.class, Blindweed.Seed.class, Blueeyedsusan.Seed.class, Butterlion.Seed.class, Chandaliertail.Seed.class, Chillisnapper.Seed.class, Clitbalm.Seed.class,
                    Clockcypress.Seed.class, Cocostuft.Seed.class, Combflower.Seed.class, Cornwheat.Seed.class, Crimsoncrown.Seed.class, Crimsonpepper.Seed.class, Dirtdaisy.Seed.class, Dreamfoil.Seed.class, Earthroot.Seed.class, Eggbloom.Seed.class,
                    Eyeeuonymus.Seed.class, Fadeleaf.Seed.class, Feelerfern.Seed.class, Firebloom.Seed.class, Firefoxglove.Seed.class, Flowertree.Seed.class, Frostcorn.Seed.class, Gobgrape.Seed.class, Goograss.Seed.class, Grasslilly.Seed.class,
                    Grassvine.Seed.class, Hypnohemp.Seed.class, Icecap.Seed.class, Kiwivetch.Seed.class, Larvaleaf.Seed.class, Lavenderlantern.Seed.class, Lightninglily.Seed.class, Musclemoss.Seed.class, Nightshadeonion.Seed.class, Parasiteshrub.Seed.class,
                    Peanutpetal.Seed.class, Poppoplar.Seed.class, Rose.Seed.class, Rotberry.Seed.class, Shadowbloom.Seed.class, Snowhedge.Seed.class, Sorrowmoss.Seed.class, Sourpitcher.Seed.class, Starflower.Seed.class, Steamweed.Seed.class,
                    Stormvine.Seed.class, Sunbloom.Seed.class, Suncarnivore.Seed.class, Sungrass.Seed.class, Swiftthistle.Seed.class, Tankcabbage.Seed.class, Tomatobush.Seed.class, Venusflytrap.Seed.class, Waterweed.Seed.class, Willowcane.Seed.class,
                    Witherfennel.Seed.class};
			SEED.probs = new float[]{
			        5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 0, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5};

            ALLSEEDS.classes = new Class<?>[]{
                    Apricobush.Seed.class, Ballcrop.Seed.class, Bananabean.Seed.class, Blackholeflower.Seed.class, Blindweed.Seed.class, Blueeyedsusan.Seed.class, Butterlion.Seed.class, Chandaliertail.Seed.class, Chillisnapper.Seed.class, Clitbalm.Seed.class,
                    Clockcypress.Seed.class, Cocostuft.Seed.class, Combflower.Seed.class, Cornwheat.Seed.class, Crimsoncrown.Seed.class, Crimsonpepper.Seed.class, Dirtdaisy.Seed.class, Dreamfoil.Seed.class, Earthroot.Seed.class, Eggbloom.Seed.class,
                    Eyeeuonymus.Seed.class, Fadeleaf.Seed.class, Feelerfern.Seed.class, Firebloom.Seed.class, Firefoxglove.Seed.class, Flowertree.Seed.class, Frostcorn.Seed.class, Gobgrape.Seed.class, Goograss.Seed.class, Grasslilly.Seed.class,
                    Grassvine.Seed.class, Hypnohemp.Seed.class, Icecap.Seed.class, Kiwivetch.Seed.class, Larvaleaf.Seed.class, Lavenderlantern.Seed.class, Lightninglily.Seed.class, Musclemoss.Seed.class, Nightshadeonion.Seed.class, Parasiteshrub.Seed.class,
                    Peanutpetal.Seed.class, Poppoplar.Seed.class, Rose.Seed.class, Rotberry.Seed.class, Shadowbloom.Seed.class, Snowhedge.Seed.class, Sorrowmoss.Seed.class, Sourpitcher.Seed.class, Starflower.Seed.class, Steamweed.Seed.class,
                    Stormvine.Seed.class, Sunbloom.Seed.class, Suncarnivore.Seed.class, Sungrass.Seed.class, Swiftthistle.Seed.class, Tankcabbage.Seed.class, Tomatobush.Seed.class, Venusflytrap.Seed.class, Waterweed.Seed.class, Willowcane.Seed.class,
                    Witherfennel.Seed.class, WandOfRegrowth.Seedpod.Seed.class, WandOfRegrowth.Dewcatcher.Seed.class};
            ALLSEEDS.probs = new float[]{
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 0, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5};

            BASESEED.classes = new Class<?>[]{
                    Apricobush.Seed.class, Ballcrop.Seed.class, Bananabean.Seed.class, Blackholeflower.Seed.class, Blindweed.Seed.class, Blueeyedsusan.Seed.class, Butterlion.Seed.class, Chandaliertail.Seed.class, Chillisnapper.Seed.class, Clitbalm.Seed.class,
                    Clockcypress.Seed.class, Cocostuft.Seed.class, Combflower.Seed.class, Cornwheat.Seed.class, Crimsoncrown.Seed.class, Crimsonpepper.Seed.class, Dirtdaisy.Seed.class, Dreamfoil.Seed.class, Earthroot.Seed.class, Eggbloom.Seed.class,
                    Eyeeuonymus.Seed.class, Fadeleaf.Seed.class, Feelerfern.Seed.class, Firebloom.Seed.class, Firefoxglove.Seed.class, Flowertree.Seed.class, Frostcorn.Seed.class, Gobgrape.Seed.class, Goograss.Seed.class, Grasslilly.Seed.class,
                    Grassvine.Seed.class, Hypnohemp.Seed.class, Icecap.Seed.class, Kiwivetch.Seed.class, Larvaleaf.Seed.class, Lavenderlantern.Seed.class, Lightninglily.Seed.class, Musclemoss.Seed.class, Nightshadeonion.Seed.class, Parasiteshrub.Seed.class,
                    Peanutpetal.Seed.class, Poppoplar.Seed.class, Rose.Seed.class, Rotberry.Seed.class, Shadowbloom.Seed.class, Snowhedge.Seed.class, Sorrowmoss.Seed.class, Sourpitcher.Seed.class, Starflower.Seed.class, Steamweed.Seed.class,
                    Stormvine.Seed.class, Sunbloom.Seed.class, Suncarnivore.Seed.class, Sungrass.Seed.class, Swiftthistle.Seed.class, Tankcabbage.Seed.class, Tomatobush.Seed.class, Venusflytrap.Seed.class, Waterweed.Seed.class, Willowcane.Seed.class,
                    Witherfennel.Seed.class};
            BASESEED.probs = new float[]{
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 0, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5};

            SEEDWATER.classes = new Class<?>[]{

            };
            SEEDWATER.probs = new float[]{

            };

            SEEDSEWER.classes = new Class<?>[]{
                    Apricobush.Seed.class, Ballcrop.Seed.class, Bananabean.Seed.class, Blackholeflower.Seed.class, Blindweed.Seed.class, Blueeyedsusan.Seed.class, Butterlion.Seed.class, Chandaliertail.Seed.class, Chillisnapper.Seed.class, Clitbalm.Seed.class,
                    Clockcypress.Seed.class, Cocostuft.Seed.class, Combflower.Seed.class, Cornwheat.Seed.class, Crimsoncrown.Seed.class, Crimsonpepper.Seed.class, Dirtdaisy.Seed.class, Dreamfoil.Seed.class, Earthroot.Seed.class, Eggbloom.Seed.class,
                    Eyeeuonymus.Seed.class, Fadeleaf.Seed.class, Feelerfern.Seed.class, Firebloom.Seed.class, Firefoxglove.Seed.class, Flowertree.Seed.class, Frostcorn.Seed.class, Gobgrape.Seed.class, Goograss.Seed.class, Grasslilly.Seed.class,
                    Grassvine.Seed.class, Hypnohemp.Seed.class, Icecap.Seed.class, Kiwivetch.Seed.class, Larvaleaf.Seed.class, Lavenderlantern.Seed.class, Lightninglily.Seed.class, Musclemoss.Seed.class, Nightshadeonion.Seed.class, Parasiteshrub.Seed.class,
                    Peanutpetal.Seed.class, Poppoplar.Seed.class, Rose.Seed.class, Rotberry.Seed.class, Shadowbloom.Seed.class, Snowhedge.Seed.class, Sorrowmoss.Seed.class, Sourpitcher.Seed.class, Starflower.Seed.class, Steamweed.Seed.class,
                    Stormvine.Seed.class, Sunbloom.Seed.class, Suncarnivore.Seed.class, Sungrass.Seed.class, Swiftthistle.Seed.class, Tankcabbage.Seed.class, Tomatobush.Seed.class, Venusflytrap.Seed.class, Waterweed.Seed.class, Willowcane.Seed.class,
                    Witherfennel.Seed.class};
            SEEDSEWER.probs = new float[]{
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 0, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5};

            SEEDPRISON.classes = new Class<?>[]{
                    Apricobush.Seed.class, Ballcrop.Seed.class, Bananabean.Seed.class, Blackholeflower.Seed.class, Blindweed.Seed.class, Blueeyedsusan.Seed.class, Butterlion.Seed.class, Chandaliertail.Seed.class, Chillisnapper.Seed.class, Clitbalm.Seed.class,
                    Clockcypress.Seed.class, Cocostuft.Seed.class, Combflower.Seed.class, Cornwheat.Seed.class, Crimsoncrown.Seed.class, Crimsonpepper.Seed.class, Dirtdaisy.Seed.class, Dreamfoil.Seed.class, Earthroot.Seed.class, Eggbloom.Seed.class,
                    Eyeeuonymus.Seed.class, Fadeleaf.Seed.class, Feelerfern.Seed.class, Firebloom.Seed.class, Firefoxglove.Seed.class, Flowertree.Seed.class, Frostcorn.Seed.class, Gobgrape.Seed.class, Goograss.Seed.class, Grasslilly.Seed.class,
                    Grassvine.Seed.class, Hypnohemp.Seed.class, Icecap.Seed.class, Kiwivetch.Seed.class, Larvaleaf.Seed.class, Lavenderlantern.Seed.class, Lightninglily.Seed.class, Musclemoss.Seed.class, Nightshadeonion.Seed.class, Parasiteshrub.Seed.class,
                    Peanutpetal.Seed.class, Poppoplar.Seed.class, Rose.Seed.class, Rotberry.Seed.class, Shadowbloom.Seed.class, Snowhedge.Seed.class, Sorrowmoss.Seed.class, Sourpitcher.Seed.class, Starflower.Seed.class, Steamweed.Seed.class,
                    Stormvine.Seed.class, Sunbloom.Seed.class, Suncarnivore.Seed.class, Sungrass.Seed.class, Swiftthistle.Seed.class, Tankcabbage.Seed.class, Tomatobush.Seed.class, Venusflytrap.Seed.class, Waterweed.Seed.class, Willowcane.Seed.class,
                    Witherfennel.Seed.class};
            SEEDPRISON.probs = new float[]{
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 0, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5};

            SEEDCAVES.classes = new Class<?>[]{
                    Apricobush.Seed.class, Ballcrop.Seed.class, Bananabean.Seed.class, Blackholeflower.Seed.class, Blindweed.Seed.class, Blueeyedsusan.Seed.class, Butterlion.Seed.class, Chandaliertail.Seed.class, Chillisnapper.Seed.class, Clitbalm.Seed.class,
                    Clockcypress.Seed.class, Cocostuft.Seed.class, Combflower.Seed.class, Cornwheat.Seed.class, Crimsoncrown.Seed.class, Crimsonpepper.Seed.class, Dirtdaisy.Seed.class, Dreamfoil.Seed.class, Earthroot.Seed.class, Eggbloom.Seed.class,
                    Eyeeuonymus.Seed.class, Fadeleaf.Seed.class, Feelerfern.Seed.class, Firebloom.Seed.class, Firefoxglove.Seed.class, Flowertree.Seed.class, Frostcorn.Seed.class, Gobgrape.Seed.class, Goograss.Seed.class, Grasslilly.Seed.class,
                    Grassvine.Seed.class, Hypnohemp.Seed.class, Icecap.Seed.class, Kiwivetch.Seed.class, Larvaleaf.Seed.class, Lavenderlantern.Seed.class, Lightninglily.Seed.class, Musclemoss.Seed.class, Nightshadeonion.Seed.class, Parasiteshrub.Seed.class,
                    Peanutpetal.Seed.class, Poppoplar.Seed.class, Rose.Seed.class, Rotberry.Seed.class, Shadowbloom.Seed.class, Snowhedge.Seed.class, Sorrowmoss.Seed.class, Sourpitcher.Seed.class, Starflower.Seed.class, Steamweed.Seed.class,
                    Stormvine.Seed.class, Sunbloom.Seed.class, Suncarnivore.Seed.class, Sungrass.Seed.class, Swiftthistle.Seed.class, Tankcabbage.Seed.class, Tomatobush.Seed.class, Venusflytrap.Seed.class, Waterweed.Seed.class, Willowcane.Seed.class,
                    Witherfennel.Seed.class};
            SEEDCAVES.probs = new float[]{
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 0, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5};

            SEEDCITY.classes = new Class<?>[]{
                    Apricobush.Seed.class, Ballcrop.Seed.class, Bananabean.Seed.class, Blackholeflower.Seed.class, Blindweed.Seed.class, Blueeyedsusan.Seed.class, Butterlion.Seed.class, Chandaliertail.Seed.class, Chillisnapper.Seed.class, Clitbalm.Seed.class,
                    Clockcypress.Seed.class, Cocostuft.Seed.class, Combflower.Seed.class, Cornwheat.Seed.class, Crimsoncrown.Seed.class, Crimsonpepper.Seed.class, Dirtdaisy.Seed.class, Dreamfoil.Seed.class, Earthroot.Seed.class, Eggbloom.Seed.class,
                    Eyeeuonymus.Seed.class, Fadeleaf.Seed.class, Feelerfern.Seed.class, Firebloom.Seed.class, Firefoxglove.Seed.class, Flowertree.Seed.class, Frostcorn.Seed.class, Gobgrape.Seed.class, Goograss.Seed.class, Grasslilly.Seed.class,
                    Grassvine.Seed.class, Hypnohemp.Seed.class, Icecap.Seed.class, Kiwivetch.Seed.class, Larvaleaf.Seed.class, Lavenderlantern.Seed.class, Lightninglily.Seed.class, Musclemoss.Seed.class, Nightshadeonion.Seed.class, Parasiteshrub.Seed.class,
                    Peanutpetal.Seed.class, Poppoplar.Seed.class, Rose.Seed.class, Rotberry.Seed.class, Shadowbloom.Seed.class, Snowhedge.Seed.class, Sorrowmoss.Seed.class, Sourpitcher.Seed.class, Starflower.Seed.class, Steamweed.Seed.class,
                    Stormvine.Seed.class, Sunbloom.Seed.class, Suncarnivore.Seed.class, Sungrass.Seed.class, Swiftthistle.Seed.class, Tankcabbage.Seed.class, Tomatobush.Seed.class, Venusflytrap.Seed.class, Waterweed.Seed.class, Willowcane.Seed.class,
                    Witherfennel.Seed.class};
            SEEDCITY.probs = new float[]{
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 0, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5};

            SEEDHELL.classes = new Class<?>[]{
                    Apricobush.Seed.class, Ballcrop.Seed.class, Bananabean.Seed.class, Blackholeflower.Seed.class, Blindweed.Seed.class, Blueeyedsusan.Seed.class, Butterlion.Seed.class, Chandaliertail.Seed.class, Chillisnapper.Seed.class, Clitbalm.Seed.class,
                    Clockcypress.Seed.class, Cocostuft.Seed.class, Combflower.Seed.class, Cornwheat.Seed.class, Crimsoncrown.Seed.class, Crimsonpepper.Seed.class, Dirtdaisy.Seed.class, Dreamfoil.Seed.class, Earthroot.Seed.class, Eggbloom.Seed.class,
                    Eyeeuonymus.Seed.class, Fadeleaf.Seed.class, Feelerfern.Seed.class, Firebloom.Seed.class, Firefoxglove.Seed.class, Flowertree.Seed.class, Frostcorn.Seed.class, Gobgrape.Seed.class, Goograss.Seed.class, Grasslilly.Seed.class,
                    Grassvine.Seed.class, Hypnohemp.Seed.class, Icecap.Seed.class, Kiwivetch.Seed.class, Larvaleaf.Seed.class, Lavenderlantern.Seed.class, Lightninglily.Seed.class, Musclemoss.Seed.class, Nightshadeonion.Seed.class, Parasiteshrub.Seed.class,
                    Peanutpetal.Seed.class, Poppoplar.Seed.class, Rose.Seed.class, Rotberry.Seed.class, Shadowbloom.Seed.class, Snowhedge.Seed.class, Sorrowmoss.Seed.class, Sourpitcher.Seed.class, Starflower.Seed.class, Steamweed.Seed.class,
                    Stormvine.Seed.class, Sunbloom.Seed.class, Suncarnivore.Seed.class, Sungrass.Seed.class, Swiftthistle.Seed.class, Tankcabbage.Seed.class, Tomatobush.Seed.class, Venusflytrap.Seed.class, Waterweed.Seed.class, Willowcane.Seed.class,
                    Witherfennel.Seed.class};
            SEEDHELL.probs = new float[]{
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 0, 5, 5, 5, 5, 5, 5,
                    5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                    5};
			
			SCROLL.classes = new Class<?>[]{
					ScrollOfUpgrade.class, //3 drop every chapter, see Dungeon.souNeeded()
					ScrollOfIdentify.class,
					ScrollOfRemoveCurse.class,
					ScrollOfMirrorImage.class,
					ScrollOfRecharging.class,
					ScrollOfTeleportation.class,
					ScrollOfLullaby.class,
					ScrollOfMagicMapping.class,
					ScrollOfRage.class,
					ScrollOfRetribution.class,
					ScrollOfTerror.class,
					ScrollOfTransmutation.class
			};
			SCROLL.probs = new float[]{ 0, 6, 4, 3, 3, 3, 2, 2, 2, 2, 2, 1 };
			
			STONE.classes = new Class<?>[]{
					StoneOfEnchantment.class,   //1 is guaranteed to drop on floors 6-19
					StoneOfAugmentation.class,  //1 is sold in each shop
					StoneOfIntuition.class,     //1 additional stone is also dropped on floors 1-3
					StoneOfAggression.class,
					StoneOfAffection.class,
					StoneOfBlast.class,
					StoneOfBlink.class,
					StoneOfClairvoyance.class,
					StoneOfDeepenedSleep.class,
					StoneOfDisarming.class,
					StoneOfFlock.class,
					StoneOfShock.class
			};
			STONE.probs = new float[]{ 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

			WAND.classes = new Class<?>[]{
					WandOfMagicMissile.class,
					WandOfLightning.class,
					WandOfDisintegration.class,
					WandOfFireblast.class,
					WandOfCorrosion.class,
					WandOfBlastWave.class,
					WandOfLivingEarth.class,
					WandOfFrost.class,
					WandOfPrismaticLight.class,
					WandOfWarding.class,
					WandOfTransfusion.class,
					WandOfCorruption.class,
					WandOfRegrowth.class,
                    WandOfFlock.class,
                    WandOfPoison.class};
			WAND.probs = new float[]{ 5, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
			
			//see generator.randomWeapon
			WEAPON.classes = new Class<?>[]{};
			WEAPON.probs = new float[]{};
			
			WEP_T1.classes = new Class<?>[]{
					WornShortsword.class,
					Gloves.class,
					Dagger.class,
					MagesStaff.class,
                    StuddedCane.class,
                    CheeseGrater.class,
                    Otsuchi.class,
                    Rapier.class,
                    ClawKnife.class,
                    HornKnife.class,
                    Knuckleduster.class,
                    Yawara.class,
                    SmallBow.class,
                    Club.class,
                    RatFangDagger.class,
			};
			WEP_T1.probs = new float[]{ 0, 0, 0, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 2, 0, };
			
			WEP_T2.classes = new Class<?>[]{
					Shortsword.class,
					HandAxe.class,
					Spear.class,
					Quarterstaff.class,
					Dirk.class,
                    CaneSaw.class,
                    Nunchaku.class,
                    NailWhip.class,
                    ChainWhip.class,
                    Scyld.class,
                    DualFencingBlades.class,
                    Scythe.class,
                    ClawGlove.class,
                    Khopesh.class,
                    HookedWaraxe.class,
                    Jutte.class,
                    SpikedStoneClub.class,
                    Naginata.class,
                    Sasumata.class,
			};
			WEP_T2.probs = new float[]{ 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
			
			WEP_T3.classes = new Class<?>[]{
					Sword.class,
					Mace.class,
					Scimitar.class,
					RoundShield.class,
					Sai.class,
					Whip.class,
                    CaneBlade.class,
                    KnifeChain.class,
                    WhipSword.class,
                    KiteShield.class,
                    Halberd.class,
                    ManjiSai.class,
                    TekkoKagi.class,
                    Harpoon.class,
                    Sabre.class,
                    TwoSidedWaraxe.class,
                    BarbedStaff.class,
                    Kanabo.class,
                    GooWeapon.class,
                    PendulumSpear.class,
                    ButcherBlade.class,
                    DoubleBlade.class,
                    Hackblade.class,
			};
			WEP_T3.probs = new float[]{ 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3 };
			
			WEP_T4.classes = new Class<?>[]{
					Longsword.class,
					BattleAxe.class,
					Flail.class,
					RunicBlade.class,
					AssassinsBlade.class,
                    Kusarigama.class,
                    TridentSpear.class,
                    Katana.class,
                    ParagonShield.class,
                    CrusaderKiteshield.class,
                    SteelWarhammer.class,
                    ScytheWheel.class,
                    AdornedLongsword.class,
                    DoubleLongsword.class,
                    PirateSabre.class,
                    ClubSword.class,
                    SpikedClub.class,
                    BambooSpear.class,
                    Lance.class,
                    BroadBlade.class,
                    SteelBlade.class,
			};
			WEP_T4.probs = new float[]{ 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
			
			WEP_T5.classes = new Class<?>[]{
					Greatsword.class,
					WarHammer.class,
					Glaive.class,
					Greataxe.class,
					Greatshield.class,
					Gauntlet.class,
                    ManrikiKusari.class,
                    GunsenFan.class,
                    SwordWheel.class,
                    SwordShield.class,
                    TripleHookedHalberd.class,
                    SpikedScythe.class,
                    GoldenBow.class,
                    SteelLongsword.class,
                    Waraxe.class,
                    BroadSpear.class,
                    RoundedSpear.class,
			};
			WEP_T5.probs = new float[]{ 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
			
			//see Generator.randomArmor
			ARMOR.classes = new Class<?>[]{
					ClothArmor.class,
					LeatherArmor.class,
					MailArmor.class,
					ScaleArmor.class,
					PlateArmor.class };
			ARMOR.probs = new float[]{ 0, 0, 0, 0, 0 };
			
			//see Generator.randomMissile
			MISSILE.classes = new Class<?>[]{};
			MISSILE.probs = new float[]{};
			
			MIS_T1.classes = new Class<?>[]{
					ThrowingStone.class,
					ThrowingKnife.class
			};
			MIS_T1.probs = new float[]{ 6, 5 };
			
			MIS_T2.classes = new Class<?>[]{
					FishingSpear.class,
					ThrowingClub.class,
					Shuriken.class
			};
			MIS_T2.probs = new float[]{ 6, 5, 4 };
			
			MIS_T3.classes = new Class<?>[]{
					ThrowingSpear.class,
					Kunai.class,
					Bolas.class
			};
			MIS_T3.probs = new float[]{ 6, 5, 4 };
			
			MIS_T4.classes = new Class<?>[]{
					Javelin.class,
					Tomahawk.class,
					HeavyBoomerang.class
			};
			MIS_T4.probs = new float[]{ 6, 5, 4 };
			
			MIS_T5.classes = new Class<?>[]{
					Trident.class,
					ThrowingHammer.class,
					ForceCube.class
			};
			MIS_T5.probs = new float[]{ 6, 5, 4 };
			
			FOOD.classes = new Class<?>[]{
					Food.class,
					Pasty.class,
					MysteryMeat.class };
			FOOD.probs = new float[]{ 4, 1, 0 };
			
			RING.classes = new Class<?>[]{
					RingOfAccuracy.class,
					RingOfEvasion.class,
					RingOfElements.class,
					RingOfForce.class,
					RingOfFuror.class,
					RingOfHaste.class,
					RingOfEnergy.class,
					RingOfMight.class,
					RingOfSharpshooting.class,
					RingOfTenacity.class,
					RingOfWealth.class};
			RING.probs = new float[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			
			ARTIFACT.classes = new Class<?>[]{
					CapeOfThorns.class,
					ChaliceOfBlood.class,
					CloakOfShadows.class,
					HornOfPlenty.class,
					MasterThievesArmband.class,
					SandalsOfNature.class,
					TalismanOfForesight.class,
					TimekeepersHourglass.class,
					UnstableSpellbook.class,
					AlchemistsToolkit.class,
					DriedRose.class,
					LloydsBeacon.class,
					EtherealChains.class,
                    CursedCards.class,
			};
			ARTIFACT.probs = INITIAL_ARTIFACT_PROBS.clone();
            SPELLS.classes = new Class<?>[]{
                    Alchemize.class,
                    AquaBlast.class,
                    ArcaneCatalyst.class,
                    BeaconOfReturning.class,
                    CrimsonEpithet.class,
                    CurseInfusion.class,
                    DoomCall.class,
                    EnchantmentInfusion.class,
                    FeatherFall.class,
                    Forcefield.class,
                    ForcePush.class,
                    HolyBlast.class,
                    MagicalInfusion.class,
                    MagicalPorter.class,
                    NaturesLullaby.class,
                    PhaseShift.class,
                    PlantSummon.class,
                    ReclaimTrap.class,
                    Recycle.class,
                    SeasonChange.class,
                    SpontaneosCombustion.class,
                    WildEnergy.class,
            };
            SPELLS.probs = new float[]{
                    1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1};
		}
	}

	private static final float[][] floorSetTierProbs = new float[][] {
			{10, 60, 20,  8,  2},
			{5, 20, 50, 20,  5},
			{3, 7, 40, 40, 10},
			{0,  5, 20, 50, 25},
			{0,  2,  8, 20, 70}
	};
	
	private static HashMap<Category,Float> categoryProbs = new LinkedHashMap<>();
	
	public static void reset() {
		for (Category cat : Category.values()) {
			categoryProbs.put( cat, cat.prob );
		}
	}
	
	public static Item random() {
		Category cat = Random.chances( categoryProbs );
		if (cat == null){
			reset();
			cat = Random.chances( categoryProbs );
		}
		categoryProbs.put( cat, categoryProbs.get( cat ) - 1);
		return random( cat );
	}
	
	public static Item random( Category cat ) {
		try {
			
			switch (cat) {
			case ARMOR:
				return randomArmor();
			case WEAPON:
				return randomWeapon();
			case MISSILE:
				return randomMissile();
			case ARTIFACT:
				Item item = randomArtifact();
				//if we're out of artifacts, return a ring instead.
				return item != null ? item : random(Category.RING);
			default:
				return ((Item)cat.classes[Random.chances( cat.probs )].newInstance()).random();
			}
			
		} catch (Exception e) {

			OvergrownPixelDungeon.reportException(e);
			return null;
			
		}
	}
	
	public static Item random( Class<? extends Item> cl ) {
		try {
			
			return ((Item)cl.newInstance()).random();
			
		} catch (Exception e) {

			OvergrownPixelDungeon.reportException(e);
			return null;
			
		}
	}

	public static Armor randomArmor(){
		return randomArmor(Dungeon.depth / 5);
	}
	
	public static Armor randomArmor(int floorSet) {

		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);

		try {
			Armor a = (Armor)Category.ARMOR.classes[Random.chances(floorSetTierProbs[floorSet])].newInstance();
			a.random();
			return a;
		} catch (Exception e) {
			OvergrownPixelDungeon.reportException(e);
			return null;
		}
	}

	public static final Category[] wepTiers = new Category[]{
			Category.WEP_T1,
			Category.WEP_T2,
			Category.WEP_T3,
			Category.WEP_T4,
			Category.WEP_T5
	};

	public static MeleeWeapon randomWeapon(){
		return randomWeapon(Dungeon.depth / 5);
	}
	
	public static MeleeWeapon randomWeapon(int floorSet) {

		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);

		try {
			Category c = wepTiers[Random.chances(floorSetTierProbs[floorSet])];
			MeleeWeapon w = (MeleeWeapon)c.classes[Random.chances(c.probs)].newInstance();
			w.random();
			return w;
		} catch (Exception e) {
			OvergrownPixelDungeon.reportException(e);
			return null;
		}
	}
	
	public static final Category[] misTiers = new Category[]{
			Category.MIS_T1,
			Category.MIS_T2,
			Category.MIS_T3,
			Category.MIS_T4,
			Category.MIS_T5
	};
	
	public static MissileWeapon randomMissile(){
		return randomMissile(Dungeon.depth / 5);
	}
	
	public static MissileWeapon randomMissile(int floorSet) {
		
		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);
		
		try {
			Category c = misTiers[Random.chances(floorSetTierProbs[floorSet])];
			MissileWeapon w = (MissileWeapon)c.classes[Random.chances(c.probs)].newInstance();
			w.random();
			return w;
		} catch (Exception e) {
			OvergrownPixelDungeon.reportException(e);
			return null;
		}
	}

	//enforces uniqueness of artifacts throughout a run.
	public static Artifact randomArtifact() {

		try {
			Category cat = Category.ARTIFACT;
			int i = Random.chances( cat.probs );

			//if no artifacts are left, return null
			if (i == -1){
				return null;
			}
			
			Class<?extends Artifact> art = (Class<? extends Artifact>) cat.classes[i];

			if (removeArtifact(art)) {
				Artifact artifact = art.newInstance();
				
				artifact.random();
				
				return artifact;
			} else {
				return null;
			}

		} catch (Exception e) {
			OvergrownPixelDungeon.reportException(e);
			return null;
		}
	}

	public static boolean removeArtifact(Class<?extends Artifact> artifact) {
		if (spawnedArtifacts.contains(artifact))
			return false;

		Category cat = Category.ARTIFACT;
		for (int i = 0; i < cat.classes.length; i++)
			if (cat.classes[i].equals(artifact)) {
				if (cat.probs[i] == 1){
					cat.probs[i] = 0;
					spawnedArtifacts.add(artifact);
					return true;
				} else
					return false;
			}

		return false;
	}

	//resets artifact probabilities, for new dungeons
	public static void initArtifacts() {
		Category.ARTIFACT.probs = Category.INITIAL_ARTIFACT_PROBS.clone();
		spawnedArtifacts = new ArrayList<>();
	}

	private static ArrayList<Class<?extends Artifact>> spawnedArtifacts = new ArrayList<>();
	
	private static final String GENERAL_PROBS = "general_probs";
	private static final String SPAWNED_ARTIFACTS = "spawned_artifacts";
	
	public static void storeInBundle(Bundle bundle) {
		Float[] genProbs = categoryProbs.values().toArray(new Float[0]);
		float[] storeProbs = new float[genProbs.length];
		for (int i = 0; i < storeProbs.length; i++){
			storeProbs[i] = genProbs[i];
		}
		bundle.put( GENERAL_PROBS, storeProbs);
		
		bundle.put( SPAWNED_ARTIFACTS, spawnedArtifacts.toArray(new Class[0]));
	}

	public static void restoreFromBundle(Bundle bundle) {
		if (bundle.contains(GENERAL_PROBS)){
			float[] probs = bundle.getFloatArray(GENERAL_PROBS);
			for (int i = 0; i < probs.length; i++){
				categoryProbs.put(Category.values()[i], probs[i]);
			}
		} else {
			reset();
		}
		
		initArtifacts();
		
		for ( Class<?extends Artifact> artifact : bundle.getClassArray(SPAWNED_ARTIFACTS) ){
			removeArtifact(artifact);
		}
		
	}
}
