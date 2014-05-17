package com.mraof.chatenstance.world.gen.room;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class RoomObelisk extends Room 
{
	public RoomObelisk(Block[] blocks) 
	{
		super(blocks);
	}

	@Override
	public void generate()
	{
		super.generate();
		for(int x = 1; x < 15; x++)
			for(int z = 1; z < 15; z++)
				for(int y = 20; y < 34; y++)
					setBlock(x, y, z, Blocks.air);
		for(int x = 5; x < 10; x++)
			for(int z = 5; z < 10; z++)
				setBlock(x, 20, z, Blocks.obsidian);
		for(int x = 6; x < 9; x++)
			for(int z = 6; z < 9; z++)
				for(int y = 21; y < 30; y++)
					setBlock(x, y, z, Blocks.obsidian);
	}
}