# TestVagrant_RCB
Validation of team has only four foreign players and at least one wicket keeper


1. Navigate to pom.xml file location in the maven project (RCB_Team) through command prompt
2. Run the below command
3. mvn clean test -Dforeignplayers=4 -Dwicketkeepers=1
4. or
5. mvn clean test -Dforeignplayers=4 -Dwicketkeepers=0
6. or
7. mvn clean test -Dforeignplayers=5 -Dwicketkeepers=1
8. or
9. mvn clean test -Dforeignplayers=3 -Dwicketkeepers=1
