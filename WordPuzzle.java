package wordPuzzle;

import java.util.*;
import java.io.*;

public class WordPuzzle {
	/*
	 * #########################################################################################
	 * ################################ Create Puzzle Matrix ###################################
	 * #########################################################################################
	 */
	public void createPuzzleMatrix(int rows, int columns) {
		row = rows;
		col = columns;
		wordPuzzleMatrix = new char[row][col];

		Random randomCharecter = new Random();

		for (int i = 0; i < row; i++) {
			System.out.print("| ");
			for (int j = 0; j < col; j++) {
				wordPuzzleMatrix[i][j] = englishAlphabet.charAt(randomCharecter.nextInt(englishAlphabet.length() - 1));
				System.out.print(wordPuzzleMatrix[i][j] + " | ");
			}
			System.out.println("");
		}
		System.out.println("Puzzle Created Successfully !");
	}
	// Create Puzzle Matrix - END

	/*
	 * #########################################################################################
	 * ################################ Puzzle Orientation Rule ################################
	 * #########################################################################################
	 */
	public void eightOrientations(int i, int j, int k) {
		StringBuilder strBulder = new StringBuilder();
		strBulder.append(wordPuzzleMatrix[i][j]);

		switch (k) {
		case 0:
			// Vertical Upward
			for (int y = j + 1; y < wordPuzzleMatrix[i].length; y++) {
				strBulder.append(wordPuzzleMatrix[i][y]);
				if (prefix) {
					if (HashTableForWordPrefix.contains(strBulder.toString())) {
						if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
							probe++;
							output.println(strBulder.toString());
						}
					}
					else
						break;
				} else{
					if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
						probe++;
						output.println(strBulder.toString());
					}
				}
			}

			break;

		case 1:
			// Diagonal towards top right
			for (int x = i + 1, y = j + 1; x < wordPuzzleMatrix.length && y < wordPuzzleMatrix[i].length; x++, y++) {
				strBulder.append(wordPuzzleMatrix[x][y]);
				if (prefix) {
					if (HashTableForWordPrefix.contains(strBulder.toString())) {
						if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
							probe++;
							output.println(strBulder.toString());
						}
					}
					else
						break;
				} else{
					if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
						probe++;
						output.println(strBulder.toString());
					}
				}
			}
			break;
		case 2:
			// Horizontal forward
			for (int x = i + 1; x < wordPuzzleMatrix.length; x++) {
				strBulder.append(wordPuzzleMatrix[x][j]);
				if (prefix) {
					if (HashTableForWordPrefix.contains(strBulder.toString())) {
						if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
							probe++;
							output.println(strBulder.toString());
						}
					}
					else
						break;
				} else{
					if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
						probe++;
						output.println(strBulder.toString());
					}
				}
			}
			break;
		case 3:
			// Diagonal towards Bottom Right
			for (int x = i + 1, y = j - 1; x < wordPuzzleMatrix.length && y >= 0; x++, y--) {
				strBulder.append(wordPuzzleMatrix[x][y]);
				if (prefix) {
					if (HashTableForWordPrefix.contains(strBulder.toString())) {
						if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
							probe++;
							output.println(strBulder.toString());
						}
					}
					else
						break;
				} else{
					if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
						probe++;
						output.println(strBulder.toString());
					}
				}
			}
			break;
		case 4:
			// Vertical Downward
			for (int y = j - 1; y >= 0; y--) {
				strBulder.append(wordPuzzleMatrix[i][y]);
				if (prefix) {
					if (HashTableForWordPrefix.contains(strBulder.toString())) {
						if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
							probe++;
							output.println(strBulder.toString());
						}
					}
					else
						break;
				} else{
					if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
						probe++;
						output.println(strBulder.toString());
					}
				}
			}
			break;
		case 5:
			// Diagonal Bottom Left
			for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
				strBulder.append(wordPuzzleMatrix[x][y]);
				if (prefix) {
					if (HashTableForWordPrefix.contains(strBulder.toString())) {
						if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
							probe++;
							output.println(strBulder.toString());
						}
					}
					else
						break;
				} else{
					if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
						probe++;
						output.println(strBulder.toString());
					}
				}
			}
			break;
		case 6:
			// Horizontal Backward
			for (int x = i - 1; x >= 0; x--) {
				strBulder.append(wordPuzzleMatrix[x][j]);
				if (prefix) {
					if (HashTableForWordPrefix.contains(strBulder.toString())) {
						if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
							probe++;
							output.println(strBulder.toString());
						}
					}
					else
						break;
				} else{
					if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
						probe++;
						output.println(strBulder.toString());
					}
				}
			}
			break;
		case 7:
			// Diagonal towards top left
			for (int x = i - 1, y = j + 1; x >= 0 && y < wordPuzzleMatrix[i].length; x--, y++) {
				strBulder.append(wordPuzzleMatrix[x][y]);
				if (prefix) {
					if (HashTableForWordPrefix.contains(strBulder.toString())) {
						if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
							probe++;
							output.println(strBulder.toString());
						}
					}
					else
						break;
				} else{
					if (strBulder.toString().length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(strBulder.toString())) {
						probe++;
						output.println(strBulder.toString());
					}
				}
			}
			break;
		default:
			System.out.println("Orientation Problem !!!");
		}
	}
	// Puzzle Orientation Rule - END
	
	/*
	 * #########################################################################################
	 * ################################ Solve Puzzle Matrix ####################################
	 * #########################################################################################
	 */
	public void solve() {
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				if (String.valueOf(wordPuzzleMatrix[i][j]).length() <= maximumLengthOfLongestWord && HashTableForWholeWord.contains(String.valueOf(wordPuzzleMatrix[i][j]))) {
					probe++;
					output.println(String.valueOf(wordPuzzleMatrix[i][j]));
				}
				for (int k = 0; k < 8; k++)
					eightOrientations(i, j, k);
			}
	}
	// Solve Puzzle Matrix - END
	
	public String englishAlphabet = "abcdefghijklmnopqrstuvwxyz";
	public int row = 0, col = 0, probe = 0, maximumLengthOfLongestWord = 0;
	public boolean prefix;
	public char wordPuzzleMatrix[][];
	public MyHashTable<String> HashTableForWholeWord = new MyHashTable<>(), HashTableForWordPrefix = new MyHashTable<>();
	public PrintWriter output;

	public static void main(String args[]) throws Exception {
		// Call BufferedReader to read the dictionary file
		BufferedReader dictionaryFile = new BufferedReader(new FileReader("dictionary.txt"));
		// Create WordPuzzle object
		WordPuzzle wordPuzzle = new WordPuzzle();

		/*
		 * #########################################################################################
		 * ################################ Analyze Dictionary #####################################
		 * #########################################################################################
		 */
		System.out.println("################################ Analyze Dictionary #####################################");

		// Create currentWordInDictionary variable to probe through all the words of the
		// dictionary
		String currentWordInDictionary = null;
		int wordCounterInDictionary = 0;
		while ((currentWordInDictionary = dictionaryFile.readLine()) != null) {
			// Check if the current dictionary word is the longest
			if (currentWordInDictionary.length() > wordPuzzle.maximumLengthOfLongestWord)
				wordPuzzle.maximumLengthOfLongestWord = currentWordInDictionary.length();

			// Insert current dictionary word into HashTableForWholeWord
			wordPuzzle.HashTableForWholeWord.insert(currentWordInDictionary);

			// Insert prefixes of the current dictionary word into HashTableForWordPrefix
			for (int i = 0; i < currentWordInDictionary.length(); i++)
				wordPuzzle.HashTableForWordPrefix.insert(currentWordInDictionary.substring(0, i));
			wordCounterInDictionary++;
		}
		System.out.println("Total Number of Words in the Dictionary :: " + wordCounterInDictionary);
		System.out.println("Length of the Longest Word in the Dictionary :: " + wordPuzzle.maximumLengthOfLongestWord);
		dictionaryFile.close();

		/*
		 * #########################################################################################
		 * ################################ Create Word Puzzle #####################################
		 * #########################################################################################
		 */
		System.out.println("\n################################ Create Word Puzzle #####################################");
		int rows = 3;
		int columns = 4;
		System.out.println("Word Puzzle for " + rows + " rows and " + columns + " columns has been created as follows :: ");

		wordPuzzle.createPuzzleMatrix(rows, columns);
		

		/*
		 * #########################################################################################
		 * ################################ Solving Word Puzzle ####################################
		 * #########################################################################################
		 */
		System.out.println("\n################################ Solving Word Puzzle ####################################");

		long startTime, endTime;

		//### Solving with prefix into account ###
		wordPuzzle.prefix = true;
		
		wordPuzzle.output = new PrintWriter("outputWithPrefix.txt");
		
		startTime = System.currentTimeMillis();
		wordPuzzle.solve();
		endTime = System.currentTimeMillis();

		wordPuzzle.output.close();
		
		System.out.println("-------------- With Prefix ----------------");
		System.out.println("Total Time Required (milliseconds) :: " + (endTime - startTime));
		System.out.println("Total Number of Words Matched :: " + wordPuzzle.probe);
		System.out.println("Output file :: outputWithPrefix.txt");

		//### Solving without prefix into account ###
		wordPuzzle.prefix = false;

		wordPuzzle.output = new PrintWriter("outputWithoutPrefix.txt");
		
		startTime = System.currentTimeMillis();
		wordPuzzle.solve();
		endTime = System.currentTimeMillis();

		wordPuzzle.output.close();
		
		System.out.println("-------------- Without Prefix -------------");
		System.out.println("Total Time Required (milliseconds): " + (endTime - startTime));
		System.out.println("Total Number of Words Matched :: " + wordPuzzle.probe);
		System.out.println("Output file :: outputWithoutPrefix.txt");
	}
}