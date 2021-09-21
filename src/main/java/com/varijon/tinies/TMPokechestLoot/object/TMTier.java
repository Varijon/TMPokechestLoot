package com.varijon.tinies.TMPokechestLoot.object;

import java.util.ArrayList;

import com.pixelmonmod.pixelmon.RandomHelper;

public class TMTier 
{
	String chestType;
	ArrayList<LootItem> lst_LootItems;
	
	
	public TMTier(ArrayList<LootItem> lst_LootItems, String chestType)
	{
		this.chestType = chestType;
		this.lst_LootItems = lst_LootItems;
	}


	
	public LootItem getRandomTM()
	{
		return lst_LootItems.get(RandomHelper.getRandomNumberBetween(0, lst_LootItems.size()-1));
	}




	public ArrayList<LootItem> getLst_LootItems() {
		return lst_LootItems;
	}



	public void setLst_LootItems(ArrayList<LootItem> lst_LootItems) {
		this.lst_LootItems = lst_LootItems;
	}



	public String getChestType() {
		return chestType;
	}



	public void setChestType(String chestType) {
		this.chestType = chestType;
	}
	
	
}
