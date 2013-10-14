Dependencies Kata
=================

Based on http://codekata.pragprog.com/2007/01/kata_eighteen_t.html. 

Highly coupled code is code where the dependencies between things are dense, lots of things depend on other things. This kind of program is hard to understand, tough to maintain, and tends to be fragile, breaking easily when things change.

There are many different kinds of coupling in code. One of the easiest to work with programatically is \emph{static coupling}, where we’re concerned with the relationships between chunks of source code. Simplisticly, we can say that class A is statically coupled to class B if the compiler needs the definition of B in order to compile

    In many languages, static dependencies can be determined by source

code analysis. Tools such as makedepend (for C programs) and JDepend (for Java) look for explicit dependencies in the source and list them out.

One of the insidious things about dependencies is that they are transitive—if A depends on B and B depends on C, then A also depends on C. So, let’s write some code that calculates the full set of dependencies for a group of items. The code takes as input a set of lines where the first token is the name of an item. The remaining tokens are the names of things that this first item depends on. Given the following input, we know that A directly depends on B and C, B depends on C and E, and so on.

  A   B   C
  B   C   E
  C   G
  D   A   F
  E   F
  F   H

The program should use this data to calculate the full set of dependencies. For example, looking at B, we see it directly depends on C and E. C in turn relies on G, E relies on F, and F relies on H. This means that B ultimately relies on C, E, F, G, and H. In fact, the full set of dependencies for the previous example is:

  A   B C E F G H
  B   C E F G H
  C   G
  D   A B C E F G H
  E   F H
  F   H

Using TDD, write a dependency calculator.

After you have a working dependency calculator, look at the build.gradle files
 for each of the Hadapt packages and run your dependency calculator on them.
Ignore all of the external dependencies and just focus on the Hadapt-specific
dependencies.
