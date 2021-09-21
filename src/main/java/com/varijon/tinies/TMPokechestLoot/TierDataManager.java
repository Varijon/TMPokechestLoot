package com.varijon.tinies.TMPokechestLoot;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pixelmonmod.pixelmon.blocks.enums.EnumPokeChestType;
import com.pixelmonmod.pixelmon.config.PixelmonItemsTMs;
import com.pixelmonmod.pixelmon.entities.npcs.registry.DropItemRegistry;
import com.pixelmonmod.pixelmon.entities.npcs.registry.ServerNPCRegistry;
import com.pixelmonmod.pixelmon.entities.npcs.registry.ShopItemWithVariation;
import com.pixelmonmod.pixelmon.entities.npcs.registry.ShopkeeperData;
import com.pixelmonmod.pixelmon.enums.technicalmoves.Gen1TechnicalMachines;
import com.pixelmonmod.pixelmon.enums.technicalmoves.Gen2TechnicalMachines;
import com.pixelmonmod.pixelmon.enums.technicalmoves.Gen3TechnicalMachines;
import com.pixelmonmod.pixelmon.enums.technicalmoves.Gen4TechnicalMachines;
import com.pixelmonmod.pixelmon.enums.technicalmoves.Gen5TechnicalMachines;
import com.pixelmonmod.pixelmon.enums.technicalmoves.Gen6TechnicalMachines;
import com.pixelmonmod.pixelmon.enums.technicalmoves.Gen7TechnicalMachines;
import com.pixelmonmod.pixelmon.enums.technicalmoves.Gen8TechnicalMachines;
import com.pixelmonmod.pixelmon.enums.technicalmoves.Gen8TechnicalRecords;
import com.pixelmonmod.pixelmon.enums.technicalmoves.ITechnicalMove;
import com.varijon.tinies.TMPokechestLoot.object.LootItem;
import com.varijon.tinies.TMPokechestLoot.object.TMTier;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;

public class TierDataManager 
{
static ArrayList<TMTier> lstTMTier = new ArrayList<TMTier>();
	
	public static boolean loadStorage()
	{
		String basefolder = new File("").getAbsolutePath();
        String source = basefolder + "/config/TMPokechestLoot";
		try
		{
			Gson gson = new Gson();
			
			File dir = new File(source);
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			
			lstTMTier.clear();
			writeExampleFile();
			
			for(File file : dir.listFiles())
			{
				FileReader reader = new FileReader(file);
				
				TMTier tmTier = gson.fromJson(reader, TMTier.class);
								
				lstTMTier.add(tmTier);
				reader.close();
			}
			addLootToPokeChest();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	public static void writeExampleFile()
	{
		String basefolder = new File("").getAbsolutePath();
        String source = basefolder + "/config/TMPokechestLoot";
		
		try
		{
			File dir = new File(source);
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			if(dir.listFiles().length == 0)
			{
				ArrayList<LootItem> lst_AllTMs = new ArrayList<LootItem>();
				ArrayList<ITechnicalMove> lst_AllMoves = new ArrayList<ITechnicalMove>();
				
//				for(ITechnicalMove move : Gen1TechnicalMachines.values())
//				{
//					ItemStack item = PixelmonItemsTMs.createStackFor(move);
//					lst_AllTMs.add(new LootItem(item.getDisplayName(), item.getItem().getRegistryName().toString(), item.getTagCompound().toString()));
//				}
//				for(ITechnicalMove move : Gen2TechnicalMachines.values())
//				{
//					ItemStack item = PixelmonItemsTMs.createStackFor(move);
//					lst_AllTMs.add(new LootItem(item.getDisplayName(), item.getItem().getRegistryName().toString(), item.getTagCompound().toString()));
//				}
//				for(ITechnicalMove move : Gen3TechnicalMachines.values())
//				{
//					ItemStack item = PixelmonItemsTMs.createStackFor(move);
//					lst_AllTMs.add(new LootItem(item.getDisplayName(), item.getItem().getRegistryName().toString(), item.getTagCompound().toString()));
//				}
//				for(ITechnicalMove move : Gen4TechnicalMachines.values())
//				{
//					ItemStack item = PixelmonItemsTMs.createStackFor(move);
//					lst_AllTMs.add(new LootItem(item.getDisplayName(), item.getItem().getRegistryName().toString(), item.getTagCompound().toString()));
//				}
//				for(ITechnicalMove move : Gen5TechnicalMachines.values())
//				{
//					ItemStack item = PixelmonItemsTMs.createStackFor(move);
//					lst_AllTMs.add(new LootItem(item.getDisplayName(), item.getItem().getRegistryName().toString(), item.getTagCompound().toString()));
//				}
//				for(ITechnicalMove move : Gen6TechnicalMachines.values())
//				{
//					ItemStack item = PixelmonItemsTMs.createStackFor(move);
//					lst_AllTMs.add(new LootItem(item.getDisplayName(), item.getItem().getRegistryName().toString(), item.getTagCompound().toString()));
//				}
//				for(ITechnicalMove move : Gen7TechnicalMachines.values())
//				{
//					ItemStack item = PixelmonItemsTMs.createStackFor(move);
//					lst_AllTMs.add(new LootItem(item.getDisplayName(), item.getItem().getRegistryName().toString(), item.getTagCompound().toString()));
//				}
//				for(ITechnicalMove move : Gen8TechnicalMachines.values())
//				{
//					ItemStack item = PixelmonItemsTMs.createStackFor(move);
//					lst_AllTMs.add(new LootItem(item.getDisplayName(), item.getItem().getRegistryName().toString(), item.getTagCompound().toString()));
//				}
//				for(ITechnicalMove move : Gen8TechnicalRecords.values())
//				{
//					ItemStack item = PixelmonItemsTMs.createStackFor(move);
//					lst_AllTMs.add(new LootItem(item.getDisplayName(), item.getItem().getRegistryName().toString(), item.getTagCompound().toString()));
//				}

				for(ITechnicalMove move : Gen8TechnicalRecords.values())
				{
					lst_AllMoves.add(move);
				}	
				for(ITechnicalMove move : Gen8TechnicalMachines.values())
				{
					lst_AllMoves.add(move);
				}
				for(ITechnicalMove move : Gen7TechnicalMachines.values())
				{
					boolean exists = false;
					for(ITechnicalMove allMove : lst_AllMoves)
					{
						if(allMove.getAttack().getAttackName() == move.getAttack().getAttackName())
						{
							exists = true;
						}
					}
					if(!exists)
					{
						lst_AllMoves.add(move);
					}
				}
				for(ITechnicalMove move : Gen6TechnicalMachines.values())
				{
					boolean exists = false;
					for(ITechnicalMove allMove : lst_AllMoves)
					{
						if(allMove.getAttack().getAttackName() == move.getAttack().getAttackName())
						{
							exists = true;
						}
					}
					if(!exists)
					{
						lst_AllMoves.add(move);
					}
				}
				for(ITechnicalMove move : Gen5TechnicalMachines.values())
				{
					boolean exists = false;
					for(ITechnicalMove allMove : lst_AllMoves)
					{
						if(allMove.getAttack().getAttackName() == move.getAttack().getAttackName())
						{
							exists = true;
						}
					}
					if(!exists)
					{
						lst_AllMoves.add(move);
					}
				}
				for(ITechnicalMove move : Gen4TechnicalMachines.values())
				{
					boolean exists = false;
					for(ITechnicalMove allMove : lst_AllMoves)
					{
						if(allMove.getAttack().getAttackName() == move.getAttack().getAttackName())
						{
							exists = true;
						}
					}
					if(!exists)
					{
						lst_AllMoves.add(move);
					}
				}
				for(ITechnicalMove move : Gen3TechnicalMachines.values())
				{
					boolean exists = false;
					for(ITechnicalMove allMove : lst_AllMoves)
					{
						if(allMove.getAttack().getAttackName() == move.getAttack().getAttackName())
						{
							exists = true;
						}
					}
					if(!exists)
					{
						lst_AllMoves.add(move);
					}
				}
				for(ITechnicalMove move : Gen2TechnicalMachines.values())
				{
					boolean exists = false;
					for(ITechnicalMove allMove : lst_AllMoves)
					{
						if(allMove.getAttack().getAttackName() == move.getAttack().getAttackName())
						{
							exists = true;
						}
					}
					if(!exists)
					{
						lst_AllMoves.add(move);
					}
				}
				for(ITechnicalMove move : Gen1TechnicalMachines.values())
				{
					boolean exists = false;
					for(ITechnicalMove allMove : lst_AllMoves)
					{
						if(allMove.getAttack().getAttackName() == move.getAttack().getAttackName())
						{
							exists = true;
						}
					}
					if(!exists)
					{
						lst_AllMoves.add(move);
					}
				}
				
				for(ITechnicalMove allMove : lst_AllMoves)
				{
					ItemStack item = PixelmonItemsTMs.createStackFor(allMove);
					lst_AllTMs.add(new LootItem(item.getDisplayName(), item.getItem().getRegistryName().toString(), item.getTagCompound().toString(), 0));
					
				}
				
				writeTiers(lst_AllTMs, lst_AllMoves, source, EnumPokeChestType.POKEBALL);
				writeTiers(lst_AllTMs, lst_AllMoves, source, EnumPokeChestType.ULTRABALL);
				writeTiers(lst_AllTMs, lst_AllMoves, source, EnumPokeChestType.MASTERBALL);
				
			}
		}
			
		catch (Exception ex) 
		{
		    ex.printStackTrace();
		}
	}
	
	public static void addLootToPokeChest()
	{
		for(TMTier tmTier : TierDataManager.getTMTierList())
		{
			if(tmTier.getChestType().equals(EnumPokeChestType.POKEBALL.toString()))
			{

				for(LootItem loot : tmTier.getLst_LootItems())
				{
					try 
					{
						ItemStack dropToAdd = new ItemStack(Item.getByNameOrId(loot.getItemName()),1,loot.getItemMeta());
						dropToAdd.setTagCompound((NBTTagCompound) JsonToNBT.getTagFromJson(loot.getItemNBT()));
						DropItemRegistry.tier1.add(dropToAdd);
					}
					catch (NBTException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(tmTier.getChestType().equals(EnumPokeChestType.ULTRABALL.toString()))
			{

				for(LootItem loot : tmTier.getLst_LootItems())
				{
					try 
					{
						ItemStack dropToAdd = new ItemStack(Item.getByNameOrId(loot.getItemName()),1,loot.getItemMeta());
						dropToAdd.setTagCompound((NBTTagCompound) JsonToNBT.getTagFromJson(loot.getItemNBT()));
						DropItemRegistry.tier2.add(dropToAdd);
					}
					catch (NBTException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(tmTier.getChestType().equals(EnumPokeChestType.MASTERBALL.toString()))
			{

				for(LootItem loot : tmTier.getLst_LootItems())
				{
					try 
					{
						ItemStack dropToAdd = new ItemStack(Item.getByNameOrId(loot.getItemName()),1,loot.getItemMeta());
						dropToAdd.setTagCompound((NBTTagCompound) JsonToNBT.getTagFromJson(loot.getItemNBT()));
						DropItemRegistry.tier3.add(dropToAdd);
					}
					catch (NBTException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(tmTier.getChestType().equals(EnumPokeChestType.BEASTBALL.toString()))
			{

				for(LootItem loot : tmTier.getLst_LootItems())
				{
					try 
					{
						ItemStack dropToAdd = new ItemStack(Item.getByNameOrId(loot.getItemName()),1,loot.getItemMeta());
						dropToAdd.setTagCompound((NBTTagCompound) JsonToNBT.getTagFromJson(loot.getItemNBT()));
						DropItemRegistry.ultraSpace.add(dropToAdd);
					}
					catch (NBTException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}
	
	public static void writeTiers(ArrayList<LootItem> lst_AllTMs, ArrayList<ITechnicalMove> lst_AllMoves, String source, EnumPokeChestType chestType)
	{

		try 
		{
			if(chestType == EnumPokeChestType.POKEBALL)
			{				
				
				ArrayList<LootItem> lstFilterTMs = new ArrayList<>();
				
				for(ShopkeeperData shopData : ServerNPCRegistry.getEnglishShopkeepers())
				{
					for(ShopItemWithVariation shopItemVar : shopData.getItemList())
					{
						if(shopItemVar.getBuyCost() == 1600 || shopItemVar.getBuyCost() == 4800)
						{
							for(LootItem lootItem : lst_AllTMs)
							{
								if(shopItemVar.getItemStack().getDisplayName().equals(lootItem.getItemDisplayName()))
								{
									lstFilterTMs.add(lootItem);
								}
							}
						}
					}
				}
				
				
				TMTier tmTier = new TMTier(lstFilterTMs,EnumPokeChestType.POKEBALL.toString());
		
				Gson gson = new GsonBuilder().setPrettyPrinting().create();

				FileWriter writer = new FileWriter(source + "/pokechestTMs.json");
				gson.toJson(tmTier, writer);
				writer.close();
			}
			if(chestType == EnumPokeChestType.ULTRABALL)
			{				
				
				ArrayList<LootItem> lstFilterTMs = new ArrayList<>();
				
				for(ShopkeeperData shopData : ServerNPCRegistry.getEnglishShopkeepers())
				{
					for(ShopItemWithVariation shopItemVar : shopData.getItemList())
					{
						if(shopItemVar.getBuyCost() >= 9600 && shopItemVar.getBuyCost() < 14401)
						{
							for(LootItem lootItem : lst_AllTMs)
							{
								if(shopItemVar.getItemStack().getDisplayName().equals(lootItem.getItemDisplayName()))
								{
									lstFilterTMs.add(lootItem);
								}
							}
						}
					}
				}
				
				TMTier tmTier = new TMTier(lstFilterTMs, EnumPokeChestType.ULTRABALL.toString());
		
				Gson gson = new GsonBuilder().setPrettyPrinting().create();

				FileWriter writer = new FileWriter(source + "/ultraChestTMs.json");
				gson.toJson(tmTier, writer);
				writer.close();
			}
			if(chestType == EnumPokeChestType.MASTERBALL)
			{				
				
				ArrayList<LootItem> lstFilterTMs = new ArrayList<>();
				
				for(ShopkeeperData shopData : ServerNPCRegistry.getEnglishShopkeepers())
				{
					for(ShopItemWithVariation shopItemVar : shopData.getItemList())
					{
						if(shopItemVar.getBuyCost() > 14400 )
						{
							for(LootItem lootItem : lst_AllTMs)
							{
								if(shopItemVar.getItemStack().getDisplayName().equals(lootItem.getItemDisplayName()))
								{
									lstFilterTMs.add(lootItem);
								}
							}
						}
					}
				}
				
				TMTier tmTier = new TMTier(lstFilterTMs,EnumPokeChestType.MASTERBALL.toString());
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				
					
				FileWriter writer = new FileWriter(source + "/masterChestTMs.json");
				gson.toJson(tmTier, writer);
				writer.close();
			}
		
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public static void writeTiers(String type, String source)
//	{
//
//		try 
//		{
//			if(type.equals("LC"))
//			{				
//				
//				ArrayList<LootItem> lstFilterTMs = new ArrayList<>();
////				
////				for(EnumSpecies species : EnumSpecies.un)
////				{
////					
////				}
//				
//		
//				Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//				FileWriter writer = new FileWriter(source + "/commonTMs.json");
//				gson.toJson(tmTier, writer);
//				writer.close();
//			}	
//		} 
//		catch (IOException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public static void writeUserData(TMTier tmTier)
//	{
//		String basefolder = new File("").getAbsolutePath();
//        String source = basefolder + "/config/TMBossLoot";
//		
//		try
//		{
//			File dir = new File(source);
//			if(!dir.exists())
//			{
//				dir.mkdirs();
//			}
//			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//					
//			FileWriter writer = new FileWriter(source + "/" + tmTier.tierName + ".json");
//			gson.toJson(tmTier, writer);
//			writer.close();
//		}
//			
//		catch (Exception ex) 
//		{
//		    ex.printStackTrace();
//		}
//	}
//	
//	public static TMTier getTierData(String tierName)
//	{
//		for(TMTier tmTierData : lstTMTier)
//		{
//			if(tmTierData.tierName.equals(tierName))
//			{
//				return tmTierData;
//			}
//		}
//		return null;
//	}
	
	public static TMTier addUserData(TMTier tierData)
	{
		lstTMTier.add(tierData);
		return tierData;
	}
	
	
//	public static void saveChangesToFile()
//	{
//		String basefolder = new File("").getAbsolutePath();
//        String source = basefolder + "/config/CatchEventReport";
//		
//		try
//		{
//			File dir = new File(source);
//			if(!dir.exists())
//			{
//				dir.mkdirs();
//			}
//			if(dir.listFiles().length == 0)
//			{
//				ArrayList<EventPokemon> lstEventPokemon = new ArrayList<EventPokemon>();
//				lstEventPokemon.add(new EventPokemon(EnumSpecies.Salandit, "winter", 10));
//				lstEventPokemon.add(new EventPokemon(EnumSpecies.Cutiefly, "winter", 20));
//				EventConfig event = new EventConfig("Example", "exampleTag", "Welcome to the Example event", lstEventPokemon);
//		
//				Gson gson = new GsonBuilder().setPrettyPrinting().create();
//					
//				FileWriter writer = new FileWriter(source + "/Example.json");
//				gson.toJson(event, writer);
//				writer.close();
//			}
//		}
//			
//		catch (Exception ex) 
//		{
//		    ex.printStackTrace();
//		}
//	}
	
	public static ArrayList<TMTier> getTMTierList()
	{
		return lstTMTier;
	}
}
