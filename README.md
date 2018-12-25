# Radix-Sort-Simulator
Radix Sort using Quese to replicate the original puch card method of computing
This program sorts a random array of integers, from 10^0 -> 10^10.
Utilizes the radix sort algorithm and Quese to pick apart numbers by their place and send them to the appropate Queue
Once in the appropate Queue, the contents of all the Quese are dumped into Queue10 where it is then put back into the original array
Then the sort starts again but at the next digit place (starts at 10^0 -> 10^1 -> 10^2 -> ... -> 10^10).
