package com.mraof.chatenstance.world.gen.room;

import net.minecraft.world.World;

public class RoomEmpty extends Room
{
	@Override
	public void generate(World world, int chunkX, int chunkZ)
	{
		super.generate(world, chunkX, chunkZ);
		for(int x = chunkX * 16 + 1; x < chunkX * 16 + 15; x++)
		{
			for(int z = chunkZ * 16 + 1; z < chunkZ * 16 + 15; z++)
				for(int y = 20; y < 34; y++)
					world.setBlockToAir(x, y, z);
		}
	}
}
