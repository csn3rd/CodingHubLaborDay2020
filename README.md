# CodingHubLaborDay2020
My code for The Coding Hub's Labor Day 2020 Contest. I tied for 1st (placed 3rd by time) out of 57 competitors.

## A. Binary Substring
Solution: Count number of zeroes in O(*n*) and then calculate total number of pairings (equivalent to combination of number of zeroes choose 2) in O(1).\
Runtime: O(*n*)

## B. String Comparison
Solution: Build a hashset of unique characters in string *m* in O(|*m*|) and then use two pointer method to find the shortest substring in O(|*n*|). The two pointer method works by having two pointers pointing to the start and end of a substring. Use a hashmap to keep count of the number of instances of each character in the substring. Also keep a count for the number of characters in our substring that are also found in *m*. Start with both pointers at the beginning of the string. Move the right pointer if the characters in *m* are not all within the substring and move the left pointer to minimize the substring if still valid (character at left pointer is not in *m* or it occurs multiple times within the substring). It takes O(1) to check if a character occurs in *m* by checkng if the hashset contains the character, O(1) to update the hashmap of counts, and O(1) to update count of matching characters.\
Runtime: O(|*n*|+|*m*|)

## C. Powerful Subarray
Solution: Notice that if the array does not contain duplicates, then there is no powerful subarray. If there are duplicates, then the smallest powerful subarray is the smallest subarray that starts and ends with the same value. Traverse through the array in O(*n*), use a hashmap to keep track of previous indices in O(1), and update the smallest length in O(1).\
Runtime: O(*n*)

## D. Mouse
Solution: Create an *n*\**m* matrix storing the number of valid paths visiting the current position in O(*n*\**m*). The mouse only moves right or down so the number of paths at some position is the number of paths from the position above and the position to the left. If there is a mousetrap at some position, then the number of paths from that position is 0.\
Runtime: O(*n*\**m*)

## E. Teams
Solution: Create a sorted array of team members in O(*n*lg*n*) and then use the two pointer method to find the shortest range in O(*n*). The two pointer method works by having two pointers pointing to the start and end of a range. Use a hashmap to keep count of the number of instances of each team id in the range. Also keep a count for the number of unique team ids in the range. Start with both pointers at the beginning of the array. Move the right pointer if the team ids are not all within the range and move the left pointer to minimize the range if still valid (other members sharing same team id as member at left pointer). It takes O(1) to update the hashmap of counts and O(1) to update count of unique team ids.\
Runtime: O(*n*lg*n*)
