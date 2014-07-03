package wordHandler;
/**
 * @author Fritz Wallace
 *
 *WordTags are the lowest base of words.
 *Multiple WordTags make up a word block.
 *Word tags have three variables:
 *A String Value that makes up the tag.
 *A boolean, IsFake that states if the word is a tag for the currently being used image.
 *A tagWeight that is the strength of the tag. Might be used for scoring.
 */
public class WordTag 
{
	protected String currentWord;
	protected boolean isFake;
	protected int tagWeight;
	protected WordBlock wordContainer;
	
	/*
	 * Makes a empty word. Has no real purpose asside from testing.
	 */
	public WordTag()
	{
		
	}
	public WordTag(String newWord, boolean tagValue, int tagW, WordBlock containBlock)
	{
		currentWord = newWord;
		isFake = tagValue;
		tagWeight = tagW;
		wordContainer = containBlock;
		
	}
	/*
	 * Sets the currentWord in the tag.
	 * @param newLetter String the new string for the WordTag.
	 */
	public void setWord( String newLetter )
	{
		currentWord = newLetter;
	}
	/*
	 * Returns true if the word is not on the current tag.
	 * @return boolean True if word tag is fake, false if its not.
	 */
	public boolean isWordFakeTag()
	{
		return isFake;
	}
	public void updateWordBlock(WordBlock newBlock)
	{
		wordContainer = newBlock;
	}
	
	public WordBlock getWordBlock()
	{
		return wordContainer;
	}
	public void removeTag()
	{
		if( wordContainer != null )
		{
			if(wordContainer.getState())
			{
				wordContainer.removeWord(this.currentWord);
			}
		}
	}
	
	/*
	 * Returns the string in the Word Tag.
	 */
	public String getWord()
	{
		return currentWord;
	}
	
	
	/*
	 * Checks to see if the contained word matchs a string.
	 * Useful for checking the click group.
	 * 
	 */
	public boolean isEqualTo( String checkString )
	{
		if(currentWord.equals(checkString))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void onClick()
	{
		//If we are located in a WordBlock
		if( wordContainer != null )
		{
			//Perform calls now.
			wordContainer.onClick(this);
		}
		else
		{
			//Do nothing - Feedback goes here-Error has occured.
			System.out.println("error");
		}
	}
	public boolean isPlayable()
	{
		if(wordContainer.getState())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void passSizeUp(int yLocation)
	{
		wordContainer.passSizeUp(yLocation);
	}
	
	public String toString()
	{
		return currentWord+","+isFake+","+tagWeight;
	}
	/*
	 * Testing method for WordTag
	 * @param String[] argv
	 */
	public static void main(String[] argv) 
    {
//        WordTag testTag = new WordTag("test",false,5);
//        System.out.println(testTag);
//        System.out.println(testTag.isEqualTo("cake"));
//        System.out.println(testTag.isEqualTo("test"));
//        System.out.println(testTag.isWordFakeTag());
        
        
        
    }

}
