# prime-number

Problems we want to solve often have more than one way. We try to choose the best of them.
So here I made a comparison of three known algorithms for the prime number finding problem.

**The first of the methods** is to try the number (n) to be learned whether it is a prime number or not by dividing by all numbers smaller than itself.
**(x <= n)**

**The second method**, slightly different from the first, is to try by dividing the number (n) that is desired to be found as a prime number by all numbers less than half.
**(x <= n/2)**

**The third method** is to try by dividing it by all numbers that are less than the root of the number (n).
**(x <= floor(sqrt(n)))**
You can learn the mathematical explanation of this method from the link below.
[title](https://stackoverflow.com/questions/5811151/why-do-we-check-up-to-the-square-root-of-a-number-to-determine-if-the-number-is)

You can see how long it took and how many comparisons the three algorithms made trying to find the same number of primes.

**1000 prime numbers**
| **Methods**   | **Elapsed Time** |    
|---------------|------------------|
| first method  | 0,0130 seconds   |
| second method | 0,0080 seconds   |
| third method  | 0,0010 seconds   |

| **Methods**   | **# of comparisons** |
|---------------|----------------------|
| first method  |        7424254       |
| second method |        3742342       |
| third method  |        172244        |

**10000 prime numbers**
| **Methods**   | **Elapsed Time** |    
|---------------|------------------|
| first method  | 1,3570 seconds   |
| second method | 0,7260 seconds   |
| third method  | 0,0140 seconds   |

| **Methods**   | **# of comparisons** |
|---------------|----------------------|
| first method  |        994024360     |
| second method |        497868950     |
| third method  |        5861184       |

**100000 prime numbers**
| **Methods**   | **Elapsed Time** |    
|---------------|------------------|
| first method  | 156,3550 seconds |
| second method | 86,1220 seconds  |
| third method  | 0,2880 seconds   |

| **Methods**   | **# of comparisons** |
|---------------|----------------------|
| first method  |        124569594068  |
| second method |        62308995348   |
| third method  |        195918028     |


Also you can try yourself. It will be enough to get the project locally and run it. After working it will ask you to enter how many prime numbers to find.
After the finding process is finished, it presents the results as a log. You can also export the results into result.txt under the /results directory.

**Note1:** If you try to find **1000000 or more** prime numbers, it will take a lot of time.
**Note2:** If you want to compare the time between algorithms, try to find **1000 or more** prime numbers.

**Warning:** It is recommended to boot the project with a known IDEs(IntelliJ, Eclipse), otherwise you will not be able to output to the result.txt file.
