# Genetic algorithm keyboard layout optimization

## Inspiration
The idea behind this project was inspired by these two videos:
+ [Using AI to Create the Perfect Keyboard](https://www.youtube.com/watch?v=EOaPb9wrgDY&t=1s&ab_channel=adumb)
+ [Why the longest English word is PAPAL and SPA is the pointiest](https://www.youtube.com/watch?v=Mf2H9WZSIyw&ab_channel=Stand-upMaths)

When stumbling upon these videos, I just had to try creating something similar.

## Idea
### Keyboard 
The Keyboard class represents a solution, i.e. an abstract keyboard with a specific (fixed-format) layout. The fitness (or in this case the punishment) of every keyboard can be calculated, and is defined as such:

<p><i>
The punishment is defined as the inverse of the average distance needed to travel per-word basis. The distance needed to travel per-word is defined as the sum of the distances between the characters, for a given word, weighted by the number of letters. Greater the punishment, worse the solution.
</i></p>

The way the distance travelled is calculated can be visualized as the total movement of a finger typing, assuming that the person typing is only using a single finger.

### Keyboard Layout
A Keyboard Layout class represents a simplified keyboard layout which contains just 26 characters, uppercase version of the letters of the English Alphabet. The layout has been designed to follow the existing standards for [keyboard layouts](https://en.wikipedia.org/wiki/Keyboard_layout), including the default <code>19.05mm</code> distance between each key, in a single row.

### Genetic operators
#### Selection
+ Select best solution
  + <i>Selection operator implementation that selects <code>n</code> solutions with the highest fitness.</i>
+ [Fitness proportional selection](https://en.wikipedia.org/wiki/Fitness_proportionate_selection)
  + <i>Selection operator implementation that selects <code>n</code> solutions using the Roulette Wheel selection method.</i>

#### Crossover
+ Split and fill
  + <i>Crossover operator implementation that takes the left side of the string layout, of the first parent, and appends the missing characters from the string layout from the second parent, in the order they appeared.</i>

#### Mutation
+ Swap characters
  +  <i>Mutation operator implementation that swaps characters with a given probability.</i>

## Fun TODO ideas
+ Implement different ways to calculate the punishment by adding support for typing with multiple fingers, e.g. [touch typing](https://en.wikipedia.org/wiki/Touch_typing)
+ Design new genetic operators and compare the results
