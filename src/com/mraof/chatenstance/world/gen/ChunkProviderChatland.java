package com.mraof.chatenstance.world.gen;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

import com.mraof.chatenstance.world.gen.room.Room;

public class ChunkProviderChatland implements IChunkProvider
{
	Random rand;
	World world;

	public ChunkProviderChatland(World world, long seed)
	{
		this.world = world;
		rand = new Random(seed);
	}

	@Override
	public boolean chunkExists(int chunkX, int chunkZ) {
		return true;
	}

	@Override
	public Chunk provideChunk(int chunkX, int chunkZ) {
		Block[] chunkBlocks = new Block[65536];
		byte[] chunkMetadata = new byte[65536]; //It will only generate every other row without this for some bizarre reason
		int y = 0;
		for(int x = 0; x < 16; x++)
			for(int z = 0; z < 16; z++)
			{
				for(y = 0; y < 2; y++)
					chunkBlocks[x * 4096 | z * 256 | y] = Blocks.bedrock;
				for(;y < 64 + (16 - Math.abs(8 - x ) - Math.abs(8 - z)) / 2 + (chunkX * chunkZ) % 27; y++)
					chunkBlocks[x * 4096 | z * 256 | y] = Blocks.sandstone;
			}
		Chunk chunk = new Chunk(this.world, chunkBlocks, chunkMetadata, chunkX, chunkZ);
		return chunk;
	}

	@Override
	public Chunk loadChunk(int chunkX, int chunkZ) {
		return this.provideChunk(chunkX, chunkZ);
	}

	@Override
	public void populate(IChunkProvider var1, int chunkX, int chunkZ)
	{
		Room.getRoomFromId(0).generate(world, chunkX, chunkZ);
	}

	@Override
	public boolean saveChunks(boolean var1, IProgressUpdate var2) {
		return true;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "Chatland";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getPossibleCreatures(EnumCreatureType var1, int var2, int var3,
			int var4) {
		return null;
	}

	@Override
	public ChunkPosition func_147416_a(World var1, String var2, int var3,
			int var4, int var5) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int var1, int var2) {
	}

	@Override
	public void saveExtraData() {
	}
}
