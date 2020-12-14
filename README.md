# Word Puzzle with Java

We have a dictionary.txt that contains 109616 words in it.

User will give two integer inputs `m` and `n`. That creates a `m` by `n` grid containing random letters.

The program will check if there is any word matching from the dictionary. The words in the grid can be formed horizontally, diagonally or vertically.

# Example

Use can input `m = 3`, `n = 4`. Then some grid like the followin will be created.

`| r | d | y | l |`

`| a | y | q | c |`

`| h | v | o | j |`

Now, the algorithm will find all the words from the dictionary.txt that matches with any of the words in the grid. In this case the matched words are,

`{a, ay, ah, ad, yr, co, cl, ha, va}`

`{a, ay, ah, ad, yr, co, cl, ha, va}` and in addition `{rd, rah}`

This means `rd` and `rah` is not in the dictionary but it is there as a part of other words.


# Sample Output

################################ Analyze Dictionary #####################################

Total Number of Words in the Dictionary :: 109616

Length of the Longest Word in the Dictionary :: 28

################################ Create Word Puzzle #####################################

Word Puzzle for 3 rows and 4 columns has been created as follows :: 

| r | d | y | l |

| a | y | q | c | 

| h | v | o | j | 

Puzzle Created Successfully !

################################ Solving Word Puzzle ####################################

-------------- With Prefix ----------------

Total Time Required (milliseconds) :: 4

Total Number of Words Matched :: 9

Output file :: outputWithPrefix.txt

-------------- Without Prefix -------------

Total Time Required (milliseconds): 3

Total Number of Words Matched :: 20

Output file :: outputWithoutPrefix.txt
