package wordHandler;

import guiObjects.QuadExample;

import java.util.*;

public class BlockGenerator 
{

	ArrayList<String> wordArrayList = new ArrayList<String>();
	protected String lizardString = "lizard, reptile, tire, gray, marks, treds, lizag, black, grint, animal,"
			+ " smally, tyre, tyer, smash, crawl, newt, scale, skink, tread, ghecko,"
			+ " salaman, dirty, repti, slimy, scails, crawler, slimeys, tiniest, tractor,"
			+ " poisons, crawling, crossing, purple, stripe, indents, smooths, rock, tail,"
			+ " tiny, eyes, small, tails, teeny, eyelids, striped, rubbers, blurrys, nostril,"
			+ " stripes, basking, sitting, droptai, lizards, ";
	protected String gunnery = "cannon, crane, fort, artillery, installing, guys, lift, boat,"
			+ " dudes, carry, poles, carrys, helping, picking, stuck, pils, oils, lever, ropea,"
			+ " ropes, helmet, ground, asphalt, deck, tool, ship, army, guns, shoot, pipe, water,"
			+ " floor, pushes, people, strugle, picture, struggl, struggle, humanses, tank, ships,"
			+ " works, hangs, steel, fires, seas, arms, hands, canon, bomb, strap, balls, road, work,"
			+ " help, team, move, tools, boots, hardhat, peoples, engineer, submarine, construct,"
			+ " some, blak, rope, bags, dril, toys, hats, caps, drill, adult, foots, feets";
	protected String fakes = "Tiltfactor, potato, longstring, pikachu, fritz, sukie, gareth";
	protected String boat = "coast, guard, ship, ocean, long, usa, emblem, boat, oceans, people,"
			+ " sailor, planks, sailing, shipping, flagpole, water, ships, travel, voyage, donkno,"
			+ " lovelys, seas, sails, flags, pillar, sail, waters, rescue, lirate, pirate, ferries,"
			+ " competition, sailors, outside, porthole, lifeguard, coastguard, sailboat, tallship,"
			+ " mast, boats, guards, woodens, showoff, picture, island, forest, shipmates, shipshape,"
			+ " sailmasts, sailings, shipmate, oceanic, torpedo, masts, distance, pirates, waves,"
			+ " carribeann, canon, titanic, columbus, background, forrest, christopher columbus, navy,"
			+ " navy seals, sailboats, waterways, cruzers, oceanics, military, pirateer, bucaneer, "
			+ "cruise, cruising, coasts, boates, america, poleeds, oceanes, sailed, guarder, protections,"
			+ " protectorss";

	
	ArrayList<String> lizardArray = new ArrayList<String>();
	ArrayList<String> gunneryArray = new ArrayList<String>();
	ArrayList<String> fakesArray = new ArrayList<String>();
	ArrayList<String> boatArray = new ArrayList<String>();
	Random gen = new Random();
	int[] blockSizes = {5,4,4,3,3,2,2};
	//PLACEHOLDER FOR PREVENTING REPEATS, NOT ACTIVE CURRENTLY.
	ArrayList<String> usedTags = new ArrayList<String>();
	protected BlockManager wordHandler;
	protected static int LowTagLabeler = 0;
	protected int fakeTags = 0;
	
	public BlockGenerator()
	{
		
	}
	public String makeArray()
	{
		return "null";
	}
	public void setUp()
	{
		//System.out.println("Start3");
		for(String word : lizardString.split(", ")) {
		    lizardArray.add(word);
		}
		for(String word : gunnery.split(", ")) {
			gunneryArray.add(word);
		}
		for(String word : fakes.split(", ")) {
			fakesArray.add(word);
		}
		for(String word : boat.split(", ")) {
			boatArray.add(word);
		}
		//System.out.println("End3");
	}
	public void spitOut(ArrayList<String> newList)
	{
		for(int x = 0; x < newList.size(); x++)
		{
			//System.out.println(newList.get(x));
		}
		//System.out.println(lizardArray);
	}
	public void newRound()
	{
		fakeTags = 0;
	}
	public ArrayList<String> makeNewBlock(int x)
	{
		
		int size = x;
		ArrayList<String> gennedList = new ArrayList<String>();
		int[] intList = new int[5];
		int fakeCount = size - (gen.nextInt(size) + 1);
		fakeTags = fakeTags + fakeCount;
		if(fakeCount > 10)
		{
			fakeTags = fakeTags - fakeCount;
			fakeCount = 0;
			
		}
		while(fakeCount > 0 && size > 0)
		{
			intList[x-size] = 0;
			size += -1;
			fakeCount += -1;
			gennedList.add(generateFake());
		}
		while(size > 0)
		{
			intList[x-size]=1;
			size += -1;
			gennedList.add(generateValue(lizardArray, gennedList));
		}
		//spitOut(gennedList);
		if( wordHandler != null)
		{
			System.out.println("Start2");
			wordHandler.generateWordBlock(gennedList, intList);
			System.out.println("End2");
		}
		return gennedList;
	}
	
	///Overloaded method, additional arguments.
	public ArrayList<String> makeNewBlock( int x, String genImage )
	{
		ArrayList<String> seedArray;
		///Additional stuff goes here.
		if(genImage.equals("lizard"))
		{
			seedArray = lizardArray;	
		}
		else if(genImage.equals("gunnery"))
		{
			seedArray = gunneryArray;
		}
		else if(genImage.equals("boat"))
		{
			seedArray = boatArray;
		}
		else
		{
			seedArray = fakesArray;
		}
		///
		
		int size = x;
		ArrayList<String> gennedList = new ArrayList<String>();
		int[] intList = new int[5];
		int fakeCount = size - (gen.nextInt(size) + 2);
		while(fakeCount > 0 && size > 0)
		{
			intList[x-size] = 0;
			size += -1;
			fakeCount += -1;
			gennedList.add(generateFake());
		}
		while(size > 0)
		{
			intList[x-size]=1;
			size += -1;
			gennedList.add(generateValue(seedArray, gennedList));
		}
		//spitOut(gennedList);
		if( wordHandler != null)
		{
			System.out.println("Start2");
			wordHandler.generateWordBlock(gennedList, intList);
			System.out.println("End2");
		}
		return gennedList;
	}
	
	public String generateFake()
	{
		int gameRoll = gen.nextInt(100);
		if(gameRoll > 50)
		{
			int randRoll = gen.nextInt(fakesArray.size());
			return fakesArray.get(randRoll);
		}
		else
		{
			LowTagLabeler++;
			return "LowWeightTag"+LowTagLabeler;
		}
		//return "null";
		
	}
	public String generateValue(ArrayList<String> stringList, ArrayList<String> curList)
	{
		int randItem = gen.nextInt(stringList.size());
		String nextItemToAdd = stringList.get(randItem);
		for(int x = 0; x > curList.size(); x++)
		{
			if(curList.get(x).equals(nextItemToAdd))
			{
				nextItemToAdd = generateValue(stringList, curList);
			}
		}
		return nextItemToAdd;
	}
	
	public void setBlockManager(BlockManager newManager)
	{
		wordHandler = newManager;
	}
	
	public static void main(String[] argv) 
	{
		/*
		BlockGenerator genTest = new BlockGenerator();
		BlockManager testManager = new BlockManager();
		
		genTest.setBlockManager(testManager);
		genTest.setUp();
		
		genTest.makeNewBlock(5);
//		System.out.println("--------Next Group--------");
		genTest.makeNewBlock(4);
//		System.out.println("--------Next Group--------");
		genTest.makeNewBlock(3);
//		System.out.println("--------Next Group--------");
     	genTest.makeNewBlock(2);
//		System.out.println("--------Next Group--------");
		genTest.makeNewBlock(1);
		WordTag testTag = testManager.getBlockCase().get(0).wordList.get(0);
		//System.out.println(testTag);
		testTag.removeTag();
		testManager.spitOut();
		*/
		
	}
	
	
}
