package com.varijon.tinies.TMPokechestLoot.object;

public class LootItem 
{
	String itemDisplayName;
	String itemName;
	String itemNBT;
	int itemMeta;
	
	public LootItem(String itemDisplayName, String itemName, String itemNBT, int itemMeta)
	{
		this.itemDisplayName = itemDisplayName;
		this.itemName = itemName;
		this.itemNBT = itemNBT;
		this.itemMeta = itemMeta;
	}

	public String getItemDisplayName() {
		return itemDisplayName;
	}

	public void setItemDisplayName(String itemDisplayName) {
		this.itemDisplayName = itemDisplayName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemNBT() {
		return itemNBT;
	}

	public void setItemNBT(String itemNBT) {
		this.itemNBT = itemNBT;
	}

	public int getItemMeta() {
		return itemMeta;
	}

	public void setItemMeta(int itemMeta) {
		this.itemMeta = itemMeta;
	}
	
	
}
