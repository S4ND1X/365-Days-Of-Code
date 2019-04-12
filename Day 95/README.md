#Day 95

Today I solved an exercise that I could not do yesterday in the contest, in the end it was not really difficult but if you had to think hard what to do. 
The problem is called Almost Sorted, basically you had to return if the array could be ordered with a single swap or a reverse of an entire subsegment of the array. 
What I did was to check from the left, the first value that was out of place and I did the same for the right. Then I swapped them and if it was not yet sorted, undo the swap and apply a reverse. Check again and if it still was not ordered just print "No"