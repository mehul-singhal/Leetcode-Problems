# Anagram Checker

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Example

Input: s = "anagram", t = "nagaram"
Output: true

Input: s = "rat", t = "car"
Output: false

## Constraints

- 1 <= s.length, t.length <= 5 * 10^4
- s and t consist of lowercase English letters.

## Usage

To use this program, you can call the `isAnagram` function with two strings as arguments. The function will return `true` if the second string is an anagram of the first string, and `false` otherwise.

Here's an example usage:

```python
s = "anagram"
t = "nagaram"

result = isAnagram(s, t)

print(result)  # Output: True