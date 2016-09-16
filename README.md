Authors :
Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne



This project is a simulation of swimmers going to the swimming pool
and needing resources to perform some actions in a certain order.

====================================================================

STRUCTURE OF THE PROJECT SnakesAndLadders

The Class that contains the main method is Pool in the package 
actionsandpool.pool . 
The main class do the simulation. In the same packahge there is 
the class Swimmer to represent a swimmer who do Actions in a certain
order. An Action is represented by class Action and its inherited
classes. An action interact with ResourcefulUser and ResourcePool 
which provide the resources that the Swimmer needs.
The subpackage mock in the tests folder is only used for tests.

====================================================================


TEST INFO

All the tests we made works with a coverage of about 84%. All tests
succeeded.

====================================================================

OTHER

The commands :

	java -jar actionsandpool.jar

	OR

	make actionsandpool

execute the jar.

In a terminal, the command make all compile the sources of 
the project.

====================================================================
